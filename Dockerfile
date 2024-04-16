FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/rsa-0.0.1-SNAPSHOT.jar rsa.jar
ENTRYPOINT ["java","-jar","/rsa.jar"]