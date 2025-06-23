package com.kwad.components.ad.reward.widget.tailframe;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;

/* loaded from: classes11.dex */
public class TailFrameBarH5View extends LinearLayout {
    protected TextView dL;
    protected TextView dM;
    protected ValueAnimator jo;

    public TailFrameBarH5View(Context context) {
        this(context, null, 0);
    }

    private void f(Context context, int i) {
        l.inflate(context, i, this);
        this.dL = (TextView) findViewById(R.id.ksad_tf_h5_ad_desc);
        this.dM = (TextView) findViewById(R.id.ksad_tf_h5_open_btn);
    }

    private void km() {
        if (this.jo != null) {
            kn();
            this.jo.start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.jo = ofFloat;
        ofFloat.setDuration(1200L);
        this.jo.setRepeatCount(-1);
        this.jo.setRepeatMode(1);
        this.jo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.tailframe.TailFrameBarH5View.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5View.this.dM.setScaleY(floatValue);
                TailFrameBarH5View.this.dM.setScaleX(floatValue);
            }
        });
        this.jo.start();
    }

    public final void b(@NonNull AdTemplate adTemplate) {
        AdInfo dS = e.dS(adTemplate);
        this.dL.setText(com.kwad.sdk.core.response.b.a.at(dS));
        this.dM.setText(com.kwad.sdk.core.response.b.a.aD(dS));
        km();
    }

    public final void g(boolean z, boolean z2) {
        int i;
        if (z) {
            if (z2) {
                i = R.layout.ksad_video_tf_bar_h5_portrait_vertical;
            } else {
                i = R.layout.ksad_video_tf_bar_h5_portrait_horizontal;
            }
        } else {
            i = R.layout.ksad_video_tf_bar_h5_landscape;
        }
        f(getContext(), i);
    }

    public TextView getH5OpenBtn() {
        return this.dM;
    }

    public final void kn() {
        ValueAnimator valueAnimator = this.jo;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.jo.cancel();
            this.jo.end();
        }
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
