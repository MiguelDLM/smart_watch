package okhttp3.internal.platform;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.CloseGuard;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

@XX({"SMAP\nAndroidPlatform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidPlatform.kt\nokhttp3/internal/platform/AndroidPlatform\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,163:1\n766#2:164\n857#2,2:165\n1#3:167\n*S KotlinDebug\n*F\n+ 1 AndroidPlatform.kt\nokhttp3/internal/platform/AndroidPlatform\n*L\n52#1:164\n52#1:165,2\n*E\n"})
@SuppressSignatureCheck
/* loaded from: classes6.dex */
public final class AndroidPlatform extends Platform {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final boolean isSupported;

    @OOXIXo
    private final CloseGuard closeGuard;

    @OOXIXo
    private final List<SocketAdapter> socketAdapters;

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @oOoXoXO
        public final Platform buildIfSupported() {
            if (isSupported()) {
                return new AndroidPlatform();
            }
            return null;
        }

        public final boolean isSupported() {
            return AndroidPlatform.isSupported;
        }

        private Companion() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class CustomTrustRootIndex implements TrustRootIndex {

        @OOXIXo
        private final Method findByIssuerAndSignatureMethod;

        @OOXIXo
        private final X509TrustManager trustManager;

        public CustomTrustRootIndex(@OOXIXo X509TrustManager trustManager, @OOXIXo Method findByIssuerAndSignatureMethod) {
            IIX0o.x0xO0oo(trustManager, "trustManager");
            IIX0o.x0xO0oo(findByIssuerAndSignatureMethod, "findByIssuerAndSignatureMethod");
            this.trustManager = trustManager;
            this.findByIssuerAndSignatureMethod = findByIssuerAndSignatureMethod;
        }

        private final X509TrustManager component1() {
            return this.trustManager;
        }

        private final Method component2() {
            return this.findByIssuerAndSignatureMethod;
        }

        public static /* synthetic */ CustomTrustRootIndex copy$default(CustomTrustRootIndex customTrustRootIndex, X509TrustManager x509TrustManager, Method method, int i, Object obj) {
            if ((i & 1) != 0) {
                x509TrustManager = customTrustRootIndex.trustManager;
            }
            if ((i & 2) != 0) {
                method = customTrustRootIndex.findByIssuerAndSignatureMethod;
            }
            return customTrustRootIndex.copy(x509TrustManager, method);
        }

        @OOXIXo
        public final CustomTrustRootIndex copy(@OOXIXo X509TrustManager trustManager, @OOXIXo Method findByIssuerAndSignatureMethod) {
            IIX0o.x0xO0oo(trustManager, "trustManager");
            IIX0o.x0xO0oo(findByIssuerAndSignatureMethod, "findByIssuerAndSignatureMethod");
            return new CustomTrustRootIndex(trustManager, findByIssuerAndSignatureMethod);
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomTrustRootIndex)) {
                return false;
            }
            CustomTrustRootIndex customTrustRootIndex = (CustomTrustRootIndex) obj;
            return IIX0o.Oxx0IOOO(this.trustManager, customTrustRootIndex.trustManager) && IIX0o.Oxx0IOOO(this.findByIssuerAndSignatureMethod, customTrustRootIndex.findByIssuerAndSignatureMethod);
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        @oOoXoXO
        public X509Certificate findByIssuerAndSignature(@OOXIXo X509Certificate cert) {
            IIX0o.x0xO0oo(cert, "cert");
            try {
                Object invoke = this.findByIssuerAndSignatureMethod.invoke(this.trustManager, cert);
                IIX0o.x0XOIxOo(invoke, "null cannot be cast to non-null type java.security.cert.TrustAnchor");
                return ((TrustAnchor) invoke).getTrustedCert();
            } catch (IllegalAccessException e) {
                throw new AssertionError("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public int hashCode() {
            return (this.trustManager.hashCode() * 31) + this.findByIssuerAndSignatureMethod.hashCode();
        }

        @OOXIXo
        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.trustManager + ", findByIssuerAndSignatureMethod=" + this.findByIssuerAndSignatureMethod + HexStringBuilder.COMMENT_END_CHAR;
        }
    }

    static {
        boolean z = false;
        if (Platform.Companion.isAndroid() && Build.VERSION.SDK_INT < 30) {
            z = true;
        }
        isSupported = z;
    }

