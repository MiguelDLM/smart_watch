package Ox0XO;

import java.util.ArrayList;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class OOXIXo implements Runnable {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Object f2867IXxxXO = new Object();

    /* renamed from: Oo, reason: collision with root package name */
    public ArrayList f2868Oo = new ArrayList();

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public x0XOIxOo f2869Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public OoOoXO0.II0xO0 f2870XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final String f2866oI0IIXIo = "DisconnectedMessageBuffer";

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final oxO.oxoX f2865OxxIIOOXO = oxO.X0o0xo.oIX0oI(oxO.X0o0xo.f33551oIX0oI, f2866oI0IIXIo);

    public OOXIXo(OoOoXO0.II0xO0 iI0xO0) {
        this.f2870XO = iI0xO0;
    }

    public int I0Io() {
        int size;
        synchronized (this.f2867IXxxXO) {
            size = this.f2868Oo.size();
        }
        return size;
    }

    public OoOoXO0.oIX0oI II0xO0(int i) {
        OoOoXO0.oIX0oI oix0oi;
        synchronized (this.f2867IXxxXO) {
            oix0oi = (OoOoXO0.oIX0oI) this.f2868Oo.get(i);
        }
        return oix0oi;
    }

    public void X0o0xo(x0XOIxOo x0xoixoo) {
        this.f2869Oxx0xo = x0xoixoo;
    }

    public void oIX0oI(int i) {
        synchronized (this.f2867IXxxXO) {
            this.f2868Oo.remove(i);
        }
    }

    public void oxoX(IXIIo.IIXOooo iIXOooo, OoOoXO0.IIXOooo iIXOooo2) throws MqttException {
        OoOoXO0.oIX0oI oix0oi = new OoOoXO0.oIX0oI(iIXOooo, iIXOooo2);
        synchronized (this.f2867IXxxXO) {
            try {
                if (this.f2868Oo.size() < this.f2870XO.oIX0oI()) {
                    this.f2868Oo.add(oix0oi);
                } else if (this.f2870XO.I0Io()) {
                    this.f2868Oo.remove(0);
                    this.f2868Oo.add(oix0oi);
                } else {
                    throw new MqttException(32203);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        f2865OxxIIOOXO.xxIXOIIO(f2866oI0IIXIo, "run", "516");
        while (I0Io() > 0) {
            try {
                this.f2869Oxx0xo.oIX0oI(II0xO0(0));
                oIX0oI(0);
            } catch (MqttException unused) {
                f2865OxxIIOOXO.oO(f2866oI0IIXIo, "run", "517");
                return;
            }
        }
    }
}
