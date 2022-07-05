package ai.ecma.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 7/5/2022
 */
@Configuration
public class RabbitMQDefaultConfig {
    @Value("${spring.rabbitmq.queues.default.name}")
    private String defaultQueueName;

    @Value("${spring.rabbitmq.queues.default.durable}")
    private boolean defaultQueueDurable;

    @Value("${spring.rabbitmq.queues.default.routing-key}")
    private String defaultQueueRoutingKey;

    @Value("${spring.rabbitmq.queues.default.exchange}")
    private String defaultQueueExchange;

    @Bean
    DirectExchange defaultDirectExchange() {
        return new DirectExchange(defaultQueueExchange);
    }

    @Bean
    Queue defaultQueue() {
        return new Queue(defaultQueueName, defaultQueueDurable);
    }

    @Bean
    Binding defaultBinding(Queue defaultQueue, DirectExchange defaultDirectExchange) {
        return BindingBuilder.bind(defaultQueue).to(defaultDirectExchange).with(defaultQueueRoutingKey);
    }
}
