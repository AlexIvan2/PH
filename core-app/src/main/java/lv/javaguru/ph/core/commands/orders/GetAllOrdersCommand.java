package lv.javaguru.ph.core.commands.orders;


import lv.javaguru.ph.core.commands.DomainCommand;

public class GetAllOrdersCommand implements DomainCommand<GetAllOrdersResult> {

    private String msisdn = "";

    public GetAllOrdersCommand() {
    }

    public GetAllOrdersCommand(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMsisdn() {
        return msisdn;
    }
}
