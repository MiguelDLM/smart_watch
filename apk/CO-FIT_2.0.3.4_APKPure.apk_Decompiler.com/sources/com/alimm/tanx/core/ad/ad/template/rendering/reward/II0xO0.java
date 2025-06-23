package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import com.alimm.tanx.core.view.player.core.OnVideoBufferingListener;
import com.alimm.tanx.core.view.player.core.PlayerBufferingState;

public final /* synthetic */ class II0xO0 implements OnVideoBufferingListener {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ RewardVideoPortraitActivity f1155oIX0oI;

    public /* synthetic */ II0xO0(RewardVideoPortraitActivity rewardVideoPortraitActivity) {
        this.f1155oIX0oI = rewardVideoPortraitActivity;
    }

    public final void OnBufferStateChanged(PlayerBufferingState playerBufferingState) {
        this.f1155oIX0oI.lambda$initVideo$8(playerBufferingState);
    }
}
