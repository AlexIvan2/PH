package lv.javaguru.ph.core.api.orders;


import lv.javaguru.ph.common.dtos.OrderDTO;
import lv.javaguru.ph.core.api.DomainCommandResult;

public class CreateOrderResult implements DomainCommandResult {

	private OrderDTO order;

	public CreateOrderResult(OrderDTO order) {
		this.order = order;
	}

	public OrderDTO getOrder() {
		return order;
	}

}
