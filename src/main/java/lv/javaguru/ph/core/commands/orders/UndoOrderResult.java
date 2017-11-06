package lv.javaguru.ph.core.commands.orders;

import lv.javaguru.ph.core.commands.DomainCommandResult;

public class UndoOrderResult implements DomainCommandResult {

    private String message;

    public UndoOrderResult() {
    }

    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }
}
