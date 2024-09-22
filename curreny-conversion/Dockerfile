FROM openjdk:17.0.2-jdk
LABEL authors="choi"

ARG JAR_PATH=build/libs/curreny-conversion-0.0.1-SNAPSHOT.jar
COPY ${JAR_PATH} currency-conversion.jar

EXPOSE 8100

ENTRYPOINT ["java", "-jar", "currency-conversion.jar"]