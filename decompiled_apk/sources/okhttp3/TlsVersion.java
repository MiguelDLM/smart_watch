package okhttp3;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import XO0OX.xxIXOIIO;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes6.dex */
public enum TlsVersion {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");


    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private final String javaName;

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OOXIXo
        public final TlsVersion forJavaName(@OOXIXo String javaName) {
            IIX0o.x0xO0oo(javaName, "javaName");
            int hashCode = javaName.hashCode();
            if (hashCode != 79201641) {
                if (hashCode != 79923350) {
                    switch (hashCode) {
                        case -503070503:
                            if (javaName.equals("TLSv1.1")) {
                                return TlsVersion.TLS_1_1;
                            }
                            break;
                        case -503070502:
                            if (javaName.equals("TLSv1.2")) {
                                return TlsVersion.TLS_1_2;
                            }
                            break;
                        case -503070501:
                            if (javaName.equals("TLSv1.3")) {
                                return TlsVersion.TLS_1_3;
                            }
                            break;
                    }
                } else if (javaName.equals("TLSv1")) {
                    return TlsVersion.TLS_1_0;
                }
            } else if (javaName.equals("SSLv3")) {
                return TlsVersion.SSL_3_0;
            }
            throw new IllegalArgumentException("Unexpected TLS version: " + javaName);
        }

        private Companion() {
        }
    }

    TlsVersion(String str) {
        this.javaName = str;
    }

    @x0XOIxOo
    @OOXIXo
    public static final TlsVersion forJavaName(@OOXIXo String str) {
        return Companion.forJavaName(str);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "javaName", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_javaName")
    /* renamed from: -deprecated_javaName, reason: not valid java name */
    public final String m434deprecated_javaName() {
        return this.javaName;
    }

    @OOXIXo
    @xxIXOIIO(name = "javaName")
    public final String javaName() {
        return this.javaName;
    }
}
