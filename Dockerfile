FROM maven:latest as build

WORKDIR /app

COPY . /app/

ENV MONGODB_URL=mongodb+srv://admin:admin123@questionapp.kzwjfry.mongodb.net/
ENV MONGODB_DATABASE=questionApp

RUN mvn clean package

FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

ENV MONGODB_URL=mongodb+srv://admin:admin123@questionapp.kzwjfry.mongodb.net/
ENV MONGODB_DATABASE=questionApp

COPY --from=build /app/target/*.jar app.jar
CMD ["java","-jar","/app.jar"]