package Ox0XO;

import com.huawei.openalliance.ad.constant.bn;
import java.util.Enumeration;
import java.util.Properties;
import org.eclipse.paho.android.service.MqttServiceConstants;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

/* loaded from: classes6.dex */
public class II0xO0 {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final byte f2813IIXOooo = 0;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static String f2814IXxxXO = "${project.version}";

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final byte f2815O0xOxO = 4;

    /* renamed from: OxI, reason: collision with root package name */
    public static final byte f2816OxI = 3;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static String f2817Oxx0xo = "L${build.level}";

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final oxO.oxoX f2818OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static /* synthetic */ Class f2819X0IIOO = null;

    /* renamed from: o00, reason: collision with root package name */
    public static final byte f2820o00 = 2;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final String f2821oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final byte f2822xoXoI = 1;

    /* renamed from: I0Io, reason: collision with root package name */
    public Oxx0xo[] f2823I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public OoOoXO0.x0xO0oo f2824II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f2825II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public II0XooXoX f2826OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public OOXIXo f2827Oo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public oxoX f2828Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public Oxx0IOOO f2829X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public X0o0xo f2830XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public OoOoXO0.oxoX f2831oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public XO f2835oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public OoOoXO0.OxxIIOOXO f2838xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public OoOoXO0.oO f2839xxIXOIIO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public boolean f2833oOoXoXO = false;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public Object f2836x0XOIxOo = new Object();

    /* renamed from: oO, reason: collision with root package name */
    public boolean f2832oO = false;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public boolean f2837x0xO0oo = false;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public byte f2834ooOOo0oXI = 3;

