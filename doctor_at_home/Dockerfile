FROM openjdk:8-jdk-alpine
VOLUME /var/lib/athome/dah-app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar 
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=prod","-jar","/app.jar"]