FROM openjdk:17-jdk-alpine

COPY target/PortfolioBackend-0.0.1-SNAPSHOT.jar /usr/app/
COPY src/main/resources/image/ppimage.png /app/image/ppimage.png
COPY src/main/resources/image/AbdulMajide.Resume.pdf /app/AbdulMajide.Resume.pdf

WORKDIR /usr/app

ENTRYPOINT ["java","-jar","PortfolioBackend-0.0.1-SNAPSHOT.jar"]
