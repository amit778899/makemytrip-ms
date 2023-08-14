pipeline {

    agent any
    node ('jenkins-slave-teamB')
    	tools {
		maven 'mvn_3.9.4'
	}
    stages {
        stage('Code Compilation') {
            steps {
                echo 'Code Compilation Is In Progress!'
                sh 'mvn clean compile'
				echo 'Code Compilation Is Completed Successfully!'
            }
        }
        stage('Code QA Execution') {
            steps {
                echo 'Test Case Check In Progress!'
                sh 'mvn clean test'
            }
        }
		stage('Code Package') {
            steps {
                echo 'Creating War Artifact!'
                sh 'mvn clean package'
            }
		}
    }
}
