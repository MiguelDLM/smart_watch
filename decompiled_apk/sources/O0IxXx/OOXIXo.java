package O0IxXx;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes11.dex */
public class OOXIXo extends ProxySelector {

    /* renamed from: oxoX, reason: collision with root package name */
    public static final List<Proxy> f1224oxoX = Arrays.asList(Proxy.NO_PROXY);

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f1225I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String f1226II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final ProxySelector f1227oIX0oI;

    public OOXIXo(ProxySelector proxySelector, String str, int i) {
        this.f1227oIX0oI = (ProxySelector) ooOOo0oXI.oIX0oI(proxySelector);
        this.f1226II0xO0 = (String) ooOOo0oXI.oIX0oI(str);
        this.f1225I0Io = i;
    }

    public static void oIX0oI(String str, int i) {
        ProxySelector.setDefault(new OOXIXo(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f1227oIX0oI.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (this.f1226II0xO0.equals(uri.getHost()) && this.f1225I0Io == uri.getPort()) {
            return f1224oxoX;
        }
        return this.f1227oIX0oI.select(uri);
    }
}
