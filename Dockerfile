FROM maven:3.6.1-jdk-11-slim as build
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /usr/src/app/target/*.jar /usr/app/App.jar  
EXPOSE 8080  
ENTRYPOINT ["java","-jar","/usr/app/App.jar"]  