package com.kaellah.testuklonposts.util;

import android.content.Context;
import android.text.TextUtils;

import com.kaellah.data.error.ApiException;
import com.kaellah.testuklonposts.R;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import timber.log.Timber;

public class ExceptionHandler {

    public static String handleException(Context context, Throwable throwable) {
        Timber.w(throwable);

        if (context == null) return "";

        String message;

        if (throwable instanceof UnknownHostException ||
            throwable instanceof ConnectException) {
            return context.getString(R.string.error_internet_connection);
        } else if (throwable instanceof SocketTimeoutException) {
            return context.getString(R.string.error_internet_timeout);
        } else if (throwable instanceof ApiException) {
            ApiException apiException = (ApiException) throwable;
            switch (apiException.getCode()) {
                case 504: {
                    return context.getString(R.string.error_internet_connection);
                }
                case 401: {
                    return apiException.getMessage();
                }
                default: {
                    message = throwable.getMessage();
                }
            }
        } else {
            message = throwable.getMessage();
        }

        if (TextUtils.isEmpty(message)) {
            message = context.getString(R.string.error_undefined);
        }

        return message;
    }

}
