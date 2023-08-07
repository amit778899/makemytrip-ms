pipeline {
    agent any
        tools {
            maven 'mvn_3.9.4'
        }

	stages {
		stage ('Check Java Version') {
			steps {
				sh "java --version"
			}
		}
		stage ('Check mvn Version') {
			steps {
				sh "mvn --version"

			}
		}

	}
}