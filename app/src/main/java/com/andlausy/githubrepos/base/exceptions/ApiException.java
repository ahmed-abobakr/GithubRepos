package com.andlausy.githubrepos.base.exceptions;



public class ApiException extends Exception {
    private int resultCode;

    public ApiException(String errorMessage, int resultCode) {
        super(errorMessage);
        this.resultCode = resultCode;
    }

    public int getResultCode() {
        return resultCode;
    }
}