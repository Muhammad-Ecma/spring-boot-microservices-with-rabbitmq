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
public class RabbitMQDirectExchangeConfig {
    /*

    @Value("${spring.rabbitmq.queues.notification.name}")
    private String notificationQueueName;

    @Value("${spring.rabbitmq.queues.notification.durable}")
    private boolean notificationQueueDurable;

    @Value("${spring.rabbitmq.queues.notification.routing-key}")
    private String notificationQueueRoutingKey;

    @Value("${spring.rabbitmq.queues.notification.exchange}")
    private String notificationQueueExchange;

    @Value("${spring.rabbitmq.queues.finance.name}")
    private String financeQueueName;

    @Value("${spring.rabbitmq.queues.finance.durable}")
    private boolean financeQueueDurable;

    @Value("${spring.rabbitmq.queues.finance.routing-key}")
    private String financeQueueRoutingKey;

    @Value("${spring.rabbitmq.queues.finance.exchange}")
    private String financeQueueExchange;

    @Value("${spring.rabbitmq.queues.log.name}")
    private String logQueueName;

    @Value("${spring.rabbitmq.queues.log.durable}")
    private boolean logQueueDurable;

    @Value("${spring.rabbitmq.queues.log.routing-key}")
    private String logQueueRoutingKey;

    @Value("${spring.rabbitmq.queues.log.exchange}")
    private String logQueueExchange;

    @Bean
    DirectExchange notificationDirectExchange() {
        return new DirectExchange(notificationQueueExchange);
    }

    @Bean
    DirectExchange financeDirectExchange() {
        return new DirectExchange(financeQueueExchange);
    }

    @Bean
    DirectExchange logDirectExchange() {
        return new DirectExchange(logQueueExchange);
    }

    @Bean
    Queue notificationQueue() {
        return new Queue(notificationQueueName, notificationQueueDurable);
    }

    @Bean
    Queue financeQueue() {
        return new Queue(financeQueueName, financeQueueDurable);
    }

    @Bean
    Queue logQueue() {
        return new Queue(logQueueName, logQueueDurable);
    }

    @Bean
    Binding notificationBinding(Queue notificationQueue, DirectExchange notificationDirectExchange) {
        return BindingBuilder.bind(notificationQueue).to(notificationDirectExchange).with(notificationQueueRoutingKey);
    }

    @Bean
    Binding financeBinding(Queue financeQueue, DirectExchange financeDirectExchange) {
        return BindingBuilder.bind(financeQueue).to(financeDirectExchange).with(financeQueueRoutingKey);
    }

    @Bean
    Binding logBinding(Queue logQueue, DirectExchange logDirectExchange) {
        return BindingBuilder.bind(logQueue).to(logDirectExchange).with(logQueueRoutingKey);
    }

    **/
}
