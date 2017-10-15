package lv.javaguru.ph.core.commands.orders;

import lv.javaguru.ph.core.commands.DomainCommandResult;
import lv.javaguru.ph.integrations.rest.dto.OrderDTO;

public class CreateOrderResult implements DomainCommandResult {

	private OrderDTO order;

	public CreateOrderResult(OrderDTO order) {
		this.order = order;
	}

	public OrderDTO getOrder() {
		return order;
	}

}
