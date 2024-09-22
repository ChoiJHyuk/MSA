FROM openjdk:17.0.2-jdk
LABEL authors="choi"

ARG JAR_PATH=build/libs/api-gateway-0.0.1-SNAPSHOT.jar
COPY ${JAR_PATH} api-gateway.jar

EXPOSE 8765

ENTRYPOINT ["java", "-jar", "api-gateway.jar"]