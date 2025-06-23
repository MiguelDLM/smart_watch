package com.bytedance.sdk.openadsdk;

import android.graphics.Bitmap;

/* loaded from: classes8.dex */
public interface TTDrawFeedAd extends TTFeedAd {

    /* loaded from: classes8.dex */
    public interface DrawVideoListener {
        void onClick();

        void onClickRetry();
    }

    void setCanInterruptVideoPlay(boolean z);

    void setDrawVideoListener(DrawVideoListener drawVideoListener);

    void setPauseIcon(Bitmap bitmap, int i);
}
