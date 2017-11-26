package lv.javaguru.ph.app.jms;

import lv.javaguru.ph.core.api.jms.JMSResponse;
import org.springframework.http.ResponseEntity;

public interface JMSResponseHandler {

    String getSupportedCommandId();

    default boolean canProcess(JMSResponse response) {
        return response.getCommandId().equals(getSupportedCommandId());
    }

    ResponseEntity process(JMSResponse jmsResponse);

}
