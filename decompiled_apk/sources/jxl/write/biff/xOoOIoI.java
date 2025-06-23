package jxl.write.biff;

/* loaded from: classes6.dex */
public class xOoOIoI extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f29020X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f29021XO;

    public xOoOIoI(boolean z) {
        super(OoIXo.xII.f2490oOXoIIIo);
        this.f29021XO = z;
        byte[] bArr = new byte[2];
        this.f29020X0o0xo = bArr;
        if (z) {
            bArr[0] = 1;
        }
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        return this.f29020X0o0xo;
    }
}