    /* renamed from: Ox0XO.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0042II0xO0 implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public long f2840IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public IXIIo.X0o0xo f2841Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public OoOoXO0.IIXOooo f2842Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public Thread f2843XO = null;

        public RunnableC0042II0xO0(IXIIo.X0o0xo x0o0xo, long j, OoOoXO0.IIXOooo iIXOooo) {
            this.f2841Oo = x0o0xo;
            this.f2840IXxxXO = j;
            this.f2842Oxx0xo = iIXOooo;
        }

        public void oIX0oI() {
            StringBuffer stringBuffer = new StringBuffer("MQTT Disc: ");
            stringBuffer.append(II0xO0.this.o00().getClientId());
            Thread thread = new Thread(this, stringBuffer.toString());
            this.f2843XO = thread;
            thread.start();
        }

        @Override // java.lang.Runnable
        public void run() {
            II0xO0.f2818OxxIIOOXO.xxIXOIIO(II0xO0.f2821oI0IIXIo, "disconnectBG:run", "221");
            II0xO0.this.f2828Oxx0IOOO.xXxxox0I(this.f2840IXxxXO);
            try {
                II0xO0.this.oo0xXOI0I(this.f2841Oo, this.f2842Oxx0xo);
                this.f2842Oxx0xo.f2606oIX0oI.xI();
            } catch (MqttException unused) {
            } catch (Throwable th) {
                this.f2842Oxx0xo.f2606oIX0oI.IXxxXO(null, null);
                II0xO0.this.xXOx(this.f2842Oxx0xo, null);
                throw th;
            }
            this.f2842Oxx0xo.f2606oIX0oI.IXxxXO(null, null);
            II0xO0.this.xXOx(this.f2842Oxx0xo, null);
        }
    }

    /* loaded from: classes6.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public OoOoXO0.IIXOooo f2845IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public Thread f2846Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public IXIIo.oxoX f2847Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public II0xO0 f2848XO;

        public oIX0oI(II0xO0 iI0xO0, OoOoXO0.IIXOooo iIXOooo, IXIIo.oxoX oxox) {
            this.f2846Oo = null;
            this.f2848XO = iI0xO0;
            this.f2845IXxxXO = iIXOooo;
            this.f2847Oxx0xo = oxox;
            StringBuffer stringBuffer = new StringBuffer("MQTT Con: ");
            stringBuffer.append(II0xO0.this.o00().getClientId());
            this.f2846Oo = new Thread(this, stringBuffer.toString());
        }

        public void oIX0oI() {
            this.f2846Oo.start();
        }

        @Override // java.lang.Runnable
        public void run() {
            MqttException II0xO02;
            II0xO0.f2818OxxIIOOXO.xxIXOIIO(II0xO0.f2821oI0IIXIo, "connectBG:run", "220");
            try {
                OoOoXO0.IXxxXO[] I0Io2 = II0xO0.this.f2826OOXIXo.I0Io();
                int i = 0;
                while (true) {
                    II0xO02 = null;
                    if (i >= I0Io2.length) {
                        break;
                    }
                    I0Io2[i].f2606oIX0oI.o00(null);
                    i++;
                }
                II0xO0.this.f2826OOXIXo.oOoXoXO(this.f2845IXxxXO, this.f2847Oxx0xo);
                Oxx0xo oxx0xo = II0xO0.this.f2823I0Io[II0xO0.this.f2825II0xO0];
                oxx0xo.start();
                II0xO0.this.f2835oxoX = new XO(this.f2848XO, II0xO0.this.f2828Oxx0IOOO, II0xO0.this.f2826OOXIXo, oxx0xo.getInputStream());
                XO xo2 = II0xO0.this.f2835oxoX;
                StringBuffer stringBuffer = new StringBuffer("MQTT Rec: ");
                stringBuffer.append(II0xO0.this.o00().getClientId());
                xo2.I0Io(stringBuffer.toString());
                II0xO0.this.f2829X0o0xo = new Oxx0IOOO(this.f2848XO, II0xO0.this.f2828Oxx0IOOO, II0xO0.this.f2826OOXIXo, oxx0xo.oIX0oI());
                Oxx0IOOO oxx0IOOO = II0xO0.this.f2829X0o0xo;
                StringBuffer stringBuffer2 = new StringBuffer("MQTT Snd: ");
                stringBuffer2.append(II0xO0.this.o00().getClientId());
                oxx0IOOO.II0xO0(stringBuffer2.toString());
                X0o0xo x0o0xo = II0xO0.this.f2830XO;
                StringBuffer stringBuffer3 = new StringBuffer("MQTT Call: ");
                stringBuffer3.append(II0xO0.this.o00().getClientId());
                x0o0xo.Oxx0xo(stringBuffer3.toString());
                II0xO0.this.oo0xXOI0I(this.f2847Oxx0xo, this.f2845IXxxXO);
            } catch (MqttException e) {
                II0xO0.f2818OxxIIOOXO.II0xO0(II0xO0.f2821oI0IIXIo, "connectBG:run", "212", null, e);
                II0xO02 = e;
            } catch (Exception e2) {
                II0xO0.f2818OxxIIOOXO.II0xO0(II0xO0.f2821oI0IIXIo, "connectBG:run", "209", null, e2);
                II0xO02 = oOoXoXO.II0xO0(e2);
            }
            if (II0xO02 != null) {
                II0xO0.this.xXOx(this.f2845IXxxXO, II0xO02);
            }
        }
    }

    static {
        Class<II0xO0> cls = f2819X0IIOO;
        if (cls == null) {
            cls = II0xO0.class;
            f2819X0IIOO = cls;
        }
        String name = cls.getName();
        f2821oI0IIXIo = name;
        f2818OxxIIOOXO = oxO.X0o0xo.oIX0oI(oxO.X0o0xo.f33551oIX0oI, name);
    }

    public II0xO0(OoOoXO0.oxoX oxox, OoOoXO0.oO oOVar, OoOoXO0.OxxIIOOXO oxxIIOOXO) throws MqttException {
        this.f2831oIX0oI = oxox;
        this.f2839xxIXOIIO = oOVar;
        this.f2838xoIox = oxxIIOOXO;
        oxxIIOOXO.init(this);
        this.f2826OOXIXo = new II0XooXoX(o00().getClientId());
        this.f2830XO = new X0o0xo(this);
        oxoX oxox2 = new oxoX(oOVar, this.f2826OOXIXo, this.f2830XO, this, oxxIIOOXO);
        this.f2828Oxx0IOOO = oxox2;
        this.f2830XO.oO(oxox2);
        f2818OxxIIOOXO.xoIox(o00().getClientId());
    }

    public void I0oOoX(String str, OoOoXO0.Oxx0IOOO oxx0IOOO) {
        this.f2830XO.Oo(str, oxx0IOOO);
    }

    public OoOoXO0.xoXoI IIX0o(String str) {
        return new OoOoXO0.xoXoI(str, this);
    }

    public OoOoXO0.Oxx0xo IIXOooo(int i) {
        return ((IXIIo.oO) this.f2827Oo.II0xO0(i).oIX0oI()).X0IIOO();
    }

    public boolean IO() {
        boolean z;
        synchronized (this.f2836x0XOIxOo) {
            z = this.f2837x0xO0oo;
        }
        return z;
    }

    public void IXxxXO(int i) throws MqttPersistenceException {
        this.f2828Oxx0IOOO.Oxx0IOOO(i);
    }

    public void Io(OoOoXO0.oOoXoXO oooxoxo) {
        this.f2830XO.x0XOIxOo(oooxoxo);
    }

    public boolean IoOoX() {
        boolean z;
        synchronized (this.f2836x0XOIxOo) {
            if (this.f2834ooOOo0oXI == 0) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public OoOoXO0.x0xO0oo O0xOxO() {
        return this.f2824II0XooXoX;
    }

    public void OI0(IXIIo.IIXOooo iIXOooo, OoOoXO0.IIXOooo iIXOooo2) throws MqttException {
        if (!IoOoX() && ((IoOoX() || !(iIXOooo instanceof IXIIo.oxoX)) && (!X00IoxXI() || !(iIXOooo instanceof IXIIo.X0o0xo)))) {
            if (this.f2827Oo != null && IO()) {
                f2818OxxIIOOXO.OOXIXo(f2821oI0IIXIo, "sendNoWait", "508", new Object[]{iIXOooo.oO()});
                this.f2828Oxx0IOOO.XxX0x0xxx(iIXOooo);
                this.f2827Oo.oxoX(iIXOooo, iIXOooo2);
                return;
            }
            f2818OxxIIOOXO.xxIXOIIO(f2821oI0IIXIo, "sendNoWait", "208");
            throw oOoXoXO.oIX0oI(32104);
        }
        OOXIXo oOXIXo = this.f2827Oo;
        if (oOXIXo != null && oOXIXo.I0Io() != 0) {
            f2818OxxIIOOXO.OOXIXo(f2821oI0IIXIo, "sendNoWait", "507", new Object[]{iIXOooo.oO()});
            this.f2828Oxx0IOOO.XxX0x0xxx(iIXOooo);
            this.f2827Oo.oxoX(iIXOooo, iIXOooo2);
            return;
        }
        oo0xXOI0I(iIXOooo, iIXOooo2);
    }

    public void Oo(int i) {
        this.f2827Oo.oIX0oI(i);
    }

    public oxoX OxI() {
        return this.f2828Oxx0IOOO;
    }

    public void Oxx0xo(IXIIo.oO oOVar) throws MqttPersistenceException {
        this.f2828Oxx0IOOO.II0XooXoX(oOVar);
    }

    public void OxxIIOOXO(long j, long j2) throws MqttException {
        this.f2828Oxx0IOOO.xXxxox0I(j);
        OoOoXO0.IIXOooo iIXOooo = new OoOoXO0.IIXOooo(this.f2831oIX0oI.getClientId());
        try {
            oo0xXOI0I(new IXIIo.X0o0xo(), iIXOooo);
            iIXOooo.waitForCompletion(j2);
        } catch (Exception unused) {
        } catch (Throwable th) {
            iIXOooo.f2606oIX0oI.IXxxXO(null, null);
            xXOx(iIXOooo, null);
            throw th;
        }
        iIXOooo.f2606oIX0oI.IXxxXO(null, null);
        xXOx(iIXOooo, null);
    }

    public boolean X00IoxXI() {
        boolean z;
        synchronized (this.f2836x0XOIxOo) {
            if (this.f2834ooOOo0oXI == 2) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public Properties X0IIOO() {
        Properties properties = new Properties();
        properties.put("conState", new Integer(this.f2834ooOOo0oXI));
        properties.put("serverURI", o00().getServerURI());
        properties.put(bn.f.L, this.f2830XO);
        properties.put("stoppingComms", new Boolean(this.f2833oOoXoXO));
        return properties;
    }

    public long XI0IXoo() {
        return this.f2828Oxx0IOOO.x0XOIxOo();
    }

    public int XIxXXX0x0() {
        return this.f2825II0xO0;
    }

    public void XOxIOxOx(String str) {
        this.f2830XO.oOoXoXO(str);
    }

    public void XX(boolean z) {
        this.f2830XO.x0xO0oo(z);
    }

    public void XoX(Oxx0xo[] oxx0xoArr) {
        this.f2823I0Io = oxx0xoArr;
    }

    public boolean Xx000oIo() {
        boolean z;
        synchronized (this.f2836x0XOIxOo) {
            if (this.f2834ooOOo0oXI == 3) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public OoOoXO0.IXxxXO[] XxX0x0xxx() {
        return this.f2826OOXIXo.I0Io();
    }

    public void o0(OOXIXo oOXIXo) {
        this.f2827Oo = oOXIXo;
    }

    public OoOoXO0.oxoX o00() {
        return this.f2831oIX0oI;
    }

    public void oI0IIXIo(IXIIo.X0o0xo x0o0xo, long j, OoOoXO0.IIXOooo iIXOooo) throws MqttException {
        synchronized (this.f2836x0XOIxOo) {
            try {
                if (!oo()) {
                    if (!Xx000oIo()) {
                        if (!X00IoxXI()) {
                            if (Thread.currentThread() != this.f2830XO.X0o0xo()) {
                                f2818OxxIIOOXO.xxIXOIIO(f2821oI0IIXIo, MqttServiceConstants.DISCONNECT_ACTION, "218");
                                this.f2834ooOOo0oXI = (byte) 2;
                                new RunnableC0042II0xO0(x0o0xo, j, iIXOooo).oIX0oI();
                            } else {
                                f2818OxxIIOOXO.xxIXOIIO(f2821oI0IIXIo, MqttServiceConstants.DISCONNECT_ACTION, "210");
                                throw oOoXoXO.oIX0oI(32107);
                            }
                        } else {
                            f2818OxxIIOOXO.xxIXOIIO(f2821oI0IIXIo, MqttServiceConstants.DISCONNECT_ACTION, "219");
                            throw oOoXoXO.oIX0oI(32102);
                        }
                    } else {
                        f2818OxxIIOOXO.xxIXOIIO(f2821oI0IIXIo, MqttServiceConstants.DISCONNECT_ACTION, "211");
                        throw oOoXoXO.oIX0oI(32101);
                    }
                } else {
                    f2818OxxIIOOXO.xxIXOIIO(f2821oI0IIXIo, MqttServiceConstants.DISCONNECT_ACTION, "223");
                    throw oOoXoXO.oIX0oI(32111);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void oO(OoOoXO0.x0xO0oo x0xo0oo, OoOoXO0.IIXOooo iIXOooo) throws MqttException {
        synchronized (this.f2836x0XOIxOo) {
            try {
                if (Xx000oIo() && !this.f2832oO) {
                    f2818OxxIIOOXO.xxIXOIIO(f2821oI0IIXIo, MqttServiceConstants.CONNECT_ACTION, "214");
                    this.f2834ooOOo0oXI = (byte) 1;
                    this.f2824II0XooXoX = x0xo0oo;
                    IXIIo.oxoX oxox = new IXIIo.oxoX(this.f2831oIX0oI.getClientId(), this.f2824II0XooXoX.X0o0xo(), this.f2824II0XooXoX.x0XOIxOo(), this.f2824II0XooXoX.I0Io(), this.f2824II0XooXoX.xoIox(), this.f2824II0XooXoX.XO(), this.f2824II0XooXoX.oOoXoXO(), this.f2824II0XooXoX.OOXIXo());
                    this.f2828Oxx0IOOO.IO(this.f2824II0XooXoX.I0Io());
                    this.f2828Oxx0IOOO.Xx000oIo(this.f2824II0XooXoX.x0XOIxOo());
                    this.f2828Oxx0IOOO.xII(this.f2824II0XooXoX.oxoX());
                    this.f2826OOXIXo.Oxx0IOOO();
                    new oIX0oI(this, iIXOooo, oxox).oIX0oI();
                } else {
                    f2818OxxIIOOXO.OOXIXo(f2821oI0IIXIo, MqttServiceConstants.CONNECT_ACTION, "207", new Object[]{new Byte(this.f2834ooOOo0oXI)});
                    if (!oo() && !this.f2832oO) {
                        if (!oOXoIIIo()) {
                            if (X00IoxXI()) {
                                throw new MqttException(32102);
                            }
                            throw oOoXoXO.oIX0oI(32100);
                        }
                        throw new MqttException(32110);
                    }
                    throw new MqttException(32111);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean oOXoIIIo() {
        boolean z;
        synchronized (this.f2836x0XOIxOo) {
            z = true;
            if (this.f2834ooOOo0oXI != 1) {
                z = false;
            }
        }
        return z;
    }

    public OoOoXO0.IIXOooo oOoXoXO() {
        return ooOOo0oXI(null);
    }

    public boolean oo() {
        boolean z;
        synchronized (this.f2836x0XOIxOo) {
            if (this.f2834ooOOo0oXI == 4) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public void oo0xXOI0I(IXIIo.IIXOooo iIXOooo, OoOoXO0.IIXOooo iIXOooo2) throws MqttException {
        oxO.oxoX oxox = f2818OxxIIOOXO;
        String str = f2821oI0IIXIo;
        oxox.OOXIXo(str, "internalSend", "200", new Object[]{iIXOooo.oO(), iIXOooo, iIXOooo2});
        if (iIXOooo2.getClient() == null) {
            iIXOooo2.f2606oIX0oI.xoXoI(o00());
            try {
                this.f2828Oxx0IOOO.oOXoIIIo(iIXOooo, iIXOooo2);
                return;
            } catch (MqttException e) {
                if (iIXOooo instanceof IXIIo.oO) {
                    this.f2828Oxx0IOOO.XOxIOxOx((IXIIo.oO) iIXOooo);
                }
                throw e;
            }
        }
        oxox.OOXIXo(str, "internalSend", "213", new Object[]{iIXOooo.oO(), iIXOooo, iIXOooo2});
        throw new MqttException(32201);
    }

    public OoOoXO0.IIXOooo ooOOo0oXI(OoOoXO0.I0Io i0Io) {
        try {
            return this.f2828Oxx0IOOO.oIX0oI(i0Io);
        } catch (MqttException e) {
            xI(e);
            return null;
        } catch (Exception e2) {
            xI(e2);
            return null;
        }
    }

    public final OoOoXO0.IIXOooo ooXIXxIX(OoOoXO0.IIXOooo iIXOooo, MqttException mqttException) {
        f2818OxxIIOOXO.xxIXOIIO(f2821oI0IIXIo, "handleOldTokens", "222");
        OoOoXO0.IIXOooo iIXOooo2 = null;
        if (iIXOooo != null) {
            try {
                if (this.f2826OOXIXo.XO(iIXOooo.f2606oIX0oI.XO()) == null) {
                    this.f2826OOXIXo.ooOOo0oXI(iIXOooo, iIXOooo.f2606oIX0oI.XO());
                }
            } catch (Exception unused) {
            }
        }
        Enumeration elements = this.f2828Oxx0IOOO.xI(mqttException).elements();
        while (elements.hasMoreElements()) {
            OoOoXO0.IIXOooo iIXOooo3 = (OoOoXO0.IIXOooo) elements.nextElement();
            if (!iIXOooo3.f2606oIX0oI.XO().equals(IXIIo.X0o0xo.f692oI0IIXIo) && !iIXOooo3.f2606oIX0oI.XO().equals("Con")) {
                this.f2830XO.oIX0oI(iIXOooo3);
            }
            iIXOooo2 = iIXOooo3;
        }
        return iIXOooo2;
    }

    public void oxXx0IX(OoOoXO0.ooOOo0oXI ooooo0oxi) {
        this.f2830XO.IXxxXO(ooooo0oxi);
    }

    public void oxxXoxO(int i) {
        this.f2825II0xO0 = i;
    }

    public void x0XOIxOo() throws MqttException {
        synchronized (this.f2836x0XOIxOo) {
            try {
                if (!oo()) {
                    if (!Xx000oIo()) {
                        f2818OxxIIOOXO.xxIXOIIO(f2821oI0IIXIo, "close", "224");
                        if (!oOXoIIIo()) {
                            if (!IoOoX()) {
                                if (X00IoxXI()) {
                                    this.f2832oO = true;
                                    return;
                                }
                            } else {
                                throw oOoXoXO.oIX0oI(32100);
                            }
                        } else {
                            throw new MqttException(32110);
                        }
                    }
                    this.f2834ooOOo0oXI = (byte) 4;
                    this.f2828Oxx0IOOO.oxoX();
                    this.f2828Oxx0IOOO = null;
                    this.f2830XO = null;
                    this.f2839xxIXOIIO = null;
                    this.f2829X0o0xo = null;
                    this.f2838xoIox = null;
                    this.f2835oxoX = null;
                    this.f2823I0Io = null;
                    this.f2824II0XooXoX = null;
                    this.f2826OOXIXo = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void x0o() {
        if (this.f2827Oo != null) {
            f2818OxxIIOOXO.xxIXOIIO(f2821oI0IIXIo, "notifyReconnect", "509");
            this.f2827Oo.X0o0xo(new Ox0XO.oIX0oI(this));
            new Thread(this.f2827Oo).start();
        }
    }

    public void x0xO0oo(IXIIo.I0Io i0Io, MqttException mqttException) throws MqttException {
        int O0xOxO2 = i0Io.O0xOxO();
        synchronized (this.f2836x0XOIxOo) {
            try {
                if (O0xOxO2 == 0) {
                    f2818OxxIIOOXO.xxIXOIIO(f2821oI0IIXIo, "connectComplete", "215");
                    this.f2834ooOOo0oXI = (byte) 0;
                } else {
                    f2818OxxIIOOXO.OOXIXo(f2821oI0IIXIo, "connectComplete", "204", new Object[]{new Integer(O0xOxO2)});
                    throw mqttException;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void xI(Exception exc) {
        MqttException mqttException;
        f2818OxxIIOOXO.II0xO0(f2821oI0IIXIo, "handleRunException", "804", null, exc);
        if (!(exc instanceof MqttException)) {
            mqttException = new MqttException(32109, exc);
        } else {
            mqttException = (MqttException) exc;
        }
        xXOx(null, mqttException);
    }

    public void xII(int i, int i2) throws MqttException {
        this.f2830XO.xoIox(i, i2);
    }

    public void xXOx(OoOoXO0.IIXOooo iIXOooo, MqttException mqttException) {
        boolean z;
        boolean z2;
        X0o0xo x0o0xo;
        OoOoXO0.oO oOVar;
        Oxx0xo oxx0xo;
        synchronized (this.f2836x0XOIxOo) {
            try {
                if (!this.f2833oOoXoXO && !this.f2832oO && !oo()) {
                    boolean z3 = true;
                    this.f2833oOoXoXO = true;
                    f2818OxxIIOOXO.xxIXOIIO(f2821oI0IIXIo, "shutdownConnection", "216");
                    if (!IoOoX() && !X00IoxXI()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.f2834ooOOo0oXI = (byte) 2;
                    if (iIXOooo != null && !iIXOooo.isComplete()) {
                        iIXOooo.f2606oIX0oI.o00(mqttException);
                    }
                    X0o0xo x0o0xo2 = this.f2830XO;
                    if (x0o0xo2 != null) {
                        x0o0xo2.oI0IIXIo();
                    }
                    try {
                        Oxx0xo[] oxx0xoArr = this.f2823I0Io;
                        if (oxx0xoArr != null && (oxx0xo = oxx0xoArr[this.f2825II0xO0]) != null) {
                            oxx0xo.stop();
                        }
                    } catch (Exception unused) {
                    }
                    XO xo2 = this.f2835oxoX;
                    if (xo2 != null) {
                        xo2.oxoX();
                    }
                    this.f2826OOXIXo.II0XooXoX(new MqttException(32102));
                    OoOoXO0.IIXOooo ooXIXxIX2 = ooXIXxIX(iIXOooo, mqttException);
                    try {
                        this.f2828Oxx0IOOO.xxIXOIIO(mqttException);
                        if (this.f2828Oxx0IOOO.oOoXoXO()) {
                            this.f2830XO.ooOOo0oXI();
                        }
                    } catch (Exception unused2) {
                    }
                    Oxx0IOOO oxx0IOOO = this.f2829X0o0xo;
                    if (oxx0IOOO != null) {
                        oxx0IOOO.I0Io();
                    }
                    OoOoXO0.OxxIIOOXO oxxIIOOXO = this.f2838xoIox;
                    if (oxxIIOOXO != null) {
                        oxxIIOOXO.stop();
                    }
                    try {
                        if (this.f2827Oo == null && (oOVar = this.f2839xxIXOIIO) != null) {
                            oOVar.close();
                        }
                    } catch (Exception unused3) {
                    }
                    synchronized (this.f2836x0XOIxOo) {
                        f2818OxxIIOOXO.xxIXOIIO(f2821oI0IIXIo, "shutdownConnection", "217");
                        this.f2834ooOOo0oXI = (byte) 3;
                        this.f2833oOoXoXO = false;
                    }
                    if (ooXIXxIX2 != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    X0o0xo x0o0xo3 = this.f2830XO;
                    if (x0o0xo3 == null) {
                        z3 = false;
                    }
                    if (z2 & z3) {
                        x0o0xo3.oIX0oI(ooXIXxIX2);
                    }
                    if (z && (x0o0xo = this.f2830XO) != null) {
                        x0o0xo.II0xO0(mqttException);
                    }
                    synchronized (this.f2836x0XOIxOo) {
                        if (this.f2832oO) {
                            try {
                                x0XOIxOo();
                            } catch (Exception unused4) {
                            }
                        }
                    }
                }
            } finally {
            }
        }
    }

    public XO xXxxox0I() {
        return this.f2835oxoX;
    }

    public void xo0x(boolean z) {
        this.f2837x0xO0oo = z;
    }

    public int xoXoI() {
        return this.f2827Oo.I0Io();
    }

    public Oxx0xo[] xxX() {
        return this.f2823I0Io;
    }
}
