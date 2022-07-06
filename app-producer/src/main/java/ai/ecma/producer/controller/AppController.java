package ai.ecma.producer.controller;

import ai.ecma.producer.model.Payment;
import ai.ecma.producer.service.RabbitMQSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 7/5/2022
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/rabbitmq")
@RequiredArgsConstructor
public class AppController {
    private final RabbitMQSender rabbitMQSender;

    /**
     * Queuing message to RabbitMQ by Direct Exchange
     *
     * @param payment - the message to be queued
     * @return response message
     */
    @PostMapping(value = "/direct-exchange")
    public String directExchange(@RequestBody Payment payment) {
        rabbitMQSender.send(payment);
        return "Message sent to the RabbitMQ Successfully";
    }

}
