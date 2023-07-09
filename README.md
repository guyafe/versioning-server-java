# Versioning Project Demo - Java Server

The versioning project is a demo to a process of correctly versioning a project, and based on the working branch automatically setting the dependencies.

This project is using Java 17 and Gradle 8.1.1.

This repository demonstrates the Java server of a weather service.<br>
At the moment we don't do any versioning for the code.

## Usage
### Clone
First clone the project from GitHub: https://github.com/guyafe/versioning-server-java.git
### Build
Build is using the command `gradle build`. It will create a jar file named `versioning-server.jar` in the `build/libs` directory.
### Run
Run the server using `gradle run`. It will run the server with the default parameters.

## Using The Server
The server is a REST API that exposes the following endpoints on port 61285:

`@GET /weather`<br>
Returns a health message

`@GET /weather/{city`}<br>
Returns the weather for the given city