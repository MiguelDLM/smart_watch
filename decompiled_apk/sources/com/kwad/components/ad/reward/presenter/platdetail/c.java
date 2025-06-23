package com.kwad.components.ad.reward.presenter.platdetail;

import android.graphics.Color;
import android.view.View;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.widget.f;

/* loaded from: classes11.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements com.kwad.sdk.widget.c {
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;

    /* JADX INFO: Access modifiers changed from: private */
    public void K(boolean z) {
        int i;
        if (z) {
            i = 85;
        } else {
            i = 153;
        }
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", "videoPlayer", new com.kwad.sdk.core.adlog.c.b().cK(i).f(this.qp.mRootContainer.getTouchCoords()), this.qp.mReportExtData);
        this.qp.oJ.bJ();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        String str;
        super.aj();
        this.mApkDownloadHelper = this.qp.mApkDownloadHelper;
        new f(this.mDetailVideoView, this);
        if (com.kwad.sdk.core.response.b.a.aX(e.dS(this.mAdTemplate))) {
            str = "#B3000000";
        } else {
            str = "#4D000000";
        }
        this.mDetailVideoView.setBackgroundColor(Color.parseColor(str));
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (d.dH(this.mAdTemplate)) {
            b(view, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mDetailVideoView.setClickListener(null);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }

    private void b(View view, final boolean z) {
        com.kwad.components.core.e.d.a.a(new a.C0788a(view.getContext()).ar(this.mAdTemplate).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.c.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                c.this.K(z);
            }
        }).b(this.mApkDownloadHelper).ao(false).v(this.qp.pn).an(3));
    }
}
