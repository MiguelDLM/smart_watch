package IoxX;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/* loaded from: classes6.dex */
public class XO implements Runnable {

    /* renamed from: OxI, reason: collision with root package name */
    public static /* synthetic */ Class f888OxI;

    /* renamed from: o00, reason: collision with root package name */
    public static final oxO.oxoX f889o00;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final String f890xoXoI;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public PipedOutputStream f891IIXOooo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public InputStream f894Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public volatile boolean f895OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f896XO = false;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f893Oo = false;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Object f892IXxxXO = new Object();

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public Thread f897oI0IIXIo = null;

    static {
        Class<XO> cls = f888OxI;
        if (cls == null) {
            cls = XO.class;
            f888OxI = cls;
        }
        String name = cls.getName();
        f890xoXoI = name;
        f889o00 = oxO.X0o0xo.oIX0oI(oxO.X0o0xo.f33551oIX0oI, name);
    }

    public XO(InputStream inputStream, PipedInputStream pipedInputStream) throws IOException {
        this.f894Oxx0xo = inputStream;
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        this.f891IIXOooo = pipedOutputStream;
        pipedInputStream.connect(pipedOutputStream);
    }

    public boolean I0Io() {
        return this.f896XO;
    }

    public boolean II0xO0() {
        return this.f895OxxIIOOXO;
    }

    public void X0o0xo() {
        this.f893Oo = true;
        synchronized (this.f892IXxxXO) {
            f889o00.xxIXOIIO(f890xoXoI, "stop", "850");
            if (this.f896XO) {
                this.f896XO = false;
                this.f895OxxIIOOXO = false;
                oIX0oI();
                if (!Thread.currentThread().equals(this.f897oI0IIXIo)) {
                    try {
                        this.f897oI0IIXIo.join();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
        this.f897oI0IIXIo = null;
        f889o00.xxIXOIIO(f890xoXoI, "stop", "851");
    }

    public final void oIX0oI() {
        try {
            this.f891IIXOooo.close();
        } catch (IOException unused) {
        }
    }

    public void oxoX(String str) {
        f889o00.xxIXOIIO(f890xoXoI, "start", "855");
        synchronized (this.f892IXxxXO) {
            try {
                if (!this.f896XO) {
                    this.f896XO = true;
                    Thread thread = new Thread(this, str);
                    this.f897oI0IIXIo = thread;
                    thread.start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        while (this.f896XO && this.f894Oxx0xo != null) {
            try {
                f889o00.xxIXOIIO(f890xoXoI, "run", "852");
                if (this.f894Oxx0xo.available() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.f895OxxIIOOXO = z;
                II0xO0 iI0xO0 = new II0xO0(this.f894Oxx0xo);
                if (!iI0xO0.II0XooXoX()) {
                    for (int i = 0; i < iI0xO0.Oxx0IOOO().length; i++) {
                        this.f891IIXOooo.write(iI0xO0.Oxx0IOOO()[i]);
                    }
                    this.f891IIXOooo.flush();
                } else if (!this.f893Oo) {
                    throw new IOException("Server sent a WebSocket Frame with the Stop OpCode");
                    break;
                }
                this.f895OxxIIOOXO = false;
            } catch (IOException unused) {
                X0o0xo();
            }
        }
    }
}
