package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.aq;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes11.dex */
final class i extends ProxySelector {
    private static final List<Proxy> aDx = Arrays.asList(Proxy.NO_PROXY);
    private final int aDA;
    private final ProxySelector aDy;
    private final String aDz;

    private i(ProxySelector proxySelector, String str, int i) {
        this.aDy = (ProxySelector) aq.checkNotNull(proxySelector);
        this.aDz = aq.gR(str);
        this.aDA = i;
    }

    public static void install(String str, int i) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.aDy.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public final List<Proxy> select(URI uri) {
        if (this.aDz.equals(uri.getHost()) && this.aDA == uri.getPort()) {
            return aDx;
        }
        return this.aDy.select(uri);
    }
}
