package XIXIX;

/* loaded from: classes9.dex */
public class xoIox extends xxIXOIIO {
    public xoIox(oOoXoXO oooxoxo) {
        super(oooxoxo);
    }

    @Override // XIXIX.xxIXOIIO
    public void x0xO0oo(boolean z) {
        this.f3804II0xO0.reset();
        if (!z) {
            this.f3804II0xO0.postTranslate(this.f3802I0Io.IO(), this.f3802I0Io.x0XOIxOo() - this.f3802I0Io.X00IoxXI());
        } else {
            this.f3804II0xO0.setTranslate(-(this.f3802I0Io.oO() - this.f3802I0Io.xII()), this.f3802I0Io.x0XOIxOo() - this.f3802I0Io.X00IoxXI());
            this.f3804II0xO0.postScale(-1.0f, 1.0f);
        }
    }
}
