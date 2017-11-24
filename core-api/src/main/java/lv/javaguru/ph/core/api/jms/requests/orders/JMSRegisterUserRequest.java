package lv.javaguru.ph.core.api.jms.requests.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.javaguru.ph.common.dtos.OrderDTO;
import lv.javaguru.ph.core.api.jms.SupportedCommandId;
import lv.javaguru.ph.core.api.jms.requests.JMSAPIRequest;

public class JMSRegisterUserRequest implements JMSAPIRequest {

    @JsonProperty("order")
    private OrderDTO orderDTO;


    @Override
    public String getCommandId() {
        return SupportedCommandId.REGISTER_ORDER;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setUserDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }
}
