package ai.ecma.consumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 7/5/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO implements Serializable {
    private Long paymentId;
    private String paymentType;
    private String paymentStatus;
    private Double paymentAmount;
    private String paymentCurrency;
    private LocalDateTime paymentCreatedAt;
}
