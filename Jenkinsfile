pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK25'
    }

    triggers {
        cron('* * * * *')
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Baixando o código do GitHub...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Compilando o projeto...'
                bat 'mvn clean compile'
            }
        }

        stage('Testes') {
            steps {
                echo 'Executando testes unitários...'
                bat 'mvn -Dmaven.test.failure.ignore=true test'
            }

            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Cobertura') {
            steps {
                echo 'Gerando relatório de cobertura com JaCoCo...'
                bat 'mvn verify'
            }

            post {
                always {
                    jacoco(
                        execPattern: 'target/jacoco.exec',
                        classPattern: 'target/classes',
                        sourcePattern: 'src/main/java',
                        exclusionPattern: ''
                    )
                }
            }
        }
    }

    post {
        success {
            echo 'Build finalizada com sucesso.'
        }

        unstable {
            echo 'Build instável: o projeto compilou, mas algum teste falhou.'
        }

        failure {
            echo 'Build falhou.'
        }

        always {
            echo 'Pipeline finalizado.'
        }
    }
}