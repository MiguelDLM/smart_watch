package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class MediationAdSlot implements IMediationAdSlot {

    /* renamed from: a, reason: collision with root package name */
    private boolean f10836a;
    private boolean b;
    private String c;
    private int d;
    private float e;
    private boolean f;
    private boolean g;
    private Map<String, Object> h;
    private boolean i;
    private String j;
    private boolean k;
    private MediationNativeToBannerListener l;
    private float m;
    private float n;
    private String o;
    private MediationSplashRequestInfo p;

    /* loaded from: classes8.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private boolean f10837a;
        private boolean b;
        private boolean c;
        private float d;
        private boolean e;
        private boolean g;
        private String h;
        private int j;
        private boolean k;
        private MediationNativeToBannerListener l;
        private String o;
        private MediationSplashRequestInfo p;
        private Map<String, Object> f = new HashMap();
        private String i = "";
        private float m = 80.0f;
        private float n = 80.0f;

        public MediationAdSlot build() {
            MediationAdSlot mediationAdSlot = new MediationAdSlot();
            mediationAdSlot.f10836a = this.f10837a;
            mediationAdSlot.b = this.b;
            mediationAdSlot.g = this.c;
            mediationAdSlot.e = this.d;
            mediationAdSlot.f = this.e;
            mediationAdSlot.h = this.f;
            mediationAdSlot.i = this.g;
            mediationAdSlot.j = this.h;
            mediationAdSlot.c = this.i;
            mediationAdSlot.d = this.j;
            mediationAdSlot.k = this.k;
            mediationAdSlot.l = this.l;
            mediationAdSlot.m = this.m;
            mediationAdSlot.n = this.n;
            mediationAdSlot.o = this.o;
            mediationAdSlot.p = this.p;
            return mediationAdSlot;
        }

        public Builder setAllowShowCloseBtn(boolean z) {
            this.k = z;
            return this;
        }

        public Builder setBidNotify(boolean z) {
            this.g = z;
            return this;
        }

        public Builder setExtraObject(String str, Object obj) {
            Map<String, Object> map = this.f;
            if (map != null) {
                map.put(str, obj);
            }
            return this;
        }

        public Builder setMediationNativeToBannerListener(MediationNativeToBannerListener mediationNativeToBannerListener) {
            this.l = mediationNativeToBannerListener;
            return this;
        }

        public Builder setMediationSplashRequestInfo(MediationSplashRequestInfo mediationSplashRequestInfo) {
            this.p = mediationSplashRequestInfo;
            return this;
        }

        public Builder setMuted(boolean z) {
            this.c = z;
            return this;
        }

        @Deprecated
        public Builder setRewardAmount(int i) {
            this.j = i;
            return this;
        }

        @Deprecated
        public Builder setRewardName(String str) {
            this.i = str;
            return this;
        }

        public Builder setScenarioId(String str) {
            this.h = str;
            return this;
        }

        public Builder setShakeViewSize(float f, float f2) {
            this.m = f;
            this.n = f2;
            return this;
        }

        public Builder setSplashPreLoad(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setSplashShakeButton(boolean z) {
            this.f10837a = z;
            return this;
        }

        public Builder setUseSurfaceView(boolean z) {
            this.e = z;
            return this;
        }

        public Builder setVolume(float f) {
            this.d = f;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.o = str;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public Map<String, Object> getExtraObject() {
        return this.h;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public int getRewardAmount() {
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getRewardName() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getScenarioId() {
        return this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewHeight() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewWidth() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getVolume() {
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getWxAppId() {
        return this.o;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isAllowShowCloseBtn() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isBidNotify() {
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isMuted() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashPreLoad() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashShakeButton() {
        return this.f10836a;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isUseSurfaceView() {
        return this.f;
    }

    private MediationAdSlot() {
        this.c = "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationNativeToBannerListener getMediationNativeToBannerListener() {
        return this.l;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationSplashRequestInfo getMediationSplashRequestInfo() {
        return this.p;
    }
}
