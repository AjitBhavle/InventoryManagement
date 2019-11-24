FROM openjdk:8
ADD target/docker-inventorymanagement.jar docker-inventorymanagement.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "docker-inventorymanagement.jar"]