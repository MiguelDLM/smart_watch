package com.alimm.tanx.core.view.player.cache;

import com.alimm.tanx.core.ad.ITanxAd;

public final /* synthetic */ class oIX0oI implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ ITanxAd f1168IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ String f1169Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ VideoGetSizeManager f1170XO;

    public /* synthetic */ oIX0oI(VideoGetSizeManager videoGetSizeManager, String str, ITanxAd iTanxAd) {
        this.f1170XO = videoGetSizeManager;
        this.f1169Oo = str;
        this.f1168IXxxXO = iTanxAd;
    }

    public final void run() {
        this.f1170XO.lambda$getVideoSize$13(this.f1169Oo, this.f1168IXxxXO);
    }
}
