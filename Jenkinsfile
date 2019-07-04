pipeline {

    agent any

    

	environment {

		//apprest_image = "waheedahmed/testjenapprest1"
		  apprest_image = "us.gcr.io/synthetic-song-226517/demo/apprest"
		//db_image = "waheedahmed/testjendb1"
		  db_image = "us.gcr.io/synthetic-song-226517/demo/mysqlofficialimg"
		//registryCredential = 'dockerhublogin'
		  registryCredential = 'gcr:synthetic-song-226517'
	
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

			//docker.withRegistry('', registryCredential) {
			  docker.withRegistry('https://us.gcr.io', registryCredential) {


 			     //   def apprestImage = docker.build(apprest_image + ":$BUILD_NUMBER")

				
				def apprestImage = docker.build(apprest_image)
				
				/* Push the container to the custom Registry */
				apprestImage.push("$BUILD_NUMBER")
				apprestImage.push("latest")
			       // apprestImage.push()

				

			      //  def mysqldbImage = docker.build(db_image + ":$BUILD_NUMBER", "./mySQL-Docker")
  					  def mysqldbImage = docker.build(db_image , "./mySQL-Docker")
				/* Push the container to the custom Registry */
					mysqldbImage.push("$BUILD_NUMBER")	
					mysqldbImage.push("latest")
			       // mysqldbImage.push()

    			}

                }

            }

        }

	    

	    

    }

}