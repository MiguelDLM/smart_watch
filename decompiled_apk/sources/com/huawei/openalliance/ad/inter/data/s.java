package com.huawei.openalliance.ad.inter.data;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.ja;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.w;

/* loaded from: classes10.dex */
public class s implements j {
    private static final String Code = "UnifyAd";
    private MetaData I;
    private AdContentData V;
    private AppInfo Z;

    public s(AdContentData adContentData) {
        this.V = adContentData;
        this.I = adContentData.S();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean A() {
        boolean Z = ja.Z(V());
        if (!Z) {
            fb.V(Code, "native ad is not in whiteList, api call event report is not allowed.");
        }
        return Z;
    }

    @Override // com.huawei.openalliance.ad.inter.data.j
    public int Code() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return 0;
        }
        return adContentData.Z();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int E() {
        return ja.a(V());
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String L() {
        MetaData metaData = this.I;
        if (metaData != null) {
            return ay.V(metaData.Code());
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public RewardVerifyConfig M() {
        if (this.V == null) {
            return null;
        }
        RewardVerifyConfig.Builder builder = new RewardVerifyConfig.Builder();
        builder.setData(this.V.at());
        builder.setUserId(this.V.au());
        return builder.build();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String O() {
        AdSource Code2;
        MetaData metaData = this.I;
        if (metaData == null || (Code2 = AdSource.Code(metaData.l())) == null) {
            return null;
        }
        return ay.V(Code2.Code());
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String P() {
        AdSource Code2;
        MetaData metaData = this.I;
        if (metaData == null || (Code2 = AdSource.Code(metaData.l())) == null) {
            return null;
        }
        return ay.V(Code2.V());
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String R() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.aG();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String T() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.aH();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int U() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return 0;
        }
        return adContentData.aN();
    }

    public String V() {
        AdContentData adContentData = this.V;
        if (adContentData != null) {
            return adContentData.v();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean W() {
        MetaData metaData = this.I;
        if (metaData == null) {
            return false;
        }
        return metaData.o();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String Y() {
        AdContentData adContentData = this.V;
        return adContentData != null ? adContentData.aP() : "";
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String a() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.a();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean aa() {
        AdContentData adContentData = this.V;
        return (adContentData == null || !adContentData.aQ() || TextUtils.isEmpty(this.V.aP())) ? false : true;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public PromoteInfo ad() {
        AdContentData adContentData = this.V;
        if (adContentData != null) {
            return adContentData.z();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public BiddingInfo ae() {
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String b() {
        MetaData metaData = this.I;
        if (metaData != null) {
            return metaData.g();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int c() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return 0;
        }
        return adContentData.l();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String d() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.b();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String e() {
        MetaData metaData = this.I;
        if (metaData != null) {
            return ay.V(metaData.L());
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public long f() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return 0L;
        }
        return adContentData.e();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public long g() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return 0L;
        }
        return adContentData.d();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean h() {
        AdContentData adContentData = this.V;
        return adContentData == null || adContentData.d() < System.currentTimeMillis();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String i() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.ac();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String j() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.ad();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String k() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.ae();
    }

    @Override // com.huawei.openalliance.ad.inter.data.j, com.huawei.openalliance.ad.inter.data.d
    public AdContentData n() {
        return this.V;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String o() {
        return this.V.L();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public long u() {
        MetaData metaData = this.I;
        if (metaData != null) {
            return metaData.F();
        }
        return 500L;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int v() {
        MetaData metaData = this.I;
        if (metaData != null) {
            return metaData.D();
        }
        return 50;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public AppInfo y() {
        AppInfo appInfo = this.Z;
        if (appInfo != null) {
            return appInfo;
        }
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        AppInfo y = adContentData.y();
        this.Z = y;
        return y;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public void Code(Context context) {
        if (this.V == null) {
            return;
        }
        V(context);
    }

    public void V(Context context) {
        if (context == null) {
            fb.I(Code, "context is null not call gotoWhyThisAdPage method");
        } else {
            w.Code(context, this.V);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public void Code(RewardVerifyConfig rewardVerifyConfig) {
        AdContentData adContentData = this.V;
        if (adContentData == null || rewardVerifyConfig == null) {
            return;
        }
        adContentData.q(rewardVerifyConfig.getData());
        this.V.r(rewardVerifyConfig.getUserId());
    }
}
