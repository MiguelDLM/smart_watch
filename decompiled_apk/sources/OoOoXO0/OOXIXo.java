package OoOoXO0;

import java.util.Hashtable;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import org.eclipse.paho.android.service.MqttServiceConstants;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

/* loaded from: classes6.dex */
public class OOXIXo implements oxoX {

    /* renamed from: IIX0o, reason: collision with root package name */
    public static int f2607IIX0o = 0;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final String f2608O0xOxO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final oxO.oxoX f2609X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final String f2610XI0IXoo = "paho";

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final long f2611XIxXXX0x0 = 30000;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final char f2612XxX0x0xxx = 55296;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static /* synthetic */ Class f2613ooXIXxIX = null;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final char f2614xXxxox0I = 56319;

    /* renamed from: xxX, reason: collision with root package name */
    public static final long f2615xxX = 10000;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public x0xO0oo f2616IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Ox0XO.II0xO0 f2617IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public String f2618Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public boolean f2619OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public Hashtable f2620Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public oOoXoXO f2621OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public String f2622XO;

    /* renamed from: o00, reason: collision with root package name */
    public Timer f2623o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public oO f2624oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public Object f2625xoXoI;

    /* loaded from: classes6.dex */
    public class oIX0oI extends TimerTask {

        /* renamed from: Oo, reason: collision with root package name */
        public static final String f2626Oo = "ReconnectTask.run";

        public oIX0oI() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            OOXIXo.f2609X0IIOO.xxIXOIIO(OOXIXo.f2608O0xOxO, f2626Oo, "506");
            OOXIXo.this.OOXIXo();
        }

