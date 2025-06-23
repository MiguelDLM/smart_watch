package com.kwad.sdk.widget;

import android.animation.ValueAnimator;

/* loaded from: classes11.dex */
public final class a {
    public static ValueAnimator ofArgb(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iArr);
        valueAnimator.setEvaluator(b.OD());
        return valueAnimator;
    }
}
