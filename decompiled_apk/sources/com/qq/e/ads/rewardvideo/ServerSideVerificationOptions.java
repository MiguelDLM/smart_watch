package com.qq.e.ads.rewardvideo;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public class ServerSideVerificationOptions {
    public static final String ACTION = "rewardAction";
    public static final String TRANS_ID = "transId";

    /* renamed from: a, reason: collision with root package name */
    private String f19427a;
    private String b;
    private final JSONObject c;

    /* loaded from: classes11.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f19428a;
        private String b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }

        public Builder setCustomData(String str) {
            this.f19428a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.b = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.c = new JSONObject();
        this.f19427a = builder.f19428a;
        this.b = builder.b;
    }

    public String getCustomData() {
        return this.f19427a;
    }

    public JSONObject getOptions() {
        return this.c;
    }

    public String getUserId() {
        return this.b;
    }
}
