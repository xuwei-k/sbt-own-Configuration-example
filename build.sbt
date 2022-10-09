val TestShared = Configuration.of("TestShared", "test-shared") extend Compile

val common = Def.settings(
  scalaVersion := "2.13.10",
  libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.17.0" % "test,test-shared",
  Test / internalDependencyClasspath ++= (TestShared / fullClasspath).value,
  TestShared / internalDependencyClasspath ++= (Compile / fullClasspath).value,
  inConfig(TestShared)(Defaults.compileSettings)
)

val a = project
  .configs(TestShared)
  .settings(
    common
  )

val b = project
  .configs(TestShared)
  .settings(
    common
  )
  .dependsOn(
    a % "compile->compile;test-shared->test-shared"
  )
