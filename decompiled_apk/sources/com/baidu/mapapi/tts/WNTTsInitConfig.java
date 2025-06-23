package com.baidu.mapapi.tts;

import android.content.Context;

/* loaded from: classes7.dex */
public class WNTTsInitConfig {
    public String appKey;
    public String authsn;
    public Context context;
    public String secretKey;

    /* loaded from: classes7.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private Context f6012a;
        private String b;
        private String c;
        private String d;

        public Builder appKey(String str) {
            this.b = str;
            return this;
        }

        public Builder authSn(String str) {
            this.d = str;
            return this;
        }

        public WNTTsInitConfig build() {
            return new WNTTsInitConfig(this.f6012a, this.b, this.c, this.d);
        }

        public Builder context(Context context) {
            this.f6012a = context;
            return this;
        }

        public Builder secretKey(String str) {
            this.c = str;
            return this;
        }
    }

    private WNTTsInitConfig(Context context, String str, String str2, String str3) {
        this.context = context;
        this.appKey = str;
        this.secretKey = str2;
        this.authsn = str3;
    }
}
