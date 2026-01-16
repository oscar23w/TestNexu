# --- ETAPA 1: Construcción (Build) ---
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
# Compila saltando los tests para ahorrar tiempo en el despliegue
RUN mvn clean package -DskipTests

# --- ETAPA 2: Ejecución (Run) ---
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Copia solo el JAR construido en la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Configuración vital para la capa gratuita (Limita la RAM)
ENV JAVA_OPTS="-Xmx300m -Xms300m"

EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
