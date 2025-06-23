package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.sdk.R;

/* loaded from: classes11.dex */
public final class a extends com.kwad.components.ad.splashscreen.presenter.e {
    private TextView EA;
    private ViewGroup EB;
    private ViewGroup ED;
    private AnimatorSet Ez;

    private void initView() {
        this.EA = (TextView) findViewById(R.id.ksad_ad_developer_text);
        this.EB = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_view);
        this.ED = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_dialog_root);
    }

    private void lB() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ED, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.EA, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.EB, "scaleX", 0.8f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.EB, "scaleY", 0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.Ez = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        this.Ez.setDuration(300L);
        this.Ez.start();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        lB();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        AnimatorSet animatorSet = this.Ez;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
