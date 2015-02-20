import com.typesafe.sbt.pgp.PgpKeys
import sbt._
import sbt.Keys._
import sbt.Resolver
import sbtrelease.ReleasePlugin
import sbtrelease.ReleasePlugin.ReleaseKeys
import scoverage.ScoverageSbtPlugin
import xerial.sbt.Sonatype

object Settings {

  val scoverage = Seq(
    ScoverageSbtPlugin.ScoverageKeys.coverageMinimum := 48,

    ScoverageSbtPlugin.ScoverageKeys.coverageFailOnMinimum := true,

    ScoverageSbtPlugin.ScoverageKeys.coverageExcludedPackages := Seq(
      "org.virtuslab.beholder.utils.generators.*",
      // only BaseView5 is tested, all are generated, so there is no need to check them all
      "org.virtuslab.beholder.views.FilterableViews.*",
      "org.virtuslab.beholder.views.FilterableViewsGenerateCode.BaseView[^5].*"
    ).mkString(";")
  )

  val sonatype = Seq(
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
  ) ++ Sonatype.sonatypeSettings

  val release = Seq(
    ReleaseKeys.publishArtifactsAction := PgpKeys.publishSigned.value
  ) ++ ReleasePlugin.releaseSettings

}

object Resolvers {
  val all: Seq[MavenRepository] = Seq(
    Resolver.typesafeRepo("releases"),
    Resolver.sonatypeRepo("releases"),
    Resolver.sonatypeRepo("snapshots")
  )
}

object Dependencies {

  val libraries: Seq[ModuleID] = Seq(
    "com.typesafe.slick" %% "slick" % "2.1.0",
    "com.typesafe.play" %% "play-slick" % "0.8.1",
    "org.virtuslab" %% "unicorn" % "0.6.2",
    "com.typesafe.play" %% "play-test" % "2.3.8" % "test",
    "org.scalatest" %% "scalatest" % "2.2.3" % "test",
    "com.h2database" % "h2" % "1.4.184" % "test"
  )
}