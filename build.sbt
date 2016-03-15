lazy val root = (project in file(".")).
  settings(
    name := "Hello-Scala",
    version := "0.1.0",
    scalaVersion := "2.11.7",
    libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.6" % "test"
)
