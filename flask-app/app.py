#!/usr/bin/python
from flask import Flask
import docker


app = Flask(__name__)

@app.route("/")
def home():
    mycontainers = []
    client = docker.DockerClient(base_url='tcp://172.31.43.88:2375')
    for container in client.containers.list():
        mycontainers.append([str(container.name), str(container.id)])

    return "{}".format(mycontainers)


if __name__ == "__main__":
    app.run(debug=True,host='0.0.0.0')

