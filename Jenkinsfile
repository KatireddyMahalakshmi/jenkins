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
                sh 'mvn '
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
            }
        }
    }
    post {
        always {
            script {
                try {
                    emailext (
                        subject: '${DEFAULT_SUBJECT}',
                        body: '${DEFAULT_CONTENT}',
                        recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
                        to: 'katireddymahalakshmi@gmail.com'
                    )
                    echo "Email sent successfully"
                } catch (e) {
                    echo "Failed to send email: ${e.message}"
                    echo "Stack trace: ${e.stackTrace.join('\n')}"
                }
            }
        }
    }
}
