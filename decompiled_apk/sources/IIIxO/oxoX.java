package IIIxO;

import OXOo.OOXIXo;
import java.io.IOException;
import java.io.InputStream;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;

@XO
/* loaded from: classes6.dex */
public final class oxoX extends InputStream {

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OOXIXo
    public final byte[] f248IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f249IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public final oIX0oI f250Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f251Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OOXIXo
    public final byte[] f252OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final InputStream f253XO;

    /* renamed from: o00, reason: collision with root package name */
    public int f254o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OOXIXo
    public final byte[] f255oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f256xoXoI;

    public oxoX(@OOXIXo InputStream input, @OOXIXo oIX0oI base64) {
        IIX0o.x0xO0oo(input, "input");
        IIX0o.x0xO0oo(base64, "base64");
        this.f253XO = input;
        this.f250Oo = base64;
        this.f255oI0IIXIo = new byte[1];
        this.f252OxxIIOOXO = new byte[1024];
        this.f248IIXOooo = new byte[1024];
    }

    public final int I0Io() {
        return this.f254o00 - this.f256xoXoI;
    }

    public final int II0xO0(byte[] bArr, int i, int i2, int i3) {
        int i4 = this.f254o00;
        this.f254o00 = i4 + this.f250Oo.x0XOIxOo(this.f252OxxIIOOXO, this.f248IIXOooo, i4, 0, i3);
        int min = Math.min(I0Io(), i2 - i);
        oIX0oI(bArr, i, min);
        Oxx0IOOO();
        return min;
    }

    public final void Oxx0IOOO() {
        byte[] bArr = this.f248IIXOooo;
        int length = bArr.length;
        int i = this.f254o00;
        if ((this.f252OxxIIOOXO.length / 4) * 3 > length - i) {
            ooOOo0oXI.O00XxXI(bArr, bArr, 0, this.f256xoXoI, i);
            this.f254o00 -= this.f256xoXoI;
            this.f256xoXoI = 0;
        }
    }

    public final int X0o0xo() {
        int read;
        if (!this.f250Oo.xxX()) {
            return this.f253XO.read();
        }
        do {
            read = this.f253XO.read();
            if (read == -1) {
                break;
            }
        } while (!I0Io.Oxx0IOOO(read));
        return read;
    }

    public final void XO() {
        if (this.f256xoXoI == this.f254o00) {
            this.f256xoXoI = 0;
            this.f254o00 = 0;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f249IXxxXO) {
            this.f249IXxxXO = true;
            this.f253XO.close();
        }
    }

    public final void oIX0oI(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.f248IIXOooo;
        int i3 = this.f256xoXoI;
        ooOOo0oXI.O00XxXI(bArr2, bArr, i, i3, i3 + i2);
        this.f256xoXoI += i2;
        XO();
    }

    public final int oxoX(int i) {
        this.f252OxxIIOOXO[i] = oIX0oI.f236II0XooXoX;
        if ((i & 3) == 2) {
            int X0o0xo2 = X0o0xo();
            if (X0o0xo2 >= 0) {
                this.f252OxxIIOOXO[i + 1] = (byte) X0o0xo2;
            }
            return i + 2;
        }
        return i + 1;
    }

    @Override // java.io.InputStream
    public int read() {
        int i = this.f256xoXoI;
        if (i < this.f254o00) {
            int i2 = this.f248IIXOooo[i] & 255;
            this.f256xoXoI = i + 1;
            XO();
            return i2;
        }
        int read = read(this.f255oI0IIXIo, 0, 1);
        if (read == -1) {
            return -1;
        }
        if (read == 1) {
            return this.f255oI0IIXIo[0] & 255;
        }
        throw new IllegalStateException("Unreachable");
    }

    @Override // java.io.InputStream
    public int read(@OOXIXo byte[] destination, int i, int i2) {
        int i3;
        boolean z;
        boolean z2;
        IIX0o.x0xO0oo(destination, "destination");
        if (i >= 0 && i2 >= 0 && (i3 = i + i2) <= destination.length) {
            if (!this.f249IXxxXO) {
                if (this.f251Oxx0xo) {
                    return -1;
                }
                if (i2 == 0) {
                    return 0;
                }
                if (I0Io() >= i2) {
                    oIX0oI(destination, i, i2);
                    return i2;
                }
                int I0Io2 = (((i2 - I0Io()) + 2) / 3) * 4;
                int i4 = i;
                while (true) {
                    z = this.f251Oxx0xo;
                    if (z || I0Io2 <= 0) {
                        break;
                    }
                    int min = Math.min(this.f252OxxIIOOXO.length, I0Io2);
                    int i5 = 0;
                    while (true) {
                        z2 = this.f251Oxx0xo;
                        if (z2 || i5 >= min) {
                            break;
                        }
                        int X0o0xo2 = X0o0xo();
                        if (X0o0xo2 == -1) {
                            this.f251Oxx0xo = true;
                        } else if (X0o0xo2 != 61) {
                            this.f252OxxIIOOXO[i5] = (byte) X0o0xo2;
                            i5++;
                        } else {
                            i5 = oxoX(i5);
                            this.f251Oxx0xo = true;
                        }
                    }
                    if (!z2 && i5 != min) {
                        throw new IllegalStateException("Check failed.");
                    }
                    I0Io2 -= i5;
                    i4 += II0xO0(destination, i4, i3, i5);
                }
                if (i4 == i && z) {
                    return -1;
                }
                return i4 - i;
            }
            throw new IOException("The input stream is closed.");
        }
        throw new IndexOutOfBoundsException("offset: " + i + ", length: " + i2 + ", buffer size: " + destination.length);
    }
}
