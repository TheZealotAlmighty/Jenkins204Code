pipeline {
    environment {
        registry = "zealotalmighty/jenkins_calculator_204"
        registryCredential = 'dockerhub'
        dockerImage=''
    }

    agent any
    tools {
        maven 'Apache Maven 3.6.3'
        jdk 'JDK 8'
    }
    stages {
        stage ('Clean') {
            steps {
                sh 'mvn clean'
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn compile'
            }
        }

        stage ('Short Tests') {
            steps {
                sh 'mvn -Dtest=CalculatorTest test'
            }
        }

        stage ('Long Tests') {
            steps {
                sh 'mvn -Dtest=CalculatorTestThorough test'
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }

        stage ('Package') {
            steps {
                sh 'mvn package'
                archiveArtifacts artifacts: 'src/**/*.java'
                archiveArtifacts artifacts: 'target/*.jar'
            }
        }

        stage ('Building image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }

        stage ('Deploy Image') {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        dockerImage.push()
                    }
                }
            }
        }

        stage ('Remove unused docker image') {
            steps {
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }

    }

    post {
        failure {
            mail to: 'zackmeyer7@gmail.com',
                 subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                 body: "Something is wrong with ${env.BUILD_URL}"
        }
    }
}
