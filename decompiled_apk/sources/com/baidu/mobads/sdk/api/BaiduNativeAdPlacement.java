package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.a;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class BaiduNativeAdPlacement {
    private String apid;
    private String mAppsid;
    private boolean mClicked;
    private boolean mWinSended;
    a mAdElementInfo = null;
    private boolean mRequestStarted = false;
    private WeakReference<BaiduNativeH5AdView> mWeakAdView = null;
    private int feedSessionId = 0;
    private int feedPositionId = 1;
    private int feedSequenceId = 1;

    public BaiduNativeH5AdView getAdView() {
        WeakReference<BaiduNativeH5AdView> weakReference = this.mWeakAdView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public String getApId() {
        return this.apid;
    }

    public int getPosistionId() {
        return this.feedPositionId;
    }

    public boolean getRequestStarted() {
        return this.mRequestStarted;
    }

    public a getResponse() {
        return this.mAdElementInfo;
    }

    public int getSequenceId() {
        return this.feedSequenceId;
    }

    public int getSessionId() {
        return this.feedSessionId;
    }

    public boolean hasValidResponse() {
        if (this.mAdElementInfo != null && isAdAvailable()) {
            return true;
        }
        return false;
    }

    public boolean isAdAvailable() {
        if (this.mAdElementInfo != null && System.currentTimeMillis() - this.mAdElementInfo.y() <= 1800000 && !this.mClicked) {
            return true;
        }
        return false;
    }

    public boolean isAdDataLoaded() {
        BaiduNativeH5AdView adView = getAdView();
        if (adView != null) {
            return adView.isAdDataLoaded();
        }
        return false;
    }

    public boolean isWinSended() {
        return this.mWinSended;
    }

    public void setAdResponse(a aVar) {
        this.mWinSended = false;
        this.mAdElementInfo = aVar;
    }

    public void setAdView(BaiduNativeH5AdView baiduNativeH5AdView) {
        this.mWeakAdView = new WeakReference<>(baiduNativeH5AdView);
    }

    public void setApId(String str) {
        this.apid = str;
    }

    public void setAppSid(String str) {
        this.mAppsid = str;
    }

    public void setClicked(boolean z) {
        this.mClicked = z;
    }

    public void setPositionId(int i) {
        if (i < 1) {
            return;
        }
        this.feedPositionId = i;
    }

    public void setRequestStarted(boolean z) {
        this.mRequestStarted = z;
    }

    public void setSessionId(int i) {
        if (i < 1) {
            return;
        }
        this.feedSessionId = i;
        this.feedSequenceId = BaiduNativeFeedSession.getInstance().getSequenceId(i);
    }

    public void setWinSended(boolean z) {
        this.mWinSended = z;
    }
}
