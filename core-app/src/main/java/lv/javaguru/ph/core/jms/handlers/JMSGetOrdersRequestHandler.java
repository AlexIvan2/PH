package lv.javaguru.ph.core.jms.handlers;

import lv.javaguru.ph.core.api.jms.JMSRequest;
import lv.javaguru.ph.core.api.jms.SupportedCommandId;
import lv.javaguru.ph.core.api.jms.requests.orders.JMSGetOrdersByMsisdnRequest;
import lv.javaguru.ph.core.api.jms.requests.orders.JMSGetOrdersResponse;
import lv.javaguru.ph.core.commands.orders.GetAllOrdersCommand;
import lv.javaguru.ph.core.commands.orders.GetAllOrdersResult;
import lv.javaguru.ph.core.jms.JMSRequestHandler;
import org.springframework.stereotype.Component;

@Component
class JMSGetOrdersRequestHandler extends JMSRequestHandler {

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.GET_ALL_ORDERS;
    }

    @Override
    public String process(JMSRequest request) {
        JMSGetOrdersByMsisdnRequest jmsCommand = mapRequest(request, JMSGetOrdersByMsisdnRequest.class);

        GetAllOrdersCommand coreCommand = new GetAllOrdersCommand();
        GetAllOrdersResult coreResult = executeCoreCommand(coreCommand);

        JMSGetOrdersResponse jmsResponse = new JMSGetOrdersResponse();
        jmsResponse.setOrders(coreResult.getAllOrders());
        return buildPayload(jmsResponse);
    }

}
