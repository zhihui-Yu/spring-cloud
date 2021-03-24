package cloudalibaba.service;

import org.springframework.stereotype.Component;

/**
 * @author simple
 */
@Component
public class PaymentExceptionHandlerService implements PaymentService {
    @Override
    public String get() {
        return "handler method";
    }
}
