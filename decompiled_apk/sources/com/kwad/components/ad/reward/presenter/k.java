package com.kwad.components.ad.reward.presenter;

import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;

/* loaded from: classes11.dex */
public final class k extends b {
    private final AdLiveCallerContextListener sn = new AdLiveCallerContextListener() { // from class: com.kwad.components.ad.reward.presenter.k.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener
        public final boolean isCloseDialogShowing() {
            return com.kwad.components.ad.reward.g.b(k.this.qp);
        }
    };
    private final com.kwad.components.core.l.a.a so = new com.kwad.components.core.l.a.b() { // from class: com.kwad.components.ad.reward.presenter.k.2
        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void c(com.kwad.components.core.proxy.c cVar) {
            super.c(cVar);
            if (k.this.qp.oK.jN()) {
                k.this.qp.oK.jO().onResume();
                if (com.kwad.components.core.s.a.as(k.this.qp.mContext).rA()) {
                    k.this.qp.d(false, false);
                }
            }
        }

        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void d(com.kwad.components.core.proxy.c cVar) {
            super.d(cVar);
            if (k.this.qp.oK.jN()) {
                k.this.qp.oK.jO().onPause();
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (this.qp.oK.jN()) {
            this.qp.oK.jO().registerAdLiveCallerContextListener(this.sn);
            this.qp.MU.add(this.so);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        if (this.qp.oK.jN()) {
            this.qp.oK.jO().unRegisterAdLiveCallerContextListener(this.sn);
            this.qp.MU.remove(this.so);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
