package com.huawei.hms.ads;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
@AllApi
/* loaded from: classes10.dex */
public class BiddingInfo {
    private String cur;
    private String lurl;
    private String nurl;

    @com.huawei.openalliance.ad.annotations.a
    private Float price;

    /* loaded from: classes10.dex */
    public static final class a {
        private String Code;
        private String I;

        @com.huawei.openalliance.ad.annotations.a
        private Float V;
        private String Z;

        public a Code(Float f) {
            this.V = f;
            return this;
        }

        public a I(String str) {
            this.Z = str;
            return this;
        }

        public a V(String str) {
            this.I = str;
            return this;
        }

        public String toString() {
            return "BiddingInfo{cur = " + this.Code + ", nurl = '" + this.I + ", lurl = " + this.Z + '}';
        }

        public a Code(String str) {
            this.Code = str;
            return this;
        }

        public BiddingInfo Code() {
            return new BiddingInfo(this);
        }
    }

    @AllApi
    public BiddingInfo() {
    }

    public boolean Code() {
        return getPrice() == null && getCur() == null && getNurl() == null && getLurl() == null;
    }

    @AllApi
    public String getCur() {
        return this.cur;
    }

    @AllApi
    public String getLurl() {
        return this.lurl;
    }

    @AllApi
    public String getNurl() {
        return this.nurl;
    }

    @AllApi
    public Float getPrice() {
        return this.price;
    }

    public String toString() {
        return "BiddingInfo{cur = " + this.cur + ", nurl = " + this.nurl + ", lurl = " + this.lurl + '}';
    }

    @AllApi
    public BiddingInfo(a aVar) {
        if (aVar != null) {
            this.cur = aVar.Code;
            this.price = aVar.V;
            this.nurl = aVar.I;
            this.lurl = aVar.Z;
        }
    }
}
