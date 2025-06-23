package xx0;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes13.dex */
public class oOoXoXO extends OOXIXo implements Handler.Callback {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public File f35208IIXOooo;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public volatile IXxxXO f35209O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public volatile IXxxXO f35210OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public ooOOo0oXI f35211Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public FileWriter f35212OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public volatile IXxxXO f35213X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public volatile IXxxXO f35214XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public volatile boolean f35215XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public Handler f35216XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public char[] f35217o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public FileWriter f35218oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public File f35219xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public HandlerThread f35220xxX;

    public oOoXoXO(ooOOo0oXI ooooo0oxi) {
        this(x0XOIxOo.f35233II0xO0, true, Oxx0xo.f35204oIX0oI, ooooo0oxi);
    }

    public void II0XooXoX() {
        if (this.f35216XxX0x0xxx.hasMessages(1024)) {
            this.f35216XxX0x0xxx.removeMessages(1024);
        }
        this.f35216XxX0x0xxx.sendEmptyMessage(1024);
    }

    public void OOXIXo() {
        oO();
        x0xO0oo();
        this.f35220xxX.quit();
    }

    public final void Oo() {
        synchronized (this) {
            try {
                if (this.f35213X0IIOO == this.f35210OxI) {
                    this.f35213X0IIOO = this.f35209O0xOxO;
                    this.f35214XI0IXoo = this.f35210OxI;
                } else {
                    this.f35213X0IIOO = this.f35210OxI;
                    this.f35214XI0IXoo = this.f35209O0xOxO;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // xx0.OOXIXo
    public void XO(int i, Thread thread, long j, String str, String str2, Throwable th) {
        xxIXOIIO(Oxx0IOOO().II0xO0(i, thread, j, str, str2, th));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1024) {
            ooOOo0oXI();
            return true;
        }
        return true;
    }

    public final void oO() {
        try {
            FileWriter fileWriter = this.f35218oI0IIXIo;
            if (fileWriter != null) {
                fileWriter.flush();
                this.f35218oI0IIXIo.close();
            }
        } catch (IOException e) {
            xxIXOIIO.xxIXOIIO(xxIXOIIO.f35263Oxx0xo, "-->closeFileWriter() exception:", e);
        }
    }

    public ooOOo0oXI oOoXoXO() {
        return this.f35211Oxx0xo;
    }

    public final void ooOOo0oXI() {
        if (Thread.currentThread() != this.f35220xxX || this.f35215XIxXXX0x0) {
            return;
        }
        this.f35215XIxXXX0x0 = true;
        Oo();
        try {
            try {
                this.f35214XI0IXoo.I0Io(x0XOIxOo(), this.f35217o00);
            } catch (IOException e) {
                xxIXOIIO.xxIXOIIO("FileTracer", "flushBuffer exception", e);
            }
            this.f35215XIxXXX0x0 = false;
        } finally {
            this.f35214XI0IXoo.oxoX();
        }
    }

    public final Writer[] x0XOIxOo() {
        File[] X0o0xo2 = oOoXoXO().X0o0xo();
        if (X0o0xo2 != null && X0o0xo2.length >= 2) {
            File file = X0o0xo2[0];
            if ((file != null && !file.equals(this.f35208IIXOooo)) || (this.f35218oI0IIXIo == null && file != null)) {
                this.f35208IIXOooo = file;
                oO();
                try {
                    this.f35218oI0IIXIo = new FileWriter(this.f35208IIXOooo, true);
                } catch (IOException unused) {
                    this.f35218oI0IIXIo = null;
                    xxIXOIIO.II0XooXoX(xxIXOIIO.f35263Oxx0xo, "-->obtainFileWriter() old log file permission denied");
                }
            }
            File file2 = X0o0xo2[1];
            if ((file2 != null && !file2.equals(this.f35219xoXoI)) || (this.f35212OxxIIOOXO == null && file2 != null)) {
                this.f35219xoXoI = file2;
                x0xO0oo();
                try {
                    this.f35212OxxIIOOXO = new FileWriter(this.f35219xoXoI, true);
                } catch (IOException unused2) {
                    this.f35212OxxIIOOXO = null;
                    xxIXOIIO.II0XooXoX(xxIXOIIO.f35263Oxx0xo, "-->obtainFileWriter() app specific file permission denied");
                }
            }
        }
        return new Writer[]{this.f35218oI0IIXIo, this.f35212OxxIIOOXO};
    }

    public final void x0xO0oo() {
        try {
            FileWriter fileWriter = this.f35212OxxIIOOXO;
            if (fileWriter != null) {
                fileWriter.flush();
                this.f35212OxxIIOOXO.close();
            }
        } catch (IOException e) {
            xxIXOIIO.xxIXOIIO(xxIXOIIO.f35263Oxx0xo, "-->closeAppSpecificFileWriter() exception:", e);
        }
    }

    public void xoIox(ooOOo0oXI ooooo0oxi) {
        this.f35211Oxx0xo = ooooo0oxi;
    }

    public final void xxIXOIIO(String str) {
        this.f35213X0IIOO.II0xO0(str);
        if (this.f35213X0IIOO.oIX0oI() >= oOoXoXO().x0XOIxOo()) {
            II0XooXoX();
        }
    }

    public oOoXoXO(int i, boolean z, Oxx0xo oxx0xo, ooOOo0oXI ooooo0oxi) {
        super(i, z, oxx0xo);
        this.f35215XIxXXX0x0 = false;
        xoIox(ooooo0oxi);
        this.f35210OxI = new IXxxXO();
        this.f35209O0xOxO = new IXxxXO();
        this.f35213X0IIOO = this.f35210OxI;
        this.f35214XI0IXoo = this.f35209O0xOxO;
        this.f35217o00 = new char[ooooo0oxi.x0XOIxOo()];
        HandlerThread handlerThread = new HandlerThread(ooooo0oxi.xoIox(), ooooo0oxi.IXxxXO());
        this.f35220xxX = handlerThread;
        handlerThread.start();
        if (!this.f35220xxX.isAlive() || this.f35220xxX.getLooper() == null) {
            return;
        }
        this.f35216XxX0x0xxx = new Handler(this.f35220xxX.getLooper(), this);
    }
}
