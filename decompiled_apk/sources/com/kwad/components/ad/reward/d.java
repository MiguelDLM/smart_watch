package com.kwad.components.ad.reward;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class d extends com.kwad.components.ad.l.b {
    private List<AdTemplate> oB;
    private boolean oC;
    private List<com.kwad.components.core.e.d.c> oD;
    private w.b oE;

    public d(List<AdTemplate> list, @Nullable JSONObject jSONObject, w.b bVar) {
        super(jSONObject, null);
        this.oC = false;
        this.oD = new ArrayList();
        this.oB = list;
        this.oE = bVar;
        if (list != null && list.size() > 0) {
            Iterator<AdTemplate> it = this.oB.iterator();
            while (it.hasNext()) {
                this.oD.add(new com.kwad.components.core.e.d.c(it.next()));
            }
        }
    }

    @Override // com.kwad.components.ad.l.b
    public final String B(AdTemplate adTemplate) {
        List<AdTemplate> list = this.oB;
        if (list != null && list.size() >= 2) {
            return com.kwad.sdk.core.response.b.b.cq(this.oB.get(1));
        }
        return super.B(adTemplate);
    }

    @Override // com.kwad.components.ad.l.b
    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.components.core.e.d.c cVar, int i) {
        super.a(frameLayout, adBaseFrameLayout, this.oB, this.oD);
    }

    @Override // com.kwad.components.ad.l.b
    public final void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplateList(this.oB);
    }

    @Override // com.kwad.components.ad.l.b
    public final boolean bx() {
        if (this.oC) {
            return this.In;
        }
        return super.bx();
    }

    @Override // com.kwad.components.ad.l.b
    @SuppressLint({"ClickableViewAccessibility"})
    public final void fk() {
        super.fk();
        this.cL.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.d.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    return true;
                }
                return false;
            }
        });
    }

    @Override // com.kwad.components.ad.l.b
    public final boolean fl() {
        return false;
    }

    public final void fm() {
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sW();
        }
    }

    @Override // com.kwad.components.ad.l.b
    public final void fn() {
        com.kwad.components.ad.reward.monitor.c.a(true, "middle_play_end_card");
    }

    @Override // com.kwad.components.ad.l.b
    public final void fo() {
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.reward.monitor.c.a(adTemplate, true, "middle_play_end_card", B(adTemplate));
    }

    @Override // com.kwad.components.ad.l.b
    public final void fp() {
        com.kwad.components.ad.reward.monitor.c.a(true, "middle_play_end_card", B(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }

    @Override // com.kwad.components.ad.l.b
    public final String getName() {
        return "MiddlePlayEndCard";
    }

    public final void setShowLandingPage(boolean z) {
        this.oC = z;
    }

    @Override // com.kwad.components.ad.l.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        List<AdTemplate> list = this.oB;
        w wVar = new w(new ArrayList(list.subList(1, list.size() - 1)));
        wVar.a(this.oE);
        aVar.a(wVar);
    }
}
