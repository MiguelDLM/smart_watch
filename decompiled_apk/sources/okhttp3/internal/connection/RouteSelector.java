package okhttp3.internal.connection;

import OXOo.OOXIXo;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxI;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;

/* loaded from: classes6.dex */
public final class RouteSelector {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private final Address address;

    @OOXIXo
    private final Call call;

    @OOXIXo
    private final EventListener eventListener;

    @OOXIXo
    private List<? extends InetSocketAddress> inetSocketAddresses;
    private int nextProxyIndex;

    @OOXIXo
    private final List<Route> postponedRoutes;

    @OOXIXo
    private List<? extends Proxy> proxies;

    @OOXIXo
    private final RouteDatabase routeDatabase;

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final String getSocketHost(@OOXIXo InetSocketAddress inetSocketAddress) {
            IIX0o.x0xO0oo(inetSocketAddress, "<this>");
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                String hostName = inetSocketAddress.getHostName();
                IIX0o.oO(hostName, "hostName");
                return hostName;
            }
            String hostAddress = address.getHostAddress();
            IIX0o.oO(hostAddress, "address.hostAddress");
            return hostAddress;
        }

        private Companion() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class Selection {
        private int nextRouteIndex;

        @OOXIXo
        private final List<Route> routes;

        public Selection(@OOXIXo List<Route> routes) {
            IIX0o.x0xO0oo(routes, "routes");
            this.routes = routes;
        }

        @OOXIXo
        public final List<Route> getRoutes() {
            return this.routes;
        }

        public final boolean hasNext() {
            if (this.nextRouteIndex < this.routes.size()) {
                return true;
            }
            return false;
        }

        @OOXIXo
        public final Route next() {
            if (hasNext()) {
                List<Route> list = this.routes;
                int i = this.nextRouteIndex;
                this.nextRouteIndex = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    public RouteSelector(@OOXIXo Address address, @OOXIXo RouteDatabase routeDatabase, @OOXIXo Call call, @OOXIXo EventListener eventListener) {
        IIX0o.x0xO0oo(address, "address");
        IIX0o.x0xO0oo(routeDatabase, "routeDatabase");
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(eventListener, "eventListener");
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        this.eventListener = eventListener;
        this.proxies = CollectionsKt__CollectionsKt.ooXIXxIX();
        this.inetSocketAddresses = CollectionsKt__CollectionsKt.ooXIXxIX();
        this.postponedRoutes = new ArrayList();
        resetNextProxy(address.url(), address.proxy());
    }

    private final boolean hasNextProxy() {
        if (this.nextProxyIndex < this.proxies.size()) {
            return true;
        }
        return false;
    }

    private final Proxy nextProxy() throws IOException {
        if (hasNextProxy()) {
            List<? extends Proxy> list = this.proxies;
            int i = this.nextProxyIndex;
            this.nextProxyIndex = i + 1;
            Proxy proxy = list.get(i);
            resetNextInetSocketAddress(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies);
    }

    private final void resetNextInetSocketAddress(Proxy proxy) throws IOException {
        String host;
        int port;
        List<InetAddress> lookup;
        ArrayList arrayList = new ArrayList();
        this.inetSocketAddresses = arrayList;
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress proxyAddress = proxy.address();
            if (proxyAddress instanceof InetSocketAddress) {
                Companion companion = Companion;
                IIX0o.oO(proxyAddress, "proxyAddress");
                InetSocketAddress inetSocketAddress = (InetSocketAddress) proxyAddress;
                host = companion.getSocketHost(inetSocketAddress);
                port = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + proxyAddress.getClass()).toString());
            }
        } else {
            host = this.address.url().host();
            port = this.address.url().port();
        }
        if (1 <= port && port < 65536) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                arrayList.add(InetSocketAddress.createUnresolved(host, port));
                return;
            }
            if (Util.canParseAsIpAddress(host)) {
                lookup = oI0IIXIo.OOXIXo(InetAddress.getByName(host));
            } else {
                this.eventListener.dnsStart(this.call, host);
                lookup = this.address.dns().lookup(host);
                if (!lookup.isEmpty()) {
                    this.eventListener.dnsEnd(this.call, host, lookup);
                } else {
                    throw new UnknownHostException(this.address.dns() + " returned no addresses for " + host);
                }
            }
            Iterator<InetAddress> it = lookup.iterator();
            while (it.hasNext()) {
                arrayList.add(new InetSocketAddress(it.next(), port));
            }
            return;
        }
        throw new SocketException("No route to " + host + ':' + port + "; port is out of range");
    }

    private final void resetNextProxy(HttpUrl httpUrl, Proxy proxy) {
        this.eventListener.proxySelectStart(this.call, httpUrl);
        List<Proxy> resetNextProxy$selectProxies = resetNextProxy$selectProxies(proxy, httpUrl, this);
        this.proxies = resetNextProxy$selectProxies;
        this.nextProxyIndex = 0;
        this.eventListener.proxySelectEnd(this.call, httpUrl, resetNextProxy$selectProxies);
    }

    private static final List<Proxy> resetNextProxy$selectProxies(Proxy proxy, HttpUrl httpUrl, RouteSelector routeSelector) {
        if (proxy != null) {
            return oI0IIXIo.OOXIXo(proxy);
        }
        URI uri = httpUrl.uri();
        if (uri.getHost() == null) {
            return Util.immutableListOf(Proxy.NO_PROXY);
        }
        List<Proxy> proxiesOrNull = routeSelector.address.proxySelector().select(uri);
        List<Proxy> list = proxiesOrNull;
        if (list != null && !list.isEmpty()) {
            IIX0o.oO(proxiesOrNull, "proxiesOrNull");
            return Util.toImmutableList(proxiesOrNull);
        }
        return Util.immutableListOf(Proxy.NO_PROXY);
    }

    public final boolean hasNext() {
        if (!hasNextProxy() && this.postponedRoutes.isEmpty()) {
            return false;
        }
        return true;
    }

    @OOXIXo
    public final Selection next() throws IOException {
        if (hasNext()) {
            ArrayList arrayList = new ArrayList();
            while (hasNextProxy()) {
                Proxy nextProxy = nextProxy();
                Iterator<? extends InetSocketAddress> it = this.inetSocketAddresses.iterator();
                while (it.hasNext()) {
                    Route route = new Route(this.address, nextProxy, it.next());
                    if (this.routeDatabase.shouldPostpone(route)) {
                        this.postponedRoutes.add(route);
                    } else {
                        arrayList.add(route);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                OxI.XIo0oOXIx(arrayList, this.postponedRoutes);
                this.postponedRoutes.clear();
            }
            return new Selection(arrayList);
        }
        throw new NoSuchElementException();
    }
}
