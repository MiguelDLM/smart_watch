package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes11.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private AdInfo mAdInfo;
    private ImageView vm;
    private TextView vn;
    private boolean vo = false;
    private View vp = null;
    private long vq = -1;
    private final l gO = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            if (c.this.vq >= 0) {
                if (j2 > Math.min(Math.min(c.this.vq, com.kwad.sdk.core.response.b.a.af(c.this.mAdInfo)), j)) {
                    c.this.io();
                }
            }
        }
    };
    private final com.kwad.components.ad.reward.e.e hw = new com.kwad.components.ad.reward.e.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.2
        @Override // com.kwad.components.ad.reward.e.e
        public final void ce() {
            c.a(c.this, true);
            c.this.io();
        }
    };

    private void ca() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate);
        this.qp.oK.a(this.gO);
        this.qp.oV.add(this.hw);
        long ae = com.kwad.sdk.core.response.b.a.ae(this.mAdInfo);
        this.vq = ae;
        if (ae == 0) {
            this.vp.setVisibility(0);
        } else {
            this.vp.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void io() {
        if (this.vp.getVisibility() == 0) {
            return;
        }
        this.vp.setAlpha(0.0f);
        this.vp.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.vp.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        ca();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.vp) {
            f.a(this.qp, this.vo);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vm = (ImageView) findViewById(R.id.ksad_detail_close_btn);
        this.vn = (TextView) findViewById(R.id.ksad_top_toolbar_close_tip);
        if (!TextUtils.isEmpty(com.kwad.components.ad.reward.a.b.gr())) {
            this.vn.setText(com.kwad.components.ad.reward.a.b.gr());
            this.vp = this.vn;
        } else {
            if (com.kwad.components.ad.reward.a.b.gq() == 0) {
                this.vm.setImageResource(R.drawable.ksad_page_close);
            } else {
                this.vm.setImageResource(R.drawable.ksad_video_skip_icon);
            }
            this.vp = this.vm;
        }
        this.vp.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qp.oK.b(this.gO);
        this.qp.oV.remove(this.hw);
        this.vp.setVisibility(8);
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.vo = true;
        return true;
    }
}
