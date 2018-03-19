package com.kaellah.data.error;

/**
 * @since 03/19/2018
 */

public class ApiException extends Exception {

    private int code;

    public ApiException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}