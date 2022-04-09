FROM adoptopenjdk:11-jre-hotspot
COPY "/build/libs/myservice-1.0.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]