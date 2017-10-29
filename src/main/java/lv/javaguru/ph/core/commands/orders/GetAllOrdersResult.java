package lv.javaguru.ph.core.commands.orders;

import lv.javaguru.ph.core.commands.DomainCommandResult;
import lv.javaguru.ph.integrations.rest.dto.OrderDTO;

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
