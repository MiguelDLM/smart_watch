package com.kwad.components.ad.reward.presenter.f;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.k.l;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.i.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.r;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public class f extends a implements j, a.InterfaceC0793a {
    private com.kwad.components.core.webview.tachikoma.e lh;
    private List<com.kwad.components.core.i.c> to;
    protected FrameLayout wh;
    private boolean wi = false;
    private final com.kwad.components.core.webview.tachikoma.e.a oW = new com.kwad.components.core.webview.tachikoma.e.a() { // from class: com.kwad.components.ad.reward.presenter.f.f.1
        @Override // com.kwad.components.core.webview.tachikoma.e.a
        public final void jb() {
            if (f.this.lh != null) {
                com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
                aVar.aaQ = f.this.qp.fP ? 1 : 0;
                f.this.lh.b(aVar);
            }
        }
    };

    private void V(boolean z) {
        int i;
        com.kwad.sdk.core.e.c.d("TkRewardPagePresenter", "fullTK: " + z);
        FrameLayout frameLayout = this.wh;
        if (frameLayout == null) {
            return;
        }
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        frameLayout.setVisibility(i);
    }

    private com.kwad.components.core.webview.tachikoma.c dC() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.reward.presenter.f.f.6
            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.b.c cVar2 = new com.kwad.components.core.webview.tachikoma.b.c();
                cVar2.aaS = com.kwad.components.ad.reward.model.b.cO();
                cVar.a(cVar2);
            }
        };
    }

    private com.kwad.components.core.webview.tachikoma.e dD() {
        return new com.kwad.components.core.webview.tachikoma.e() { // from class: com.kwad.components.ad.reward.presenter.f.f.5
            @Override // com.kwad.components.core.webview.tachikoma.e, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
                aVar.aaQ = f.this.qp.fP ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (!this.wi) {
            V(true);
        }
        com.kwad.components.ad.reward.g gVar = this.qp;
        gVar.pa = true ^ this.wi;
        gVar.a((a.InterfaceC0793a) this);
        com.kwad.components.ad.reward.a.eY().a(this);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bY() {
        FrameLayout frameLayout;
        if (!this.wi && (frameLayout = this.wh) != null) {
            frameLayout.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bZ() {
    }

    @IdRes
    public int ci() {
        return R.id.ksad_js_reward_card;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.wh;
    }

    public String getTKReaderScene() {
        return "tk_reward";
    }

    public String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.m275do(this.qp.mAdTemplate);
    }

    public final BackPressHandleResult go() {
        com.kwad.components.ad.reward.k.a.d dVar = this.wl;
        if (dVar == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        return dVar.go();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wh = (FrameLayout) findViewById(ci());
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0793a
    public final void onError(int i, String str) {
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0793a
    public final void onRequestResult(int i) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qp.b((a.InterfaceC0793a) this);
        com.kwad.components.ad.reward.a.eY().b(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        if (aVar != null && !com.kwad.sdk.core.response.b.e.b(this.qp.mAdResultData.getProceedTemplateList(), aVar.creativeId, aVar.adStyle)) {
            if (aVar.adTemplate != null && !aVar.aGc) {
                this.qp.oJ.bJ();
                return;
            }
            com.kwad.components.core.i.c a2 = com.kwad.components.ad.reward.g.a(this.to, aVar.creativeId);
            if (a2 != null) {
                this.qp.a(a2);
                return;
            }
            return;
        }
        this.qp.oJ.bJ();
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0793a
    public final void e(@Nullable List<com.kwad.components.core.i.c> list) {
        if (list == null || list.size() == 0 || this.wl == null) {
            return;
        }
        this.to = list;
        List<AdTemplate> a2 = a(list, this.qp.mAdTemplate);
        com.kwad.sdk.core.webview.b th = this.wl.th();
        if (th != null) {
            th.setAdTemplateList(a2);
        }
        l jp = this.wl.jp();
        if (jp != null) {
            jp.g(a2);
        } else {
            this.wl.h(a2);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.b.a(this.mAdTemplate, tKRenderFailReason);
        com.kwad.sdk.core.e.c.d("TkRewardPagePresenter", "onTkLoadFailed");
        this.wi = true;
        this.qp.pa = false;
        V(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.a, com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(r rVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(rVar, bVar);
        rVar.c(new com.kwad.components.ad.reward.c.f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.presenter.f.f.2
            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar2) {
                com.kwad.sdk.core.e.c.d("TkRewardPagePresenter", "onUpdateExtraReward : " + bVar2.gP());
                f.this.a(bVar2);
            }
        }));
        this.lh = dD();
        this.qp.a(this.oW);
        rVar.c(this.lh);
        rVar.c(new com.kwad.components.core.webview.tachikoma.b(new b.a() { // from class: com.kwad.components.ad.reward.presenter.f.f.3
            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void dM() {
                com.kwad.components.ad.reward.model.b.I(f.this.qp.mContext);
            }
        }));
        rVar.c(dC());
        rVar.c(new com.kwad.components.core.webview.jshandler.h(new n() { // from class: com.kwad.components.ad.reward.presenter.f.f.4
            @Override // com.kwad.components.core.webview.jshandler.n
            public final void a(com.kwad.components.core.webview.jshandler.h hVar, String str) {
                boolean z;
                if (TextUtils.equals(str, "autoCallApp")) {
                    if (com.kwad.components.ad.reward.g.g(com.kwad.sdk.core.response.b.e.dS(f.this.qp.mAdTemplate)) && com.kwad.sdk.core.d.a.Eq() && f.this.qp.mScreenOrientation == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    hVar.aT(z);
                }
            }
        }));
    }

    private static List<AdTemplate> a(List<com.kwad.components.core.i.c> list, AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(adTemplate);
        arrayList.addAll(com.kwad.components.core.i.c.m(list));
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
        FrameLayout frameLayout;
        if (this.wi || (frameLayout = this.wh) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
        com.kwad.components.ad.reward.e.b bVar;
        com.kwad.sdk.core.e.c.d("TkRewardPagePresenter", "onSkipClick: " + tVar.WF);
        com.kwad.components.ad.reward.g gVar = this.qp;
        if (gVar != null && (bVar = gVar.oJ) != null) {
            bVar.onVideoSkipToEnd(tVar.WF * 1000);
        }
        com.kwad.components.ad.reward.presenter.f.s(this.qp);
        com.kwad.components.ad.reward.g.a(this.qp.oS, new com.kwad.sdk.f.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.f.7
            private static void c(com.kwad.components.ad.reward.k.a aVar) {
                aVar.iM();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(com.kwad.components.ad.reward.k.a aVar) {
                c(aVar);
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
    }
}
