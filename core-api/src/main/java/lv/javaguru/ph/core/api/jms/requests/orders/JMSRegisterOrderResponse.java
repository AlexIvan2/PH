package lv.javaguru.ph.core.api.jms.requests.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.javaguru.ph.common.dtos.OrderDTO;

public class JMSRegisterOrderResponse {

    @JsonProperty("order")
    private OrderDTO orderDTO;


    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }
}
