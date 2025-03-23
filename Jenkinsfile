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
        stage('OWASP Dependency-Check') {
            steps {
                dependencyCheck additionalArguments: '''
                    -o './'
                    -s './'
                    -f 'ALL'
                    --prettyPrint''', odcInstallation: 'dp'
                
                dependencyCheckPublisher pattern: 'dependency-check-report.xml'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying....'
                // Add your deploy steps here
            }
        }
    }
    post {
        always {
            emailext body: '''${SCRIPT, template="groovy-html.template"}''',
                subject: "${currentBuild.currentResult}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                to: 'katireddymahalakshmi@gmail.com',
                replyTo: 'katireddymahalakshmi@gmail.com',
                mimeType: 'text/html'
        }
        success {
            emailext body: "The build was successful. Check console output at ${env.BUILD_URL}",
                subject: "Success: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                to: 'katireddymahalakshmi@gmail.com',
                replyTo: 'katireddymahalakshmi@gmail.com'
        }
        failure {
            emailext body: "The build failed. Check console output at ${env.BUILD_URL}",
                subject: "Failed: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                to: 'katireddymahalakshmi@gmail.com',
                replyTo: 'katireddymahalakshmi@gmail.com'
        }
    }
}
