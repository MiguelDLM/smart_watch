package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import XO0OX.xxIXOIIO;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpDelete;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpHead;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpPatch;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpPut;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

@XX({"SMAP\nRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Request.kt\nokhttp3/Request\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,298:1\n1864#2,3:299\n*S KotlinDebug\n*F\n+ 1 Request.kt\nokhttp3/Request\n*L\n119#1:299,3\n*E\n"})
/* loaded from: classes6.dex */
public final class Request {

    @oOoXoXO
    private final RequestBody body;

    @OOXIXo
    private final Headers headers;

    @oOoXoXO
    private CacheControl lazyCacheControl;

    @OOXIXo
    private final String method;

    @OOXIXo
    private final Map<Class<?>, Object> tags;

    @OOXIXo
    private final HttpUrl url;

    @XX({"SMAP\nRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Request.kt\nokhttp3/Request$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,298:1\n1#2:299\n*E\n"})
    /* loaded from: classes6.dex */
    public static class Builder {

        @oOoXoXO
        private RequestBody body;

        @OOXIXo
        private Headers.Builder headers;

        @OOXIXo
        private String method;

        @OOXIXo
        private Map<Class<?>, Object> tags;

        @oOoXoXO
        private HttpUrl url;

        public Builder() {
            this.tags = new LinkedHashMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public static /* synthetic */ Builder delete$default(Builder builder, RequestBody requestBody, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    requestBody = Util.EMPTY_REQUEST;
                }
                return builder.delete(requestBody);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }

        @OOXIXo
        public Builder addHeader(@OOXIXo String name, @OOXIXo String value) {
            IIX0o.x0xO0oo(name, "name");
            IIX0o.x0xO0oo(value, "value");
            this.headers.add(name, value);
            return this;
        }

        @OOXIXo
        public Request build() {
            HttpUrl httpUrl = this.url;
            if (httpUrl != null) {
                return new Request(httpUrl, this.method, this.headers.build(), this.body, Util.toImmutableMap(this.tags));
            }
            throw new IllegalStateException("url == null");
        }

        @OOXIXo
        public Builder cacheControl(@OOXIXo CacheControl cacheControl) {
            IIX0o.x0xO0oo(cacheControl, "cacheControl");
            String cacheControl2 = cacheControl.toString();
            if (cacheControl2.length() == 0) {
                return removeHeader("Cache-Control");
            }
            return header("Cache-Control", cacheControl2);
        }

        @OOXIXo
        @xoIox
        public final Builder delete() {
            return delete$default(this, null, 1, null);
        }

        @OOXIXo
        public Builder get() {
            return method("GET", null);
        }

        @oOoXoXO
        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        @OOXIXo
        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        @OOXIXo
        public final String getMethod$okhttp() {
            return this.method;
        }

        @OOXIXo
        public final Map<Class<?>, Object> getTags$okhttp() {
            return this.tags;
        }

        @oOoXoXO
        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        @OOXIXo
        public Builder head() {
            return method(HttpHead.METHOD_NAME, null);
        }

        @OOXIXo
        public Builder header(@OOXIXo String name, @OOXIXo String value) {
            IIX0o.x0xO0oo(name, "name");
            IIX0o.x0xO0oo(value, "value");
            this.headers.set(name, value);
            return this;
        }

        @OOXIXo
        public Builder headers(@OOXIXo Headers headers) {
            IIX0o.x0xO0oo(headers, "headers");
            this.headers = headers.newBuilder();
            return this;
        }

        @OOXIXo
        public Builder method(@OOXIXo String method, @oOoXoXO RequestBody requestBody) {
            IIX0o.x0xO0oo(method, "method");
            if (method.length() > 0) {
                if (requestBody == null) {
                    if (HttpMethod.requiresRequestBody(method)) {
                        throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
                    }
                } else if (!HttpMethod.permitsRequestBody(method)) {
                    throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
                }
                this.method = method;
                this.body = requestBody;
                return this;
            }
            throw new IllegalArgumentException("method.isEmpty() == true");
        }

        @OOXIXo
        public Builder patch(@OOXIXo RequestBody body) {
            IIX0o.x0xO0oo(body, "body");
            return method(HttpPatch.METHOD_NAME, body);
        }

        @OOXIXo
        public Builder post(@OOXIXo RequestBody body) {
            IIX0o.x0xO0oo(body, "body");
            return method("POST", body);
        }

        @OOXIXo
        public Builder put(@OOXIXo RequestBody body) {
            IIX0o.x0xO0oo(body, "body");
            return method(HttpPut.METHOD_NAME, body);
        }

        @OOXIXo
        public Builder removeHeader(@OOXIXo String name) {
            IIX0o.x0xO0oo(name, "name");
            this.headers.removeAll(name);
            return this;
        }

