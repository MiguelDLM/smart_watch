package com.androidnetworking.utils;

import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ResponseType;
import okhttp3.Response;

/* loaded from: classes.dex */
public final class SourceCloseUtil {
    private SourceCloseUtil() {
    }

    public static void close(Response response, ANRequest aNRequest) {
        if (aNRequest.getResponseAs() != ResponseType.OK_HTTP_RESPONSE && response != null && response.body() != null && response.body().source() != null) {
            try {
                response.body().source().close();
            } catch (Exception unused) {
            }
        }
    }
}
