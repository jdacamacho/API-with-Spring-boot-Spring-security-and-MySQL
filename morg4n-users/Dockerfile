## Execute application
FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/morg4n-users-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} morgan-users.jar
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "morgan-users.jar"]