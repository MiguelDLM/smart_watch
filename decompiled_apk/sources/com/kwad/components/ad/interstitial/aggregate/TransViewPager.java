package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes11.dex */
public class TransViewPager extends com.kwad.sdk.widget.d {
    private float iY;

    @SlideType
    private int iZ;
    private Map<Integer, com.kwad.components.ad.interstitial.g.c> map;

    public TransViewPager(@NonNull Context context) {
        this(context, null);
    }

    private void a(View view, View view2, float f) {
        if (this.iZ == 0 && f != 0.0f) {
            float f2 = this.iY;
            if (f2 != 0.0f) {
                if (f > f2) {
                    this.iZ = 1;
                } else {
                    this.iZ = 2;
                }
            }
        }
        if (this.iZ == 1 && view2 != null) {
            if (f <= 0.5d && f > 0.0f) {
                view2.setTranslationX(240.0f * f);
            } else {
                view2.setTranslationX((1.0f - f) * 240.0f);
            }
        }
        if (this.iZ == 2 && view != null) {
            if (f <= 0.5d && f >= 0.0f) {
                view.setTranslationX((-240.0f) * f);
            } else {
                view.setTranslationX((1.0f - f) * (-240.0f));
            }
        }
        this.iY = f;
        if (f == 0.0f) {
            this.iZ = 0;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void onPageScrolled(int i, float f, int i2) {
        a(y(i), y(i + 1), f);
        super.onPageScrolled(i, f, i2);
    }

    public final com.kwad.components.ad.interstitial.g.c y(int i) {
        return this.map.get(Integer.valueOf(i));
    }

    public TransViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.map = new HashMap();
        this.iZ = 0;
    }

    public final void a(int i, com.kwad.components.ad.interstitial.g.c cVar) {
        this.map.put(Integer.valueOf(i), cVar);
    }
}
