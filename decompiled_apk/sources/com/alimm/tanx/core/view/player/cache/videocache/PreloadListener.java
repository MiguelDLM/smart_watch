package com.alimm.tanx.core.view.player.cache.videocache;

import com.alimm.tanx.core.ad.ITanxAd;

/* loaded from: classes.dex */
public interface PreloadListener {
    void onCached(String str);

    void onError(String str, Exception exc);

    void onStartCached(ITanxAd iTanxAd);
}
