ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.8"

val akkaVersion="2.5.20"
val akkaHttpVersion="10.1.7"
val scalaTestVersion="3.0.5"

libraryDependencies ++=Seq(
  //akka streams
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  //akka http
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion,
  //testing
//  "com.typesafe.akka" %% "akka-testkit" % akkaHttpVersion,//this caused build error
  "org.scalatest" %% "scalatest" % scalaTestVersion
)

lazy val root = (project in file("."))
  .settings(
    name := "Akka HTTP With Scala RTJ"
  )
