package ai.ecma.producer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppProducerApplication.class, args);
    }

}
