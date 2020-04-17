FROM maven:3.6.3-jdk-8-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ /app/src/
RUN mvn package

FROM openjdk:8-jre-alpine
VOLUME /var/lib/athome/dah-app
COPY --from=build /app/target/*.jar app.jar

# set profile to activate (will be overridden when starting e.g. on Azure)
ENV PROFILE=prod

EXPOSE 8080

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=${PROFILE}","-jar","/app.jar"]
