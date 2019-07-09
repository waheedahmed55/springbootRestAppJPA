pipeline {

    agent any

    

	environment {

		//apprest_image = "waheedahmed/testjenapprest1"
		  apprest_image = "us.gcr.io/synthetic-song-226517/demo/apprest"
		//db_image = "waheedahmed/testjendb1"
		  db_image = "us.gcr.io/synthetic-song-226517/demo/mysqlofficialimg"
		  
		  test_image = "us.gcr.io/synthetic-song-226517/demo/restassuredtests"
		  
		//registryCredential = 'dockerhublogin'
		  registryCredential = 'gcr:synthetic-song-226517'
		  
		  test_dep = "demotest"
          GOOGLE_PROJECT_ID = 'synthetic-song-226517';
		  
	
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

	    stage('Building the Tests') {

            steps {

                script {

			docker.withRegistry('https://us.gcr.io', registryCredential) {

				def testImage = docker.build(test_image, "./restAssuredDemoTest")
				testImage.push("$BUILD_NUMBER")
				testImage.push("latest")
				
    			}
                }
		    
            }
        }

	    stage('Deploy the test') {

            steps {

                script {
				sh """
				curl -o /tmp/google-cloud-sdk.tar.gz https://dl.google.com/dl/cloudsdk/channels/rapid/downloads/google-cloud-sdk-220.0.0-linux-x86_64.tar.gz;
				tar -xvf /tmp/google-cloud-sdk.tar.gz -C /tmp/;
				/tmp/google-cloud-sdk/install.sh -q;
				export PATH=/tmp/google-cloud-sdk/bin:$PATH;
				gcloud config set project ${GOOGLE_PROJECT_ID};
				gcloud components install app-engine-java;
				gcloud components install app-engine-python;
				gcloud components install kubectl;
				echo "After authentication gcloud"; 
				kubectl run --image=${test_image} ${test_dep}
				kubectl get pods;
				""" 
                }
		    
            }
        }
	    

    }

}