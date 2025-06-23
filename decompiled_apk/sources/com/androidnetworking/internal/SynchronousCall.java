package com.androidnetworking.internal;

import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.androidnetworking.common.ResponseType;
import com.androidnetworking.error.ANError;
import com.androidnetworking.utils.SourceCloseUtil;
import com.androidnetworking.utils.Utils;
import okhttp3.Response;

/* loaded from: classes.dex */
public final class SynchronousCall {
    private SynchronousCall() {
    }

    public static <T> ANResponse<T> execute(ANRequest aNRequest) {
        int requestType = aNRequest.getRequestType();
        if (requestType != 0) {
            if (requestType != 1) {
                if (requestType != 2) {
                    return new ANResponse<>(new ANError());
                }
                return executeUploadRequest(aNRequest);
            }
            return executeDownloadRequest(aNRequest);
        }
        return executeSimpleRequest(aNRequest);
    }

    private static <T> ANResponse<T> executeDownloadRequest(ANRequest aNRequest) {
        try {
            Response performDownloadRequest = InternalNetworking.performDownloadRequest(aNRequest);
            if (performDownloadRequest == null) {
                return new ANResponse<>(Utils.getErrorForConnection(new ANError()));
            }
            if (performDownloadRequest.code() >= 400) {
                ANResponse<T> aNResponse = new ANResponse<>(Utils.getErrorForServerResponse(new ANError(performDownloadRequest), aNRequest, performDownloadRequest.code()));
                aNResponse.setOkHttpResponse(performDownloadRequest);
                return aNResponse;
            }
            ANResponse<T> aNResponse2 = new ANResponse<>("success");
            aNResponse2.setOkHttpResponse(performDownloadRequest);
            return aNResponse2;
        } catch (ANError e) {
            return new ANResponse<>(Utils.getErrorForConnection(new ANError(e)));
        } catch (Exception e2) {
            return new ANResponse<>(Utils.getErrorForConnection(new ANError(e2)));
        }
    }

    private static <T> ANResponse<T> executeSimpleRequest(ANRequest aNRequest) {
        try {
            try {
                Response performSimpleRequest = InternalNetworking.performSimpleRequest(aNRequest);
                if (performSimpleRequest == null) {
                    ANResponse<T> aNResponse = new ANResponse<>(Utils.getErrorForConnection(new ANError()));
                    SourceCloseUtil.close(performSimpleRequest, aNRequest);
                    return aNResponse;
                }
                if (aNRequest.getResponseAs() == ResponseType.OK_HTTP_RESPONSE) {
                    ANResponse<T> aNResponse2 = new ANResponse<>(performSimpleRequest);
                    aNResponse2.setOkHttpResponse(performSimpleRequest);
                    SourceCloseUtil.close(performSimpleRequest, aNRequest);
                    return aNResponse2;
                }
                if (performSimpleRequest.code() >= 400) {
                    ANResponse<T> aNResponse3 = new ANResponse<>(Utils.getErrorForServerResponse(new ANError(performSimpleRequest), aNRequest, performSimpleRequest.code()));
                    aNResponse3.setOkHttpResponse(performSimpleRequest);
                    SourceCloseUtil.close(performSimpleRequest, aNRequest);
                    return aNResponse3;
                }
                ANResponse<T> parseResponse = aNRequest.parseResponse(performSimpleRequest);
                parseResponse.setOkHttpResponse(performSimpleRequest);
                SourceCloseUtil.close(performSimpleRequest, aNRequest);
                return parseResponse;
            } catch (ANError e) {
                ANResponse<T> aNResponse4 = new ANResponse<>(Utils.getErrorForConnection(new ANError(e)));
                SourceCloseUtil.close(null, aNRequest);
                return aNResponse4;
            } catch (Exception e2) {
                ANResponse<T> aNResponse5 = new ANResponse<>(Utils.getErrorForConnection(new ANError(e2)));
                SourceCloseUtil.close(null, aNRequest);
                return aNResponse5;
            }
        } catch (Throwable th) {
            SourceCloseUtil.close(null, aNRequest);
            throw th;
        }
    }

    private static <T> ANResponse<T> executeUploadRequest(ANRequest aNRequest) {
        try {
            try {
                Response performUploadRequest = InternalNetworking.performUploadRequest(aNRequest);
                if (performUploadRequest == null) {
                    ANResponse<T> aNResponse = new ANResponse<>(Utils.getErrorForConnection(new ANError()));
                    SourceCloseUtil.close(performUploadRequest, aNRequest);
                    return aNResponse;
                }
                if (aNRequest.getResponseAs() == ResponseType.OK_HTTP_RESPONSE) {
                    ANResponse<T> aNResponse2 = new ANResponse<>(performUploadRequest);
                    aNResponse2.setOkHttpResponse(performUploadRequest);
                    SourceCloseUtil.close(performUploadRequest, aNRequest);
                    return aNResponse2;
                }
                if (performUploadRequest.code() >= 400) {
                    ANResponse<T> aNResponse3 = new ANResponse<>(Utils.getErrorForServerResponse(new ANError(performUploadRequest), aNRequest, performUploadRequest.code()));
                    aNResponse3.setOkHttpResponse(performUploadRequest);
                    SourceCloseUtil.close(performUploadRequest, aNRequest);
                    return aNResponse3;
                }
                ANResponse<T> parseResponse = aNRequest.parseResponse(performUploadRequest);
                parseResponse.setOkHttpResponse(performUploadRequest);
                SourceCloseUtil.close(performUploadRequest, aNRequest);
                return parseResponse;
            } catch (ANError e) {
                ANResponse<T> aNResponse4 = new ANResponse<>(Utils.getErrorForConnection(e));
                SourceCloseUtil.close(null, aNRequest);
                return aNResponse4;
            } catch (Exception e2) {
                ANResponse<T> aNResponse5 = new ANResponse<>(Utils.getErrorForConnection(new ANError(e2)));
                SourceCloseUtil.close(null, aNRequest);
                return aNResponse5;
            }
        } catch (Throwable th) {
            SourceCloseUtil.close(null, aNRequest);
            throw th;
        }
    }
}
