package lv.javaguru.ph.core.commands.orders;


public class UndoOrderCommand {

    private String msisdn;

    public UndoOrderCommand(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMsisdn() {
        return msisdn;
    }
}
