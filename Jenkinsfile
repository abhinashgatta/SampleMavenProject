pipeline {
    agent any

    tools {
        maven "M3"      // Name of Maven configured in Jenkins
        jdk "JDK11"     // Change if you use another JDK
    }

    stages {

        stage("Checkout") {
            steps {
                git branch: 'main', url: 'https://github.com/abhinashgatta/SampleMavenProject.git'

            }
        }

        stage("Build") {
            steps {
                sh "mvn clean compile"
            }
        }

        stage("Test") {
            steps {
                sh "mvn test"
            }
        }

        stage("Package") {
            steps {
                sh "mvn package"
            }
        }
    }

    post {
        always {
            // Archive test results and reports
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}
