FROM openjdk:17
EXPOSE 8081
COPY target/account-operations-jar.jar account-operations-jar.jar
ENTRYPOINT ["java", "-jar", "/account-operations-jar.jar"]