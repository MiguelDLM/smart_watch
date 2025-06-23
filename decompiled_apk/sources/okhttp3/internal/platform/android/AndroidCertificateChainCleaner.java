package okhttp3.internal.platform.android;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.tls.CertificateChainCleaner;

@XX({"SMAP\nAndroidCertificateChainCleaner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidCertificateChainCleaner.kt\nokhttp3/internal/platform/android/AndroidCertificateChainCleaner\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n37#2,2:75\n1#3:77\n*S KotlinDebug\n*F\n+ 1 AndroidCertificateChainCleaner.kt\nokhttp3/internal/platform/android/AndroidCertificateChainCleaner\n*L\n43#1:75,2\n*E\n"})
@SuppressSignatureCheck
/* loaded from: classes6.dex */
public final class AndroidCertificateChainCleaner extends CertificateChainCleaner {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private final X509TrustManager trustManager;

    @OOXIXo
    private final X509TrustManagerExtensions x509TrustManagerExtensions;

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @SuppressSignatureCheck
        @oOoXoXO
        public final AndroidCertificateChainCleaner buildIfSupported(@OOXIXo X509TrustManager trustManager) {
            X509TrustManagerExtensions x509TrustManagerExtensions;
            IIX0o.x0xO0oo(trustManager, "trustManager");
            try {
                x509TrustManagerExtensions = new X509TrustManagerExtensions(trustManager);
            } catch (IllegalArgumentException unused) {
                x509TrustManagerExtensions = null;
            }
            if (x509TrustManagerExtensions == null) {
                return null;
            }
            return new AndroidCertificateChainCleaner(trustManager, x509TrustManagerExtensions);
        }

        private Companion() {
        }
    }

    public AndroidCertificateChainCleaner(@OOXIXo X509TrustManager trustManager, @OOXIXo X509TrustManagerExtensions x509TrustManagerExtensions) {
        IIX0o.x0xO0oo(trustManager, "trustManager");
        IIX0o.x0xO0oo(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.trustManager = trustManager;
        this.x509TrustManagerExtensions = x509TrustManagerExtensions;
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    @OOXIXo
    @SuppressSignatureCheck
    public List<Certificate> clean(@OOXIXo List<? extends Certificate> chain, @OOXIXo String hostname) throws SSLPeerUnverifiedException {
        IIX0o.x0xO0oo(chain, "chain");
        IIX0o.x0xO0oo(hostname, "hostname");
        try {
            List<X509Certificate> checkServerTrusted = this.x509TrustManagerExtensions.checkServerTrusted((X509Certificate[]) chain.toArray(new X509Certificate[0]), "RSA", hostname);
            IIX0o.oO(checkServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return checkServerTrusted;
        } catch (CertificateException e) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
            sSLPeerUnverifiedException.initCause(e);
            throw sSLPeerUnverifiedException;
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if ((obj instanceof AndroidCertificateChainCleaner) && ((AndroidCertificateChainCleaner) obj).trustManager == this.trustManager) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(this.trustManager);
    }
}
