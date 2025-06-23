package com.kwad.components.core.r.b;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.c;
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
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.components.r;
import com.kwad.sdk.core.webview.c.g;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.widget.e;

/* loaded from: classes11.dex */
public final class a extends Presenter implements j {
    private FrameLayout Tr;
    private aw Ts;
    protected boolean Tt;
    protected com.kwad.components.core.r.a.b Tu;
    private com.kwad.components.core.l.a.a Tv = new com.kwad.components.core.l.a.a() { // from class: com.kwad.components.core.r.b.a.1
        @Override // com.kwad.components.core.l.a.a
        public final void c(c cVar) {
            a.this.rv();
        }

        @Override // com.kwad.components.core.l.a.a
        public final void d(c cVar) {
            a.this.rw();
        }

        @Override // com.kwad.components.core.l.a.a
        public final void fQ() {
        }

        @Override // com.kwad.components.core.l.a.a
        public final void fR() {
            a.this.rx();
        }
    };
    private i gj;

    private void ru() {
        aw awVar = this.Ts;
        if (awVar == null) {
            return;
        }
        if (!this.Tt) {
            awVar.sV();
            this.Ts.sW();
            this.Tt = true;
            return;
        }
        awVar.sZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        ru();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rw() {
        aw awVar = this.Ts;
        if (awVar != null && this.Tt) {
            awVar.ta();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rx() {
        aw awVar = this.Ts;
        if (awVar != null && this.Tt) {
            awVar.sX();
            this.Ts.sY();
            l lVar = this.Tu.Tk;
            if (lVar != null) {
                lVar.callbackDismiss();
            }
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0809a c0809a) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.Tu = (com.kwad.components.core.r.a.b) Kf();
        this.Tr = (FrameLayout) findViewById(R.id.ksad_js_container);
        i iVar = new i(getContext(), 1000, 0);
        this.gj = iVar;
        iVar.a(this.Tu.Th);
        l lVar = this.Tu.Tk;
        if (lVar != null) {
            lVar.a(this.gj);
            this.gj.a(new g() { // from class: com.kwad.components.core.r.b.a.2
                @Override // com.kwad.sdk.core.webview.c.g
                public final void callTKBridge(String str) {
                    l lVar2 = a.this.Tu.Tk;
                    if (lVar2 != null) {
                        lVar2.callTKBridge(str);
                    }
                }
            });
            this.gj.a("hasTKBridge", Boolean.TRUE);
        }
        this.gj.a(getActivity(), this.Tu.mAdResultData, this);
        this.Tu.MU.add(this.Tv);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        ru();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.Tr;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_activity";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return this.Tu.Th.templateId;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final e getTouchCoordsView() {
        return this.Tu.mRootContainer;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        rx();
        this.gj.jq();
        this.Tu.MU.remove(this.Tv);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aW = com.kwad.sdk.c.a.a.aW(getContext());
        aVar.width = (int) ((bj.getScreenWidth(getContext()) / aW) + 0.5f);
        aVar.height = (int) ((bj.getScreenHeight(getContext()) / aW) + 0.5f);
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
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        getActivity().finish();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        this.Ts = awVar;
    }
}
