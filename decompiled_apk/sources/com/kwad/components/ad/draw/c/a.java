package com.kwad.components.ad.draw.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.k.b;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.h.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.l;

/* loaded from: classes11.dex */
public final class a extends b {
    private com.kwad.components.core.widget.a.b bQ;
    private long dc;
    private com.kwad.sdk.contentalliance.a.a.a dd;
    private boolean de;
    private final c df;
    private Context mContext;

    public a(@NonNull AdTemplate adTemplate, @NonNull com.kwad.components.core.widget.a.b bVar, @NonNull DetailVideoView detailVideoView) {
        super(adTemplate, detailVideoView);
        this.df = new c() { // from class: com.kwad.components.ad.draw.c.a.2
            @Override // com.kwad.sdk.core.h.c
            public final void aM() {
                if (a.this.dd == null) {
                    a aVar = a.this;
                    aVar.dd = com.kwad.sdk.contentalliance.a.a.a.bF(aVar.mAdTemplate);
                    a.this.HU.a(a.this.dd);
                }
                if (a.this.de) {
                    return;
                }
                a.this.resume();
            }

            @Override // com.kwad.sdk.core.h.c
            public final void aN() {
                a.this.pause();
            }
        };
        this.dc = com.kwad.sdk.core.response.b.a.aa(e.dS(this.mAdTemplate));
        this.bQ = bVar;
        this.mContext = detailVideoView.getContext();
        aL();
        this.HU.a(new c.e() { // from class: com.kwad.components.ad.draw.c.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    a.this.start(l.eo(a.this.mAdTemplate));
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    private void aL() {
        this.HU.a(new b.a(this.mAdTemplate).da(e.dU(this.mAdTemplate)).db(h.b(e.dT(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).BJ(), this.mDetailVideoView);
        this.HU.prepareAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(long j) {
        if (this.bQ.dX()) {
            this.HU.a(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, j));
            this.HU.start();
        }
    }

    public final void aJ() {
        long eo = l.eo(this.mAdTemplate);
        if (this.HU.rW() == null) {
            aL();
        }
        start(eo);
        this.bQ.a(this.df);
    }

    public final void aK() {
        this.dd = null;
        this.bQ.b(this.df);
        this.HU.release();
    }

    public final void f(boolean z) {
        this.de = z;
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void resume() {
        super.resume();
        com.kwad.components.core.s.a.as(this.mContext).aN(false);
    }
}
