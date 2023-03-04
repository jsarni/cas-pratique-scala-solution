import sbt.project
scalaVersion := "2.13.10"

name := "cas-pratique-scala-solution"

version := "1.0.0"

organization := "io.github.jsarni"
homepage := Some(url("https://github.com/jsarni/cas-pratique-scala-solution"))

// Dependencies
val scalaTest = "org.scalatest" %% "scalatest" % "3.2.7" % Test


lazy val tp1_solution = (project in file("."))
  .settings(
    name := "tp1-scala-solution",
    libraryDependencies += scalaTest
  )