package IXIIo;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class xoXoI extends InputStream {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f715IIXOooo = 0;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f716IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f717Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public byte[] f718Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f719OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public byte[] f720XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f721oI0IIXIo;

    public xoXoI(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        this.f720XO = bArr;
        this.f718Oxx0xo = bArr2;
        this.f717Oo = i;
        this.f721oI0IIXIo = i3;
        this.f716IXxxXO = i2;
        this.f719OxxIIOOXO = i4;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i;
        int i2 = this.f715IIXOooo;
        int i3 = this.f716IXxxXO;
        if (i2 < i3) {
            i = this.f720XO[this.f717Oo + i2];
        } else if (i2 < this.f719OxxIIOOXO + i3) {
            i = this.f718Oxx0xo[(this.f721oI0IIXIo + i2) - i3];
        } else {
            return -1;
        }
        if (i < 0) {
            i += 256;
        }
        this.f715IIXOooo = i2 + 1;
        return i;
    }
}
