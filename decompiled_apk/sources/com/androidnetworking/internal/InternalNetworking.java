package com.androidnetworking.internal;

import android.content.Context;
import android.net.TrafficStats;
import com.androidnetworking.common.ANConstants;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ConnectionClassManager;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.androidnetworking.interfaces.AnalyticsListener;
import com.androidnetworking.utils.Utils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: classes.dex */
public final class InternalNetworking {
    public static OkHttpClient sHttpClient = getClient();
    public static String sUserAgent = null;

    private InternalNetworking() {
    }

    public static void addHeadersToRequestBuilder(Request.Builder builder, ANRequest aNRequest) {
        if (aNRequest.getUserAgent() != null) {
            builder.addHeader("User-Agent", aNRequest.getUserAgent());
        } else {
            String str = sUserAgent;
            if (str != null) {
                aNRequest.setUserAgent(str);
                builder.addHeader("User-Agent", sUserAgent);
            }
        }
        Headers headers = aNRequest.getHeaders();
        if (headers != null) {
            builder.headers(headers);
            if (aNRequest.getUserAgent() != null && !headers.names().contains("User-Agent")) {
                builder.addHeader("User-Agent", aNRequest.getUserAgent());
            }
        }
    }

    public static void enableLogging(HttpLoggingInterceptor.Level level) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(level);
        sHttpClient = getClient().newBuilder().addInterceptor(httpLoggingInterceptor).build();
    }

    public static OkHttpClient getClient() {
        OkHttpClient okHttpClient = sHttpClient;
        if (okHttpClient == null) {
            return getDefaultClient();
        }
        return okHttpClient;
    }

    public static OkHttpClient getDefaultClient() {
        OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return newBuilder.connectTimeout(60L, timeUnit).readTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).build();
    }

    public static Response performDownloadRequest(final ANRequest aNRequest) throws ANError {
        OkHttpClient build;
        long contentLength;
        try {
            Request.Builder url = new Request.Builder().url(aNRequest.getUrl());
            addHeadersToRequestBuilder(url, aNRequest);
            Request.Builder builder = url.get();
            if (aNRequest.getCacheControl() != null) {
                builder.cacheControl(aNRequest.getCacheControl());
            }
            Request build2 = builder.build();
            if (aNRequest.getOkHttpClient() != null) {
                build = aNRequest.getOkHttpClient().newBuilder().cache(sHttpClient.cache()).addNetworkInterceptor(new Interceptor() { // from class: com.androidnetworking.internal.InternalNetworking.1
                    @Override // okhttp3.Interceptor
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        Response proceed = chain.proceed(chain.request());
                        return proceed.newBuilder().body(new ResponseProgressBody(proceed.body(), ANRequest.this.getDownloadProgressListener())).build();
                    }
                }).build();
            } else {
                build = sHttpClient.newBuilder().addNetworkInterceptor(new Interceptor() { // from class: com.androidnetworking.internal.InternalNetworking.2
                    @Override // okhttp3.Interceptor
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        Response proceed = chain.proceed(chain.request());
                        return proceed.newBuilder().body(new ResponseProgressBody(proceed.body(), ANRequest.this.getDownloadProgressListener())).build();
                    }
                }).build();
            }
            aNRequest.setCall(build.newCall(build2));
            long currentTimeMillis = System.currentTimeMillis();
            long totalRxBytes = TrafficStats.getTotalRxBytes();
            Response execute = aNRequest.getCall().execute();
            Utils.saveFile(execute, aNRequest.getDirPath(), aNRequest.getFileName());
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (execute.cacheResponse() == null) {
                long totalRxBytes2 = TrafficStats.getTotalRxBytes();
                if (totalRxBytes != -1 && totalRxBytes2 != -1) {
                    contentLength = totalRxBytes2 - totalRxBytes;
                    ConnectionClassManager.getInstance().updateBandwidth(contentLength, currentTimeMillis2);
                    Utils.sendAnalytics(aNRequest.getAnalyticsListener(), currentTimeMillis2, -1L, execute.body().contentLength(), false);
                }
                contentLength = execute.body().contentLength();
                ConnectionClassManager.getInstance().updateBandwidth(contentLength, currentTimeMillis2);
                Utils.sendAnalytics(aNRequest.getAnalyticsListener(), currentTimeMillis2, -1L, execute.body().contentLength(), false);
            } else if (aNRequest.getAnalyticsListener() != null) {
                Utils.sendAnalytics(aNRequest.getAnalyticsListener(), currentTimeMillis2, -1L, 0L, true);
            }
            return execute;
        } catch (IOException e) {
            try {
                File file = new File(aNRequest.getDirPath() + File.separator + aNRequest.getFileName());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            throw new ANError(e);
        }
    }

    public static Response performSimpleRequest(ANRequest aNRequest) throws ANError {
        long contentLength;
        try {
            Request.Builder url = new Request.Builder().url(aNRequest.getUrl());
            addHeadersToRequestBuilder(url, aNRequest);
            RequestBody requestBody = null;
            switch (aNRequest.getMethod()) {
                case 0:
                    url = url.get();
                    break;
                case 1:
                    requestBody = aNRequest.getRequestBody();
                    url = url.post(requestBody);
                    break;
                case 2:
                    requestBody = aNRequest.getRequestBody();
                    url = url.put(requestBody);
                    break;
                case 3:
                    requestBody = aNRequest.getRequestBody();
                    url = url.delete(requestBody);
                    break;
                case 4:
                    url = url.head();
                    break;
                case 5:
                    requestBody = aNRequest.getRequestBody();
                    url = url.patch(requestBody);
                    break;
                case 6:
                    url = url.method("OPTIONS", null);
                    break;
            }
            if (aNRequest.getCacheControl() != null) {
                url.cacheControl(aNRequest.getCacheControl());
            }
            Request build = url.build();
            if (aNRequest.getOkHttpClient() != null) {
                aNRequest.setCall(aNRequest.getOkHttpClient().newBuilder().cache(sHttpClient.cache()).build().newCall(build));
            } else {
                aNRequest.setCall(sHttpClient.newCall(build));
            }
            long currentTimeMillis = System.currentTimeMillis();
            long totalRxBytes = TrafficStats.getTotalRxBytes();
            Response execute = aNRequest.getCall().execute();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            long j = -1;
            if (execute.cacheResponse() == null) {
                long totalRxBytes2 = TrafficStats.getTotalRxBytes();
                if (totalRxBytes != -1 && totalRxBytes2 != -1) {
                    contentLength = totalRxBytes2 - totalRxBytes;
                    ConnectionClassManager.getInstance().updateBandwidth(contentLength, currentTimeMillis2);
                    AnalyticsListener analyticsListener = aNRequest.getAnalyticsListener();
                    if (requestBody != null && requestBody.contentLength() != 0) {
                        j = requestBody.contentLength();
                    }
                    Utils.sendAnalytics(analyticsListener, currentTimeMillis2, j, execute.body().contentLength(), false);
                }
                contentLength = execute.body().contentLength();
                ConnectionClassManager.getInstance().updateBandwidth(contentLength, currentTimeMillis2);
                AnalyticsListener analyticsListener2 = aNRequest.getAnalyticsListener();
                if (requestBody != null) {
                    j = requestBody.contentLength();
                }
                Utils.sendAnalytics(analyticsListener2, currentTimeMillis2, j, execute.body().contentLength(), false);
            } else if (aNRequest.getAnalyticsListener() != null) {
                if (execute.networkResponse() == null) {
                    Utils.sendAnalytics(aNRequest.getAnalyticsListener(), currentTimeMillis2, 0L, 0L, true);
                } else {
                    AnalyticsListener analyticsListener3 = aNRequest.getAnalyticsListener();
                    if (requestBody != null && requestBody.contentLength() != 0) {
                        j = requestBody.contentLength();
                    }
                    Utils.sendAnalytics(analyticsListener3, currentTimeMillis2, j, 0L, true);
                }
            }
            return execute;
        } catch (IOException e) {
            throw new ANError(e);
        }
    }

    public static Response performUploadRequest(ANRequest aNRequest) throws ANError {
        try {
            Request.Builder url = new Request.Builder().url(aNRequest.getUrl());
            addHeadersToRequestBuilder(url, aNRequest);
            RequestBody multiPartRequestBody = aNRequest.getMultiPartRequestBody();
            long contentLength = multiPartRequestBody.contentLength();
            Request.Builder post = url.post(new RequestProgressBody(multiPartRequestBody, aNRequest.getUploadProgressListener()));
            if (aNRequest.getCacheControl() != null) {
                post.cacheControl(aNRequest.getCacheControl());
            }
            Request build = post.build();
            if (aNRequest.getOkHttpClient() != null) {
                aNRequest.setCall(aNRequest.getOkHttpClient().newBuilder().cache(sHttpClient.cache()).build().newCall(build));
            } else {
                aNRequest.setCall(sHttpClient.newCall(build));
            }
            long currentTimeMillis = System.currentTimeMillis();
            Response execute = aNRequest.getCall().execute();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (aNRequest.getAnalyticsListener() != null) {
                if (execute.cacheResponse() == null) {
                    Utils.sendAnalytics(aNRequest.getAnalyticsListener(), currentTimeMillis2, contentLength, execute.body().contentLength(), false);
                } else if (execute.networkResponse() == null) {
                    Utils.sendAnalytics(aNRequest.getAnalyticsListener(), currentTimeMillis2, 0L, 0L, true);
                } else {
                    AnalyticsListener analyticsListener = aNRequest.getAnalyticsListener();
                    if (contentLength == 0) {
                        contentLength = -1;
                    }
                    Utils.sendAnalytics(analyticsListener, currentTimeMillis2, contentLength, 0L, true);
                }
            }
            return execute;
        } catch (IOException e) {
            throw new ANError(e);
        }
    }

    public static void setClient(OkHttpClient okHttpClient) {
        sHttpClient = okHttpClient;
    }

    public static void setClientWithCache(Context context) {
        OkHttpClient.Builder cache = new OkHttpClient().newBuilder().cache(Utils.getCache(context, ANConstants.MAX_CACHE_SIZE, ANConstants.CACHE_DIR_NAME));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        sHttpClient = cache.connectTimeout(60L, timeUnit).readTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).build();
    }

    public static void setUserAgent(String str) {
        sUserAgent = str;
    }
}
