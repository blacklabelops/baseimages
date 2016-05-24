## blacklabelops/alpine

Alpine images are smaller than full distributions, e.g. CentOS. This is a base image with some tweaks based on the official alpine image on Dockerhub.

* Includes updates

### Build the Image

~~~~
$ cd alpine && docker build -t blacklabelops/alpine .
~~~~

### Run the Image

~~~~
$ docker run -it --rm blacklabelops/alpine bash
~~~~

## blacklabelops/centos

* Includes updates

### Build the Image

~~~~
$ cd centos && docker build -t blacklabelops/centos .
~~~~

### Run the Image

~~~~
$ docker run -it --rm blacklabelops/centos bash
~~~~

## blacklabelops/ubuntu

* Includes updates

### Build the Image

~~~~
$ cd ubuntu && docker build -t blacklabelops/ubuntu .
~~~~

### Run the Image

~~~~
$ docker run -it --rm blacklabelops/ubuntu bash
~~~~
