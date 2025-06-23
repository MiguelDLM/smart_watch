package com.huawei.hms.ads.instreamad;

import com.huawei.hms.ads.annotation.GlobalApi;
import java.util.List;

@GlobalApi
/* loaded from: classes10.dex */
public interface InstreamAdLoadListener {
    void onAdFailed(int i);

    void onAdLoaded(List<InstreamAd> list);
}
