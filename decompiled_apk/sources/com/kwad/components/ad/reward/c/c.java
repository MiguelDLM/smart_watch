package com.kwad.components.ad.reward.c;

import com.kwad.sdk.api.KsRewardVideoAd;
import java.lang.reflect.Method;

/* loaded from: classes11.dex */
public final class c {
    public static void a(b bVar, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        if (rewardAdInteractionListener == null || bVar == null) {
            return;
        }
        try {
            rewardAdInteractionListener.onExtraRewardVerify(bVar.getType());
        } catch (Throwable unused) {
        }
    }

    public static b gQ() {
        return new b(1);
    }

    public static boolean a(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        if (rewardAdInteractionListener == null) {
            return false;
        }
        try {
            for (Method method : rewardAdInteractionListener.getClass().getMethods()) {
                if ("onExtraRewardVerify".equals(method.getName())) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
