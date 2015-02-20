import sbtrelease.ReleasePlugin

organization := "org.virtuslab"

name := "beholder"

scalaVersion := "2.11.5"

updateOptions := updateOptions.value.withCachedResolution(true)

libraryDependencies ++= Dependencies.libraries

resolvers ++= Resolvers.all

parallelExecution in Test := false

testOptions in Test ++= Seq(Tests.Argument("-oF"))

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-feature",
  "-Xlint",
  "-Xfatal-warnings"
)

com.typesafe.sbt.SbtScalariform.scalariformSettings

Settings.sonatype

Settings.scoverage

Settings.release
