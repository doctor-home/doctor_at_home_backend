FROM openjdk:8
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar 
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=prod","-jar","/app.jar"]