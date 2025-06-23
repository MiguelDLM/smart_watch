package jxl.write.biff;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes6.dex */
public final class IIX0o {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28581II0XooXoX = XxIIOXIXx.X0o0xo.Oxx0IOOO(IIX0o.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public OutputStream f28582I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f28583II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public jxl.read.biff.x0xO0oo f28584Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28585X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f28586XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public XIxXXX0x0 f28587oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28588oxoX;

    public IIX0o(OutputStream outputStream, xIoXXXIXo.O0xOxO o0xOxO, jxl.read.biff.x0xO0oo x0xo0oo) throws IOException {
        this.f28582I0Io = outputStream;
        this.f28586XO = o0xOxO;
        this.f28584Oxx0IOOO = x0xo0oo;
        II0xO0();
    }

    public int I0Io() throws IOException {
        return this.f28587oIX0oI.getPosition();
    }

    public final void II0xO0() throws IOException {
        if (this.f28586XO.o00()) {
            this.f28587oIX0oI = new ooXIXxIX(this.f28586XO.xoXoI());
            return;
        }
        this.f28588oxoX = this.f28586XO.oO();
        this.f28585X0o0xo = this.f28586XO.oIX0oI();
        this.f28587oIX0oI = new xXOx(this.f28588oxoX, this.f28585X0o0xo);
    }

    public void X0o0xo(OutputStream outputStream) throws IOException {
        if (this.f28587oIX0oI != null) {
            f28581II0XooXoX.ooOOo0oXI("Rewriting a workbook with non-empty data");
        }
        this.f28582I0Io = outputStream;
        II0xO0();
    }

    public void XO(OoIXo.xoIox xoiox) throws IOException {
        this.f28587oIX0oI.write(xoiox.I0Io());
    }

    public void oIX0oI(boolean z) throws IOException, JxlWriteException {
        XIxXXX0x0 xIxXXX0x0 = this.f28587oIX0oI;
        new x0xO0oo(xIxXXX0x0, xIxXXX0x0.getPosition(), this.f28582I0Io, this.f28584Oxx0IOOO).XO();
        this.f28582I0Io.flush();
        this.f28587oIX0oI.close();
        if (z) {
            this.f28582I0Io.close();
        }
        this.f28587oIX0oI = null;
        if (!this.f28586XO.oOoXoXO()) {
            System.gc();
        }
    }

    public void oxoX(byte[] bArr, int i) throws IOException {
        this.f28587oIX0oI.oIX0oI(bArr, i);
    }
}
