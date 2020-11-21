# Base images 基础镜像
FROM swr.cn-south-1.myhuaweicloud.com/beller_sun_docker/base:latest
#MAINTAINER 维护者信息
MAINTAINER 孙玉朝

ENV APP_NAME multi-data-source

RUN sudo mkdir -p /home/admin/logs && \
    sudo mkdir -p /home/admin/$APP_NAME && \
    sudo mkdir -p /home/admin/$APP_NAME/logs && \
    sudo mkdir -p /home/admin/$APP_NAME/target && \
    sudo mkdir -p /home/admin/$APP_NAME/target/exploded && \
    sudo mkdir -p /root/logs && \

sudo chmod o+wx /home/admin/logs && \
sudo chmod -R a+rwx /home/admin/$APP_NAME

#挂载目录的映射
VOLUME /home/admin/logs /home/admin/$APP_NAME/logs
WORKDIR /home/admin/$APP_NAME/bin

COPY multi-data-source.jar /home/admin/multi-data-source/target/multi-data-source.jar
