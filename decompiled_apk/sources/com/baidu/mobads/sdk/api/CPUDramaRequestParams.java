package com.baidu.mobads.sdk.api;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class CPUDramaRequestParams {
    private HashMap<String, Object> mParameters;

    /* loaded from: classes7.dex */
    public static class Builder {
        private HashMap<String, Object> mExtras = new HashMap<>();

        public Builder addExtra(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                this.mExtras.put(str, str2);
            }
            return this;
        }

        public CPUDramaRequestParams build() {
            return new CPUDramaRequestParams(this);
        }

        public Builder setAppSid(String str) {
            this.mExtras.put("appsid", str);
            return this;
        }

        public Builder setCustomUserId(String str) {
            this.mExtras.put("outerUid", str);
            return this;
        }

        public Builder setDetailConfig(CPUDramaDetailConfig cPUDramaDetailConfig) {
            this.mExtras.put("dramaDetailConfig", cPUDramaDetailConfig);
            return this;
        }

        public Builder setSubChannelId(String str) {
            this.mExtras.put("subChannelId", str);
            return this;
        }

        public Builder setTimeOut(String str) {
            this.mExtras.put("timeout", str);
            return this;
        }
    }

    public HashMap<String, Object> getExtras() {
        return this.mParameters;
    }

    private CPUDramaRequestParams(Builder builder) {
        this.mParameters = new HashMap<>();
        if (builder == null || builder.mExtras == null) {
            return;
        }
        this.mParameters = builder.mExtras;
    }
}
