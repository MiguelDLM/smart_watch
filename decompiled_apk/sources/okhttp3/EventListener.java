package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes6.dex */
public abstract class EventListener {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    @XO
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener$Companion$NONE$1
    };

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes6.dex */
    public interface Factory {
        @OOXIXo
        EventListener create(@OOXIXo Call call);
    }

    public void cacheConditionalHit(@OOXIXo Call call, @OOXIXo Response cachedResponse) {
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(cachedResponse, "cachedResponse");
    }

    public void cacheHit(@OOXIXo Call call, @OOXIXo Response response) {
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(response, "response");
    }

    public void cacheMiss(@OOXIXo Call call) {
        IIX0o.x0xO0oo(call, "call");
    }

    public void callEnd(@OOXIXo Call call) {
        IIX0o.x0xO0oo(call, "call");
    }

    public void callFailed(@OOXIXo Call call, @OOXIXo IOException ioe) {
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(ioe, "ioe");
    }

    public void callStart(@OOXIXo Call call) {
        IIX0o.x0xO0oo(call, "call");
    }

    public void canceled(@OOXIXo Call call) {
        IIX0o.x0xO0oo(call, "call");
    }

    public void connectEnd(@OOXIXo Call call, @OOXIXo InetSocketAddress inetSocketAddress, @OOXIXo Proxy proxy, @oOoXoXO Protocol protocol) {
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(inetSocketAddress, "inetSocketAddress");
        IIX0o.x0xO0oo(proxy, "proxy");
    }

    public void connectFailed(@OOXIXo Call call, @OOXIXo InetSocketAddress inetSocketAddress, @OOXIXo Proxy proxy, @oOoXoXO Protocol protocol, @OOXIXo IOException ioe) {
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(inetSocketAddress, "inetSocketAddress");
        IIX0o.x0xO0oo(proxy, "proxy");
        IIX0o.x0xO0oo(ioe, "ioe");
    }

    public void connectStart(@OOXIXo Call call, @OOXIXo InetSocketAddress inetSocketAddress, @OOXIXo Proxy proxy) {
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(inetSocketAddress, "inetSocketAddress");
        IIX0o.x0xO0oo(proxy, "proxy");
    }

    public void connectionAcquired(@OOXIXo Call call, @OOXIXo Connection connection) {
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(connection, "connection");
    }

    public void connectionReleased(@OOXIXo Call call, @OOXIXo Connection connection) {
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(connection, "connection");
    }

    public void dnsEnd(@OOXIXo Call call, @OOXIXo String domainName, @OOXIXo List<InetAddress> inetAddressList) {
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(domainName, "domainName");
        IIX0o.x0xO0oo(inetAddressList, "inetAddressList");
    }

    public void dnsStart(@OOXIXo Call call, @OOXIXo String domainName) {
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(domainName, "domainName");
    }

    public void proxySelectEnd(@OOXIXo Call call, @OOXIXo HttpUrl url, @OOXIXo List<Proxy> proxies) {
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(proxies, "proxies");
    }

    public void proxySelectStart(@OOXIXo Call call, @OOXIXo HttpUrl url) {
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(url, "url");
    }

    public void requestBodyEnd(@OOXIXo Call call, long j) {
        IIX0o.x0xO0oo(call, "call");
    }

    public void requestBodyStart(@OOXIXo Call call) {
        IIX0o.x0xO0oo(call, "call");
    }

    public void requestFailed(@OOXIXo Call call, @OOXIXo IOException ioe) {
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(ioe, "ioe");
    }

    public void requestHeadersEnd(@OOXIXo Call call, @OOXIXo Request request) {
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(request, "request");
    }

    public void requestHeadersStart(@OOXIXo Call call) {
        IIX0o.x0xO0oo(call, "call");
    }

    public void responseBodyEnd(@OOXIXo Call call, long j) {
        IIX0o.x0xO0oo(call, "call");
    }

    public void responseBodyStart(@OOXIXo Call call) {
        IIX0o.x0xO0oo(call, "call");
    }

    public void responseFailed(@OOXIXo Call call, @OOXIXo IOException ioe) {
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(ioe, "ioe");
    }

    public void responseHeadersEnd(@OOXIXo Call call, @OOXIXo Response response) {
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(response, "response");
    }

    public void responseHeadersStart(@OOXIXo Call call) {
        IIX0o.x0xO0oo(call, "call");
    }

    public void satisfactionFailure(@OOXIXo Call call, @OOXIXo Response response) {
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(response, "response");
    }

    public void secureConnectEnd(@OOXIXo Call call, @oOoXoXO Handshake handshake) {
        IIX0o.x0xO0oo(call, "call");
    }

    public void secureConnectStart(@OOXIXo Call call) {
        IIX0o.x0xO0oo(call, "call");
    }
}
