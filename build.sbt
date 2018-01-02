import sbt._
import org.sstudio.bulldozer.build.Resolvers
import org.sstudio.bulldozer.build.Dependencies._

// Task
lazy val compileScalastyle = taskKey[Unit]("compileScalastyle")

// Settings
lazy val projectSettings = Seq(
  organization := "org.sstudio",
  version := "0.1.0",
  scalaVersion := "2.11.11",
  resolvers := Resolvers.list,
  compileScalastyle := scalastyle.in(Compile).toTask("").value,
  (compile in Compile) := ((compile in Compile) dependsOn compileScalastyle).value
)

lazy val scoverageSettings = Seq(
  coverageMinimum := 70,
  coverageFailOnMinimum := false,
  coverageHighlighting := true
)

lazy val bulldozerSettings = projectSettings ++ scoverageSettings

// Options
lazy val compilerOptions = Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-optimise",
  "-unchecked",
  "-language:implicitConversions"
)

// Merge Strategy
lazy val universalCustomize: Def.Setting[String => sbtassembly.MergeStrategy] =
  assemblyMergeStrategy in assembly := {
    case "META-INF/MANIFEST.MF" => MergeStrategy.discard
    case "application.conf" => MergeStrategy.concat
    case "META-INF/mailcap" => MergeStrategy.concat
    case "META-INF\\mailcap" => MergeStrategy.concat
    case PathList(ps@_*) if ps.last endsWith ".default" => MergeStrategy.first
    case PathList(ps@_*) if ps.last endsWith ".dat" => MergeStrategy.first
    case PathList(ps@_*) if ps.last endsWith ".dtd" => MergeStrategy.first
    case PathList(ps@_*) if ps.last endsWith ".xsd" => MergeStrategy.first
    case PathList(ps@_*) if ps.last endsWith ".class" => MergeStrategy.first
    case PathList(ps@_*) if ps.last endsWith ".xml" => MergeStrategy.first
    case PathList(ps@_*) if ps.last endsWith ".properties" => MergeStrategy.first
    case PathList(ps@_*) if ps.last endsWith ".txt" => MergeStrategy.concat
    case PathList(ps@_*) if ps.last endsWith ".html" => MergeStrategy.first
    case PathList(ps@_*) if ps.last endsWith ".java" => MergeStrategy.first
    case x =>
      val oldStrategy = (assemblyMergeStrategy in assembly).value
      oldStrategy(x)
  }

// Dependencies
lazy val bulldozerDep = Seq(
  typesafeConfig,
  jodaTime,
  akka,
  akkaHttp,
  scalaCompiler,
  json4s
)

// Projects
lazy val bulldozer = (project in file("bulldozer"))
  .settings(
    bulldozerSettings,
    name := "bulldozer",
    scalacOptions ++= compilerOptions,
    libraryDependencies ++= bulldozerDep
  )

lazy val root = (project in file("."))
  .settings(
    bulldozerSettings,
    name := "root",
    scalacOptions ++= compilerOptions
  ) aggregate bulldozer

// Commands
addCommandAlias("root", ";project root")
