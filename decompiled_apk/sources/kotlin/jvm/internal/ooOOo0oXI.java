package kotlin.jvm.internal;

/* loaded from: classes6.dex */
public final class ooOOo0oXI extends X00IoxXI<boolean[]> {

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final boolean[] f29346oxoX;

    public ooOOo0oXI(int i) {
        super(i);
        this.f29346oxoX = new boolean[i];
    }

    public final void II0XooXoX(boolean z) {
        boolean[] zArr = this.f29346oxoX;
        int II0xO02 = II0xO0();
        X0o0xo(II0xO02 + 1);
        zArr[II0xO02] = z;
    }

    @OXOo.OOXIXo
    public final boolean[] xoIox() {
        return Oxx0IOOO(this.f29346oxoX, new boolean[XO()]);
    }

    @Override // kotlin.jvm.internal.X00IoxXI
    /* renamed from: xxIXOIIO, reason: merged with bridge method [inline-methods] */
    public int I0Io(@OXOo.OOXIXo boolean[] zArr) {
        IIX0o.x0xO0oo(zArr, "<this>");
        return zArr.length;
    }
}
