# groovy docklister

A simple **Flask** web-app that lists runnning docker containers on given servers. the app is accompanied by one **Nginx ** proxy server and a full set of **Jenkins** DSL jobs 
to build & publish docker images as well as run and test the app. 




## File structure

    .
    ├── src
    │   ├── jobs                # DSL script files
    │   ├── flask-app			# flask container related setup
    │   ├── Nginx           	# nginx proxy container related setup
    └── docker compose           # unrelated build file

## Pre-requisits
- Jenkins 
	- job dsl plugin 
	- cloudbees (most of the docker related plugins)
- Docker (usually goes with jenkins)
- Github account to clone this to
- Dockerhub account 

## Credentials
Be sure to configure credentials to git and docker accounts used in the dsl jobs.
i found that setting them manually after the dsl is imported by the seed job can realy "seal the deal" especially because i have encountered issues with my servers and had to set up this project a couple of times over. 



## Seed job setup
- Reference to the github repo 
-  under build section tick the "process job DSL's"
	- look on filesystem : 
	>dsl scripts :     ./jobs/*.groovy  
- Any other configurations you may like 

## Links 
the following documentations were used in the making of this : 
Jenkins Job DSL API : 
[https://jenkinsci.github.io/job-dsl-plugin](https://jenkinsci.github.io/job-dsl-plugin)
[sheehan](https://github.com/sheehan)/[job-dsl-gradle-example](https://github.com/sheehan/job-dsl-gradle-example)


# Disclaimer
this project is still a work in progress. 
there are a lot of dsl documentation to get to the bottom of. 
no rhel servers were harmed in the making of this repo 
(only ubuntu)
