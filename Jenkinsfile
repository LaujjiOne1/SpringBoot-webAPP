pipeline {
    agent any

    tools {
        // Ces outils doivent correspondre à ce qui est configuré dans Administrer Jenkins -> Tools
        maven 'Maven3'
        jdk 'Java17'
    }

    stages {
        stage('1. Récupération du Code') {
            steps {
                echo '=== Récupération du projet depuis le dépôt distant ==='
                checkout scm
            }
        }

        stage('2. Nettoyage initial') {
            steps {
                echo '=== Nettoyage des anciens builds ==='
                // Remplacement de 'bat' par 'sh'
                sh 'mvn clean'
            }
        }

        stage('3. Exécution des Tests') {
            steps {
                echo '=== Lancement de vos tests Spring Boot (JUnit 5) ==='
                // Remplacement de 'bat' par 'sh'
                sh 'mvn test'
            }
        }

        stage('4. Compilation du Serveur') {
            steps {
                echo '=== Compilation et création du fichier JAR exécutable ==='
                // Remplacement de 'bat' par 'sh'
                sh 'mvn package -DskipTests' 
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