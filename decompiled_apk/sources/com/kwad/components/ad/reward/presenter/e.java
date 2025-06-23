package com.kwad.components.ad.reward.presenter;

import android.view.ViewGroup;
import android.view.ViewStub;
import com.kwad.components.ad.reward.n.n;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes11.dex */
public final class e extends b {
    private AdInfo mAdInfo;

    public e(AdInfo adInfo, ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        this.mAdInfo = adInfo;
        if (com.kwad.components.ad.reward.a.b.i(adInfo)) {
            final com.kwad.components.ad.reward.b.c cVar = new com.kwad.components.ad.reward.b.c();
            a(cVar);
            ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.ksad_reward_order_card);
            if (viewStub != null) {
                viewGroup3 = (ViewGroup) viewStub.inflate();
            } else {
                viewGroup3 = (ViewGroup) viewGroup.findViewById(R.id.ksad_reward_order_root);
            }
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.e(viewGroup3, new n.a() { // from class: com.kwad.components.ad.reward.presenter.e.1
                @Override // com.kwad.components.ad.reward.n.n.a
                public final void hu() {
                    cVar.showDialog();
                }
            }));
            return;
        }
        if (com.kwad.sdk.core.response.b.a.cb(adInfo) == 1) {
            ViewStub viewStub2 = (ViewStub) viewGroup.findViewById(R.id.ksad_reward_jinniu_card);
            if (viewStub2 != null) {
                viewGroup2 = (ViewGroup) viewStub2.inflate();
            } else {
                viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.ksad_reward_jinniu_root);
            }
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.d(viewGroup2));
        }
    }
}
