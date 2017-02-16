# blacklabelops/alpine

Blacklabelops Alpine Base Image

* Includes repository updates
* tini: Zombie Process Reaper
* su-exec: Execute processes as different user
* wait-for-it: Waiting for available server ports.
* Feature Script: Runtime user definition with environment variables.

[README.de](alpine/README.md)

[Dockerhub Repository](https://hub.docker.com/r/blacklabelops/alpine/)

# blacklabelops/centos

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

* Includes updates

## Build the Image

~~~~
$ cd ubuntu && docker build -t blacklabelops/ubuntu .
~~~~

## Run the Image

~~~~
$ docker run -it --rm blacklabelops/ubuntu bash
~~~~
