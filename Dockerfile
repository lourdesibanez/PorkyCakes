# Imagen de demo: la app Java y una base MariaDB en el mismo contenedor.
# La base se crea desde porkydb.sql en cada arranque, así que la demo siempre empieza limpia.

FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -q dependency:go-offline
COPY src ./src
RUN mvn -q package -DskipTests

FROM eclipse-temurin:21-jre-noble
RUN apt-get update \
 && apt-get install -y --no-install-recommends mariadb-server \
 && rm -rf /var/lib/apt/lists/*
WORKDIR /app
COPY --from=build /app/target/porkycakes.jar app.jar
COPY porkydb.sql docker/entrypoint.sh ./
RUN sed -i 's/\r$//' entrypoint.sh && chmod +x entrypoint.sh
ENV DB_URL="jdbc:mysql://127.0.0.1:3306/porkydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8" \
    DB_USER=porky \
    DB_PASS=porky \
    PORT=4567
EXPOSE 4567
CMD ["./entrypoint.sh"]
