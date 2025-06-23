package com.androidnetworking.common;

import com.androidnetworking.error.ANError;
import okhttp3.Response;

/* loaded from: classes.dex */
public class ANResponse<T> {
    private final ANError mANError;
    private final T mResult;
    private Response response;

    public ANResponse(T t) {
        this.mResult = t;
        this.mANError = null;
    }

    public static <T> ANResponse<T> failed(ANError aNError) {
        return new ANResponse<>(aNError);
    }

    public static <T> ANResponse<T> success(T t) {
        return new ANResponse<>(t);
    }

    public ANError getError() {
        return this.mANError;
    }

    public Response getOkHttpResponse() {
        return this.response;
    }

    public T getResult() {
        return this.mResult;
    }

    public boolean isSuccess() {
        if (this.mANError == null) {
            return true;
        }
        return false;
    }

    public void setOkHttpResponse(Response response) {
        this.response = response;
    }

    public ANResponse(ANError aNError) {
        this.mResult = null;
        this.mANError = aNError;
    }
}
