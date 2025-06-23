package com.kwad.components.core.e.a;

import android.app.Activity;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.r;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public final class f extends Presenter implements j, com.kwad.sdk.core.h.c {
    private com.kwad.components.core.widget.a.b Kj;
    private a Kt;
    private aw cQ;
    private i gj;
    private AdTemplate mAdTemplate;

    private void ai(boolean z) {
        if (!z) {
            this.Kt.cR();
        }
        bo.runOnUiThread(new az() { // from class: com.kwad.components.core.e.a.f.2
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                f.this.Kt.Kk.nD();
            }
        });
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0809a c0809a) {
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        com.kwad.sdk.core.e.c.d("InstalledActivatePresenter", "onPageVisible");
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sZ();
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        com.kwad.sdk.core.e.c.d("InstalledActivatePresenter", "onPageInvisible");
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.ta();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        a aVar = (a) Kf();
        this.Kt = aVar;
        this.mAdTemplate = aVar.mAdTemplate;
        this.Kj = aVar.Kj;
        this.gj = new i(getContext()) { // from class: com.kwad.components.core.e.a.f.1
            @Override // com.kwad.components.core.webview.tachikoma.i
            public final boolean nJ() {
                return true;
            }
        };
        this.gj.a((Activity) null, com.kwad.sdk.core.response.b.c.dD(this.mAdTemplate), this);
        this.Kj.a(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aW = com.kwad.sdk.c.a.a.aW(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / aW) + 0.5f);
        aVar.height = (int) ((screenHeight / aW) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        com.kwad.sdk.core.e.c.d("InstalledActivatePresenter", "onTkLoadSuccess");
        this.Kt.bv();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.Kt.Ki;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_installed_activate";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.cg(this.mAdTemplate).installedActivateInfo.templateId;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.Kt.Ki;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.gj.jq();
        this.Kj.b(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(m mVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(r rVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        com.kwad.sdk.core.e.c.d("InstalledActivatePresenter", "onTkLoadFailed");
        ai(true);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        com.kwad.sdk.core.e.c.d("InstalledActivatePresenter", "onAdClicked");
        ai(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        ai(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        this.cQ = awVar;
        this.Kt.cQ = awVar;
    }
}
