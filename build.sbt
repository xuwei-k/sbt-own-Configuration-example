val common = Def.settings(
  scalaVersion := "2.13.10",
  libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.17.0" % Test
)

val a = project
  .settings(
    common
  )

val b = project
  .settings(
    common
  )
  .dependsOn(
    a % "compile->compile;test->test"
  )
