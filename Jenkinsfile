pipeline {
    agent any

    tools {
        maven 'Maven'
    }
    parameters {
            choice(
                name: 'ENV',
                choices: ['dev', 'qa', 'stage'],
                description: 'Select Environment'
            )
            }
    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    // Run tests but don't stop the pipeline immediately
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        sh 'mvn clean test'
                    }
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                allure(
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'allure-results']]
                )
            }
        }
    }

    post {

        always {
            archiveArtifacts artifacts: 'allure-results/**', fingerprint: true
        }

        success {
            withCredentials([string(credentialsId: 'slack-webhook', variable: 'SLACK_WEBHOOK')]) {
                sh """
                curl -X POST \
                -H "Content-type: application/json" \
                --data '{
                  "text":"🚀 Jenkins Build Notification\\n\\n📦 Project: ${env.JOB_NAME}\\n🔢 Build: #${env.BUILD_NUMBER}\\n📌 Status: ✅ SUCCESS\\n\\n🔗 Build: ${env.BUILD_URL}\\n📊 Allure Report: ${env.BUILD_URL}allure"
                }' \
                "$SLACK_WEBHOOK"
                """
            }
        }

        failure {
            withCredentials([string(credentialsId: 'slack-webhook', variable: 'SLACK_WEBHOOK')]) {
                sh """
                curl -X POST \
                -H "Content-type: application/json" \
                --data '{
                  "text":"🚀 Jenkins Build Notification\\n\\n📦 Project: ${env.JOB_NAME}\\n🔢 Build: #${env.BUILD_NUMBER}\\n📌 Status: ❌ FAILURE\\n\\n🔗 Build: ${env.BUILD_URL}\\n📊 Allure Report: ${env.BUILD_URL}allure"
                }' \
                "$SLACK_WEBHOOK"
                """
            }
        }
    }
}