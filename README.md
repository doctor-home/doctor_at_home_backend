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
    profile=azure # options: azure, prod, local
    mvn clean package
    mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=${profile}"
    open <http://localhost:8080/index>
    
* As spring-boot application, with "azure" profile (using Azure CosmosDB as database backend)
    Windows Powershell (bash users, you get the idea)
    ```powershell
    # set environment variables, as you'd configure on Azure Web App Container
    $env:PROFILE="azure"
    $env:WEBSITES_HOSTNAME="0.0.0.0"
    $env:WEBSITES_PORT="7777"
    $env:MONGODB_DATABASE="doctor-at-home-backend-db"
    $env:MONGODB_URI="mongodb:// [...]"

    mvn clean package spring-boot:run '-Dspring-boot.run.profile=${env:PROFILE}'

    # go to http://localhost:7777/index>
    ```


* Local build and run using Docker

   ```bash
   docker-compose up --build
   open <http://0.0.0.0:8080/index>
    ```



## Build and Deploy from Github to Azure Web App Containers

This uses Github actions to deploy on Azure Web App Containers.
See .github/workflows/azure.yml

## Testing

* Jwt is used for authenticating each request

* A POST request to the JWT Authentication endpoint must be sent to receive a bearer token to authenticate all requests to the API endpoints

* Using the Swagger UI, you can add the bearer token to all requests by clicking on the padlock icon at the top right corner and giving in the token, in form "Bearer replace_token_string_here"
