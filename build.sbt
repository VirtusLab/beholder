organization := "org.virtuslab"

name := "beholder"

version := "0.2.7-SNAPSHOT"

scalaVersion := "2.11.6"

resolvers += Resolver.typesafeRepo("releases")

resolvers += Resolver.sonatypeRepo("releases")

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "com.typesafe.play" %% "play-slick" % "0.8.1",
  "org.virtuslab" %% "unicorn" % "0.6.3",
  "org.scalatest" %% "scalatest" % "2.2.3" % "test",
  "com.typesafe.play" %% "play-test" % "2.3.9" % "test",
  "com.h2database" % "h2" % "1.4.184" % "test"
)

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

ScoverageSbtPlugin.ScoverageKeys.coverageMinimum := 48

ScoverageSbtPlugin.ScoverageKeys.coverageFailOnMinimum := true

ScoverageSbtPlugin.ScoverageKeys.coverageExcludedPackages := Seq(
  "org.virtuslab.beholder.utils.generators.*",
  // only BaseView5 is tested, all are generated, so there is no need to check them all
  "org.virtuslab.beholder.views.FilterableViews.*",
  "org.virtuslab.beholder.views.FilterableViewsGenerateCode.BaseView[^5].*"
).mkString(";")
