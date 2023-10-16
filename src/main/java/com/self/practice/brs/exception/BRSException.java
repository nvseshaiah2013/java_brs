package com.self.practice.brs.exception;

import com.self.practice.brs.config.PropertiesConfig;

import javax.persistence.EntityNotFoundException;
import java.text.MessageFormat;
import java.util.Optional;

public class BRSException {

    private static PropertiesConfig propertiesConfig;

    public static RuntimeException throwException(String messageTemplate, String ...args) {
        return new RuntimeException();
    }

    private static String getMessageTemplate(EntityType entityType, ExceptionType exceptionType) {
        return entityType.name().concat(".").concat(exceptionType.getValue()).toLowerCase();
    }

    public static RuntimeException throwException(EntityType entityType, ExceptionType exceptionType, String... args) {
        String messageTemplate = getMessageTemplate(entityType, exceptionType);
        return throwException(exceptionType, messageTemplate, args);
    }

    public static RuntimeException throwExceptionWithTemplate(EntityType entityType, ExceptionType exceptionType, String messageTemplate, String... args) {
        return throwException(exceptionType, messageTemplate, args);
    }

    private static RuntimeException throwException(ExceptionType exceptionType, String messageTemplate, String... args) {
        if (ExceptionType.ENTITY_NOT_FOUND.equals(exceptionType)) {
            return new EntityNotFoundException(format(messageTemplate, args));
        } else if (ExceptionType.DUPLICATE_ENTITY.equals(exceptionType)) {
            return new DuplicateEntityException(format(messageTemplate, args));
        }
        return new RuntimeException(format(messageTemplate, args));
    }

    public static class DuplicateEntityException extends RuntimeException {
        public DuplicateEntityException(String message) {
            super(message);
        }
    }

    private static String format(String template, String ...args) {
       return Optional
                .ofNullable(propertiesConfig.getConfigValue(template))
               .map(value -> MessageFormat.format(value, (Object[]) args))
               .orElse(String.format(template, (Object[]) args));
    }
}
