package com.huawei.openalliance.ad.inter.data;

import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.openalliance.ad.beans.metadata.MediaFile;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.constant.bf;
import com.huawei.openalliance.ad.utils.ad;
import java.util.List;

/* loaded from: classes10.dex */
public class n extends c implements h, Comparable {
    private p B;
    private boolean F;
    private boolean S;
    private boolean Z;

    public n(AdContentData adContentData) {
        super(adContentData);
        this.Z = false;
        this.S = false;
        this.F = false;
    }

    public boolean B() {
        return this.S;
    }

    public int C() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.K();
        }
        return 0;
    }

    public String Code() {
        MetaData i_ = i_();
        if (i_ != null) {
            return i_.a();
        }
        return null;
    }

    public List<AdvertiserInfo> D() {
        if (this.Code == null || !o_()) {
            return null;
        }
        return this.Code.aL();
    }

    public void I(boolean z) {
        this.F = z;
    }

    @Override // com.huawei.openalliance.ad.inter.data.h
    public p S() {
        MetaData i_;
        MediaFile h;
        if (this.B == null && (i_ = i_()) != null && (h = i_.h()) != null) {
            this.B = new p(h, i_.k());
        }
        return this.B;
    }

    public boolean V() {
        p pVar = this.B;
        return pVar != null && "video/mp4".equals(pVar.b());
    }

    public boolean Z() {
        return this.Z;
    }

    public boolean af() {
        return this.F;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return ((obj instanceof n) && ((n) obj).C() <= C()) ? 1 : -1;
    }

    public boolean o_() {
        if (this.Code != null) {
            return !ad.Code(r0.aL());
        }
        return false;
    }

    public void Code(boolean z) {
        this.Z = z;
    }

    public boolean I() {
        p pVar = this.B;
        return pVar != null && ("image/jpeg".equals(pVar.b()) || bf.B.equals(this.B.b()) || bf.I.equals(this.B.b()) || bf.Z.equals(this.B.b()));
    }
}
