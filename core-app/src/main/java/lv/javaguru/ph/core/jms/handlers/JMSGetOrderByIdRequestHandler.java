package lv.javaguru.ph.core.jms.handlers;

import lv.javaguru.ph.core.api.jms.JMSRequest;
import lv.javaguru.ph.core.api.jms.SupportedCommandId;

import lv.javaguru.ph.core.api.jms.requests.orders.JMSGetOrderByIdRequest;
import lv.javaguru.ph.core.api.jms.requests.orders.JMSGetOrderByIdResponse;
import lv.javaguru.ph.core.commands.orders.GetAllOrdersCommand;
import lv.javaguru.ph.core.commands.orders.GetAllOrdersResult;
import lv.javaguru.ph.core.commands.orders.GetOrderCommand;
import lv.javaguru.ph.core.commands.orders.GetOrderResult;
import lv.javaguru.ph.core.jms.JMSRequestHandler;
import org.springframework.stereotype.Component;

@Component
class JMSGetOrderByIdRequestHandler extends JMSRequestHandler {

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.GET_ORDER_BY_ID;
    }

    @Override
    public String process(JMSRequest request) {
        JMSGetOrderByIdRequest jmsCommand = mapRequest(request, JMSGetOrderByIdRequest.class);

        GetOrderCommand coreCommand = new GetOrderCommand(jmsCommand.getOrderId());
        GetOrderResult coreResult = executeCoreCommand(coreCommand);

        JMSGetOrderByIdResponse jmsResponse = new JMSGetOrderByIdResponse();
        jmsResponse.setOrderDTO(coreResult.getOrder());
        return buildPayload(jmsResponse);
    }

}
