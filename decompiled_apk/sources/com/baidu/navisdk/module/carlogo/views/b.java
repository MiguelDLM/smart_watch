package com.baidu.navisdk.module.carlogo.views;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes7.dex */
public final class b implements ViewPager.PageTransformer {

    /* renamed from: a, reason: collision with root package name */
    private ViewPager f7088a;

    public b(ViewPager viewPager) {
        this.f7088a = viewPager;
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(@NonNull View view, float f) {
        float abs = 1.0f - Math.abs(((((view.getLeft() - this.f7088a.getScrollX()) + (view.getMeasuredWidth() / 2)) - (this.f7088a.getMeasuredWidth() / 2)) * 0.7f) / this.f7088a.getMeasuredWidth());
        if (abs > 0.0f) {
            view.setScaleX(abs);
            view.setScaleY(abs);
        }
    }
}
