package Ox0XO;

import java.io.IOException;
import java.io.InputStream;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class XO implements Runnable {

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static /* synthetic */ Class f2906O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public static final oxO.oxoX f2907OxI;

    /* renamed from: o00, reason: collision with root package name */
    public static final String f2908o00;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public oxoX f2910IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public II0xO0 f2912Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public II0XooXoX f2913OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public IXIIo.XO f2915oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public volatile boolean f2916xoXoI;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f2914XO = false;

    /* renamed from: Oo, reason: collision with root package name */
    public Object f2911Oo = new Object();

    /* renamed from: IIXOooo, reason: collision with root package name */
    public Thread f2909IIXOooo = null;

    static {
        Class<XO> cls = f2906O0xOxO;
        if (cls == null) {
            cls = XO.class;
            f2906O0xOxO = cls;
        }
        String name = cls.getName();
        f2908o00 = name;
        f2907OxI = oxO.X0o0xo.oIX0oI(oxO.X0o0xo.f33551oIX0oI, name);
    }

    public XO(II0xO0 iI0xO0, oxoX oxox, II0XooXoX iI0XooXoX, InputStream inputStream) {
        this.f2910IXxxXO = null;
        this.f2912Oxx0xo = null;
        this.f2913OxxIIOOXO = null;
        this.f2915oI0IIXIo = new IXIIo.XO(oxox, inputStream);
        this.f2912Oxx0xo = iI0xO0;
        this.f2910IXxxXO = oxox;
        this.f2913OxxIIOOXO = iI0XooXoX;
        f2907OxI.xoIox(iI0xO0.o00().getClientId());
    }

    public void I0Io(String str) {
        f2907OxI.xxIXOIIO(f2908o00, "start", "855");
        synchronized (this.f2911Oo) {
            try {
                if (!this.f2914XO) {
                    this.f2914XO = true;
                    Thread thread = new Thread(this, str);
                    this.f2909IIXOooo = thread;
                    thread.start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean II0xO0() {
        return this.f2914XO;
    }

    public boolean oIX0oI() {
        return this.f2916xoXoI;
    }

    public void oxoX() {
        synchronized (this.f2911Oo) {
            f2907OxI.xxIXOIIO(f2908o00, "stop", "850");
            if (this.f2914XO) {
                this.f2914XO = false;
                this.f2916xoXoI = false;
                if (!Thread.currentThread().equals(this.f2909IIXOooo)) {
                    try {
                        this.f2909IIXOooo.join();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
        this.f2909IIXOooo = null;
        f2907OxI.xxIXOIIO(f2908o00, "stop", "851");
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        OoOoXO0.IIXOooo iIXOooo = null;
        while (this.f2914XO && this.f2915oI0IIXIo != null) {
            try {
                try {
                    f2907OxI.xxIXOIIO(f2908o00, "run", "852");
                    if (this.f2915oI0IIXIo.available() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.f2916xoXoI = z;
                    IXIIo.IIXOooo II0xO02 = this.f2915oI0IIXIo.II0xO0();
                    this.f2916xoXoI = false;
                    if (II0xO02 instanceof IXIIo.II0xO0) {
                        iIXOooo = this.f2913OxxIIOOXO.X0o0xo(II0xO02);
                        if (iIXOooo != null) {
                            synchronized (iIXOooo) {
                                this.f2910IXxxXO.OxI((IXIIo.II0xO0) II0xO02);
                            }
                        } else {
                            throw new MqttException(6);
                        }
                    } else {
                        this.f2910IXxxXO.X0IIOO(II0xO02);
                    }
                } catch (IOException e) {
                    f2907OxI.xxIXOIIO(f2908o00, "run", "853");
                    this.f2914XO = false;
                    if (!this.f2912Oxx0xo.X00IoxXI()) {
                        this.f2912Oxx0xo.xXOx(iIXOooo, new MqttException(32109, e));
                    }
                } catch (MqttException e2) {
                    f2907OxI.II0xO0(f2908o00, "run", "856", null, e2);
                    this.f2914XO = false;
                    this.f2912Oxx0xo.xXOx(iIXOooo, e2);
                }
                this.f2916xoXoI = false;
            } catch (Throwable th) {
                this.f2916xoXoI = false;
                throw th;
            }
        }
        f2907OxI.xxIXOIIO(f2908o00, "run", "854");
    }
}
