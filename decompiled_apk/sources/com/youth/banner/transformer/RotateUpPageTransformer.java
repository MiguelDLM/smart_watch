package com.youth.banner.transformer;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes13.dex */
public class RotateUpPageTransformer extends BasePageTransformer {
    private static final float DEFAULT_MAX_ROTATE = 15.0f;
    private float mMaxRotate;

    public RotateUpPageTransformer() {
        this.mMaxRotate = DEFAULT_MAX_ROTATE;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f) {
        if (f < -1.0f) {
            view.setRotation(this.mMaxRotate);
            view.setPivotX(view.getWidth());
            view.setPivotY(0.0f);
        } else {
            if (f <= 1.0f) {
                if (f < 0.0f) {
                    view.setPivotX(view.getWidth() * (((-f) * 0.5f) + 0.5f));
                    view.setPivotY(0.0f);
                    view.setRotation((-this.mMaxRotate) * f);
                    return;
                } else {
                    view.setPivotX(view.getWidth() * 0.5f * (1.0f - f));
                    view.setPivotY(0.0f);
                    view.setRotation((-this.mMaxRotate) * f);
                    return;
                }
            }
            view.setRotation(-this.mMaxRotate);
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
        }
    }

    public RotateUpPageTransformer(float f) {
        this.mMaxRotate = f;
    }
}
