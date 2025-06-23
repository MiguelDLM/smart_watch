package com.baidu.navisdk.adapter.struct;

import com.baidu.navisdk.adapter.IBaiduNaviManager;

/* loaded from: classes7.dex */
public class BNaviInitConfig {
    private final IBaiduNaviManager.INaviInitListener naviInitListener;
    private final String sdcardRootPath;

    /* loaded from: classes7.dex */
    public static class Builder {
        private IBaiduNaviManager.INaviInitListener naviInitListener;
        private String sdcardRootPath;

        public BNaviInitConfig build() {
            return new BNaviInitConfig(this.sdcardRootPath, this.naviInitListener);
        }

        public Builder naviInitListener(IBaiduNaviManager.INaviInitListener iNaviInitListener) {
            this.naviInitListener = iNaviInitListener;
            return this;
        }

        public Builder sdcardRootPath(String str) {
            this.sdcardRootPath = str;
            return this;
        }
    }

    public IBaiduNaviManager.INaviInitListener getNaviInitListener() {
        return this.naviInitListener;
    }

    public String getSdcardRootPath() {
        return this.sdcardRootPath;
    }

    private BNaviInitConfig(String str, IBaiduNaviManager.INaviInitListener iNaviInitListener) {
        this.sdcardRootPath = str;
        this.naviInitListener = iNaviInitListener;
    }
}
