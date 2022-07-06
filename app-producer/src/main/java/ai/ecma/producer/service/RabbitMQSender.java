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

    @Value("${spring.rabbitmq.queues.default.routing-key}")
    private String defaultQueueRoutingKey;

    @Value("${spring.rabbitmq.queues.default.exchange}")
    private String defaultQueueExchange;

    public void send(String exchange, String routingKey, Payment payment) {
        log.info("Start queueing: Exchange = {}, RoutingKey = {}, Payment = {}", exchange, routingKey, payment.getPaymentId());

        rabbitTemplate.convertAndSend(exchange, routingKey, payment);

        log.info("End queueing: Exchange = {}, RoutingKey = {}, Payment = {}", exchange, routingKey, payment.getPaymentId());
    }

    public void send(Payment payment) {
        this.send(defaultQueueExchange, defaultQueueRoutingKey, payment);
    }
}
