package lv.javaguru.ph.core.handlers;

import lv.javaguru.ph.core.commands.DomainCommand;
import lv.javaguru.ph.core.commands.DomainCommandResult;

public interface DomainCommandHandler<C extends DomainCommand, R extends DomainCommandResult> {

    R execute(C command);

    Class getCommandType();

}
