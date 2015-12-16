package org.inaetics.ails.api.client.exceptions;

/**
 * This exception represents the unavailability of the server.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 09-12-2015
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
