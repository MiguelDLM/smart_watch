package okhttp3;

import OXOo.OOXIXo;
import XO0OX.XO;
import XO0OX.x0XOIxOo;
import XO0OX.xxIXOIIO;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.OxI;

/* loaded from: classes6.dex */
public final class CipherSuite {

    @OOXIXo
    public static final Companion Companion;

    @OOXIXo
    private static final Map<String, CipherSuite> INSTANCES;

    @OOXIXo
    private static final Comparator<String> ORDER_BY_NAME;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_AES_128_CCM_8_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_AES_128_CCM_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_AES_128_GCM_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_AES_256_GCM_SHA384;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_CHACHA20_POLY1305_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_GCM_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_GCM_SHA384;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_DSS_WITH_DES_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_GCM_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_GCM_SHA384;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DHE_RSA_WITH_DES_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_RC4_40_MD5;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DH_anon_WITH_3DES_EDE_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_GCM_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_GCM_SHA384;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DH_anon_WITH_DES_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_DH_anon_WITH_RC4_128_MD5;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_NULL_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_RC4_128_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_RSA_WITH_NULL_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDHE_RSA_WITH_RC4_128_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_NULL_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_RC4_128_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_RSA_WITH_NULL_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_RSA_WITH_RC4_128_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_128_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_256_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_anon_WITH_NULL_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_ECDH_anon_WITH_RC4_128_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_EMPTY_RENEGOTIATION_INFO_SCSV;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_FALLBACK_SCSV;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_MD5;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_MD5;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_MD5;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_MD5;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_PSK_WITH_3DES_EDE_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_PSK_WITH_AES_128_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_PSK_WITH_AES_256_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_PSK_WITH_RC4_128_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_RSA_EXPORT_WITH_DES40_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_RSA_EXPORT_WITH_RC4_40_MD5;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_RSA_WITH_3DES_EDE_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_RSA_WITH_AES_128_GCM_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_RSA_WITH_AES_256_GCM_SHA384;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_128_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_256_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_RSA_WITH_DES_CBC_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_RSA_WITH_NULL_MD5;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA256;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_RSA_WITH_RC4_128_MD5;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_RSA_WITH_RC4_128_SHA;

    @OOXIXo
    @XO
    public static final CipherSuite TLS_RSA_WITH_SEED_CBC_SHA;

    @OOXIXo
    private final String javaName;

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final CipherSuite init(String str, int i) {
            CipherSuite cipherSuite = new CipherSuite(str, null);
            CipherSuite.INSTANCES.put(str, cipherSuite);
            return cipherSuite;
        }

        private final String secondaryName(String str) {
            if (OxI.IOOoXo0Ix(str, "TLS_", false, 2, null)) {
                StringBuilder sb = new StringBuilder();
                sb.append("SSL_");
                String substring = str.substring(4);
                IIX0o.oO(substring, "this as java.lang.String).substring(startIndex)");
                sb.append(substring);
                return sb.toString();
            }
            if (OxI.IOOoXo0Ix(str, "SSL_", false, 2, null)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("TLS_");
                String substring2 = str.substring(4);
                IIX0o.oO(substring2, "this as java.lang.String).substring(startIndex)");
                sb2.append(substring2);
                return sb2.toString();
            }
            return str;
        }

        @x0XOIxOo
        @OOXIXo
        public final synchronized CipherSuite forJavaName(@OOXIXo String javaName) {
            CipherSuite cipherSuite;
            try {
                IIX0o.x0xO0oo(javaName, "javaName");
                cipherSuite = (CipherSuite) CipherSuite.INSTANCES.get(javaName);
                if (cipherSuite == null) {
                    cipherSuite = (CipherSuite) CipherSuite.INSTANCES.get(secondaryName(javaName));
                    if (cipherSuite == null) {
                        cipherSuite = new CipherSuite(javaName, null);
                    }
                    CipherSuite.INSTANCES.put(javaName, cipherSuite);
                }
            } catch (Throwable th) {
                throw th;
            }
            return cipherSuite;
        }

