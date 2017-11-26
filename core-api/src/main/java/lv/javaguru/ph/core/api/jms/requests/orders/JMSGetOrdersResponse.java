package lv.javaguru.ph.core.api.jms.requests.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.javaguru.ph.common.dtos.OrderDTO;

import java.util.List;

public class JMSGetOrdersResponse {

    @JsonProperty("orders")
    private List<OrderDTO> orders;

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }
}
