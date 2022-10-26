val scalaVer       = "3.2.0"
val zioVersion     = "2.0.2"
val zioHttpVersion = "2.0.0-RC10"
val zioConfig      = "3.0.1"
val zioLogging     = "2.0.0"
val zioJson        = "0.3.0-RC10"

lazy val compileDependencies = Seq(
  "dev.zio" %% "zio"                 % zioVersion,
  "dev.zio" %% "zio-config"          % zioConfig,
  "dev.zio" %% "zio-config-typesafe" % zioConfig,
  "dev.zio" %% "zio-logging"         % zioLogging,
  "dev.zio" %% "zio-streams"         % zioVersion,
  "dev.zio" %% "zio-json"            % zioJson,
//  "dev.zio" %% "zio-test"            % zioVersion      % Test,
//  "dev.zio" %% "zio-test-sbt"        % zioVersion      % Test,
  "io.d11"  %% "zhttp"               % zioHttpVersion
) map (_     % Compile)

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
  libraryDependencies ++= compileDependencies
)

lazy val root = (project in file("."))
  .settings(settings)
