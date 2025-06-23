package Ox0XO;

import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class Oxx0IOOO implements Runnable {

    /* renamed from: OxI, reason: collision with root package name */
    public static /* synthetic */ Class f2871OxI;

    /* renamed from: o00, reason: collision with root package name */
    public static final oxO.oxoX f2872o00;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final String f2873xoXoI;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public oxoX f2875IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public IXIIo.Oxx0IOOO f2877Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public II0XooXoX f2878OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public II0xO0 f2880oI0IIXIo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f2879XO = false;

    /* renamed from: Oo, reason: collision with root package name */
    public Object f2876Oo = new Object();

    /* renamed from: IIXOooo, reason: collision with root package name */
    public Thread f2874IIXOooo = null;

    static {
        Class<Oxx0IOOO> cls = f2871OxI;
        if (cls == null) {
            cls = Oxx0IOOO.class;
            f2871OxI = cls;
        }
        String name = cls.getName();
        f2873xoXoI = name;
        f2872o00 = oxO.X0o0xo.oIX0oI(oxO.X0o0xo.f33551oIX0oI, name);
    }

    public Oxx0IOOO(II0xO0 iI0xO0, oxoX oxox, II0XooXoX iI0XooXoX, OutputStream outputStream) {
        this.f2875IXxxXO = null;
        this.f2880oI0IIXIo = null;
        this.f2878OxxIIOOXO = null;
        this.f2877Oxx0xo = new IXIIo.Oxx0IOOO(oxox, outputStream);
        this.f2880oI0IIXIo = iI0xO0;
        this.f2875IXxxXO = oxox;
        this.f2878OxxIIOOXO = iI0XooXoX;
        f2872o00.xoIox(iI0xO0.o00().getClientId());
    }

    public void I0Io() {
        synchronized (this.f2876Oo) {
            f2872o00.xxIXOIIO(f2873xoXoI, "stop", "800");
            if (this.f2879XO) {
                this.f2879XO = false;
                if (!Thread.currentThread().equals(this.f2874IIXOooo)) {
                    while (this.f2874IIXOooo.isAlive()) {
                        try {
                            this.f2875IXxxXO.o00();
                            this.f2874IIXOooo.join(100L);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
            this.f2874IIXOooo = null;
            f2872o00.xxIXOIIO(f2873xoXoI, "stop", "801");
        }
    }

    public void II0xO0(String str) {
        synchronized (this.f2876Oo) {
            try {
                if (!this.f2879XO) {
                    this.f2879XO = true;
                    Thread thread = new Thread(this, str);
                    this.f2874IIXOooo = thread;
                    thread.start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void oIX0oI(IXIIo.IIXOooo iIXOooo, Exception exc) {
        MqttException mqttException;
        f2872o00.II0xO0(f2873xoXoI, "handleRunException", "804", null, exc);
        if (!(exc instanceof MqttException)) {
            mqttException = new MqttException(32109, exc);
        } else {
            mqttException = (MqttException) exc;
        }
        this.f2879XO = false;
        this.f2880oI0IIXIo.xXOx(null, mqttException);
    }

    @Override // java.lang.Runnable
    public void run() {
        IXIIo.IIXOooo iIXOooo = null;
        while (this.f2879XO && this.f2877Oxx0xo != null) {
            try {
                iIXOooo = this.f2875IXxxXO.xoIox();
                if (iIXOooo != null) {
                    f2872o00.OOXIXo(f2873xoXoI, "run", "802", new Object[]{iIXOooo.oO(), iIXOooo});
                    if (iIXOooo instanceof IXIIo.II0xO0) {
                        this.f2877Oxx0xo.oIX0oI(iIXOooo);
                        this.f2877Oxx0xo.flush();
                    } else {
                        OoOoXO0.IIXOooo X0o0xo2 = this.f2878OxxIIOOXO.X0o0xo(iIXOooo);
                        if (X0o0xo2 != null) {
                            synchronized (X0o0xo2) {
                                this.f2877Oxx0xo.oIX0oI(iIXOooo);
                                try {
                                    this.f2877Oxx0xo.flush();
                                } catch (IOException e) {
                                    if (!(iIXOooo instanceof IXIIo.X0o0xo)) {
                                        throw e;
                                        break;
                                    }
                                }
                                this.f2875IXxxXO.XIxXXX0x0(iIXOooo);
                            }
                        } else {
                            continue;
                        }
                    }
                } else {
                    f2872o00.xxIXOIIO(f2873xoXoI, "run", "803");
                    this.f2879XO = false;
                }
            } catch (MqttException e2) {
                oIX0oI(iIXOooo, e2);
            } catch (Exception e3) {
                oIX0oI(iIXOooo, e3);
            }
        }
        f2872o00.xxIXOIIO(f2873xoXoI, "run", "805");
    }
}
