pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'maven') {
                    bat 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven') {
                    bat 'mvn test'
                }
            }
        }


        stage ('package Stage') {
            steps {
                withMaven(maven : 'maven') {
                    bat 'mvn package'
                }
            }
        }
        stage ('docker build') {
            steps {
                bat 'docker build -f Dockerfile -t banerjeeindranil854/docker-inventorymanagement .'
            }
        }
        stage ('docker push') {
            steps {
            		withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPassword')]) {
                    bat "docker login -u banerjeeindranil854 -p ${dockerHubPassword}"
					}
                bat 'docker push banerjeeindranil854/docker-inventorymanagement'
            }
        }
    }
}