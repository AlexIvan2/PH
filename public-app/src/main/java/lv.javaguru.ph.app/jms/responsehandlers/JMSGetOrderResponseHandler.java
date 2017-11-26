package lv.javaguru.ph.app.jms.responsehandlers;

import lv.javaguru.ph.app.common.JsonMapper;
import lv.javaguru.ph.app.jms.JMSResponseHandler;
import lv.javaguru.ph.core.api.jms.JMSResponse;
import lv.javaguru.ph.core.api.jms.SupportedCommandId;
import lv.javaguru.ph.core.api.jms.requests.orders.JMSGetOrderByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
class JMSGetOrderResponseHandler implements JMSResponseHandler {

    @Autowired private JsonMapper jsonMapper;

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.GET_ORDER_BY_ID;
    }

    @Override
    public ResponseEntity process(JMSResponse jmsResponse) {
        String payload = jmsResponse.getPayload();
        JMSGetOrderByIdResponse response = jsonMapper.mapToObject(
                payload, JMSGetOrderByIdResponse.class
        );
        return ResponseEntity.ok(response.getOrderDTO());
    }

}
