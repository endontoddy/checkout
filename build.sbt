lazy val phoneCompany = (project in file(".")).settings(
  Seq(
    name := "checkout",
    version := "1.0",
    scalaVersion := "2.12.6"
  )
)

val specs2Ver = "4.2.0"

libraryDependencies ++= Seq(
  "org.specs2"        %% "specs2-core" % specs2Ver % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")

