package lv.javaguru.ph.core.commands.orders;


import lv.javaguru.ph.core.api.DomainCommandResult;

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
