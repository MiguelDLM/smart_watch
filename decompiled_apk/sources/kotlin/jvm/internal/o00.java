package kotlin.jvm.internal;

/* loaded from: classes6.dex */
public final class o00 extends X00IoxXI<double[]> {

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final double[] f29329oxoX;

    public o00(int i) {
        super(i);
        this.f29329oxoX = new double[i];
    }

    public final void II0XooXoX(double d) {
        double[] dArr = this.f29329oxoX;
        int II0xO02 = II0xO0();
        X0o0xo(II0xO02 + 1);
        dArr[II0xO02] = d;
    }

    @OXOo.OOXIXo
    public final double[] xoIox() {
        return Oxx0IOOO(this.f29329oxoX, new double[XO()]);
    }

    @Override // kotlin.jvm.internal.X00IoxXI
    /* renamed from: xxIXOIIO, reason: merged with bridge method [inline-methods] */
    public int I0Io(@OXOo.OOXIXo double[] dArr) {
        IIX0o.x0xO0oo(dArr, "<this>");
        return dArr.length;
    }
}
