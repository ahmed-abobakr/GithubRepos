package com.andlausy.githubrepos.base.exceptions;

public class ValidationsException extends Exception {

    private Type type;

    public ValidationsException(Type type){
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public enum Type {INVALID_EMAIL_EXCEPTION, INVALID_PASSWORD_EXCEPTION, LIMIT_PASSWORD_LIMIT, EMAIL_MANDATORY_EXCEPTION, PASSWORD_MANDATORY_EXCEPTION,
                NAME_MANDATORY_EXCEPTION, MOBILE_MANDATORY_EXCEPTION, INVALID_MOBILE_LIMIT, COUNTRY_MANDATORY_EXCEPTION,
                MARKET_MANDATORY_EXCEPTION}
}
