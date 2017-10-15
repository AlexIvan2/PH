package lv.javaguru.ph.core.services.orders;

import org.springframework.stereotype.Component;

import java.util.Date;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang.StringUtils.isBlank;

@Component
class OrderValidatorImpl implements OrderValidator {

    @Override
    public void validate(String msisdn, String routingNumber, Date activationDate) {
        validateMsisdn(msisdn);
        validateRoutingNumber(routingNumber);
        validateActivationDate(activationDate);
    }

    private void validateMsisdn(String msisdn) {
        checkNotNull(msisdn, "Order msisdn must not be null");
        checkArgument(!isBlank(msisdn), "Order msisdn must not be empty");
    }

    private void validateRoutingNumber(String routingNumber) {
        checkNotNull(routingNumber, "Order routingNumber must not be null");
        checkArgument(!isBlank(routingNumber), "Order routingNumber must not be empty");
    }

    private void validateActivationDate(Date activationDate) {
        //TODO: Date validation
    }

}
