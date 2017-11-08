package lv.javaguru.ph.core.handlers.orders;

import lv.javaguru.ph.common.dtos.OrderDTO;
import lv.javaguru.ph.core.api.orders.CreateOrderCommand;
import lv.javaguru.ph.core.api.orders.CreateOrderResult;
import lv.javaguru.ph.core.domain.Order;
import lv.javaguru.ph.core.handlers.DomainCommandHandler;
import lv.javaguru.ph.core.services.users.OrderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class CreateOrderCommandHandler
		implements DomainCommandHandler<CreateOrderCommand, CreateOrderResult> {

	@Autowired private OrderFactory orderFactory;
	@Autowired private OrderConverter orderConverter;


	@Override
	public CreateOrderResult execute(CreateOrderCommand command) {
		Order order = orderFactory.create(
				command.getMsisdn(),
				command.getRoutingNumber(),
				command.getActivationDate()
		);
		OrderDTO orderDTO = orderConverter.convert(order);
		return new CreateOrderResult(orderDTO);
	}

	@Override
	public Class getCommandType() {
		return CreateOrderCommand.class;
	}
	
}
