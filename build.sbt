val scalaVer       = "3.2.0"
val zioVersion     = "2.0.0"
val zioHttpVersion = "2.0.0-RC10"

lazy val compileDependencies = Seq(
  "dev.zio"     %% "zio"             % zioVersion,
  "dev.zio"     %% "zio-test"        % zioVersion      % Test,
  "dev.zio"     %% "zio-test-sbt"    % zioVersion      % Test,
  "com.lihaoyi" %% "requests"        % "0.7.0",
  "io.d11"      %% "zhttp"           % zioHttpVersion
)

lazy val settings = Seq(
  name                 := "scala-zio",
  version              := "1.0.0",
  scalaVersion         := scalaVer,
  scalacOptions       ++= Seq(
    "-language:postfixOps",
    "-Ykind-projector",
    "-Yexplicit-nulls",
    "-source",
    "future",
    "-Xfatal-warnings"
  ),
  libraryDependencies ++= compileDependencies,
  testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework"))
)

lazy val root = (project in file("."))
  .settings(settings)
