pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: 'github', url: GIT_URL
            }
        }

        
        stage('SonarQube Scan') {
            steps {
                withSonarQubeEnv(installationName: 'localSonar12',credentialsId: 'sonartoken') {
                    sh 'mvn clean verify sonar:sonar -Dsonar.login=$SONAR_AUTH_TOKEN'
                }    
            }
        }

        stage('Build Artifact'){
            steps{
             sh ''' mvn clean package'''
            }
        }
        stage('Archieve / Cleanup Workspace'){
            steps{
                archiveArtifacts artifacts: '**/*.war', fingerprint: true, followSymlinks: false, onlyIfSuccessful: true
                cleanWs()
            }
        }
    }
}
