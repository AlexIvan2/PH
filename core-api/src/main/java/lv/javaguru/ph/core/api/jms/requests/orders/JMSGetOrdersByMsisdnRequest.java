package lv.javaguru.ph.core.api.jms.requests.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.javaguru.ph.core.api.jms.SupportedCommandId;
import lv.javaguru.ph.core.api.jms.requests.JMSAPIRequest;

public class JMSGetOrdersByMsisdnRequest implements JMSAPIRequest {

    @JsonProperty("msisdn")
    private String msisdn;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    @Override
    public String getCommandId() {
        return SupportedCommandId.GET_ORDER_BY_MSISDN;
    }
}