        public /* synthetic */ oIX0oI(OOXIXo oOXIXo, oIX0oI oix0oi) {
            this();
        }
    }

    static {
        Class<OOXIXo> cls = f2613ooXIXxIX;
        if (cls == null) {
            cls = OOXIXo.class;
            f2613ooXIXxIX = cls;
        }
        String name = cls.getName();
        f2608O0xOxO = name;
        f2609X0IIOO = oxO.X0o0xo.oIX0oI(oxO.X0o0xo.f33551oIX0oI, name);
        f2607IIX0o = 1000;
    }

    public OOXIXo(String str, String str2) throws MqttException {
        this(str, str2, new IXI.oxoX());
    }

    public static boolean oIX0oI(char c) {
        if (c >= 55296 && c <= 56319) {
            return true;
        }
        return false;
    }

    public static String x0xO0oo() {
        StringBuffer stringBuffer = new StringBuffer(f2610XI0IXoo);
        stringBuffer.append(System.nanoTime());
        return stringBuffer.toString();
    }

    public final int IIXOooo(String str, int i) {
        int lastIndexOf = str.lastIndexOf(58);
        if (lastIndexOf != -1) {
            int indexOf = str.indexOf(47);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            return Integer.parseInt(str.substring(lastIndexOf + 1, indexOf));
        }
        return i;
    }

    public int IXxxXO() {
        return this.f2617IXxxXO.xoXoI();
    }

    public void O0xOxO(II0xO0 iI0xO0) {
        this.f2617IXxxXO.o0(new Ox0XO.OOXIXo(iI0xO0));
    }

    public final void OOXIXo() {
        f2609X0IIOO.OOXIXo(f2608O0xOxO, "attemptReconnect", "500", new Object[]{this.f2622XO});
        try {
            connect(this.f2616IIXOooo, this.f2625xoXoI, new xoIox(this));
        } catch (MqttSecurityException e) {
            f2609X0IIOO.II0xO0(f2608O0xOxO, "attemptReconnect", "804", null, e);
        } catch (MqttException e2) {
            f2609X0IIOO.II0xO0(f2608O0xOxO, "attemptReconnect", "804", null, e2);
        }
    }

    public Oxx0xo Oo(int i) {
        return this.f2617IXxxXO.IIXOooo(i);
    }

    public final void OxI(int i) {
        f2609X0IIOO.OOXIXo(f2608O0xOxO, "rescheduleReconnectCycle", "505", new Object[]{this.f2622XO, new Long(f2607IIX0o)});
        this.f2623o00.schedule(new oIX0oI(this, null), f2607IIX0o);
    }

    public String Oxx0xo() {
        return this.f2617IXxxXO.xxX()[this.f2617IXxxXO.XIxXXX0x0()].getServerURI();
    }

    public final String OxxIIOOXO(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            indexOf = str.indexOf(47);
        }
        if (indexOf == -1) {
            indexOf = str.length();
        }
        return str.substring(0, indexOf);
    }

    public final void X0IIOO() {
        f2609X0IIOO.OOXIXo(f2608O0xOxO, "startReconnectCycle", "503", new Object[]{this.f2622XO, new Long(f2607IIX0o)});
        StringBuffer stringBuffer = new StringBuffer("MQTT Reconnect: ");
        stringBuffer.append(this.f2622XO);
        Timer timer = new Timer(stringBuffer.toString());
        this.f2623o00 = timer;
        timer.schedule(new oIX0oI(this, null), f2607IIX0o);
    }

    public final void XI0IXoo() {
        f2609X0IIOO.OOXIXo(f2608O0xOxO, "stopReconnectCycle", "504", new Object[]{this.f2622XO});
        this.f2623o00.cancel();
        f2607IIX0o = 1000;
    }

    @Override // OoOoXO0.oxoX
    public void close() throws MqttException {
        oxO.oxoX oxox = f2609X0IIOO;
        String str = f2608O0xOxO;
        oxox.xxIXOIIO(str, "close", "113");
        this.f2617IXxxXO.x0XOIxOo();
        oxox.xxIXOIIO(str, "close", "114");
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX connect(Object obj, I0Io i0Io) throws MqttException, MqttSecurityException {
        return connect(new x0xO0oo(), obj, i0Io);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX disconnect(Object obj, I0Io i0Io) throws MqttException {
        return disconnect(30000L, obj, i0Io);
    }

    @Override // OoOoXO0.oxoX
    public void disconnectForcibly() throws MqttException {
        disconnectForcibly(30000L, 10000L);
    }

    @Override // OoOoXO0.oxoX
    public String getClientId() {
        return this.f2622XO;
    }

    @Override // OoOoXO0.oxoX
    public XO[] getPendingDeliveryTokens() {
        return this.f2617IXxxXO.XxX0x0xxx();
    }

    @Override // OoOoXO0.oxoX
    public String getServerURI() {
        return this.f2618Oo;
    }

    @Override // OoOoXO0.oxoX
    public boolean isConnected() {
        return this.f2617IXxxXO.IoOoX();
    }

    @Override // OoOoXO0.oxoX
    public void messageArrivedComplete(int i, int i2) throws MqttException {
        this.f2617IXxxXO.xII(i, i2);
    }

    public void o00() throws MqttException {
        f2609X0IIOO.OOXIXo(f2608O0xOxO, "reconnect", "500", new Object[]{this.f2622XO});
        if (!this.f2617IXxxXO.IoOoX()) {
            if (!this.f2617IXxxXO.oOXoIIIo()) {
                if (!this.f2617IXxxXO.X00IoxXI()) {
                    if (!this.f2617IXxxXO.oo()) {
                        XI0IXoo();
                        OOXIXo();
                        return;
                    }
                    throw new MqttException(32111);
                }
                throw new MqttException(32102);
            }
            throw new MqttException(32110);
        }
        throw Ox0XO.oOoXoXO.oIX0oI(32100);
    }

    public XOx.oIX0oI oI0IIXIo() {
        return new XOx.oIX0oI(this.f2622XO, this.f2617IXxxXO);
    }

    public void oO(int i) {
        this.f2617IXxxXO.Oo(i);
    }

    public II0XooXoX oOoXoXO(Object obj, I0Io i0Io) throws MqttException {
        oxO.oxoX oxox = f2609X0IIOO;
        String str = f2608O0xOxO;
        oxox.xxIXOIIO(str, "ping", "117");
        IIXOooo oOoXoXO2 = this.f2617IXxxXO.oOoXoXO();
        oxox.xxIXOIIO(str, "ping", "118");
        return oOoXoXO2;
    }

    public final Ox0XO.Oxx0xo ooOOo0oXI(String str, x0xO0oo x0xo0oo) throws MqttException, MqttSecurityException {
        OOoOoO0o.oIX0oI oix0oi;
        String[] Oxx0IOOO2;
        OOoOoO0o.oIX0oI oix0oi2;
        String[] Oxx0IOOO3;
        f2609X0IIOO.OOXIXo(f2608O0xOxO, "createNetworkModule", "115", new Object[]{str});
        SocketFactory xxIXOIIO2 = x0xo0oo.xxIXOIIO();
        int XIxXXX0x02 = x0xO0oo.XIxXXX0x0(str);
        if (XIxXXX0x02 != 0) {
            if (XIxXXX0x02 != 1) {
                if (XIxXXX0x02 != 2) {
                    if (XIxXXX0x02 != 3) {
                        if (XIxXXX0x02 != 4) {
                            return null;
                        }
                        String substring = str.substring(6);
                        String OxxIIOOXO2 = OxxIIOOXO(substring);
                        int IIXOooo2 = IIXOooo(substring, 443);
                        if (xxIXOIIO2 == null) {
                            OOoOoO0o.oIX0oI oix0oi3 = new OOoOoO0o.oIX0oI();
                            Properties Oxx0IOOO4 = x0xo0oo.Oxx0IOOO();
                            if (Oxx0IOOO4 != null) {
                                oix0oi3.xoXoI(Oxx0IOOO4, null);
                            }
                            oix0oi2 = oix0oi3;
                            xxIXOIIO2 = oix0oi3.I0Io(null);
                        } else if (xxIXOIIO2 instanceof SSLSocketFactory) {
                            oix0oi2 = null;
                        } else {
                            throw Ox0XO.oOoXoXO.oIX0oI(32105);
                        }
                        IoxX.II0XooXoX iI0XooXoX = new IoxX.II0XooXoX((SSLSocketFactory) xxIXOIIO2, str, OxxIIOOXO2, IIXOooo2, this.f2622XO);
                        iI0XooXoX.X0o0xo(x0xo0oo.oIX0oI());
                        if (oix0oi2 != null && (Oxx0IOOO3 = oix0oi2.Oxx0IOOO(null)) != null) {
                            iI0XooXoX.oxoX(Oxx0IOOO3);
                        }
                        return iI0XooXoX;
                    }
                    String substring2 = str.substring(5);
                    String OxxIIOOXO3 = OxxIIOOXO(substring2);
                    int IIXOooo3 = IIXOooo(substring2, 80);
                    if (xxIXOIIO2 == null) {
                        xxIXOIIO2 = SocketFactory.getDefault();
                    } else if (xxIXOIIO2 instanceof SSLSocketFactory) {
                        throw Ox0XO.oOoXoXO.oIX0oI(32105);
                    }
                    IoxX.X0o0xo x0o0xo = new IoxX.X0o0xo(xxIXOIIO2, str, OxxIIOOXO3, IIXOooo3, this.f2622XO);
                    x0o0xo.II0xO0(x0xo0oo.oIX0oI());
                    return x0o0xo;
                }
                return new Ox0XO.oO(str.substring(8));
            }
            String substring3 = str.substring(6);
            String OxxIIOOXO4 = OxxIIOOXO(substring3);
            int IIXOooo4 = IIXOooo(substring3, 8883);
            if (xxIXOIIO2 == null) {
                OOoOoO0o.oIX0oI oix0oi4 = new OOoOoO0o.oIX0oI();
                Properties Oxx0IOOO5 = x0xo0oo.Oxx0IOOO();
                if (Oxx0IOOO5 != null) {
                    oix0oi4.xoXoI(Oxx0IOOO5, null);
                }
                oix0oi = oix0oi4;
                xxIXOIIO2 = oix0oi4.I0Io(null);
            } else if (xxIXOIIO2 instanceof SSLSocketFactory) {
                oix0oi = null;
            } else {
                throw Ox0XO.oOoXoXO.oIX0oI(32105);
            }
            Ox0XO.OxxIIOOXO oxxIIOOXO = new Ox0XO.OxxIIOOXO((SSLSocketFactory) xxIXOIIO2, OxxIIOOXO4, IIXOooo4, this.f2622XO);
            oxxIIOOXO.X0o0xo(x0xo0oo.oIX0oI());
            if (oix0oi != null && (Oxx0IOOO2 = oix0oi.Oxx0IOOO(null)) != null) {
                oxxIIOOXO.oxoX(Oxx0IOOO2);
            }
            return oxxIIOOXO;
        }
        String substring4 = str.substring(6);
        String OxxIIOOXO5 = OxxIIOOXO(substring4);
        int IIXOooo5 = IIXOooo(substring4, 1883);
        if (xxIXOIIO2 == null) {
            xxIXOIIO2 = SocketFactory.getDefault();
        } else if (xxIXOIIO2 instanceof SSLSocketFactory) {
            throw Ox0XO.oOoXoXO.oIX0oI(32105);
        }
        Ox0XO.IIXOooo iIXOooo = new Ox0XO.IIXOooo(xxIXOIIO2, OxxIIOOXO5, IIXOooo5, this.f2622XO);
        iIXOooo.II0xO0(x0xo0oo.oIX0oI());
        return iIXOooo;
    }

    @Override // OoOoXO0.oxoX
    public XO publish(String str, byte[] bArr, int i, boolean z, Object obj, I0Io i0Io) throws MqttException, MqttPersistenceException {
        Oxx0xo oxx0xo = new Oxx0xo(bArr);
        oxx0xo.setQos(i);
        oxx0xo.setRetained(z);
        return publish(str, oxx0xo, obj, i0Io);
    }

    @Override // OoOoXO0.oxoX
    public void setCallback(oOoXoXO oooxoxo) {
        this.f2621OxxIIOOXO = oooxoxo;
        this.f2617IXxxXO.Io(oooxoxo);
    }

    @Override // OoOoXO0.oxoX
    public void setManualAcks(boolean z) {
        this.f2617IXxxXO.XX(z);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX subscribe(String str, int i, Object obj, I0Io i0Io) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i}, obj, i0Io);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX unsubscribe(String str, Object obj, I0Io i0Io) throws MqttException {
        return unsubscribe(new String[]{str}, obj, i0Io);
    }

    public Ox0XO.Oxx0xo[] x0XOIxOo(String str, x0xO0oo x0xo0oo) throws MqttException, MqttSecurityException {
        f2609X0IIOO.OOXIXo(f2608O0xOxO, "createNetworkModules", "116", new Object[]{str});
        String[] II0XooXoX2 = x0xo0oo.II0XooXoX();
        if (II0XooXoX2 == null) {
            II0XooXoX2 = new String[]{str};
        } else if (II0XooXoX2.length == 0) {
            II0XooXoX2 = new String[]{str};
        }
        Ox0XO.Oxx0xo[] oxx0xoArr = new Ox0XO.Oxx0xo[II0XooXoX2.length];
        for (int i = 0; i < II0XooXoX2.length; i++) {
            oxx0xoArr[i] = ooOOo0oXI(II0XooXoX2[i], x0xo0oo);
        }
        f2609X0IIOO.xxIXOIIO(f2608O0xOxO, "createNetworkModules", "108");
        return oxx0xoArr;
    }

    public xoXoI xoXoI(String str) {
        xoXoI.XO(str, false);
        xoXoI xoxoi = (xoXoI) this.f2620Oxx0xo.get(str);
        if (xoxoi == null) {
            xoXoI xoxoi2 = new xoXoI(str, this.f2617IXxxXO);
            this.f2620Oxx0xo.put(str, xoxoi2);
            return xoxoi2;
        }
        return xoxoi;
    }

    public OOXIXo(String str, String str2, oO oOVar) throws MqttException {
        this(str, str2, oOVar, new o00());
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX connect() throws MqttException, MqttSecurityException {
        return connect(null, null);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX disconnect() throws MqttException {
        return disconnect(null, null);
    }

    @Override // OoOoXO0.oxoX
    public void disconnectForcibly(long j) throws MqttException {
        disconnectForcibly(30000L, j);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX subscribe(String str, int i) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i}, (Object) null, (I0Io) null);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX unsubscribe(String str) throws MqttException {
        return unsubscribe(new String[]{str}, (Object) null, (I0Io) null);
    }

    public OOXIXo(String str, String str2, oO oOVar, OxxIIOOXO oxxIIOOXO) throws MqttException {
        this.f2619OxI = false;
        f2609X0IIOO.xoIox(str2);
        if (str2 != null) {
            int i = 0;
            int i2 = 0;
            while (i < str2.length() - 1) {
                if (oIX0oI(str2.charAt(i))) {
                    i++;
                }
                i2++;
                i++;
            }
            if (i2 <= 65535) {
                x0xO0oo.XIxXXX0x0(str);
                this.f2618Oo = str;
                this.f2622XO = str2;
                this.f2624oI0IIXIo = oOVar;
                if (oOVar == null) {
                    this.f2624oI0IIXIo = new IXI.oIX0oI();
                }
                f2609X0IIOO.OOXIXo(f2608O0xOxO, "MqttAsyncClient", "101", new Object[]{str2, str, oOVar});
                this.f2624oI0IIXIo.oIX0oI(str2, str);
                this.f2617IXxxXO = new Ox0XO.II0xO0(this, this.f2624oI0IIXIo, oxxIIOOXO);
                this.f2624oI0IIXIo.close();
                this.f2620Oxx0xo = new Hashtable();
                return;
            }
            throw new IllegalArgumentException("ClientId longer than 65535 characters");
        }
        throw new IllegalArgumentException("Null clientId");
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX connect(x0xO0oo x0xo0oo) throws MqttException, MqttSecurityException {
        return connect(x0xo0oo, null, null);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX disconnect(long j) throws MqttException {
        return disconnect(j, null, null);
    }

    @Override // OoOoXO0.oxoX
    public void disconnectForcibly(long j, long j2) throws MqttException {
        this.f2617IXxxXO.OxxIIOOXO(j, j2);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX subscribe(String[] strArr, int[] iArr) throws MqttException {
        return subscribe(strArr, iArr, (Object) null, (I0Io) null);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX unsubscribe(String[] strArr) throws MqttException {
        return unsubscribe(strArr, (Object) null, (I0Io) null);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX connect(x0xO0oo x0xo0oo, Object obj, I0Io i0Io) throws MqttException, MqttSecurityException {
        if (!this.f2617IXxxXO.IoOoX()) {
            if (!this.f2617IXxxXO.oOXoIIIo()) {
                if (!this.f2617IXxxXO.X00IoxXI()) {
                    if (!this.f2617IXxxXO.oo()) {
                        this.f2616IIXOooo = x0xo0oo;
                        this.f2625xoXoI = obj;
                        boolean ooOOo0oXI2 = x0xo0oo.ooOOo0oXI();
                        f2609X0IIOO.OOXIXo(f2608O0xOxO, MqttServiceConstants.CONNECT_ACTION, "103", new Object[]{Boolean.valueOf(x0xo0oo.x0XOIxOo()), new Integer(x0xo0oo.oIX0oI()), new Integer(x0xo0oo.I0Io()), x0xo0oo.xoIox(), x0xo0oo.XO() == null ? "[null]" : "[notnull]", x0xo0oo.oOoXoXO() == null ? "[null]" : "[notnull]", obj, i0Io});
                        this.f2617IXxxXO.XoX(x0XOIxOo(this.f2618Oo, x0xo0oo));
                        this.f2617IXxxXO.oxXx0IX(new xxIXOIIO(this, ooOOo0oXI2));
                        IIXOooo iIXOooo = new IIXOooo(getClientId());
                        Ox0XO.xxIXOIIO xxixoiio = new Ox0XO.xxIXOIIO(this, this.f2624oI0IIXIo, this.f2617IXxxXO, x0xo0oo, iIXOooo, obj, i0Io, this.f2619OxI);
                        iIXOooo.setActionCallback(xxixoiio);
                        iIXOooo.setUserContext(this);
                        oOoXoXO oooxoxo = this.f2621OxxIIOOXO;
                        if (oooxoxo instanceof ooOOo0oXI) {
                            xxixoiio.II0xO0((ooOOo0oXI) oooxoxo);
                        }
                        this.f2617IXxxXO.oxxXoxO(0);
                        xxixoiio.oIX0oI();
                        return iIXOooo;
                    }
                    throw new MqttException(32111);
                }
                throw new MqttException(32102);
            }
            throw new MqttException(32110);
        }
        throw Ox0XO.oOoXoXO.oIX0oI(32100);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX disconnect(long j, Object obj, I0Io i0Io) throws MqttException {
        oxO.oxoX oxox = f2609X0IIOO;
        String str = f2608O0xOxO;
        oxox.OOXIXo(str, MqttServiceConstants.DISCONNECT_ACTION, "104", new Object[]{new Long(j), obj, i0Io});
        IIXOooo iIXOooo = new IIXOooo(getClientId());
        iIXOooo.setActionCallback(i0Io);
        iIXOooo.setUserContext(obj);
        try {
            this.f2617IXxxXO.oI0IIXIo(new IXIIo.X0o0xo(), j, iIXOooo);
            oxox.xxIXOIIO(str, MqttServiceConstants.DISCONNECT_ACTION, "108");
            return iIXOooo;
        } catch (MqttException e) {
            f2609X0IIOO.II0xO0(f2608O0xOxO, MqttServiceConstants.DISCONNECT_ACTION, "105", null, e);
            throw e;
        }
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX subscribe(String[] strArr, int[] iArr, Object obj, I0Io i0Io) throws MqttException {
        if (strArr.length == iArr.length) {
            for (String str : strArr) {
                this.f2617IXxxXO.XOxIOxOx(str);
            }
            String str2 = "";
            for (int i = 0; i < strArr.length; i++) {
                if (i > 0) {
                    StringBuffer stringBuffer = new StringBuffer(String.valueOf(str2));
                    stringBuffer.append(", ");
                    str2 = stringBuffer.toString();
                }
                StringBuffer stringBuffer2 = new StringBuffer(String.valueOf(str2));
                stringBuffer2.append("topic=");
                stringBuffer2.append(strArr[i]);
                stringBuffer2.append(" qos=");
                stringBuffer2.append(iArr[i]);
                str2 = stringBuffer2.toString();
                xoXoI.XO(strArr[i], true);
            }
            oxO.oxoX oxox = f2609X0IIOO;
            String str3 = f2608O0xOxO;
            oxox.OOXIXo(str3, MqttServiceConstants.SUBSCRIBE_ACTION, "106", new Object[]{str2, obj, i0Io});
            IIXOooo iIXOooo = new IIXOooo(getClientId());
            iIXOooo.setActionCallback(i0Io);
            iIXOooo.setUserContext(obj);
            iIXOooo.f2606oIX0oI.XIxXXX0x0(strArr);
            this.f2617IXxxXO.OI0(new IXIIo.Oxx0xo(strArr, iArr), iIXOooo);
            oxox.xxIXOIIO(str3, MqttServiceConstants.SUBSCRIBE_ACTION, "109");
            return iIXOooo;
        }
        throw new IllegalArgumentException();
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX unsubscribe(String[] strArr, Object obj, I0Io i0Io) throws MqttException {
        String str = "";
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                StringBuffer stringBuffer = new StringBuffer(String.valueOf(str));
                stringBuffer.append(", ");
                str = stringBuffer.toString();
            }
            StringBuffer stringBuffer2 = new StringBuffer(String.valueOf(str));
            stringBuffer2.append(strArr[i]);
            str = stringBuffer2.toString();
            xoXoI.XO(strArr[i], true);
        }
        f2609X0IIOO.OOXIXo(f2608O0xOxO, MqttServiceConstants.UNSUBSCRIBE_ACTION, "107", new Object[]{str, obj, i0Io});
        for (String str2 : strArr) {
            this.f2617IXxxXO.XOxIOxOx(str2);
        }
        IIXOooo iIXOooo = new IIXOooo(getClientId());
        iIXOooo.setActionCallback(i0Io);
        iIXOooo.setUserContext(obj);
        iIXOooo.f2606oIX0oI.XIxXXX0x0(strArr);
        this.f2617IXxxXO.OI0(new IXIIo.OxxIIOOXO(strArr), iIXOooo);
        f2609X0IIOO.xxIXOIIO(f2608O0xOxO, MqttServiceConstants.UNSUBSCRIBE_ACTION, "110");
        return iIXOooo;
    }

    @Override // OoOoXO0.oxoX
    public XO publish(String str, byte[] bArr, int i, boolean z) throws MqttException, MqttPersistenceException {
        return publish(str, bArr, i, z, null, null);
    }

    @Override // OoOoXO0.oxoX
    public XO publish(String str, Oxx0xo oxx0xo) throws MqttException, MqttPersistenceException {
        return publish(str, oxx0xo, (Object) null, (I0Io) null);
    }

    @Override // OoOoXO0.oxoX
    public XO publish(String str, Oxx0xo oxx0xo, Object obj, I0Io i0Io) throws MqttException, MqttPersistenceException {
        oxO.oxoX oxox = f2609X0IIOO;
        String str2 = f2608O0xOxO;
        oxox.OOXIXo(str2, "publish", "111", new Object[]{str, obj, i0Io});
        xoXoI.XO(str, false);
        IXxxXO iXxxXO = new IXxxXO(getClientId());
        iXxxXO.setActionCallback(i0Io);
        iXxxXO.setUserContext(obj);
        iXxxXO.oIX0oI(oxx0xo);
        iXxxXO.f2606oIX0oI.XIxXXX0x0(new String[]{str});
        this.f2617IXxxXO.OI0(new IXIIo.oO(str, oxx0xo), iXxxXO);
        oxox.xxIXOIIO(str2, "publish", "112");
        return iXxxXO;
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX subscribe(String str, int i, Object obj, I0Io i0Io, Oxx0IOOO oxx0IOOO) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i}, obj, i0Io, new Oxx0IOOO[]{oxx0IOOO});
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX subscribe(String str, int i, Oxx0IOOO oxx0IOOO) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i}, (Object) null, (I0Io) null, new Oxx0IOOO[]{oxx0IOOO});
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX subscribe(String[] strArr, int[] iArr, Oxx0IOOO[] oxx0IOOOArr) throws MqttException {
        return subscribe(strArr, iArr, (Object) null, (I0Io) null, oxx0IOOOArr);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX subscribe(String[] strArr, int[] iArr, Object obj, I0Io i0Io, Oxx0IOOO[] oxx0IOOOArr) throws MqttException {
        if (oxx0IOOOArr.length == iArr.length && iArr.length == strArr.length) {
            II0XooXoX subscribe = subscribe(strArr, iArr, obj, i0Io);
            for (int i = 0; i < strArr.length; i++) {
                this.f2617IXxxXO.I0oOoX(strArr[i], oxx0IOOOArr[i]);
            }
            return subscribe;
        }
        throw new IllegalArgumentException();
    }
}
