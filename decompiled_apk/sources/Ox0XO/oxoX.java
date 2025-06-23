package Ox0XO;

import com.huawei.openalliance.ad.constant.x;
import com.realsil.sdk.dfu.DfuConstants;
import java.io.EOFException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import org.eclipse.paho.android.service.MqttServiceConstants;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

/* loaded from: classes6.dex */
public class oxoX {

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final String f2926IIX0o = "sc-";

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final String f2927XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final String f2928XxX0x0xxx = "s-";

    /* renamed from: oo, reason: collision with root package name */
    public static /* synthetic */ Class f2929oo = null;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public static final int f2930oo0xXOI0I = 65535;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final String f2931ooXIXxIX = "r-";

    /* renamed from: xI, reason: collision with root package name */
    public static final int f2932xI = 1;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final String f2933xXxxox0I = "sb-";

    /* renamed from: xxX, reason: collision with root package name */
    public static final oxO.oxoX f2934xxX;

    /* renamed from: I0Io, reason: collision with root package name */
    public volatile Vector f2935I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public long f2936II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Hashtable f2937II0xO0;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public Hashtable f2940O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public Hashtable f2943OxI;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public X0o0xo f2944Oxx0IOOO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public Hashtable f2947X0IIOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public II0XooXoX f2948X0o0xo;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public OoOoXO0.OxxIIOOXO f2949XI0IXoo;

    /* renamed from: XO, reason: collision with root package name */
    public II0xO0 f2950XO;

    /* renamed from: o00, reason: collision with root package name */
    public Hashtable f2951o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public IXIIo.IIXOooo f2952oI0IIXIo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f2955oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f2956ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public volatile Vector f2957oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public OoOoXO0.oO f2960xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f2962xxIXOIIO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f2953oIX0oI = 0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f2941OOXIXo = 0;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public Object f2958x0XOIxOo = new Object();

    /* renamed from: oO, reason: collision with root package name */
    public Object f2954oO = new Object();

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public boolean f2959x0xO0oo = false;

    /* renamed from: Oo, reason: collision with root package name */
    public long f2942Oo = 0;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public long f2939IXxxXO = 0;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public long f2945Oxx0xo = 0;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public Object f2946OxxIIOOXO = new Object();

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f2938IIXOooo = 0;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f2961xoXoI = false;

    static {
        Class<oxoX> cls = f2929oo;
        if (cls == null) {
            cls = oxoX.class;
            f2929oo = cls;
        }
        String name = cls.getName();
        f2927XIxXXX0x0 = name;
        f2934xxX = oxO.X0o0xo.oIX0oI(oxO.X0o0xo.f33551oIX0oI, name);
    }

    public oxoX(OoOoXO0.oO oOVar, II0XooXoX iI0XooXoX, X0o0xo x0o0xo, II0xO0 iI0xO0, OoOoXO0.OxxIIOOXO oxxIIOOXO) throws MqttException {
        this.f2950XO = null;
        this.f2944Oxx0IOOO = null;
        this.f2955oOoXoXO = 0;
        this.f2956ooOOo0oXI = 0;
        this.f2951o00 = null;
        this.f2943OxI = null;
        this.f2940O0xOxO = null;
        this.f2947X0IIOO = null;
        this.f2949XI0IXoo = null;
        oxO.oxoX oxox = f2934xxX;
        oxox.xoIox(iI0xO0.o00().getClientId());
        oxox.x0xO0oo(f2927XIxXXX0x0, "<Init>", "");
        this.f2937II0xO0 = new Hashtable();
        this.f2957oxoX = new Vector();
        this.f2951o00 = new Hashtable();
        this.f2943OxI = new Hashtable();
        this.f2940O0xOxO = new Hashtable();
        this.f2947X0IIOO = new Hashtable();
        this.f2952oI0IIXIo = new IXIIo.xxIXOIIO();
        this.f2956ooOOo0oXI = 0;
        this.f2955oOoXoXO = 0;
        this.f2960xoIox = oOVar;
        this.f2944Oxx0IOOO = x0o0xo;
        this.f2948X0o0xo = iI0XooXoX;
        this.f2950XO = iI0xO0;
        this.f2949XI0IXoo = oxxIIOOXO;
        IoOoX();
    }

    public void I0Io() throws MqttException {
        f2934xxX.xxIXOIIO(f2927XIxXXX0x0, "clearState", ">");
        this.f2960xoIox.clear();
        this.f2937II0xO0.clear();
        this.f2935I0Io.clear();
        this.f2957oxoX.clear();
        this.f2951o00.clear();
        this.f2943OxI.clear();
        this.f2940O0xOxO.clear();
        this.f2947X0IIOO.clear();
        this.f2948X0o0xo.oIX0oI();
    }

    public void II0XooXoX(IXIIo.oO oOVar) throws MqttPersistenceException {
        f2934xxX.OOXIXo(f2927XIxXXX0x0, "deliveryComplete", "641", new Object[]{new Integer(oOVar.x0xO0oo())});
        this.f2960xoIox.remove(IXxxXO(oOVar));
        this.f2947X0IIOO.remove(new Integer(oOVar.x0xO0oo()));
    }

    public boolean II0xO0() {
        int II0xO02 = this.f2948X0o0xo.II0xO0();
        if (!this.f2959x0xO0oo || II0xO02 != 0 || this.f2957oxoX.size() != 0 || !this.f2944Oxx0IOOO.II0XooXoX()) {
            return false;
        }
        f2934xxX.OOXIXo(f2927XIxXXX0x0, "checkQuiesceLock", "626", new Object[]{new Boolean(this.f2959x0xO0oo), new Integer(this.f2955oOoXoXO), new Integer(this.f2957oxoX.size()), new Integer(this.f2956ooOOo0oXI), Boolean.valueOf(this.f2944Oxx0IOOO.II0XooXoX()), new Integer(II0xO02)});
        synchronized (this.f2954oO) {
            this.f2954oO.notifyAll();
        }
        return true;
    }

