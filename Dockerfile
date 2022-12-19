FROM amazoncorretto:17
MAINTAINER alexeymoskvinov
COPY target/kontora-server-0.0.1-SNAPSHOT.jar kontora-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/kontora-server-0.0.1-SNAPSHOT.jar"]
