package com.baidu.mobads.sdk.api;

import android.view.View;
import java.util.List;

/* loaded from: classes7.dex */
public interface EntryResponse {

    /* loaded from: classes7.dex */
    public interface EntryAdInteractionListener {
        void onADExposed();

        void onADExposureFailed(int i);

        void onAdClick();

        void onAdUnionClick();
    }

    String getAdLogoUrl();

    String getBaiduLogoUrl();

    String getTitle();

    boolean isAdAvailable();

    void registerViewForInteraction(View view, List<View> list, List<View> list2, EntryAdInteractionListener entryAdInteractionListener);

    void unionLogoClick();
}
