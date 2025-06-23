package com.kwad.components.core.webview.tachikoma.c;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.b.y;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.k;
import com.kwad.sdk.core.webview.c.g;
import com.kwad.sdk.utils.bj;

/* loaded from: classes11.dex */
public class c extends a {
    private FrameLayout Tr;
    private e Zt;
    private p abq;
    private aw abr;
    private com.kwad.components.core.webview.tachikoma.e.d abs = new com.kwad.components.core.webview.tachikoma.e.d() { // from class: com.kwad.components.core.webview.tachikoma.c.c.2
        @Override // com.kwad.components.core.webview.tachikoma.e.d
        public final void fS() {
            if (c.this.abr != null) {
                c.this.abr.sV();
                c.this.abr.sW();
            }
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.d
        public final void ga() {
            if (c.this.abr != null) {
                c.this.abr.sX();
                c.this.abr.sY();
            }
        }
    };

    /* renamed from: xo, reason: collision with root package name */
    private String f18470xo;

    /* JADX INFO: Access modifiers changed from: private */
    public void tz() {
        e.a aVar = this.abk.abp;
        if (aVar != null) {
            aVar.fU();
        }
        com.kwad.components.core.webview.tachikoma.d.b.tG().s(getTkTemplateId(), getTKReaderScene());
        k kVar = this.abk.abm;
        if (kVar != null) {
            kVar.callbackPageStatus(false, "render failed");
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0809a c0809a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        e eVar = this.Zt;
        if (eVar != null) {
            eVar.a(this.abs);
        }
        if (this.abk.abm != null) {
            this.gj.a(new g() { // from class: com.kwad.components.core.webview.tachikoma.c.c.1
                @Override // com.kwad.sdk.core.webview.c.g
                public final void callTKBridge(String str) {
                    c.this.abk.abm.callTKBridge(str);
                }
            });
            this.abk.abm.a(this.gj);
            this.gj.a("hasTKBridge", Boolean.TRUE);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        k kVar = this.abk.abm;
        if (kVar != null) {
            kVar.callbackPageStatus(true, null);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
        super.bG();
        b bVar = this.abk;
        if (bVar.abo) {
            com.kwad.components.core.webview.tachikoma.e.c cVar = bVar.Tf;
            if (cVar != null) {
                cVar.F(true);
                return;
            }
            return;
        }
        e eVar = this.Zt;
        if (eVar != null) {
            eVar.dismiss();
        }
        com.kwad.components.core.webview.tachikoma.e.c cVar2 = this.abk.Tf;
        if (cVar2 != null) {
            cVar2.gb();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.Tr;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTKReaderScene() {
        return "tk_dialog";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTkTemplateId() {
        StyleTemplate styleTemplate = this.abk.Th;
        if (styleTemplate != null) {
            return styleTemplate.templateId;
        }
        return this.f18470xo;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Tr = (FrameLayout) findViewById(R.id.ksad_tk_dialog_container);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aW = com.kwad.sdk.c.a.a.aW(getContext());
        aVar.width = (int) ((bj.getScreenWidth(getContext()) / aW) + 0.5f);
        aVar.height = (int) ((bj.getScreenHeight(getContext()) / aW) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a
    public final void a(b bVar) {
        super.a(bVar);
        b bVar2 = this.abk;
        this.f18470xo = bVar2.f18469xo;
        this.Zt = bVar2.Zt;
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
        this.abq = pVar;
        long j = this.abk.xt;
        if (pVar == null || j <= 0) {
            return;
        }
        y yVar = new y();
        yVar.nF = (int) ((((float) j) / 1000.0f) + 0.5f);
        this.abq.a(yVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        this.abr = awVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
        super.a(tVar);
        e eVar = this.Zt;
        if (eVar != null) {
            eVar.dismiss();
        }
        com.kwad.components.core.webview.tachikoma.e.c cVar = this.abk.Tf;
        if (cVar != null) {
            cVar.F(true);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
        k kVar = this.abk.abm;
        if (kVar != null) {
            kVar.callbackDialogDismiss();
        }
    }

    public void a(TKRenderFailReason tKRenderFailReason) {
        e eVar = this.Zt;
        if (eVar != null) {
            if (eVar.isShowing()) {
                this.Zt.d(new DialogInterface.OnDismissListener() { // from class: com.kwad.components.core.webview.tachikoma.c.c.3
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        c.this.Zt.e(this);
                        c.this.tz();
                    }
                });
            } else {
                tz();
            }
            this.Zt.dismiss();
            return;
        }
        tz();
    }
}
