package org.wz.exercises.header.first;

public class PositionsDoOverlapException extends RuntimeException {

    public PositionsDoOverlapException(String message) {
        super(message);
    }

    public PositionsDoOverlapException(String message, Throwable cause) {
        super(message, cause);
    }

    public PositionsDoOverlapException(Throwable cause) {
        super(cause);
    }

    public PositionsDoOverlapException() {
        super();
    }
}
