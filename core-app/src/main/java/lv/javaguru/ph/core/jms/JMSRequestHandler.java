package lv.javaguru.ph.core.jms;

import lv.javaguru.ph.core.api.jms.JMSRequest;
import lv.javaguru.ph.core.commands.DomainCommand;
import lv.javaguru.ph.core.commands.DomainCommandResult;
import lv.javaguru.ph.core.commons.JsonMapper;
import lv.javaguru.ph.core.services.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class JMSRequestHandler {

    @Autowired protected JsonMapper jsonMapper;
    @Autowired protected CommandExecutor commandExecutor;


    public abstract String getSupportedCommandId();

    protected boolean canProcess(JMSRequest request) {
        return request.getCommandId().equals(getSupportedCommandId());
    }

    public abstract String process(JMSRequest request);

    public <T> T mapRequest(JMSRequest request, Class<T> clazz) {
        String payload = request.getPayload();
        return jsonMapper.mapToObject(payload, clazz);
    }

    protected <C extends DomainCommand<T>, T extends DomainCommandResult> T executeCoreCommand(DomainCommand<T> coreCommand) {
        return commandExecutor.execute(coreCommand);
    }

    protected String buildPayload(Object jmsResponse) {
        return jsonMapper.mapToString(jmsResponse);
    }

}
