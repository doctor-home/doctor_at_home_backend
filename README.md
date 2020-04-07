# Doctor@Home: Backend repository

## Overview

This component decouples the business logic and data model from the frontend by exposing REST endpoints to which the Frontend can send requests to

## Pre-requisites

* mongodb, maven and jdk 8. Tomcat server needed if running locally

## API Endpoint Docs

* Start page <http://0.0.0.0:8080/index>

* Go to <http://0.0.0.0:8080/docs> for api documentation and to test api endpoints

## Local Build

Navigate to doctor_at_home

* As spring-boot application

    ```bash
   mvn clean package spring-boot:run
   open <http://0.0.0.0:8080/index>
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
