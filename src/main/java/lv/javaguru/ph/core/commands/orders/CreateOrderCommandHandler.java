package lv.javaguru.ph.core.commands.orders;

import lv.javaguru.ph.core.domain.Order;
import lv.javaguru.ph.integrations.rest.dto.OrderDTO;
import lv.javaguru.ph.core.services.DomainCommandHandler;
import lv.javaguru.ph.core.services.orders.OrderFactory;
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
