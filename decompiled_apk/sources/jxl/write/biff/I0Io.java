package jxl.write.biff;

/* loaded from: classes6.dex */
public class I0Io extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f28559X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public byte[] f28560XO;

    public I0Io(boolean z) {
        super(OoIXo.xII.f2438O00XxXI);
        this.f28559X0o0xo = z;
        byte[] bArr = new byte[2];
        this.f28560XO = bArr;
        if (z) {
            OoIXo.oo0xXOI0I.XO(1, bArr, 0);
        }
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        return this.f28560XO;
    }
}
