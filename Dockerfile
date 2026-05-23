# Utilise une image Java légère pour exécuter l'application
FROM eclipse-temurin:17-jre-alpine

# Dossier de travail à l'intérieur du conteneur
WORKDIR /app

# Copie le fichier JAR généré par Maven (dans target/) vers le conteneur
COPY target/*.jar app.jar

# Expose le port 8080 (le port par défaut de Spring Boot)
EXPOSE 8080

# Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]