package com.huawei.openalliance.ad.inter.data;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.ja;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.CtrlExt;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes10.dex */
public abstract class c implements d {
    private static final String I = "BaseAd";
    private String B;
    private String C;
    protected AdContentData Code;
    private boolean D = false;
    private List<AdSource> F;
    private AppInfo S;
    protected String V;
    private String Z;

    public c(AdContentData adContentData) {
        this.Z = UUID.randomUUID().toString();
        this.Code = adContentData;
        if (adContentData != null) {
            if (TextUtils.isEmpty(adContentData.aa())) {
                this.Code.S(this.Z);
            } else {
                this.Z = this.Code.aa();
            }
        }
    }

    public static List<ImageInfo> Code(List<com.huawei.openalliance.ad.beans.metadata.ImageInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<com.huawei.openalliance.ad.beans.metadata.ImageInfo> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new ImageInfo(it.next()));
            }
        }
        return arrayList;
    }

    private void V(Context context) {
        if (context == null) {
            fb.I(I, "context is null not call gotoWhyThisAdPage method");
        } else {
            w.Code(context, this.Code);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean A() {
        boolean Z = ja.Z(m_());
        if (!Z) {
            fb.V(I, "native ad is not in whiteList, api call event report is not allowed.");
        }
        return Z;
    }

    public void B(boolean z) {
        this.D = z;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int E() {
        return ja.a(m_());
    }

    public CtrlExt F() {
        AdContentData adContentData = this.Code;
        if (adContentData == null) {
            return null;
        }
        return adContentData.V();
    }

    public DelayInfo H() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.an();
        }
        return null;
    }

    public void I(String str) {
        if (str != null) {
            this.Code.i(str);
        }
    }

    public String J() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.at();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String L() {
        MetaData i_;
        if (this.B == null && (i_ = i_()) != null) {
            this.B = ay.V(i_.Code());
        }
        return this.B;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public RewardVerifyConfig M() {
        RewardVerifyConfig.Builder builder = new RewardVerifyConfig.Builder();
        builder.setData(J());
        builder.setUserId(n_());
        return builder.build();
    }

    public List<AdSource> N() {
        MetaData i_;
        if (this.F == null && (i_ = i_()) != null) {
            this.F = i_.l();
        }
        return this.F;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String O() {
        AdSource Code = AdSource.Code(N());
        if (Code != null) {
            return ay.V(Code.Code());
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String P() {
        AdSource Code = AdSource.Code(N());
        if (Code != null) {
            return Code.V();
        }
        return null;
    }

    public String Q() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.r();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String R() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.aG();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String T() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.aH();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int U() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.aN();
        }
        return 0;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean W() {
        MetaData i_ = i_();
        if (i_ != null) {
            return i_.o();
        }
        return false;
    }

    public boolean X() {
        return this.D;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String Y() {
        AdContentData adContentData = this.Code;
        return adContentData != null ? adContentData.aP() : "";
    }

    public void Z(boolean z) {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            adContentData.V(z);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String a() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.a();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean aa() {
        AdContentData adContentData = this.Code;
        return (adContentData == null || !adContentData.aQ() || TextUtils.isEmpty(this.Code.aP())) ? false : true;
    }

    public boolean ab() {
        AdContentData adContentData = this.Code;
        return adContentData != null && adContentData.aF() == 3;
    }

    public String ac() {
        AdContentData adContentData = this.Code;
        if (adContentData == null) {
            return null;
        }
        return adContentData.aE();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public PromoteInfo ad() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.z();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public BiddingInfo ae() {
        if (this.Code == null) {
            return null;
        }
        BiddingInfo.a I2 = new BiddingInfo.a().Code(this.Code.aV()).Code(this.Code.aW()).V(this.Code.aX()).I(this.Code.aY());
        if (I2.Code().Code()) {
            return null;
        }
        return I2.Code();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String b() {
        MetaData i_ = i_();
        return i_ != null ? i_.g() : "2";
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int c() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.l();
        }
        return 0;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String d() {
        AdContentData adContentData = this.Code;
        return adContentData != null ? adContentData.b() : "";
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String e() {
        MetaData i_;
        if (this.C == null && (i_ = i_()) != null) {
            this.C = ay.V(i_.L());
        }
        return this.C;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        String a2 = a();
        if (!(obj instanceof c) || a2 == null) {
            return false;
        }
        return TextUtils.equals(a2, ((c) obj).a());
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public long f() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.e();
        }
        return 0L;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public long g() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.d();
        }
        return 0L;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean h() {
        return g() < System.currentTimeMillis();
    }

    public int hashCode() {
        String a2 = a();
        return (a2 != null ? a2.hashCode() : -1) & super.hashCode();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String i() {
        AdContentData adContentData = this.Code;
        String ac = adContentData != null ? adContentData.ac() : null;
        return TextUtils.isEmpty(ac) ? x.ao : ac;
    }

    public MetaData i_() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.S();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String j() {
        AdContentData adContentData = this.Code;
        return adContentData != null ? adContentData.ad() : "";
    }

    public int j_() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.Z();
        }
        return -1;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String k() {
        AdContentData adContentData = this.Code;
        return adContentData != null ? adContentData.ae() : "";
    }

    public long k_() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.aB();
        }
        return 0L;
    }

    public String l() {
        MetaData i_ = i_();
        return i_ != null ? i_.c() : "";
    }

    public int l_() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.j();
        }
        return 0;
    }

    public String m_() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.v();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public AdContentData n() {
        return this.Code;
    }

    public String n_() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.au();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String o() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.L();
        }
        return null;
    }

    public boolean p_() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.x();
        }
        return false;
    }

    public String q() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.M();
        }
        return null;
    }

    public String r() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.D();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public long u() {
        MetaData i_ = i_();
        if (i_ != null) {
            return i_.F();
        }
        return 500L;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int v() {
        MetaData i_ = i_();
        if (i_ != null) {
            return i_.D();
        }
        return 50;
    }

    public String w() {
        MetaData i_ = i_();
        return i_ != null ? i_.b() : "";
    }

    public String x() {
        return this.Z;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public AppInfo y() {
        MetaData i_;
        ApkInfo e;
        if (this.S == null && (i_ = i_()) != null && (e = i_.e()) != null) {
            AppInfo appInfo = new AppInfo(e);
            appInfo.Code(l());
            appInfo.V(x());
            appInfo.a(i_.I());
            this.S = appInfo;
        }
        return this.S;
    }

    public List<Integer> z() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.q();
        }
        return null;
    }

    public void Code(long j) {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            adContentData.Z(j);
        }
    }

    public void V(String str) {
        if (str != null) {
            this.Code.r(str);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public void Code(Context context) {
        V(context);
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public void Code(RewardVerifyConfig rewardVerifyConfig) {
        if (this.Code == null || rewardVerifyConfig == null) {
            return;
        }
        Code(rewardVerifyConfig.getData());
        V(rewardVerifyConfig.getUserId());
    }

    public void Code(String str) {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            adContentData.q(str);
        }
    }
}
