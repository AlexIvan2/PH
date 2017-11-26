package lv.javaguru.ph.core.jms.handlers;

import lv.javaguru.ph.core.api.jms.JMSRequest;
import lv.javaguru.ph.core.api.jms.SupportedCommandId;
import lv.javaguru.ph.core.api.jms.requests.orders.JMSRegisterOrderRequest;
import lv.javaguru.ph.core.api.jms.requests.orders.JMSRegisterOrderResponse;
import lv.javaguru.ph.core.commands.orders.RegisterOrderCommand;
import lv.javaguru.ph.core.commands.orders.RegisterOrderResult;
import lv.javaguru.ph.core.jms.JMSRequestHandler;
import org.springframework.stereotype.Component;

@Component
class JMSRegisterOrderRequestHandler extends JMSRequestHandler {

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.REGISTER_ORDER;
    }

    @Override
    public String process(JMSRequest request) {
        JMSRegisterOrderRequest jmsCommand = mapRequest(request, JMSRegisterOrderRequest.class);

        RegisterOrderCommand coreCommand = new RegisterOrderCommand(jmsCommand.getOrderDTO());
        RegisterOrderResult coreResult = executeCoreCommand(coreCommand);

        JMSRegisterOrderResponse jmsResponse = new JMSRegisterOrderResponse();
        jmsResponse.setOrderDTO(coreResult.getOrder());
        return buildPayload(jmsResponse);
    }

}
