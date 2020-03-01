job('runs and test containers') {
    steps {
        shell('docker run -dit -p 5000:5000 --network groovy-docklist --ip 172.18.0.2 --name nginx-proxy stavsheen/flasker:latest')
    }
    wrappers {
        buildInDocker {
            image('stavsheen/nprox:latest')
            startCommand('curl 127.0.0.1:80')
        }
    }
}
