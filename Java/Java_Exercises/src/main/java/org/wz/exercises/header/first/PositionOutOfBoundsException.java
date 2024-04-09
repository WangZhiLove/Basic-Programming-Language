package org.wz.exercises.header.first;

/**
 * Exception thrown when a position is out of bounds.
 * @author wangzhi
 */
public class PositionOutOfBoundsException extends RuntimeException {

    public PositionOutOfBoundsException(String message) {
        super(message);
    }
}
