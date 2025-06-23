package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.w;

/* loaded from: classes10.dex */
public class ProgressButtonForNarrowBounds extends ProgressButton {
    public ProgressButtonForNarrowBounds(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.ad.views.ProgressButton
    public void Code(int i, int i2) {
        int width;
        int width2;
        synchronized (this.D) {
            try {
                if (this.e) {
                    width = (getWidth() / 2) - this.Code.centerX();
                    if (this.d && width < this.f17432a) {
                        width = getTextStart();
                    }
                    width2 = this.Code.width() + width;
                } else {
                    width = (getWidth() - this.Code.width()) - w.V(getContext(), 1.0f);
                    if (this.d && width < this.f17432a) {
                        width = getTextStart();
                    }
                    width2 = getWidth();
                }
                Drawable drawable = this.F;
                if (drawable != null) {
                    drawable.setBounds(width, 0, width2, i2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.huawei.openalliance.ad.views.ProgressButton
    public int getTextStart() {
        if (bc.C()) {
            return this.c;
        }
        int width = ((getWidth() - this.Code.width()) - this.f) - w.V(getContext(), 8.0f);
        int i = this.b;
        if (width < i) {
            width = i;
        }
        fb.V("ProgressButtonNew", "safeTextStart: %s", Integer.valueOf(width));
        return width;
    }

    public ProgressButtonForNarrowBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.huawei.openalliance.ad.views.ProgressButton
    public void Code(Canvas canvas) {
        int width;
        int height;
        Rect rect;
        synchronized (this.D) {
            try {
                CharSequence charSequence = this.I;
                if (charSequence != null && charSequence.length() > 0) {
                    String intern = this.I.toString().intern();
                    if (this.e) {
                        width = (getWidth() / 2) - this.Code.centerX();
                        if (this.d && width < this.f17432a) {
                            width = getTextStart();
                        }
                        height = getHeight() / 2;
                        rect = this.Code;
                    } else {
                        width = (getWidth() - this.Code.width()) - w.V(getContext(), 1.0f);
                        if (this.d && width < this.f17432a) {
                            width = getTextStart();
                        }
                        height = getHeight() / 2;
                        rect = this.Code;
                    }
                    canvas.drawText((CharSequence) intern, 0, intern.length(), width, height - rect.centerY(), this.V);
                    Code(getWidth(), getHeight());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ProgressButtonForNarrowBounds(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
