#基于那个镜像
#FROM java
FROM frolvlad/alpine-oraclejdk8:slim
#FROM openjdk:8-jdk-alpine
#可以将本地文件夹或者其他container的文件夹挂载到container中
VOLUME /tmp
#将build的文件添加到镜像中
ADD rouna-eureka-1.0-SNAPSHOT.jar app.jar
#container启动时执行的命令，但是一个Dockerfile中只能有一条	ENTRYPOINT命令，如果多条，则只执行最后一条
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]