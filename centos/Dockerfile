FROM centos:7.2.1511

ARG BUILD_DATE=undefined

RUN yum -y update && \
    yum clean all && rm -rf /var/cache/yum/*

LABEL maintainer="Steffen Bleul <sbl@blacklabelops.com>" \
      com.blacklabelops.image.os="centos" \
      com.blacklabelops.image.osversion="7.2.1511" \
      com.blacklabelops.image.name.centos="centos-base-image" \
      con.blacklabelops.image.builddate.centos=${BUILD_DATE}
