organization := "org.virtuslab"

name := "beholder"

version := "0.2.0-SNAPSHOT"

scalaVersion := "2.10.4"

resolvers += Resolver.typesafeRepo("releases")

resolvers += Resolver.sonatypeRepo("releases")

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "com.typesafe.play" %% "play-slick" % "0.8.0-RC3",
  "org.virtuslab" %% "unicorn" % "0.6.0-SNAPSHOT",
  "org.scalatest" %% "scalatest" % "2.0" % "test",
  "com.typesafe.play" %% "play-test" % "2.3.2" % "test",
  "com.h2database" % "h2" % "1.3.175" % "test"
)

parallelExecution in Test := false

incOptions := incOptions.value.withNameHashing(true)

testOptions in Test ++= Seq(Tests.Argument("-oF"))

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-feature",
  "-Xlint",
  "-Ywarn-all"
)

com.typesafe.sbt.SbtScalariform.scalariformSettings