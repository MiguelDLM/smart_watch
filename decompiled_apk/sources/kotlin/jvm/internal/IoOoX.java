package kotlin.jvm.internal;

/* loaded from: classes6.dex */
public final class IoOoX extends X00IoxXI<long[]> {

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final long[] f29283oxoX;

    public IoOoX(int i) {
        super(i);
        this.f29283oxoX = new long[i];
    }

    public final void II0XooXoX(long j) {
        long[] jArr = this.f29283oxoX;
        int II0xO02 = II0xO0();
        X0o0xo(II0xO02 + 1);
        jArr[II0xO02] = j;
    }

    @OXOo.OOXIXo
    public final long[] xoIox() {
        return Oxx0IOOO(this.f29283oxoX, new long[XO()]);
    }

    @Override // kotlin.jvm.internal.X00IoxXI
    /* renamed from: xxIXOIIO, reason: merged with bridge method [inline-methods] */
    public int I0Io(@OXOo.OOXIXo long[] jArr) {
        IIX0o.x0xO0oo(jArr, "<this>");
        return jArr.length;
    }
}
