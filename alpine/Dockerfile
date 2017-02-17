FROM alpine:3.5

ARG BUILD_DATE=undefined

ENV BLACKLABELOPS_HOME=/var/blacklabelops

RUN apk upgrade --update && \
    apk add \
      bash \
      tini \
      su-exec \
      curl && \
    # Network fix
    echo 'hosts: files mdns4_minimal [NOTFOUND=return] dns mdns4' >> /etc/nsswitch.conf && \
    # Blacklabelops Feature Script Folder
    mkdir -p ${BLACKLABELOPS_HOME} && \
    # Clean up
    apk del curl && \
    rm -rf /var/cache/apk/* && \
    rm -rf /tmp/* && \
    rm -rf /var/log/*

COPY imagescripts/ ${BLACKLABELOPS_HOME}/
COPY imagescripts/dockerwait.sh /usr/bin/dockerwait

LABEL maintainer="Steffen Bleul <sbl@blacklabelops.com>" \
      com.blacklabelops.image.os="alpine" \
      com.blacklabelops.image.osversion="3.5" \
      com.blacklabelops.image.name.alpine="alpine-base-image" \
      com.blacklabelops.image.builddate.alpine=${BUILD_DATE}
