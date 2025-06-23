package okhttp3.internal.proxy;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nNullProxySelector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NullProxySelector.kt\nokhttp3/internal/proxy/NullProxySelector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,36:1\n1#2:37\n*E\n"})
/* loaded from: classes6.dex */
public final class NullProxySelector extends ProxySelector {

    @OOXIXo
    public static final NullProxySelector INSTANCE = new NullProxySelector();

    private NullProxySelector() {
    }

    @Override // java.net.ProxySelector
    public void connectFailed(@oOoXoXO URI uri, @oOoXoXO SocketAddress socketAddress, @oOoXoXO IOException iOException) {
    }

    @Override // java.net.ProxySelector
    @OOXIXo
    public List<Proxy> select(@oOoXoXO URI uri) {
        if (uri != null) {
            return oI0IIXIo.OOXIXo(Proxy.NO_PROXY);
        }
        throw new IllegalArgumentException("uri must not be null");
    }
}
