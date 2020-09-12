FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/test-java-task-1.0-SNAPSHOT.jar /app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar