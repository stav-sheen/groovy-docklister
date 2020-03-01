job('nginx-proxy maker') {
    description('Build and Publish nginx proxy image to dockerhub')
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
            repositoryName('stavsheen/nprox')
            tag('${env.BUILD_ID}')
	    tag('latest')
            registryCredentials('${docker-Cred}')
            dockerfileDirectory('./nginx')
        }
    }
}
