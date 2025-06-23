package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import XO0OX.x0XOIxOo;
import XO0OX.xxIXOIIO;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.DeprecationLevel;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import okhttp3.internal.Util;

@XX({"SMAP\nHandshake.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handshake.kt\nokhttp3/Handshake\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,200:1\n1549#2:201\n1620#2,3:202\n1549#2:205\n1620#2,3:206\n*S KotlinDebug\n*F\n+ 1 Handshake.kt\nokhttp3/Handshake\n*L\n129#1:201\n129#1:202,3\n134#1:205\n134#1:206,3\n*E\n"})
/* loaded from: classes6.dex */
public final class Handshake {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private final CipherSuite cipherSuite;

    @OOXIXo
    private final List<Certificate> localCertificates;

    @OOXIXo
    private final X0IIOO peerCertificates$delegate;

    @OOXIXo
    private final TlsVersion tlsVersion;

    @XX({"SMAP\nHandshake.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handshake.kt\nokhttp3/Handshake$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,200:1\n1#2:201\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private final List<Certificate> toImmutableList(Certificate[] certificateArr) {
            if (certificateArr != null) {
                return Util.immutableListOf(Arrays.copyOf(certificateArr, certificateArr.length));
            }
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.XX(expression = "sslSession.handshake()", imports = {}))
        @OOXIXo
        @xxIXOIIO(name = "-deprecated_get")
        /* renamed from: -deprecated_get, reason: not valid java name */
        public final Handshake m348deprecated_get(@OOXIXo SSLSession sslSession) throws IOException {
            IIX0o.x0xO0oo(sslSession, "sslSession");
            return get(sslSession);
        }

        @x0XOIxOo
        @OOXIXo
        @xxIXOIIO(name = "get")
        public final Handshake get(@OOXIXo SSLSession sSLSession) throws IOException {
            final List<Certificate> ooXIXxIX2;
            IIX0o.x0xO0oo(sSLSession, "<this>");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite != null) {
                if (!(IIX0o.Oxx0IOOO(cipherSuite, "TLS_NULL_WITH_NULL_NULL") ? true : IIX0o.Oxx0IOOO(cipherSuite, "SSL_NULL_WITH_NULL_NULL"))) {
                    CipherSuite forJavaName = CipherSuite.Companion.forJavaName(cipherSuite);
                    String protocol = sSLSession.getProtocol();
                    if (protocol != null) {
                        if (!IIX0o.Oxx0IOOO("NONE", protocol)) {
                            TlsVersion forJavaName2 = TlsVersion.Companion.forJavaName(protocol);
                            try {
                                ooXIXxIX2 = toImmutableList(sSLSession.getPeerCertificates());
                            } catch (SSLPeerUnverifiedException unused) {
                                ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
                            }
                            return new Handshake(forJavaName2, forJavaName, toImmutableList(sSLSession.getLocalCertificates()), new oIX0oI<List<? extends Certificate>>() { // from class: okhttp3.Handshake$Companion$handshake$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // Oox.oIX0oI
                                @OOXIXo
                                public final List<? extends Certificate> invoke() {
                                    return ooXIXxIX2;
                                }
                            });
                        }
                        throw new IOException("tlsVersion == NONE");
                    }
                    throw new IllegalStateException("tlsVersion == null");
                }
                throw new IOException("cipherSuite == " + cipherSuite);
            }
            throw new IllegalStateException("cipherSuite == null");
        }

        private Companion() {
        }

