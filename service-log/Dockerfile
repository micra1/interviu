FROM openjdk:21-jdk-slim
LABEL "org.opencontainers.image.authors"="mihai.craciun"

# Add the application's jar to the image
COPY target/service-log-0.0.1-SNAPSHOT.jar service-log-0.0.1-SNAPSHOT.jar

# execute the application
ENTRYPOINT ["java", "-jar", "service-log-0.0.1-SNAPSHOT.jar"]