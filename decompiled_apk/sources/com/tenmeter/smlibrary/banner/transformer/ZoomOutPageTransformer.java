package com.tenmeter.smlibrary.banner.transformer;

import android.view.View;

/* loaded from: classes13.dex */
public class ZoomOutPageTransformer extends BasePageTransformer {
    private static final float DEFAULT_MIN_ALPHA = 0.5f;
    private static final float DEFAULT_MIN_SCALE = 0.85f;
    private float mMinAlpha;
    private float mMinScale;

    public ZoomOutPageTransformer() {
        this.mMinScale = DEFAULT_MIN_SCALE;
        this.mMinAlpha = 0.5f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (f < -1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        if (f <= 1.0f) {
            float max = Math.max(this.mMinScale, 1.0f - Math.abs(f));
            float f2 = 1.0f - max;
            float f3 = (height * f2) / 2.0f;
            float f4 = (width * f2) / 2.0f;
            if (f < 0.0f) {
                view.setTranslationX(f4 - (f3 / 2.0f));
            } else {
                view.setTranslationX((-f4) + (f3 / 2.0f));
            }
            view.setScaleX(max);
            view.setScaleY(max);
            float f5 = this.mMinAlpha;
            float f6 = this.mMinScale;
            view.setAlpha(f5 + (((max - f6) / (1.0f - f6)) * (1.0f - f5)));
            return;
        }
        view.setAlpha(0.0f);
    }

    public ZoomOutPageTransformer(float f, float f2) {
        this.mMinScale = f;
        this.mMinAlpha = f2;
    }
}
