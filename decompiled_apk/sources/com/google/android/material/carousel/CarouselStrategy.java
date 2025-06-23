package com.google.android.material.carousel;

import XIXIX.OOXIXo;
import android.content.Context;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

/* loaded from: classes9.dex */
public abstract class CarouselStrategy {
    private float smallSizeMax;
    private float smallSizeMin;

    public static int[] doubleCounts(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            iArr2[i] = iArr[i] * 2;
        }
        return iArr2;
    }

    @FloatRange(from = OOXIXo.f3760XO, to = 1.0d)
    public static float getChildMaskPercentage(float f, float f2, float f3) {
        return 1.0f - ((f - f3) / (f2 - f3));
    }

    public float getSmallItemSizeMax() {
        return this.smallSizeMax;
    }

    public float getSmallItemSizeMin() {
        return this.smallSizeMin;
    }

    public void initialize(Context context) {
        float f = this.smallSizeMin;
        if (f <= 0.0f) {
            f = CarouselStrategyHelper.getSmallSizeMin(context);
        }
        this.smallSizeMin = f;
        float f2 = this.smallSizeMax;
        if (f2 <= 0.0f) {
            f2 = CarouselStrategyHelper.getSmallSizeMax(context);
        }
        this.smallSizeMax = f2;
    }

    public boolean isContained() {
        return true;
    }

    public abstract KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view);

    public void setSmallItemSizeMax(float f) {
        this.smallSizeMax = f;
    }

    public void setSmallItemSizeMin(float f) {
        this.smallSizeMin = f;
    }

    public boolean shouldRefreshKeylineState(Carousel carousel, int i) {
        return false;
    }
}
