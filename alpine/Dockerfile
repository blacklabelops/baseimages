FROM alpine:3.5

ARG ALPINE_IMAGE_BUILD_DATE=undefined

ENV BLACKLABELOPS_HOME=/var/blacklabelops

RUN apk upgrade --update && \
    apk add \
      bash \
      tini \
      su-exec \
      curl && \
    # Network fix
    echo 'hosts: files mdns4_minimal [NOTFOUND=return] dns mdns4' >> /etc/nsswitch.conf && \
    # Wait for it - Waiting For Available Ports And Servers
    curl https://raw.githubusercontent.com/vishnubob/wait-for-it/55c54a5abdfb32637b563b28cc088314b162195e/wait-for-it.sh -o /usr/bin/wait-for-it && \
    # Blacklabelops Feature Script Folder
    mkdir -p ${BLACKLABELOPS_HOME} && \
    # Clean up
    apk del curl && \
    rm -rf /var/cache/apk/* && \
    rm -rf /tmp/* && \
    rm -rf /var/log/*

COPY imagescripts/ ${BLACKLABELOPS_HOME}/

LABEL maintainer="Steffen Bleul <sbl@blacklabelops.com>" \
      com.blacklabelops.image.name.alpine="alpine-base-image" \
      con.blacklabelops.image.builddate.alpine=${ALPINE_IMAGE_BUILD_DATE}
