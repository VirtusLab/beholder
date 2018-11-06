
organization := "org.virtuslab"

name := "beholder"

version := "1.4.0-SNAPSHOT"

val scala_2_11 = "2.11.12"
val scala_2_12 = "2.12.7"

scalaVersion := scala_2_11

crossScalaVersions := List(scala_2_11, scala_2_12)

resolvers += Resolver.typesafeRepo("releases")

resolvers += Resolver.sonatypeRepo("releases")

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  "org.virtuslab" %% "unicorn" % "1.3.0",
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.0.0" % Test,
  "com.typesafe.play" %% "play-test" % "2.6.20" % "test",
  "com.typesafe.play" %% "play-json-joda" % "2.6.10",
  "com.h2database" % "h2" % "1.4.187" % "test"
)

parallelExecution in Test := false

testOptions in Test ++= Seq(Tests.Argument("-oF"))

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-feature",
  "-Xlint"
//  "-Xfatal-warnings"
)

com.typesafe.sbt.SbtScalariform.scalariformSettings

pomExtra := <url>https://github.com/VirtusLab/beholder</url>
  <licenses>
    <license>
      <name>Apache-style</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>https://github.com/VirtusLab/beholder.git</url>
    <connection>scm:git:git@github.com:VirtusLab/beholder.git</connection>
  </scm>
  <developers>
    <developer>
      <id>VirtusLab</id>
      <name>VirtusLab</name>
      <url>http://www.virtuslab.com/</url>
    </developer>
    <developer>
      <id>JerzyMuller</id>
      <name>Jerzy Müller</name>
      <url>https://github.com/Kwestor</url>
    </developer>
    <developer>
      <id>KrzysztofRomanowski</id>
      <name>Krzysztof Romanowski</name>
      <url>https://github.com/romanowski</url>
    </developer>
  </developers>

//xerial.sbt.Sonatype.sonatypeSettings

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
