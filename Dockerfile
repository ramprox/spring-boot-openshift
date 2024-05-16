# Build the application first using Maven
FROM maven:3.8.3-openjdk-17 as build
WORKDIR /app
COPY . .
RUN mvn install

# Inject the JAR file into a new container to keep the file small
FROM bellsoft/liberica-openjdk-alpine-musl:17
WORKDIR /app
COPY --from=build /app/target/spring-boot-openshift-*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar app.jar"]