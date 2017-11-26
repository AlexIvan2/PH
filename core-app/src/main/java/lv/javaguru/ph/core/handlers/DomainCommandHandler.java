package lv.javaguru.ph.core.handlers;

public interface DomainCommandHandler<C, R> {

    R execute(C command);

    Class getCommandType();

}
