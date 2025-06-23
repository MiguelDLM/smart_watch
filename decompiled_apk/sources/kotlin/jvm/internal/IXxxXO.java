package kotlin.jvm.internal;

/* loaded from: classes6.dex */
public final class IXxxXO extends X00IoxXI<char[]> {

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final char[] f29282oxoX;

    public IXxxXO(int i) {
        super(i);
        this.f29282oxoX = new char[i];
    }

    public final void II0XooXoX(char c) {
        char[] cArr = this.f29282oxoX;
        int II0xO02 = II0xO0();
        X0o0xo(II0xO02 + 1);
        cArr[II0xO02] = c;
    }

    @OXOo.OOXIXo
    public final char[] xoIox() {
        return Oxx0IOOO(this.f29282oxoX, new char[XO()]);
    }

    @Override // kotlin.jvm.internal.X00IoxXI
    /* renamed from: xxIXOIIO, reason: merged with bridge method [inline-methods] */
    public int I0Io(@OXOo.OOXIXo char[] cArr) {
        IIX0o.x0xO0oo(cArr, "<this>");
        return cArr.length;
    }
}
