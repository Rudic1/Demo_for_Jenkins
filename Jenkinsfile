pipeline {
	
    agent any
    
    tools { 
   	 maven 'maven'
   	 jdk 'java-17-openjdk'
    }	
    
    stages {
        stage('Check') {
            steps {
		sleep time: 3, unit: 'SECONDS'
                git 'https://github.com/Rudic1/Demo_for_Jenkins.git'
            }
        }
        
        stage('Build') {
	    agent {label 'linux'}
            steps {
                script {
                    sh 'mvn clean install -DskipTests'
                }
            }
        }

   	stage('Simulate Browser Tests') {
            parallel {
                stage('Firefox') {
                    agent { label 'linux' }
                    steps {
                        echo 'Running tests on Firefox...'
                        sh 'echo Simulating Firefox tests'
                        sleep 5
                    }
                }

                stage('Chrome') {
                    agent { label 'win' }
                    steps {
                        echo 'Running tests on Chrome...'
                        bat 'echo Simulating Chrome tests'
                        sleep 4
                    }
                }

                stage('Edge') {
		    agent { label 'win' }
                    steps {
                        echo 'Running tests on Edge (Windows)...'
                        bat 'echo Simulating Edge tests'
                        sleep 4
                    }
                }
            }
        }

	 stage('Unit-Tests') {
	    agent {label 'linux'}
            steps {
                script {
		    echo 'Starting Tests'
                    sh 'mvn test'
                }
            }
        } 
        
        stage('Test Results') {
	    agent {label 'linux'}
            steps {
                junit '**/target/surefire-reports/*.xml' 
            }
        }
        
        stage('Archive Artifacts') {
	    agent {label 'linux'}
            steps {
                archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
            }
        }

        stage('Simulate Deployment') {
            steps {
		sleep time: 3, unit: 'SECONDS'
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
