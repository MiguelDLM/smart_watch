package com.tenmeter.smlibrary.banner.transformer;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes13.dex */
public class RotateYTransformer extends BasePageTransformer {
    private static final float DEFAULT_MAX_ROTATE = 35.0f;
    private float mMaxRotate;

    public RotateYTransformer() {
        this.mMaxRotate = DEFAULT_MAX_ROTATE;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f) {
        view.setPivotY(view.getHeight() / 2);
        if (f < -1.0f) {
            view.setRotationY(this.mMaxRotate * (-1.0f));
            view.setPivotX(view.getWidth());
            return;
        }
        if (f <= 1.0f) {
            view.setRotationY(this.mMaxRotate * f);
            if (f < 0.0f) {
                view.setPivotX(view.getWidth() * (((-f) * 0.5f) + 0.5f));
                view.setPivotX(view.getWidth());
                return;
            } else {
                view.setPivotX(view.getWidth() * 0.5f * (1.0f - f));
                view.setPivotX(0.0f);
                return;
            }
        }
        view.setRotationY(this.mMaxRotate * 1.0f);
        view.setPivotX(0.0f);
    }

    public RotateYTransformer(float f) {
        this.mMaxRotate = f;
    }
}
