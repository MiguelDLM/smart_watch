package OoOoXO0;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import javax.net.SocketFactory;

/* loaded from: classes6.dex */
public class x0xO0oo {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f2639IIXOooo = 1;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f2640IXxxXO = 0;

    /* renamed from: Oo, reason: collision with root package name */
    public static final boolean f2641Oo = true;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f2642OxI = 4;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f2643Oxx0xo = 3;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f2644OxxIIOOXO = 0;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f2645o00 = 3;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f2646oI0IIXIo = 4;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f2647oO = 30;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f2648x0XOIxOo = 60;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f2649x0xO0oo = 10;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f2650xoXoI = 2;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public SocketFactory f2655Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f2656X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public char[] f2657XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f2658oIX0oI = 60;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f2653II0xO0 = 10;

    /* renamed from: I0Io, reason: collision with root package name */
    public String f2651I0Io = null;

    /* renamed from: oxoX, reason: collision with root package name */
    public Oxx0xo f2661oxoX = null;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public Properties f2652II0XooXoX = null;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f2663xxIXOIIO = true;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f2662xoIox = 30;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public String[] f2654OOXIXo = null;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f2659oOoXoXO = 0;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f2660ooOOo0oXI = false;

    public static int XIxXXX0x0(String str) {
        try {
            URI uri = new URI(str);
            if (uri.getScheme().equals("ws")) {
                return 3;
            }
            if (uri.getScheme().equals("wss")) {
                return 4;
            }
            if (uri.getPath().equals("")) {
                if (uri.getScheme().equals("tcp")) {
                    return 0;
                }
                if (uri.getScheme().equals("ssl")) {
                    return 1;
                }
                if (uri.getScheme().equals("local")) {
                    return 2;
                }
                throw new IllegalArgumentException(str);
            }
            throw new IllegalArgumentException(str);
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException(str);
        }
    }

    public int I0Io() {
        return this.f2658oIX0oI;
    }

    public String[] II0XooXoX() {
        return this.f2654OOXIXo;
    }

    public Properties II0xO0() {
        String xoIox2;
        String OOXIXo2;
        Properties properties = new Properties();
        properties.put("MqttVersion", new Integer(X0o0xo()));
        properties.put("CleanSession", Boolean.valueOf(x0XOIxOo()));
        properties.put("ConTimeout", new Integer(oIX0oI()));
        properties.put("KeepAliveInterval", new Integer(I0Io()));
        if (xoIox() == null) {
            xoIox2 = "null";
        } else {
            xoIox2 = xoIox();
        }
        properties.put("UserName", xoIox2);
        if (OOXIXo() == null) {
            OOXIXo2 = "null";
        } else {
            OOXIXo2 = OOXIXo();
        }
        properties.put("WillDestination", OOXIXo2);
        if (xxIXOIIO() == null) {
            properties.put("SocketFactory", "null");
        } else {
            properties.put("SocketFactory", xxIXOIIO());
        }
        if (Oxx0IOOO() == null) {
            properties.put("SSLProperties", "null");
        } else {
            properties.put("SSLProperties", Oxx0IOOO());
        }
        return properties;
    }

    public void IIXOooo(Properties properties) {
        this.f2652II0XooXoX = properties;
    }

    public void IXxxXO(int i) throws IllegalArgumentException {
        if (i >= 0) {
            this.f2658oIX0oI = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void O0xOxO(xoXoI xoxoi, byte[] bArr, int i, boolean z) {
        String II0xO02 = xoxoi.II0xO0();
        xxX(II0xO02, bArr);
        X0IIOO(II0xO02, new Oxx0xo(bArr), i, z);
    }

    public String OOXIXo() {
        return this.f2651I0Io;
    }

    public void Oo(int i) {
        if (i >= 0) {
            this.f2662xoIox = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void OxI(String str) {
        if (str != null && str.trim().equals("")) {
            throw new IllegalArgumentException();
        }
        this.f2656X0o0xo = str;
    }

    public Properties Oxx0IOOO() {
        return this.f2652II0XooXoX;
    }

    public void Oxx0xo(int i) {
        if (i >= 0) {
            this.f2653II0xO0 = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void OxxIIOOXO(char[] cArr) {
        this.f2657XO = cArr;
    }

    public void X0IIOO(String str, Oxx0xo oxx0xo, int i, boolean z) {
        this.f2651I0Io = str;
        this.f2661oxoX = oxx0xo;
        oxx0xo.setQos(i);
        this.f2661oxoX.setRetained(z);
        this.f2661oxoX.setMutable(false);
    }

    public int X0o0xo() {
        return this.f2659oOoXoXO;
    }

    public void XI0IXoo(String str, byte[] bArr, int i, boolean z) {
        xxX(str, bArr);
        X0IIOO(str, new Oxx0xo(bArr), i, z);
    }

    public char[] XO() {
        return this.f2657XO;
    }

    public void o00(SocketFactory socketFactory) {
        this.f2655Oxx0IOOO = socketFactory;
    }

    public void oI0IIXIo(int i) throws IllegalArgumentException {
        if (i != 0 && i != 3 && i != 4) {
            throw new IllegalArgumentException();
        }
        this.f2659oOoXoXO = i;
    }

    public int oIX0oI() {
        return this.f2662xoIox;
    }

    public void oO(boolean z) {
        this.f2660ooOOo0oXI = z;
    }

    public Oxx0xo oOoXoXO() {
        return this.f2661oxoX;
    }

    public boolean ooOOo0oXI() {
        return this.f2660ooOOo0oXI;
    }

    public int oxoX() {
        return this.f2653II0xO0;
    }

    public String toString() {
        return XOx.oIX0oI.Oxx0IOOO(II0xO0(), "Connection options");
    }

    public boolean x0XOIxOo() {
        return this.f2663xxIXOIIO;
    }

    public void x0xO0oo(boolean z) {
        this.f2663xxIXOIIO = z;
    }

    public String xoIox() {
        return this.f2656X0o0xo;
    }

    public void xoXoI(String[] strArr) {
        for (String str : strArr) {
            XIxXXX0x0(str);
        }
        this.f2654OOXIXo = strArr;
    }

    public SocketFactory xxIXOIIO() {
        return this.f2655Oxx0IOOO;
    }

    public final void xxX(String str, Object obj) {
        if (str != null && obj != null) {
            xoXoI.XO(str, false);
            return;
        }
        throw new IllegalArgumentException();
    }
}
