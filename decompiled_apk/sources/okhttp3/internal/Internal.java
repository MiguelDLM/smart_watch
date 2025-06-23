package okhttp3.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.IIX0o;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

@xxIXOIIO(name = "Internal")
/* loaded from: classes6.dex */
public final class Internal {
    @OOXIXo
    public static final Headers.Builder addHeaderLenient(@OOXIXo Headers.Builder builder, @OOXIXo String line) {
        IIX0o.x0xO0oo(builder, "builder");
        IIX0o.x0xO0oo(line, "line");
        return builder.addLenient$okhttp(line);
    }

    public static final void applyConnectionSpec(@OOXIXo ConnectionSpec connectionSpec, @OOXIXo SSLSocket sslSocket, boolean z) {
        IIX0o.x0xO0oo(connectionSpec, "connectionSpec");
        IIX0o.x0xO0oo(sslSocket, "sslSocket");
        connectionSpec.apply$okhttp(sslSocket, z);
    }

    @oOoXoXO
    public static final Response cacheGet(@OOXIXo Cache cache, @OOXIXo Request request) {
        IIX0o.x0xO0oo(cache, "cache");
        IIX0o.x0xO0oo(request, "request");
        return cache.get$okhttp(request);
    }

    @OOXIXo
    public static final String cookieToString(@OOXIXo Cookie cookie, boolean z) {
        IIX0o.x0xO0oo(cookie, "cookie");
        return cookie.toString$okhttp(z);
    }

    @oOoXoXO
    public static final Cookie parseCookie(long j, @OOXIXo HttpUrl url, @OOXIXo String setCookie) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(setCookie, "setCookie");
        return Cookie.Companion.parse$okhttp(j, url, setCookie);
    }

    @OOXIXo
    public static final Headers.Builder addHeaderLenient(@OOXIXo Headers.Builder builder, @OOXIXo String name, @OOXIXo String value) {
        IIX0o.x0xO0oo(builder, "builder");
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(value, "value");
        return builder.addLenient$okhttp(name, value);
    }
}
