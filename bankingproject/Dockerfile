
FROM jelastic/maven:3.9.7-openjdk-21.0.2-almalinux-9 AS build

WORKDIR /app

COPY bankingproject-0.0.1-SNAPSHOT.jar /app/bankingproject.jar

CMD ["java", "-jar", "/app/bankingproject.jar"]