# Blacklabelops Docker Base Image

[![Docker Stars](https://img.shields.io/docker/stars/blacklabelops/alpine.svg)](https://hub.docker.com/r/blacklabelops/alpine/) [![Docker Pulls](https://img.shields.io/docker/pulls/blacklabelops/alpine.svg)](https://hub.docker.com/r/blacklabelops/alpine/)

Alpine images are smaller than full distributions, e.g. CentOS. This is a base image with some tweaks based on the official alpine image on Dockerhub.

Image Features:

* Includes repository updates
* tini: Zombie Process Reaper
* su-exec: Execute processes as different user
* wait-for-it: Waiting for available server ports.
* Feature Script: Runtime user definition with environment variables.

# Build the Image

~~~~
$ cd alpine && docker build -t blacklabelops/alpine .
~~~~

# Run the Image

~~~~
$ docker run -it --rm blacklabelops/alpine bash
~~~~

# Blacklabelops User Feature

The blacklabelops User Feature is a script for specifiying the run user of your application with env variables.
The user will be created automatically and can be user inside your entrypoint to start your application using `su-exec`.

You can define a user for your application at startup with the environment variables:

* DOCKER_USER: The user's name, should match a valid username on your host machine (Default: blacklabelops).
* DOCKER_USER_ID: The user's id should match a valid id on your host machine (Default: 1000).
* DOCKER_USERGROUP: The user's groupname, should match a valid groupname on your host machine (Default: blacklabelops).
* DOCKER_USERGROUP_ID: The user's groupid, should match a valid goup id on your host machine (Default: 1000).

Example Use Case:

~~~~
$ docker run \
    -e "DOCKER_USER=YourUser" \
    -e "DOCKER_USER_ID=2000" \
    -e "DOCKER_USERGROUP=YourGroup" \
    -e "DOCKER_USERGROUP_ID=2000" \
    blacklabelops/alpine ./var/blacklabelops/createuser.sh
~~~~

In order to make this work you will have to hook this script in your individual entrypoint script:

~~~~
#!/bin/bash

# Include The Feature Script
source /var/blacklabelops/dockeruser.sh
# Create The User
dockerUser
# Print User Information
printUserInfo
# Executing The Application
exec su-exec $CURRENT_DOCKER_USER your_application_command_here
~~~~

> Simple entrypoint.sh script example.

# Using tini

Tini is used to wrap your images entrypoint!

More information: [krallin/tini](https://github.com/krallin/tini)

Example:

~~~~
ENTRYPOINT ["/sbin/tini","--","/yourpath/docker-entrypoint.sh"]
~~~~

> Will start your entrypoint under tini process management.

# Using su-exec

Su-Exec C reimplementation of gosu! Simplified sudo to exec processes under different users.

More information: [ncopa/su-exec](https://github.com/ncopa/su-exec)

Use su-exec in your individual entrypoint script:

~~~~
#!/bin/bash

# Executing The Application
exec su-exec your_user your_application_command_here
~~~~

> Simple entrypoint.sh script example.

# Build the Image

~~~~
$ docker build -t blacklabelops/alpine .
~~~~

# Run the Image

~~~~
$ docker run -it --rm blacklabelops/alpine bash
~~~~

# Support

Leave a message and ask questions on Hipchat: [blacklabelops/hipchat](http://support.blacklabelops.com)
