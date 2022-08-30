FROM amazoncorretto:11-alpine
MAINTAINER reekmike.com
COPY target/the-globe-1.0-SNAPSHOT.jar the-globe-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","the-globe-1.0-SNAPSHOT.jar"]





