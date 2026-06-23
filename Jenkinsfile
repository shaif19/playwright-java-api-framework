pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false,
                        jdk: '',
                        results: [[path: 'allure-results']]
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'allure-results/**', fingerprint: true
        }
    }
}

post {
    always {
        withCredentials([string(credentialsId: 'slack-webhook', variable: 'SLACK_WEBHOOK')]) {
            sh '''
            curl -X POST -H "Content-type: application/json" \
            --data '{
              "text":"✅ Jenkins Build Finished\\nJob: '"$JOB_NAME"'\\nBuild: #'"$BUILD_NUMBER"'\\nStatus: '"$currentBuild.currentResult"'"
            }' \
            "$SLACK_WEBHOOK"
            '''
        }
    }
}