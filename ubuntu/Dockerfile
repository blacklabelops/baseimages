FROM ubuntu:16.04
MAINTAINER Steffen Bleul <sbl@blacklabelops.com>

RUN apt-get update && \
    apt-get -y dist-upgrade && \
    apt-get autoclean && \
    rm -rf /tmp/* && rm -rf /var/log/*
