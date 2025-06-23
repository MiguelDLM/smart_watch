package xX0IIXIx0;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/* loaded from: classes9.dex */
public abstract class Oxx0IOOO extends oO {

    /* renamed from: I0Io, reason: collision with root package name */
    public Paint f34529I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Ioxxx.oIX0oI f34530II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public Paint f34531X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public Paint f34532XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public Paint f34533oxoX;

    public Oxx0IOOO(Ioxxx.oIX0oI oix0oi, XIXIX.oOoXoXO oooxoxo) {
        super(oooxoxo);
        this.f34530II0xO0 = oix0oi;
        Paint paint = new Paint(1);
        this.f34529I0Io = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f34531X0o0xo = new Paint(4);
        Paint paint2 = new Paint(1);
        this.f34532XO = paint2;
        paint2.setColor(Color.rgb(63, 63, 63));
        this.f34532XO.setTextAlign(Paint.Align.CENTER);
        this.f34532XO.setTextSize(XIXIX.OOXIXo.X0o0xo(9.0f));
        Paint paint3 = new Paint(1);
        this.f34533oxoX = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.f34533oxoX.setStrokeWidth(2.0f);
        this.f34533oxoX.setColor(Color.rgb(255, 187, 115));
    }

    public abstract void I0Io(Canvas canvas);

    public Paint II0XooXoX() {
        return this.f34529I0Io;
    }

    public abstract void II0xO0(Canvas canvas);

    public boolean OOXIXo(OOXIxO0.X0o0xo x0o0xo) {
        if (x0o0xo.getData().IXxxXO() < x0o0xo.getMaxVisibleCount() * this.f34563oIX0oI.xoXoI()) {
            return true;
        }
        return false;
    }

    public Paint Oxx0IOOO() {
        return this.f34533oxoX;
    }

    public abstract void X0o0xo(Canvas canvas, String str, float f, float f2, int i);

    public abstract void XO(Canvas canvas);

    public void oIX0oI(IIxOXoOo0.X0o0xo x0o0xo) {
        this.f34532XO.setTypeface(x0o0xo.x0XOIxOo());
        this.f34532XO.setTextSize(x0o0xo.o0oIxOo());
    }

    public abstract void oxoX(Canvas canvas, XI0oooXX.oxoX[] oxoxArr);

    public abstract void xoIox();

    public Paint xxIXOIIO() {
        return this.f34532XO;
    }
}
