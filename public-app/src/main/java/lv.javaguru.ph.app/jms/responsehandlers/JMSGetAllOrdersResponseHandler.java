package lv.javaguru.ph.app.jms.responsehandlers;

import lv.javaguru.ph.app.common.JsonMapper;
import lv.javaguru.ph.app.jms.JMSResponseHandler;
import lv.javaguru.ph.core.api.jms.JMSResponse;
import lv.javaguru.ph.core.api.jms.SupportedCommandId;
import lv.javaguru.ph.core.api.jms.requests.orders.JMSGetOrdersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
class JMSGetAllOrdersResponseHandler implements JMSResponseHandler {

    @Autowired private JsonMapper jsonMapper;

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.GET_ALL_ORDERS;
    }

    @Override
    public ResponseEntity process(JMSResponse jmsResponse) {
        String payload = jmsResponse.getPayload();
        JMSGetOrdersResponse response = jsonMapper.mapToObject(
                payload, JMSGetOrdersResponse.class
        );
        return ResponseEntity.ok(response.getOrders());
    }

}
