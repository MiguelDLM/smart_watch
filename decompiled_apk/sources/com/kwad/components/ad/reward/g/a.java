package com.kwad.components.ad.reward.g;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.b.g;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.l;

/* loaded from: classes11.dex */
public final class a extends d implements g {
    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return g.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.ad.b.g
    public final void loadRewardVideoAd(KsScene ksScene, @NonNull KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        if (!l.zJ().Ag()) {
            e eVar = e.awT;
            rewardVideoAdListener.onError(eVar.errorCode, eVar.msg);
        } else {
            b.a(ksScene, new c(ksScene.getPosId(), rewardVideoAdListener));
        }
    }

    @Override // com.kwad.components.ad.b.g
    public final void notifyRewardVerify() {
        com.kwad.components.ad.reward.b.fc().notifyRewardVerify();
    }
}
