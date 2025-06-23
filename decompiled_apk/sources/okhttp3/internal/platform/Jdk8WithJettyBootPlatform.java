package okhttp3.internal.platform;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import okhttp3.Protocol;

/* loaded from: classes6.dex */
public final class Jdk8WithJettyBootPlatform extends Platform {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private final Class<?> clientProviderClass;

    @OOXIXo
    private final Method getMethod;

    @OOXIXo
    private final Method putMethod;

    @OOXIXo
    private final Method removeMethod;

    @OOXIXo
    private final Class<?> serverProviderClass;

    /* loaded from: classes6.dex */
    public static final class AlpnProvider implements InvocationHandler {

        @OOXIXo
        private final List<String> protocols;

        @oOoXoXO
        private String selected;
        private boolean unsupported;

        public AlpnProvider(@OOXIXo List<String> protocols) {
            IIX0o.x0xO0oo(protocols, "protocols");
            this.protocols = protocols;
        }

        @oOoXoXO
        public final String getSelected() {
            return this.selected;
        }

        public final boolean getUnsupported() {
            return this.unsupported;
        }

        @Override // java.lang.reflect.InvocationHandler
        @oOoXoXO
        public Object invoke(@OOXIXo Object proxy, @OOXIXo Method method, @oOoXoXO Object[] objArr) throws Throwable {
            IIX0o.x0xO0oo(proxy, "proxy");
            IIX0o.x0xO0oo(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (IIX0o.Oxx0IOOO(name, "supports") && IIX0o.Oxx0IOOO(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (IIX0o.Oxx0IOOO(name, "unsupported") && IIX0o.Oxx0IOOO(Void.TYPE, returnType)) {
                this.unsupported = true;
                return null;
            }
            if (IIX0o.Oxx0IOOO(name, "protocols") && objArr.length == 0) {
                return this.protocols;
            }
            if ((IIX0o.Oxx0IOOO(name, "selectProtocol") || IIX0o.Oxx0IOOO(name, "select")) && IIX0o.Oxx0IOOO(String.class, returnType) && objArr.length == 1) {
                Object obj = objArr[0];
                if (obj instanceof List) {
                    IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
                    List list = (List) obj;
                    int size = list.size();
                    if (size >= 0) {
                        int i = 0;
                        while (true) {
                            Object obj2 = list.get(i);
                            IIX0o.x0XOIxOo(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            if (this.protocols.contains(str)) {
                                this.selected = str;
                                return str;
                            }
                            if (i == size) {
                                break;
                            }
                            i++;
                        }
                    }
                    String str2 = this.protocols.get(0);
                    this.selected = str2;
                    return str2;
                }
            }
            if ((IIX0o.Oxx0IOOO(name, "protocolSelected") || IIX0o.Oxx0IOOO(name, XXooOOI.oIX0oI.f4118XO)) && objArr.length == 1) {
                Object obj3 = objArr[0];
                IIX0o.x0XOIxOo(obj3, "null cannot be cast to non-null type kotlin.String");
                this.selected = (String) obj3;
                return null;
            }
            return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
        }

        public final void setSelected(@oOoXoXO String str) {
            this.selected = str;
        }

        public final void setUnsupported(boolean z) {
            this.unsupported = z;
        }
    }

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @oOoXoXO
        public final Platform buildIfSupported() {
            String jvmVersion = System.getProperty("java.specification.version", "unknown");
            try {
                IIX0o.oO(jvmVersion, "jvmVersion");
                if (Integer.parseInt(jvmVersion) >= 9) {
                    return null;
                }
            } catch (NumberFormatException unused) {
            }
            try {
                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                Class<?> clientProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                Class<?> serverProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                Method putMethod = cls.getMethod("put", SSLSocket.class, cls2);
                Method getMethod = cls.getMethod("get", SSLSocket.class);
                Method removeMethod = cls.getMethod("remove", SSLSocket.class);
                IIX0o.oO(putMethod, "putMethod");
                IIX0o.oO(getMethod, "getMethod");
                IIX0o.oO(removeMethod, "removeMethod");
                IIX0o.oO(clientProviderClass, "clientProviderClass");
                IIX0o.oO(serverProviderClass, "serverProviderClass");
                return new Jdk8WithJettyBootPlatform(putMethod, getMethod, removeMethod, clientProviderClass, serverProviderClass);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return null;
            }
        }

        private Companion() {
        }
    }

    public Jdk8WithJettyBootPlatform(@OOXIXo Method putMethod, @OOXIXo Method getMethod, @OOXIXo Method removeMethod, @OOXIXo Class<?> clientProviderClass, @OOXIXo Class<?> serverProviderClass) {
        IIX0o.x0xO0oo(putMethod, "putMethod");
        IIX0o.x0xO0oo(getMethod, "getMethod");
        IIX0o.x0xO0oo(removeMethod, "removeMethod");
        IIX0o.x0xO0oo(clientProviderClass, "clientProviderClass");
        IIX0o.x0xO0oo(serverProviderClass, "serverProviderClass");
        this.putMethod = putMethod;
        this.getMethod = getMethod;
        this.removeMethod = removeMethod;
        this.clientProviderClass = clientProviderClass;
        this.serverProviderClass = serverProviderClass;
    }

    @Override // okhttp3.internal.platform.Platform
    public void afterHandshake(@OOXIXo SSLSocket sslSocket) {
        IIX0o.x0xO0oo(sslSocket, "sslSocket");
        try {
            this.removeMethod.invoke(null, sslSocket);
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to remove ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(@OOXIXo SSLSocket sslSocket, @oOoXoXO String str, @OOXIXo List<? extends Protocol> protocols) {
        IIX0o.x0xO0oo(sslSocket, "sslSocket");
        IIX0o.x0xO0oo(protocols, "protocols");
        try {
            this.putMethod.invoke(null, sslSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new AlpnProvider(Platform.Companion.alpnProtocolNames(protocols))));
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to set ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    @oOoXoXO
    public String getSelectedProtocol(@OOXIXo SSLSocket sslSocket) {
        IIX0o.x0xO0oo(sslSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.getMethod.invoke(null, sslSocket));
            IIX0o.x0XOIxOo(invocationHandler, "null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            AlpnProvider alpnProvider = (AlpnProvider) invocationHandler;
            if (!alpnProvider.getUnsupported() && alpnProvider.getSelected() == null) {
                Platform.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            if (alpnProvider.getUnsupported()) {
                return null;
            }
            return alpnProvider.getSelected();
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to get ALPN selected protocol", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        }
    }
}
