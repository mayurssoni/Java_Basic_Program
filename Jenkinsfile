node{
    def Maven_Home = tool name: 'Maven-Auto', type: 'maven'
    def Docker_Home = tool name: 'Docker-Auto', type: 'dockerTool'
    
    stage('Git Checkout'){
        git 'https://github.com/mayurssoni/Bootcamp05.git'
    }
    
    stage("Build Code"){
        sh "$Maven_Home/bin/mvn clean package"
    }
    
    stage('Docker Image build'){
        sh "sudo $Docker_Home/bin/docker build -t 8460447701/my_first_repo:jenkins1 ."
    }

    stage('Docker Push Image'){
        echo "So"
        withCredentials([usernamePassword(credentialsId: 'DockerhubMayur', passwordVariable: 'password', usernameVariable: 'username')]) {
        sh "sudo $Docker_Home/bin/docker login -u '${username}' -p '${password}'"
        }
        sh "sudo $Docker_Home/bin/docker push 8460447701/my_first_repo:jenkins1"
    }
    
    stage('Docker Run Container'){
        sh "sudo $Docker_Home/bin/docker run -dti -p 8084:8090 8460447701/my_first_repo:jenkins1"
    }
    
//    stage('Up in cloud foundry'){
//        pushToCloudFoundry(
//        target: 'https://api.run.pivotal.io',
//        organization: 'mayurssoni-org',
//        cloudSpace: 'development',
//        credentialsId: 'cloudfondrymayur'
//        )
//    }

    stage("Start app in cloud Foundary"){
        withCredentials([usernamePassword(credentialsId: 'cloudfondrymayur', passwordVariable: 'pass', usernameVariable: 'user')]) {
        sh "cf login -a https://api.run.pivotal.io -u '${user}' -p '${pass}' -o mayurssoni-org -s development"
        }
        sh "cf push devops_spring --docker-image 8460447701/my_first_repo:jenkins1"
    }
    
}
