FROM openjdk:17.0.2-jdk
LABEL authors="choi"

ARG JAR_PATH=build/libs/naming-0.0.1-SNAPSHOT.jar
COPY ${JAR_PATH} naming-server.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "naming-server.jar"]