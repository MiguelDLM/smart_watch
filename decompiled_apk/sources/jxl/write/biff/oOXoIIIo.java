package jxl.write.biff;

/* loaded from: classes6.dex */
public class oOXoIIIo extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f28847X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f28848XO;

    public oOXoIIIo(boolean z) {
        super(OoIXo.xII.f2432IoOoo);
        this.f28848XO = z;
        byte[] bArr = new byte[2];
        this.f28847X0o0xo = bArr;
        if (z) {
            bArr[0] = 1;
        }
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        return this.f28847X0o0xo;
    }
}
