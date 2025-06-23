package com.kwad.components.ad.f.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public final class f extends com.kwad.components.ad.f.a.a implements View.OnClickListener {
    private ImageView dE;
    private TextView dF;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private ViewGroup na;
    private TextView nb;
    private KsAppDownloadListener nc = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.f.b.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            f.this.nb.setText(com.kwad.sdk.core.response.b.a.aD(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            f.this.nb.setText(com.kwad.sdk.core.response.b.a.ca(f.this.mAdTemplate));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            f.this.nb.setText(com.kwad.sdk.core.response.b.a.aD(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            f.this.nb.setText(com.kwad.sdk.core.response.b.a.ab(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
        }
    };

    private void G(int i) {
        long j;
        com.kwad.components.ad.f.c.a aVar;
        a.C0788a b = new a.C0788a(this.na.getContext()).ar(this.mAdTemplate).an(i).b(this.mApkDownloadHelper);
        com.kwad.components.ad.f.a.b bVar = this.mN;
        if (bVar != null && (aVar = bVar.mO) != null) {
            j = aVar.getPlayDuration();
        } else {
            j = 0;
        }
        com.kwad.components.core.e.d.a.a(b.v(j).a(new a.b() { // from class: com.kwad.components.ad.f.b.f.3
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(f.this.mAdTemplate, 2, f.this.mN.mI.getTouchCoords());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ey() {
        KSImageLoader.loadAppIcon(this.dE, com.kwad.sdk.core.response.b.a.cg(this.mAdInfo), this.mAdTemplate, 12);
        this.dF.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
        this.nb.setText(com.kwad.sdk.core.response.b.a.aD(this.mAdInfo));
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this.nc);
        }
        this.na.setOnClickListener(this);
        this.na.setVisibility(0);
    }

    private void notifyAdClick() {
        this.mN.mw.l(this.na);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdTemplate adTemplate = this.mN.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        this.mApkDownloadHelper = this.mN.mApkDownloadHelper;
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.f.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                try {
                    f.this.ey();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    com.kwad.components.core.d.a.reportSdkCaughtException(th);
                }
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mN.mO.b((com.kwad.components.core.video.k) lVar);
        this.na.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.na) {
            G(2);
            notifyAdClick();
        } else if (view == this.nb) {
            G(1);
            notifyAdClick();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.na = (ViewGroup) findViewById(R.id.ksad_video_complete_app_container);
        this.dE = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dF = (TextView) findViewById(R.id.ksad_app_name);
        this.nb = (TextView) findViewById(R.id.ksad_app_download);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.nc);
        }
    }
}
