FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD spring-grpc.jar spring-grpc.jar
RUN sh -c 'touch /spring-grpc.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /spring-grpc.jar" ]
