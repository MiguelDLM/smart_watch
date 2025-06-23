package xX0IIXIx0;

import android.graphics.Canvas;
import android.graphics.Path;

/* loaded from: classes9.dex */
public abstract class oOoXoXO extends I0Io {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public Path f34564II0XooXoX;

    public oOoXoXO(Ioxxx.oIX0oI oix0oi, XIXIX.oOoXoXO oooxoxo) {
        super(oix0oi, oooxoxo);
        this.f34564II0XooXoX = new Path();
    }

    public void x0XOIxOo(Canvas canvas, float f, float f2, IIxOXoOo0.II0XooXoX iI0XooXoX) {
        this.f34533oxoX.setColor(iI0XooXoX.X0xII0I());
        this.f34533oxoX.setStrokeWidth(iI0XooXoX.xI0oxI00());
        this.f34533oxoX.setPathEffect(iI0XooXoX.O0IxXx());
        if (iI0XooXoX.XI0IXoo()) {
            this.f34564II0XooXoX.reset();
            this.f34564II0XooXoX.moveTo(f, this.f34563oIX0oI.xoIox());
            this.f34564II0XooXoX.lineTo(f, this.f34563oIX0oI.XO());
            canvas.drawPath(this.f34564II0XooXoX, this.f34533oxoX);
        }
        if (iI0XooXoX.XOxxooXI()) {
            this.f34564II0XooXoX.reset();
            this.f34564II0XooXoX.moveTo(this.f34563oIX0oI.II0XooXoX(), f2);
            this.f34564II0XooXoX.lineTo(this.f34563oIX0oI.xxIXOIIO(), f2);
            canvas.drawPath(this.f34564II0XooXoX, this.f34533oxoX);
        }
    }
}
