FROM openjdk:17
EXPOSE 9006
LABEL maintainer="RupSTLer"          
ADD target/message-microservice.jar message-microservice.jar
ENTRYPOINT ["java", "-jar", "message-microservice.jar"]