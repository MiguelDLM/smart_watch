package IIIxO;

import OXOo.OOXIXo;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;

@XO
/* loaded from: classes6.dex */
public final class X0o0xo extends OutputStream {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f228IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f229IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public final oIX0oI f230Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f231Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OOXIXo
    public final byte[] f232OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final OutputStream f233XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OOXIXo
    public final byte[] f234oI0IIXIo;

    public X0o0xo(@OOXIXo OutputStream output, @OOXIXo oIX0oI base64) {
        int i;
        IIX0o.x0xO0oo(output, "output");
        IIX0o.x0xO0oo(base64, "base64");
        this.f233XO = output;
        this.f230Oo = base64;
        if (base64.xxX()) {
            i = 76;
        } else {
            i = -1;
        }
        this.f231Oxx0xo = i;
        this.f234oI0IIXIo = new byte[1024];
        this.f232OxxIIOOXO = new byte[3];
    }

    public final void I0Io() {
        if (oxoX(this.f232OxxIIOOXO, 0, this.f228IIXOooo) == 4) {
            this.f228IIXOooo = 0;
            return;
        }
        throw new IllegalStateException("Check failed.");
    }

    public final int II0xO0(byte[] bArr, int i, int i2) {
        int min = Math.min(3 - this.f228IIXOooo, i2 - i);
        ooOOo0oXI.O00XxXI(bArr, this.f232OxxIIOOXO, this.f228IIXOooo, i, i + min);
        int i3 = this.f228IIXOooo + min;
        this.f228IIXOooo = i3;
        if (i3 == 3) {
            I0Io();
        }
        return min;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f229IXxxXO) {
            this.f229IXxxXO = true;
            if (this.f228IIXOooo != 0) {
                I0Io();
            }
            this.f233XO.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        oIX0oI();
        this.f233XO.flush();
    }

    public final void oIX0oI() {
        if (!this.f229IXxxXO) {
        } else {
            throw new IOException("The output stream is closed.");
        }
    }

    public final int oxoX(byte[] bArr, int i, int i2) {
        int oI0IIXIo2 = this.f230Oo.oI0IIXIo(bArr, this.f234oI0IIXIo, 0, i, i2);
        if (this.f231Oxx0xo == 0) {
            this.f233XO.write(oIX0oI.f235I0Io.ooXIXxIX());
            this.f231Oxx0xo = 76;
            if (oI0IIXIo2 > 76) {
                throw new IllegalStateException("Check failed.");
            }
        }
        this.f233XO.write(this.f234oI0IIXIo, 0, oI0IIXIo2);
        this.f231Oxx0xo -= oI0IIXIo2;
        return oI0IIXIo2;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        oIX0oI();
        byte[] bArr = this.f232OxxIIOOXO;
        int i2 = this.f228IIXOooo;
        int i3 = i2 + 1;
        this.f228IIXOooo = i3;
        bArr[i2] = (byte) i;
        if (i3 == 3) {
            I0Io();
        }
    }

    @Override // java.io.OutputStream
    public void write(@OOXIXo byte[] source, int i, int i2) {
        int i3;
        IIX0o.x0xO0oo(source, "source");
        oIX0oI();
        if (i < 0 || i2 < 0 || (i3 = i + i2) > source.length) {
            throw new IndexOutOfBoundsException("offset: " + i + ", length: " + i2 + ", source size: " + source.length);
        }
        if (i2 == 0) {
            return;
        }
        int i4 = this.f228IIXOooo;
        if (i4 < 3) {
            if (i4 != 0) {
                i += II0xO0(source, i, i3);
                if (this.f228IIXOooo != 0) {
                    return;
                }
            }
            while (i + 3 <= i3) {
                int min = Math.min((this.f230Oo.xxX() ? this.f231Oxx0xo : this.f234oI0IIXIo.length) / 4, (i3 - i) / 3);
                int i5 = (min * 3) + i;
                if (oxoX(source, i, i5) != min * 4) {
                    throw new IllegalStateException("Check failed.");
                }
                i = i5;
            }
            ooOOo0oXI.O00XxXI(source, this.f232OxxIIOOXO, 0, i, i3);
            this.f228IIXOooo = i3 - i;
            return;
        }
        throw new IllegalStateException("Check failed.");
    }
}
