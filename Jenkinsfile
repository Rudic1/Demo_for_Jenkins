pipeline {
	
    agent any
	tools { 
        maven 'maven'
        jdk 'java-17-openjdk'
       }	
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
		    echo 'Starting Tests now'
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
            slackSend channel: '#jenkinsdemo', color: 'good', message: "*Build erfolgreich:* ${env.JOB_NAME} #${env.BUILD_NUMBER}"

        }

        failure {
            echo 'Die Pipeline ist fehlgeschlagen.'
            slackSend channel: '#jenkinsdemo', color: 'danger', message: "*Build fehlgeschlagen:* ${env.JOB_NAME} #${env.BUILD_NUMBER}"

        }
    }
}
