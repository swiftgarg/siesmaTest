######### IMAGE BUILD ############
FROM maven:3.8.5-amazoncorretto-11 AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

######### PROD IMAGE ARTIFACT COPY #############

FROM amazoncorretto:11

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/*.jar /app/siesma-test.jar

ENTRYPOINT ["java", "-jar", "siesma-test.jar"]