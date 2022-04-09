FROM adoptopenjdk:11-jre-hotspot
COPY "/build/libs/myservice-1.0.jar" "app.jar"
EXPOSE ["java", "-jar", "/app.jar"]