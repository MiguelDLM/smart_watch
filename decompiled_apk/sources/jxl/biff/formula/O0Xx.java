package jxl.biff.formula;

import java.util.Stack;

/* loaded from: classes6.dex */
public abstract class O0Xx extends IO implements o0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public OI0[] f27704II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f27705Oxx0IOOO;

    public final void IIXOooo(int i) {
        this.f27705Oxx0IOOO = i;
    }

    public int IXxxXO() {
        return this.f27705Oxx0IOOO;
    }

    public void Oxx0xo(Stack stack) {
    }

    public OI0[] OxxIIOOXO() {
        return this.f27704II0XooXoX;
    }

    public int oI0IIXIo() {
        return 5;
    }

    @Override // jxl.biff.formula.OI0
    public byte[] oxoX() {
        return null;
    }

    @Override // jxl.biff.formula.o0
    public int read(byte[] bArr, int i) {
        this.f27705Oxx0IOOO = OoIXo.oo0xXOI0I.I0Io(bArr[i], bArr[i + 1]);
        return 2;
    }

    public void xoXoI(OI0[] oi0Arr) {
        this.f27704II0XooXoX = oi0Arr;
    }
}
