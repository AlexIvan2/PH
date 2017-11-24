package lv.javaguru.ph.core.api.jms.requests.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.javaguru.ph.core.api.jms.SupportedCommandId;
import lv.javaguru.ph.core.api.jms.requests.JMSAPIRequest;

public class JMSGetAllOrdersRequest implements JMSAPIRequest {

    @JsonProperty("user_login")
    private String orderDetails;

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String getCommandId() {
        return SupportedCommandId.GET_ALL_ORDERS;
    }
}
