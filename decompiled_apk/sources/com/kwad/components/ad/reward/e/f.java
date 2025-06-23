package com.kwad.components.ad.reward.e;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsRewardVideoAd;
import java.util.HashMap;

/* loaded from: classes11.dex */
public final class f {
    private static final HashMap<String, f> rv = new HashMap<>();
    private KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    private com.kwad.components.core.i.d oz;
    private KsRewardVideoAd.RewardAdInteractionListener rw;

    @Nullable
    private static f G(String str) {
        return rv.get(str);
    }

    public static KsRewardVideoAd.RewardAdInteractionListener H(String str) {
        f G = G(str);
        if (G != null) {
            return G.rw;
        }
        return null;
    }

    public static void I(String str) {
        f G = G(str);
        if (G != null) {
            G.rw = G.mInteractionListener;
        }
    }

    public static com.kwad.components.core.i.d J(String str) {
        f G = G(str);
        if (G != null) {
            return G.oz;
        }
        return null;
    }

    public static void K(String str) {
        f G = G(str);
        if (G != null) {
            G.destroy();
            rv.put(str, null);
        }
    }

    public static void a(String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, com.kwad.components.core.i.d dVar) {
        f fVar = new f();
        fVar.mInteractionListener = rewardAdInteractionListener;
        fVar.oz = dVar;
        fVar.rw = rewardAdInteractionListener;
        rv.put(str, fVar);
    }

    private void destroy() {
        this.mInteractionListener = null;
        this.rw = null;
        com.kwad.components.core.i.d dVar = this.oz;
        if (dVar != null) {
            dVar.destroy();
            this.oz = null;
        }
    }
}
