package com.baidu.ar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;

/* loaded from: classes7.dex */
public class kd extends ReplacementSpan {
    private int CR;

    public kd(int i) {
        this.CR = i;
    }

    private TextPaint a(Paint paint) {
        TextPaint textPaint = new TextPaint(paint);
        int i = this.CR;
        if (i != -1) {
            textPaint.setTextSize(i * textPaint.density);
        }
        return textPaint;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        TextPaint a2 = a(paint);
        Paint.FontMetricsInt fontMetricsInt = a2.getFontMetricsInt();
        canvas.drawText(charSequence, i, i2, f, i4 - (((((fontMetricsInt.ascent + i4) + i4) + fontMetricsInt.descent) / 2) - ((i3 + i5) / 2)), a2);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (int) a(paint).measureText(charSequence, i, i2);
    }
}
