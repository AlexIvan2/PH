package lv.javaguru.ph.core.jms.handlers;

import lv.javaguru.ph.core.api.jms.JMSRequest;
import lv.javaguru.ph.core.api.jms.SupportedCommandId;

import lv.javaguru.ph.core.api.jms.requests.orders.JMSGetAllOrdersRequest;
import lv.javaguru.ph.core.api.jms.requests.orders.JMSGetAllOrdersResponse;
import lv.javaguru.ph.core.commands.orders.GetAllOrdersCommand;
import lv.javaguru.ph.core.commands.orders.GetAllOrdersResult;
import lv.javaguru.ph.core.jms.JMSRequestHandler;
import org.springframework.stereotype.Component;

@Component
class JMSGetAllOrdersRequestHandler extends JMSRequestHandler {

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.GET_ALL_ORDERS;
    }

    @Override
    public String process(JMSRequest request) {
        JMSGetAllOrdersRequest jmsCommand = mapRequest(request, JMSGetAllOrdersRequest.class);

        GetAllOrdersCommand coreCommand = new GetAllOrdersCommand(jmsCommand.getOrderDetails());
        GetAllOrdersResult coreResult = executeCoreCommand(coreCommand);

        JMSGetAllOrdersResponse jmsResponse = new JMSGetAllOrdersResponse();
        jmsResponse.setOrderDTO(coreResult.getAllOrders());
        return buildPayload(jmsResponse);
    }

}
