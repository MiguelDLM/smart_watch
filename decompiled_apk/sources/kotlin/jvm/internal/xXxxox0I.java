package kotlin.jvm.internal;

/* loaded from: classes6.dex */
public final class xXxxox0I extends X00IoxXI<int[]> {

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final int[] f29374oxoX;

    public xXxxox0I(int i) {
        super(i);
        this.f29374oxoX = new int[i];
    }

    public final void II0XooXoX(int i) {
        int[] iArr = this.f29374oxoX;
        int II0xO02 = II0xO0();
        X0o0xo(II0xO02 + 1);
        iArr[II0xO02] = i;
    }

    @OXOo.OOXIXo
    public final int[] xoIox() {
        return Oxx0IOOO(this.f29374oxoX, new int[XO()]);
    }

    @Override // kotlin.jvm.internal.X00IoxXI
    /* renamed from: xxIXOIIO, reason: merged with bridge method [inline-methods] */
    public int I0Io(@OXOo.OOXIXo int[] iArr) {
        IIX0o.x0xO0oo(iArr, "<this>");
        return iArr.length;
    }
}
