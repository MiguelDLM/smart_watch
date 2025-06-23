package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import com.alimm.tanx.core.view.player.core.ITanxPlayer;
import com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener;
import com.alimm.tanx.core.view.player.core.PlayerState;

public final /* synthetic */ class oIX0oI implements OnVideoStateChangeListener {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ RewardVideoPortraitActivity f1156oIX0oI;

    public /* synthetic */ oIX0oI(RewardVideoPortraitActivity rewardVideoPortraitActivity) {
        this.f1156oIX0oI = rewardVideoPortraitActivity;
    }

    public final void onStateChange(ITanxPlayer iTanxPlayer, PlayerState playerState) {
        this.f1156oIX0oI.lambda$initVideo$7(iTanxPlayer, playerState);
    }
}