    public final Vector IIX0o(Vector vector) {
        int i;
        Vector vector2 = new Vector();
        if (vector.size() == 0) {
            return vector2;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 < vector.size()) {
            int x0xO0oo2 = ((IXIIo.IIXOooo) vector.elementAt(i2)).x0xO0oo();
            int i6 = x0xO0oo2 - i3;
            if (i6 > i4) {
                i5 = i2;
                i4 = i6;
            }
            i2++;
            i3 = x0xO0oo2;
        }
        if ((65535 - i3) + ((IXIIo.IIXOooo) vector.elementAt(0)).x0xO0oo() > i4) {
            i = 0;
        } else {
            i = i5;
        }
        for (int i7 = i; i7 < vector.size(); i7++) {
            vector2.addElement(vector.elementAt(i7));
        }
        for (int i8 = 0; i8 < i; i8++) {
            vector2.addElement(vector.elementAt(i8));
        }
        return vector2;
    }

    public final void IIXOooo(Vector vector, IXIIo.IIXOooo iIXOooo) {
        int x0xO0oo2 = iIXOooo.x0xO0oo();
        for (int i = 0; i < vector.size(); i++) {
            if (((IXIIo.IIXOooo) vector.elementAt(i)).x0xO0oo() > x0xO0oo2) {
                vector.insertElementAt(iIXOooo, i);
                return;
            }
        }
        vector.addElement(iIXOooo);
    }

    public void IO(long j) {
        this.f2936II0XooXoX = j * 1000;
    }

    public final String IXxxXO(IXIIo.IIXOooo iIXOooo) {
        StringBuffer stringBuffer = new StringBuffer(f2931ooXIXxIX);
        stringBuffer.append(iIXOooo.x0xO0oo());
        return stringBuffer.toString();
    }

