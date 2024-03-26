pipeline {

    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }

    agent any

    tools {
        maven 'maven_3.9.6'
    }

    stages {
        stage('Code Compilation') {
            steps {
                echo 'Code Compilation is In Progress!'
                sh 'mvn clean compile'
				echo 'Code Compilation is Completed Successfully!'
            }
        }
        stage('Code QA Execution') {
             steps {
                echo 'Amit Test case check in Progress!'
                sh 'mvn clean test'
             }
        }
        stage('Code Package') {
            steps {
                echo 'Creating War Artifact'
                sh 'mvn clean package'
            }
        }
        stage('Building & Tag Docker Image') {
            steps {
                echo 'Starting Building Docker Image'
                sh 'docker build -t amit778899/makemytrip-ms .'
                sh 'docker build -t makemytrip-ms .'
                echo 'Completed  Building Docker Image'
            }
        }
        stage('Docker Image Scanning') {
            steps {
                echo 'Docker Image Scanning Started'
                sh 'java -version'
                echo 'Docker Image Scanning Completed'
            }
        }
        stage(' Docker push to Docker Hub') {
           steps {
              script {
                 withCredentials([string(credentialsId: 'dockerhubCred', variable: 'dockerhubCred')]){
                 sh 'docker login docker.io -u amit778899 -p ${dockerhubCred}'
                 echo "Push Docker Image to DockerHub : In Progress"
                 sh 'docker push amit778899/makemytrip-ms:latest'
                 echo "Push Docker Image to DockerHub : Completed"
                 }
              }
            }
        }
        stage(' Docker Image Push to Amazon ECR') {
           steps {
              script {
                 withDockerRegistry([credentialsId:'ecr:ap-south-1:ecr-credentials', url:"https://615277645636.dkr.ecr.ap-south-1.amazonaws.com/makemytrip-ms"]){
                 sh """
                 echo "List the docker images present in local"
                 docker images
                 echo "Tagging the Docker Image: In Progress"
                 docker tag makemytrip-ms:latest 615277645636.dkr.ecr.ap-south-1.amazonaws.com/makemytrip-ms:latest
                 echo "Tagging the Docker Image: Completed"
                 echo "Push Docker Image to ECR : In Progress"
                 docker push 615277645636.dkr.ecr.ap-south-1.amazonaws.com/makemytrip-ms:latest
                 echo "Push Docker Image to ECR : Completed"
                 """
                 }
              }
           }
        }
        stage ('Upload the docker Image to Nexus') {
        	steps {
        		script {
        			withCredentials([usernamePassword(credentialsId: 'nexuscred', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        			sh 'docker login http://65.0.11.128:8085/repository/makemytrip-ms/ -u admin -p ${PASSWORD}'
        			echo "Push Docker Image to Nexus : In Progress"
        			sh 'docker tag makemytrip-ms 65.0.11.128:8085/makemytrip-ms:latest'
        			sh 'docker push 65.0.11.128:8085/makemytrip-ms'
        			echo "Push Docker Image to Nexus : Completed"
        			}
        		}
        	}
        }
        stage('Delete images from Jenkins') {
            steps {
                sh 'docker rmi -f $(docker images -q)'
                sh 'docker images'
            }
        }
	}
}
