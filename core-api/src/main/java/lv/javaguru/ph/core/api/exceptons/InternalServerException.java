package lv.javaguru.ph.core.api.exceptons;

public class InternalServerException extends ApplicationException {

    public InternalServerException() {
        super(ResponseStatus.INTERNAL_SERVER_ERROR);
    }
}
