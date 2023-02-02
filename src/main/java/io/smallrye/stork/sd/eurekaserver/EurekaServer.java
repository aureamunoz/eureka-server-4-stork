package io.smallrye.stork.sd.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;



/**
 * Let's be clear - Starting an Eureka server is not as easy as it should be.
 * The available container image is out of date (https://hub.docker.com/r/springcloud/eureka) and unusable.
 * <p>
 * The easiest way is to start a Spring application.
 * It leads to test classpath pollution as you need to select the versions carefully.
 * <p>
 * This class is responsible for starting and stopping the Eureka server.
 * The spring application reads the `src/test/resources/application.properties` file.
 * <p>
 * This class starts the server and provides helper methods to handle registrations and status updates.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {

    private static ConfigurableApplicationContext context;

    public static final String EUREKA_HOST = "localhost";
    public static final int EUREKA_PORT = 8761;
    @SuppressWarnings("HttpUrlsUsage")
    public static final String EUREKA_URL = "http://" + EUREKA_HOST + ":" + EUREKA_PORT;

    public static void main(String[] args) {
        context = SpringApplication.run(EurekaServer.class);
    }
}
