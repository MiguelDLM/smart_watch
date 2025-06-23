package jxl.write.biff;

/* loaded from: classes6.dex */
public class O0IxXx extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f28651X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f28652XO;

    public O0IxXx(boolean z) {
        super(OoIXo.xII.f2441O0Xx);
        this.f28652XO = z;
        byte[] bArr = new byte[2];
        this.f28651X0o0xo = bArr;
        if (z) {
            bArr[0] = 1;
        }
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        return this.f28651X0o0xo;
    }
}
