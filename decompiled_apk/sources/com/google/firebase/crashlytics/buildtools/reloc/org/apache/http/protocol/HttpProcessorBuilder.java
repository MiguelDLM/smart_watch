package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpRequestInterceptor;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponseInterceptor;
import java.util.LinkedList;

/* loaded from: classes10.dex */
public class HttpProcessorBuilder {
    private ChainBuilder<HttpRequestInterceptor> requestChainBuilder;
    private ChainBuilder<HttpResponseInterceptor> responseChainBuilder;

    public static HttpProcessorBuilder create() {
        return new HttpProcessorBuilder();
    }

    private ChainBuilder<HttpRequestInterceptor> getRequestChainBuilder() {
        if (this.requestChainBuilder == null) {
            this.requestChainBuilder = new ChainBuilder<>();
        }
        return this.requestChainBuilder;
    }

    private ChainBuilder<HttpResponseInterceptor> getResponseChainBuilder() {
        if (this.responseChainBuilder == null) {
            this.responseChainBuilder = new ChainBuilder<>();
        }
        return this.responseChainBuilder;
    }

    public HttpProcessorBuilder add(HttpRequestInterceptor httpRequestInterceptor) {
        return addLast(httpRequestInterceptor);
    }

    public HttpProcessorBuilder addAll(HttpRequestInterceptor... httpRequestInterceptorArr) {
        return addAllLast(httpRequestInterceptorArr);
    }

    public HttpProcessorBuilder addAllFirst(HttpRequestInterceptor... httpRequestInterceptorArr) {
        if (httpRequestInterceptorArr == null) {
            return this;
        }
        getRequestChainBuilder().addAllFirst(httpRequestInterceptorArr);
        return this;
    }

    public HttpProcessorBuilder addAllLast(HttpRequestInterceptor... httpRequestInterceptorArr) {
        if (httpRequestInterceptorArr == null) {
            return this;
        }
        getRequestChainBuilder().addAllLast(httpRequestInterceptorArr);
        return this;
    }

    public HttpProcessorBuilder addFirst(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor == null) {
            return this;
        }
        getRequestChainBuilder().addFirst(httpRequestInterceptor);
        return this;
    }

    public HttpProcessorBuilder addLast(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor == null) {
            return this;
        }
        getRequestChainBuilder().addLast(httpRequestInterceptor);
        return this;
    }

    public HttpProcessor build() {
        LinkedList<HttpRequestInterceptor> linkedList;
        ChainBuilder<HttpRequestInterceptor> chainBuilder = this.requestChainBuilder;
        LinkedList<HttpResponseInterceptor> linkedList2 = null;
        if (chainBuilder != null) {
            linkedList = chainBuilder.build();
        } else {
            linkedList = null;
        }
        ChainBuilder<HttpResponseInterceptor> chainBuilder2 = this.responseChainBuilder;
        if (chainBuilder2 != null) {
            linkedList2 = chainBuilder2.build();
        }
        return new ImmutableHttpProcessor(linkedList, linkedList2);
    }

    public HttpProcessorBuilder add(HttpResponseInterceptor httpResponseInterceptor) {
        return addLast(httpResponseInterceptor);
    }

    public HttpProcessorBuilder addAll(HttpResponseInterceptor... httpResponseInterceptorArr) {
        return addAllLast(httpResponseInterceptorArr);
    }

    public HttpProcessorBuilder addAllFirst(HttpResponseInterceptor... httpResponseInterceptorArr) {
        if (httpResponseInterceptorArr == null) {
            return this;
        }
        getResponseChainBuilder().addAllFirst(httpResponseInterceptorArr);
        return this;
    }

    public HttpProcessorBuilder addAllLast(HttpResponseInterceptor... httpResponseInterceptorArr) {
        if (httpResponseInterceptorArr == null) {
            return this;
        }
        getResponseChainBuilder().addAllLast(httpResponseInterceptorArr);
        return this;
    }

    public HttpProcessorBuilder addFirst(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor == null) {
            return this;
        }
        getResponseChainBuilder().addFirst(httpResponseInterceptor);
        return this;
    }

    public HttpProcessorBuilder addLast(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor == null) {
            return this;
        }
        getResponseChainBuilder().addLast(httpResponseInterceptor);
        return this;
    }
}
