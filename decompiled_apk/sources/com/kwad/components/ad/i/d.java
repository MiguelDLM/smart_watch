package com.kwad.components.ad.i;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.x;
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
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes11.dex */
public final class d extends KSFrameLayout implements j, com.kwad.sdk.core.h.c {
    public static String nV = "PUSH_VIEW_TAG";
    private final com.kwad.components.core.widget.a.b bQ;
    private aw cQ;
    private i gj;
    private AdTemplate nW;
    private com.kwad.components.ad.b.a.b nX;
    private boolean nY;
    private ViewGroup nZ;
    private boolean oa;

    public d(@NonNull Context context, AdTemplate adTemplate) {
        super(context);
        this.nY = false;
        setTag(nV);
        this.nW = adTemplate;
        this.bQ = new com.kwad.components.core.widget.a.b(this, 100);
        this.gj = new i(-1L, getContext()) { // from class: com.kwad.components.ad.i.d.1
            {
                super(-1L, r4);
            }

            @Override // com.kwad.components.core.webview.tachikoma.i
            public final void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, r rVar, ViewGroup viewGroup) {
                super.a(bVar, cVar, rVar, viewGroup);
                rVar.c(new x(bVar, cVar, this) { // from class: com.kwad.components.ad.i.d.1.1
                    @Override // com.kwad.components.core.webview.jshandler.x
                    public final void K(int i) {
                        super.K(i);
                        if (i == 3) {
                            d.this.a((WebCloseStatus) null);
                        }
                    }
                });
            }
        };
        this.gj.a((Activity) null, com.kwad.sdk.core.response.b.c.dD(this.nW), this);
    }

    private void destroy() {
        this.gj.jq();
        ViewGroup viewGroup = this.nZ;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eR() {
        if (this.oa) {
            return;
        }
        this.oa = true;
        eU();
        destroy();
    }

    private void eS() {
        com.kwad.components.ad.b.a.b bVar = this.nX;
        if (bVar != null) {
            bVar.T();
        }
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sV();
            this.cQ.sW();
        }
    }

    private void eU() {
        com.kwad.components.ad.b.a.b bVar = this.nX;
        if (bVar != null) {
            bVar.U();
        }
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sX();
            this.cQ.sY();
        }
    }

    private boolean eV() {
        try {
            com.kwad.sdk.core.c.b.En();
            final Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing()) {
                View findViewById = currentActivity.getWindow().getDecorView().findViewById(R.id.content);
                if (!(findViewById instanceof ViewGroup)) {
                    return false;
                }
                this.nZ = (ViewGroup) findViewById;
                this.nZ.addView(this, new ViewGroup.LayoutParams(-1, -1));
                com.kwad.sdk.core.c.b.En();
                com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.i.d.2
                    @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                    /* renamed from: onActivityDestroyed */
                    public final void b(Activity activity) {
                        super.b(activity);
                        com.kwad.sdk.core.c.b.En();
                        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                        if (activity.equals(currentActivity)) {
                            d.this.eR();
                        }
                    }
                });
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
            return false;
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0809a c0809a) {
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        com.kwad.sdk.core.e.c.d("PushAdView", "onPageVisible: ");
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sZ();
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        com.kwad.sdk.core.e.c.d("PushAdView", "onPageInvisible: ");
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.ta();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        this.bQ.a(this);
        this.bQ.ua();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        this.bQ.release();
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
        com.kwad.sdk.core.e.c.d("PushAdView", "onTkLoadSuccess");
        this.nY = true;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
    }

    public final boolean c(com.kwad.components.ad.b.a.b bVar) {
        this.nX = bVar;
        if (this.nY && eV()) {
            eS();
            return true;
        }
        return false;
    }

    public final boolean eT() {
        return this.nY;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_push_ad";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dA(this.nW);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.e getTouchCoordsView() {
        return this;
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
        com.kwad.sdk.core.e.c.d("PushAdView", "onTkLoadFailed");
        this.nY = false;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        com.kwad.sdk.core.e.c.d("PushAdView", "onAdClicked");
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        this.cQ = awVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable WebCloseStatus webCloseStatus) {
        eR();
    }
}
