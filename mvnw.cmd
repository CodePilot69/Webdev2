@REM ----------------------------------------------------------------------------
@REM Licensed to the Apache Software Foundation (ASF) under one
@REM or more contributor license agreements.
@REM Maven Wrapper startup batch script
@REM ----------------------------------------------------------------------------

@IF "%__MVNW_ARG0_NAME__%"=="" (SET __MVNW_ARG0_NAME__=%~nx0)
@SET DP0=%~dp0

@SET MAVEN_PROJECTBASEDIR=%DP0%
@SET MVNW_REPOURL=https://repo.maven.apache.org/maven2

@SET WRAPPER_JAR="%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar"
@SET WRAPPER_LAUNCHER=org.apache.maven.wrapper.MavenWrapperMain

@SET DOWNLOAD_URL="https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.3.2/maven-wrapper-3.3.2.jar"

@FOR /F "usebackq tokens=1,2 delims==" %%A IN ("%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.properties") DO (
    @IF "%%A"=="distributionUrl" SET DISTRIBUTION_URL=%%B
    @IF "%%A"=="wrapperUrl" SET DOWNLOAD_URL=%%B
)

@SET JAVA_HOME_SET=0
@IF NOT "%JAVA_HOME%"=="" (SET JAVA_HOME_SET=1)

@IF "%JAVA_HOME_SET%"=="0" (
    @echo JAVA_HOME is not set. Please set JAVA_HOME to your JDK 17 installation.
    @exit /b 1
)

@SET MVN_CMD="%JAVA_HOME%\bin\java" -classpath %WRAPPER_JAR% "-Dmaven.multiModuleProjectDirectory=%MAVEN_PROJECTBASEDIR%" %WRAPPER_LAUNCHER% %*

@IF NOT EXIST %WRAPPER_JAR% (
    @echo Downloading Maven Wrapper...
    @"%JAVA_HOME%\bin\java" -classpath "" org.apache.maven.wrapper.MavenWrapperDownloader %DOWNLOAD_URL% %WRAPPER_JAR%
)

@%MVN_CMD%
