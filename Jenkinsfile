pipeline {
    agent any
    tools{
        maven 'maven-3'
        jdk 'jdk17'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Run Integration Tests'){
            steps{
                sh 'mvn verify'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying....'
                // Add your deploy steps here
            }
        }
    }
}
