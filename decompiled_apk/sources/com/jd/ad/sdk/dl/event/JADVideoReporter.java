package com.jd.ad.sdk.dl.event;

/* loaded from: classes10.dex */
public interface JADVideoReporter {
    void reportVideoCompleted(float f);

    void reportVideoError(float f, int i, int i2);

    void reportVideoPause(float f);

    void reportVideoResume(float f);

    void reportVideoStart(float f);

    void reportVideoWillStart();
}
