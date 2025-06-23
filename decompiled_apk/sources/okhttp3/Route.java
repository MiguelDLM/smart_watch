package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class Route {

    @OOXIXo
    private final Address address;

    @OOXIXo
    private final Proxy proxy;

    @OOXIXo
    private final InetSocketAddress socketAddress;

    public Route(@OOXIXo Address address, @OOXIXo Proxy proxy, @OOXIXo InetSocketAddress socketAddress) {
        IIX0o.x0xO0oo(address, "address");
        IIX0o.x0xO0oo(proxy, "proxy");
        IIX0o.x0xO0oo(socketAddress, "socketAddress");
        this.address = address;
        this.proxy = proxy;
        this.socketAddress = socketAddress;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "address", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_address")
    /* renamed from: -deprecated_address, reason: not valid java name */
    public final Address m431deprecated_address() {
        return this.address;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "proxy", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_proxy")
    /* renamed from: -deprecated_proxy, reason: not valid java name */
    public final Proxy m432deprecated_proxy() {
        return this.proxy;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "socketAddress", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_socketAddress")
    /* renamed from: -deprecated_socketAddress, reason: not valid java name */
    public final InetSocketAddress m433deprecated_socketAddress() {
        return this.socketAddress;
    }

    @OOXIXo
    @xxIXOIIO(name = "address")
    public final Address address() {
        return this.address;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (IIX0o.Oxx0IOOO(route.address, this.address) && IIX0o.Oxx0IOOO(route.proxy, this.proxy) && IIX0o.Oxx0IOOO(route.socketAddress, this.socketAddress)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.address.hashCode()) * 31) + this.proxy.hashCode()) * 31) + this.socketAddress.hashCode();
    }

    @OOXIXo
    @xxIXOIIO(name = "proxy")
    public final Proxy proxy() {
        return this.proxy;
    }

    public final boolean requiresTunnel() {
        if (this.address.sslSocketFactory() != null && this.proxy.type() == Proxy.Type.HTTP) {
            return true;
        }
        return false;
    }

    @OOXIXo
    @xxIXOIIO(name = "socketAddress")
    public final InetSocketAddress socketAddress() {
        return this.socketAddress;
    }

    @OOXIXo
    public String toString() {
        return "Route{" + this.socketAddress + '}';
    }
}
