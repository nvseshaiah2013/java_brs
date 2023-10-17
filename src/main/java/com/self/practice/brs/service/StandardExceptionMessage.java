package com.self.practice.brs.service;

import com.self.practice.brs.exception.BRSException;
import com.self.practice.brs.exception.EntityType;
import com.self.practice.brs.exception.ExceptionType;

public interface StandardExceptionMessage {

    /**
     * Returns a exception in standardFormat
     *
     * @param entityType type of Entity being referred
     * @param exceptionType type of the Exception to be thrown
     * @param args Arguments
     * @return {@link RuntimeException}
     */
    default RuntimeException exception(EntityType entityType, ExceptionType exceptionType, String ...args) {
        return BRSException.throwException(entityType, exceptionType, args);
    }
}
