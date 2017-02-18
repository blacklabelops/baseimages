FROM ubuntu:16.04

ARG BUILD_DATE=undefined

RUN apt-get update && \
    apt-get -y dist-upgrade && \
    apt-get autoclean && \
    rm -rf /tmp/* && rm -rf /var/log/*

LABEL maintainer="Steffen Bleul <sbl@blacklabelops.com>" \
      com.blacklabelops.maintainer.name="Steffen Bleul" \
      com.blacklabelops.maintainer.email="sbl@blacklabelops.com" \
      com.blacklabelops.support="http://support.blacklabelops.com/" \
      com.blacklabelops.image.os="ubuntu" \
      com.blacklabelops.image.osversion="16.04" \
      com.blacklabelops.image.name.ubuntu="ubuntu-base-image" \
      com.blacklabelops.image.builddate.ubuntu=${BUILD_DATE}
