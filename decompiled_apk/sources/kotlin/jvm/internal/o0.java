package kotlin.jvm.internal;

/* loaded from: classes6.dex */
public final class o0 extends X00IoxXI<short[]> {

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final short[] f29328oxoX;

    public o0(int i) {
        super(i);
        this.f29328oxoX = new short[i];
    }

    public final void II0XooXoX(short s) {
        short[] sArr = this.f29328oxoX;
        int II0xO02 = II0xO0();
        X0o0xo(II0xO02 + 1);
        sArr[II0xO02] = s;
    }

    @OXOo.OOXIXo
    public final short[] xoIox() {
        return Oxx0IOOO(this.f29328oxoX, new short[XO()]);
    }

    @Override // kotlin.jvm.internal.X00IoxXI
    /* renamed from: xxIXOIIO, reason: merged with bridge method [inline-methods] */
    public int I0Io(@OXOo.OOXIXo short[] sArr) {
        IIX0o.x0xO0oo(sArr, "<this>");
        return sArr.length;
    }
}
