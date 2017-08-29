# spring-grpc
Spring gRPC example.

## Spring boot gRPC starter
### Required lib
We use this [Spring boot gRPC starter] (https://github.com/yidongnan/grpc-spring-boot-starter)

### Implementation
* For simplicity's sake, we put server and client implementation together. 
* We do not use persistent layer yet
* Do not support gRPC 1.5 yet. 

## Docker Support
To create the Docker image and container, run the following maven command and docker command:

```
$ mvn clean compile install docker:removeImage docker:build -Denv=dev -Dmaven.test.skip=true 

$ docker run -d --name spring-grpc -p 8080:8080 jin/spring-grpc

```
