package lv.javaguru.ph.core.services.users;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Component
class OrderValidatorImpl implements OrderValidator {

    @Override
    public void validate(String msisdn, String routingNumber, Date activationDate) {
        validateMsisdn(msisdn);
        validateRoutingNumber(routingNumber);
        validateActivationDate(activationDate);
    }

    @Override
    public void validateNoMsisdn(String routingNumber, Date activationDate) {
        validateRoutingNumber(routingNumber);
        validateActivationDate(activationDate);
    }

    private void validateMsisdn(String msisdn) {
        checkNotNull(msisdn, "Order msisdn must not be null");
        checkArgument(!StringUtils.isEmpty(msisdn), "Order msisdn must not be empty");
    }

    private void validateRoutingNumber(String routingNumber) {
        checkNotNull(routingNumber, "Order routingNumber must not be null");
        checkArgument(!StringUtils.isEmpty(routingNumber), "Order routingNumber must not be empty");
    }

    private void validateActivationDate(Date activationDate) {
        Date now = new Date();
        boolean valid = now.before(activationDate);
        checkArgument(valid, "Activation date should be in the future");
    }

}
