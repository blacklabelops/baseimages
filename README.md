# Supported Tags And Respective Dockerfile Links

| Base Image   | Tag          | Dockerfile | Readme |
|--------------|--------------|------------|--------|
| blacklabelops/alpine | latest, 3.8 | [Dockerfile](alpine/Dockerfile) | [README.md](alpine/README.md) |
| blacklabelops/centos | latest, 7, 7.4 , 7.4.1708 | [Dockerfile](centos/Dockerfile) | [README.md](README.md) |
| blacklabelops/ubuntu | latest, 18, 18.04 | [Dockerfile](ubuntu/Dockerfile) | [README.md](README.md) |

# Support

Leave a message and ask questions on Hipchat: [blacklabelops/support](https://www.hipchat.com/gEorzhvnI)

# blacklabelops/alpine

[![Docker Stars](https://img.shields.io/docker/stars/blacklabelops/alpine.svg)](https://hub.docker.com/r/blacklabelops/alpine/) [![Docker Pulls](https://img.shields.io/docker/pulls/blacklabelops/alpine.svg)](https://hub.docker.com/r/blacklabelops/alpine/)

Blacklabelops Alpine Base Image

* Includes repository updates
* tini: Zombie Process Reaper
* su-exec: Execute processes as different user
* wait-for-it: Waiting for available server ports.
* Feature Script: Runtime user definition with environment variables.

[README.de](alpine/README.md)

[Dockerhub Repository](https://hub.docker.com/r/blacklabelops/alpine/)

# blacklabelops/centos

[![Docker Stars](https://img.shields.io/docker/stars/blacklabelops/centos.svg)](https://hub.docker.com/r/blacklabelops/centos/) [![Docker Pulls](https://img.shields.io/docker/pulls/blacklabelops/centos.svg)](https://hub.docker.com/r/blacklabelops/centos/)

* Includes updates

## Build the Image

~~~~
$ cd centos && docker build -t blacklabelops/centos .
~~~~

## Run the Image

~~~~
$ docker run -it --rm blacklabelops/centos bash
~~~~

# blacklabelops/ubuntu

[![Docker Stars](https://img.shields.io/docker/stars/blacklabelops/ubuntu.svg)](https://hub.docker.com/r/blacklabelops/ubuntu/) [![Docker Pulls](https://img.shields.io/docker/pulls/blacklabelops/ubuntu.svg)](https://hub.docker.com/r/blacklabelops/ubuntu/)

* Includes updates

## Build the Image

~~~~
$ cd ubuntu && docker build -t blacklabelops/ubuntu .
~~~~

## Run the Image

~~~~
$ docker run -it --rm blacklabelops/ubuntu bash
~~~~
