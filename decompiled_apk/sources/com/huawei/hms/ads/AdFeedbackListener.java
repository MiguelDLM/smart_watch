package com.huawei.hms.ads;

import com.huawei.hms.ads.annotation.AllApi;

@AllApi
/* loaded from: classes10.dex */
public interface AdFeedbackListener {
    void onAdDisliked();

    void onAdFeedbackShowFailed();

    void onAdLiked();
}
