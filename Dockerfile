FROM ghcr.io/graalvm/graalvm-ce:latest
ADD target/districtpdsmanagement-app.jar districtpdsmanagement-app.jar
EXPOSE 8282
ENTRYPOINT ["java", "-jar", "districtpdsmanagement-app.jar"]