package lv.javaguru.ph.core.api.orders;


import lv.javaguru.ph.core.api.DomainCommand;

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
