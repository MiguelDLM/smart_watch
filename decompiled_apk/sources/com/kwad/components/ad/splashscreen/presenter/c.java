package com.kwad.components.ad.splashscreen.presenter;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bn;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class c extends e implements com.kwad.sdk.core.h.c {
    private TextView Da;
    private com.kwad.components.ad.splashscreen.widget.b Db;
    private AdInfo.AdPreloadInfo Dc;
    private boolean Dd = false;
    private View De;
    private AdInfo se;

    private SplashSkipViewModel kX() {
        SplashSkipViewModel splashSkipViewModel = new SplashSkipViewModel();
        AdInfo adInfo = this.se;
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        int i = adSplashInfo.imageDisplaySecond;
        if (i <= 0) {
            i = 5;
        }
        int min = Math.min(adSplashInfo.videoDisplaySecond, com.kwad.sdk.core.response.b.a.L(adInfo));
        if (com.kwad.sdk.core.response.b.a.bb(this.se)) {
            i = min;
        }
        splashSkipViewModel.skipSecond = i;
        return splashSkipViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kY() {
        com.kwad.components.ad.splashscreen.monitor.a.kU().Z(this.Di.mAdTemplate);
        this.Di.kP();
        JSONObject jSONObject = new JSONObject();
        com.kwad.components.ad.splashscreen.d.a aVar = this.Di.Cr;
        if (aVar != null) {
            try {
                jSONObject.put("duration", aVar.getCurrentPosition());
            } catch (JSONException e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        }
        a.C0845a c0845a = new a.C0845a();
        bn bnVar = this.Di.mTimerHelper;
        if (bnVar != null) {
            c0845a.duration = bnVar.getTime();
        }
        com.kwad.sdk.core.adlog.c.b(this.Di.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cL(1).cT(22).b(c0845a), jSONObject);
    }

    private synchronized void la() {
        if (!this.Dd && this.Db != null) {
            if (com.kwad.sdk.core.response.b.a.cy(this.se) && com.kwad.sdk.core.response.b.a.cz(this.se)) {
                com.kwad.sdk.core.adlog.c.b(this.Di.mAdTemplate, 124, (JSONObject) null);
                this.Dd = true;
            }
        }
    }

    private void t(AdInfo adInfo) {
        int i;
        if (com.kwad.components.ad.splashscreen.e.c.z(adInfo)) {
            i = R.id.ksad_splash_right_top_root;
        } else {
            i = R.id.ksad_splash_left_top_root;
        }
        findViewById(i).setVisibility(0);
    }

    private static boolean u(AdInfo adInfo) {
        if (!com.kwad.sdk.core.response.b.a.cw(adInfo)) {
            return true;
        }
        return false;
    }

    private void v(AdInfo adInfo) {
        int i;
        if (com.kwad.components.ad.splashscreen.e.c.z(adInfo)) {
            i = R.id.ksad_splash_preload_right_tips;
        } else {
            i = R.id.ksad_splash_preload_left_tips;
        }
        this.Da = (TextView) findViewById(i);
        AdInfo.AdPreloadInfo adPreloadInfo = adInfo.adPreloadInfo;
        this.Dc = adPreloadInfo;
        if (adPreloadInfo != null && !bh.isNullString(adPreloadInfo.preloadTips)) {
            this.Da.setVisibility(0);
            this.Da.setText(this.Dc.preloadTips);
        } else {
            this.Da.setVisibility(8);
        }
    }

    private void w(AdInfo adInfo) {
        this.De = findViewById(R.id.ksad_skip_view_area);
        if (com.kwad.sdk.core.response.b.a.cx(adInfo) && adInfo.adSplashInfo.skipButtonPosition == 0) {
            this.De.setVisibility(0);
            this.De.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.presenter.c.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.this.kY();
                }
            });
            this.De.post(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.c.3
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    ((View) c.this.Db).post(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.c.3.1
                        @Override // com.kwad.sdk.utils.az
                        public final void doTask() {
                            int aa = c.this.Db.aa(35);
                            ViewGroup.LayoutParams layoutParams = c.this.De.getLayoutParams();
                            layoutParams.width = aa + com.kwad.sdk.c.a.a.a(c.this.Di.mRootContainer.getContext(), 66.0f);
                            c.this.De.setLayoutParams(layoutParams);
                        }
                    });
                }
            });
            return;
        }
        this.De.setVisibility(8);
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        com.kwad.sdk.core.e.c.d("SkipAdPresenter", "onPageVisible");
        this.Db.B(this.se);
        la();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        com.kwad.sdk.core.e.c.d("SkipAdPresenter", "onPageInvisible");
        this.Db.A(this.se);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    public final void aj() {
        int i;
        int i2;
        super.aj();
        com.kwad.sdk.core.e.c.d("SkipAdPresenter", "onBind");
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate);
        this.se = dS;
        t(dS);
        v(this.se);
        if (u(this.se)) {
            if (com.kwad.components.ad.splashscreen.e.c.z(this.se)) {
                i2 = R.id.ksad_splash_skip_right_view;
            } else {
                i2 = R.id.ksad_splash_skip_left_view;
            }
            this.Db = (com.kwad.components.ad.splashscreen.widget.b) findViewById(i2);
        } else {
            if (com.kwad.components.ad.splashscreen.e.c.z(this.se)) {
                i = R.id.ksad_splash_circle_skip_right_view;
            } else {
                i = R.id.ksad_splash_circle_skip_left_view;
            }
            this.Db = (com.kwad.components.ad.splashscreen.widget.b) findViewById(i);
        }
        this.Db.a(kX(), this.se);
        this.Db.setOnViewListener(new SkipView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.c.1
            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void Y(int i3) {
                c.this.Di.X(i3);
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void lb() {
                c.this.kY();
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void lc() {
                c.this.kZ();
            }
        });
        w(this.se);
        this.Di.Ct.a(this);
    }

    public final void kZ() {
        this.Di.mRootContainer.post(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.c.4
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                if (com.kwad.components.core.e.c.b.nQ()) {
                    c.this.Di.mRootContainer.postDelayed(this, 1000L);
                } else {
                    c.this.Di.kN();
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Di.Ct.b(this);
        this.Db.bf();
    }
}
