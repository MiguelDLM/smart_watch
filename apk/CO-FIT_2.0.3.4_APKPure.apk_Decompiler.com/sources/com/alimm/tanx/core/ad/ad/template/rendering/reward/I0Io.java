package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import com.alimm.tanx.core.request.TanxPlayerError;
import com.alimm.tanx.core.view.player.core.ITanxPlayer;
import com.alimm.tanx.core.view.player.core.OnVideoErrorListener;

public final /* synthetic */ class I0Io implements OnVideoErrorListener {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ RewardVideoPortraitActivity f1154oIX0oI;

    public /* synthetic */ I0Io(RewardVideoPortraitActivity rewardVideoPortraitActivity) {
        this.f1154oIX0oI = rewardVideoPortraitActivity;
    }

    public final boolean onError(ITanxPlayer iTanxPlayer, TanxPlayerError tanxPlayerError) {
        return this.f1154oIX0oI.lambda$initVideo$9(iTanxPlayer, tanxPlayerError);
    }
}
