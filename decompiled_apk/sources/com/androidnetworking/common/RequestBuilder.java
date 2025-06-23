package com.androidnetworking.common;

import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public interface RequestBuilder {
    RequestBuilder addHeaders(Object obj);

    RequestBuilder addHeaders(String str, String str2);

    RequestBuilder addHeaders(Map<String, String> map);

    RequestBuilder addPathParameter(Object obj);

    RequestBuilder addPathParameter(String str, String str2);

    RequestBuilder addPathParameter(Map<String, String> map);

    RequestBuilder addQueryParameter(Object obj);

    RequestBuilder addQueryParameter(String str, String str2);

    RequestBuilder addQueryParameter(Map<String, String> map);

    RequestBuilder doNotCacheResponse();

    RequestBuilder getResponseOnlyFromNetwork();

    RequestBuilder getResponseOnlyIfCached();

    RequestBuilder setExecutor(Executor executor);

    RequestBuilder setMaxAgeCacheControl(int i, TimeUnit timeUnit);

    RequestBuilder setMaxStaleCacheControl(int i, TimeUnit timeUnit);

    RequestBuilder setOkHttpClient(OkHttpClient okHttpClient);

    RequestBuilder setPriority(Priority priority);

    RequestBuilder setTag(Object obj);

    RequestBuilder setUserAgent(String str);
}
