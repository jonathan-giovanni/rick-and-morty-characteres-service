FROM gradle:jdk17 as builder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle assemble

FROM openjdk:17
RUN mkdir /app
COPY --from=builder /home/gradle/src/build/libs/rick-and-morty-characteres-service-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Duser.timezone=Europe/Madrid -Djava.security.egd=file:/dev/./urandom -jar /app/app.jar" ]
