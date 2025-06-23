package jxl.write.biff;

/* loaded from: classes6.dex */
public class oIX0oI extends OoIXo.OI0 {

    /* renamed from: XO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28837XO = XxIIOXIXx.X0o0xo.Oxx0IOOO(oIX0oI.class);

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f28838X0o0xo;

    public oIX0oI(int i, byte[] bArr) {
        super(OoIXo.xII.oIX0oI(i));
        this.f28838X0o0xo = bArr;
        f28837XO.ooOOo0oXI("ArbitraryRecord of type " + i + " created");
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        return this.f28838X0o0xo;
    }
}
