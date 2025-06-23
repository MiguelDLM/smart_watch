package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;
import o0oIxXOx.XIxXXX0x0;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

/* loaded from: classes6.dex */
public final class Address {

    @oOoXoXO
    private final CertificatePinner certificatePinner;

    @OOXIXo
    private final List<ConnectionSpec> connectionSpecs;

    @OOXIXo
    private final Dns dns;

    @oOoXoXO
    private final HostnameVerifier hostnameVerifier;

    @OOXIXo
    private final List<Protocol> protocols;

    @oOoXoXO
    private final Proxy proxy;

    @OOXIXo
    private final Authenticator proxyAuthenticator;

    @OOXIXo
    private final ProxySelector proxySelector;

    @OOXIXo
    private final SocketFactory socketFactory;

    @oOoXoXO
    private final SSLSocketFactory sslSocketFactory;

    @OOXIXo
    private final HttpUrl url;

    public Address(@OOXIXo String uriHost, int i, @OOXIXo Dns dns, @OOXIXo SocketFactory socketFactory, @oOoXoXO SSLSocketFactory sSLSocketFactory, @oOoXoXO HostnameVerifier hostnameVerifier, @oOoXoXO CertificatePinner certificatePinner, @OOXIXo Authenticator proxyAuthenticator, @oOoXoXO Proxy proxy, @OOXIXo List<? extends Protocol> protocols, @OOXIXo List<ConnectionSpec> connectionSpecs, @OOXIXo ProxySelector proxySelector) {
        IIX0o.x0xO0oo(uriHost, "uriHost");
        IIX0o.x0xO0oo(dns, "dns");
        IIX0o.x0xO0oo(socketFactory, "socketFactory");
        IIX0o.x0xO0oo(proxyAuthenticator, "proxyAuthenticator");
        IIX0o.x0xO0oo(protocols, "protocols");
        IIX0o.x0xO0oo(connectionSpecs, "connectionSpecs");
        IIX0o.x0xO0oo(proxySelector, "proxySelector");
        this.dns = dns;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
        this.proxyAuthenticator = proxyAuthenticator;
        this.proxy = proxy;
        this.proxySelector = proxySelector;
        this.url = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(uriHost).port(i).build();
        this.protocols = Util.toImmutableList(protocols);
        this.connectionSpecs = Util.toImmutableList(connectionSpecs);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "certificatePinner", imports = {}))
    @xxIXOIIO(name = "-deprecated_certificatePinner")
    @oOoXoXO
    /* renamed from: -deprecated_certificatePinner, reason: not valid java name */
    public final CertificatePinner m301deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "connectionSpecs", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_connectionSpecs")
    /* renamed from: -deprecated_connectionSpecs, reason: not valid java name */
    public final List<ConnectionSpec> m302deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = XIxXXX0x0.f31163OOXIXo, imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_dns")
    /* renamed from: -deprecated_dns, reason: not valid java name */
    public final Dns m303deprecated_dns() {
        return this.dns;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "hostnameVerifier", imports = {}))
    @xxIXOIIO(name = "-deprecated_hostnameVerifier")
    @oOoXoXO
    /* renamed from: -deprecated_hostnameVerifier, reason: not valid java name */
    public final HostnameVerifier m304deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "protocols", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_protocols")
    /* renamed from: -deprecated_protocols, reason: not valid java name */
    public final List<Protocol> m305deprecated_protocols() {
        return this.protocols;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "proxy", imports = {}))
    @xxIXOIIO(name = "-deprecated_proxy")
    @oOoXoXO
    /* renamed from: -deprecated_proxy, reason: not valid java name */
    public final Proxy m306deprecated_proxy() {
        return this.proxy;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "proxyAuthenticator", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_proxyAuthenticator")
    /* renamed from: -deprecated_proxyAuthenticator, reason: not valid java name */
    public final Authenticator m307deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "proxySelector", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_proxySelector")
    /* renamed from: -deprecated_proxySelector, reason: not valid java name */
    public final ProxySelector m308deprecated_proxySelector() {
        return this.proxySelector;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "socketFactory", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_socketFactory")
    /* renamed from: -deprecated_socketFactory, reason: not valid java name */
    public final SocketFactory m309deprecated_socketFactory() {
        return this.socketFactory;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "sslSocketFactory", imports = {}))
    @xxIXOIIO(name = "-deprecated_sslSocketFactory")
    @oOoXoXO
    /* renamed from: -deprecated_sslSocketFactory, reason: not valid java name */
    public final SSLSocketFactory m310deprecated_sslSocketFactory() {
        return this.sslSocketFactory;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "url", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_url")
    /* renamed from: -deprecated_url, reason: not valid java name */
    public final HttpUrl m311deprecated_url() {
        return this.url;
    }

    @xxIXOIIO(name = "certificatePinner")
    @oOoXoXO
    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    @OOXIXo
    @xxIXOIIO(name = "connectionSpecs")
    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    @OOXIXo
    @xxIXOIIO(name = XIxXXX0x0.f31163OOXIXo)
    public final Dns dns() {
        return this.dns;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (IIX0o.Oxx0IOOO(this.url, address.url) && equalsNonHost$okhttp(address)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equalsNonHost$okhttp(@OOXIXo Address that) {
        IIX0o.x0xO0oo(that, "that");
        if (IIX0o.Oxx0IOOO(this.dns, that.dns) && IIX0o.Oxx0IOOO(this.proxyAuthenticator, that.proxyAuthenticator) && IIX0o.Oxx0IOOO(this.protocols, that.protocols) && IIX0o.Oxx0IOOO(this.connectionSpecs, that.connectionSpecs) && IIX0o.Oxx0IOOO(this.proxySelector, that.proxySelector) && IIX0o.Oxx0IOOO(this.proxy, that.proxy) && IIX0o.Oxx0IOOO(this.sslSocketFactory, that.sslSocketFactory) && IIX0o.Oxx0IOOO(this.hostnameVerifier, that.hostnameVerifier) && IIX0o.Oxx0IOOO(this.certificatePinner, that.certificatePinner) && this.url.port() == that.url.port()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.url.hashCode()) * 31) + this.dns.hashCode()) * 31) + this.proxyAuthenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode()) * 31) + Objects.hashCode(this.proxy)) * 31) + Objects.hashCode(this.sslSocketFactory)) * 31) + Objects.hashCode(this.hostnameVerifier)) * 31) + Objects.hashCode(this.certificatePinner);
    }

    @xxIXOIIO(name = "hostnameVerifier")
    @oOoXoXO
    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
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

    @OOXIXo
    @xxIXOIIO(name = "socketFactory")
    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    @xxIXOIIO(name = "sslSocketFactory")
    @oOoXoXO
    public final SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb;
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.url.host());
        sb2.append(':');
        sb2.append(this.url.port());
        sb2.append(", ");
        if (this.proxy != null) {
            sb = new StringBuilder();
            sb.append("proxy=");
            obj = this.proxy;
        } else {
            sb = new StringBuilder();
            sb.append("proxySelector=");
            obj = this.proxySelector;
        }
        sb.append(obj);
        sb2.append(sb.toString());
        sb2.append('}');
        return sb2.toString();
    }

    @OOXIXo
    @xxIXOIIO(name = "url")
    public final HttpUrl url() {
        return this.url;
    }
}
