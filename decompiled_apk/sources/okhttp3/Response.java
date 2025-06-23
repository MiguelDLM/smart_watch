package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import XO0OX.xxIXOIIO;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import okhttp3.Headers;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;

@XX({"SMAP\nResponse.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Response.kt\nokhttp3/Response\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,455:1\n1#2:456\n*E\n"})
/* loaded from: classes6.dex */
public final class Response implements Closeable {

    @oOoXoXO
    private final ResponseBody body;

    @oOoXoXO
    private final Response cacheResponse;
    private final int code;

    @oOoXoXO
    private final Exchange exchange;

    @oOoXoXO
    private final Handshake handshake;

    @OOXIXo
    private final Headers headers;

    @oOoXoXO
    private CacheControl lazyCacheControl;

    @OOXIXo
    private final String message;

    @oOoXoXO
    private final Response networkResponse;

    @oOoXoXO
    private final Response priorResponse;

    @OOXIXo
    private final Protocol protocol;
    private final long receivedResponseAtMillis;

    @OOXIXo
    private final Request request;
    private final long sentRequestAtMillis;

    public Response(@OOXIXo Request request, @OOXIXo Protocol protocol, @OOXIXo String message, int i, @oOoXoXO Handshake handshake, @OOXIXo Headers headers, @oOoXoXO ResponseBody responseBody, @oOoXoXO Response response, @oOoXoXO Response response2, @oOoXoXO Response response3, long j, long j2, @oOoXoXO Exchange exchange) {
        IIX0o.x0xO0oo(request, "request");
        IIX0o.x0xO0oo(protocol, "protocol");
        IIX0o.x0xO0oo(message, "message");
        IIX0o.x0xO0oo(headers, "headers");
        this.request = request;
        this.protocol = protocol;
        this.message = message;
        this.code = i;
        this.handshake = handshake;
        this.headers = headers;
        this.body = responseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j;
        this.receivedResponseAtMillis = j2;
        this.exchange = exchange;
    }

