package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import XO0OX.XO;
import XO0OX.x0XOIxOo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.XoX;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

@XX({"SMAP\nCertificatePinner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CertificatePinner.kt\nokhttp3/CertificatePinner\n+ 2 Util.kt\nokhttp3/internal/Util\n*L\n1#1,370:1\n625#2,8:371\n*S KotlinDebug\n*F\n+ 1 CertificatePinner.kt\nokhttp3/CertificatePinner\n*L\n216#1:371,8\n*E\n"})
/* loaded from: classes6.dex */
public final class CertificatePinner {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    @XO
    public static final CertificatePinner DEFAULT = new Builder().build();

    @oOoXoXO
    private final CertificateChainCleaner certificateChainCleaner;

    @OOXIXo
    private final Set<Pin> pins;

    /* loaded from: classes6.dex */
    public static final class Builder {

        @OOXIXo
        private final List<Pin> pins = new ArrayList();

        @OOXIXo
        public final Builder add(@OOXIXo String pattern, @OOXIXo String... pins) {
            IIX0o.x0xO0oo(pattern, "pattern");
            IIX0o.x0xO0oo(pins, "pins");
            for (String str : pins) {
                this.pins.add(new Pin(pattern, str));
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @OOXIXo
        public final CertificatePinner build() {
            return new CertificatePinner(CollectionsKt___CollectionsKt.XxI0(this.pins), null, 2, 0 == true ? 1 : 0);
        }

        @OOXIXo
        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    @XX({"SMAP\nCertificatePinner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CertificatePinner.kt\nokhttp3/CertificatePinner$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,370:1\n1#2:371\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OOXIXo
        public final String pin(@OOXIXo Certificate certificate) {
            IIX0o.x0xO0oo(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return "sha256/" + sha256Hash((X509Certificate) certificate).base64();
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }

        @x0XOIxOo
        @OOXIXo
        public final ByteString sha1Hash(@OOXIXo X509Certificate x509Certificate) {
            IIX0o.x0xO0oo(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.Companion;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            IIX0o.oO(encoded, "publicKey.encoded");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha1();
        }

        @x0XOIxOo
        @OOXIXo
        public final ByteString sha256Hash(@OOXIXo X509Certificate x509Certificate) {
            IIX0o.x0xO0oo(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.Companion;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            IIX0o.oO(encoded, "publicKey.encoded");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha256();
        }

        private Companion() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class Pin {

        @OOXIXo
        private final ByteString hash;

        @OOXIXo
        private final String hashAlgorithm;

        @OOXIXo
        private final String pattern;

        public Pin(@OOXIXo String pattern, @OOXIXo String pin) {
            IIX0o.x0xO0oo(pattern, "pattern");
            IIX0o.x0xO0oo(pin, "pin");
            if ((OxI.IOOoXo0Ix(pattern, "*.", false, 2, null) && StringsKt__StringsKt.O0O0Io00X(pattern, "*", 1, false, 4, null) == -1) || ((OxI.IOOoXo0Ix(pattern, "**.", false, 2, null) && StringsKt__StringsKt.O0O0Io00X(pattern, "*", 2, false, 4, null) == -1) || StringsKt__StringsKt.O0O0Io00X(pattern, "*", 0, false, 6, null) == -1)) {
                String canonicalHost = HostnamesKt.toCanonicalHost(pattern);
                if (canonicalHost != null) {
                    this.pattern = canonicalHost;
                    if (OxI.IOOoXo0Ix(pin, "sha1/", false, 2, null)) {
                        this.hashAlgorithm = "sha1";
                        ByteString.Companion companion = ByteString.Companion;
                        String substring = pin.substring(5);
                        IIX0o.oO(substring, "this as java.lang.String).substring(startIndex)");
                        ByteString decodeBase64 = companion.decodeBase64(substring);
                        if (decodeBase64 != null) {
                            this.hash = decodeBase64;
                            return;
                        }
                        throw new IllegalArgumentException("Invalid pin hash: " + pin);
                    }
                    if (OxI.IOOoXo0Ix(pin, "sha256/", false, 2, null)) {
                        this.hashAlgorithm = "sha256";
                        ByteString.Companion companion2 = ByteString.Companion;
                        String substring2 = pin.substring(7);
                        IIX0o.oO(substring2, "this as java.lang.String).substring(startIndex)");
                        ByteString decodeBase642 = companion2.decodeBase64(substring2);
                        if (decodeBase642 != null) {
                            this.hash = decodeBase642;
                            return;
                        }
                        throw new IllegalArgumentException("Invalid pin hash: " + pin);
                    }
                    throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + pin);
                }
                throw new IllegalArgumentException("Invalid pattern: " + pattern);
            }
            throw new IllegalArgumentException(("Unexpected pattern: " + pattern).toString());
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            if (IIX0o.Oxx0IOOO(this.pattern, pin.pattern) && IIX0o.Oxx0IOOO(this.hashAlgorithm, pin.hashAlgorithm) && IIX0o.Oxx0IOOO(this.hash, pin.hash)) {
                return true;
            }
            return false;
        }

        @OOXIXo
        public final ByteString getHash() {
            return this.hash;
        }

        @OOXIXo
        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        @OOXIXo
        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return (((this.pattern.hashCode() * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public final boolean matchesCertificate(@OOXIXo X509Certificate certificate) {
            IIX0o.x0xO0oo(certificate, "certificate");
            String str = this.hashAlgorithm;
            if (IIX0o.Oxx0IOOO(str, "sha256")) {
                return IIX0o.Oxx0IOOO(this.hash, CertificatePinner.Companion.sha256Hash(certificate));
            }
            if (IIX0o.Oxx0IOOO(str, "sha1")) {
                return IIX0o.Oxx0IOOO(this.hash, CertificatePinner.Companion.sha1Hash(certificate));
            }
            return false;
        }

        public final boolean matchesHostname(@OOXIXo String hostname) {
            IIX0o.x0xO0oo(hostname, "hostname");
            if (OxI.IOOoXo0Ix(this.pattern, "**.", false, 2, null)) {
                int length = this.pattern.length() - 3;
                int length2 = hostname.length() - length;
                if (!OxI.oXxx000(hostname, hostname.length() - length, this.pattern, 3, length, false, 16, null)) {
                    return false;
                }
                if (length2 != 0 && hostname.charAt(length2 - 1) != '.') {
                    return false;
                }
            } else if (OxI.IOOoXo0Ix(this.pattern, "*.", false, 2, null)) {
                int length3 = this.pattern.length() - 1;
                int length4 = hostname.length() - length3;
                if (!OxI.oXxx000(hostname, hostname.length() - length3, this.pattern, 1, length3, false, 16, null) || StringsKt__StringsKt.XIxO(hostname, '.', length4 - 1, false, 4, null) != -1) {
                    return false;
                }
            } else {
                return IIX0o.Oxx0IOOO(hostname, this.pattern);
            }
            return true;
        }

        @OOXIXo
        public String toString() {
            return this.hashAlgorithm + IOUtils.DIR_SEPARATOR_UNIX + this.hash.base64();
        }
    }

    public CertificatePinner(@OOXIXo Set<Pin> pins, @oOoXoXO CertificateChainCleaner certificateChainCleaner) {
        IIX0o.x0xO0oo(pins, "pins");
        this.pins = pins;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    @x0XOIxOo
    @OOXIXo
    public static final String pin(@OOXIXo Certificate certificate) {
        return Companion.pin(certificate);
    }

    @x0XOIxOo
    @OOXIXo
    public static final ByteString sha1Hash(@OOXIXo X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    @x0XOIxOo
    @OOXIXo
    public static final ByteString sha256Hash(@OOXIXo X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    public final void check(@OOXIXo final String hostname, @OOXIXo final List<? extends Certificate> peerCertificates) throws SSLPeerUnverifiedException {
        IIX0o.x0xO0oo(hostname, "hostname");
        IIX0o.x0xO0oo(peerCertificates, "peerCertificates");
        check$okhttp(hostname, new oIX0oI<List<? extends X509Certificate>>() { // from class: okhttp3.CertificatePinner$check$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OOXIXo
            public final List<? extends X509Certificate> invoke() {
                List<Certificate> list;
                CertificateChainCleaner certificateChainCleaner$okhttp = CertificatePinner.this.getCertificateChainCleaner$okhttp();
                if (certificateChainCleaner$okhttp == null || (list = certificateChainCleaner$okhttp.clean(peerCertificates, hostname)) == null) {
                    list = peerCertificates;
                }
                List<Certificate> list2 = list;
                ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list2, 10));
                for (Certificate certificate : list2) {
                    IIX0o.x0XOIxOo(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    arrayList.add((X509Certificate) certificate);
                }
                return arrayList;
            }
        });
    }

    public final void check$okhttp(@OOXIXo String hostname, @OOXIXo oIX0oI<? extends List<? extends X509Certificate>> cleanedPeerCertificatesFn) {
        IIX0o.x0xO0oo(hostname, "hostname");
        IIX0o.x0xO0oo(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        List<Pin> findMatchingPins = findMatchingPins(hostname);
        if (findMatchingPins.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> invoke = cleanedPeerCertificatesFn.invoke();
        for (X509Certificate x509Certificate : invoke) {
            ByteString byteString = null;
            ByteString byteString2 = null;
            for (Pin pin : findMatchingPins) {
                String hashAlgorithm = pin.getHashAlgorithm();
                if (IIX0o.Oxx0IOOO(hashAlgorithm, "sha256")) {
                    if (byteString == null) {
                        byteString = Companion.sha256Hash(x509Certificate);
                    }
                    if (IIX0o.Oxx0IOOO(pin.getHash(), byteString)) {
                        return;
                    }
                } else if (IIX0o.Oxx0IOOO(hashAlgorithm, "sha1")) {
                    if (byteString2 == null) {
                        byteString2 = Companion.sha1Hash(x509Certificate);
                    }
                    if (IIX0o.Oxx0IOOO(pin.getHash(), byteString2)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : invoke) {
            sb.append("\n    ");
            sb.append(Companion.pin(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(hostname);
        sb.append(":");
        for (Pin pin2 : findMatchingPins) {
            sb.append("\n    ");
            sb.append(pin2);
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(sb2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (IIX0o.Oxx0IOOO(certificatePinner.pins, this.pins) && IIX0o.Oxx0IOOO(certificatePinner.certificateChainCleaner, this.certificateChainCleaner)) {
                return true;
            }
        }
        return false;
    }

    @OOXIXo
    public final List<Pin> findMatchingPins(@OOXIXo String hostname) {
        IIX0o.x0xO0oo(hostname, "hostname");
        Set<Pin> set = this.pins;
        List<Pin> ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        for (Object obj : set) {
            if (((Pin) obj).matchesHostname(hostname)) {
                if (ooXIXxIX2.isEmpty()) {
                    ooXIXxIX2 = new ArrayList<>();
                }
                IIX0o.x0XOIxOo(ooXIXxIX2, "null cannot be cast to non-null type kotlin.collections.MutableList<T of okhttp3.internal.Util.filterList>");
                XoX.Oxx0IOOO(ooXIXxIX2).add(obj);
            }
        }
        return ooXIXxIX2;
    }

    @oOoXoXO
    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    @OOXIXo
    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int i;
        int hashCode = (1517 + this.pins.hashCode()) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        if (certificateChainCleaner != null) {
            i = certificateChainCleaner.hashCode();
        } else {
            i = 0;
        }
        return hashCode + i;
    }

    @OOXIXo
    public final CertificatePinner withCertificateChainCleaner$okhttp(@OOXIXo CertificateChainCleaner certificateChainCleaner) {
        IIX0o.x0xO0oo(certificateChainCleaner, "certificateChainCleaner");
        if (IIX0o.Oxx0IOOO(this.certificateChainCleaner, certificateChainCleaner)) {
            return this;
        }
        return new CertificatePinner(this.pins, certificateChainCleaner);
    }

    @kotlin.OOXIXo(message = "replaced with {@link #check(String, List)}.", replaceWith = @kotlin.XX(expression = "check(hostname, peerCertificates.toList())", imports = {}))
    public final void check(@OOXIXo String hostname, @OOXIXo Certificate... peerCertificates) throws SSLPeerUnverifiedException {
        IIX0o.x0xO0oo(hostname, "hostname");
        IIX0o.x0xO0oo(peerCertificates, "peerCertificates");
        check(hostname, ArraysKt___ArraysKt.IoXOX(peerCertificates));
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i, IIXOooo iIXOooo) {
        this(set, (i & 2) != 0 ? null : certificateChainCleaner);
    }
}
