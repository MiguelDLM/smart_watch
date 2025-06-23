package Ox0XO;

import com.baidu.mobads.sdk.internal.cm;
import com.realsil.sdk.dfu.DfuConstants;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class xoXoI {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static /* synthetic */ Class f2964IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public static final oxO.oxoX f2965Oo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final String f2966x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public String f2980xoIox;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public volatile boolean f2974oIX0oI = false;

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f2969II0xO0 = false;

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f2967I0Io = false;

    /* renamed from: oxoX, reason: collision with root package name */
    public Object f2978oxoX = new Object();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public Object f2972X0o0xo = new Object();

    /* renamed from: XO, reason: collision with root package name */
    public OoOoXO0.Oxx0xo f2973XO = null;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public IXIIo.IIXOooo f2971Oxx0IOOO = null;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public MqttException f2968II0XooXoX = null;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public String[] f2981xxIXOIIO = null;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public OoOoXO0.oxoX f2970OOXIXo = null;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public OoOoXO0.I0Io f2976oOoXoXO = null;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public Object f2977ooOOo0oXI = null;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public int f2979x0XOIxOo = 0;

    /* renamed from: oO, reason: collision with root package name */
    public boolean f2975oO = false;

    static {
        Class<xoXoI> cls = f2964IXxxXO;
        if (cls == null) {
            cls = xoXoI.class;
            f2964IXxxXO = cls;
        }
        String name = cls.getName();
        f2966x0xO0oo = name;
        f2965Oo = oxO.X0o0xo.oIX0oI(oxO.X0o0xo.f33551oIX0oI, name);
    }

    public xoXoI(String str) {
        f2965Oo.xoIox(str);
    }

    public OoOoXO0.oxoX I0Io() {
        return this.f2970OOXIXo;
    }

    public int II0XooXoX() {
        return this.f2979x0XOIxOo;
    }

    public OoOoXO0.I0Io II0xO0() {
        return this.f2976oOoXoXO;
    }

    public IXIIo.IIXOooo IIX0o() throws MqttException {
        return ooXIXxIX(-1L);
    }

    public void IIXOooo(OoOoXO0.I0Io i0Io) {
        this.f2976oOoXoXO = i0Io;
    }

    public void IXxxXO(IXIIo.IIXOooo iIXOooo, MqttException mqttException) {
        f2965Oo.OOXIXo(f2966x0xO0oo, "markComplete", cm.b, new Object[]{XO(), iIXOooo, mqttException});
        synchronized (this.f2978oxoX) {
            try {
                if (iIXOooo instanceof IXIIo.II0xO0) {
                    this.f2973XO = null;
                }
                this.f2969II0xO0 = true;
                this.f2971Oxx0IOOO = iIXOooo;
                this.f2968II0XooXoX = mqttException;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void O0xOxO(OoOoXO0.Oxx0xo oxx0xo) {
        this.f2973XO = oxx0xo;
    }

    public String[] OOXIXo() {
        return this.f2981xxIXOIIO;
    }

    public boolean Oo() {
        return this.f2975oO;
    }

    public void OxI(String str) {
        this.f2980xoIox = str;
    }

    public OoOoXO0.Oxx0xo Oxx0IOOO() {
        return this.f2973XO;
    }

    public void Oxx0xo() {
        f2965Oo.OOXIXo(f2966x0xO0oo, "notifyComplete", cm.b, new Object[]{XO(), this.f2971Oxx0IOOO, this.f2968II0XooXoX});
        synchronized (this.f2978oxoX) {
            try {
                if (this.f2968II0XooXoX == null && this.f2969II0xO0) {
                    this.f2974oIX0oI = true;
                    this.f2969II0xO0 = false;
                } else {
                    this.f2969II0xO0 = false;
                }
                this.f2978oxoX.notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f2972X0o0xo) {
            this.f2967I0Io = true;
            this.f2972X0o0xo.notifyAll();
        }
    }

    public void OxxIIOOXO() throws MqttException {
        if (!x0xO0oo()) {
            f2965Oo.OOXIXo(f2966x0xO0oo, "reset", "410", new Object[]{XO()});
            this.f2970OOXIXo = null;
            this.f2974oIX0oI = false;
            this.f2971Oxx0IOOO = null;
            this.f2967I0Io = false;
            this.f2968II0XooXoX = null;
            this.f2977ooOOo0oXI = null;
            return;
        }
        throw new MqttException(32201);
    }

    public void X0IIOO(int i) {
        this.f2979x0XOIxOo = i;
    }

    public int[] X0o0xo() {
        int[] iArr = new int[0];
        IXIIo.IIXOooo iIXOooo = this.f2971Oxx0IOOO;
        if (iIXOooo instanceof IXIIo.IXxxXO) {
            return ((IXIIo.IXxxXO) iIXOooo).O0xOxO();
        }
        return iArr;
    }

    public void XI0IXoo(boolean z) {
        this.f2975oO = z;
    }

    public void XIxXXX0x0(String[] strArr) {
        this.f2981xxIXOIIO = strArr;
    }

    public String XO() {
        return this.f2980xoIox;
    }

    public void XxX0x0xxx() throws MqttException {
        xXxxox0I(-1L);
    }

    public void o00(MqttException mqttException) {
        synchronized (this.f2978oxoX) {
            this.f2968II0XooXoX = mqttException;
        }
    }

    public void oI0IIXIo() {
        f2965Oo.OOXIXo(f2966x0xO0oo, "notifySent", "403", new Object[]{XO()});
        synchronized (this.f2978oxoX) {
            this.f2971Oxx0IOOO = null;
            this.f2974oIX0oI = false;
        }
        synchronized (this.f2972X0o0xo) {
            this.f2967I0Io = true;
            this.f2972X0o0xo.notifyAll();
        }
    }

    public boolean oIX0oI() throws MqttException {
        if (oxoX() == null) {
            return true;
        }
        throw oxoX();
    }

    public boolean oO() {
        return this.f2969II0xO0;
    }

    public Object oOoXoXO() {
        return this.f2977ooOOo0oXI;
    }

    public IXIIo.IIXOooo ooOOo0oXI() {
        return this.f2971Oxx0IOOO;
    }

    public IXIIo.IIXOooo ooXIXxIX(long j) throws MqttException {
        String str;
        synchronized (this.f2978oxoX) {
            try {
                oxO.oxoX oxox = f2965Oo;
                String str2 = f2966x0xO0oo;
                String XO2 = XO();
                Long l = new Long(j);
                Boolean bool = new Boolean(this.f2967I0Io);
                Boolean bool2 = new Boolean(this.f2974oIX0oI);
                MqttException mqttException = this.f2968II0XooXoX;
                if (mqttException == null) {
                    str = "false";
                } else {
                    str = "true";
                }
                oxox.II0xO0(str2, "waitForResponse", "400", new Object[]{XO2, l, bool, bool2, str, this.f2971Oxx0IOOO, this}, mqttException);
                while (!this.f2974oIX0oI) {
                    if (this.f2968II0XooXoX == null) {
                        try {
                            f2965Oo.OOXIXo(f2966x0xO0oo, "waitForResponse", "408", new Object[]{XO(), new Long(j)});
                            if (j <= 0) {
                                this.f2978oxoX.wait();
                            } else {
                                this.f2978oxoX.wait(j);
                            }
                        } catch (InterruptedException e) {
                            this.f2968II0XooXoX = new MqttException(e);
                        }
                    }
                    if (!this.f2974oIX0oI) {
                        MqttException mqttException2 = this.f2968II0XooXoX;
                        if (mqttException2 == null) {
                            if (j > 0) {
                                break;
                            }
                        } else {
                            f2965Oo.II0xO0(f2966x0xO0oo, "waitForResponse", "401", null, mqttException2);
                            throw this.f2968II0XooXoX;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        f2965Oo.OOXIXo(f2966x0xO0oo, "waitForResponse", "402", new Object[]{XO(), this.f2971Oxx0IOOO});
        return this.f2971Oxx0IOOO;
    }

    public MqttException oxoX() {
        return this.f2968II0XooXoX;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(XO());
        stringBuffer.append(" ,topics=");
        if (OOXIXo() != null) {
            for (int i = 0; i < OOXIXo().length; i++) {
                stringBuffer.append(OOXIXo()[i]);
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(" ,usercontext=");
        stringBuffer.append(oOoXoXO());
        stringBuffer.append(" ,isComplete=");
        stringBuffer.append(x0XOIxOo());
        stringBuffer.append(" ,isNotified=");
        stringBuffer.append(Oo());
        stringBuffer.append(" ,exception=");
        stringBuffer.append(oxoX());
        stringBuffer.append(" ,actioncallback=");
        stringBuffer.append(II0xO0());
        return stringBuffer.toString();
    }

    public boolean x0XOIxOo() {
        return this.f2974oIX0oI;
    }

    public boolean x0xO0oo() {
        if (I0Io() != null && !x0XOIxOo()) {
            return true;
        }
        return false;
    }

    public void xI() throws MqttException {
        boolean z;
        synchronized (this.f2972X0o0xo) {
            try {
                synchronized (this.f2978oxoX) {
                    MqttException mqttException = this.f2968II0XooXoX;
                    if (mqttException != null) {
                        throw mqttException;
                    }
                }
                while (true) {
                    z = this.f2967I0Io;
                    if (z) {
                        break;
                    }
                    try {
                        f2965Oo.OOXIXo(f2966x0xO0oo, "waitUntilSent", "409", new Object[]{XO()});
                        this.f2972X0o0xo.wait();
                    } catch (InterruptedException unused) {
                    }
                }
                if (!z) {
                    MqttException mqttException2 = this.f2968II0XooXoX;
                    if (mqttException2 == null) {
                        throw oOoXoXO.oIX0oI(6);
                    }
                    throw mqttException2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void xXxxox0I(long j) throws MqttException {
        oxO.oxoX oxox = f2965Oo;
        String str = f2966x0xO0oo;
        oxox.OOXIXo(str, "waitForCompletion", "407", new Object[]{XO(), new Long(j), this});
        if (ooXIXxIX(j) == null && !this.f2974oIX0oI) {
            oxox.OOXIXo(str, "waitForCompletion", "406", new Object[]{XO(), this});
            MqttException mqttException = new MqttException(DfuConstants.MAX_CONNECTION_LOCK_TIMEOUT);
            this.f2968II0XooXoX = mqttException;
            throw mqttException;
        }
        oIX0oI();
    }

    public boolean xoIox() {
        IXIIo.IIXOooo iIXOooo = this.f2971Oxx0IOOO;
        if (iIXOooo instanceof IXIIo.I0Io) {
            return ((IXIIo.I0Io) iIXOooo).X0IIOO();
        }
        return false;
    }

    public void xoXoI(OoOoXO0.oxoX oxox) {
        this.f2970OOXIXo = oxox;
    }

    public IXIIo.IIXOooo xxIXOIIO() {
        return this.f2971Oxx0IOOO;
    }

    public void xxX(Object obj) {
        this.f2977ooOOo0oXI = obj;
    }
}
