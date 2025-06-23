package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class MediationViewBinder implements IMediationViewBinder {
    public final int callToActionId;
    public final int decriptionTextId;
    public final Map<String, Integer> extras;
    public final int groupImage1Id;
    public final int groupImage2Id;
    public final int groupImage3Id;
    public final int iconImageId;
    public final int layoutId;
    public final int logoLayoutId;
    public final int mainImageId;
    public final int mediaViewId;
    public final int shakeViewContainerId;
    public final int sourceId;
    public final int titleId;

    /* loaded from: classes8.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        protected int f10840a;
        protected int b;
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        protected int h;
        protected int i;
        protected int j;
        protected int k;
        protected int l;
        protected int m;
        protected Map<String, Integer> n;

        public Builder(int i) {
            this.n = Collections.emptyMap();
            this.f10840a = i;
            this.n = new HashMap();
        }

        public Builder addExtra(String str, int i) {
            this.n.put(str, Integer.valueOf(i));
            return this;
        }

        public Builder addExtras(Map<String, Integer> map) {
            this.n = new HashMap(map);
            return this;
        }

        public MediationViewBinder build() {
            return new MediationViewBinder(this);
        }

        public Builder callToActionId(int i) {
            this.d = i;
            return this;
        }

        public Builder descriptionTextId(int i) {
            this.c = i;
            return this;
        }

        public Builder groupImage1Id(int i) {
            this.j = i;
            return this;
        }

        public Builder groupImage2Id(int i) {
            this.k = i;
            return this;
        }

        public Builder groupImage3Id(int i) {
            this.l = i;
            return this;
        }

        public Builder iconImageId(int i) {
            this.e = i;
            return this;
        }

        public Builder logoLayoutId(int i) {
            this.i = i;
            return this;
        }

        public Builder mainImageId(int i) {
            this.f = i;
            return this;
        }

        public Builder mediaViewIdId(int i) {
            this.g = i;
            return this;
        }

        public Builder shakeViewContainerId(int i) {
            this.m = i;
            return this;
        }

        public Builder sourceId(int i) {
            this.h = i;
            return this;
        }

        public Builder titleId(int i) {
            this.b = i;
            return this;
        }
    }

    public MediationViewBinder(Builder builder) {
        this.layoutId = builder.f10840a;
        this.titleId = builder.b;
        this.decriptionTextId = builder.c;
        this.callToActionId = builder.d;
        this.iconImageId = builder.e;
        this.mainImageId = builder.f;
        this.mediaViewId = builder.g;
        this.sourceId = builder.h;
        this.extras = builder.n;
        this.groupImage1Id = builder.j;
        this.groupImage2Id = builder.k;
        this.groupImage3Id = builder.l;
        this.logoLayoutId = builder.i;
        this.shakeViewContainerId = builder.m;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getCallToActionId() {
        return this.callToActionId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getDecriptionTextId() {
        return this.decriptionTextId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public Map<String, Integer> getExtras() {
        return this.extras;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage1Id() {
        return this.groupImage1Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage2Id() {
        return this.groupImage2Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage3Id() {
        return this.groupImage3Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getIconImageId() {
        return this.iconImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLogoLayoutId() {
        return this.logoLayoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMainImageId() {
        return this.mainImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMediaViewId() {
        return this.mediaViewId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getShakeViewContainerId() {
        return this.shakeViewContainerId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getSourceId() {
        return this.sourceId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getTitleId() {
        return this.titleId;
    }
}
