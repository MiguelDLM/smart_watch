package xOOOX;

import IIxOXoOo0.OOXIXo;
import XIXIX.oOoXoXO;
import android.graphics.Canvas;
import android.graphics.Paint;

/* loaded from: classes9.dex */
public class XO implements X0o0xo {
    @Override // xOOOX.X0o0xo
    public void oIX0oI(Canvas canvas, OOXIXo oOXIXo, oOoXoXO oooxoxo, float f, float f2, Paint paint) {
        float oO2 = oOXIXo.oO();
        float f3 = oO2 / 2.0f;
        float X0o0xo2 = XIXIX.OOXIXo.X0o0xo(oOXIXo.XI());
        float f4 = (oO2 - (X0o0xo2 * 2.0f)) / 2.0f;
        float f5 = f4 / 2.0f;
        int IIxOXoOo02 = oOXIXo.IIxOXoOo0();
        if (oO2 > XIXIX.OOXIXo.f3760XO) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(f4);
            float f6 = f - X0o0xo2;
            float f7 = f2 - X0o0xo2;
            float f8 = f + X0o0xo2;
            float f9 = f2 + X0o0xo2;
            canvas.drawRect(f6 - f5, f7 - f5, f8 + f5, f9 + f5, paint);
            if (IIxOXoOo02 != 1122867) {
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(IIxOXoOo02);
                canvas.drawRect(f6, f7, f8, f9, paint);
                return;
            }
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(f - f3, f2 - f3, f + f3, f2 + f3, paint);
    }
}
