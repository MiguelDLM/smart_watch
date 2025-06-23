package com.alimm.tanx.core.config;

import android.util.Log;
import com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker;
import com.alimm.tanx.core.image.ILoader;
import com.alimm.tanx.core.image.ImageManager;
import com.alimm.tanx.core.net.INetWork;
import com.alimm.tanx.core.utils.LogStatus;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer;
import java.util.List;
import java.util.Map;
import x0oxIIIX.oIX0oI;

/* loaded from: classes.dex */
public class TanxConfig extends TanxCoreConfig implements NotConfused {
    private SettingConfig mSettingConfig;
    private HttpProxyCacheServer proxyCacheServer;

    /* loaded from: classes.dex */
    public static class Builder implements NotConfused {
        protected Boolean idAllSwitch;
        protected String imei;
        protected boolean imeiSwitch;
        protected String mAppId;
        private String mAppKey;
        protected String mAppName;
        private String mAppSecret;
        protected String mChannel;
        protected boolean mDebugMode;
        private ILoader mImageLoader;
        private INetWork mNetWork;
        protected ITanxUserTracker mTanxUserTracker;
        protected oIX0oI mUserTracker;
        private boolean netDebug;
        protected String oaid;
        protected boolean oaidSwitch;
        private Map<String, List<String>> userTag;
        protected LogStatus logStatus = null;
        private SettingConfig mSettingConfig = new SettingConfig();

        public Builder() {
            this.mDebugMode = false;
            this.netDebug = false;
            this.mDebugMode = false;
            this.netDebug = false;
        }

        public Builder appId(String str) {
            this.mAppId = str;
            return this;
        }

        public Builder appKey(String str) {
            this.mAppKey = str;
            return this;
        }

        public Builder appName(String str) {
            this.mAppName = str;
            return this;
        }

        public Builder appSecret(String str) {
            this.mAppSecret = str;
            return this;
        }

        public TanxConfig build() {
            return new TanxConfig(this);
        }

        public Builder channel(String str) {
            this.mChannel = str;
            return this;
        }

        public Builder dark(SettingConfig settingConfig) {
            this.mSettingConfig = settingConfig;
            return this;
        }

        public Builder debug(boolean z) {
            this.mDebugMode = z;
            return this;
        }

        public Builder idAllSwitch(boolean z) {
            this.idAllSwitch = Boolean.valueOf(z);
            return this;
        }

        @Deprecated
        public Builder imageLoader(ILoader iLoader) {
            this.mImageLoader = iLoader;
            return this;
        }

        public Builder imei(String str) {
            this.imei = str;
            return this;
        }

        public Builder imeiSwitch(boolean z) {
            this.imeiSwitch = z;
            return this;
        }

        public Builder logStatus(LogStatus logStatus) {
            this.logStatus = logStatus;
            return this;
        }

        public Builder netDebug(boolean z) {
            this.netDebug = z;
            return this;
        }

        public Builder network(INetWork iNetWork) {
            this.mNetWork = iNetWork;
            return this;
        }

        public Builder oaid(String str) {
            this.oaid = str;
            return this;
        }

        public Builder oaidSwitch(boolean z) {
            this.oaidSwitch = z;
            return this;
        }

        public Builder setUserTag(Map<String, List<String>> map) {
            this.userTag = map;
            return this;
        }

        public Builder tanxUserTracker(ITanxUserTracker iTanxUserTracker) {
            this.mTanxUserTracker = iTanxUserTracker;
            return this;
        }

        public Builder userTracker(oIX0oI oix0oi) {
            this.mUserTracker = oix0oi;
            return this;
        }
    }

    public TanxConfig() {
    }

    public ILoader getImageLoader() {
        return ImageManager.getLoader();
    }

    public SettingConfig getSettingConfig() {
        return this.mSettingConfig;
    }

    public void setImageLoader(ILoader iLoader) {
        if (iLoader != null) {
            Log.d("ImageManager init", "媒体设置mImageLoader");
            ImageManager.setLoader(iLoader);
        }
    }

    public void setSettingConfig(SettingConfig settingConfig) {
        this.mSettingConfig = settingConfig;
    }

    public TanxConfig(Builder builder) {
        setDebugMode(builder.mDebugMode);
        setLogStatus(builder.logStatus);
        setAppName(builder.mAppName);
        setChannel(builder.mChannel);
        setAppId(builder.mAppId);
        setAppName(builder.mAppName);
        setAppKey(builder.mAppKey);
        setNetDebug(builder.netDebug);
        setAppSecret(builder.mAppSecret);
        setmOaid(builder.oaid);
        setImei(builder.imei);
        setOaidSwitch(builder.oaidSwitch);
        setImeiSwitch(builder.imeiSwitch);
        setIdAllSwitch(builder.idAllSwitch);
        setImageLoader(builder.mImageLoader);
        this.mSettingConfig = builder.mSettingConfig;
        setUserTag(builder.userTag);
    }
}
