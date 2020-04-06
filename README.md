# Doctor@Home: Backend repository

*Doctor@Home supports clinicians to closely monitor their Covid-19 patients that are confined at home.
It reduces workload from Clinicians and supports the medical triage. Helps optimize scarce clinical resources while reducing infection exposure for patients and clinicians. It improves patients quality of life by being able to stay home with their family as long as medically justifiable*

## Dependencies

* mongodb, maven and jdk 8. Tomcat server needed if running locally

## API Endpoint Docs

* Start page [http://<container_ip>:8080/index]()

* Go to [http://<container_ip>:8080/docs]() for api documentation and to test api endpoints

## To Run

* Navigate to doctor_at_home

* Run mvn clean package to build jar files if doesn't exist already in directory target/

* Run "docker-compose up" to build images and start container

* Run "docker-compose up -d" to build docker containers and run in detached mode

* Go to <http://localhost:8080/pathhere> to access endpoints

* Run "docker-compose stop" to stop containers

* *Note: Remember to change url addresses used in application.properties if server address changes*

* *if localhost doesn’t work, then you can check ip address of containers by running "docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' $(docker ps -q)"*

* *You can open [http:// <container_ip>:8080 ]() in browser*
