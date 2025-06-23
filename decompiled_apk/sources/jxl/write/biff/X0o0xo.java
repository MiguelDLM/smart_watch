package jxl.write.biff;

/* loaded from: classes6.dex */
public class X0o0xo extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f28693X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public byte[] f28694XO;

    public X0o0xo(boolean z) {
        super(OoIXo.xII.f2423IIxOXoOo0);
        this.f28693X0o0xo = z;
        byte[] bArr = new byte[2];
        this.f28694XO = bArr;
        if (!z) {
            OoIXo.oo0xXOI0I.XO(1, bArr, 0);
        }
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        return this.f28694XO;
    }
}
