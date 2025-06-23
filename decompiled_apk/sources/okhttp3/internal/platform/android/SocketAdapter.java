package okhttp3.internal.platform.android;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.IIX0o;
import okhttp3.Protocol;

/* loaded from: classes6.dex */
public interface SocketAdapter {

    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static boolean matchesSocketFactory(@OOXIXo SocketAdapter socketAdapter, @OOXIXo SSLSocketFactory sslSocketFactory) {
            IIX0o.x0xO0oo(sslSocketFactory, "sslSocketFactory");
            return false;
        }

        @oOoXoXO
        public static X509TrustManager trustManager(@OOXIXo SocketAdapter socketAdapter, @OOXIXo SSLSocketFactory sslSocketFactory) {
            IIX0o.x0xO0oo(sslSocketFactory, "sslSocketFactory");
            return null;
        }
    }

    void configureTlsExtensions(@OOXIXo SSLSocket sSLSocket, @oOoXoXO String str, @OOXIXo List<? extends Protocol> list);

    @oOoXoXO
    String getSelectedProtocol(@OOXIXo SSLSocket sSLSocket);

    boolean isSupported();

    boolean matchesSocket(@OOXIXo SSLSocket sSLSocket);

    boolean matchesSocketFactory(@OOXIXo SSLSocketFactory sSLSocketFactory);

    @oOoXoXO
    X509TrustManager trustManager(@OOXIXo SSLSocketFactory sSLSocketFactory);
}
