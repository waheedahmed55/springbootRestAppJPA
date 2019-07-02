FROM store/oracle/serverjre:8
VOLUME /tmp
COPY wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh
RUN mkdir /home/restapi
RUN mkdir /home/restapi/src
COPY src/ /home/restapi/src/
COPY pom.xml /home/restapi/
RUN ls /home/restapi/src
RUN ls /home/restapi/src
RUN mvn package -f /restapi/pom.xml
#COPY target/*.jar  App.jar
EXPOSE 8081
CMD ["cp target/*. App.jar","./wait-for-it.sh", "localhostmysql:3306","--","java", "-jar", "App.jar"]