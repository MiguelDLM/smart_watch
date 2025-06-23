package jxl.write.biff;

/* loaded from: classes6.dex */
public class x0o extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int[] f28970X0o0xo;

    public x0o(int[] iArr) {
        super(OoIXo.xII.f2437O0);
        this.f28970X0o0xo = iArr;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        int[] iArr = this.f28970X0o0xo;
        int i = 2;
        byte[] bArr = new byte[(iArr.length * 6) + 2];
        int i2 = 0;
        OoIXo.oo0xXOI0I.XO(iArr.length, bArr, 0);
        while (true) {
            int[] iArr2 = this.f28970X0o0xo;
            if (i2 < iArr2.length) {
                OoIXo.oo0xXOI0I.XO(iArr2[i2], bArr, i);
                OoIXo.oo0xXOI0I.XO(255, bArr, i + 4);
                i += 6;
                i2++;
            } else {
                return bArr;
            }
        }
    }
}
