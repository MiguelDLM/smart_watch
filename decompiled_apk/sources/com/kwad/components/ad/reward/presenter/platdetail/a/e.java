package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.aj;

/* loaded from: classes11.dex */
public final class e extends com.kwad.components.ad.reward.presenter.b implements j {
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.e.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            e.this.it();
        }
    };
    private View vw;
    private View vx;
    private ImageView vy;

    public e() {
        a(new com.kwad.components.ad.reward.presenter.platdetail.a());
        a(new com.kwad.components.ad.reward.presenter.d.a());
    }

    private void is() {
        if (!this.qp.pb) {
            this.vx.setVisibility(8);
        }
        this.vw.setVisibility(0);
        getContext();
        if (com.kwad.components.ad.reward.g.F(this.qp.mAdTemplate) && aj.ML()) {
            this.vy.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.vw.setVisibility(0);
        this.vx.setVisibility(8);
        this.qp.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.eY().a(this);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bY() {
        is();
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bZ() {
        it();
    }

    public final void it() {
        if (this.qp.pb) {
            this.vw.setVisibility(8);
        } else {
            this.vw.setVisibility(8);
            this.vx.setVisibility(0);
        }
        getContext();
        if (com.kwad.components.ad.reward.g.F(this.qp.mAdTemplate) && aj.ML()) {
            this.vy.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vw = findViewById(R.id.ksad_play_detail_top_toolbar);
        this.vx = findViewById(R.id.ksad_play_end_top_toolbar);
        this.vy = (ImageView) findViewById(R.id.ksad_blur_end_cover);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        is();
        this.qp.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.eY().b(this);
        this.vx.setVisibility(8);
    }
}
