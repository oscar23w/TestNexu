# --- ETAPA 1: Construcción (Build) con Java 21 ---
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# --- ETAPA 2: Ejecución (Run) con Java 21 ---
# Cambiamos la imagen de ejecución también a Java 21
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
# Copia el JAR generado en la etapa 1
COPY --from=build /app/target/*.jar app.jar

# Configuración de memoria para el plan gratuito
ENV JAVA_OPTS="-Xmx300m -Xms300m"

EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
