pipeline {
    agent any

    tools {
        // Indiquez ici les noms exacts configurés dans "Administrer Jenkins -> Tools"
        maven 'Maven3' 
        jdk 'Java17'
    }

    stages {
        stage('1. Récupération du Code') {
            steps {
                echo '=== Récupération du projet depuis le dépôt distant ==='
                // Utilise la configuration de votre Job Jenkins (gère vos Credentials automatiquement)
                checkout scm 
            }
        }

        stage('2. Nettoyage initial') {
            steps {
                echo '=== Nettoyage des anciens builds ==='
                bat 'mvn clean'
            }
        }

        stage('3. Exécution des Tests') {
            steps {
                echo '=== Lancement de vos tests Spring Boot (JUnit 5) ==='
                bat 'mvn test'
            }
        }

        stage('4. Compilation du Serveur') {
            steps {
                echo '=== Compilation et création du fichier JAR exécutable ==='
                // -DskipTests permet d'aller plus vite car les tests ont déjà été validés à l'étape précédente
                bat 'mvn package -DskipTests' 
            }
        }
    }

    post {
        success {
            echo '========================================================='
            echo '  SUCCÈS ! Votre pipeline fonctionne parfaitement.     '
            echo '  Le fichier JAR de votre serveur Spring Boot est prêt.  '
            echo '========================================================='
        }
        failure {
            echo '========================================================='
            echo '  ÉCHEC ! Le pipeline s\'est arrêté.                      '
            echo '  Vérifiez les lignes d\'erreur ci-dessus dans la console.'
            echo '========================================================='
        }
    }
}