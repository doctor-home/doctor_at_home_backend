# Doctor@Home: Backend repository

## Overview

This component decouples the business logic and data model from the frontend by exposing REST endpoints to which the Frontend can send requests to

## Pre-requisites

* mongodb, maven and jdk 8. Tomcat server needed if running locally

## API Endpoint Docs

* Start page <http://localhost:8080/index>

* Go to <http://localhost:8080/docs> for api documentation and to test api endpoints

## Local Build

Navigate to doctor_at_home

* As spring-boot application
    ```bash
    profile=azure # options: azure, prod, local. Add "demo" to load demo data upon startup
    mvn clean package
    mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=${profile}"
    # open <http://localhost:8080/index>
    



* Local build and run using Docker
   * Docker-compose with embedded MongoDB
   ```bash
   docker-compose up --build
   open <http://0.0.0.0:8080/index>
    ```
    * Using "azure" profile (using CosmosDB as database backend on Azure)
    
    ```powershell
    # Windows Powershell (bash users, you get the idea)
    # set environment variables, as you'd configure on Azure Web App Container
    $env:PROFILE="azure" # add "demo" profile to load demo data on startup
    $env:WEBSITE_HOSTNAME="localhost"
    $env:PORT="7777"
    $env:WEBSITES_PORT="7777"
    $env:MONGODB_DATABASE="doctor-at-home-backend-db"
    $env:MONGODB_URI="mongodb:// [...]"

    # Build and tag container (locally)
    docker build -t doctorathome/backend:latest .

    # Run the container
    docker run -e PROFILE=$env:PROFILE -e PORT=$env:PORT -e WEBSITES_PORT=$env:WEBSITES_PORT -e WEBSITES_HOSTNAME=$env:WEBSITES_HOSTNAME -e MONGODB_DATABASE=$env:MONGODB_DATABASE -e MONGODB_URI=$env:MONGODB_URI -i -p $env:PORT:$env:PORT doctorathome/backend:latest

    # go to http://localhost:7777/index>
    ```



## Build and Deploy from Github to Azure Web App Containers

This uses Github actions to deploy on Azure Web App Containers.
See .github/workflows/azure.yml

## Testing

* Jwt is used for authenticating each request

* A POST request to the JWT Authentication endpoint must be sent to receive a bearer token to authenticate all requests to the API endpoints

* Using the Swagger UI, you can add the bearer token to all requests by clicking on the padlock icon at the top right corner and giving in the token, in form "Bearer replace_token_string_here"