        @x0XOIxOo
        @OOXIXo
        public final Handshake get(@OOXIXo TlsVersion tlsVersion, @OOXIXo CipherSuite cipherSuite, @OOXIXo List<? extends Certificate> peerCertificates, @OOXIXo List<? extends Certificate> localCertificates) {
            IIX0o.x0xO0oo(tlsVersion, "tlsVersion");
            IIX0o.x0xO0oo(cipherSuite, "cipherSuite");
            IIX0o.x0xO0oo(peerCertificates, "peerCertificates");
            IIX0o.x0xO0oo(localCertificates, "localCertificates");
            final List immutableList = Util.toImmutableList(peerCertificates);
            return new Handshake(tlsVersion, cipherSuite, Util.toImmutableList(localCertificates), new oIX0oI<List<? extends Certificate>>() { // from class: okhttp3.Handshake$Companion$get$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                @OOXIXo
                public final List<? extends Certificate> invoke() {
                    return immutableList;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Handshake(@OOXIXo TlsVersion tlsVersion, @OOXIXo CipherSuite cipherSuite, @OOXIXo List<? extends Certificate> localCertificates, @OOXIXo final oIX0oI<? extends List<? extends Certificate>> peerCertificatesFn) {
        IIX0o.x0xO0oo(tlsVersion, "tlsVersion");
        IIX0o.x0xO0oo(cipherSuite, "cipherSuite");
        IIX0o.x0xO0oo(localCertificates, "localCertificates");
        IIX0o.x0xO0oo(peerCertificatesFn, "peerCertificatesFn");
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = localCertificates;
        this.peerCertificates$delegate = XIxXXX0x0.oIX0oI(new oIX0oI<List<? extends Certificate>>() { // from class: okhttp3.Handshake$peerCertificates$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OOXIXo
            public final List<? extends Certificate> invoke() {
                try {
                    return peerCertificatesFn.invoke();
                } catch (SSLPeerUnverifiedException unused) {
                    return CollectionsKt__CollectionsKt.ooXIXxIX();
                }
            }
        });
    }

    @x0XOIxOo
    @OOXIXo
    @xxIXOIIO(name = "get")
    public static final Handshake get(@OOXIXo SSLSession sSLSession) throws IOException {
        return Companion.get(sSLSession);
    }

    private final String getName(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        IIX0o.oO(type, "type");
        return type;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "cipherSuite", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_cipherSuite")
    /* renamed from: -deprecated_cipherSuite, reason: not valid java name */
    public final CipherSuite m342deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "localCertificates", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_localCertificates")
    /* renamed from: -deprecated_localCertificates, reason: not valid java name */
    public final List<Certificate> m343deprecated_localCertificates() {
        return this.localCertificates;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "localPrincipal", imports = {}))
    @xxIXOIIO(name = "-deprecated_localPrincipal")
    @oOoXoXO
    /* renamed from: -deprecated_localPrincipal, reason: not valid java name */
    public final Principal m344deprecated_localPrincipal() {
        return localPrincipal();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "peerCertificates", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_peerCertificates")
    /* renamed from: -deprecated_peerCertificates, reason: not valid java name */
    public final List<Certificate> m345deprecated_peerCertificates() {
        return peerCertificates();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "peerPrincipal", imports = {}))
    @xxIXOIIO(name = "-deprecated_peerPrincipal")
    @oOoXoXO
    /* renamed from: -deprecated_peerPrincipal, reason: not valid java name */
    public final Principal m346deprecated_peerPrincipal() {
        return peerPrincipal();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "tlsVersion", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_tlsVersion")
    /* renamed from: -deprecated_tlsVersion, reason: not valid java name */
    public final TlsVersion m347deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    @OOXIXo
    @xxIXOIIO(name = "cipherSuite")
    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            if (handshake.tlsVersion == this.tlsVersion && IIX0o.Oxx0IOOO(handshake.cipherSuite, this.cipherSuite) && IIX0o.Oxx0IOOO(handshake.peerCertificates(), peerCertificates()) && IIX0o.Oxx0IOOO(handshake.localCertificates, this.localCertificates)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.tlsVersion.hashCode()) * 31) + this.cipherSuite.hashCode()) * 31) + peerCertificates().hashCode()) * 31) + this.localCertificates.hashCode();
    }

    @OOXIXo
    @xxIXOIIO(name = "localCertificates")
    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    @xxIXOIIO(name = "localPrincipal")
    @oOoXoXO
    public final Principal localPrincipal() {
        X509Certificate x509Certificate;
        Object XxXX2 = CollectionsKt___CollectionsKt.XxXX(this.localCertificates);
        if (XxXX2 instanceof X509Certificate) {
            x509Certificate = (X509Certificate) XxXX2;
        } else {
            x509Certificate = null;
        }
        if (x509Certificate == null) {
            return null;
        }
        return x509Certificate.getSubjectX500Principal();
    }

    @OOXIXo
    @xxIXOIIO(name = "peerCertificates")
    public final List<Certificate> peerCertificates() {
        return (List) this.peerCertificates$delegate.getValue();
    }

    @xxIXOIIO(name = "peerPrincipal")
    @oOoXoXO
    public final Principal peerPrincipal() {
        X509Certificate x509Certificate;
        Object XxXX2 = CollectionsKt___CollectionsKt.XxXX(peerCertificates());
        if (XxXX2 instanceof X509Certificate) {
            x509Certificate = (X509Certificate) XxXX2;
        } else {
            x509Certificate = null;
        }
        if (x509Certificate == null) {
            return null;
        }
        return x509Certificate.getSubjectX500Principal();
    }

    @OOXIXo
    @xxIXOIIO(name = "tlsVersion")
    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    @OOXIXo
    public String toString() {
        List<Certificate> peerCertificates = peerCertificates();
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(peerCertificates, 10));
        Iterator<T> it = peerCertificates.iterator();
        while (it.hasNext()) {
            arrayList.add(getName((Certificate) it.next()));
        }
        String obj = arrayList.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Handshake{tlsVersion=");
        sb.append(this.tlsVersion);
        sb.append(" cipherSuite=");
        sb.append(this.cipherSuite);
        sb.append(" peerCertificates=");
        sb.append(obj);
        sb.append(" localCertificates=");
        List<Certificate> list = this.localCertificates;
        ArrayList arrayList2 = new ArrayList(OxxIIOOXO.xo0x(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(getName((Certificate) it2.next()));
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }

    @x0XOIxOo
    @OOXIXo
    public static final Handshake get(@OOXIXo TlsVersion tlsVersion, @OOXIXo CipherSuite cipherSuite, @OOXIXo List<? extends Certificate> list, @OOXIXo List<? extends Certificate> list2) {
        return Companion.get(tlsVersion, cipherSuite, list, list2);
    }
}
