package okhttp3.internal.tls;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes6.dex */
public final class BasicCertificateChainCleaner extends CertificateChainCleaner {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final int MAX_SIGNERS = 9;

    @OOXIXo
    private final TrustRootIndex trustRootIndex;

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BasicCertificateChainCleaner(@OOXIXo TrustRootIndex trustRootIndex) {
        IIX0o.x0xO0oo(trustRootIndex, "trustRootIndex");
        this.trustRootIndex = trustRootIndex;
    }

    private final boolean verifySignature(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!IIX0o.Oxx0IOOO(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    @OOXIXo
    public List<Certificate> clean(@OOXIXo List<? extends Certificate> chain, @OOXIXo String hostname) throws SSLPeerUnverifiedException {
        IIX0o.x0xO0oo(chain, "chain");
        IIX0o.x0xO0oo(hostname, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(chain);
        ArrayList arrayList = new ArrayList();
        Object removeFirst = arrayDeque.removeFirst();
        IIX0o.oO(removeFirst, "queue.removeFirst()");
        arrayList.add(removeFirst);
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            Object obj = arrayList.get(arrayList.size() - 1);
            IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            X509Certificate x509Certificate = (X509Certificate) obj;
            X509Certificate findByIssuerAndSignature = this.trustRootIndex.findByIssuerAndSignature(x509Certificate);
            if (findByIssuerAndSignature != null) {
                if (arrayList.size() > 1 || !IIX0o.Oxx0IOOO(x509Certificate, findByIssuerAndSignature)) {
                    arrayList.add(findByIssuerAndSignature);
                }
                if (verifySignature(findByIssuerAndSignature, findByIssuerAndSignature)) {
                    return arrayList;
                }
                z = true;
            } else {
                Iterator it = arrayDeque.iterator();
                IIX0o.oO(it, "queue.iterator()");
                while (it.hasNext()) {
                    Object next = it.next();
                    IIX0o.x0XOIxOo(next, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    X509Certificate x509Certificate2 = (X509Certificate) next;
                    if (verifySignature(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof BasicCertificateChainCleaner) && IIX0o.Oxx0IOOO(((BasicCertificateChainCleaner) obj).trustRootIndex, this.trustRootIndex)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.trustRootIndex.hashCode();
    }
}
