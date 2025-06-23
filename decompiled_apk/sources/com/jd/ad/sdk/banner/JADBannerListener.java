package com.jd.ad.sdk.banner;

import android.view.View;

/* loaded from: classes10.dex */
public interface JADBannerListener {
    void onClick();

    void onClose();

    void onExposure();

    void onLoadFailure(int i, String str);

    void onLoadSuccess();

    void onRenderFailure(int i, String str);

    void onRenderSuccess(View view);
}
