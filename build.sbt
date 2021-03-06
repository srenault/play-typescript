sbtPlugin := true

name := "play-typescript"

organization := "com.github.hexx"

version := "0.0.1"

scalaVersion := "2.9.1"

scalacOptions := Seq("-deprecation", "-unchecked")

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies <++= (scalaVersion, sbtVersion) { (scalaV, sbtV) => Seq(
  "play" % "sbt-plugin" % "2.0.4" extra("scalaVersion" -> scalaV, "sbtVersion" -> sbtV)
)}

publishMavenStyle := true

publishArtifact in Test := false

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) 
    Some("snapshots" at nexus + "content/repositories/snapshots") 
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>https://github.com/hexx/play-typescript</url>
  <licenses>
    <license>
      <name>MIT License</name>
      <url>http://www.opensource.org/licenses/mit-license.php</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:hexx/play-typescript.git</url>
    <connection>scm:git:git@github.com:hexx/play-typescript.git</connection>
  </scm>
  <developers>
    <developer>
      <id>hexx</id>
      <name>Seitaro Yuuki</name>
      <url>https://github.com/hexx</url>
    </developer>
  </developers>)
