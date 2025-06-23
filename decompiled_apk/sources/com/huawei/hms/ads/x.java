package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.instreamad.InstreamAd;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import java.util.List;

/* loaded from: classes10.dex */
public class x extends InstreamAd {
    private Context I;
    private com.huawei.openalliance.ad.inter.data.n V;

    public x(Context context, com.huawei.openalliance.ad.inter.data.h hVar) {
        this.I = context;
        if (hVar instanceof com.huawei.openalliance.ad.inter.data.n) {
            this.V = (com.huawei.openalliance.ad.inter.data.n) hVar;
        }
    }

    private boolean V() {
        return this.V == null;
    }

    public com.huawei.openalliance.ad.inter.data.h Code() {
        return this.V;
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getAdSign() {
        return V() ? "2" : this.V.b();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getAdSource() {
        if (V()) {
            return null;
        }
        return this.V.e();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public List<AdvertiserInfo> getAdvertiserInfo() {
        if (V()) {
            return null;
        }
        return this.V.D();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public BiddingInfo getBiddingInfo() {
        if (V()) {
            return null;
        }
        return this.V.ae();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getCallToAction() {
        if (V()) {
            return null;
        }
        return com.huawei.hms.ads.utils.a.Code(this.I, this.V.y(), this.V.L());
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getDspLogo() {
        if (V()) {
            return null;
        }
        return this.V.P();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getDspName() {
        if (V()) {
            return null;
        }
        return this.V.O();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public long getDuration() {
        com.huawei.openalliance.ad.inter.data.p S;
        if (V() || (S = this.V.S()) == null) {
            return 0L;
        }
        return S.d();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getTransparencyTplUrl() {
        return !V() ? this.V.Y() : "";
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getWhyThisAd() {
        if (V()) {
            return null;
        }
        return this.V.i();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean hasAdvertiserInfo() {
        if (V()) {
            return false;
        }
        return this.V.o_();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean isClicked() {
        if (V()) {
            return false;
        }
        return this.V.Z();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean isExpired() {
        if (V()) {
            return true;
        }
        return this.V.h();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean isImageAd() {
        if (V()) {
            return false;
        }
        return this.V.I();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean isShown() {
        if (V()) {
            return false;
        }
        return this.V.B();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean isTransparencyOpen() {
        return (V() || !this.V.aa() || TextUtils.isEmpty(this.V.Y())) ? false : true;
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean isVideoAd() {
        if (V()) {
            return false;
        }
        return this.V.V();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        if (V()) {
            return;
        }
        this.V.Code(rewardVerifyConfig);
    }
}
