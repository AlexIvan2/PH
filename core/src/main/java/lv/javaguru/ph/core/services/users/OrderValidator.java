package lv.javaguru.ph.core.services.users;

import java.util.Date;

public interface OrderValidator {

    void validate(String msisdn, String routingNumber, Date activationDate);

    void validateNoMsisdn(String routingNumber, Date activationDate);

}