    public AndroidPlatform() {
        List xII2 = CollectionsKt__CollectionsKt.xII(StandardAndroidSocketAdapter.Companion.buildIfSupported$default(StandardAndroidSocketAdapter.Companion, null, 1, null), new DeferredSocketAdapter(AndroidSocketAdapter.Companion.getPlayProviderFactory()), new DeferredSocketAdapter(ConscryptSocketAdapter.Companion.getFactory()), new DeferredSocketAdapter(BouncyCastleSocketAdapter.Companion.getFactory()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : xII2) {
            if (((SocketAdapter) obj).isSupported()) {
                arrayList.add(obj);
            }
        }
        this.socketAdapters = arrayList;
        this.closeGuard = CloseGuard.Companion.get();
    }

    @Override // okhttp3.internal.platform.Platform
    @OOXIXo
    public CertificateChainCleaner buildCertificateChainCleaner(@OOXIXo X509TrustManager trustManager) {
        IIX0o.x0xO0oo(trustManager, "trustManager");
        AndroidCertificateChainCleaner buildIfSupported = AndroidCertificateChainCleaner.Companion.buildIfSupported(trustManager);
        if (buildIfSupported == null) {
            return super.buildCertificateChainCleaner(trustManager);
        }
        return buildIfSupported;
    }

    @Override // okhttp3.internal.platform.Platform
    @OOXIXo
    public TrustRootIndex buildTrustRootIndex(@OOXIXo X509TrustManager trustManager) {
        IIX0o.x0xO0oo(trustManager, "trustManager");
        try {
            Method method = trustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            method.setAccessible(true);
            IIX0o.oO(method, "method");
            return new CustomTrustRootIndex(trustManager, method);
        } catch (NoSuchMethodException unused) {
            return super.buildTrustRootIndex(trustManager);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(@OOXIXo SSLSocket sslSocket, @oOoXoXO String str, @OOXIXo List<Protocol> protocols) {
        Object obj;
        IIX0o.x0xO0oo(sslSocket, "sslSocket");
        IIX0o.x0xO0oo(protocols, "protocols");
        Iterator<T> it = this.socketAdapters.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((SocketAdapter) obj).matchesSocket(sslSocket)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) obj;
        if (socketAdapter != null) {
            socketAdapter.configureTlsExtensions(sslSocket, str, protocols);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void connectSocket(@OOXIXo Socket socket, @OOXIXo InetSocketAddress address, int i) throws IOException {
        IIX0o.x0xO0oo(socket, "socket");
        IIX0o.x0xO0oo(address, "address");
        try {
            socket.connect(address, i);
        } catch (ClassCastException e) {
            if (Build.VERSION.SDK_INT == 26) {
                throw new IOException("Exception in connect", e);
            }
            throw e;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    @oOoXoXO
    public String getSelectedProtocol(@OOXIXo SSLSocket sslSocket) {
        Object obj;
        IIX0o.x0xO0oo(sslSocket, "sslSocket");
        Iterator<T> it = this.socketAdapters.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((SocketAdapter) obj).matchesSocket(sslSocket)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) obj;
        if (socketAdapter == null) {
            return null;
        }
        return socketAdapter.getSelectedProtocol(sslSocket);
    }

    @Override // okhttp3.internal.platform.Platform
    @oOoXoXO
    public Object getStackTraceForCloseable(@OOXIXo String closer) {
        IIX0o.x0xO0oo(closer, "closer");
        return this.closeGuard.createAndOpen(closer);
    }

    @Override // okhttp3.internal.platform.Platform
    public boolean isCleartextTrafficPermitted(@OOXIXo String hostname) {
        NetworkSecurityPolicy networkSecurityPolicy;
        boolean isCleartextTrafficPermitted;
        NetworkSecurityPolicy networkSecurityPolicy2;
        boolean isCleartextTrafficPermitted2;
        IIX0o.x0xO0oo(hostname, "hostname");
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            networkSecurityPolicy2 = NetworkSecurityPolicy.getInstance();
            isCleartextTrafficPermitted2 = networkSecurityPolicy2.isCleartextTrafficPermitted(hostname);
            return isCleartextTrafficPermitted2;
        }
        if (i >= 23) {
            networkSecurityPolicy = NetworkSecurityPolicy.getInstance();
            isCleartextTrafficPermitted = networkSecurityPolicy.isCleartextTrafficPermitted();
            return isCleartextTrafficPermitted;
        }
        return true;
    }

    @Override // okhttp3.internal.platform.Platform
    public void logCloseableLeak(@OOXIXo String message, @oOoXoXO Object obj) {
        IIX0o.x0xO0oo(message, "message");
        if (!this.closeGuard.warnIfOpen(obj)) {
            Platform.log$default(this, message, 5, null, 4, null);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    @oOoXoXO
    public X509TrustManager trustManager(@OOXIXo SSLSocketFactory sslSocketFactory) {
        Object obj;
        IIX0o.x0xO0oo(sslSocketFactory, "sslSocketFactory");
        Iterator<T> it = this.socketAdapters.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((SocketAdapter) obj).matchesSocketFactory(sslSocketFactory)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) obj;
        if (socketAdapter == null) {
            return null;
        }
        return socketAdapter.trustManager(sslSocketFactory);
    }
}
