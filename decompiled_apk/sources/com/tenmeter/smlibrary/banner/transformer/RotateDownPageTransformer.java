package com.tenmeter.smlibrary.banner.transformer;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes13.dex */
public class RotateDownPageTransformer extends BasePageTransformer {
    private static final float DEFAULT_MAX_ROTATE = 15.0f;
    private float mMaxRotate;

    public RotateDownPageTransformer() {
        this.mMaxRotate = DEFAULT_MAX_ROTATE;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f) {
        if (f < -1.0f) {
            view.setRotation(this.mMaxRotate * (-1.0f));
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight());
        } else {
            if (f <= 1.0f) {
                if (f < 0.0f) {
                    view.setPivotX(view.getWidth() * (((-f) * 0.5f) + 0.5f));
                    view.setPivotY(view.getHeight());
                    view.setRotation(this.mMaxRotate * f);
                    return;
                } else {
                    view.setPivotX(view.getWidth() * 0.5f * (1.0f - f));
                    view.setPivotY(view.getHeight());
                    view.setRotation(this.mMaxRotate * f);
                    return;
                }
            }
            view.setRotation(this.mMaxRotate);
            view.getWidth();
            view.setPivotX(0);
            view.setPivotY(view.getHeight());
        }
    }

    public RotateDownPageTransformer(float f) {
        this.mMaxRotate = f;
    }
}
