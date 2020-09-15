FROM adoptopenjdk:11-jre-hotspot-bionic
COPY target/app.jar .
CMD ["java", "-jar", "dkb-service.jar"]