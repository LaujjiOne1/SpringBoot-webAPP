pipeline {
    agent any

    tools {
        // Associe le Maven configuré dans "Administrer Jenkins -> Tools"
        maven 'Maven3' 
        // Associe le JDK configuré dans Jenkins
        jdk 'Java17'
    }

    triggers {
        // [Rappel TP2]: Permet le déclenchement à distance via un Token
        // URL d'appel : http://localhost:8080/job/Nom_Du_Job/build?token=MON_SECRET_TOKEN
        RemoteTrigger(token: 'MON_SECRET_TOKEN')
    }

    stages {
        stage('Nettoyage & Préparation') {
            steps {
                // [Rappel TP1]: Équivalent moderne de la commande Batch
                echo '=== Nettoyage du projet Spring Boot ==='
                bat 'mvn clean'
            }
        }

        stage('Exécution des Tests') {
            steps {
                // [Rappel TP4 / Tests]: Lance vos tests JUnit 5 (MockMvc, Intégration, etc.)
                echo '=== Lancement des tests unitaires et d\'intégration ==='
                bat 'mvn test'
            }
        }

        stage('Compilation & Package') {
            steps {
                // [Rappel TP4]: Compile le code Java et génère le fichier .jar exécutable
                echo '=== Compilation et création du JAR Spring Boot ==='
                bat 'mvn package -DskipTests' 
            }
        }

        stage('Analyse Code (Optionnel)') {
            steps {
                // [Rappel TP4]: Si vous utilisez SonarQube comme dans le TP
                echo '=== Analyse de la qualité du code avec SonarQube ==='
                // bat 'mvn sonar:sonar' (Décommenter si le serveur Sonar est actif)
            }
        }
    }

    post {
        success {
            echo '=== Le Build est un SUCCÈS ! Votre application est prête. ==='
            // Optionnel : Vous pouvez ajouter ici une commande pour lancer le JAR en tâche de fond
            // bat 'start /B java -jar target/*.jar'
        }
        failure {
            echo '=== Le Build a ÉCHOUÉ. Vérifiez les rapports de tests ou de compilation. ==='
        }
    }
}