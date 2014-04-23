organization := "org.virtuslab"

name := "beholder"

version := "0.2.0"

scalaVersion := "2.10.4"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

resolvers += Resolver.typesafeRepo("releases")

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "2.1.0-M1",
  "com.typesafe.play" %% "play-slick" % "0.6.0.1",
  "org.virtuslab" % "unicorn_2.10" % "0.6.0-M1",
  "org.scalatest" % "scalatest_2.10" % "2.0" % "test",
  "com.typesafe.play" %% "play-test" % "2.2.0" % "test",
  "com.h2database" % "h2" % "1.3.175" % "test"
)

parallelExecution in Test := false