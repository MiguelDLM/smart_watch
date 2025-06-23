package okhttp3.internal.tls;

import OXOo.OOXIXo;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import okhttp3.internal.platform.Platform;

/* loaded from: classes6.dex */
public abstract class CertificateChainCleaner {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final CertificateChainCleaner get(@OOXIXo X509TrustManager trustManager) {
            IIX0o.x0xO0oo(trustManager, "trustManager");
            return Platform.Companion.get().buildCertificateChainCleaner(trustManager);
        }

        private Companion() {
        }

        @OOXIXo
        public final CertificateChainCleaner get(@OOXIXo X509Certificate... caCerts) {
            IIX0o.x0xO0oo(caCerts, "caCerts");
            return new BasicCertificateChainCleaner(new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(caCerts, caCerts.length)));
        }
    }

    @OOXIXo
    public abstract List<Certificate> clean(@OOXIXo List<? extends Certificate> list, @OOXIXo String str) throws SSLPeerUnverifiedException;
}
