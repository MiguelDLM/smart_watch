package okhttp3.internal.http;

import OXOo.OOXIXo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.net.Proxy;
import kotlin.jvm.internal.IIX0o;
import okhttp3.HttpUrl;
import okhttp3.Request;

/* loaded from: classes6.dex */
public final class RequestLine {

    @OOXIXo
    public static final RequestLine INSTANCE = new RequestLine();

    private RequestLine() {
    }

    private final boolean includeAuthorityInRequestLine(Request request, Proxy.Type type) {
        if (!request.isHttps() && type == Proxy.Type.HTTP) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final String get(@OOXIXo Request request, @OOXIXo Proxy.Type proxyType) {
        IIX0o.x0xO0oo(request, "request");
        IIX0o.x0xO0oo(proxyType, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.method());
        sb.append(TokenParser.SP);
        RequestLine requestLine = INSTANCE;
        if (requestLine.includeAuthorityInRequestLine(request, proxyType)) {
            sb.append(request.url());
        } else {
            sb.append(requestLine.requestPath(request.url()));
        }
        sb.append(" HTTP/1.1");
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @OOXIXo
    public final String requestPath(@OOXIXo HttpUrl url) {
        IIX0o.x0xO0oo(url, "url");
        String encodedPath = url.encodedPath();
        String encodedQuery = url.encodedQuery();
        if (encodedQuery != null) {
            return encodedPath + '?' + encodedQuery;
        }
        return encodedPath;
    }
}
