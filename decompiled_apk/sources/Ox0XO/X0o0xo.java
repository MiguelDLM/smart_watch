package Ox0XO;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.eclipse.paho.android.service.MqttServiceConstants;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class X0o0xo implements Runnable {

    /* renamed from: IIX0o, reason: collision with root package name */
    public static /* synthetic */ Class f2888IIX0o = null;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final oxO.oxoX f2889XxX0x0xxx;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final int f2890xXxxox0I = 10;

    /* renamed from: xxX, reason: collision with root package name */
    public static final String f2891xxX;

    /* renamed from: Oo, reason: collision with root package name */
    public OoOoXO0.ooOOo0oXI f2895Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public Thread f2896OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public II0xO0 f2897Oxx0xo;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public oxoX f2900XI0IXoo;

    /* renamed from: XO, reason: collision with root package name */
    public OoOoXO0.oOoXoXO f2902XO;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f2892IIXOooo = false;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f2905xoXoI = false;

    /* renamed from: o00, reason: collision with root package name */
    public Object f2903o00 = new Object();

    /* renamed from: O0xOxO, reason: collision with root package name */
    public Object f2894O0xOxO = new Object();

    /* renamed from: X0IIOO, reason: collision with root package name */
    public Object f2899X0IIOO = new Object();

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public boolean f2901XIxXXX0x0 = false;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public Vector f2904oI0IIXIo = new Vector(10);

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public Vector f2898OxxIIOOXO = new Vector(10);

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Hashtable f2893IXxxXO = new Hashtable();

    static {
        Class<X0o0xo> cls = f2888IIX0o;
        if (cls == null) {
            cls = X0o0xo.class;
            f2888IIX0o = cls;
        }
        String name = cls.getName();
        f2891xxX = name;
        f2889XxX0x0xxx = oxO.X0o0xo.oIX0oI(oxO.X0o0xo.f33551oIX0oI, name);
    }

    public X0o0xo(II0xO0 iI0xO0) {
        this.f2897Oxx0xo = iI0xO0;
        f2889XxX0x0xxx.xoIox(iI0xO0.o00().getClientId());
    }

    public boolean I0Io(String str, int i, OoOoXO0.Oxx0xo oxx0xo) throws Exception {
        Enumeration keys = this.f2893IXxxXO.keys();
        boolean z = false;
        while (keys.hasMoreElements()) {
            String str2 = (String) keys.nextElement();
            if (OoOoXO0.xoXoI.I0Io(str2, str)) {
                oxx0xo.setId(i);
                ((OoOoXO0.Oxx0IOOO) this.f2893IXxxXO.get(str2)).messageArrived(str, oxx0xo);
                z = true;
            }
        }
        if (this.f2902XO != null && !z) {
            oxx0xo.setId(i);
            this.f2902XO.messageArrived(str, oxx0xo);
            return true;
        }
        return z;
    }

    public boolean II0XooXoX() {
        if (this.f2905xoXoI && this.f2898OxxIIOOXO.size() == 0 && this.f2904oI0IIXIo.size() == 0) {
            return true;
        }
        return false;
    }

    public void II0xO0(MqttException mqttException) {
        try {
            if (this.f2902XO != null && mqttException != null) {
                f2889XxX0x0xxx.OOXIXo(f2891xxX, "connectionLost", "708", new Object[]{mqttException});
                this.f2902XO.connectionLost(mqttException);
            }
            OoOoXO0.ooOOo0oXI ooooo0oxi = this.f2895Oo;
            if (ooooo0oxi != null && mqttException != null) {
                ooooo0oxi.connectionLost(mqttException);
            }
        } catch (Throwable th) {
            f2889XxX0x0xxx.OOXIXo(f2891xxX, "connectionLost", "720", new Object[]{th});
        }
    }

    public void IXxxXO(OoOoXO0.ooOOo0oXI ooooo0oxi) {
        this.f2895Oo = ooooo0oxi;
    }

    public void OOXIXo() {
        this.f2905xoXoI = true;
        synchronized (this.f2899X0IIOO) {
            f2889XxX0x0xxx.xxIXOIIO(f2891xxX, "quiesce", "711");
            this.f2899X0IIOO.notifyAll();
        }
    }

    public void Oo(String str, OoOoXO0.Oxx0IOOO oxx0IOOO) {
        this.f2893IXxxXO.put(str, oxx0IOOO);
    }

    public final void Oxx0IOOO(IXIIo.oO oOVar) throws MqttException, Exception {
        String XI0IXoo2 = oOVar.XI0IXoo();
        f2889XxX0x0xxx.OOXIXo(f2891xxX, "handleMessage", "713", new Object[]{new Integer(oOVar.x0xO0oo()), XI0IXoo2});
        I0Io(XI0IXoo2, oOVar.x0xO0oo(), oOVar.X0IIOO());
        if (!this.f2901XIxXXX0x0) {
            if (oOVar.X0IIOO().getQos() == 1) {
                this.f2897Oxx0xo.oo0xXOI0I(new IXIIo.OOXIXo(oOVar), new OoOoXO0.IIXOooo(this.f2897Oxx0xo.o00().getClientId()));
            } else if (oOVar.X0IIOO().getQos() == 2) {
                this.f2897Oxx0xo.Oxx0xo(oOVar);
                IXIIo.oOoXoXO oooxoxo = new IXIIo.oOoXoXO(oOVar);
                II0xO0 iI0xO0 = this.f2897Oxx0xo;
                iI0xO0.oo0xXOI0I(oooxoxo, new OoOoXO0.IIXOooo(iI0xO0.o00().getClientId()));
            }
        }
    }

    public void Oxx0xo(String str) {
        synchronized (this.f2903o00) {
            try {
                if (!this.f2892IIXOooo) {
                    this.f2904oI0IIXIo.clear();
                    this.f2898OxxIIOOXO.clear();
                    this.f2892IIXOooo = true;
                    this.f2905xoXoI = false;
                    Thread thread = new Thread(this, str);
                    this.f2896OxI = thread;
                    thread.start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Thread X0o0xo() {
        return this.f2896OxI;
    }

    public final void XO(OoOoXO0.IIXOooo iIXOooo) throws MqttException {
        synchronized (iIXOooo) {
            try {
                f2889XxX0x0xxx.OOXIXo(f2891xxX, "handleActionComplete", "705", new Object[]{iIXOooo.f2606oIX0oI.XO()});
                if (iIXOooo.isComplete()) {
                    this.f2900XI0IXoo.xoXoI(iIXOooo);
                }
                iIXOooo.f2606oIX0oI.Oxx0xo();
                if (!iIXOooo.f2606oIX0oI.Oo()) {
                    if (this.f2902XO != null && (iIXOooo instanceof OoOoXO0.IXxxXO) && iIXOooo.isComplete()) {
                        this.f2902XO.deliveryComplete((OoOoXO0.IXxxXO) iIXOooo);
                    }
                    oxoX(iIXOooo);
                }
                if (iIXOooo.isComplete() && ((iIXOooo instanceof OoOoXO0.IXxxXO) || (iIXOooo.getActionCallback() instanceof OoOoXO0.I0Io))) {
                    iIXOooo.f2606oIX0oI.XI0IXoo(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void oI0IIXIo() {
        synchronized (this.f2903o00) {
            if (this.f2892IIXOooo) {
                oxO.oxoX oxox = f2889XxX0x0xxx;
                String str = f2891xxX;
                oxox.xxIXOIIO(str, "stop", "700");
                this.f2892IIXOooo = false;
                if (!Thread.currentThread().equals(this.f2896OxI)) {
                    try {
                        synchronized (this.f2894O0xOxO) {
                            oxox.xxIXOIIO(str, "stop", "701");
                            this.f2894O0xOxO.notifyAll();
                        }
                        this.f2896OxI.join();
                    } catch (InterruptedException unused) {
                    }
                }
            }
            this.f2896OxI = null;
            f2889XxX0x0xxx.xxIXOIIO(f2891xxX, "stop", "703");
        }
    }

    public void oIX0oI(OoOoXO0.IIXOooo iIXOooo) {
        if (this.f2892IIXOooo) {
            this.f2898OxxIIOOXO.addElement(iIXOooo);
            synchronized (this.f2894O0xOxO) {
                f2889XxX0x0xxx.OOXIXo(f2891xxX, "asyncOperationComplete", "715", new Object[]{iIXOooo.f2606oIX0oI.XO()});
                this.f2894O0xOxO.notifyAll();
            }
            return;
        }
        try {
            XO(iIXOooo);
        } catch (Throwable th) {
            f2889XxX0x0xxx.II0xO0(f2891xxX, "asyncOperationComplete", "719", null, th);
            this.f2897Oxx0xo.xXOx(null, new MqttException(th));
        }
    }

    public void oO(oxoX oxox) {
        this.f2900XI0IXoo = oxox;
    }

    public void oOoXoXO(String str) {
        this.f2893IXxxXO.remove(str);
    }

    public void ooOOo0oXI() {
        this.f2893IXxxXO.clear();
    }

    public void oxoX(OoOoXO0.IIXOooo iIXOooo) {
        OoOoXO0.I0Io actionCallback;
        if (iIXOooo != null && (actionCallback = iIXOooo.getActionCallback()) != null) {
            if (iIXOooo.getException() == null) {
                f2889XxX0x0xxx.OOXIXo(f2891xxX, "fireActionEvent", "716", new Object[]{iIXOooo.f2606oIX0oI.XO()});
                actionCallback.onSuccess(iIXOooo);
            } else {
                f2889XxX0x0xxx.OOXIXo(f2891xxX, "fireActionEvent", "716", new Object[]{iIXOooo.f2606oIX0oI.XO()});
                actionCallback.onFailure(iIXOooo, iIXOooo.getException());
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        OoOoXO0.IIXOooo iIXOooo;
        IXIIo.oO oOVar;
        while (this.f2892IIXOooo) {
            try {
                try {
                    synchronized (this.f2894O0xOxO) {
                        try {
                            if (this.f2892IIXOooo && this.f2904oI0IIXIo.isEmpty() && this.f2898OxxIIOOXO.isEmpty()) {
                                f2889XxX0x0xxx.xxIXOIIO(f2891xxX, "run", "704");
                                this.f2894O0xOxO.wait();
                            }
                        } catch (Throwable th) {
                            throw th;
                            break;
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        f2889XxX0x0xxx.II0xO0(f2891xxX, "run", "714", null, th2);
                        this.f2892IIXOooo = false;
                        this.f2897Oxx0xo.xXOx(null, new MqttException(th2));
                    } catch (Throwable th3) {
                        synchronized (this.f2899X0IIOO) {
                            f2889XxX0x0xxx.xxIXOIIO(f2891xxX, "run", "706");
                            this.f2899X0IIOO.notifyAll();
                            throw th3;
                        }
                    }
                }
            } catch (InterruptedException unused) {
            }
            if (this.f2892IIXOooo) {
                synchronized (this.f2898OxxIIOOXO) {
                    try {
                        if (!this.f2898OxxIIOOXO.isEmpty()) {
                            iIXOooo = (OoOoXO0.IIXOooo) this.f2898OxxIIOOXO.elementAt(0);
                            this.f2898OxxIIOOXO.removeElementAt(0);
                        } else {
                            iIXOooo = null;
                        }
                    } finally {
                    }
                }
                if (iIXOooo != null) {
                    XO(iIXOooo);
                }
                synchronized (this.f2904oI0IIXIo) {
                    try {
                        if (!this.f2904oI0IIXIo.isEmpty()) {
                            oOVar = (IXIIo.oO) this.f2904oI0IIXIo.elementAt(0);
                            this.f2904oI0IIXIo.removeElementAt(0);
                        } else {
                            oOVar = null;
                        }
                    } finally {
                    }
                }
                if (oOVar != null) {
                    Oxx0IOOO(oOVar);
                }
            }
            if (this.f2905xoXoI) {
                this.f2900XI0IXoo.II0xO0();
            }
            synchronized (this.f2899X0IIOO) {
                f2889XxX0x0xxx.xxIXOIIO(f2891xxX, "run", "706");
                this.f2899X0IIOO.notifyAll();
            }
        }
    }

    public void x0XOIxOo(OoOoXO0.oOoXoXO oooxoxo) {
        this.f2902XO = oooxoxo;
    }

    public void x0xO0oo(boolean z) {
        this.f2901XIxXXX0x0 = z;
    }

    public void xoIox(int i, int i2) throws MqttException {
        if (i2 == 1) {
            this.f2897Oxx0xo.oo0xXOI0I(new IXIIo.OOXIXo(i), new OoOoXO0.IIXOooo(this.f2897Oxx0xo.o00().getClientId()));
        } else if (i2 == 2) {
            this.f2897Oxx0xo.IXxxXO(i);
            IXIIo.oOoXoXO oooxoxo = new IXIIo.oOoXoXO(i);
            II0xO0 iI0xO0 = this.f2897Oxx0xo;
            iI0xO0.oo0xXOI0I(oooxoxo, new OoOoXO0.IIXOooo(iI0xO0.o00().getClientId()));
        }
    }

    public void xxIXOIIO(IXIIo.oO oOVar) {
        if (this.f2902XO != null || this.f2893IXxxXO.size() > 0) {
            synchronized (this.f2899X0IIOO) {
                while (this.f2892IIXOooo && !this.f2905xoXoI && this.f2904oI0IIXIo.size() >= 10) {
                    try {
                        f2889XxX0x0xxx.xxIXOIIO(f2891xxX, MqttServiceConstants.MESSAGE_ARRIVED_ACTION, "709");
                        this.f2899X0IIOO.wait(200L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            if (!this.f2905xoXoI) {
                this.f2904oI0IIXIo.addElement(oOVar);
                synchronized (this.f2894O0xOxO) {
                    f2889XxX0x0xxx.xxIXOIIO(f2891xxX, MqttServiceConstants.MESSAGE_ARRIVED_ACTION, "710");
                    this.f2894O0xOxO.notifyAll();
                }
            }
        }
    }
}
