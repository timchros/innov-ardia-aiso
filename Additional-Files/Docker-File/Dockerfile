FROM tomcat:8.0-alpine
LABEL maintainer="chondrog@mail.ntua.gr"

ADD AISO.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]