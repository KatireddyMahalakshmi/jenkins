pipeline {
    agent any
    tools{
        maven 'maven-3'
        jdk 'JDK11'
    }

    stages {
        stage('Build') {
            steps {
                sh './mvnw clean package -DskipTests'
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
