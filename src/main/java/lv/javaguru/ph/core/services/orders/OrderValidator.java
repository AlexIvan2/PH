package lv.javaguru.ph.core.services.orders;

import java.util.Date;

public interface OrderValidator {

    void validate(String msisdn, String routingNumber, Date activationDate);

}
