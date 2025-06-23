package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import java.net.Proxy;
import java.net.ProxySelector;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import o0oIxXOx.XIxXXX0x0;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.WebSocket;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@XX({"SMAP\nOkHttpClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkHttpClient.kt\nokhttp3/OkHttpClient\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1079:1\n2624#2,3:1080\n2624#2,3:1083\n1#3:1086\n*S KotlinDebug\n*F\n+ 1 OkHttpClient.kt\nokhttp3/OkHttpClient\n*L\n225#1:1080,3\n255#1:1083,3\n*E\n"})
/* loaded from: classes6.dex */
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {

    @OOXIXo
    private final Authenticator authenticator;

    @oOoXoXO
    private final Cache cache;
    private final int callTimeoutMillis;

    @oOoXoXO
    private final CertificateChainCleaner certificateChainCleaner;

    @OOXIXo
    private final CertificatePinner certificatePinner;
    private final int connectTimeoutMillis;

    @OOXIXo
    private final ConnectionPool connectionPool;

    @OOXIXo
    private final List<ConnectionSpec> connectionSpecs;

    @OOXIXo
    private final CookieJar cookieJar;

    @OOXIXo
    private final Dispatcher dispatcher;

    @OOXIXo
    private final Dns dns;

    @OOXIXo
    private final EventListener.Factory eventListenerFactory;
    private final boolean followRedirects;
    private final boolean followSslRedirects;

    @OOXIXo
    private final HostnameVerifier hostnameVerifier;

    @OOXIXo
    private final List<Interceptor> interceptors;
    private final long minWebSocketMessageToCompress;

    @OOXIXo
    private final List<Interceptor> networkInterceptors;
    private final int pingIntervalMillis;

    @OOXIXo
    private final List<Protocol> protocols;

    @oOoXoXO
    private final Proxy proxy;

    @OOXIXo
    private final Authenticator proxyAuthenticator;

    @OOXIXo
    private final ProxySelector proxySelector;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;

    @OOXIXo
    private final RouteDatabase routeDatabase;

    @OOXIXo
    private final SocketFactory socketFactory;

    @oOoXoXO
    private final SSLSocketFactory sslSocketFactoryOrNull;
    private final int writeTimeoutMillis;

    @oOoXoXO
    private final X509TrustManager x509TrustManager;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableListOf(Protocol.HTTP_2, Protocol.HTTP_1_1);

    @OOXIXo
    private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = Util.immutableListOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);

    @XX({"SMAP\nOkHttpClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkHttpClient.kt\nokhttp3/OkHttpClient$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1079:1\n1#2:1080\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class Builder {

        @OOXIXo
        private Authenticator authenticator;

        @oOoXoXO
        private Cache cache;
        private int callTimeout;

        @oOoXoXO
        private CertificateChainCleaner certificateChainCleaner;

        @OOXIXo
        private CertificatePinner certificatePinner;
        private int connectTimeout;

        @OOXIXo
        private ConnectionPool connectionPool;

        @OOXIXo
        private List<ConnectionSpec> connectionSpecs;

        @OOXIXo
        private CookieJar cookieJar;

        @OOXIXo
        private Dispatcher dispatcher;

        @OOXIXo
        private Dns dns;

        @OOXIXo
        private EventListener.Factory eventListenerFactory;
        private boolean followRedirects;
        private boolean followSslRedirects;

        @OOXIXo
        private HostnameVerifier hostnameVerifier;

        @OOXIXo
        private final List<Interceptor> interceptors;
        private long minWebSocketMessageToCompress;

        @OOXIXo
        private final List<Interceptor> networkInterceptors;
        private int pingInterval;

        @OOXIXo
        private List<? extends Protocol> protocols;

        @oOoXoXO
        private Proxy proxy;

        @OOXIXo
        private Authenticator proxyAuthenticator;

        @oOoXoXO
        private ProxySelector proxySelector;
        private int readTimeout;
        private boolean retryOnConnectionFailure;

        @oOoXoXO
        private RouteDatabase routeDatabase;

        @OOXIXo
        private SocketFactory socketFactory;

        @oOoXoXO
        private SSLSocketFactory sslSocketFactoryOrNull;
        private int writeTimeout;

        @oOoXoXO
        private X509TrustManager x509TrustManagerOrNull;

        public Builder() {
            this.dispatcher = new Dispatcher();
            this.connectionPool = new ConnectionPool();
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.eventListenerFactory = Util.asFactory(EventListener.NONE);
            this.retryOnConnectionFailure = true;
            Authenticator authenticator = Authenticator.NONE;
            this.authenticator = authenticator;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = CookieJar.NO_COOKIES;
            this.dns = Dns.SYSTEM;
            this.proxyAuthenticator = authenticator;
            SocketFactory socketFactory = SocketFactory.getDefault();
            IIX0o.oO(socketFactory, "getDefault()");
            this.socketFactory = socketFactory;
            Companion companion = OkHttpClient.Companion;
            this.connectionSpecs = companion.getDEFAULT_CONNECTION_SPECS$okhttp();
            this.protocols = companion.getDEFAULT_PROTOCOLS$okhttp();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.minWebSocketMessageToCompress = 1024L;
        }

        @OOXIXo
        @xxIXOIIO(name = "-addInterceptor")
        /* renamed from: -addInterceptor, reason: not valid java name */
        public final Builder m411addInterceptor(@OOXIXo final Oox.oOoXoXO<? super Interceptor.Chain, Response> block) {
            IIX0o.x0xO0oo(block, "block");
            return addInterceptor(new Interceptor() { // from class: okhttp3.OkHttpClient$Builder$addInterceptor$2
                @Override // okhttp3.Interceptor
                @OOXIXo
                public final Response intercept(@OOXIXo Interceptor.Chain chain) {
                    IIX0o.x0xO0oo(chain, "chain");
                    return block.invoke(chain);
                }
            });
        }

        @OOXIXo
        @xxIXOIIO(name = "-addNetworkInterceptor")
        /* renamed from: -addNetworkInterceptor, reason: not valid java name */
        public final Builder m412addNetworkInterceptor(@OOXIXo final Oox.oOoXoXO<? super Interceptor.Chain, Response> block) {
            IIX0o.x0xO0oo(block, "block");
            return addNetworkInterceptor(new Interceptor() { // from class: okhttp3.OkHttpClient$Builder$addNetworkInterceptor$2
                @Override // okhttp3.Interceptor
                @OOXIXo
                public final Response intercept(@OOXIXo Interceptor.Chain chain) {
                    IIX0o.x0xO0oo(chain, "chain");
                    return block.invoke(chain);
                }
            });
        }

        @OOXIXo
        public final Builder addInterceptor(@OOXIXo Interceptor interceptor) {
            IIX0o.x0xO0oo(interceptor, "interceptor");
            this.interceptors.add(interceptor);
            return this;
        }

        @OOXIXo
        public final Builder addNetworkInterceptor(@OOXIXo Interceptor interceptor) {
            IIX0o.x0xO0oo(interceptor, "interceptor");
            this.networkInterceptors.add(interceptor);
            return this;
        }

        @OOXIXo
        public final Builder authenticator(@OOXIXo Authenticator authenticator) {
            IIX0o.x0xO0oo(authenticator, "authenticator");
            this.authenticator = authenticator;
            return this;
        }

        @OOXIXo
        public final OkHttpClient build() {
            return new OkHttpClient(this);
        }

        @OOXIXo
        public final Builder cache(@oOoXoXO Cache cache) {
            this.cache = cache;
            return this;
        }

        @OOXIXo
        public final Builder callTimeout(long j, @OOXIXo TimeUnit unit) {
            IIX0o.x0xO0oo(unit, "unit");
            this.callTimeout = Util.checkDuration("timeout", j, unit);
            return this;
        }

        @OOXIXo
        public final Builder certificatePinner(@OOXIXo CertificatePinner certificatePinner) {
            IIX0o.x0xO0oo(certificatePinner, "certificatePinner");
            if (!IIX0o.Oxx0IOOO(certificatePinner, this.certificatePinner)) {
                this.routeDatabase = null;
            }
            this.certificatePinner = certificatePinner;
            return this;
        }

        @OOXIXo
        public final Builder connectTimeout(long j, @OOXIXo TimeUnit unit) {
            IIX0o.x0xO0oo(unit, "unit");
            this.connectTimeout = Util.checkDuration("timeout", j, unit);
            return this;
        }

        @OOXIXo
        public final Builder connectionPool(@OOXIXo ConnectionPool connectionPool) {
            IIX0o.x0xO0oo(connectionPool, "connectionPool");
            this.connectionPool = connectionPool;
            return this;
        }

        @OOXIXo
        public final Builder connectionSpecs(@OOXIXo List<ConnectionSpec> connectionSpecs) {
            IIX0o.x0xO0oo(connectionSpecs, "connectionSpecs");
            if (!IIX0o.Oxx0IOOO(connectionSpecs, this.connectionSpecs)) {
                this.routeDatabase = null;
            }
            this.connectionSpecs = Util.toImmutableList(connectionSpecs);
            return this;
        }

        @OOXIXo
        public final Builder cookieJar(@OOXIXo CookieJar cookieJar) {
            IIX0o.x0xO0oo(cookieJar, "cookieJar");
            this.cookieJar = cookieJar;
            return this;
        }

        @OOXIXo
        public final Builder dispatcher(@OOXIXo Dispatcher dispatcher) {
            IIX0o.x0xO0oo(dispatcher, "dispatcher");
            this.dispatcher = dispatcher;
            return this;
        }

        @OOXIXo
        public final Builder dns(@OOXIXo Dns dns) {
            IIX0o.x0xO0oo(dns, "dns");
            if (!IIX0o.Oxx0IOOO(dns, this.dns)) {
                this.routeDatabase = null;
            }
            this.dns = dns;
            return this;
        }

        @OOXIXo
        public final Builder eventListener(@OOXIXo EventListener eventListener) {
            IIX0o.x0xO0oo(eventListener, "eventListener");
            this.eventListenerFactory = Util.asFactory(eventListener);
            return this;
        }

        @OOXIXo
        public final Builder eventListenerFactory(@OOXIXo EventListener.Factory eventListenerFactory) {
            IIX0o.x0xO0oo(eventListenerFactory, "eventListenerFactory");
            this.eventListenerFactory = eventListenerFactory;
            return this;
        }

        @OOXIXo
        public final Builder followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        @OOXIXo
        public final Builder followSslRedirects(boolean z) {
            this.followSslRedirects = z;
            return this;
        }

        @OOXIXo
        public final Authenticator getAuthenticator$okhttp() {
            return this.authenticator;
        }

        @oOoXoXO
        public final Cache getCache$okhttp() {
            return this.cache;
        }

        public final int getCallTimeout$okhttp() {
            return this.callTimeout;
        }

        @oOoXoXO
        public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
            return this.certificateChainCleaner;
        }

        @OOXIXo
        public final CertificatePinner getCertificatePinner$okhttp() {
            return this.certificatePinner;
        }

        public final int getConnectTimeout$okhttp() {
            return this.connectTimeout;
        }

        @OOXIXo
        public final ConnectionPool getConnectionPool$okhttp() {
            return this.connectionPool;
        }

        @OOXIXo
        public final List<ConnectionSpec> getConnectionSpecs$okhttp() {
            return this.connectionSpecs;
        }

        @OOXIXo
        public final CookieJar getCookieJar$okhttp() {
            return this.cookieJar;
        }

        @OOXIXo
        public final Dispatcher getDispatcher$okhttp() {
            return this.dispatcher;
        }

        @OOXIXo
        public final Dns getDns$okhttp() {
            return this.dns;
        }

        @OOXIXo
        public final EventListener.Factory getEventListenerFactory$okhttp() {
            return this.eventListenerFactory;
        }

        public final boolean getFollowRedirects$okhttp() {
            return this.followRedirects;
        }

        public final boolean getFollowSslRedirects$okhttp() {
            return this.followSslRedirects;
        }

        @OOXIXo
        public final HostnameVerifier getHostnameVerifier$okhttp() {
            return this.hostnameVerifier;
        }

        @OOXIXo
        public final List<Interceptor> getInterceptors$okhttp() {
            return this.interceptors;
        }

        public final long getMinWebSocketMessageToCompress$okhttp() {
            return this.minWebSocketMessageToCompress;
        }

        @OOXIXo
        public final List<Interceptor> getNetworkInterceptors$okhttp() {
            return this.networkInterceptors;
        }

        public final int getPingInterval$okhttp() {
            return this.pingInterval;
        }

        @OOXIXo
        public final List<Protocol> getProtocols$okhttp() {
            return this.protocols;
        }

        @oOoXoXO
        public final Proxy getProxy$okhttp() {
            return this.proxy;
        }

        @OOXIXo
        public final Authenticator getProxyAuthenticator$okhttp() {
            return this.proxyAuthenticator;
        }

        @oOoXoXO
        public final ProxySelector getProxySelector$okhttp() {
            return this.proxySelector;
        }

        public final int getReadTimeout$okhttp() {
            return this.readTimeout;
        }

        public final boolean getRetryOnConnectionFailure$okhttp() {
            return this.retryOnConnectionFailure;
        }

        @oOoXoXO
        public final RouteDatabase getRouteDatabase$okhttp() {
            return this.routeDatabase;
        }

        @OOXIXo
        public final SocketFactory getSocketFactory$okhttp() {
            return this.socketFactory;
        }

        @oOoXoXO
        public final SSLSocketFactory getSslSocketFactoryOrNull$okhttp() {
            return this.sslSocketFactoryOrNull;
        }

        public final int getWriteTimeout$okhttp() {
            return this.writeTimeout;
        }

        @oOoXoXO
        public final X509TrustManager getX509TrustManagerOrNull$okhttp() {
            return this.x509TrustManagerOrNull;
        }

        @OOXIXo
        public final Builder hostnameVerifier(@OOXIXo HostnameVerifier hostnameVerifier) {
            IIX0o.x0xO0oo(hostnameVerifier, "hostnameVerifier");
            if (!IIX0o.Oxx0IOOO(hostnameVerifier, this.hostnameVerifier)) {
                this.routeDatabase = null;
            }
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        @OOXIXo
        public final List<Interceptor> interceptors() {
            return this.interceptors;
        }

        @OOXIXo
        public final Builder minWebSocketMessageToCompress(long j) {
            if (j >= 0) {
                this.minWebSocketMessageToCompress = j;
                return this;
            }
            throw new IllegalArgumentException(("minWebSocketMessageToCompress must be positive: " + j).toString());
        }

        @OOXIXo
        public final List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        @OOXIXo
        public final Builder pingInterval(long j, @OOXIXo TimeUnit unit) {
            IIX0o.x0xO0oo(unit, "unit");
            this.pingInterval = Util.checkDuration("interval", j, unit);
            return this;
        }

        @OOXIXo
        public final Builder protocols(@OOXIXo List<? extends Protocol> protocols) {
            IIX0o.x0xO0oo(protocols, "protocols");
            List o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(protocols);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!o0Xo0XII.contains(protocol) && !o0Xo0XII.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + o0Xo0XII).toString());
            }
            if (o0Xo0XII.contains(protocol) && o0Xo0XII.size() > 1) {
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + o0Xo0XII).toString());
            }
            if (!o0Xo0XII.contains(Protocol.HTTP_1_0)) {
                IIX0o.x0XOIxOo(o0Xo0XII, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Protocol?>");
                if (!o0Xo0XII.contains(null)) {
                    o0Xo0XII.remove(Protocol.SPDY_3);
                    if (!IIX0o.Oxx0IOOO(o0Xo0XII, this.protocols)) {
                        this.routeDatabase = null;
                    }
                    List<? extends Protocol> unmodifiableList = Collections.unmodifiableList(o0Xo0XII);
                    IIX0o.oO(unmodifiableList, "unmodifiableList(protocolsCopy)");
                    this.protocols = unmodifiableList;
                    return this;
                }
                throw new IllegalArgumentException("protocols must not contain null");
            }
            throw new IllegalArgumentException(("protocols must not contain http/1.0: " + o0Xo0XII).toString());
        }

        @OOXIXo
        public final Builder proxy(@oOoXoXO Proxy proxy) {
            if (!IIX0o.Oxx0IOOO(proxy, this.proxy)) {
                this.routeDatabase = null;
            }
            this.proxy = proxy;
            return this;
        }

        @OOXIXo
        public final Builder proxyAuthenticator(@OOXIXo Authenticator proxyAuthenticator) {
            IIX0o.x0xO0oo(proxyAuthenticator, "proxyAuthenticator");
            if (!IIX0o.Oxx0IOOO(proxyAuthenticator, this.proxyAuthenticator)) {
                this.routeDatabase = null;
            }
            this.proxyAuthenticator = proxyAuthenticator;
            return this;
        }

        @OOXIXo
        public final Builder proxySelector(@OOXIXo ProxySelector proxySelector) {
            IIX0o.x0xO0oo(proxySelector, "proxySelector");
            if (!IIX0o.Oxx0IOOO(proxySelector, this.proxySelector)) {
                this.routeDatabase = null;
            }
            this.proxySelector = proxySelector;
            return this;
        }

        @OOXIXo
        public final Builder readTimeout(long j, @OOXIXo TimeUnit unit) {
            IIX0o.x0xO0oo(unit, "unit");
            this.readTimeout = Util.checkDuration("timeout", j, unit);
            return this;
        }

        @OOXIXo
        public final Builder retryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        public final void setAuthenticator$okhttp(@OOXIXo Authenticator authenticator) {
            IIX0o.x0xO0oo(authenticator, "<set-?>");
            this.authenticator = authenticator;
        }

        public final void setCache$okhttp(@oOoXoXO Cache cache) {
            this.cache = cache;
        }

        public final void setCallTimeout$okhttp(int i) {
            this.callTimeout = i;
        }

        public final void setCertificateChainCleaner$okhttp(@oOoXoXO CertificateChainCleaner certificateChainCleaner) {
            this.certificateChainCleaner = certificateChainCleaner;
        }

        public final void setCertificatePinner$okhttp(@OOXIXo CertificatePinner certificatePinner) {
            IIX0o.x0xO0oo(certificatePinner, "<set-?>");
            this.certificatePinner = certificatePinner;
        }

        public final void setConnectTimeout$okhttp(int i) {
            this.connectTimeout = i;
        }

        public final void setConnectionPool$okhttp(@OOXIXo ConnectionPool connectionPool) {
            IIX0o.x0xO0oo(connectionPool, "<set-?>");
            this.connectionPool = connectionPool;
        }

        public final void setConnectionSpecs$okhttp(@OOXIXo List<ConnectionSpec> list) {
            IIX0o.x0xO0oo(list, "<set-?>");
            this.connectionSpecs = list;
        }

        public final void setCookieJar$okhttp(@OOXIXo CookieJar cookieJar) {
            IIX0o.x0xO0oo(cookieJar, "<set-?>");
            this.cookieJar = cookieJar;
        }

        public final void setDispatcher$okhttp(@OOXIXo Dispatcher dispatcher) {
            IIX0o.x0xO0oo(dispatcher, "<set-?>");
            this.dispatcher = dispatcher;
        }

        public final void setDns$okhttp(@OOXIXo Dns dns) {
            IIX0o.x0xO0oo(dns, "<set-?>");
            this.dns = dns;
        }

        public final void setEventListenerFactory$okhttp(@OOXIXo EventListener.Factory factory) {
            IIX0o.x0xO0oo(factory, "<set-?>");
            this.eventListenerFactory = factory;
        }

        public final void setFollowRedirects$okhttp(boolean z) {
            this.followRedirects = z;
        }

        public final void setFollowSslRedirects$okhttp(boolean z) {
            this.followSslRedirects = z;
        }

        public final void setHostnameVerifier$okhttp(@OOXIXo HostnameVerifier hostnameVerifier) {
            IIX0o.x0xO0oo(hostnameVerifier, "<set-?>");
            this.hostnameVerifier = hostnameVerifier;
        }

        public final void setMinWebSocketMessageToCompress$okhttp(long j) {
            this.minWebSocketMessageToCompress = j;
        }

        public final void setPingInterval$okhttp(int i) {
            this.pingInterval = i;
        }

        public final void setProtocols$okhttp(@OOXIXo List<? extends Protocol> list) {
            IIX0o.x0xO0oo(list, "<set-?>");
            this.protocols = list;
        }

        public final void setProxy$okhttp(@oOoXoXO Proxy proxy) {
            this.proxy = proxy;
        }

        public final void setProxyAuthenticator$okhttp(@OOXIXo Authenticator authenticator) {
            IIX0o.x0xO0oo(authenticator, "<set-?>");
            this.proxyAuthenticator = authenticator;
        }

        public final void setProxySelector$okhttp(@oOoXoXO ProxySelector proxySelector) {
            this.proxySelector = proxySelector;
        }

        public final void setReadTimeout$okhttp(int i) {
            this.readTimeout = i;
        }

        public final void setRetryOnConnectionFailure$okhttp(boolean z) {
            this.retryOnConnectionFailure = z;
        }

        public final void setRouteDatabase$okhttp(@oOoXoXO RouteDatabase routeDatabase) {
            this.routeDatabase = routeDatabase;
        }

        public final void setSocketFactory$okhttp(@OOXIXo SocketFactory socketFactory) {
            IIX0o.x0xO0oo(socketFactory, "<set-?>");
            this.socketFactory = socketFactory;
        }

        public final void setSslSocketFactoryOrNull$okhttp(@oOoXoXO SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactoryOrNull = sSLSocketFactory;
        }

        public final void setWriteTimeout$okhttp(int i) {
            this.writeTimeout = i;
        }

        public final void setX509TrustManagerOrNull$okhttp(@oOoXoXO X509TrustManager x509TrustManager) {
            this.x509TrustManagerOrNull = x509TrustManager;
        }

        @OOXIXo
        public final Builder socketFactory(@OOXIXo SocketFactory socketFactory) {
            IIX0o.x0xO0oo(socketFactory, "socketFactory");
            if (!(socketFactory instanceof SSLSocketFactory)) {
                if (!IIX0o.Oxx0IOOO(socketFactory, this.socketFactory)) {
                    this.routeDatabase = null;
                }
                this.socketFactory = socketFactory;
                return this;
            }
            throw new IllegalArgumentException("socketFactory instanceof SSLSocketFactory");
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use the sslSocketFactory overload that accepts a X509TrustManager.")
        @OOXIXo
        public final Builder sslSocketFactory(@OOXIXo SSLSocketFactory sslSocketFactory) {
            IIX0o.x0xO0oo(sslSocketFactory, "sslSocketFactory");
            if (!IIX0o.Oxx0IOOO(sslSocketFactory, this.sslSocketFactoryOrNull)) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sslSocketFactory;
            Platform.Companion companion = Platform.Companion;
            X509TrustManager trustManager = companion.get().trustManager(sslSocketFactory);
            if (trustManager != null) {
                this.x509TrustManagerOrNull = trustManager;
                Platform platform = companion.get();
                X509TrustManager x509TrustManager = this.x509TrustManagerOrNull;
                IIX0o.ooOOo0oXI(x509TrustManager);
                this.certificateChainCleaner = platform.buildCertificateChainCleaner(x509TrustManager);
                return this;
            }
            throw new IllegalStateException("Unable to extract the trust manager on " + companion.get() + ", sslSocketFactory is " + sslSocketFactory.getClass());
        }

        @OOXIXo
        public final Builder writeTimeout(long j, @OOXIXo TimeUnit unit) {
            IIX0o.x0xO0oo(unit, "unit");
            this.writeTimeout = Util.checkDuration("timeout", j, unit);
            return this;
        }

        @OOXIXo
        @IgnoreJRERequirement
        public final Builder callTimeout(@OOXIXo Duration duration) {
            long millis;
            IIX0o.x0xO0oo(duration, "duration");
            millis = duration.toMillis();
            callTimeout(millis, TimeUnit.MILLISECONDS);
            return this;
        }

        @OOXIXo
        @IgnoreJRERequirement
        public final Builder connectTimeout(@OOXIXo Duration duration) {
            long millis;
            IIX0o.x0xO0oo(duration, "duration");
            millis = duration.toMillis();
            connectTimeout(millis, TimeUnit.MILLISECONDS);
            return this;
        }

        @OOXIXo
        @IgnoreJRERequirement
        public final Builder pingInterval(@OOXIXo Duration duration) {
            long millis;
            IIX0o.x0xO0oo(duration, "duration");
            millis = duration.toMillis();
            pingInterval(millis, TimeUnit.MILLISECONDS);
            return this;
        }

        @OOXIXo
        @IgnoreJRERequirement
        public final Builder readTimeout(@OOXIXo Duration duration) {
            long millis;
            IIX0o.x0xO0oo(duration, "duration");
            millis = duration.toMillis();
            readTimeout(millis, TimeUnit.MILLISECONDS);
            return this;
        }

        @OOXIXo
        @IgnoreJRERequirement
        public final Builder writeTimeout(@OOXIXo Duration duration) {
            long millis;
            IIX0o.x0xO0oo(duration, "duration");
            millis = duration.toMillis();
            writeTimeout(millis, TimeUnit.MILLISECONDS);
            return this;
        }

        @OOXIXo
        public final Builder sslSocketFactory(@OOXIXo SSLSocketFactory sslSocketFactory, @OOXIXo X509TrustManager trustManager) {
            IIX0o.x0xO0oo(sslSocketFactory, "sslSocketFactory");
            IIX0o.x0xO0oo(trustManager, "trustManager");
            if (!IIX0o.Oxx0IOOO(sslSocketFactory, this.sslSocketFactoryOrNull) || !IIX0o.Oxx0IOOO(trustManager, this.x509TrustManagerOrNull)) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sslSocketFactory;
            this.certificateChainCleaner = CertificateChainCleaner.Companion.get(trustManager);
            this.x509TrustManagerOrNull = trustManager;
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(@OOXIXo OkHttpClient okHttpClient) {
            this();
            IIX0o.x0xO0oo(okHttpClient, "okHttpClient");
            this.dispatcher = okHttpClient.dispatcher();
            this.connectionPool = okHttpClient.connectionPool();
            OxI.XIo0oOXIx(this.interceptors, okHttpClient.interceptors());
            OxI.XIo0oOXIx(this.networkInterceptors, okHttpClient.networkInterceptors());
            this.eventListenerFactory = okHttpClient.eventListenerFactory();
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure();
            this.authenticator = okHttpClient.authenticator();
            this.followRedirects = okHttpClient.followRedirects();
            this.followSslRedirects = okHttpClient.followSslRedirects();
            this.cookieJar = okHttpClient.cookieJar();
            this.cache = okHttpClient.cache();
            this.dns = okHttpClient.dns();
            this.proxy = okHttpClient.proxy();
            this.proxySelector = okHttpClient.proxySelector();
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator();
            this.socketFactory = okHttpClient.socketFactory();
            this.sslSocketFactoryOrNull = okHttpClient.sslSocketFactoryOrNull;
            this.x509TrustManagerOrNull = okHttpClient.x509TrustManager();
            this.connectionSpecs = okHttpClient.connectionSpecs();
            this.protocols = okHttpClient.protocols();
            this.hostnameVerifier = okHttpClient.hostnameVerifier();
            this.certificatePinner = okHttpClient.certificatePinner();
            this.certificateChainCleaner = okHttpClient.certificateChainCleaner();
            this.callTimeout = okHttpClient.callTimeoutMillis();
            this.connectTimeout = okHttpClient.connectTimeoutMillis();
            this.readTimeout = okHttpClient.readTimeoutMillis();
            this.writeTimeout = okHttpClient.writeTimeoutMillis();
            this.pingInterval = okHttpClient.pingIntervalMillis();
            this.minWebSocketMessageToCompress = okHttpClient.minWebSocketMessageToCompress();
            this.routeDatabase = okHttpClient.getRouteDatabase();
        }
    }

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final List<ConnectionSpec> getDEFAULT_CONNECTION_SPECS$okhttp() {
            return OkHttpClient.DEFAULT_CONNECTION_SPECS;
        }

        @OOXIXo
        public final List<Protocol> getDEFAULT_PROTOCOLS$okhttp() {
            return OkHttpClient.DEFAULT_PROTOCOLS;
        }

        private Companion() {
        }
    }

    public OkHttpClient(@OOXIXo Builder builder) {
        ProxySelector proxySelector$okhttp;
        IIX0o.x0xO0oo(builder, "builder");
        this.dispatcher = builder.getDispatcher$okhttp();
        this.connectionPool = builder.getConnectionPool$okhttp();
        this.interceptors = Util.toImmutableList(builder.getInterceptors$okhttp());
        this.networkInterceptors = Util.toImmutableList(builder.getNetworkInterceptors$okhttp());
        this.eventListenerFactory = builder.getEventListenerFactory$okhttp();
        this.retryOnConnectionFailure = builder.getRetryOnConnectionFailure$okhttp();
        this.authenticator = builder.getAuthenticator$okhttp();
        this.followRedirects = builder.getFollowRedirects$okhttp();
        this.followSslRedirects = builder.getFollowSslRedirects$okhttp();
        this.cookieJar = builder.getCookieJar$okhttp();
        this.cache = builder.getCache$okhttp();
        this.dns = builder.getDns$okhttp();
        this.proxy = builder.getProxy$okhttp();
        if (builder.getProxy$okhttp() != null) {
            proxySelector$okhttp = NullProxySelector.INSTANCE;
        } else {
            proxySelector$okhttp = builder.getProxySelector$okhttp();
            proxySelector$okhttp = proxySelector$okhttp == null ? ProxySelector.getDefault() : proxySelector$okhttp;
            if (proxySelector$okhttp == null) {
                proxySelector$okhttp = NullProxySelector.INSTANCE;
            }
        }
        this.proxySelector = proxySelector$okhttp;
        this.proxyAuthenticator = builder.getProxyAuthenticator$okhttp();
        this.socketFactory = builder.getSocketFactory$okhttp();
        List<ConnectionSpec> connectionSpecs$okhttp = builder.getConnectionSpecs$okhttp();
        this.connectionSpecs = connectionSpecs$okhttp;
        this.protocols = builder.getProtocols$okhttp();
        this.hostnameVerifier = builder.getHostnameVerifier$okhttp();
        this.callTimeoutMillis = builder.getCallTimeout$okhttp();
        this.connectTimeoutMillis = builder.getConnectTimeout$okhttp();
        this.readTimeoutMillis = builder.getReadTimeout$okhttp();
        this.writeTimeoutMillis = builder.getWriteTimeout$okhttp();
        this.pingIntervalMillis = builder.getPingInterval$okhttp();
        this.minWebSocketMessageToCompress = builder.getMinWebSocketMessageToCompress$okhttp();
        RouteDatabase routeDatabase$okhttp = builder.getRouteDatabase$okhttp();
        this.routeDatabase = routeDatabase$okhttp == null ? new RouteDatabase() : routeDatabase$okhttp;
        List<ConnectionSpec> list = connectionSpecs$okhttp;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((ConnectionSpec) it.next()).isTls()) {
                    if (builder.getSslSocketFactoryOrNull$okhttp() != null) {
                        this.sslSocketFactoryOrNull = builder.getSslSocketFactoryOrNull$okhttp();
                        CertificateChainCleaner certificateChainCleaner$okhttp = builder.getCertificateChainCleaner$okhttp();
                        IIX0o.ooOOo0oXI(certificateChainCleaner$okhttp);
                        this.certificateChainCleaner = certificateChainCleaner$okhttp;
                        X509TrustManager x509TrustManagerOrNull$okhttp = builder.getX509TrustManagerOrNull$okhttp();
                        IIX0o.ooOOo0oXI(x509TrustManagerOrNull$okhttp);
                        this.x509TrustManager = x509TrustManagerOrNull$okhttp;
                        CertificatePinner certificatePinner$okhttp = builder.getCertificatePinner$okhttp();
                        IIX0o.ooOOo0oXI(certificateChainCleaner$okhttp);
                        this.certificatePinner = certificatePinner$okhttp.withCertificateChainCleaner$okhttp(certificateChainCleaner$okhttp);
                    } else {
                        Platform.Companion companion = Platform.Companion;
                        X509TrustManager platformTrustManager = companion.get().platformTrustManager();
                        this.x509TrustManager = platformTrustManager;
                        Platform platform = companion.get();
                        IIX0o.ooOOo0oXI(platformTrustManager);
                        this.sslSocketFactoryOrNull = platform.newSslSocketFactory(platformTrustManager);
                        CertificateChainCleaner.Companion companion2 = CertificateChainCleaner.Companion;
                        IIX0o.ooOOo0oXI(platformTrustManager);
                        CertificateChainCleaner certificateChainCleaner = companion2.get(platformTrustManager);
                        this.certificateChainCleaner = certificateChainCleaner;
                        CertificatePinner certificatePinner$okhttp2 = builder.getCertificatePinner$okhttp();
                        IIX0o.ooOOo0oXI(certificateChainCleaner);
                        this.certificatePinner = certificatePinner$okhttp2.withCertificateChainCleaner$okhttp(certificateChainCleaner);
                    }
                    verifyClientState();
                }
            }
        }
        this.sslSocketFactoryOrNull = null;
        this.certificateChainCleaner = null;
        this.x509TrustManager = null;
        this.certificatePinner = CertificatePinner.DEFAULT;
        verifyClientState();
    }

    private final void verifyClientState() {
        List<Interceptor> list = this.interceptors;
        IIX0o.x0XOIxOo(list, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (!list.contains(null)) {
            List<Interceptor> list2 = this.networkInterceptors;
            IIX0o.x0XOIxOo(list2, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
            if (!list2.contains(null)) {
                List<ConnectionSpec> list3 = this.connectionSpecs;
                if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                    Iterator<T> it = list3.iterator();
                    while (it.hasNext()) {
                        if (((ConnectionSpec) it.next()).isTls()) {
                            if (this.sslSocketFactoryOrNull != null) {
                                if (this.certificateChainCleaner != null) {
                                    if (this.x509TrustManager == null) {
                                        throw new IllegalStateException("x509TrustManager == null");
                                    }
                                    return;
                                }
                                throw new IllegalStateException("certificateChainCleaner == null");
                            }
                            throw new IllegalStateException("sslSocketFactory == null");
                        }
                    }
                }
                if (this.sslSocketFactoryOrNull == null) {
                    if (this.certificateChainCleaner == null) {
                        if (this.x509TrustManager == null) {
                            if (IIX0o.Oxx0IOOO(this.certificatePinner, CertificatePinner.DEFAULT)) {
                                return;
                            } else {
                                throw new IllegalStateException("Check failed.");
                            }
                        }
                        throw new IllegalStateException("Check failed.");
                    }
                    throw new IllegalStateException("Check failed.");
                }
                throw new IllegalStateException("Check failed.");
            }
            throw new IllegalStateException(("Null network interceptor: " + this.networkInterceptors).toString());
        }
        throw new IllegalStateException(("Null interceptor: " + this.interceptors).toString());
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "authenticator", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_authenticator")
    /* renamed from: -deprecated_authenticator, reason: not valid java name */
    public final Authenticator m385deprecated_authenticator() {
        return this.authenticator;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "cache", imports = {}))
    @xxIXOIIO(name = "-deprecated_cache")
    @oOoXoXO
    /* renamed from: -deprecated_cache, reason: not valid java name */
    public final Cache m386deprecated_cache() {
        return this.cache;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "callTimeoutMillis", imports = {}))
    @xxIXOIIO(name = "-deprecated_callTimeoutMillis")
    /* renamed from: -deprecated_callTimeoutMillis, reason: not valid java name */
    public final int m387deprecated_callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "certificatePinner", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_certificatePinner")
    /* renamed from: -deprecated_certificatePinner, reason: not valid java name */
    public final CertificatePinner m388deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "connectTimeoutMillis", imports = {}))
    @xxIXOIIO(name = "-deprecated_connectTimeoutMillis")
    /* renamed from: -deprecated_connectTimeoutMillis, reason: not valid java name */
    public final int m389deprecated_connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "connectionPool", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_connectionPool")
    /* renamed from: -deprecated_connectionPool, reason: not valid java name */
    public final ConnectionPool m390deprecated_connectionPool() {
        return this.connectionPool;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "connectionSpecs", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_connectionSpecs")
    /* renamed from: -deprecated_connectionSpecs, reason: not valid java name */
    public final List<ConnectionSpec> m391deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "cookieJar", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_cookieJar")
    /* renamed from: -deprecated_cookieJar, reason: not valid java name */
    public final CookieJar m392deprecated_cookieJar() {
        return this.cookieJar;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "dispatcher", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_dispatcher")
    /* renamed from: -deprecated_dispatcher, reason: not valid java name */
    public final Dispatcher m393deprecated_dispatcher() {
        return this.dispatcher;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = XIxXXX0x0.f31163OOXIXo, imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_dns")
    /* renamed from: -deprecated_dns, reason: not valid java name */
    public final Dns m394deprecated_dns() {
        return this.dns;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "eventListenerFactory", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_eventListenerFactory")
    /* renamed from: -deprecated_eventListenerFactory, reason: not valid java name */
    public final EventListener.Factory m395deprecated_eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "followRedirects", imports = {}))
    @xxIXOIIO(name = "-deprecated_followRedirects")
    /* renamed from: -deprecated_followRedirects, reason: not valid java name */
    public final boolean m396deprecated_followRedirects() {
        return this.followRedirects;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "followSslRedirects", imports = {}))
    @xxIXOIIO(name = "-deprecated_followSslRedirects")
    /* renamed from: -deprecated_followSslRedirects, reason: not valid java name */
    public final boolean m397deprecated_followSslRedirects() {
        return this.followSslRedirects;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "hostnameVerifier", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_hostnameVerifier")
    /* renamed from: -deprecated_hostnameVerifier, reason: not valid java name */
    public final HostnameVerifier m398deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "interceptors", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_interceptors")
    /* renamed from: -deprecated_interceptors, reason: not valid java name */
    public final List<Interceptor> m399deprecated_interceptors() {
        return this.interceptors;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "networkInterceptors", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_networkInterceptors")
    /* renamed from: -deprecated_networkInterceptors, reason: not valid java name */
    public final List<Interceptor> m400deprecated_networkInterceptors() {
        return this.networkInterceptors;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "pingIntervalMillis", imports = {}))
    @xxIXOIIO(name = "-deprecated_pingIntervalMillis")
    /* renamed from: -deprecated_pingIntervalMillis, reason: not valid java name */
    public final int m401deprecated_pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "protocols", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_protocols")
    /* renamed from: -deprecated_protocols, reason: not valid java name */
    public final List<Protocol> m402deprecated_protocols() {
        return this.protocols;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "proxy", imports = {}))
    @xxIXOIIO(name = "-deprecated_proxy")
    @oOoXoXO
    /* renamed from: -deprecated_proxy, reason: not valid java name */
    public final Proxy m403deprecated_proxy() {
        return this.proxy;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "proxyAuthenticator", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_proxyAuthenticator")
    /* renamed from: -deprecated_proxyAuthenticator, reason: not valid java name */
    public final Authenticator m404deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "proxySelector", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_proxySelector")
    /* renamed from: -deprecated_proxySelector, reason: not valid java name */
    public final ProxySelector m405deprecated_proxySelector() {
        return this.proxySelector;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "readTimeoutMillis", imports = {}))
    @xxIXOIIO(name = "-deprecated_readTimeoutMillis")
    /* renamed from: -deprecated_readTimeoutMillis, reason: not valid java name */
    public final int m406deprecated_readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "retryOnConnectionFailure", imports = {}))
    @xxIXOIIO(name = "-deprecated_retryOnConnectionFailure")
    /* renamed from: -deprecated_retryOnConnectionFailure, reason: not valid java name */
    public final boolean m407deprecated_retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "socketFactory", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_socketFactory")
    /* renamed from: -deprecated_socketFactory, reason: not valid java name */
    public final SocketFactory m408deprecated_socketFactory() {
        return this.socketFactory;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "sslSocketFactory", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_sslSocketFactory")
    /* renamed from: -deprecated_sslSocketFactory, reason: not valid java name */
    public final SSLSocketFactory m409deprecated_sslSocketFactory() {
        return sslSocketFactory();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "writeTimeoutMillis", imports = {}))
    @xxIXOIIO(name = "-deprecated_writeTimeoutMillis")
    /* renamed from: -deprecated_writeTimeoutMillis, reason: not valid java name */
    public final int m410deprecated_writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @OOXIXo
    @xxIXOIIO(name = "authenticator")
    public final Authenticator authenticator() {
        return this.authenticator;
    }

    @xxIXOIIO(name = "cache")
    @oOoXoXO
    public final Cache cache() {
        return this.cache;
    }

    @xxIXOIIO(name = "callTimeoutMillis")
    public final int callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @xxIXOIIO(name = "certificateChainCleaner")
    @oOoXoXO
    public final CertificateChainCleaner certificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    @OOXIXo
    @xxIXOIIO(name = "certificatePinner")
    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    @OOXIXo
    public Object clone() {
        return super.clone();
    }

    @xxIXOIIO(name = "connectTimeoutMillis")
    public final int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @OOXIXo
    @xxIXOIIO(name = "connectionPool")
    public final ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    @OOXIXo
    @xxIXOIIO(name = "connectionSpecs")
    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    @OOXIXo
    @xxIXOIIO(name = "cookieJar")
    public final CookieJar cookieJar() {
        return this.cookieJar;
    }

    @OOXIXo
    @xxIXOIIO(name = "dispatcher")
    public final Dispatcher dispatcher() {
        return this.dispatcher;
    }

    @OOXIXo
    @xxIXOIIO(name = XIxXXX0x0.f31163OOXIXo)
    public final Dns dns() {
        return this.dns;
    }

    @OOXIXo
    @xxIXOIIO(name = "eventListenerFactory")
    public final EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @xxIXOIIO(name = "followRedirects")
    public final boolean followRedirects() {
        return this.followRedirects;
    }

    @xxIXOIIO(name = "followSslRedirects")
    public final boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    @OOXIXo
    public final RouteDatabase getRouteDatabase() {
        return this.routeDatabase;
    }

    @OOXIXo
    @xxIXOIIO(name = "hostnameVerifier")
    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @OOXIXo
    @xxIXOIIO(name = "interceptors")
    public final List<Interceptor> interceptors() {
        return this.interceptors;
    }

    @xxIXOIIO(name = "minWebSocketMessageToCompress")
    public final long minWebSocketMessageToCompress() {
        return this.minWebSocketMessageToCompress;
    }

    @OOXIXo
    @xxIXOIIO(name = "networkInterceptors")
    public final List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    @OOXIXo
    public Builder newBuilder() {
        return new Builder(this);
    }

    @Override // okhttp3.Call.Factory
    @OOXIXo
    public Call newCall(@OOXIXo Request request) {
        IIX0o.x0xO0oo(request, "request");
        return new RealCall(this, request, false);
    }

    @Override // okhttp3.WebSocket.Factory
    @OOXIXo
    public WebSocket newWebSocket(@OOXIXo Request request, @OOXIXo WebSocketListener listener) {
        IIX0o.x0xO0oo(request, "request");
        IIX0o.x0xO0oo(listener, "listener");
        RealWebSocket realWebSocket = new RealWebSocket(TaskRunner.INSTANCE, request, listener, new Random(), this.pingIntervalMillis, null, this.minWebSocketMessageToCompress);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    @xxIXOIIO(name = "pingIntervalMillis")
    public final int pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @OOXIXo
    @xxIXOIIO(name = "protocols")
    public final List<Protocol> protocols() {
        return this.protocols;
    }

    @xxIXOIIO(name = "proxy")
    @oOoXoXO
    public final Proxy proxy() {
        return this.proxy;
    }

    @OOXIXo
    @xxIXOIIO(name = "proxyAuthenticator")
    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @OOXIXo
    @xxIXOIIO(name = "proxySelector")
    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    @xxIXOIIO(name = "readTimeoutMillis")
    public final int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @xxIXOIIO(name = "retryOnConnectionFailure")
    public final boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @OOXIXo
    @xxIXOIIO(name = "socketFactory")
    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    @OOXIXo
    @xxIXOIIO(name = "sslSocketFactory")
    public final SSLSocketFactory sslSocketFactory() {
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactoryOrNull;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    @xxIXOIIO(name = "writeTimeoutMillis")
    public final int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @xxIXOIIO(name = "x509TrustManager")
    @oOoXoXO
    public final X509TrustManager x509TrustManager() {
        return this.x509TrustManager;
    }

    public OkHttpClient() {
        this(new Builder());
    }
}
