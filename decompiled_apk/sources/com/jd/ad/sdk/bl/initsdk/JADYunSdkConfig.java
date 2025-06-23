package com.jd.ad.sdk.bl.initsdk;

import androidx.annotation.NonNull;

/* loaded from: classes10.dex */
public class JADYunSdkConfig {
    private boolean enableLog;
    private String mAppId;
    private JADPrivateController privateController;
    private boolean supportMultiProcess;

    /* loaded from: classes10.dex */
    public static class Builder {
        private String appId;
        private boolean enableLog;
        public JADPrivateController privateController;
        private boolean supportMultiProcess;

        public JADYunSdkConfig build() {
            return new JADYunSdkConfig(this);
        }

        public Builder setAppId(@NonNull String str) {
            this.appId = str;
            return this;
        }

        public Builder setEnableLog(boolean z) {
            this.enableLog = z;
            return this;
        }

        public Builder setPrivateController(@NonNull JADPrivateController jADPrivateController) {
            this.privateController = jADPrivateController;
            return this;
        }

        public Builder setSupportMultiProcess(boolean z) {
            this.supportMultiProcess = z;
            return this;
        }
    }

    private void setAppId(String str) {
        this.mAppId = str;
    }

    private void setEnableLog(boolean z) {
        this.enableLog = z;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public JADPrivateController getPrivateController() {
        return this.privateController;
    }

    public boolean isEnableLog() {
        return this.enableLog;
    }

    public boolean isSupportMultiProcess() {
        return this.supportMultiProcess;
    }

    public void setPrivateController(JADPrivateController jADPrivateController) {
        this.privateController = jADPrivateController;
    }

    public void setSupportMultiProcess(boolean z) {
        this.supportMultiProcess = z;
    }

    private JADYunSdkConfig(Builder builder) {
        this.mAppId = builder.appId;
        this.enableLog = builder.enableLog;
        this.privateController = builder.privateController;
        this.supportMultiProcess = builder.supportMultiProcess;
    }
}
