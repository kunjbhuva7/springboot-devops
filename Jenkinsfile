pipeline {
    agent any

    tools {
        maven 'maven3'
        jdk 'jdk17'
    }

    environment {
        DOCKERHUB_CREDENTIALS = 'dockerhub-token'
        IMAGE_NAME = "kunj22/springboot-devops"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                url: 'https://github.com/kunjbhuva7/springboot-devops.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Build & Push Image (Jib)') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: "${DOCKERHUB_CREDENTIALS}",
                    usernameVariable: 'USER',
                    passwordVariable: 'PASS'
                )]) {
                    sh """
                       mvn -DskipTests \
                        -Djib.to.image=${IMAGE_NAME}:${BUILD_NUMBER} \
                        -Djib.to.auth.username=$USER \
                        -Djib.to.auth.password=$PASS \
                        jib:build
                    """
                }
            }
        }

        stage('Deploy Application on Port 3555') {
            steps {
                sh "pkill -f springboot-devops || true"
                sh "nohup java -jar target/*.jar --server.port=3555 > app.log 2>&1 &"
            }
        }
    }

    post {
        success {
            echo "✅ Deployment Successful — Running on port 3555"
            echo "Test using: curl http://localhost:3555/hello"
        }
        failure {
            echo "❌ Pipeline Failed"
        }
    }
}

