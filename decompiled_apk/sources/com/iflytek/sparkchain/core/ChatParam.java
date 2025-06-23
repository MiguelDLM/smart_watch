package com.iflytek.sparkchain.core;

import com.iflytek.sparkchain.core.AiRequest;

/* loaded from: classes10.dex */
public class ChatParam {
    private String mAuditing;
    private String mChatID;
    private String mDomain;
    private String mUid;
    private String mUrl;
    private float mTemperature = -1.0f;
    private int mTopK = -1;
    private int mMaxToken = -1;
    private AiRequest.Builder paramBuilder = AiRequest.builder();

    private ChatParam() {
    }

    public static ChatParam builder() {
        return new ChatParam();
    }

    public ChatParam auditing(String str) {
        this.mAuditing = str;
        return this;
    }

    public ChatParam chatID(String str) {
        this.mChatID = str;
        return this;
    }

    public ChatParam domain(String str) {
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

    public long getParamListHandle() {
        return this.paramBuilder.build().getHandle();
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

    public ChatParam maxToken(int i) {
        this.mMaxToken = i;
        return this;
    }

    public ChatParam param(String str, double d) {
        this.paramBuilder.param(str, d);
        return this;
    }

    public ChatParam temperature(float f) {
        this.mTemperature = f;
        return this;
    }

    public ChatParam topK(int i) {
        this.mTopK = i;
        return this;
    }

    public ChatParam uid(String str) {
        this.mUid = str;
        return this;
    }

    public ChatParam url(String str) {
        this.mUrl = str;
        return this;
    }

    public ChatParam param(String str, int i) {
        this.paramBuilder.param(str, i);
        return this;
    }

    public ChatParam param(String str, String str2) {
        this.paramBuilder.param(str, str2);
        return this;
    }

    public ChatParam param(String str, boolean z) {
        this.paramBuilder.param(str, z);
        return this;
    }
}