        @OOXIXo
        public final Comparator<String> getORDER_BY_NAME$okhttp() {
            return CipherSuite.ORDER_BY_NAME;
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        ORDER_BY_NAME = new Comparator<String>() { // from class: okhttp3.CipherSuite$Companion$ORDER_BY_NAME$1
            @Override // java.util.Comparator
            public int compare(@OOXIXo String a2, @OOXIXo String b) {
                IIX0o.x0xO0oo(a2, "a");
                IIX0o.x0xO0oo(b, "b");
                int min = Math.min(a2.length(), b.length());
                for (int i = 4; i < min; i++) {
                    char charAt = a2.charAt(i);
                    char charAt2 = b.charAt(i);
                    if (charAt != charAt2) {
                        return IIX0o.oI0IIXIo(charAt, charAt2) < 0 ? -1 : 1;
                    }
                }
                int length = a2.length();
                int length2 = b.length();
                if (length != length2) {
                    return length < length2 ? -1 : 1;
                }
                return 0;
            }
        };
        INSTANCES = new LinkedHashMap();
        TLS_RSA_WITH_NULL_MD5 = companion.init("SSL_RSA_WITH_NULL_MD5", 1);
        TLS_RSA_WITH_NULL_SHA = companion.init("SSL_RSA_WITH_NULL_SHA", 2);
        TLS_RSA_EXPORT_WITH_RC4_40_MD5 = companion.init("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        TLS_RSA_WITH_RC4_128_MD5 = companion.init("SSL_RSA_WITH_RC4_128_MD5", 4);
        TLS_RSA_WITH_RC4_128_SHA = companion.init("SSL_RSA_WITH_RC4_128_SHA", 5);
        TLS_RSA_EXPORT_WITH_DES40_CBC_SHA = companion.init("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        TLS_RSA_WITH_DES_CBC_SHA = companion.init("SSL_RSA_WITH_DES_CBC_SHA", 9);
        TLS_RSA_WITH_3DES_EDE_CBC_SHA = companion.init("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = companion.init("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        TLS_DHE_DSS_WITH_DES_CBC_SHA = companion.init("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA = companion.init("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = companion.init("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        TLS_DHE_RSA_WITH_DES_CBC_SHA = companion.init("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA = companion.init("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        TLS_DH_anon_EXPORT_WITH_RC4_40_MD5 = companion.init("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        TLS_DH_anon_WITH_RC4_128_MD5 = companion.init("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA = companion.init("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        TLS_DH_anon_WITH_DES_CBC_SHA = companion.init("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        TLS_DH_anon_WITH_3DES_EDE_CBC_SHA = companion.init("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        TLS_KRB5_WITH_DES_CBC_SHA = companion.init("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        TLS_KRB5_WITH_3DES_EDE_CBC_SHA = companion.init("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        TLS_KRB5_WITH_RC4_128_SHA = companion.init("TLS_KRB5_WITH_RC4_128_SHA", 32);
        TLS_KRB5_WITH_DES_CBC_MD5 = companion.init("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        TLS_KRB5_WITH_3DES_EDE_CBC_MD5 = companion.init("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        TLS_KRB5_WITH_RC4_128_MD5 = companion.init("TLS_KRB5_WITH_RC4_128_MD5", 36);
        TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA = companion.init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        TLS_KRB5_EXPORT_WITH_RC4_40_SHA = companion.init("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5 = companion.init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        TLS_KRB5_EXPORT_WITH_RC4_40_MD5 = companion.init("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        TLS_RSA_WITH_AES_128_CBC_SHA = companion.init("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        TLS_DHE_DSS_WITH_AES_128_CBC_SHA = companion.init("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        TLS_DHE_RSA_WITH_AES_128_CBC_SHA = companion.init("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        TLS_DH_anon_WITH_AES_128_CBC_SHA = companion.init("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        TLS_RSA_WITH_AES_256_CBC_SHA = companion.init("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        TLS_DHE_DSS_WITH_AES_256_CBC_SHA = companion.init("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        TLS_DHE_RSA_WITH_AES_256_CBC_SHA = companion.init("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        TLS_DH_anon_WITH_AES_256_CBC_SHA = companion.init("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        TLS_RSA_WITH_NULL_SHA256 = companion.init("TLS_RSA_WITH_NULL_SHA256", 59);
        TLS_RSA_WITH_AES_128_CBC_SHA256 = companion.init("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        TLS_RSA_WITH_AES_256_CBC_SHA256 = companion.init("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        TLS_DHE_DSS_WITH_AES_128_CBC_SHA256 = companion.init("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        TLS_RSA_WITH_CAMELLIA_128_CBC_SHA = companion.init("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA = companion.init("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA = companion.init("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        TLS_DHE_RSA_WITH_AES_128_CBC_SHA256 = companion.init("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        TLS_DHE_DSS_WITH_AES_256_CBC_SHA256 = companion.init("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        TLS_DHE_RSA_WITH_AES_256_CBC_SHA256 = companion.init("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        TLS_DH_anon_WITH_AES_128_CBC_SHA256 = companion.init("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        TLS_DH_anon_WITH_AES_256_CBC_SHA256 = companion.init("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        TLS_RSA_WITH_CAMELLIA_256_CBC_SHA = companion.init("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA = companion.init("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA = companion.init("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        TLS_PSK_WITH_RC4_128_SHA = companion.init("TLS_PSK_WITH_RC4_128_SHA", 138);
        TLS_PSK_WITH_3DES_EDE_CBC_SHA = companion.init("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        TLS_PSK_WITH_AES_128_CBC_SHA = companion.init("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        TLS_PSK_WITH_AES_256_CBC_SHA = companion.init("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        TLS_RSA_WITH_SEED_CBC_SHA = companion.init("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        TLS_RSA_WITH_AES_128_GCM_SHA256 = companion.init("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        TLS_RSA_WITH_AES_256_GCM_SHA384 = companion.init("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 = companion.init("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 = companion.init("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        TLS_DHE_DSS_WITH_AES_128_GCM_SHA256 = companion.init("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 = companion.init("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        TLS_DH_anon_WITH_AES_128_GCM_SHA256 = companion.init("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        TLS_DH_anon_WITH_AES_256_GCM_SHA384 = companion.init("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        TLS_EMPTY_RENEGOTIATION_INFO_SCSV = companion.init("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        TLS_FALLBACK_SCSV = companion.init("TLS_FALLBACK_SCSV", 22016);
        TLS_ECDH_ECDSA_WITH_NULL_SHA = companion.init("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        TLS_ECDH_ECDSA_WITH_RC4_128_SHA = companion.init("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA = companion.init("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA = companion.init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA = companion.init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        TLS_ECDHE_ECDSA_WITH_NULL_SHA = companion.init("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        TLS_ECDHE_ECDSA_WITH_RC4_128_SHA = companion.init("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA = companion.init("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA = companion.init("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = companion.init("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        TLS_ECDH_RSA_WITH_NULL_SHA = companion.init("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        TLS_ECDH_RSA_WITH_RC4_128_SHA = companion.init("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA = companion.init("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        TLS_ECDH_RSA_WITH_AES_128_CBC_SHA = companion.init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        TLS_ECDH_RSA_WITH_AES_256_CBC_SHA = companion.init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        TLS_ECDHE_RSA_WITH_NULL_SHA = companion.init("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        TLS_ECDHE_RSA_WITH_RC4_128_SHA = companion.init("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA = companion.init("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = companion.init("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = companion.init("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        TLS_ECDH_anon_WITH_NULL_SHA = companion.init("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        TLS_ECDH_anon_WITH_RC4_128_SHA = companion.init("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA = companion.init("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        TLS_ECDH_anon_WITH_AES_128_CBC_SHA = companion.init("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        TLS_ECDH_anon_WITH_AES_256_CBC_SHA = companion.init("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 = companion.init("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 = companion.init("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256 = companion.init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384 = companion.init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 = companion.init("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 = companion.init("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256 = companion.init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384 = companion.init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = companion.init("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = companion.init("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256 = companion.init("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384 = companion.init("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = companion.init("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = companion.init("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256 = companion.init("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384 = companion.init("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA = companion.init("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA = companion.init("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = companion.init("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = companion.init("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = companion.init("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256 = companion.init("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        TLS_AES_128_GCM_SHA256 = companion.init("TLS_AES_128_GCM_SHA256", 4865);
        TLS_AES_256_GCM_SHA384 = companion.init("TLS_AES_256_GCM_SHA384", 4866);
        TLS_CHACHA20_POLY1305_SHA256 = companion.init("TLS_CHACHA20_POLY1305_SHA256", 4867);
        TLS_AES_128_CCM_SHA256 = companion.init("TLS_AES_128_CCM_SHA256", 4868);
        TLS_AES_128_CCM_8_SHA256 = companion.init("TLS_AES_128_CCM_8_SHA256", 4869);
    }

    public /* synthetic */ CipherSuite(String str, IIXOooo iIXOooo) {
        this(str);
    }

    @x0XOIxOo
    @OOXIXo
    public static final synchronized CipherSuite forJavaName(@OOXIXo String str) {
        CipherSuite forJavaName;
        synchronized (CipherSuite.class) {
            forJavaName = Companion.forJavaName(str);
        }
        return forJavaName;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "javaName", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_javaName")
    /* renamed from: -deprecated_javaName, reason: not valid java name */
    public final String m327deprecated_javaName() {
        return this.javaName;
    }

    @OOXIXo
    @xxIXOIIO(name = "javaName")
    public final String javaName() {
        return this.javaName;
    }

    @OOXIXo
    public String toString() {
        return this.javaName;
    }

    private CipherSuite(String str) {
        this.javaName = str;
    }
}
