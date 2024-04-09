package org.wz.exercises.header.first;

/**
 * 位置重复涉及 Exception
 * @author wangzhi
 */
public class LocationAlreadyHitException extends RuntimeException {

    public LocationAlreadyHitException(String msg) {
        super(msg);
    }
}
