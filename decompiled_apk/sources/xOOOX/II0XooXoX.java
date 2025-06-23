package xOOOX;

import IIxOXoOo0.OOXIXo;
import XIXIX.oOoXoXO;
import android.graphics.Canvas;
import android.graphics.Paint;

/* loaded from: classes9.dex */
public class II0XooXoX implements X0o0xo {
    @Override // xOOOX.X0o0xo
    public void oIX0oI(Canvas canvas, OOXIXo oOXIXo, oOoXoXO oooxoxo, float f, float f2, Paint paint) {
        float oO2 = oOXIXo.oO() / 2.0f;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(XIXIX.OOXIXo.X0o0xo(1.0f));
        float f3 = f - oO2;
        float f4 = f2 - oO2;
        float f5 = f + oO2;
        float f6 = oO2 + f2;
        canvas.drawLine(f3, f4, f5, f6, paint);
        canvas.drawLine(f5, f4, f3, f6, paint);
    }
}
