FROM mcr.microsoft.com/playwright/java:v1.54.0

WORKDIR /app

COPY . .

RUN mvn clean compile

CMD ["mvn", "test"]