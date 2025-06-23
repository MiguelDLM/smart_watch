package com.baidu.navisdk.adapter.struct;

import android.content.Context;
import com.baidu.navisdk.tts.ITTSInitListener;

/* loaded from: classes7.dex */
public class BNTTsInitConfig {
    public String appId;
    public String appKey;
    public String authsn;
    public Context context;
    public ITTSInitListener initListener;
    public String secretKey;

    /* loaded from: classes7.dex */
    public static class Builder {
        private String appId;
        private String appKey;
        private String authsn;
        private Context context;
        public ITTSInitListener initListener;
        private String secretKey;

        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        public Builder appKey(String str) {
            this.appKey = str;
            return this;
        }

        public Builder authSn(String str) {
            this.authsn = str;
            return this;
        }

        public BNTTsInitConfig build() {
            return new BNTTsInitConfig(this.context, this.appId, this.appKey, this.secretKey, this.authsn, this.initListener);
        }

        public Builder context(Context context) {
            this.context = context;
            return this;
        }

        public Builder listener(ITTSInitListener iTTSInitListener) {
            this.initListener = iTTSInitListener;
            return this;
        }

        public Builder secretKey(String str) {
            this.secretKey = str;
            return this;
        }
    }

    private BNTTsInitConfig(Context context, String str, String str2, String str3, String str4, ITTSInitListener iTTSInitListener) {
        this.context = context;
        this.appId = str;
        this.appKey = str2;
        this.secretKey = str3;
        this.authsn = str4;
        this.initListener = iTTSInitListener;
    }
}