        public final void setBody$okhttp(@oOoXoXO RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setHeaders$okhttp(@OOXIXo Headers.Builder builder) {
            IIX0o.x0xO0oo(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMethod$okhttp(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.method = str;
        }

        public final void setTags$okhttp(@OOXIXo Map<Class<?>, Object> map) {
            IIX0o.x0xO0oo(map, "<set-?>");
            this.tags = map;
        }

        public final void setUrl$okhttp(@oOoXoXO HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        @OOXIXo
        public Builder tag(@oOoXoXO Object obj) {
            return tag(Object.class, obj);
        }

        @OOXIXo
        public Builder url(@OOXIXo HttpUrl url) {
            IIX0o.x0xO0oo(url, "url");
            this.url = url;
            return this;
        }

        @OOXIXo
        @xoIox
        public Builder delete(@oOoXoXO RequestBody requestBody) {
            return method(HttpDelete.METHOD_NAME, requestBody);
        }

        @OOXIXo
        public <T> Builder tag(@OOXIXo Class<? super T> type, @oOoXoXO T t) {
            IIX0o.x0xO0oo(type, "type");
            if (t == null) {
                this.tags.remove(type);
            } else {
                if (this.tags.isEmpty()) {
                    this.tags = new LinkedHashMap();
                }
                Map<Class<?>, Object> map = this.tags;
                T cast = type.cast(t);
                IIX0o.ooOOo0oXI(cast);
                map.put(type, cast);
            }
            return this;
        }

        @OOXIXo
        public Builder url(@OOXIXo String url) {
            IIX0o.x0xO0oo(url, "url");
            if (OxI.xIXIOX(url, "ws:", true)) {
                StringBuilder sb = new StringBuilder();
                sb.append("http:");
                String substring = url.substring(3);
                IIX0o.oO(substring, "this as java.lang.String).substring(startIndex)");
                sb.append(substring);
                url = sb.toString();
            } else if (OxI.xIXIOX(url, "wss:", true)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("https:");
                String substring2 = url.substring(4);
                IIX0o.oO(substring2, "this as java.lang.String).substring(startIndex)");
                sb2.append(substring2);
                url = sb2.toString();
            }
            return url(HttpUrl.Companion.get(url));
        }

        public Builder(@OOXIXo Request request) {
            Map<Class<?>, Object> O0X2;
            IIX0o.x0xO0oo(request, "request");
            this.tags = new LinkedHashMap();
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            if (request.getTags$okhttp().isEmpty()) {
                O0X2 = new LinkedHashMap<>();
            } else {
                O0X2 = o0.O0X(request.getTags$okhttp());
            }
            this.tags = O0X2;
            this.headers = request.headers().newBuilder();
        }

        @OOXIXo
        public Builder url(@OOXIXo URL url) {
            IIX0o.x0xO0oo(url, "url");
            HttpUrl.Companion companion = HttpUrl.Companion;
            String url2 = url.toString();
            IIX0o.oO(url2, "url.toString()");
            return url(companion.get(url2));
        }
    }

    public Request(@OOXIXo HttpUrl url, @OOXIXo String method, @OOXIXo Headers headers, @oOoXoXO RequestBody requestBody, @OOXIXo Map<Class<?>, ? extends Object> tags) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(method, "method");
        IIX0o.x0xO0oo(headers, "headers");
        IIX0o.x0xO0oo(tags, "tags");
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.body = requestBody;
        this.tags = tags;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "body", imports = {}))
    @xxIXOIIO(name = "-deprecated_body")
    @oOoXoXO
    /* renamed from: -deprecated_body, reason: not valid java name */
    public final RequestBody m413deprecated_body() {
        return this.body;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "cacheControl", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_cacheControl")
    /* renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m414deprecated_cacheControl() {
        return cacheControl();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = TTDownloadField.TT_HEADERS, imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_headers")
    /* renamed from: -deprecated_headers, reason: not valid java name */
    public final Headers m415deprecated_headers() {
        return this.headers;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "method", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_method")
    /* renamed from: -deprecated_method, reason: not valid java name */
    public final String m416deprecated_method() {
        return this.method;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "url", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_url")
    /* renamed from: -deprecated_url, reason: not valid java name */
    public final HttpUrl m417deprecated_url() {
        return this.url;
    }

    @xxIXOIIO(name = "body")
    @oOoXoXO
    public final RequestBody body() {
        return this.body;
    }

    @OOXIXo
    @xxIXOIIO(name = "cacheControl")
    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl == null) {
            CacheControl parse = CacheControl.Companion.parse(this.headers);
            this.lazyCacheControl = parse;
            return parse;
        }
        return cacheControl;
    }

    @OOXIXo
    public final Map<Class<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    @oOoXoXO
    public final String header(@OOXIXo String name) {
        IIX0o.x0xO0oo(name, "name");
        return this.headers.get(name);
    }

    @OOXIXo
    @xxIXOIIO(name = TTDownloadField.TT_HEADERS)
    public final Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    @OOXIXo
    @xxIXOIIO(name = "method")
    public final String method() {
        return this.method;
    }

    @OOXIXo
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @oOoXoXO
    public final Object tag() {
        return tag(Object.class);
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        if (this.headers.size() != 0) {
            sb.append(", headers=[");
            int i = 0;
            for (Pair<? extends String, ? extends String> pair : this.headers) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String component1 = pair2.component1();
                String component2 = pair2.component2();
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(component1);
                sb.append(':');
                sb.append(component2);
                i = i2;
            }
            sb.append(']');
        }
        if (!this.tags.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.tags);
        }
        sb.append('}');
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @OOXIXo
    @xxIXOIIO(name = "url")
    public final HttpUrl url() {
        return this.url;
    }

    @OOXIXo
    public final List<String> headers(@OOXIXo String name) {
        IIX0o.x0xO0oo(name, "name");
        return this.headers.values(name);
    }

    @oOoXoXO
    public final <T> T tag(@OOXIXo Class<? extends T> type) {
        IIX0o.x0xO0oo(type, "type");
        return type.cast(this.tags.get(type));
    }
}
