package jxl.write.biff;

/* loaded from: classes6.dex */
public class o00 extends OoIXo.OI0 {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f28803Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f28804X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f28805XO;

    public o00(int i, boolean z) {
        super(OoIXo.xII.f2512x0o);
        this.f28804X0o0xo = new byte[4];
        this.f28805XO = i;
        this.f28803Oxx0IOOO = z;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        if (this.f28803Oxx0IOOO) {
            byte[] bArr = this.f28804X0o0xo;
            bArr[0] = (byte) (bArr[0] | 1);
        }
        OoIXo.oo0xXOI0I.XO(this.f28805XO, this.f28804X0o0xo, 2);
        return this.f28804X0o0xo;
    }
}
