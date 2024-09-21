FROM openjdk:17.0.2-jdk
LABEL authors="choi"

ARG JAR_PATH=build/libs/currency-exchange-0.0.1-SNAPSHOT.jar
COPY ${JAR_PATH} currency-exchange.jar

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "currency-exchange.jar"]