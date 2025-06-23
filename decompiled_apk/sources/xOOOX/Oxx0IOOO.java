package xOOOX;

import IIxOXoOo0.OOXIXo;
import XIXIX.oOoXoXO;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/* loaded from: classes9.dex */
public class Oxx0IOOO implements X0o0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Path f34458oIX0oI = new Path();

    @Override // xOOOX.X0o0xo
    public void oIX0oI(Canvas canvas, OOXIXo oOXIXo, oOoXoXO oooxoxo, float f, float f2, Paint paint) {
        float oO2 = oOXIXo.oO();
        float f3 = oO2 / 2.0f;
        float X0o0xo2 = (oO2 - (XIXIX.OOXIXo.X0o0xo(oOXIXo.XI()) * 2.0f)) / 2.0f;
        int IIxOXoOo02 = oOXIXo.IIxOXoOo0();
        paint.setStyle(Paint.Style.FILL);
        Path path = this.f34458oIX0oI;
        path.reset();
        float f4 = f2 - f3;
        path.moveTo(f, f4);
        float f5 = f + f3;
        float f6 = f2 + f3;
        path.lineTo(f5, f6);
        float f7 = f - f3;
        path.lineTo(f7, f6);
        double d = oO2;
        if (d > XIXIX.OOXIXo.f3760XO) {
            path.lineTo(f, f4);
            float f8 = f7 + X0o0xo2;
            float f9 = f6 - X0o0xo2;
            path.moveTo(f8, f9);
            path.lineTo(f5 - X0o0xo2, f9);
            path.lineTo(f, f4 + X0o0xo2);
            path.lineTo(f8, f9);
        }
        path.close();
        canvas.drawPath(path, paint);
        path.reset();
        if (d > XIXIX.OOXIXo.f3760XO && IIxOXoOo02 != 1122867) {
            paint.setColor(IIxOXoOo02);
            path.moveTo(f, f4 + X0o0xo2);
            float f10 = f6 - X0o0xo2;
            path.lineTo(f5 - X0o0xo2, f10);
            path.lineTo(f7 + X0o0xo2, f10);
            path.close();
            canvas.drawPath(path, paint);
            path.reset();
        }
    }
}