    public static /* synthetic */ String header$default(Response response, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return response.header(str, str2);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "body", imports = {}))
    @xxIXOIIO(name = "-deprecated_body")
    @oOoXoXO
    /* renamed from: -deprecated_body, reason: not valid java name */
    public final ResponseBody m418deprecated_body() {
        return this.body;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "cacheControl", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_cacheControl")
    /* renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m419deprecated_cacheControl() {
        return cacheControl();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "cacheResponse", imports = {}))
    @xxIXOIIO(name = "-deprecated_cacheResponse")
    @oOoXoXO
    /* renamed from: -deprecated_cacheResponse, reason: not valid java name */
    public final Response m420deprecated_cacheResponse() {
        return this.cacheResponse;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "code", imports = {}))
    @xxIXOIIO(name = "-deprecated_code")
    /* renamed from: -deprecated_code, reason: not valid java name */
    public final int m421deprecated_code() {
        return this.code;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "handshake", imports = {}))
    @xxIXOIIO(name = "-deprecated_handshake")
    @oOoXoXO
    /* renamed from: -deprecated_handshake, reason: not valid java name */
    public final Handshake m422deprecated_handshake() {
        return this.handshake;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = TTDownloadField.TT_HEADERS, imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_headers")
    /* renamed from: -deprecated_headers, reason: not valid java name */
    public final Headers m423deprecated_headers() {
        return this.headers;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "message", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_message")
    /* renamed from: -deprecated_message, reason: not valid java name */
    public final String m424deprecated_message() {
        return this.message;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "networkResponse", imports = {}))
    @xxIXOIIO(name = "-deprecated_networkResponse")
    @oOoXoXO
    /* renamed from: -deprecated_networkResponse, reason: not valid java name */
    public final Response m425deprecated_networkResponse() {
        return this.networkResponse;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "priorResponse", imports = {}))
    @xxIXOIIO(name = "-deprecated_priorResponse")
    @oOoXoXO
    /* renamed from: -deprecated_priorResponse, reason: not valid java name */
    public final Response m426deprecated_priorResponse() {
        return this.priorResponse;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "protocol", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_protocol")
    /* renamed from: -deprecated_protocol, reason: not valid java name */
    public final Protocol m427deprecated_protocol() {
        return this.protocol;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "receivedResponseAtMillis", imports = {}))
    @xxIXOIIO(name = "-deprecated_receivedResponseAtMillis")
    /* renamed from: -deprecated_receivedResponseAtMillis, reason: not valid java name */
    public final long m428deprecated_receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "request", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_request")
    /* renamed from: -deprecated_request, reason: not valid java name */
    public final Request m429deprecated_request() {
        return this.request;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "sentRequestAtMillis", imports = {}))
    @xxIXOIIO(name = "-deprecated_sentRequestAtMillis")
    /* renamed from: -deprecated_sentRequestAtMillis, reason: not valid java name */
    public final long m430deprecated_sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    @xxIXOIIO(name = "body")
    @oOoXoXO
    public final ResponseBody body() {
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

    @xxIXOIIO(name = "cacheResponse")
    @oOoXoXO
    public final Response cacheResponse() {
        return this.cacheResponse;
    }

    @OOXIXo
    public final List<Challenge> challenges() {
        String str;
        Headers headers = this.headers;
        int i = this.code;
        if (i != 401) {
            if (i != 407) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            str = "Proxy-Authenticate";
        } else {
            str = "WWW-Authenticate";
        }
        return HttpHeaders.parseChallenges(headers, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody != null) {
            responseBody.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    @xxIXOIIO(name = "code")
    public final int code() {
        return this.code;
    }

    @xxIXOIIO(name = "exchange")
    @oOoXoXO
    public final Exchange exchange() {
        return this.exchange;
    }

    @xxIXOIIO(name = "handshake")
    @oOoXoXO
    public final Handshake handshake() {
        return this.handshake;
    }

    @oOoXoXO
    @xoIox
    public final String header(@OOXIXo String name) {
        IIX0o.x0xO0oo(name, "name");
        return header$default(this, name, null, 2, null);
    }

    @OOXIXo
    @xxIXOIIO(name = TTDownloadField.TT_HEADERS)
    public final Headers headers() {
        return this.headers;
    }

    public final boolean isRedirect() {
        int i = this.code;
        if (i != 307 && i != 308) {
            switch (i) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public final boolean isSuccessful() {
        int i = this.code;
        if (200 > i || i >= 300) {
            return false;
        }
        return true;
    }

    @OOXIXo
    @xxIXOIIO(name = "message")
    public final String message() {
        return this.message;
    }

    @xxIXOIIO(name = "networkResponse")
    @oOoXoXO
    public final Response networkResponse() {
        return this.networkResponse;
    }

    @OOXIXo
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @OOXIXo
    public final ResponseBody peekBody(long j) throws IOException {
        ResponseBody responseBody = this.body;
        IIX0o.ooOOo0oXI(responseBody);
        BufferedSource peek = responseBody.source().peek();
        Buffer buffer = new Buffer();
        peek.request(j);
        buffer.write((Source) peek, Math.min(j, peek.getBuffer().size()));
        return ResponseBody.Companion.create(buffer, this.body.contentType(), buffer.size());
    }

    @xxIXOIIO(name = "priorResponse")
    @oOoXoXO
    public final Response priorResponse() {
        return this.priorResponse;
    }

    @OOXIXo
    @xxIXOIIO(name = "protocol")
    public final Protocol protocol() {
        return this.protocol;
    }

    @xxIXOIIO(name = "receivedResponseAtMillis")
    public final long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @OOXIXo
    @xxIXOIIO(name = "request")
    public final Request request() {
        return this.request;
    }

    @xxIXOIIO(name = "sentRequestAtMillis")
    public final long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    @OOXIXo
    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }

    @OOXIXo
    public final Headers trailers() throws IOException {
        Exchange exchange = this.exchange;
        if (exchange != null) {
            return exchange.trailers();
        }
        throw new IllegalStateException("trailers not available");
    }

    @oOoXoXO
    @xoIox
    public final String header(@OOXIXo String name, @oOoXoXO String str) {
        IIX0o.x0xO0oo(name, "name");
        String str2 = this.headers.get(name);
        return str2 == null ? str : str2;
    }

    @OOXIXo
    public final List<String> headers(@OOXIXo String name) {
        IIX0o.x0xO0oo(name, "name");
        return this.headers.values(name);
    }

    @XX({"SMAP\nResponse.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Response.kt\nokhttp3/Response$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,455:1\n1#2:456\n*E\n"})
    /* loaded from: classes6.dex */
    public static class Builder {

        @oOoXoXO
        private ResponseBody body;

        @oOoXoXO
        private Response cacheResponse;
        private int code;

        @oOoXoXO
        private Exchange exchange;

        @oOoXoXO
        private Handshake handshake;

        @OOXIXo
        private Headers.Builder headers;

        @oOoXoXO
        private String message;

        @oOoXoXO
        private Response networkResponse;

        @oOoXoXO
        private Response priorResponse;

        @oOoXoXO
        private Protocol protocol;
        private long receivedResponseAtMillis;

        @oOoXoXO
        private Request request;
        private long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        private final void checkPriorResponse(Response response) {
            if (response != null && response.body() != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private final void checkSupportResponse(String str, Response response) {
            if (response != null) {
                if (response.body() == null) {
                    if (response.networkResponse() == null) {
                        if (response.cacheResponse() == null) {
                            if (response.priorResponse() != null) {
                                throw new IllegalArgumentException((str + ".priorResponse != null").toString());
                            }
                            return;
                        }
                        throw new IllegalArgumentException((str + ".cacheResponse != null").toString());
                    }
                    throw new IllegalArgumentException((str + ".networkResponse != null").toString());
                }
                throw new IllegalArgumentException((str + ".body != null").toString());
            }
        }

        @OOXIXo
        public Builder addHeader(@OOXIXo String name, @OOXIXo String value) {
            IIX0o.x0xO0oo(name, "name");
            IIX0o.x0xO0oo(value, "value");
            this.headers.add(name, value);
            return this;
        }

        @OOXIXo
        public Builder body(@oOoXoXO ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        @OOXIXo
        public Response build() {
            int i = this.code;
            if (i >= 0) {
                Request request = this.request;
                if (request != null) {
                    Protocol protocol = this.protocol;
                    if (protocol != null) {
                        String str = this.message;
                        if (str != null) {
                            return new Response(request, protocol, str, i, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("protocol == null");
                }
                throw new IllegalStateException("request == null");
            }
            throw new IllegalStateException(("code < 0: " + this.code).toString());
        }

        @OOXIXo
        public Builder cacheResponse(@oOoXoXO Response response) {
            checkSupportResponse("cacheResponse", response);
            this.cacheResponse = response;
            return this;
        }

        @OOXIXo
        public Builder code(int i) {
            this.code = i;
            return this;
        }

        @oOoXoXO
        public final ResponseBody getBody$okhttp() {
            return this.body;
        }

        @oOoXoXO
        public final Response getCacheResponse$okhttp() {
            return this.cacheResponse;
        }

        public final int getCode$okhttp() {
            return this.code;
        }

        @oOoXoXO
        public final Exchange getExchange$okhttp() {
            return this.exchange;
        }

        @oOoXoXO
        public final Handshake getHandshake$okhttp() {
            return this.handshake;
        }

        @OOXIXo
        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        @oOoXoXO
        public final String getMessage$okhttp() {
            return this.message;
        }

        @oOoXoXO
        public final Response getNetworkResponse$okhttp() {
            return this.networkResponse;
        }

        @oOoXoXO
        public final Response getPriorResponse$okhttp() {
            return this.priorResponse;
        }

        @oOoXoXO
        public final Protocol getProtocol$okhttp() {
            return this.protocol;
        }

        public final long getReceivedResponseAtMillis$okhttp() {
            return this.receivedResponseAtMillis;
        }

        @oOoXoXO
        public final Request getRequest$okhttp() {
            return this.request;
        }

        public final long getSentRequestAtMillis$okhttp() {
            return this.sentRequestAtMillis;
        }

        @OOXIXo
        public Builder handshake(@oOoXoXO Handshake handshake) {
            this.handshake = handshake;
            return this;
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

        public final void initExchange$okhttp(@OOXIXo Exchange deferredTrailers) {
            IIX0o.x0xO0oo(deferredTrailers, "deferredTrailers");
            this.exchange = deferredTrailers;
        }

        @OOXIXo
        public Builder message(@OOXIXo String message) {
            IIX0o.x0xO0oo(message, "message");
            this.message = message;
            return this;
        }

        @OOXIXo
        public Builder networkResponse(@oOoXoXO Response response) {
            checkSupportResponse("networkResponse", response);
            this.networkResponse = response;
            return this;
        }

        @OOXIXo
        public Builder priorResponse(@oOoXoXO Response response) {
            checkPriorResponse(response);
            this.priorResponse = response;
            return this;
        }

        @OOXIXo
        public Builder protocol(@OOXIXo Protocol protocol) {
            IIX0o.x0xO0oo(protocol, "protocol");
            this.protocol = protocol;
            return this;
        }

        @OOXIXo
        public Builder receivedResponseAtMillis(long j) {
            this.receivedResponseAtMillis = j;
            return this;
        }

        @OOXIXo
        public Builder removeHeader(@OOXIXo String name) {
            IIX0o.x0xO0oo(name, "name");
            this.headers.removeAll(name);
            return this;
        }

        @OOXIXo
        public Builder request(@OOXIXo Request request) {
            IIX0o.x0xO0oo(request, "request");
            this.request = request;
            return this;
        }

        @OOXIXo
        public Builder sentRequestAtMillis(long j) {
            this.sentRequestAtMillis = j;
            return this;
        }

        public final void setBody$okhttp(@oOoXoXO ResponseBody responseBody) {
            this.body = responseBody;
        }

        public final void setCacheResponse$okhttp(@oOoXoXO Response response) {
            this.cacheResponse = response;
        }

        public final void setCode$okhttp(int i) {
            this.code = i;
        }

        public final void setExchange$okhttp(@oOoXoXO Exchange exchange) {
            this.exchange = exchange;
        }

        public final void setHandshake$okhttp(@oOoXoXO Handshake handshake) {
            this.handshake = handshake;
        }

        public final void setHeaders$okhttp(@OOXIXo Headers.Builder builder) {
            IIX0o.x0xO0oo(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMessage$okhttp(@oOoXoXO String str) {
            this.message = str;
        }

        public final void setNetworkResponse$okhttp(@oOoXoXO Response response) {
            this.networkResponse = response;
        }

        public final void setPriorResponse$okhttp(@oOoXoXO Response response) {
            this.priorResponse = response;
        }

        public final void setProtocol$okhttp(@oOoXoXO Protocol protocol) {
            this.protocol = protocol;
        }

        public final void setReceivedResponseAtMillis$okhttp(long j) {
            this.receivedResponseAtMillis = j;
        }

        public final void setRequest$okhttp(@oOoXoXO Request request) {
            this.request = request;
        }

        public final void setSentRequestAtMillis$okhttp(long j) {
            this.sentRequestAtMillis = j;
        }

        public Builder(@OOXIXo Response response) {
            IIX0o.x0xO0oo(response, "response");
            this.code = -1;
            this.request = response.request();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.handshake = response.handshake();
            this.headers = response.headers().newBuilder();
            this.body = response.body();
            this.networkResponse = response.networkResponse();
            this.cacheResponse = response.cacheResponse();
            this.priorResponse = response.priorResponse();
            this.sentRequestAtMillis = response.sentRequestAtMillis();
            this.receivedResponseAtMillis = response.receivedResponseAtMillis();
            this.exchange = response.exchange();
        }
    }
}
