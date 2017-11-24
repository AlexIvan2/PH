package lv.javaguru.ph.core.services;

import lv.javaguru.ph.core.commands.DomainCommand;
import lv.javaguru.ph.core.commands.DomainCommandResult;

public interface CommandExecutor {

    <T extends DomainCommandResult> T execute(DomainCommand<T> domainCommand);

}
