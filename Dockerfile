# Base images 基础镜像
FROM registry.cn-beijing.aliyuncs.com/acs-sample/jenkins-slave-java
#MAINTAINER 维护者信息
MAINTAINER 孙玉朝

ENV APP_NAME multi-data-source

RUN mkdir -p /home/admin/logs && \
    mkdir -p /home/admin/$APP_NAME && \
    mkdir -p /home/admin/$APP_NAME/logs && \
    mkdir -p /home/admin/$APP_NAME/target && \
    mkdir -p /home/admin/$APP_NAME/target/exploded && \
    mkdir -p /root/logs && \

chmod o+wx /home/admin/logs && \
chmod -R a+rwx /home/admin/$APP_NAME

#挂载目录的映射
VOLUME /home/admin/logs /home/admin/$APP_NAME/logs
WORKDIR /home/admin/$APP_NAME/bin

COPY multi-data-source.jar /home/admin/multi-data-source/target/multi-data-source.jar
