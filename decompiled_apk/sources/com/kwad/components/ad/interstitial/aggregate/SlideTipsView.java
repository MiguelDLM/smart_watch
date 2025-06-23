package com.kwad.components.ad.interstitial.aggregate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.n.l;

/* loaded from: classes11.dex */
public class SlideTipsView extends FrameLayout {
    public SlideTipsView(@NonNull Context context) {
        this(context, null);
    }

    public SlideTipsView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"CustomViewStyleable"})
    public SlideTipsView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_SlideTipsView, i, 0);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.ksad_SlideTipsView_ksad_is_left_slide, true);
        obtainStyledAttributes.recycle();
        if (z) {
            i2 = R.layout.ksad_interstitial_left_slide_to_next;
        } else {
            i2 = R.layout.ksad_interstitial_right_slide_to_return;
        }
        l.inflate(context, i2, this);
    }
}
