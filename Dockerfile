FROM openjdk:8
ADD target/fileuploader-1.0-spring-boot.jar fileuploader-1.0.jar
ENTRYPOINT ["java","-jar","fileuploader-1.0.jar"]