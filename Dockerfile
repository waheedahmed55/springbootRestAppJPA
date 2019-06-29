FROM store/oracle/serverjre:8
VOLUME /tmp
COPY wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh
COPY target/*.jar  App.jar
EXPOSE 8081
CMD ["./wait-for-it.sh", "localhostmysql:3306","--","java", "-jar", "App.jar"]