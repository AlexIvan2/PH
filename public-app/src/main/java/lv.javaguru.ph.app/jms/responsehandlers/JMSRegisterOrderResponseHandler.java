package lv.javaguru.ph.app.jms.responsehandlers;

import lv.javaguru.ph.app.common.JsonMapper;
import lv.javaguru.ph.app.jms.JMSResponseHandler;
import lv.javaguru.ph.core.api.jms.JMSResponse;
import lv.javaguru.ph.core.api.jms.SupportedCommandId;
import lv.javaguru.ph.core.api.jms.requests.orders.JMSRegisterOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
class JMSRegisterOrderResponseHandler implements JMSResponseHandler {

    @Autowired private JsonMapper jsonMapper;

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.REGISTER_ORDER;
    }

    @Override
    public ResponseEntity process(JMSResponse jmsResponse) {
        String payload = jmsResponse.getPayload();
        JMSRegisterOrderResponse response = jsonMapper.mapToObject(
                payload, JMSRegisterOrderResponse.class
        );
        return ResponseEntity.ok(response.getOrderDTO());
    }

}
