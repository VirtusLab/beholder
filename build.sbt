
organization := "org.virtuslab"

name := "beholder"

inThisBuild(List(
  organization := "org.virtuslab",
  homepage := Some(url("https://github.com/VirtusLab/beholder")),
  licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
  developers := List(
    Developer(
      "jsroka",
      "jsroka",
      "jsroka@virtuslab.com",
      url("https://virtuslab.com/")
    )
  )
))

val scala_2_12 = "2.12.18"
val scala_2_13 = "2.13.11"

scalaVersion := scala_2_13

crossScalaVersions := List(scala_2_12, scala_2_13)

resolvers += Resolver.typesafeRepo("releases")

resolvers += Resolver.sonatypeRepo("releases")

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  "org.virtuslab" %% "unicorn" % "1.4.1",
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test,
  "com.typesafe.play" %% "play-test" % "2.8.8" % "test",
  "com.typesafe.play" %% "play-json-joda" % "2.9.2",
  "com.h2database" % "h2" % "1.4.200" % "test",
  "com.chuusai"        %% "shapeless" % "2.3.3",
  "io.underscore"      %% "slickless" % "0.3.6",
  "com.softwaremill.sttp.tapir" %% "tapir-core" % "1.2.7"
)

Test / testOptions ++= Seq(Tests.Argument("-oF"))
Test / fork := true

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-feature",
  "-Xlint"
//  "-Xfatal-warnings"
)

// Scoverage setup

scoverage.ScoverageKeys.coverageMinimum := 48

scoverage.ScoverageKeys.coverageFailOnMinimum := true

scoverage.ScoverageKeys.coverageExcludedPackages := Seq(
  "org.virtuslab.beholder.utils.generators.*",
  // only BaseView5 is tested, all are generated, so there is no need to check them all
  "org.virtuslab.beholder.views.FilterableViews.*",
  "org.virtuslab.beholder.views.FilterableViewsGenerateCode.BaseView[^6].*",
  "org.virtuslab.beholder.filters.FilterFactoryMethods.*"
).mkString(";")
