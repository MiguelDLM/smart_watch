package jxl.write.biff;

/* loaded from: classes6.dex */
public class XIo0oOXIx extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f28705X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public byte[] f28706XO;

    public XIo0oOXIx(String str) {
        super(OoIXo.xII.f2434Ioxxx);
        this.f28705X0o0xo = str;
        if (str == null) {
            byte[] bArr = new byte[2];
            this.f28706XO = bArr;
            OoIXo.oo0xXOI0I.XO(0, bArr, 0);
            return;
        }
        byte[] bytes = str.getBytes();
        int i = 0;
        int i2 = 0;
        while (i < bytes.length) {
            byte b = bytes[i];
            i++;
            i2 ^= XX0(b, i);
        }
        int length = (bytes.length ^ i2) ^ 52811;
        byte[] bArr2 = new byte[2];
        this.f28706XO = bArr2;
        OoIXo.oo0xXOI0I.XO(length, bArr2, 0);
    }

    public final int XX0(int i, int i2) {
        int i3 = i & 32767;
        while (i2 > 0) {
            i3 = (i3 & 16384) != 0 ? ((i3 << 1) & 32767) + 1 : (i3 << 1) & 32767;
            i2--;
        }
        return i3;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        return this.f28706XO;
    }

    public XIo0oOXIx(int i) {
        super(OoIXo.xII.f2434Ioxxx);
        byte[] bArr = new byte[2];
        this.f28706XO = bArr;
        OoIXo.oo0xXOI0I.XO(i, bArr, 0);
    }
}
