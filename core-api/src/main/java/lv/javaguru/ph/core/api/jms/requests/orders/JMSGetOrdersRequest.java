package lv.javaguru.ph.core.api.jms.requests.orders;

import lv.javaguru.ph.core.api.jms.SupportedCommandId;
import lv.javaguru.ph.core.api.jms.requests.JMSAPIRequest;

public class JMSGetOrdersRequest implements JMSAPIRequest {

    @Override
    public String getCommandId() {
        return SupportedCommandId.GET_ALL_ORDERS;
    }
}
