package com.kwad.components.ad.reward.model;

import com.bytedance.android.live.base.api.push.ILivePush;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes11.dex */
public final class d {
    public static String m(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.cM(adInfo)) {
            return ILivePush.ClickType.LIVE;
        }
        if (com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            return "image";
        }
        if (com.kwad.sdk.core.response.b.a.bY(adInfo)) {
            return "reward_preview";
        }
        return "video";
    }
}
