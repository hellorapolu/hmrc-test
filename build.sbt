name := "hmrc-test"

version := "0.1"

scalaVersion := "2.12.3"

scalacOptions ++= Seq("-unchecked", "-deprecation")

resolvers ++= Seq("Local Maven Repository" at "file:///"+Path.userHome+"/.m2/repository",
  "Signpost releases" at "https://oss.sonatype.org/content/repositories/signpost-releases/")

mainClass in (Compile, packageBin) := Some("Checkout")

libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.specs2" % "specs2-core_2.12" % "4.0.0" % "test",
  "junit" % "junit" % "4.7" % "test")
