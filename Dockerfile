FROM maven:3.9.9-eclipse-temurin-17

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

CMD ["java", "-jar", "target/Telegram_bot_parser_marketplace-1.0-SNAPSHOT.jar"]