FROM centos:7.2.1511
MAINTAINER Steffen Bleul <sbl@blacklabelops.com>

# Default UTF-8 encoding
ENV LANG C.UTF-8

RUN yum -y update && \
    yum clean all && rm -rf /var/cache/yum/*
