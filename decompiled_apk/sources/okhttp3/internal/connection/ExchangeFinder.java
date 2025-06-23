package okhttp3.internal.connection;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.io.IOException;
import kotlin.jvm.internal.IIX0o;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

/* loaded from: classes6.dex */
public final class ExchangeFinder {

    @OOXIXo
    private final Address address;

    @OOXIXo
    private final RealCall call;

    @OOXIXo
    private final RealConnectionPool connectionPool;
    private int connectionShutdownCount;

    @OOXIXo
    private final EventListener eventListener;

    @oOoXoXO
    private Route nextRouteToTry;
    private int otherFailureCount;
    private int refusedStreamCount;

    @oOoXoXO
    private RouteSelector.Selection routeSelection;

    @oOoXoXO
    private RouteSelector routeSelector;

    public ExchangeFinder(@OOXIXo RealConnectionPool connectionPool, @OOXIXo Address address, @OOXIXo RealCall call, @OOXIXo EventListener eventListener) {
        IIX0o.x0xO0oo(connectionPool, "connectionPool");
        IIX0o.x0xO0oo(address, "address");
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(eventListener, "eventListener");
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final okhttp3.internal.connection.RealConnection findConnection(int r15, int r16, int r17, int r18, boolean r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ExchangeFinder.findConnection(int, int, int, int, boolean):okhttp3.internal.connection.RealConnection");
    }

    private final RealConnection findHealthyConnection(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        boolean z3;
        while (true) {
            RealConnection findConnection = findConnection(i, i2, i3, i4, z);
            if (findConnection.isHealthy(z2)) {
                return findConnection;
            }
            findConnection.noNewExchanges$okhttp();
            if (this.nextRouteToTry == null) {
                RouteSelector.Selection selection = this.routeSelection;
                boolean z4 = true;
                if (selection != null) {
                    z3 = selection.hasNext();
                } else {
                    z3 = true;
                }
                if (z3) {
                    continue;
                } else {
                    RouteSelector routeSelector = this.routeSelector;
                    if (routeSelector != null) {
                        z4 = routeSelector.hasNext();
                    }
                    if (!z4) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
    }

    private final Route retryRoute() {
        RealConnection connection;
        if (this.refusedStreamCount > 1 || this.connectionShutdownCount > 1 || this.otherFailureCount > 0 || (connection = this.call.getConnection()) == null) {
            return null;
        }
        synchronized (connection) {
            if (connection.getRouteFailureCount$okhttp() != 0) {
                return null;
            }
            if (!Util.canReuseConnectionFor(connection.route().address().url(), this.address.url())) {
                return null;
            }
            return connection.route();
        }
    }

    @OOXIXo
    public final ExchangeCodec find(@OOXIXo OkHttpClient client, @OOXIXo RealInterceptorChain chain) {
        IIX0o.x0xO0oo(client, "client");
        IIX0o.x0xO0oo(chain, "chain");
        try {
            return findHealthyConnection(chain.getConnectTimeoutMillis$okhttp(), chain.getReadTimeoutMillis$okhttp(), chain.getWriteTimeoutMillis$okhttp(), client.pingIntervalMillis(), client.retryOnConnectionFailure(), !IIX0o.Oxx0IOOO(chain.getRequest$okhttp().method(), "GET")).newCodec$okhttp(client, chain);
        } catch (IOException e) {
            trackFailure(e);
            throw new RouteException(e);
        } catch (RouteException e2) {
            trackFailure(e2.getLastConnectException());
            throw e2;
        }
    }

    @OOXIXo
    public final Address getAddress$okhttp() {
        return this.address;
    }

    public final boolean retryAfterFailure() {
        RouteSelector routeSelector;
        if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
            return false;
        }
        if (this.nextRouteToTry != null) {
            return true;
        }
        Route retryRoute = retryRoute();
        if (retryRoute != null) {
            this.nextRouteToTry = retryRoute;
            return true;
        }
        RouteSelector.Selection selection = this.routeSelection;
        if ((selection != null && selection.hasNext()) || (routeSelector = this.routeSelector) == null) {
            return true;
        }
        return routeSelector.hasNext();
    }

    public final boolean sameHostAndPort(@OOXIXo HttpUrl url) {
        IIX0o.x0xO0oo(url, "url");
        HttpUrl url2 = this.address.url();
        if (url.port() == url2.port() && IIX0o.Oxx0IOOO(url.host(), url2.host())) {
            return true;
        }
        return false;
    }

    public final void trackFailure(@OOXIXo IOException e) {
        IIX0o.x0xO0oo(e, "e");
        this.nextRouteToTry = null;
        if ((e instanceof StreamResetException) && ((StreamResetException) e).errorCode == ErrorCode.REFUSED_STREAM) {
            this.refusedStreamCount++;
        } else if (e instanceof ConnectionShutdownException) {
            this.connectionShutdownCount++;
        } else {
            this.otherFailureCount++;
        }
    }
}
