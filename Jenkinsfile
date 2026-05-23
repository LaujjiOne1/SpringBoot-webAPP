pipeline {
    agent any

    tools {
        maven 'Maven3' 
        jdk 'Java17'
    }

    stages {
        stage('1. Code Checkout') {
            steps {
                echo '=== Récupération du code depuis GitHub ==='
                checkout scm 
            }
        }

        stage('2. Nettoyage initial') {
            steps {
                echo '=== Nettoyage et mise à jour forcée des dépendances ==='
                // Force Maven à aller chercher les nouveaux starter-test sur internet
                sh 'mvn clean dependency:resolve -U'
            }
        }

        stage('3. Exécution des Tests') {
            steps {
                echo '=== Lancement de vos tests Spring Boot (JUnit 5) ==='
                sh 'mvn test'
            }
        }

        stage('4. Compilation du Serveur') {
            steps {
                echo '=== Compilation et création du fichier JAR exécutable ==='
                sh 'mvn package -DskipTests' 
            }
        }
    }
}