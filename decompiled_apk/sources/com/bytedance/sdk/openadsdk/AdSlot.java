package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import com.garmin.fit.X0xOO;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class AdSlot implements SlotType {
    private String A;

    /* renamed from: a, reason: collision with root package name */
    private String f10642a;
    private int b;
    private int c;
    private float d;
    private float e;
    private int f;
    private boolean g;
    private boolean h;
    private boolean i;
    private String j;
    private String k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private int[] p;
    private int q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private TTAdLoadType x;
    private IMediationAdSlot y;
    private int z;

    /* loaded from: classes8.dex */
    public static class Builder {
        private String A;

        /* renamed from: a, reason: collision with root package name */
        private String f10643a;
        private String h;
        private int k;
        private int l;
        private float m;
        private float n;
        private int[] p;
        private int q;
        private String r;
        private String s;
        private String t;
        private String v;
        private String w;
        private String x;
        private IMediationAdSlot y;
        private int z;
        private int b = ScreenUtil.SCREEN_SIZE_Y_LARGE;
        private int c = X0xOO.f13583O0o0;
        private boolean d = true;
        private boolean e = false;
        private boolean f = false;
        private int g = 1;
        private String i = "defaultUser";
        private int j = 2;
        private boolean o = true;
        private TTAdLoadType u = TTAdLoadType.UNKNOWN;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.f10642a = this.f10643a;
            adSlot.f = this.g;
            adSlot.g = this.d;
            adSlot.h = this.e;
            adSlot.i = this.f;
            adSlot.b = this.b;
            adSlot.c = this.c;
            adSlot.d = this.m;
            adSlot.e = this.n;
            adSlot.j = this.h;
            adSlot.k = this.i;
            adSlot.l = this.j;
            adSlot.n = this.k;
            adSlot.o = this.o;
            adSlot.p = this.p;
            adSlot.q = this.q;
            adSlot.r = this.r;
            adSlot.t = this.v;
            adSlot.u = this.w;
            adSlot.v = this.x;
            adSlot.m = this.l;
            adSlot.s = this.s;
            adSlot.w = this.t;
            adSlot.x = this.u;
            adSlot.A = this.A;
            adSlot.z = this.z;
            adSlot.y = this.y;
            return adSlot;
        }

        public Builder setAdCount(int i) {
            if (i <= 0) {
                i = 1;
            }
            if (i > 20) {
                i = 20;
            }
            this.g = i;
            return this;
        }

        public Builder setAdId(String str) {
            this.v = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.u = tTAdLoadType;
            return this;
        }

        public Builder setAdType(int i) {
            this.l = i;
            return this;
        }

        public Builder setAdloadSeq(int i) {
            this.q = i;
            return this;
        }

        public Builder setCodeId(String str) {
            this.f10643a = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.w = str;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f, float f2) {
            this.m = f;
            this.n = f2;
            return this;
        }

        public Builder setExt(String str) {
            this.x = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.p = iArr;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.b = i;
            this.c = i2;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.o = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.h = str;
            return this;
        }

        public Builder setMediationAdSlot(IMediationAdSlot iMediationAdSlot) {
            this.y = iMediationAdSlot;
            return this;
        }

        @Deprecated
        public Builder setNativeAdType(int i) {
            this.k = i;
            return this;
        }

        public Builder setOrientation(int i) {
            this.j = i;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.r = str;
            return this;
        }

        public Builder setRewardAmount(int i) {
            this.z = i;
            return this;
        }

        public Builder setRewardName(String str) {
            this.A = str;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setUserData(String str) {
            this.t = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.i = str;
            return this;
        }

        public Builder supportIconStyle() {
            this.f = true;
            return this;
        }

        public Builder supportRenderControl() {
            this.e = true;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.s = str;
            return this;
        }
    }

    public int getAdCount() {
        return this.f;
    }

    public String getAdId() {
        return this.t;
    }

    public TTAdLoadType getAdLoadType() {
        return this.x;
    }

    public int getAdType() {
        return this.m;
    }

    public int getAdloadSeq() {
        return this.q;
    }

    public String getBidAdm() {
        return this.s;
    }

    public String getCodeId() {
        return this.f10642a;
    }

    public String getCreativeId() {
        return this.u;
    }

    public float getExpressViewAcceptedHeight() {
        return this.e;
    }

    public float getExpressViewAcceptedWidth() {
        return this.d;
    }

    public String getExt() {
        return this.v;
    }

    public int[] getExternalABVid() {
        return this.p;
    }

    public int getImgAcceptedHeight() {
        return this.c;
    }

    public int getImgAcceptedWidth() {
        return this.b;
    }

    public String getMediaExtra() {
        return this.j;
    }

    public IMediationAdSlot getMediationAdSlot() {
        return this.y;
    }

    @Deprecated
    public int getNativeAdType() {
        return this.n;
    }

    public int getOrientation() {
        return this.l;
    }

    public String getPrimeRit() {
        String str = this.r;
        if (str == null) {
            return "";
        }
        return str;
    }

    public int getRewardAmount() {
        return this.z;
    }

    public String getRewardName() {
        return this.A;
    }

    public String getUserData() {
        return this.w;
    }

    public String getUserID() {
        return this.k;
    }

    public boolean isAutoPlay() {
        return this.o;
    }

    public boolean isSupportDeepLink() {
        return this.g;
    }

    public boolean isSupportIconStyle() {
        return this.i;
    }

    public boolean isSupportRenderConrol() {
        return this.h;
    }

    public void setAdCount(int i) {
        this.f = i;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.x = tTAdLoadType;
    }

    public void setExternalABVid(int... iArr) {
        this.p = iArr;
    }

    public void setGroupLoadMore(int i) {
        this.j = a(this.j, i);
    }

    public void setNativeAdType(int i) {
        this.n = i;
    }

    public void setUserData(String str) {
        this.w = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.f10642a);
            jSONObject.put("mIsAutoPlay", this.o);
            jSONObject.put("mImgAcceptedWidth", this.b);
            jSONObject.put("mImgAcceptedHeight", this.c);
            jSONObject.put("mExpressViewAcceptedWidth", this.d);
            jSONObject.put("mExpressViewAcceptedHeight", this.e);
            jSONObject.put("mAdCount", this.f);
            jSONObject.put("mSupportDeepLink", this.g);
            jSONObject.put("mSupportRenderControl", this.h);
            jSONObject.put("mSupportIconStyle", this.i);
            jSONObject.put("mMediaExtra", this.j);
            jSONObject.put("mUserID", this.k);
            jSONObject.put("mOrientation", this.l);
            jSONObject.put("mNativeAdType", this.n);
            jSONObject.put("mAdloadSeq", this.q);
            jSONObject.put("mPrimeRit", this.r);
            jSONObject.put("mAdId", this.t);
            jSONObject.put("mCreativeId", this.u);
            jSONObject.put("mExt", this.v);
            jSONObject.put("mBidAdm", this.s);
            jSONObject.put("mUserData", this.w);
            jSONObject.put("mAdLoadType", this.x);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.f10642a + "', mImgAcceptedWidth=" + this.b + ", mImgAcceptedHeight=" + this.c + ", mExpressViewAcceptedWidth=" + this.d + ", mExpressViewAcceptedHeight=" + this.e + ", mAdCount=" + this.f + ", mSupportDeepLink=" + this.g + ", mSupportRenderControl=" + this.h + ", mSupportIconStyle=" + this.i + ", mMediaExtra='" + this.j + "', mUserID='" + this.k + "', mOrientation=" + this.l + ", mNativeAdType=" + this.n + ", mIsAutoPlay=" + this.o + ", mPrimeRit" + this.r + ", mAdloadSeq" + this.q + ", mAdId" + this.t + ", mCreativeId" + this.u + ", mExt" + this.v + ", mUserData" + this.w + ", mAdLoadType" + this.x + '}';
    }

    private AdSlot() {
        this.l = 2;
        this.o = true;
    }

    private String a(String str, int i) {
        JSONObject jSONObject;
        if (i < 1) {
            return str;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_tt_group_load_more", i);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return str;
        }
    }
}
