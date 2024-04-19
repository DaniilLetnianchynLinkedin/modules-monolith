FROM gradle:8.7-jdk as build
WORKDIR /workspace/app

COPY build.gradle.kts gradlew settings.gradle.kts ./
COPY src src
RUN gradle clean build -x test


FROM eclipse-temurin:21-jdk
VOLUME /tmp
ARG JAR_FILE=/workspace/app/build/libs/*.jar
COPY --from=build ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]