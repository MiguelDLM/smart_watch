package xOOOX;

import IIxOXoOo0.OOXIXo;
import XIXIX.oOoXoXO;
import android.graphics.Canvas;
import android.graphics.Paint;

/* loaded from: classes9.dex */
public class oIX0oI implements X0o0xo {
    @Override // xOOOX.X0o0xo
    public void oIX0oI(Canvas canvas, OOXIXo oOXIXo, oOoXoXO oooxoxo, float f, float f2, Paint paint) {
        float oO2 = oOXIXo.oO() / 2.0f;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(XIXIX.OOXIXo.X0o0xo(1.0f));
        float f3 = oO2 * 2.0f;
        float f4 = f2 + f3;
        canvas.drawLine(f, f4, f + f3, f2, paint);
        canvas.drawLine(f, f4, f - f3, f2, paint);
    }
}
