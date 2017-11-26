package lv.javaguru.ph.core.handlers.orders;

import lv.javaguru.ph.common.dtos.OrderDTO;
import lv.javaguru.ph.core.commands.orders.RegisterOrderCommand;
import lv.javaguru.ph.core.commands.orders.RegisterOrderResult;
import lv.javaguru.ph.core.domain.Order;
import lv.javaguru.ph.core.handlers.DomainCommandHandler;
import lv.javaguru.ph.core.services.orders.OrderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class RegisterOrderCommandHandler
		implements DomainCommandHandler<RegisterOrderCommand, RegisterOrderResult> {

	@Autowired private OrderFactory orderFactory;
	@Autowired private OrderConverter orderConverter;


	@Override
	public RegisterOrderResult execute(RegisterOrderCommand command) {
		Order order = orderFactory.create(
				command.getOrderDTO().getMsisdn(),
				command.getOrderDTO().getRoutingNumber(),
				command.getOrderDTO().getActivationDate()
		);
		OrderDTO orderDTO = orderConverter.convert(order);
		return new RegisterOrderResult(orderDTO);
	}

	@Override
	public Class getCommandType() {
		return RegisterOrderCommand.class;
	}
	
}
