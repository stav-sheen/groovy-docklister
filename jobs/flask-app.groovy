job('DockerBuildandPublishDSL') {
    description('Build and Publish flask app image to dockerhub')
     scm {
        git {
        remote {
                url('https://github.com/stav-sheen/groovy-docklister.git')
	        credentials('${Git-Creds}')
            }
            wrappers {
                preBuildCleanup()
            } 
            branch('*/' + 'master')
        }
    }

    steps {
        dockerBuildAndPublish {
            repositoryName('stavsheen/flasker')
            tag('${env.BUILD_ID}')
	    tag('latest')
            registryCredentials('${docker-cred}')
            dockerfileDirectory('./flask-app')
        }
    }
}
