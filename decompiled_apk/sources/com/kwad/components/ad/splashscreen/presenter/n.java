package com.kwad.components.ad.splashscreen.presenter;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class n extends e {
    private AdMatrixInfo.SplashSlideInfo DO;
    private TextView DP;
    private ImageView DQ;
    private com.kwad.components.ad.splashscreen.widget.d DR;
    private KsSplashSlidePathView DS;
    private com.kwad.components.core.e.d.c DT;
    private double DU;
    private com.kwad.components.ad.splashscreen.e.a Dy;
    private TextView hz;
    private AdInfo mAdInfo;
    private long mStartTime;

    private void initView() {
        AdMatrixInfo.SplashSlideInfo splashSlideInfo = this.mAdInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo;
        this.DO = splashSlideInfo;
        this.DU = splashSlideInfo.convertDistance;
        int i = splashSlideInfo.style;
        com.kwad.components.ad.splashscreen.widget.d dVar = new com.kwad.components.ad.splashscreen.widget.d(getContext(), i);
        this.DR = dVar;
        this.DQ.setImageDrawable(dVar);
        this.DQ.post(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.n.3
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                n.this.lu();
                if (n.this.DR != null) {
                    n.this.DR.start();
                }
            }
        });
        if (!TextUtils.isEmpty(this.DO.title)) {
            this.hz.setText(this.DO.title);
        } else if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.hz.setText("向右滑动");
                }
            } else {
                this.hz.setText("向左滑动");
            }
        } else {
            this.hz.setText("向上滑动");
        }
        if (!TextUtils.isEmpty(this.DO.subtitle)) {
            this.DP.setText(this.DO.subtitle);
        } else if (com.kwad.sdk.core.response.b.a.aE(this.mAdInfo)) {
            this.DP.setText(com.kwad.components.ad.splashscreen.d.a(this.Di.mAdTemplate, this.mAdInfo, this.DT.ov(), 0));
        } else {
            this.DP.setText("跳转详情页或者第三方应用");
        }
    }

    private void lt() {
        com.kwad.components.ad.splashscreen.e.a aVar = this.Dy;
        if (aVar == null) {
            com.kwad.components.ad.splashscreen.e.a aVar2 = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.Di.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.n.4
                {
                    super(r3);
                }

                @Override // com.kwad.components.ad.splashscreen.e.a
                public final void k(int i, String str) {
                    n.this.DP.setText(str);
                }
            };
            this.Dy = aVar2;
            this.DT.b(aVar2);
            return;
        }
        aVar.setAdTemplate(this.Di.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lu() {
        if (this.DO != null) {
            com.kwad.sdk.core.adlog.c.d(this.Di.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cU(this.DO.style).cM(190));
            com.kwad.components.core.webview.tachikoma.d.a.tC().aW(190);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (this.Di == null) {
            return;
        }
        bo.postOnUiThread(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.n.2
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                n.this.Di.CJ = SystemClock.elapsedRealtime() - n.this.mStartTime;
            }
        });
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate);
        this.DT = this.Di.mApkDownloadHelper;
        initView();
        if (com.kwad.sdk.core.response.b.a.aE(this.mAdInfo)) {
            lt();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mStartTime = SystemClock.elapsedRealtime();
        ((ViewStub) findViewById(R.id.ksad_slide_layout)).inflate();
        this.hz = (TextView) findViewById(R.id.ksad_splash_slide_title);
        this.DP = (TextView) findViewById(R.id.ksad_splash_slide_actiontext);
        this.DQ = (ImageView) findViewById(R.id.ksad_splash_slideView);
        KsSplashSlidePathView ksSplashSlidePathView = (KsSplashSlidePathView) ((ViewStub) findViewById(R.id.ksad_splash_slideTouchView)).inflate();
        this.DS = ksSplashSlidePathView;
        ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.n.1
            @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
            public final void a(float f, float f2, float f3, float f4) {
                n nVar;
                com.kwad.components.ad.splashscreen.h hVar;
                final float px2dip = com.kwad.sdk.c.a.a.px2dip(n.this.getContext(), (float) Math.sqrt(Math.pow(f3 - f, 2.0d) + Math.pow(f4 - f2, 2.0d)));
                if (px2dip >= n.this.DU && (hVar = (nVar = n.this).Di) != null) {
                    hVar.a(1, nVar.getContext(), 153, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.n.1.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                            bVar.cU(n.this.DO.style);
                            bVar.cV((int) px2dip);
                        }
                    });
                }
            }

            @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
            public final void lv() {
                n nVar;
                com.kwad.components.ad.splashscreen.h hVar;
                if (com.kwad.components.ad.splashscreen.h.n(n.this.mAdInfo) && (hVar = (nVar = n.this).Di) != null) {
                    hVar.c(1, nVar.getContext(), 53, 2);
                }
            }
        });
    }
}
