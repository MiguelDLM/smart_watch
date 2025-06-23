package jxl.read.biff;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;

/* loaded from: classes6.dex */
public class XIxXXX0x0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28284II0XooXoX = XxIIOXIXx.X0o0xo.Oxx0IOOO(XIxXXX0x0.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28285I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f28286II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f28287Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28288X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public x0xO0oo f28289XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public byte[] f28290oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28291oxoX;

    public XIxXXX0x0(InputStream inputStream, xIoXXXIXo.O0xOxO o0xOxO) throws IOException, BiffException {
        this.f28287Oxx0IOOO = o0xOxO;
        this.f28291oxoX = o0xOxO.oO();
        this.f28288X0o0xo = this.f28287Oxx0IOOO.oIX0oI();
        byte[] bArr = new byte[this.f28291oxoX];
        int read = inputStream.read(bArr);
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException();
        }
        int i = read;
        while (read != -1) {
            if (i >= bArr.length) {
                byte[] bArr2 = new byte[bArr.length + this.f28288X0o0xo];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                bArr = bArr2;
            }
            read = inputStream.read(bArr, i, bArr.length - i);
            i += read;
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedIOException();
            }
        }
        if (i + 1 != 0) {
            x0xO0oo x0xo0oo = new x0xO0oo(bArr, o0xOxO);
            try {
                this.f28290oIX0oI = x0xo0oo.OOXIXo("workbook");
            } catch (BiffException unused) {
                this.f28290oIX0oI = x0xo0oo.OOXIXo("book");
            }
            if (!this.f28287Oxx0IOOO.Oxx0xo() && x0xo0oo.X0o0xo() > OoIXo.X0o0xo.f2199X0IIOO.length) {
                this.f28289XO = x0xo0oo;
            }
            if (this.f28287Oxx0IOOO.oOoXoXO()) {
                return;
            }
            System.gc();
            return;
        }
        throw new BiffException(BiffException.excelFileNotFound);
    }

    public x0xO0oo I0Io() {
        return this.f28289XO;
    }

    public xoxXI II0XooXoX() {
        int i = this.f28286II0xO0;
        xoxXI xoxxi = new xoxXI(this.f28290oIX0oI, this.f28286II0xO0, this);
        this.f28286II0xO0 = i;
        return xoxxi;
    }

    public void II0xO0() {
    }

    public void OOXIXo(int i) {
        this.f28285I0Io = this.f28286II0xO0;
        this.f28286II0xO0 = i;
    }

    public xoxXI Oxx0IOOO() {
        return new xoxXI(this.f28290oIX0oI, this.f28286II0xO0, this);
    }

    public boolean X0o0xo() {
        if (this.f28286II0xO0 < this.f28290oIX0oI.length - 4) {
            return true;
        }
        return false;
    }

    public final void XO() {
        boolean z = false;
        while (!z) {
            byte[] bArr = this.f28290oIX0oI;
            int i = this.f28286II0xO0;
            if (OoIXo.oo0xXOI0I.I0Io(bArr[i], bArr[i + 1]) == OoIXo.xII.f2506oxoX.f2535oIX0oI) {
                z = true;
            } else {
                oOoXoXO(128);
            }
        }
    }

    public void oIX0oI() {
        this.f28290oIX0oI = null;
    }

    public void oOoXoXO(int i) {
        this.f28286II0xO0 += i;
    }

    public int oxoX() {
        return this.f28286II0xO0;
    }

    public void xoIox() {
        this.f28286II0xO0 = this.f28285I0Io;
    }

    public byte[] xxIXOIIO(int i, int i2) {
        byte[] bArr = new byte[i2];
        try {
            System.arraycopy(this.f28290oIX0oI, i, bArr, 0, i2);
            return bArr;
        } catch (ArrayIndexOutOfBoundsException e) {
            f28284II0XooXoX.I0Io("Array index out of bounds at position " + i + " record length " + i2);
            throw e;
        }
    }

    public XIxXXX0x0(byte[] bArr) {
        this.f28290oIX0oI = bArr;
    }
}
