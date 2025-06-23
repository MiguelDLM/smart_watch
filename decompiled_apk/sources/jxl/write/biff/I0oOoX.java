package jxl.write.biff;

/* loaded from: classes6.dex */
public class I0oOoX extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f28565X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public byte[] f28566XO;

    public I0oOoX(boolean z) {
        super(OoIXo.xII.f2440O0X);
        this.f28565X0o0xo = z;
        byte[] bArr = new byte[2];
        this.f28566XO = bArr;
        if (z) {
            bArr[0] = 1;
        }
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        return this.f28566XO;
    }
}
