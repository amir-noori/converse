ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.10"

val AkkaVersion = "2.7.0"


lazy val root = (project in file("."))
  .settings(
    name := "converse"
  )


libraryDependencies ++= Seq(

  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test,

  "com.lightbend.akka" %% "akka-stream-alpakka-slick" % "5.0.0",
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,


  // slick
  "com.typesafe.slick" %% "slick" % "3.4.1",
  "org.postgresql" % "postgresql" % "42.5.0",


  // Start with this one
  "org.tpolecat" %% "doobie-core" % "1.0.0-RC1",

  // And add any of these as needed
  "org.tpolecat" %% "doobie-h2" % "1.0.0-RC1", // H2 driver 1.4.200 + type mappings.
  "org.tpolecat" %% "doobie-hikari" % "1.0.0-RC1", // HikariCP transactor.
  "org.tpolecat" %% "doobie-postgres" % "1.0.0-RC1", // Postgres driver 42.3.1 + type mappings.
  "org.tpolecat" %% "doobie-specs2" % "1.0.0-RC1" % "test", // Specs2 support for typechecking statements.
  "org.tpolecat" %% "doobie-scalatest" % "1.0.0-RC1" % "test" // ScalaTest support for typechecking statements.

)