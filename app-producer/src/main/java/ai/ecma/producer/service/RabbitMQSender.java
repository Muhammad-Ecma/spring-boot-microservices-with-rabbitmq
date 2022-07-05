package ai.ecma.producer.service;

import ai.ecma.producer.model.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Author: Mak Sophea
 * Date: 07/31/2020
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitMQSender {
    private final RabbitTemplate rabbitTemplate;


    @Value("${spring.rabbitmq.queues.default.name}")
    private String defaultQueueName;

    @Value("${spring.rabbitmq.queues.default.durable}")
    private boolean defaultQueueDurable;

    @Value("${spring.rabbitmq.queues.default.routing-key}")
    private String defaultQueueRoutingKey;

    @Value("${spring.rabbitmq.queues.default.exchange}")
    private String defaultQueueExchange;

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

    public void send(String exchange, String routingKey, Payment payment) {
        log.info("Start queueing: Exchange = {}, RoutingKey = {}, Payment = {}", exchange, routingKey, payment.getPaymentId());

        rabbitTemplate.convertAndSend(exchange, routingKey, payment);

        log.info("End queueing: Exchange = {}, RoutingKey = {}, Payment = {}", exchange, routingKey, payment.getPaymentId());
    }

    public void send(Payment payment) {
        this.send(defaultQueueExchange, defaultQueueRoutingKey, payment);
    }

    public void sendToFinance(Payment payment) {
        this.send(financeQueueExchange, financeQueueRoutingKey, payment);
    }

}
