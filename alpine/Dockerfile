FROM alpine:3.4
MAINTAINER Steffen Bleul <sbl@blacklabelops.com>

RUN apk upgrade --update && \
    apk add \
      bash && \
    # Network fix
    echo 'hosts: files mdns4_minimal [NOTFOUND=return] dns mdns4' >> /etc/nsswitch.conf && \
    # Clean up
    rm -rf /var/cache/apk/* && \
    rm -rf /tmp/* && \
    rm -rf /var/log/*
