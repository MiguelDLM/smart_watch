package com.jd.ad.sdk.bl.exposuremonitor;

/* loaded from: classes10.dex */
public interface JADExposureListener {
    void onDelayExposure(long j, String str, int i);

    void onExposure(String str);

    void onFinishExposure();

    void onPreExposure(String str);
}
