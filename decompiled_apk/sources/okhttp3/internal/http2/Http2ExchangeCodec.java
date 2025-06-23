package okhttp3.internal.http2;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: classes6.dex */
public final class Http2ExchangeCodec implements ExchangeCodec {

    @OOXIXo
    private static final String CONNECTION = "connection";

    @OOXIXo
    private static final String UPGRADE = "upgrade";
    private volatile boolean canceled;

    @OOXIXo
    private final RealInterceptorChain chain;

    @OOXIXo
    private final RealConnection connection;

    @OOXIXo
    private final Http2Connection http2Connection;

    @OOXIXo
    private final Protocol protocol;

    @oOoXoXO
    private volatile Http2Stream stream;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final String HOST = "host";

    @OOXIXo
    private static final String KEEP_ALIVE = "keep-alive";

    @OOXIXo
    private static final String PROXY_CONNECTION = "proxy-connection";

    @OOXIXo
    private static final String TE = "te";

    @OOXIXo
    private static final String TRANSFER_ENCODING = "transfer-encoding";

    @OOXIXo
    private static final String ENCODING = "encoding";

    @OOXIXo
    private static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableListOf("connection", HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, "upgrade", Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8);

    @OOXIXo
    private static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableListOf("connection", HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, "upgrade");

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final List<Header> http2HeadersList(@OOXIXo Request request) {
            IIX0o.x0xO0oo(request, "request");
            Headers headers = request.headers();
            ArrayList arrayList = new ArrayList(headers.size() + 4);
            arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
            arrayList.add(new Header(Header.TARGET_PATH, RequestLine.INSTANCE.requestPath(request.url())));
            String header = request.header("Host");
            if (header != null) {
                arrayList.add(new Header(Header.TARGET_AUTHORITY, header));
            }
            arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                Locale US = Locale.US;
                IIX0o.oO(US, "US");
                String lowerCase = name.toLowerCase(US);
                IIX0o.oO(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (!Http2ExchangeCodec.HTTP_2_SKIPPED_REQUEST_HEADERS.contains(lowerCase) || (IIX0o.Oxx0IOOO(lowerCase, Http2ExchangeCodec.TE) && IIX0o.Oxx0IOOO(headers.value(i), "trailers"))) {
                    arrayList.add(new Header(lowerCase, headers.value(i)));
                }
            }
            return arrayList;
        }

        @OOXIXo
        public final Response.Builder readHttp2HeadersList(@OOXIXo Headers headerBlock, @OOXIXo Protocol protocol) {
            IIX0o.x0xO0oo(headerBlock, "headerBlock");
            IIX0o.x0xO0oo(protocol, "protocol");
            Headers.Builder builder = new Headers.Builder();
            int size = headerBlock.size();
            StatusLine statusLine = null;
            for (int i = 0; i < size; i++) {
                String name = headerBlock.name(i);
                String value = headerBlock.value(i);
                if (IIX0o.Oxx0IOOO(name, Header.RESPONSE_STATUS_UTF8)) {
                    statusLine = StatusLine.Companion.parse("HTTP/1.1 " + value);
                } else if (!Http2ExchangeCodec.HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(name)) {
                    builder.addLenient$okhttp(name, value);
                }
            }
            if (statusLine != null) {
                return new Response.Builder().protocol(protocol).code(statusLine.code).message(statusLine.message).headers(builder.build());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }

        private Companion() {
        }
    }

    public Http2ExchangeCodec(@OOXIXo OkHttpClient client, @OOXIXo RealConnection connection, @OOXIXo RealInterceptorChain chain, @OOXIXo Http2Connection http2Connection) {
        IIX0o.x0xO0oo(client, "client");
        IIX0o.x0xO0oo(connection, "connection");
        IIX0o.x0xO0oo(chain, "chain");
        IIX0o.x0xO0oo(http2Connection, "http2Connection");
        this.connection = connection;
        this.chain = chain;
        this.http2Connection = http2Connection;
        List<Protocol> protocols = client.protocols();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.protocol = protocols.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        this.canceled = true;
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @OOXIXo
    public Sink createRequestBody(@OOXIXo Request request, long j) {
        IIX0o.x0xO0oo(request, "request");
        Http2Stream http2Stream = this.stream;
        IIX0o.ooOOo0oXI(http2Stream);
        return http2Stream.getSink();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        Http2Stream http2Stream = this.stream;
        IIX0o.ooOOo0oXI(http2Stream);
        http2Stream.getSink().close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.http2Connection.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @OOXIXo
    public RealConnection getConnection() {
        return this.connection;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @OOXIXo
    public Source openResponseBodySource(@OOXIXo Response response) {
        IIX0o.x0xO0oo(response, "response");
        Http2Stream http2Stream = this.stream;
        IIX0o.ooOOo0oXI(http2Stream);
        return http2Stream.getSource$okhttp();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @oOoXoXO
    public Response.Builder readResponseHeaders(boolean z) {
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            Response.Builder readHttp2HeadersList = Companion.readHttp2HeadersList(http2Stream.takeHeaders(), this.protocol);
            if (z && readHttp2HeadersList.getCode$okhttp() == 100) {
                return null;
            }
            return readHttp2HeadersList;
        }
        throw new IOException("stream wasn't created");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(@OOXIXo Response response) {
        IIX0o.x0xO0oo(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            return 0L;
        }
        return Util.headersContentLength(response);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @OOXIXo
    public Headers trailers() {
        Http2Stream http2Stream = this.stream;
        IIX0o.ooOOo0oXI(http2Stream);
        return http2Stream.trailers();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(@OOXIXo Request request) {
        boolean z;
        IIX0o.x0xO0oo(request, "request");
        if (this.stream != null) {
            return;
        }
        if (request.body() != null) {
            z = true;
        } else {
            z = false;
        }
        this.stream = this.http2Connection.newStream(Companion.http2HeadersList(request), z);
        if (!this.canceled) {
            Http2Stream http2Stream = this.stream;
            IIX0o.ooOOo0oXI(http2Stream);
            Timeout readTimeout = http2Stream.readTimeout();
            long readTimeoutMillis$okhttp = this.chain.getReadTimeoutMillis$okhttp();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            readTimeout.timeout(readTimeoutMillis$okhttp, timeUnit);
            Http2Stream http2Stream2 = this.stream;
            IIX0o.ooOOo0oXI(http2Stream2);
            http2Stream2.writeTimeout().timeout(this.chain.getWriteTimeoutMillis$okhttp(), timeUnit);
            return;
        }
        Http2Stream http2Stream3 = this.stream;
        IIX0o.ooOOo0oXI(http2Stream3);
        http2Stream3.closeLater(ErrorCode.CANCEL);
        throw new IOException("Canceled");
    }
}