    public void IoOoX() throws MqttException {
        Enumeration keys = this.f2960xoIox.keys();
        int i = this.f2953oIX0oI;
        Vector vector = new Vector();
        f2934xxX.xxIXOIIO(f2927XIxXXX0x0, "restoreState", "600");
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            IXIIo.IIXOooo oo2 = oo(str, this.f2960xoIox.get(str));
            if (oo2 != null) {
                if (str.startsWith(f2931ooXIXxIX)) {
                    f2934xxX.OOXIXo(f2927XIxXXX0x0, "restoreState", "604", new Object[]{str, oo2});
                    this.f2947X0IIOO.put(new Integer(oo2.x0xO0oo()), oo2);
                } else if (str.startsWith(f2928XxX0x0xxx)) {
                    IXIIo.oO oOVar = (IXIIo.oO) oo2;
                    i = Math.max(oOVar.x0xO0oo(), i);
                    if (this.f2960xoIox.I0Io(oI0IIXIo(oOVar))) {
                        IXIIo.x0XOIxOo x0xoixoo = (IXIIo.x0XOIxOo) oo(str, this.f2960xoIox.get(oI0IIXIo(oOVar)));
                        if (x0xoixoo != null) {
                            f2934xxX.OOXIXo(f2927XIxXXX0x0, "restoreState", "605", new Object[]{str, oo2});
                            this.f2951o00.put(new Integer(x0xoixoo.x0xO0oo()), x0xoixoo);
                        } else {
                            f2934xxX.OOXIXo(f2927XIxXXX0x0, "restoreState", "606", new Object[]{str, oo2});
                        }
                    } else {
                        oOVar.o00(true);
                        if (oOVar.X0IIOO().getQos() == 2) {
                            f2934xxX.OOXIXo(f2927XIxXXX0x0, "restoreState", "607", new Object[]{str, oo2});
                            this.f2951o00.put(new Integer(oOVar.x0xO0oo()), oOVar);
                        } else {
                            f2934xxX.OOXIXo(f2927XIxXXX0x0, "restoreState", "608", new Object[]{str, oo2});
                            this.f2943OxI.put(new Integer(oOVar.x0xO0oo()), oOVar);
                        }
                    }
                    this.f2948X0o0xo.OOXIXo(oOVar).f2606oIX0oI.xoXoI(this.f2950XO.o00());
                    this.f2937II0xO0.put(new Integer(oOVar.x0xO0oo()), new Integer(oOVar.x0xO0oo()));
                } else if (str.startsWith(f2933xXxxox0I)) {
                    IXIIo.oO oOVar2 = (IXIIo.oO) oo2;
                    i = Math.max(oOVar2.x0xO0oo(), i);
                    if (oOVar2.X0IIOO().getQos() == 2) {
                        f2934xxX.OOXIXo(f2927XIxXXX0x0, "restoreState", "607", new Object[]{str, oo2});
                        this.f2951o00.put(new Integer(oOVar2.x0xO0oo()), oOVar2);
                    } else if (oOVar2.X0IIOO().getQos() == 1) {
                        f2934xxX.OOXIXo(f2927XIxXXX0x0, "restoreState", "608", new Object[]{str, oo2});
                        this.f2943OxI.put(new Integer(oOVar2.x0xO0oo()), oOVar2);
                    } else {
                        f2934xxX.OOXIXo(f2927XIxXXX0x0, "restoreState", "511", new Object[]{str, oo2});
                        this.f2940O0xOxO.put(new Integer(oOVar2.x0xO0oo()), oOVar2);
                        this.f2960xoIox.remove(str);
                    }
                    this.f2948X0o0xo.OOXIXo(oOVar2).f2606oIX0oI.xoXoI(this.f2950XO.o00());
                    this.f2937II0xO0.put(new Integer(oOVar2.x0xO0oo()), new Integer(oOVar2.x0xO0oo()));
                } else if (str.startsWith(f2926IIX0o) && !this.f2960xoIox.I0Io(OxxIIOOXO((IXIIo.x0XOIxOo) oo2))) {
                    vector.addElement(str);
                }
            }
        }
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            String str2 = (String) elements.nextElement();
            f2934xxX.OOXIXo(f2927XIxXXX0x0, "restoreState", "609", new Object[]{str2});
            this.f2960xoIox.remove(str2);
        }
        this.f2953oIX0oI = i;
    }

    public void O0xOxO(int i) {
        if (i > 0) {
            this.f2939IXxxXO = System.currentTimeMillis();
        }
        f2934xxX.OOXIXo(f2927XIxXXX0x0, "notifyReceivedBytes", "630", new Object[]{new Integer(i)});
    }

    public int OOXIXo() {
        return this.f2955oOoXoXO;
    }

    public final String Oo(int i) {
        StringBuffer stringBuffer = new StringBuffer(f2931ooXIXxIX);
        stringBuffer.append(i);
        return stringBuffer.toString();
    }

    public void OxI(IXIIo.II0xO0 iI0xO0) throws MqttException {
        this.f2939IXxxXO = System.currentTimeMillis();
        oxO.oxoX oxox = f2934xxX;
        String str = f2927XIxXXX0x0;
        oxox.OOXIXo(str, "notifyReceivedAck", "627", new Object[]{new Integer(iI0xO0.x0xO0oo()), iI0xO0});
        OoOoXO0.IIXOooo X0o0xo2 = this.f2948X0o0xo.X0o0xo(iI0xO0);
        if (X0o0xo2 == null) {
            oxox.OOXIXo(str, "notifyReceivedAck", "662", new Object[]{new Integer(iI0xO0.x0xO0oo())});
        } else if (iI0xO0 instanceof IXIIo.ooOOo0oXI) {
            oOXoIIIo(new IXIIo.x0XOIxOo((IXIIo.ooOOo0oXI) iI0xO0), X0o0xo2);
        } else if (!(iI0xO0 instanceof IXIIo.OOXIXo) && !(iI0xO0 instanceof IXIIo.oOoXoXO)) {
            if (iI0xO0 instanceof IXIIo.xoIox) {
                synchronized (this.f2946OxxIIOOXO) {
                    try {
                        this.f2938IIXOooo = Math.max(0, this.f2938IIXOooo - 1);
                        XI0IXoo(iI0xO0, X0o0xo2, null);
                        if (this.f2938IIXOooo == 0) {
                            this.f2948X0o0xo.xxIXOIIO(iI0xO0);
                        }
                    } finally {
                    }
                }
                oxox.OOXIXo(str, "notifyReceivedAck", "636", new Object[]{new Integer(this.f2938IIXOooo)});
            } else if (iI0xO0 instanceof IXIIo.I0Io) {
                IXIIo.I0Io i0Io = (IXIIo.I0Io) iI0xO0;
                int O0xOxO2 = i0Io.O0xOxO();
                if (O0xOxO2 == 0) {
                    synchronized (this.f2958x0XOIxOo) {
                        try {
                            if (this.f2962xxIXOIIO) {
                                I0Io();
                                this.f2948X0o0xo.oOoXoXO(X0o0xo2, iI0xO0);
                            }
                            this.f2956ooOOo0oXI = 0;
                            this.f2955oOoXoXO = 0;
                            oo0xXOI0I();
                            X0o0xo();
                        } finally {
                        }
                    }
                    this.f2950XO.x0xO0oo(i0Io, null);
                    XI0IXoo(iI0xO0, X0o0xo2, null);
                    this.f2948X0o0xo.xxIXOIIO(iI0xO0);
                    synchronized (this.f2958x0XOIxOo) {
                        this.f2958x0XOIxOo.notifyAll();
                    }
                } else {
                    throw oOoXoXO.oIX0oI(O0xOxO2);
                }
            } else {
                XI0IXoo(iI0xO0, X0o0xo2, null);
                ooXIXxIX(iI0xO0.x0xO0oo());
                this.f2948X0o0xo.xxIXOIIO(iI0xO0);
            }
        } else {
            XI0IXoo(iI0xO0, X0o0xo2, null);
        }
        II0xO0();
    }

    public void Oxx0IOOO(int i) throws MqttPersistenceException {
        f2934xxX.OOXIXo(f2927XIxXXX0x0, "deliveryComplete", "641", new Object[]{new Integer(i)});
        this.f2960xoIox.remove(Oo(i));
        this.f2947X0IIOO.remove(new Integer(i));
    }

    public final String Oxx0xo(IXIIo.IIXOooo iIXOooo) {
        StringBuffer stringBuffer = new StringBuffer(f2933xXxxox0I);
        stringBuffer.append(iIXOooo.x0xO0oo());
        return stringBuffer.toString();
    }

    public final String OxxIIOOXO(IXIIo.IIXOooo iIXOooo) {
        StringBuffer stringBuffer = new StringBuffer(f2928XxX0x0xxx);
        stringBuffer.append(iIXOooo.x0xO0oo());
        return stringBuffer.toString();
    }

    public void X00IoxXI(long j) {
        this.f2936II0XooXoX = j;
    }

    public void X0IIOO(IXIIo.IIXOooo iIXOooo) throws MqttException {
        this.f2939IXxxXO = System.currentTimeMillis();
        f2934xxX.OOXIXo(f2927XIxXXX0x0, "notifyReceivedMsg", "651", new Object[]{new Integer(iIXOooo.x0xO0oo()), iIXOooo});
        if (!this.f2959x0xO0oo) {
            if (iIXOooo instanceof IXIIo.oO) {
                IXIIo.oO oOVar = (IXIIo.oO) iIXOooo;
                int qos = oOVar.X0IIOO().getQos();
                if (qos != 0 && qos != 1) {
                    if (qos == 2) {
                        this.f2960xoIox.II0xO0(IXxxXO(iIXOooo), oOVar);
                        this.f2947X0IIOO.put(new Integer(oOVar.x0xO0oo()), oOVar);
                        oOXoIIIo(new IXIIo.ooOOo0oXI(oOVar), null);
                        return;
                    }
                    return;
                }
                X0o0xo x0o0xo = this.f2944Oxx0IOOO;
                if (x0o0xo != null) {
                    x0o0xo.xxIXOIIO(oOVar);
                    return;
                }
                return;
            }
            if (iIXOooo instanceof IXIIo.x0XOIxOo) {
                IXIIo.oO oOVar2 = (IXIIo.oO) this.f2947X0IIOO.get(new Integer(iIXOooo.x0xO0oo()));
                if (oOVar2 != null) {
                    X0o0xo x0o0xo2 = this.f2944Oxx0IOOO;
                    if (x0o0xo2 != null) {
                        x0o0xo2.xxIXOIIO(oOVar2);
                        return;
                    }
                    return;
                }
                oOXoIIIo(new IXIIo.oOoXoXO(iIXOooo.x0xO0oo()), null);
            }
        }
    }

    public void X0o0xo() {
        f2934xxX.xxIXOIIO(f2927XIxXXX0x0, x.bl, "631");
        this.f2961xoXoI = true;
        this.f2949XI0IXoo.start();
    }

    public void XI0IXoo(IXIIo.IIXOooo iIXOooo, OoOoXO0.IIXOooo iIXOooo2, MqttException mqttException) {
        iIXOooo2.f2606oIX0oI.IXxxXO(iIXOooo, mqttException);
        iIXOooo2.f2606oIX0oI.Oxx0xo();
        if (iIXOooo != null && (iIXOooo instanceof IXIIo.II0xO0) && !(iIXOooo instanceof IXIIo.ooOOo0oXI)) {
            f2934xxX.OOXIXo(f2927XIxXXX0x0, "notifyResult", "648", new Object[]{iIXOooo2.f2606oIX0oI.XO(), iIXOooo, mqttException});
            this.f2944Oxx0IOOO.oIX0oI(iIXOooo2);
        }
        if (iIXOooo == null) {
            f2934xxX.OOXIXo(f2927XIxXXX0x0, "notifyResult", "649", new Object[]{iIXOooo2.f2606oIX0oI.XO(), mqttException});
            this.f2944Oxx0IOOO.oIX0oI(iIXOooo2);
        }
    }

    public void XIxXXX0x0(IXIIo.IIXOooo iIXOooo) {
        int i;
        this.f2942Oo = System.currentTimeMillis();
        oxO.oxoX oxox = f2934xxX;
        String str = f2927XIxXXX0x0;
        oxox.OOXIXo(str, "notifySent", "625", new Object[]{iIXOooo.oO()});
        OoOoXO0.IIXOooo X0o0xo2 = this.f2948X0o0xo.X0o0xo(iIXOooo);
        X0o0xo2.f2606oIX0oI.oI0IIXIo();
        if (iIXOooo instanceof IXIIo.xxIXOIIO) {
            synchronized (this.f2946OxxIIOOXO) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.f2946OxxIIOOXO) {
                    this.f2945Oxx0xo = currentTimeMillis;
                    i = this.f2938IIXOooo + 1;
                    this.f2938IIXOooo = i;
                }
                oxox.OOXIXo(str, "notifySent", "635", new Object[]{new Integer(i)});
            }
            return;
        }
        if ((iIXOooo instanceof IXIIo.oO) && ((IXIIo.oO) iIXOooo).X0IIOO().getQos() == 0) {
            X0o0xo2.f2606oIX0oI.IXxxXO(null, null);
            this.f2944Oxx0IOOO.oIX0oI(X0o0xo2);
            XO();
            ooXIXxIX(iIXOooo.x0xO0oo());
            this.f2948X0o0xo.xxIXOIIO(iIXOooo);
            II0xO0();
        }
    }

    public final void XO() {
        synchronized (this.f2958x0XOIxOo) {
            try {
                int i = this.f2955oOoXoXO - 1;
                this.f2955oOoXoXO = i;
                f2934xxX.OOXIXo(f2927XIxXXX0x0, "decrementInFlight", "646", new Object[]{new Integer(i)});
                if (!II0xO0()) {
                    this.f2958x0XOIxOo.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void XOxIOxOx(IXIIo.oO oOVar) throws MqttPersistenceException {
        synchronized (this.f2958x0XOIxOo) {
            try {
                f2934xxX.OOXIXo(f2927XIxXXX0x0, "undo", "618", new Object[]{new Integer(oOVar.x0xO0oo()), new Integer(oOVar.X0IIOO().getQos())});
                if (oOVar.X0IIOO().getQos() == 1) {
                    this.f2943OxI.remove(new Integer(oOVar.x0xO0oo()));
                } else {
                    this.f2951o00.remove(new Integer(oOVar.x0xO0oo()));
                }
                this.f2935I0Io.removeElement(oOVar);
                this.f2960xoIox.remove(OxxIIOOXO(oOVar));
                this.f2948X0o0xo.xxIXOIIO(oOVar);
                II0xO0();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void Xx000oIo(boolean z) {
        this.f2962xxIXOIIO = z;
    }

    public void XxX0x0xxx(IXIIo.IIXOooo iIXOooo) {
        String Oxx0xo2 = Oxx0xo(iIXOooo);
        try {
            iIXOooo.OxI(x0xO0oo());
            try {
                this.f2960xoIox.II0xO0(Oxx0xo2, (IXIIo.oO) iIXOooo);
            } catch (MqttPersistenceException unused) {
                f2934xxX.xxIXOIIO(f2927XIxXXX0x0, "persistBufferedMessage", "515");
                this.f2960xoIox.oIX0oI(this.f2950XO.o00().getClientId(), this.f2950XO.o00().getClientId());
                this.f2960xoIox.II0xO0(Oxx0xo2, (IXIIo.oO) iIXOooo);
            }
            f2934xxX.OOXIXo(f2927XIxXXX0x0, "persistBufferedMessage", "513", new Object[]{Oxx0xo2});
        } catch (MqttException unused2) {
            f2934xxX.oIX0oI(f2927XIxXXX0x0, "persistBufferedMessage", "513", new Object[]{Oxx0xo2});
        }
    }

    public void o00() {
        synchronized (this.f2958x0XOIxOo) {
            f2934xxX.xxIXOIIO(f2927XIxXXX0x0, "notifyQueueLock", "638");
            this.f2958x0XOIxOo.notifyAll();
        }
    }

    public final String oI0IIXIo(IXIIo.IIXOooo iIXOooo) {
        StringBuffer stringBuffer = new StringBuffer(f2926IIX0o);
        stringBuffer.append(iIXOooo.x0xO0oo());
        return stringBuffer.toString();
    }

    public OoOoXO0.IIXOooo oIX0oI(OoOoXO0.I0Io i0Io) throws MqttException {
        oxO.oxoX oxox;
        Object obj;
        OoOoXO0.IIXOooo iIXOooo;
        long max;
        oxO.oxoX oxox2 = f2934xxX;
        String str = f2927XIxXXX0x0;
        oxox2.OOXIXo(str, "checkForActivity", "616", new Object[0]);
        synchronized (this.f2954oO) {
            try {
                if (this.f2959x0xO0oo) {
                    return null;
                }
                x0XOIxOo();
                if (!this.f2961xoXoI || this.f2936II0XooXoX <= 0) {
                    return null;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Object obj2 = this.f2946OxxIIOOXO;
                synchronized (obj2) {
                    try {
                        try {
                            int i = this.f2938IIXOooo;
                            if (i > 0) {
                                obj = obj2;
                                long j = currentTimeMillis - this.f2939IXxxXO;
                                long j2 = this.f2936II0XooXoX;
                                if (j < 100 + j2) {
                                    oxox = oxox2;
                                } else {
                                    oxox2.O0xOxO(str, "checkForActivity", "619", new Object[]{new Long(j2), new Long(this.f2942Oo), new Long(this.f2939IXxxXO), new Long(currentTimeMillis), new Long(this.f2945Oxx0xo)});
                                    throw oOoXoXO.oIX0oI(DfuConstants.MAX_CONNECTION_LOCK_TIMEOUT);
                                }
                            } else {
                                oxox = oxox2;
                                obj = obj2;
                            }
                            if (i == 0) {
                                long j3 = currentTimeMillis - this.f2942Oo;
                                long j4 = this.f2936II0XooXoX;
                                if (j3 >= 2 * j4) {
                                    oxox.O0xOxO(str, "checkForActivity", "642", new Object[]{new Long(j4), new Long(this.f2942Oo), new Long(this.f2939IXxxXO), new Long(currentTimeMillis), new Long(this.f2945Oxx0xo)});
                                    throw oOoXoXO.oIX0oI(32002);
                                }
                            }
                            if ((i == 0 && currentTimeMillis - this.f2939IXxxXO >= this.f2936II0XooXoX - 100) || currentTimeMillis - this.f2942Oo >= this.f2936II0XooXoX - 100) {
                                oxox.OOXIXo(str, "checkForActivity", "620", new Object[]{new Long(this.f2936II0XooXoX), new Long(this.f2942Oo), new Long(this.f2939IXxxXO)});
                                iIXOooo = new OoOoXO0.IIXOooo(this.f2950XO.o00().getClientId());
                                if (i0Io != null) {
                                    iIXOooo.setActionCallback(i0Io);
                                }
                                this.f2948X0o0xo.oOoXoXO(iIXOooo, this.f2952oI0IIXIo);
                                this.f2957oxoX.insertElementAt(this.f2952oI0IIXIo, 0);
                                max = x0XOIxOo();
                                o00();
                            } else {
                                oxox.OOXIXo(str, "checkForActivity", "634", null);
                                iIXOooo = null;
                                max = Math.max(1L, x0XOIxOo() - (currentTimeMillis - this.f2942Oo));
                            }
                            oxox.OOXIXo(str, "checkForActivity", "624", new Object[]{new Long(max)});
                            this.f2949XI0IXoo.schedule(max);
                            return iIXOooo;
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                throw th;
            } finally {
            }
        }
    }

    public int oO() {
        return this.f2941OOXIXo;
    }

    public void oOXoIIIo(IXIIo.IIXOooo iIXOooo, OoOoXO0.IIXOooo iIXOooo2) throws MqttException {
        if (iIXOooo.OxxIIOOXO() && iIXOooo.x0xO0oo() == 0) {
            iIXOooo.OxI(x0xO0oo());
        }
        if (iIXOooo2 != null) {
            try {
                iIXOooo2.f2606oIX0oI.X0IIOO(iIXOooo.x0xO0oo());
            } catch (Exception unused) {
            }
        }
        if (iIXOooo instanceof IXIIo.oO) {
            synchronized (this.f2958x0XOIxOo) {
                try {
                    int i = this.f2955oOoXoXO;
                    if (i < this.f2941OOXIXo) {
                        OoOoXO0.Oxx0xo X0IIOO2 = ((IXIIo.oO) iIXOooo).X0IIOO();
                        f2934xxX.OOXIXo(f2927XIxXXX0x0, MqttServiceConstants.SEND_ACTION, "628", new Object[]{new Integer(iIXOooo.x0xO0oo()), new Integer(X0IIOO2.getQos()), iIXOooo});
                        int qos = X0IIOO2.getQos();
                        if (qos != 1) {
                            if (qos == 2) {
                                this.f2951o00.put(new Integer(iIXOooo.x0xO0oo()), iIXOooo);
                                this.f2960xoIox.II0xO0(OxxIIOOXO(iIXOooo), (IXIIo.oO) iIXOooo);
                            }
                        } else {
                            this.f2943OxI.put(new Integer(iIXOooo.x0xO0oo()), iIXOooo);
                            this.f2960xoIox.II0xO0(OxxIIOOXO(iIXOooo), (IXIIo.oO) iIXOooo);
                        }
                        this.f2948X0o0xo.oOoXoXO(iIXOooo2, iIXOooo);
                        this.f2935I0Io.addElement(iIXOooo);
                        this.f2958x0XOIxOo.notifyAll();
                    } else {
                        f2934xxX.OOXIXo(f2927XIxXXX0x0, MqttServiceConstants.SEND_ACTION, "613", new Object[]{new Integer(i)});
                        throw new MqttException(32202);
                    }
                } finally {
                }
            }
            return;
        }
        f2934xxX.OOXIXo(f2927XIxXXX0x0, MqttServiceConstants.SEND_ACTION, "615", new Object[]{new Integer(iIXOooo.x0xO0oo()), iIXOooo});
        if (iIXOooo instanceof IXIIo.oxoX) {
            synchronized (this.f2958x0XOIxOo) {
                this.f2948X0o0xo.oOoXoXO(iIXOooo2, iIXOooo);
                this.f2957oxoX.insertElementAt(iIXOooo, 0);
                this.f2958x0XOIxOo.notifyAll();
            }
            return;
        }
        if (iIXOooo instanceof IXIIo.xxIXOIIO) {
            this.f2952oI0IIXIo = iIXOooo;
        } else if (iIXOooo instanceof IXIIo.x0XOIxOo) {
            this.f2951o00.put(new Integer(iIXOooo.x0xO0oo()), iIXOooo);
            this.f2960xoIox.II0xO0(oI0IIXIo(iIXOooo), (IXIIo.x0XOIxOo) iIXOooo);
        } else if (iIXOooo instanceof IXIIo.oOoXoXO) {
            this.f2960xoIox.remove(IXxxXO(iIXOooo));
        }
        synchronized (this.f2958x0XOIxOo) {
            try {
                if (!(iIXOooo instanceof IXIIo.II0xO0)) {
                    this.f2948X0o0xo.oOoXoXO(iIXOooo2, iIXOooo);
                }
                this.f2957oxoX.addElement(iIXOooo);
                this.f2958x0XOIxOo.notifyAll();
            } finally {
            }
        }
    }

    public boolean oOoXoXO() {
        return this.f2962xxIXOIIO;
    }

    public final IXIIo.IIXOooo oo(String str, OoOoXO0.oI0IIXIo oi0iixio) throws MqttException {
        IXIIo.IIXOooo iIXOooo;
        try {
            iIXOooo = IXIIo.IIXOooo.Oxx0IOOO(oi0iixio);
        } catch (MqttException e) {
            f2934xxX.II0xO0(f2927XIxXXX0x0, "restoreMessage", "602", new Object[]{str}, e);
            if (e.getCause() instanceof EOFException) {
                if (str != null) {
                    this.f2960xoIox.remove(str);
                }
                iIXOooo = null;
            } else {
                throw e;
            }
        }
        f2934xxX.OOXIXo(f2927XIxXXX0x0, "restoreMessage", "601", new Object[]{str, iIXOooo});
        return iIXOooo;
    }

    public final void oo0xXOI0I() {
        this.f2935I0Io = new Vector(this.f2941OOXIXo);
        this.f2957oxoX = new Vector();
        Enumeration keys = this.f2951o00.keys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            IXIIo.IIXOooo iIXOooo = (IXIIo.IIXOooo) this.f2951o00.get(nextElement);
            if (iIXOooo instanceof IXIIo.oO) {
                f2934xxX.OOXIXo(f2927XIxXXX0x0, "restoreInflightMessages", "610", new Object[]{nextElement});
                iIXOooo.o00(true);
                IIXOooo(this.f2935I0Io, (IXIIo.oO) iIXOooo);
            } else if (iIXOooo instanceof IXIIo.x0XOIxOo) {
                f2934xxX.OOXIXo(f2927XIxXXX0x0, "restoreInflightMessages", "611", new Object[]{nextElement});
                IIXOooo(this.f2957oxoX, (IXIIo.x0XOIxOo) iIXOooo);
            }
        }
        Enumeration keys2 = this.f2943OxI.keys();
        while (keys2.hasMoreElements()) {
            Object nextElement2 = keys2.nextElement();
            IXIIo.oO oOVar = (IXIIo.oO) this.f2943OxI.get(nextElement2);
            oOVar.o00(true);
            f2934xxX.OOXIXo(f2927XIxXXX0x0, "restoreInflightMessages", "612", new Object[]{nextElement2});
            IIXOooo(this.f2935I0Io, oOVar);
        }
        Enumeration keys3 = this.f2940O0xOxO.keys();
        while (keys3.hasMoreElements()) {
            Object nextElement3 = keys3.nextElement();
            IXIIo.oO oOVar2 = (IXIIo.oO) this.f2940O0xOxO.get(nextElement3);
            f2934xxX.OOXIXo(f2927XIxXXX0x0, "restoreInflightMessages", "512", new Object[]{nextElement3});
            IIXOooo(this.f2935I0Io, oOVar2);
        }
        this.f2957oxoX = IIX0o(this.f2957oxoX);
        this.f2935I0Io = IIX0o(this.f2935I0Io);
    }

    public Properties ooOOo0oXI() {
        Properties properties = new Properties();
        properties.put("In use msgids", this.f2937II0xO0);
        properties.put("pendingMessages", this.f2935I0Io);
        properties.put("pendingFlows", this.f2957oxoX);
        properties.put("maxInflight", new Integer(this.f2941OOXIXo));
        properties.put("nextMsgID", new Integer(this.f2953oIX0oI));
        properties.put("actualInFlight", new Integer(this.f2955oOoXoXO));
        properties.put("inFlightPubRels", new Integer(this.f2956ooOOo0oXI));
        properties.put("quiescing", Boolean.valueOf(this.f2959x0xO0oo));
        properties.put("pingoutstanding", new Integer(this.f2938IIXOooo));
        properties.put("lastOutboundActivity", new Long(this.f2942Oo));
        properties.put("lastInboundActivity", new Long(this.f2939IXxxXO));
        properties.put("outboundQoS2", this.f2951o00);
        properties.put("outboundQoS1", this.f2943OxI);
        properties.put("outboundQoS0", this.f2940O0xOxO);
        properties.put("inboundQoS2", this.f2947X0IIOO);
        properties.put("tokens", this.f2948X0o0xo);
        return properties;
    }

    public final synchronized void ooXIXxIX(int i) {
        this.f2937II0xO0.remove(new Integer(i));
    }

    public void oxoX() {
        this.f2937II0xO0.clear();
        this.f2935I0Io.clear();
        this.f2957oxoX.clear();
        this.f2951o00.clear();
        this.f2943OxI.clear();
        this.f2940O0xOxO.clear();
        this.f2947X0IIOO.clear();
        this.f2948X0o0xo.oIX0oI();
        this.f2937II0xO0 = null;
        this.f2935I0Io = null;
        this.f2957oxoX = null;
        this.f2951o00 = null;
        this.f2943OxI = null;
        this.f2940O0xOxO = null;
        this.f2947X0IIOO = null;
        this.f2948X0o0xo = null;
        this.f2944Oxx0IOOO = null;
        this.f2950XO = null;
        this.f2960xoIox = null;
        this.f2952oI0IIXIo = null;
    }

    public long x0XOIxOo() {
        return this.f2936II0XooXoX;
    }

    public void x0o(IXIIo.IIXOooo iIXOooo) throws MqttPersistenceException {
        f2934xxX.OOXIXo(f2927XIxXXX0x0, "unPersistBufferedMessage", "513", new Object[]{iIXOooo.oO()});
        this.f2960xoIox.remove(Oxx0xo(iIXOooo));
    }

    public final synchronized int x0xO0oo() throws MqttException {
        int i;
        try {
            int i2 = this.f2953oIX0oI;
            int i3 = 0;
            do {
                int i4 = this.f2953oIX0oI + 1;
                this.f2953oIX0oI = i4;
                if (i4 > 65535) {
                    this.f2953oIX0oI = 1;
                }
                i = this.f2953oIX0oI;
                if (i == i2 && (i3 = i3 + 1) == 2) {
                    throw oOoXoXO.oIX0oI(32001);
                }
            } while (this.f2937II0xO0.containsKey(new Integer(i)));
            Integer num = new Integer(this.f2953oIX0oI);
            this.f2937II0xO0.put(num, num);
        } catch (Throwable th) {
            throw th;
        }
        return this.f2953oIX0oI;
    }

    public Vector xI(MqttException mqttException) {
        f2934xxX.OOXIXo(f2927XIxXXX0x0, "resolveOldTokens", "632", new Object[]{mqttException});
        if (mqttException == null) {
            mqttException = new MqttException(32102);
        }
        Vector oxoX2 = this.f2948X0o0xo.oxoX();
        Enumeration elements = oxoX2.elements();
        while (elements.hasMoreElements()) {
            OoOoXO0.IIXOooo iIXOooo = (OoOoXO0.IIXOooo) elements.nextElement();
            synchronized (iIXOooo) {
                try {
                    if (!iIXOooo.isComplete() && !iIXOooo.f2606oIX0oI.oO() && iIXOooo.getException() == null) {
                        iIXOooo.f2606oIX0oI.o00(mqttException);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!(iIXOooo instanceof OoOoXO0.IXxxXO)) {
                this.f2948X0o0xo.xoIox(iIXOooo.f2606oIX0oI.XO());
            }
        }
        return oxoX2;
    }

    public void xII(int i) {
        this.f2941OOXIXo = i;
        this.f2935I0Io = new Vector(this.f2941OOXIXo);
    }

    public void xXxxox0I(long j) {
        int II0xO02;
        if (j > 0) {
            oxO.oxoX oxox = f2934xxX;
            String str = f2927XIxXXX0x0;
            oxox.OOXIXo(str, "quiesce", "637", new Object[]{new Long(j)});
            synchronized (this.f2958x0XOIxOo) {
                this.f2959x0xO0oo = true;
            }
            this.f2944Oxx0IOOO.OOXIXo();
            o00();
            synchronized (this.f2954oO) {
                try {
                    try {
                        II0xO02 = this.f2948X0o0xo.II0xO0();
                    } catch (Throwable th) {
                        throw th;
                    }
                } catch (InterruptedException unused) {
                }
                if (II0xO02 <= 0) {
                    if (this.f2957oxoX.size() <= 0) {
                        if (!this.f2944Oxx0IOOO.II0XooXoX()) {
                        }
                    }
                }
                oxox.OOXIXo(str, "quiesce", "639", new Object[]{new Integer(this.f2955oOoXoXO), new Integer(this.f2957oxoX.size()), new Integer(this.f2956ooOOo0oXI), new Integer(II0xO02)});
                this.f2954oO.wait(j);
            }
            synchronized (this.f2958x0XOIxOo) {
                this.f2935I0Io.clear();
                this.f2957oxoX.clear();
                this.f2959x0xO0oo = false;
                this.f2955oOoXoXO = 0;
            }
            f2934xxX.xxIXOIIO(f2927XIxXXX0x0, "quiesce", "640");
        }
    }

    public IXIIo.IIXOooo xoIox() throws MqttException {
        synchronized (this.f2958x0XOIxOo) {
            IXIIo.IIXOooo iIXOooo = null;
            while (iIXOooo == null) {
                try {
                    if ((this.f2935I0Io.isEmpty() && this.f2957oxoX.isEmpty()) || (this.f2957oxoX.isEmpty() && this.f2955oOoXoXO >= this.f2941OOXIXo)) {
                        try {
                            oxO.oxoX oxox = f2934xxX;
                            String str = f2927XIxXXX0x0;
                            oxox.xxIXOIIO(str, "get", "644");
                            this.f2958x0XOIxOo.wait();
                            oxox.xxIXOIIO(str, "get", "647");
                        } catch (InterruptedException unused) {
                        }
                    }
                    if (!this.f2961xoXoI && (this.f2957oxoX.isEmpty() || !(((IXIIo.IIXOooo) this.f2957oxoX.elementAt(0)) instanceof IXIIo.oxoX))) {
                        f2934xxX.xxIXOIIO(f2927XIxXXX0x0, "get", "621");
                        return null;
                    }
                    if (!this.f2957oxoX.isEmpty()) {
                        iIXOooo = (IXIIo.IIXOooo) this.f2957oxoX.remove(0);
                        if (iIXOooo instanceof IXIIo.x0XOIxOo) {
                            int i = this.f2956ooOOo0oXI + 1;
                            this.f2956ooOOo0oXI = i;
                            f2934xxX.OOXIXo(f2927XIxXXX0x0, "get", "617", new Object[]{new Integer(i)});
                        }
                        II0xO0();
                    } else if (!this.f2935I0Io.isEmpty()) {
                        if (this.f2955oOoXoXO < this.f2941OOXIXo) {
                            iIXOooo = (IXIIo.IIXOooo) this.f2935I0Io.elementAt(0);
                            this.f2935I0Io.removeElementAt(0);
                            int i2 = this.f2955oOoXoXO + 1;
                            this.f2955oOoXoXO = i2;
                            f2934xxX.OOXIXo(f2927XIxXXX0x0, "get", "623", new Object[]{new Integer(i2)});
                        } else {
                            f2934xxX.xxIXOIIO(f2927XIxXXX0x0, "get", "622");
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return iIXOooo;
        }
    }

    public void xoXoI(OoOoXO0.IIXOooo iIXOooo) throws MqttException {
        IXIIo.IIXOooo ooOOo0oXI2 = iIXOooo.f2606oIX0oI.ooOOo0oXI();
        if (ooOOo0oXI2 != null && (ooOOo0oXI2 instanceof IXIIo.II0xO0)) {
            oxO.oxoX oxox = f2934xxX;
            String str = f2927XIxXXX0x0;
            oxox.OOXIXo(str, "notifyComplete", "629", new Object[]{new Integer(ooOOo0oXI2.x0xO0oo()), iIXOooo, ooOOo0oXI2});
            IXIIo.II0xO0 iI0xO0 = (IXIIo.II0xO0) ooOOo0oXI2;
            if (iI0xO0 instanceof IXIIo.OOXIXo) {
                this.f2960xoIox.remove(OxxIIOOXO(ooOOo0oXI2));
                this.f2943OxI.remove(new Integer(iI0xO0.x0xO0oo()));
                XO();
                ooXIXxIX(ooOOo0oXI2.x0xO0oo());
                this.f2948X0o0xo.xxIXOIIO(ooOOo0oXI2);
                oxox.OOXIXo(str, "notifyComplete", "650", new Object[]{new Integer(iI0xO0.x0xO0oo())});
            } else if (iI0xO0 instanceof IXIIo.oOoXoXO) {
                this.f2960xoIox.remove(OxxIIOOXO(ooOOo0oXI2));
                this.f2960xoIox.remove(oI0IIXIo(ooOOo0oXI2));
                this.f2951o00.remove(new Integer(iI0xO0.x0xO0oo()));
                this.f2956ooOOo0oXI--;
                XO();
                ooXIXxIX(ooOOo0oXI2.x0xO0oo());
                this.f2948X0o0xo.xxIXOIIO(ooOOo0oXI2);
                oxox.OOXIXo(str, "notifyComplete", "645", new Object[]{new Integer(iI0xO0.x0xO0oo()), new Integer(this.f2956ooOOo0oXI)});
            }
            II0xO0();
        }
    }

    public void xxIXOIIO(MqttException mqttException) {
        f2934xxX.OOXIXo(f2927XIxXXX0x0, "disconnected", "633", new Object[]{mqttException});
        this.f2961xoXoI = false;
        try {
            if (this.f2962xxIXOIIO) {
                I0Io();
            }
            this.f2935I0Io.clear();
            this.f2957oxoX.clear();
            synchronized (this.f2946OxxIIOOXO) {
                this.f2938IIXOooo = 0;
            }
        } catch (MqttException unused) {
        }
    }

    public void xxX(int i) {
        if (i > 0) {
            this.f2942Oo = System.currentTimeMillis();
        }
        f2934xxX.OOXIXo(f2927XIxXXX0x0, "notifySentBytes", "643", new Object[]{new Integer(i)});
    }
}
