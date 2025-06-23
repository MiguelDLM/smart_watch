package com.kwad.components.ad.reward.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.g;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.q;

/* loaded from: classes11.dex */
public final class a {
    public static k qu = new k("rewardSkipType", 0);
    public static k qv = new k("rewardActiveAppTaskMinSecond", 15);
    public static k qw = new k("rewardContentDetainType", 0);
    public static d qx = new d("forceGetAudioFocus", false);
    public static q qy = new q("rewardSkipTips", "");
    public static q qz = new q("fullscreenSkipTips", "");
    public static k qA = new k("ecRewardAdOrderSwitch", 0);
    public static k qB = new k("ecRewardAdFanSwitch", 0);
    public static k qC = new k("ecRewardAdKwaishopStyle", 0);
    public static k qD = new k("xdtCouponShowDuration", 3000);
    public static k qE = new k("jinniuCloseDialogStyle", 1);
    public static g qF = new g("interactionTimeInRewardedVideo", 0.0f);
    public static d qG = new d("autoJumpInRewardedVideo", false);
    public static k qH = new k("advanceJumpDirectDeliveryMaxCount", 0);
    public static d qI = new d("advanceJumpDirectDeliverySwitch", false);
    public static k qJ = new k("shortVideoFollowRewardPlayStyle", 0);
    public static d qK = new d("enableRewardLayoutOptimise", false);
    public static d qL = new d("enableFullscreenLayoutOptimise", false);

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void init() {
    }
}
