package okhttp3.internal.platform.android;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

/* loaded from: classes6.dex */
public final class StandardAndroidSocketAdapter extends AndroidSocketAdapter {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private final Class<?> paramClass;

    @OOXIXo
    private final Class<? super SSLSocketFactory> sslSocketFactoryClass;

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ SocketAdapter buildIfSupported$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return companion.buildIfSupported(str);
        }

        @oOoXoXO
        public final SocketAdapter buildIfSupported(@OOXIXo String packageName) {
            IIX0o.x0xO0oo(packageName, "packageName");
            try {
                Class<?> cls = Class.forName(packageName + ".OpenSSLSocketImpl");
                IIX0o.x0XOIxOo(cls, "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocket>");
                Class<?> cls2 = Class.forName(packageName + ".OpenSSLSocketFactoryImpl");
                IIX0o.x0XOIxOo(cls2, "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocketFactory>");
                Class<?> paramsClass = Class.forName(packageName + ".SSLParametersImpl");
                IIX0o.oO(paramsClass, "paramsClass");
                return new StandardAndroidSocketAdapter(cls, cls2, paramsClass);
            } catch (Exception e) {
                Platform.Companion.get().log("unable to load android socket classes", 5, e);
                return null;
            }
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StandardAndroidSocketAdapter(@OOXIXo Class<? super SSLSocket> sslSocketClass, @OOXIXo Class<? super SSLSocketFactory> sslSocketFactoryClass, @OOXIXo Class<?> paramClass) {
        super(sslSocketClass);
        IIX0o.x0xO0oo(sslSocketClass, "sslSocketClass");
        IIX0o.x0xO0oo(sslSocketFactoryClass, "sslSocketFactoryClass");
        IIX0o.x0xO0oo(paramClass, "paramClass");
        this.sslSocketFactoryClass = sslSocketFactoryClass;
        this.paramClass = paramClass;
    }

    @Override // okhttp3.internal.platform.android.AndroidSocketAdapter, okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocketFactory(@OOXIXo SSLSocketFactory sslSocketFactory) {
        IIX0o.x0xO0oo(sslSocketFactory, "sslSocketFactory");
        return this.sslSocketFactoryClass.isInstance(sslSocketFactory);
    }

    @Override // okhttp3.internal.platform.android.AndroidSocketAdapter, okhttp3.internal.platform.android.SocketAdapter
    @oOoXoXO
    public X509TrustManager trustManager(@OOXIXo SSLSocketFactory sslSocketFactory) {
        IIX0o.x0xO0oo(sslSocketFactory, "sslSocketFactory");
        Object readFieldOrNull = Util.readFieldOrNull(sslSocketFactory, this.paramClass, "sslParameters");
        IIX0o.ooOOo0oXI(readFieldOrNull);
        X509TrustManager x509TrustManager = (X509TrustManager) Util.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "x509TrustManager");
        if (x509TrustManager == null) {
            return (X509TrustManager) Util.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "trustManager");
        }
        return x509TrustManager;
    }
}
