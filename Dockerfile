# Используем базовый образ Temurin 17 с Alpine Linux
FROM eclipse-temurin:17-jre-alpine

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /rivstas/

# Копируем собранный JAR-файл внутрь контейнера
COPY ./target/JAN-Community-0.0.1-SNAPSHOT.jar ./community-service.jar

# Устанавливаем переменные окружения
ENV JWT_SECRET='hqUerWWqiExZNqIANXb4Xe8upVEaLtBvOJZkza1+desHl5kyrHSFCnDgI0OGCsT1kGJhWxCfxKvWmj3EAH0wTA=='
ENV KAFKA_CONFIG="org.apache.kafka.common.security.scram.ScramLoginModule required username='ssppshpm' password='uipBeio0BdwVedfCCqy6vhtBDcbeuUpR'"
ENV KAFKA_KEY='ssppshpm'
ENV MOGODB_URI='mongodb+srv://RivS:TelranJava47@cluster0.075d4oh.mongodb.net/telran?retryWrites=true&w=majority'

# Запускаем Java-приложение при старте контейнера
CMD ["java", "-jar", "/rivstas/community-service.jar", "--server.port=8084", "--server.address=0.0.0.0"]