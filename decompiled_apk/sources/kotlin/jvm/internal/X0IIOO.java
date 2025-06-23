package kotlin.jvm.internal;

/* loaded from: classes6.dex */
public final class X0IIOO extends X00IoxXI<float[]> {

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final float[] f29316oxoX;

    public X0IIOO(int i) {
        super(i);
        this.f29316oxoX = new float[i];
    }

    public final void II0XooXoX(float f) {
        float[] fArr = this.f29316oxoX;
        int II0xO02 = II0xO0();
        X0o0xo(II0xO02 + 1);
        fArr[II0xO02] = f;
    }

    @OXOo.OOXIXo
    public final float[] xoIox() {
        return Oxx0IOOO(this.f29316oxoX, new float[XO()]);
    }

    @Override // kotlin.jvm.internal.X00IoxXI
    /* renamed from: xxIXOIIO, reason: merged with bridge method [inline-methods] */
    public int I0Io(@OXOo.OOXIXo float[] fArr) {
        IIX0o.x0xO0oo(fArr, "<this>");
        return fArr.length;
    }
}
