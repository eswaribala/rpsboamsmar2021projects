pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        bat(script: 'mvn -version', returnStatus: true, returnStdout: true)
      }
    }

  }
}