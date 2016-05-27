FROM alpine:3.3
MAINTAINER Steffen Bleul <sbl@blacklabelops.com>

# Default UTF-8 encoding
ENV LANG en_US.UTF-8

RUN apk upgrade --update && \
    apk add \
      bash && \
    # Network fix
    echo 'hosts: files mdns4_minimal [NOTFOUND=return] dns mdns4' >> /etc/nsswitch.conf && \
    # Clean up
    rm -rf /var/cache/apk/* && \
    rm -rf /tmp/* && \
    rm -rf /var/log/*
