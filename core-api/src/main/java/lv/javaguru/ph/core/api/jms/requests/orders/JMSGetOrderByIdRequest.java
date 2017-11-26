package lv.javaguru.ph.core.api.jms.requests.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.javaguru.ph.core.api.jms.SupportedCommandId;
import lv.javaguru.ph.core.api.jms.requests.JMSAPIRequest;

public class JMSGetOrderByIdRequest implements JMSAPIRequest {

    @JsonProperty("order_id")
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String getCommandId() {
        return SupportedCommandId.GET_ORDER_BY_ID;
    }
}
