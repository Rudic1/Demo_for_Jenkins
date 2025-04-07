pipeline {
	
    agent any
	
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Rudic1/Demo_for_Jenkins.git'
            }
        }
        
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }

        stage('Deploy') {
            steps {
                // Optional
                echo 'Deployment erfolgreich!'
            }
        }
    }

    post {
        always {
            echo 'Pipeline abgeschlossen.'
        }

        success {
            echo 'Die Pipeline war erfolgreich!'
        }

        failure {
            echo 'Die Pipeline ist fehlgeschlagen.'
        }
    }
}
