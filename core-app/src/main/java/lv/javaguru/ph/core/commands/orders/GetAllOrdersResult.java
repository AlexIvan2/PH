package lv.javaguru.ph.core.api.orders;


import lv.javaguru.ph.common.dtos.OrderDTO;
import lv.javaguru.ph.core.api.DomainCommandResult;

import java.util.List;

public class GetAllOrdersResult implements DomainCommandResult {

    private List<OrderDTO> orders;

    public GetAllOrdersResult(List<OrderDTO> orders) {
        this.orders = orders;
    }

    public List<OrderDTO> getAllOrders() {
        return orders;
    }

}
