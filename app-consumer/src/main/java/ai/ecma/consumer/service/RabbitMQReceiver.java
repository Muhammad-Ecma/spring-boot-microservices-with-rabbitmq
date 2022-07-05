package ai.ecma.consumer.service;

import ai.ecma.consumer.model.PaymentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Author: Mak Sophea
 * Date: 07/31/2020
 */
@Component
@Slf4j
public class RabbitMQReceiver {

    @RabbitListener(queues = "${spring.rabbitmq.queues.default.name}")
    public void receivedMessage(PaymentDTO paymentDTO) {
        log.info("Receive Message: Payment = {}", paymentDTO);
    }
}
