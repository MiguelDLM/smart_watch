package com.kwad.components.ad.f.b;

import android.view.View;
import com.kwad.components.core.video.l;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class c extends com.kwad.components.ad.f.a.a {
    private List<Integer> cB;
    private volatile boolean cC = false;

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.cB = com.kwad.sdk.core.response.b.a.bn(com.kwad.sdk.core.response.b.e.dS(this.mN.mAdTemplate));
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.c.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                com.kwad.sdk.core.adlog.c.bN(c.this.mN.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j, long j2) {
                c.this.c(j2);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                c.this.cC = false;
                if (!c.this.mN.mAdTemplate.mPvReported) {
                    c.this.mN.mw.es();
                }
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                View view = (View) c.this.mN.mI.getParent();
                if (view != null) {
                    bVar.v(view.getHeight(), view.getWidth());
                }
                com.kwad.components.core.s.b.rC().a(c.this.mN.mAdTemplate, null, bVar);
                com.kwad.sdk.core.adlog.c.bM(c.this.mN.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                if (!c.this.cC) {
                    c.this.cC = true;
                    com.kwad.components.core.o.a.qI().b(c.this.mN.mAdTemplate, System.currentTimeMillis(), 1);
                }
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mN.mO.b((com.kwad.components.core.video.k) lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.cB) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mN.mAdTemplate, ceil, (JSONObject) null);
                this.cB.remove(num);
                return;
            }
        }
    }
}
