# Eureka server for Stork 

The purpose of this project is to provide a container image for an application implementin

[Smallrye Stork Eureka service discovery](https://github.com/smallrye/smallrye-stork/tree/main/service-discovery/eureka) is using this image for testing purposes.

The available container image is out of date (https://hub.docker.com/r/springcloud/eureka) and unusable.

This project uses Spring Boot and is the result of following the steps described in [this article](https://dzone.com/articles/spring-cloud-amp-spring-bootimplementing-eureka-se).


## Running the application locally

You can run your application from the root folder using:
```shell script
./mvnw spring-boot:run
```

The Eureka server will be available http://localhost:8761.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

## Creating a container image

1. Make sure Docker is up and running.
2. A Dockerfile is provided in `src/main/docker/Dockerfile.jvm` containing the instructions to build your Docker image.
3. Build the image by running the following command:

```shell
docker build -f src/main/docker/Dockerfile.jvm -t quay.io/$USER/eureka-server .
```
**NOTE** Make sure you use your own user and use another registry if you want.

Then you can run the container using:

```shell
docker run -i --rm -p 8761:8761 quay.io/$USER/eureka-server
```

