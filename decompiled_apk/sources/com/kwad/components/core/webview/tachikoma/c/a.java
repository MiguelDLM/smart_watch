package com.kwad.components.core.webview.tachikoma.c;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.r;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: classes11.dex */
public abstract class a extends Presenter implements j {
    protected b abk;
    protected i gj;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        b bVar = (b) Kf();
        this.abk = bVar;
        a(bVar);
        if (this.gj == null) {
            this.gj = hO();
        }
        StyleTemplate styleTemplate = this.abk.Th;
        if (styleTemplate != null) {
            this.gj.a(styleTemplate);
        }
        i iVar = this.gj;
        b bVar2 = this.abk;
        iVar.a(bVar2.mActivity, bVar2.mAdResultData, this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.abk.abl;
    }

    public i hO() {
        return new i(this.abk.xt, getContext());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.gj.jq();
        this.gj = null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(m mVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(t tVar) {
    }

    public void a(b bVar) {
    }

    public void a(r rVar, com.kwad.sdk.core.webview.b bVar) {
    }

    public void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    public void a(WebCloseStatus webCloseStatus) {
        e eVar = this.abk.Zt;
        if (eVar != null) {
            eVar.dismiss();
        }
    }
}
