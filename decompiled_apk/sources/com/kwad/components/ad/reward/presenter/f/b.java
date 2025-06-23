package com.kwad.components.ad.reward.presenter.f;

import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.b.x;
import com.kwad.sdk.R;
import com.kwad.sdk.components.r;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public class b extends d {
    private FrameLayout wh;
    private boolean wi = false;

    private void T(boolean z) {
        int i;
        FrameLayout frameLayout = this.wh;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        frameLayout.setVisibility(i);
    }

    private com.kwad.components.core.webview.tachikoma.c dC() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.reward.presenter.f.b.1
            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.b.c cVar2 = new com.kwad.components.core.webview.tachikoma.b.c();
                cVar2.aaS = com.kwad.components.ad.reward.model.b.cO();
                cVar.a(cVar2);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (!this.wi) {
            T(true);
        }
    }

    @IdRes
    public int ci() {
        return R.id.ksad_js_reward_card;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.wh;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTKReaderScene() {
        return "tk_live_video";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dp(this.qp.mAdTemplate);
    }

    public final BackPressHandleResult go() {
        com.kwad.components.ad.reward.k.a.d dVar = this.wl;
        if (dVar == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        return dVar.go();
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d
    public final boolean iN() {
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wh = (FrameLayout) findViewById(ci());
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(r rVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(rVar, bVar);
        rVar.c(dC());
        rVar.c(new com.kwad.components.core.webview.tachikoma.b(new b.a() { // from class: com.kwad.components.ad.reward.presenter.f.b.2
            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void dM() {
                com.kwad.components.ad.reward.model.b.I(b.this.qp.mContext);
            }
        }));
        rVar.c(new v() { // from class: com.kwad.components.ad.reward.presenter.f.b.3
            @Override // com.kwad.components.core.webview.jshandler.v
            public final void a(x xVar) {
                super.a(xVar);
                b.this.qp.oJ.onVideoPlayStart();
                com.kwad.components.ad.reward.monitor.c.b(b.this.qp.oZ, b.this.qp.mAdTemplate, b.this.qp.mPageEnterTime);
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void b(x xVar) {
                super.b(xVar);
                long ty = xVar.ty();
                b.this.qp.oJ.onVideoPlayError(xVar.errorCode, (int) ty);
                com.kwad.components.ad.reward.monitor.c.a(b.this.qp.oZ, b.this.qp.mAdTemplate, b.this.qp.pw, xVar.errorCode, ty);
                com.kwad.components.ad.reward.monitor.b.c(b.this.qp.oZ, b.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void c(x xVar) {
                super.c(xVar);
                b.this.qp.oJ.onVideoPlayEnd();
                b.this.qp.mAdTemplate.setmCurPlayTime(-1L);
                com.kwad.components.ad.reward.presenter.f.s(b.this.qp);
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void d(x xVar) {
                super.d(xVar);
                b.this.qp.mAdTemplate.setmCurPlayTime(xVar.nF);
            }
        });
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aW = com.kwad.sdk.c.a.a.aW(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / aW) + 0.5f);
        aVar.height = (int) ((screenHeight / aW) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(final t tVar) {
        com.kwad.sdk.core.e.c.d("TKLivePresenter", "onSkipClick: " + tVar.WF);
        bo.postOnUiThread(new az() { // from class: com.kwad.components.ad.reward.presenter.f.b.4
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                if (b.this.qp != null && b.this.qp.oJ != null) {
                    b.this.qp.oJ.onVideoSkipToEnd(tVar.WF * 1000);
                }
                com.kwad.components.ad.reward.presenter.f.s(b.this.qp);
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.b.a(this.mAdTemplate, tKRenderFailReason);
        this.wi = true;
        T(false);
    }
}
