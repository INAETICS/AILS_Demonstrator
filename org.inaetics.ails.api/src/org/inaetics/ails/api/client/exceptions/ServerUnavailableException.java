package org.inaetics.ails.api.client.exceptions;

/**
 * Created by nicokorthout on 09/12/15.
 */
public class ServerUnavailableException extends Exception {

    private static final long serialVersionUID = 1L;

    public ServerUnavailableException() {
        super();
    }

    public ServerUnavailableException(String detailMessage) {
        super(detailMessage);
    }

    public ServerUnavailableException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public ServerUnavailableException(Throwable throwable) {
        super(throwable);
    }
}
