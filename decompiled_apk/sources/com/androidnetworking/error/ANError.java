package com.androidnetworking.error;

import com.androidnetworking.common.ANConstants;
import com.androidnetworking.utils.ParseUtil;
import okhttp3.Response;

/* loaded from: classes.dex */
public class ANError extends Exception {
    private String errorBody;
    private int errorCode;
    private String errorDetail;
    private Response response;

    public ANError() {
        this.errorCode = 0;
    }

    public <T> T getErrorAsObject(Class<T> cls) {
        try {
            return (T) ParseUtil.getParserFactory().getObject(this.errorBody, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getErrorBody() {
        return this.errorBody;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorDetail() {
        return this.errorDetail;
    }

    public Response getResponse() {
        return this.response;
    }

    public void setCancellationMessageInError() {
        this.errorDetail = ANConstants.REQUEST_CANCELLED_ERROR;
    }

    public void setErrorBody(String str) {
        this.errorBody = str;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setErrorDetail(String str) {
        this.errorDetail = str;
    }

    public ANError(Response response) {
        this.errorCode = 0;
        this.response = response;
    }

    public ANError(String str) {
        super(str);
        this.errorCode = 0;
    }

    public ANError(String str, Response response) {
        super(str);
        this.errorCode = 0;
        this.response = response;
    }

    public ANError(String str, Throwable th) {
        super(str, th);
        this.errorCode = 0;
    }

    public ANError(String str, Response response, Throwable th) {
        super(str, th);
        this.errorCode = 0;
        this.response = response;
    }

    public ANError(Response response, Throwable th) {
        super(th);
        this.errorCode = 0;
        this.response = response;
    }

    public ANError(Throwable th) {
        super(th);
        this.errorCode = 0;
    }
}
