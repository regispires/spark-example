name := "spark-example"

version := "0.0.1"

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

EclipseKeys.withSource := true

// additional libraries
libraryDependencies ++= Seq(
	"org.apache.spark"  %% "spark-core"              % "1.2.0"  % "provided",
	"org.apache.spark"  %% "spark-mllib"             % "1.2.0"  % "provided",
	"com.fasterxml.jackson.core" % "jackson-core" % "2.5.2" % "provided",
	"com.fasterxml.jackson.module" % "jackson-module-scala_2.10" % "2.5.1" % "provided"
	)
