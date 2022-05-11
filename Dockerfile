FROM openjdk:8-jre-alpine
ADD target/WomenEmpowerment-0.0.1-SNAPSHOT.jar WomenEmpowerment-0.0.1-SNAPSHOT.jar
EXPOSE 8234
#CMD ["openjdk"]
ENTRYPOINT [ "java","-jar","WomenEmpowerment-0.0.1-SNAPSHOT.jar"]