package OoIXo;

/* loaded from: classes6.dex */
public class II0XooXoX extends OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f2046X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f2047XO;

    public II0XooXoX(int i, int i2) {
        super(xII.f2420IIX0);
        this.f2046X0o0xo = i;
        this.f2047XO = i2;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        oo0xXOI0I.XO(this.f2046X0o0xo, r0, 0);
        byte[] bArr = {0, (byte) (bArr[1] | 128), (byte) this.f2047XO, -1};
        return bArr;
    }
}
