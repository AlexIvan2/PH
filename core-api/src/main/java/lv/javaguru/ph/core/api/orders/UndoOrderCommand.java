package lv.javaguru.ph.core.api.orders;


import lv.javaguru.ph.core.api.DomainCommand;

public class UndoOrderCommand implements DomainCommand<UndoOrderResult> {

    private String msisdn;

    public UndoOrderCommand(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMsisdn() {
        return msisdn;
    }
}
