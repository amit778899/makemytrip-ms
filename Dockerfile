FROM tomcat:9.0.52-jre11-openjdk-slim
COPY C:\Myproject\makemytrip-ms\target\makemytrip-ms*.jar /usr/local/tomcat/webapps
EXPOSE 8080
USER makemytrip-ms
WORKDIR /usr/local/tomcat/webapps
CMD ["catalina.sh", "run"]