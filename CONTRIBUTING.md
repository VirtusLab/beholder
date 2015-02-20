Contributing
============

All kind of tips & tricks for people interested in contributing to beholder.

CI job
------

A Travis job is set up for `beholder` [here](https://travis-ci.org/VirtusLab/beholder).
Each branch and PR is cross-tested against `Scala 2.11.5`, `OpenJDK 7` and `OpenJDK 8`.

Code coverage
-------------

Beholder uses [scoverage](https://github.com/scoverage/scalac-scoverage-plugin) plugin for code coverage.
To run it, use:

```
sbt clean coverage test
```

(`clean` *is important*)

Results are placed in `beholder\target\scala-2.11\scoverage-report`.

Minimum coverage is set to *48%* (which is current coverage) so all code you add to project *have to be 100% test-covered*, otherwise Travis build will fail.

Releasing
---------

Before release you must have access to Sonatype and have PGP keys for signing artifacts.

To automate release process, `beholder` uses [sbt-release](https://github.com/sbt/sbt-release) plugin. To release a new version, just use `sbt release` and follow instructions. For more information, see plugin docs.

**Warn** - You should *not* update version file (`version.sbt`) yourself, `sbt-release` does it for you.
