package jxl.write.biff;

/* loaded from: classes6.dex */
public class oOoIIO0 extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f28850X0o0xo;

    public oOoIIO0(int i) {
        super(OoIXo.xII.f2468XIxXXX0x0);
        this.f28850X0o0xo = new byte[i * 2];
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 1;
            OoIXo.oo0xXOI0I.XO(i3, this.f28850X0o0xo, i2 * 2);
            i2 = i3;
        }
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        return this.f28850X0o0xo;
    }
}
