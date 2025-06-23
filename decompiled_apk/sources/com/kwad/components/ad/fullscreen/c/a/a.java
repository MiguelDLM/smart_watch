package com.kwad.components.ad.fullscreen.c.a;

import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bs;

/* loaded from: classes11.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements bs.a {
    private l gO = new l() { // from class: com.kwad.components.ad.fullscreen.c.a.a.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (!a.this.hi) {
                a.this.hh.sendEmptyMessageDelayed(1, 500L);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            if (!a.this.qp.oK.jN()) {
                a.this.a(j, j2);
                a.this.hj = j2;
            } else if (j2 > 800) {
                a.this.hj = j2;
                if (a.this.hj > j) {
                    a.this.hf.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) a.this.hg.getLayoutParams();
                    marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(a.this.getContext(), 0.0f);
                    a.this.hg.setLayoutParams(marginLayoutParams);
                }
                a.this.a(j, j2);
                a.a(a.this, true);
            }
        }
    };
    private TextView hf;
    private View hg;
    private bs hh;
    private boolean hi;
    private long hj;
    private AdInfo mAdInfo;

    private void ca() {
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(this.qp.mAdTemplate);
        this.mAdInfo = dS;
        this.hf.setText(String.valueOf(com.kwad.sdk.core.response.b.a.L(dS)));
        this.hf.setVisibility(0);
        this.qp.oK.a(this.gO);
    }

    private void x(int i) {
        this.hf.setText(String.valueOf(i));
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.hh = new bs(this);
        ca();
        if (this.qp.oK.jN()) {
            x(30);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.hf = (TextView) findViewById(R.id.ksad_video_count_down);
        this.hg = findViewById(R.id.ksad_video_sound_switch);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qp.oK.b(this.gO);
        this.hi = false;
        this.hh.removeCallbacksAndMessages(null);
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.hi = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        x(Math.max((int) ((((float) (j - j2)) / 1000.0f) + 0.5f), 0));
    }

    @Override // com.kwad.sdk.utils.bs.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (!this.qp.fN() && !this.qp.fM()) {
                long j = this.hj + 500;
                this.hj = j;
                if (j > 30000) {
                    this.hf.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hg.getLayoutParams();
                    marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(getContext(), 0.0f);
                    this.hg.setLayoutParams(marginLayoutParams);
                    return;
                }
                a(30000L, j);
                this.hh.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.hh.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
