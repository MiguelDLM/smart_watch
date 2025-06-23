package com.kwad.components.ad.reward.presenter.b;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.model.AdLiveEndResultData;
import com.kwad.components.ad.reward.n.p;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.utils.az;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    private IAdLiveEndRequest ga;
    private long hj;

    @Nullable
    private p pj;

    @Nullable
    private View tQ;
    private final l<com.kwad.components.core.liveEnd.a, AdLiveEndResultData> mNetworking = new l<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.b.b.1
        @NonNull
        private static AdLiveEndResultData Q(String str) {
            AdLiveEndResultData adLiveEndResultData = new AdLiveEndResultData();
            adLiveEndResultData.parseJson(new JSONObject(str));
            return adLiveEndResultData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: bC, reason: merged with bridge method [inline-methods] */
        public com.kwad.components.core.liveEnd.a createRequest() {
            return new com.kwad.components.core.liveEnd.a(b.this.ga);
        }

        @Override // com.kwad.sdk.core.network.l
        public final boolean isPostByJson() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ AdLiveEndResultData parseData(String str) {
            return Q(str);
        }
    };
    private final com.kwad.components.core.video.l sw = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.b.b.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.hP();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            b.this.hQ();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            b.this.hj = j2;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.hQ();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void hP() {
        if (this.ga == null) {
            return;
        }
        this.mNetworking.request(new o<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.b.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar) {
                super.onStartRequest(aVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar, @NonNull final AdLiveEndResultData adLiveEndResultData) {
                super.onSuccess(aVar, adLiveEndResultData);
                if (adLiveEndResultData.mQLivePushEndInfo == null) {
                    return;
                }
                b.this.qp.mRootContainer.post(new az() { // from class: com.kwad.components.ad.reward.presenter.b.b.3.1
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        if (b.this.pj == null) {
                            b bVar = b.this;
                            bVar.pj = new p(bVar.qp);
                        }
                        b.this.pj.h(b.this.qp.mRootContainer);
                        b.this.pj.b(r.R(b.this.qp.mAdTemplate));
                        b.this.pj.a(b.this.qp, adLiveEndResultData.mQLivePushEndInfo, b.this.hj);
                        b.this.qp.pj = b.this.pj;
                        if (b.this.qp.mContext.getResources().getConfiguration().orientation == 2) {
                            b bVar2 = b.this;
                            bVar2.tQ = bVar2.findViewById(R.id.ksad_live_end_page_layout_root_landscape);
                        } else {
                            b bVar3 = b.this;
                            bVar3.tQ = bVar3.findViewById(R.id.ksad_live_end_page_layout_root);
                        }
                        b.this.tQ.setVisibility(0);
                        b.this.hy();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar, int i, String str) {
                super.onError(aVar, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hQ() {
        View view = this.tQ;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hy() {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0845a c0845a = new a.C0845a();
        bVar.cT(24);
        bVar.b(c0845a);
        com.kwad.components.ad.reward.j.b.a(true, this.qp.mAdTemplate, null, bVar);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        com.kwad.components.core.n.a.a.a aVar;
        super.aj();
        if (this.qp.oK.jN()) {
            this.qp.oK.a(this.sw);
            String bf = com.kwad.sdk.core.response.b.a.bf(e.dS(this.qp.mAdTemplate));
            if (!TextUtils.isEmpty(bf) && (aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class)) != null) {
                this.ga = aVar.getAdLiveEndRequest(bf);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mNetworking.cancel();
        if (this.qp.oK.jN()) {
            this.qp.oK.b(this.sw);
        }
    }
}
