package com.alimm.tanx.core.net.okhttp.tanxc_if;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* loaded from: classes.dex */
public class tanxc_do implements Interceptor {
    private RequestBody tanxc_do(final RequestBody requestBody) {
        return new RequestBody() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_do.1
            @Override // okhttp3.RequestBody
            public long contentLength() {
                return -1L;
            }

            @Override // okhttp3.RequestBody
            public MediaType contentType() {
                return requestBody.contentType();
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                BufferedSink buffer = Okio.buffer(new GzipSink(bufferedSink));
                requestBody.writeTo(buffer);
                buffer.close();
            }
        };
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (request.body() != null && request.header("Content-Encoding") == null) {
            return chain.proceed(request.newBuilder().method(request.method(), tanxc_do(request.body())).build());
        }
        return chain.proceed(request);
    }
}
