Beholder: Play-Slick library for data presentation
==================================================
[![Build Status](https://travis-ci.org/VirtusLab/beholder.svg?branch=master)](https://travis-ci.org/VirtusLab/beholder)

Standard part of many application are list of data that is not a effect of simple query from one table but junction and aggregation of data from many tables. Beholder provides support for such elemets.

Features:
* views as table
* declaring filters for data
* support for sorting, filtering on multiple (custom) datatypes

Contributors
------------
Authors:
* [Krzysztof Romanowski](https://github.com/romanowski)
* [Jerzy Müller](https://github.com/Kwestor)
* [Mikołaj Jakubowski](https://github.com/mkljakubowski)
* [Krzysztof Borowski](https://github.com/liosedhel)

Feel free to use it, test it and to contribute!

Getting beholder
----------------

For latest version (Scala 2.13.0 compatible) use:

```scala
// https://mvnrepository.com/artifact/org.virtuslab/beholder
libraryDependencies += "org.virtuslab" %% "beholder" % "1.4.2"
```

Or see Maven repository for [2.10](http://maven-repository.com/artifact/org.virtuslab/beholder_2.10), [2.11](http://maven-repository.com/artifact/org.virtuslab/beholder_2.11), [2.12](http://maven-repository.com/artifact/org.virtuslab/beholder_2.12) and [2.13](http://maven-repository.com/artifact/org.virtuslab/beholder_2.13).

Or see our [mvnrepository](https://mvnrepository.com/artifact/org.virtuslab/beholder) page.

Examples
========

Lets assume that we created simple entries

```scala
case class MachineId(id: Long) extends AnyVal with BaseId
```
```scala
case class UserId(id: Long) extends AnyVal with BaseId
```

and junction table joined them by ids.

Defining view
-------------

Usually for data in view does not came form single table so we have to create view that is materialisation of some query.
Beholder provides such utility. We can create Slick's table that operate on view (it is read only).

```scala
case class UserMachineView(email: String, system: String, cores: Int)

val usersMachinesQuery = for {
  user <- Users
  userMachine <- UserMachines if user.id === userMachine.userId
  machine <- Machines if machine.id === userMachine.machineId
} yield (user, machine)


val UsersMachineView = FilterableViews.createView(name = "USERS_MACHINE_VIEW",
  apply = UserMachineView.apply _,
  unapply = UserMachineView.unapply _,
  baseQuery = usersMachinesQuery) {
  case (user, machine) =>
    //naming the fields
    ("email" -> user.email,
      "system" -> machine.system,
      "cores" -> machine.cores)
}

UsersMachineView.viewDDL.create
```

Defining filter
---------------
We create a filter by specify table query (view or normal table) and mapping for field

```scala
val UsersMachineFilter = new FiltersGenerator[UserMachineView].create(view,
  inText,
  inText,
  inIntField
)
```

Do the filtering from request
-----------------------------

```scala
UsersMachineFilter.filterForm.bindFromRequest().fold(
  errors => handleError(),
  filterData => showResult(UsersMachineFilter.filter(filterData))
)
```
