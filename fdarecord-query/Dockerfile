FROM gradle:5.4.1-jre11-slim as builder
COPY --chown=gradle:gradle . /home/gradle/webapp
WORKDIR /home/gradle/webapp
RUN gradle clean :fdarecord-query:bootJar

FROM azul/zulu-openjdk-alpine:11.0.3
COPY --from=builder /home/gradle/webapp/fdarecord-query/build/libs/application.jar application.jar

ENTRYPOINT ["java", "-jar", "application.jar"]