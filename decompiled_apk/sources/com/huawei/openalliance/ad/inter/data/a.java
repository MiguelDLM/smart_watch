package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.beans.metadata.MetaData;

/* loaded from: classes10.dex */
public class a extends c implements e {
    private static final String I = "AwardAd";
    private static final long Z = 30424300;
    private com.huawei.openalliance.ad.beans.metadata.VideoInfo B;
    private boolean C;
    private RewardItem F;
    private boolean S;

    public a(AdContentData adContentData) {
        super(adContentData);
        this.C = false;
        if (adContentData.N() == null || adContentData.O() == 0) {
            return;
        }
        this.F = new RewardItem(adContentData.N(), adContentData.O());
    }

    private com.huawei.openalliance.ad.beans.metadata.VideoInfo Code() {
        MetaData i_;
        if (this.B == null && (i_ = i_()) != null) {
            this.B = i_.V();
        }
        return this.B;
    }

    @Override // com.huawei.openalliance.ad.inter.data.e
    public boolean B() {
        return this.C;
    }

    @Override // com.huawei.openalliance.ad.inter.data.e
    public RewardItem C() {
        return this.F;
    }

    public void I(boolean z) {
        this.C = z;
    }

    public boolean S() {
        return this.S;
    }

    public void V(boolean z) {
        this.S = z;
    }

    public void Code(RewardItem rewardItem) {
        this.F = rewardItem;
    }

    public boolean V() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            this.B = adContentData.t();
        }
        return this.B != null || ab();
    }
}
