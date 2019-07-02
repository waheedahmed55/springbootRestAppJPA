pipeline {

    agent any

    

	environment {

		apprest_image = "waheedahmed/testjenapprest1"

		db_image = "waheedahmed/testjendb1"

		registryCredential = 'dockerhublogin'

    }

	

    stages {

	    

	stage('Cloning Git') {

      	    steps {

        	git 'https://github.com/waheedahmed55/springbootRestAppJPA.git'

            }

    	}    

	    

        stage('Build Docker Image') {

            steps {

                script {

			docker.withRegistry('', registryCredential) {



 			        def apprestImage = docker.build(apprest_image + ":$BUILD_NUMBER")

				/* Push the container to the custom Registry */

			        apprestImage.push()

				

			        def mysqldbImage = docker.build(db_image + ":$BUILD_NUMBER", "./mySQL-Docker")

				/* Push the container to the custom Registry */

			        mysqldbImage.push()

    			}

                }

            }

        }

	    

	    

    }

}