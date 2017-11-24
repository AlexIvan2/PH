package lv.javaguru.ph.core.api.jms.requests.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.javaguru.ph.common.dtos.OrderDTO;

public class JMSGetAllOrdersResponse {

    @JsonProperty("order")
    private OrderDTO OrderDTO;


    public OrderDTO getOrderDTO() {
        return OrderDTO;
    }

    public void setOrderDTO(OrderDTO userDTO) {
        this.OrderDTO = OrderDTO;
    }

}
