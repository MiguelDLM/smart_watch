package kotlin.jvm.internal;

/* loaded from: classes6.dex */
public final class oO extends X00IoxXI<byte[]> {

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final byte[] f29339oxoX;

    public oO(int i) {
        super(i);
        this.f29339oxoX = new byte[i];
    }

    public final void II0XooXoX(byte b) {
        byte[] bArr = this.f29339oxoX;
        int II0xO02 = II0xO0();
        X0o0xo(II0xO02 + 1);
        bArr[II0xO02] = b;
    }

    @OXOo.OOXIXo
    public final byte[] xoIox() {
        return Oxx0IOOO(this.f29339oxoX, new byte[XO()]);
    }

    @Override // kotlin.jvm.internal.X00IoxXI
    /* renamed from: xxIXOIIO, reason: merged with bridge method [inline-methods] */
    public int I0Io(@OXOo.OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<this>");
        return bArr.length;
    }
}
