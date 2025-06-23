package jxl.write.biff;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes6.dex */
public class xXOx implements XIxXXX0x0 {

    /* renamed from: oxoX, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f29022oxoX = XxIIOXIXx.X0o0xo.Oxx0IOOO(xXOx.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public int f29023I0Io = 0;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f29024II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public byte[] f29025oIX0oI;

    public xXOx(int i, int i2) {
        this.f29025oIX0oI = new byte[i];
        this.f29024II0xO0 = i2;
    }

    @Override // jxl.write.biff.XIxXXX0x0
    public void II0xO0(OutputStream outputStream) throws IOException {
        outputStream.write(this.f29025oIX0oI, 0, this.f29023I0Io);
    }

    @Override // jxl.write.biff.XIxXXX0x0
    public void close() throws IOException {
    }

    @Override // jxl.write.biff.XIxXXX0x0
    public int getPosition() {
        return this.f29023I0Io;
    }

    @Override // jxl.write.biff.XIxXXX0x0
    public void oIX0oI(byte[] bArr, int i) {
        System.arraycopy(bArr, 0, this.f29025oIX0oI, i, bArr.length);
    }

    @Override // jxl.write.biff.XIxXXX0x0
    public void write(byte[] bArr) {
        while (true) {
            int i = this.f29023I0Io;
            int length = bArr.length + i;
            byte[] bArr2 = this.f29025oIX0oI;
            if (length > bArr2.length) {
                byte[] bArr3 = new byte[bArr2.length + this.f29024II0xO0];
                System.arraycopy(bArr2, 0, bArr3, 0, i);
                this.f29025oIX0oI = bArr3;
            } else {
                System.arraycopy(bArr, 0, bArr2, i, bArr.length);
                this.f29023I0Io += bArr.length;
                return;
            }
        }
    }
}
