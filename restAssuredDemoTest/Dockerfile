FROM maven
RUN mkdir /home/restassured
RUN mkdir /home/restassured/src
COPY src/ /home/restassured/src/
COPY pom.xml /home/restassured/
RUN ls /home/restassured/src
RUN ls /home/restassured/src/
ENTRYPOINT ["mvn","-f","/home/restassured/pom.xml","clean","test","-l /home/restassured/output.log"]
