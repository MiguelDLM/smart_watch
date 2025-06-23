package Ox0XO;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class II0XooXoX {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final oxO.oxoX f2807X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public static /* synthetic */ Class f2808XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f2809oxoX;

    /* renamed from: I0Io, reason: collision with root package name */
    public MqttException f2810I0Io = null;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f2811II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Hashtable f2812oIX0oI;

    static {
        Class<II0XooXoX> cls = f2808XO;
        if (cls == null) {
            cls = II0XooXoX.class;
            f2808XO = cls;
        }
        String name = cls.getName();
        f2809oxoX = name;
        f2807X0o0xo = oxO.X0o0xo.oIX0oI(oxO.X0o0xo.f33551oIX0oI, name);
    }

    public II0XooXoX(String str) {
        oxO.oxoX oxox = f2807X0o0xo;
        oxox.xoIox(str);
        this.f2812oIX0oI = new Hashtable();
        this.f2811II0xO0 = str;
        oxox.xxIXOIIO(f2809oxoX, "<Init>", "308");
    }

    public OoOoXO0.IXxxXO[] I0Io() {
        OoOoXO0.IXxxXO[] iXxxXOArr;
        synchronized (this.f2812oIX0oI) {
            try {
                f2807X0o0xo.xxIXOIIO(f2809oxoX, "getOutstandingDelTokens", "311");
                Vector vector = new Vector();
                Enumeration elements = this.f2812oIX0oI.elements();
                while (elements.hasMoreElements()) {
                    OoOoXO0.IIXOooo iIXOooo = (OoOoXO0.IIXOooo) elements.nextElement();
                    if (iIXOooo != null && (iIXOooo instanceof OoOoXO0.IXxxXO) && !iIXOooo.f2606oIX0oI.Oo()) {
                        vector.addElement(iIXOooo);
                    }
                }
                iXxxXOArr = (OoOoXO0.IXxxXO[]) vector.toArray(new OoOoXO0.IXxxXO[vector.size()]);
            } catch (Throwable th) {
                throw th;
            }
        }
        return iXxxXOArr;
    }

    public void II0XooXoX(MqttException mqttException) {
        synchronized (this.f2812oIX0oI) {
            f2807X0o0xo.OOXIXo(f2809oxoX, "quiesce", "309", new Object[]{mqttException});
            this.f2810I0Io = mqttException;
        }
    }

    public int II0xO0() {
        int size;
        synchronized (this.f2812oIX0oI) {
            size = this.f2812oIX0oI.size();
        }
        return size;
    }

    public OoOoXO0.IXxxXO OOXIXo(IXIIo.oO oOVar) {
        OoOoXO0.IXxxXO iXxxXO;
        synchronized (this.f2812oIX0oI) {
            try {
                String num = new Integer(oOVar.x0xO0oo()).toString();
                if (this.f2812oIX0oI.containsKey(num)) {
                    iXxxXO = (OoOoXO0.IXxxXO) this.f2812oIX0oI.get(num);
                    f2807X0o0xo.OOXIXo(f2809oxoX, "restoreToken", "302", new Object[]{num, oOVar, iXxxXO});
                } else {
                    iXxxXO = new OoOoXO0.IXxxXO(this.f2811II0xO0);
                    iXxxXO.f2606oIX0oI.OxI(num);
                    this.f2812oIX0oI.put(num, iXxxXO);
                    f2807X0o0xo.OOXIXo(f2809oxoX, "restoreToken", "303", new Object[]{num, oOVar, iXxxXO});
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return iXxxXO;
    }

    public void Oxx0IOOO() {
        synchronized (this.f2812oIX0oI) {
            f2807X0o0xo.xxIXOIIO(f2809oxoX, "open", "310");
            this.f2810I0Io = null;
        }
    }

    public OoOoXO0.IIXOooo X0o0xo(IXIIo.IIXOooo iIXOooo) {
        return (OoOoXO0.IIXOooo) this.f2812oIX0oI.get(iIXOooo.oO());
    }

    public OoOoXO0.IIXOooo XO(String str) {
        return (OoOoXO0.IIXOooo) this.f2812oIX0oI.get(str);
    }

    public void oIX0oI() {
        f2807X0o0xo.OOXIXo(f2809oxoX, "clear", "305", new Object[]{new Integer(this.f2812oIX0oI.size())});
        synchronized (this.f2812oIX0oI) {
            this.f2812oIX0oI.clear();
        }
    }

    public void oOoXoXO(OoOoXO0.IIXOooo iIXOooo, IXIIo.IIXOooo iIXOooo2) throws MqttException {
        synchronized (this.f2812oIX0oI) {
            try {
                MqttException mqttException = this.f2810I0Io;
                if (mqttException == null) {
                    String oO2 = iIXOooo2.oO();
                    f2807X0o0xo.OOXIXo(f2809oxoX, "saveToken", "300", new Object[]{oO2, iIXOooo2});
                    ooOOo0oXI(iIXOooo, oO2);
                } else {
                    throw mqttException;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void ooOOo0oXI(OoOoXO0.IIXOooo iIXOooo, String str) {
        synchronized (this.f2812oIX0oI) {
            f2807X0o0xo.OOXIXo(f2809oxoX, "saveToken", "307", new Object[]{str, iIXOooo.toString()});
            iIXOooo.f2606oIX0oI.OxI(str);
            this.f2812oIX0oI.put(str, iIXOooo);
        }
    }

    public Vector oxoX() {
        Vector vector;
        synchronized (this.f2812oIX0oI) {
            try {
                f2807X0o0xo.xxIXOIIO(f2809oxoX, "getOutstandingTokens", "312");
                vector = new Vector();
                Enumeration elements = this.f2812oIX0oI.elements();
                while (elements.hasMoreElements()) {
                    OoOoXO0.IIXOooo iIXOooo = (OoOoXO0.IIXOooo) elements.nextElement();
                    if (iIXOooo != null) {
                        vector.addElement(iIXOooo);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return vector;
    }

    public String toString() {
        String stringBuffer;
        String property = System.getProperty("line.separator", "\n");
        StringBuffer stringBuffer2 = new StringBuffer();
        synchronized (this.f2812oIX0oI) {
            try {
                Enumeration elements = this.f2812oIX0oI.elements();
                while (elements.hasMoreElements()) {
                    OoOoXO0.IIXOooo iIXOooo = (OoOoXO0.IIXOooo) elements.nextElement();
                    StringBuffer stringBuffer3 = new StringBuffer("{");
                    stringBuffer3.append(iIXOooo.f2606oIX0oI);
                    stringBuffer3.append(org.apache.commons.text.ooOOo0oXI.f33074oOoXoXO);
                    stringBuffer3.append(property);
                    stringBuffer2.append(stringBuffer3.toString());
                }
                stringBuffer = stringBuffer2.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringBuffer;
    }

    public OoOoXO0.IIXOooo xoIox(String str) {
        f2807X0o0xo.OOXIXo(f2809oxoX, "removeToken", "306", new Object[]{str});
        if (str != null) {
            return (OoOoXO0.IIXOooo) this.f2812oIX0oI.remove(str);
        }
        return null;
    }

    public OoOoXO0.IIXOooo xxIXOIIO(IXIIo.IIXOooo iIXOooo) {
        if (iIXOooo != null) {
            return xoIox(iIXOooo.oO());
        }
        return null;
    }
}
