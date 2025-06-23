package com.alimm.tanx.core.ad.ad.template.rendering.splash;

import android.content.Context;
import com.alimm.tanx.core.ad.bean.BidInfo;

public interface IRenderCallback {
    void onAdClicked(boolean z, BidInfo bidInfo, long j, Context context, boolean z2, int i);

    void onAdClosed(boolean z, BidInfo bidInfo, long j);

    void onAdFinished(boolean z, BidInfo bidInfo, long j);

    void onAdShowError(int i);

    void onAdShowException(boolean z, String str);

    void onAdStarted(boolean z, BidInfo bidInfo);

    void requestCloseAd(boolean z, int i);
}
