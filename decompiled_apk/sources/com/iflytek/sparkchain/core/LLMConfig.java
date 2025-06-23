package com.iflytek.sparkchain.core;

import com.iflytek.sparkchain.core.AiRequest;

/* loaded from: classes10.dex */
public class LLMConfig {
    private String mAuditing;
    private String mChatID;
    private String mDomain;
    private boolean mShowRefLabel;
    private String mUid;
    private String mUrl;
    private float mTemperature = -1.0f;
    private int mTopK = -1;
    private int mMaxToken = -1;
    private AiRequest.Builder paramBuilder = null;
    private int mHandleId = -1;

    private LLMConfig() {
    }

    public static LLMConfig builder() {
        return new LLMConfig();
    }

    public LLMConfig auditing(String str) {
        this.mAuditing = str;
        return this;
    }

    public LLMConfig chatID(String str) {
        this.mChatID = str;
        return this;
    }

    public LLMConfig domain(String str) {
        this.mDomain = str;
        return this;
    }

    public String getAuditing() {
        return this.mAuditing;
    }

    public String getChatID() {
        return this.mChatID;
    }

    public String getDomain() {
        return this.mDomain;
    }

    public int getMaxToken() {
        return this.mMaxToken;
    }

    public float getTemperature() {
        return this.mTemperature;
    }

    public int getTopK() {
        return this.mTopK;
    }

    public String getUid() {
        return this.mUid;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean isShowRefLabel() {
        return this.mShowRefLabel;
    }

    public LLMConfig maxToken(int i) {
        this.mMaxToken = i;
        return this;
    }

    public LLMConfig param(String str, double d) {
        if (this.paramBuilder == null) {
            AiRequest.Builder builder = AiRequest.builder();
            this.paramBuilder = builder;
            this.mHandleId = builder.build().getHandle();
        }
        this.paramBuilder.param(str, d);
        return this;
    }

    public LLMConfig showRefLabel(boolean z) {
        this.mShowRefLabel = z;
        return this;
    }

    public LLMConfig temperature(float f) {
        this.mTemperature = f;
        return this;
    }

    public LLMConfig topK(int i) {
        this.mTopK = i;
        return this;
    }

    public LLMConfig uid(String str) {
        this.mUid = str;
        return this;
    }

    public LLMConfig url(String str) {
        this.mUrl = str;
        return this;
    }

    public LLMConfig param(String str, int i) {
        if (this.paramBuilder == null) {
            AiRequest.Builder builder = AiRequest.builder();
            this.paramBuilder = builder;
            this.mHandleId = builder.build().getHandle();
        }
        this.paramBuilder.param(str, i);
        return this;
    }

    public LLMConfig param(String str, String str2) {
        if (this.paramBuilder == null) {
            AiRequest.Builder builder = AiRequest.builder();
            this.paramBuilder = builder;
            this.mHandleId = builder.build().getHandle();
        }
        this.paramBuilder.param(str, str2);
        return this;
    }

    public LLMConfig param(String str, boolean z) {
        if (this.paramBuilder == null) {
            AiRequest.Builder builder = AiRequest.builder();
            this.paramBuilder = builder;
            this.mHandleId = builder.build().getHandle();
        }
        this.paramBuilder.param(str, z);
        return this;
    }
}
