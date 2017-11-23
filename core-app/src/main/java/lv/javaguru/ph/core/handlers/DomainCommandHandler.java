package lv.javaguru.ph.core.handlers;

import lv.javaguru.ph.core.api.DomainCommand;
import lv.javaguru.ph.core.api.DomainCommandResult;

public interface DomainCommandHandler<C extends DomainCommand, R extends DomainCommandResult> {

    R execute(C command);

    Class getCommandType();

}
