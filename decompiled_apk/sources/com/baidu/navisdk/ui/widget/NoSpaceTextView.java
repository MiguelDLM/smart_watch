package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.navisdk.module.cloudconfig.f;

/* loaded from: classes8.dex */
public class NoSpaceTextView extends TextView {
    private final boolean isEnable;
    private boolean refreshMeasure;

    public NoSpaceTextView(Context context) {
        super(context);
        this.refreshMeasure = false;
        boolean z = f.c().A.f7118a;
        this.isEnable = z;
        setIncludeFontPadding(z);
    }

    private String[] getLinesText() {
        String[] strArr = new String[getLineCount()];
        String charSequence = getText().toString();
        Layout layout = getLayout();
        int i = 0;
        int i2 = 0;
        while (i < getLineCount()) {
            int lineEnd = layout.getLineEnd(i);
            strArr[i] = charSequence.substring(i2, lineEnd);
            i++;
            i2 = lineEnd;
        }
        return strArr;
    }

    private void removeSpace(int i, int i2) {
        String[] linesText = getLinesText();
        TextPaint paint = getPaint();
        Rect rect = new Rect();
        String str = linesText[0];
        paint.getTextBounds(str, 0, str.length(), rect);
        Paint.FontMetricsInt fontMetricsInt = new Paint.FontMetricsInt();
        paint.getFontMetricsInt(fontMetricsInt);
        setPadding(getLeftPaddingOffset(), (fontMetricsInt.top - rect.top) + getTopPaddingOffset(), getRightPaddingOffset(), getBottomPaddingOffset());
        String str2 = linesText[linesText.length - 1];
        paint.getTextBounds(str2, 0, str2.length(), rect);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() - (fontMetricsInt.bottom - rect.bottom));
        if (this.refreshMeasure) {
            this.refreshMeasure = false;
            measure(i, i2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.isEnable) {
            removeSpace(i, i2);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        this.refreshMeasure = true;
    }

    public NoSpaceTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.refreshMeasure = false;
        boolean z = f.c().A.f7118a;
        this.isEnable = z;
        setIncludeFontPadding(z);
    }

    public NoSpaceTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.refreshMeasure = false;
        boolean z = f.c().A.f7118a;
        this.isEnable = z;
        setIncludeFontPadding(z);
    }
}
