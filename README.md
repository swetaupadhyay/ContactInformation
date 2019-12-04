# Contact-information

- Contact information microservice is responsible for create, delete, update contact. It would provide service to fetch all the contacts. And also change status from Active to Deactive and vice versa.

## Requirements

- JDK 1.8
- maven 3+

## Compiling the service

1. `mvn clean install`

## Running microservice locally

cd contact-information
java -jar target\contact-information-0.0.1-SNAPSHOT.jar

## To use H2 DB (in-memory) provided by Spring boot. then in application.properties file, uncomment the below lines. and in pom.xml, please uncomment dependancy for com.h2database

- spring.datasource.url = jdbc:h2:file:C:/data/sample
- spring.datasource.name=sample
- spring.datasource.driverClassName=org.h2.Driver
- spring.datasource.initialize=false
