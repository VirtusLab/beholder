organization := "org.virtuslab"

name := "beholder"

version := "0.2.0-M1"

scalaVersion := "2.10.4"

resolvers += Resolver.typesafeRepo("releases")

resolvers += Resolver.sonatypeRepo("releases")

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "2.1.0-M1",
  "com.typesafe.play" %% "play-slick" % "0.6.0.1",
  "org.virtuslab" % "unicorn_2.10" % "0.6.0-M2",
  "org.scalatest" % "scalatest_2.10" % "2.0" % "test",
  "com.typesafe.play" %% "play-test" % "2.2.0" % "test",
  "com.h2database" % "h2" % "1.3.175" % "test"
)

parallelExecution in Test := false