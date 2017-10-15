package lv.javaguru.ph.core.services.orders;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class OrderValidatorImplTest {

    private OrderValidator validator = new OrderValidatorImpl();

    private static final String MSISDN = "37112345678";
    private static final String ROUTINGNUMBER = "12325";
    private static final Date ACTIVATIONDATE = null;


    @Test
    public void validateShouldFailIfMsisdnIsNull() {
        validateShouldFail(null, ROUTINGNUMBER, ACTIVATIONDATE, "Order msisdn must not be null");
    }

    @Test
    public void validateShouldFailIfRoutingNumberIsNull() {
        validateShouldFail(MSISDN, null, ACTIVATIONDATE, "Client password must not be null");
    }

    @Test
    public void validateShouldFailIfMsisdnIsEmpty() {
        validateShouldFail("", ROUTINGNUMBER, ACTIVATIONDATE, "Client login must not be empty");
    }

    @Test
    public void validateShouldFailIfRoutingNumberIsEmpty() {
        validateShouldFail(MSISDN, "", ACTIVATIONDATE,"Client password must not be empty");
    }

    private void validateShouldFail(String msisdn,
                                    String routingNumber,
                                    Date activationDate,
                                    String errorMessage) {
        try {
            validator.validate(msisdn, routingNumber, activationDate);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is(errorMessage));
        }
    }

}
