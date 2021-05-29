# TrafficSignalServer

## Description
- This Project is the server-side implementation of Traffic signal emualtor.
- It contains the implementation of a Server-Sent-Events-based API with Spring that allows a web application to handle a unidirectional event stream and receive updates whenever server emits data.
- The API sends the Traffic signal status periodically to the client which is implemented using Flux class provided by Reactor library.

## Build Steps
- `mvn clean install` to install dependencies and build the project.
- `mvn spring-boot:run` to run the project on localhost:10093.
