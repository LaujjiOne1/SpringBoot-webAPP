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

        stage('2. Maven Build & Tests') {
            steps {
                echo '=== Nettoyage et exécution des Tests ==='
                sh 'mvn clean test'
            }
        }

        stage('3. Package JAR') {
            steps {
                echo '=== Création de l\'artifact JAR ==='
                sh 'mvn package -DskipTests'
            }
        }

        stage('4. Docker Build Image') {
            steps {
                echo '=== Création de l\'image Docker Spring Boot ==='
                // Nettoyage d'une ancienne image ou conteneur local s'il existe
                sh 'docker rm -f my-springboot-app || true'
                
                // Construction de l'image locale
                sh 'docker build -t myspringapp-image:latest .'
            }
        }

        stage('5. Push to Docker Hub') {
            steps {
                // Utilisation de votre identifiant secret 'TknDckrHb'
                withCredentials([usernamePassword(credentialsId: 'dockerHubKey', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_TOKEN')]) {
                    
                    echo '=== Connexion à Docker Hub ==='
                    sh 'echo "$DOCKER_TOKEN" | docker login -u "$DOCKER_USER" --password-stdin'
                    
                    echo '=== Tag et Push de l\'image ==='
                    // On prépare le nom pour Docker Hub : nom_utilisateur/nom_depot:tag
                    sh 'docker tag myspringapp-image:latest "$DOCKER_USER"/my-helloworld-app:latest'
                    sh 'docker push "$DOCKER_USER"/my-helloworld-app:latest'
                }
            }
        }

        stage('6. Deploy & Run App') {
            steps {
                echo '=== Lancement de l\'application conteneurisée ==='
                // On utilise withCredentials pour récupérer ton DOCKER_USER pour l'image
                withCredentials([usernamePassword(credentialsId: 'dockerHubKey', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_TOKEN')]) {
                    // Supprime le conteneur s'il tourne déjà pour pouvoir le mettre à jour
                    sh 'docker rm -f my-springboot-app || true'
                    
                    // Lance le conteneur en arrière-plan (-d) sur le port 8082 de ta machine
                    sh 'docker run -d --name my-springboot-app -p 8082:8080 "$DOCKER_USER"/my-helloworld-app:latest'
                    
                    echo '=== Application disponible sur http://localhost:8082 lance pour le voir please ==='
                }
            }
        }
    }

    post {
        success {
            echo '==========================================================='
            echo ' FÉLICITATIONS ! Le TP2 est entièrement complété.         '
            echo ' Votre application tourne maintenant dans un conteneur !   '
            echo '==========================================================='
        }
        failure {
            echo '=== LE PIPELINE A ÉCHOUÉ à une étape Docker ==='
        }
    }
}
