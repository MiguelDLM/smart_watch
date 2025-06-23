package com.sma.androidnetworklib;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;

/* loaded from: classes11.dex */
public class HttpLoggingInterceptor implements Interceptor {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final Charset f19678I0Io = Charset.forName("UTF-8");

    /* renamed from: II0xO0, reason: collision with root package name */
    public volatile Level f19679II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final oIX0oI f19680oIX0oI;

    /* loaded from: classes11.dex */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY,
        CUSTOM
    }

    /* loaded from: classes11.dex */
    public interface oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final oIX0oI f19681oIX0oI = new C0927oIX0oI();

        /* renamed from: com.sma.androidnetworklib.HttpLoggingInterceptor$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class C0927oIX0oI implements oIX0oI {
            @Override // com.sma.androidnetworklib.HttpLoggingInterceptor.oIX0oI
            public void log(String str) {
                Platform.get().log(str, 4, null);
            }
        }

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(oIX0oI.f19681oIX0oI);
    }

    public static boolean oxoX(Buffer buffer) {
        long j;
        try {
            Buffer buffer2 = new Buffer();
            if (buffer.size() < 64) {
                j = buffer.size();
            } else {
                j = 64;
            }
            buffer.copyTo(buffer2, 0L, j);
            for (int i = 0; i < 16; i++) {
                if (!buffer2.exhausted()) {
                    int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                    if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                        return false;
                    }
                } else {
                    return true;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public Level I0Io() {
        return this.f19679II0xO0;
    }

    public final Response II0xO0(Interceptor.Chain chain) throws IOException {
        boolean z;
        Protocol protocol;
        String str;
        String str2;
        Level level = this.f19679II0xO0;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z2 = true;
        if (level == Level.BODY || level == Level.HEADERS) {
            z = true;
        } else {
            z = false;
        }
        RequestBody body = request.body();
        if (body == null) {
            z2 = false;
        }
        Connection connection = chain.connection();
        if (connection != null) {
            protocol = connection.protocol();
        } else {
            protocol = Protocol.HTTP_1_1;
        }
        String str3 = "--> " + request.method() + TokenParser.SP + request.url().uri().getPath() + TokenParser.SP + protocol;
        if (!z && z2) {
            str3 = str3 + " (" + body.contentLength() + "-byte body)";
        }
        this.f19680oIX0oI.log(str3);
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            long contentLength = body2.contentLength();
            if (contentLength != -1) {
                str = contentLength + "-byte";
            } else {
                str = "unknown-length";
            }
            oIX0oI oix0oi = this.f19680oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append("<-- ");
            sb.append(proceed.code());
            sb.append(TokenParser.SP);
            sb.append(proceed.message());
            sb.append(TokenParser.SP);
            sb.append(proceed.request().url().uri().getPath());
            sb.append(" (");
            sb.append(millis);
            sb.append("ms");
            if (!z) {
                str2 = ", " + str + " body";
            } else {
                str2 = "";
            }
            sb.append(str2);
            sb.append(HexStringBuilder.COMMENT_END_CHAR);
            oix0oi.log(sb.toString());
            if (!HttpHeaders.hasBody(proceed)) {
                this.f19680oIX0oI.log("<-- END HTTP");
            } else if (oIX0oI(proceed.headers())) {
                this.f19680oIX0oI.log("<-- END HTTP (encoded body omitted)");
            } else {
                BufferedSource source = body2.source();
                source.request(Long.MAX_VALUE);
                Buffer buffer = source.buffer();
                Charset charset = f19678I0Io;
                MediaType contentType = body2.contentType();
                if (contentType != null) {
                    charset = contentType.charset(charset);
                }
                if (!oxoX(buffer)) {
                    this.f19680oIX0oI.log("<-- END HTTP (binary " + buffer.size() + "-byte body omitted)");
                    return proceed;
                }
                if (contentLength != 0) {
                    this.f19680oIX0oI.log(buffer.clone().readString(charset));
                }
            }
            return proceed;
        } catch (Exception e) {
            this.f19680oIX0oI.log("<-- HTTP FAILED " + request.url().uri().getPath() + "  : " + e);
            throw e;
        }
    }

    public HttpLoggingInterceptor X0o0xo(Level level) {
        if (level != null) {
            this.f19679II0xO0 = level;
            return this;
        }
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        boolean z2;
        Protocol protocol;
        boolean z3;
        String str;
        String str2;
        boolean z4;
        Level level = this.f19679II0xO0;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        if (level == Level.CUSTOM) {
            return II0xO0(chain);
        }
        boolean z5 = true;
        if (level == Level.BODY) {
            z = true;
        } else {
            z = false;
        }
        if (!z && level != Level.HEADERS) {
            z2 = false;
        } else {
            z2 = true;
        }
        RequestBody body = request.body();
        if (body == null) {
            z5 = false;
        }
        Connection connection = chain.connection();
        if (connection != null) {
            protocol = connection.protocol();
        } else {
            protocol = Protocol.HTTP_1_1;
        }
        String str3 = "--> " + request.method() + TokenParser.SP + request.url() + TokenParser.SP + protocol;
        if (!z2 && z5) {
            str3 = str3 + " (" + body.contentLength() + "-byte body)";
        }
        this.f19680oIX0oI.log(str3);
        if (z2) {
            if (z5) {
                if (body.contentType() != null) {
                    this.f19680oIX0oI.log("Content-Type: " + body.contentType());
                }
                if (body.contentLength() != -1) {
                    this.f19680oIX0oI.log("Content-Length: " + body.contentLength());
                }
            }
            Headers headers = request.headers();
            int size = headers.size();
            int i = 0;
            while (i < size) {
                String name = headers.name(i);
                int i2 = size;
                if (!"Content-Type".equalsIgnoreCase(name) && !"Content-Length".equalsIgnoreCase(name)) {
                    z4 = z2;
                    this.f19680oIX0oI.log(name + ": " + headers.value(i));
                } else {
                    z4 = z2;
                }
                i++;
                size = i2;
                z2 = z4;
            }
            z3 = z2;
            if (z && z5) {
                if (oIX0oI(request.headers())) {
                    this.f19680oIX0oI.log("--> END " + request.method() + " (encoded body omitted)");
                } else {
                    Buffer buffer = new Buffer();
                    body.writeTo(buffer);
                    Charset charset = f19678I0Io;
                    MediaType contentType = body.contentType();
                    if (contentType != null) {
                        charset = contentType.charset(charset);
                    }
                    this.f19680oIX0oI.log("");
                    if (oxoX(buffer)) {
                        this.f19680oIX0oI.log(buffer.readString(charset));
                        this.f19680oIX0oI.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                    } else {
                        this.f19680oIX0oI.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                    }
                }
            } else {
                this.f19680oIX0oI.log("--> END " + request.method());
            }
        } else {
            z3 = z2;
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            long contentLength = body2.contentLength();
            if (contentLength != -1) {
                str = contentLength + "-byte";
            } else {
                str = "unknown-length";
            }
            oIX0oI oix0oi = this.f19680oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append("<-- ");
            sb.append(proceed.code());
            sb.append(TokenParser.SP);
            sb.append(proceed.message());
            sb.append(TokenParser.SP);
            sb.append(proceed.request().url());
            sb.append(" (");
            sb.append(millis);
            sb.append("ms");
            if (z3) {
                str2 = "";
            } else {
                str2 = ", " + str + " body";
            }
            sb.append(str2);
            sb.append(HexStringBuilder.COMMENT_END_CHAR);
            oix0oi.log(sb.toString());
            if (z3) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    this.f19680oIX0oI.log(headers2.name(i3) + ": " + headers2.value(i3));
                }
                if (z && HttpHeaders.hasBody(proceed)) {
                    if (oIX0oI(proceed.headers())) {
                        this.f19680oIX0oI.log("<-- END HTTP (encoded body omitted)");
                    } else {
                        BufferedSource source = body2.source();
                        source.request(Long.MAX_VALUE);
                        Buffer buffer2 = source.buffer();
                        Charset charset2 = f19678I0Io;
                        MediaType contentType2 = body2.contentType();
                        if (contentType2 != null) {
                            charset2 = contentType2.charset(charset2);
                        }
                        if (!oxoX(buffer2)) {
                            this.f19680oIX0oI.log("");
                            this.f19680oIX0oI.log("<-- END HTTP (binary " + buffer2.size() + "-byte body omitted)");
                            return proceed;
                        }
                        if (contentLength != 0) {
                            this.f19680oIX0oI.log("");
                            this.f19680oIX0oI.log(buffer2.clone().readString(charset2));
                        }
                        this.f19680oIX0oI.log("<-- END HTTP (" + buffer2.size() + "-byte body)");
                    }
                } else {
                    this.f19680oIX0oI.log("<-- END HTTP");
                }
            }
            return proceed;
        } catch (Exception e) {
            this.f19680oIX0oI.log("<-- HTTP FAILED " + request.url().uri().getPath() + "  : " + e);
            throw e;
        }
    }

    public final boolean oIX0oI(Headers headers) {
        String str = headers.get("Content-Encoding");
        if (str != null && !str.equalsIgnoreCase("identity")) {
            return true;
        }
        return false;
    }

    public HttpLoggingInterceptor(oIX0oI oix0oi) {
        this.f19679II0xO0 = Level.NONE;
        this.f19680oIX0oI = oix0oi;
    }
}
