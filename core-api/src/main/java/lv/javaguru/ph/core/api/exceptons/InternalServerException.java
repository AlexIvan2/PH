package lv.javaguru.ph.core.api.exceptons;

import lv.javaguru.ph.core.api.common.ResponseStatus;

public class InternalServerException extends ApplicationException {

    public InternalServerException() {
        super(ResponseStatus.INTERNAL_SERVER_ERROR);
    }
}
