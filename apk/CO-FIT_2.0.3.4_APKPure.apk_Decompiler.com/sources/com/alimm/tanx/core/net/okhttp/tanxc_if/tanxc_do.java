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
import okio.Sink;

public class tanxc_do implements Interceptor {
    private RequestBody tanxc_do(final RequestBody requestBody) {
        return new RequestBody() {
            public long contentLength() {
                return -1;
            }

            public MediaType contentType() {
                return requestBody.contentType();
            }

            public void writeTo(BufferedSink bufferedSink) throws IOException {
                BufferedSink buffer = Okio.buffer((Sink) new GzipSink(bufferedSink));
                requestBody.writeTo(buffer);
                buffer.close();
            }
        };
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (request.body() == null || request.header("Content-Encoding") != null) {
            return chain.proceed(request);
        }
        return chain.proceed(request.newBuilder().method(request.method(), tanxc_do(request.body())).build());
    }
}
