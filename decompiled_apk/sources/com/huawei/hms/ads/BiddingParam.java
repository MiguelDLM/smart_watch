package com.huawei.hms.ads;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;
import java.util.List;

@DataKeep
@AllApi
/* loaded from: classes10.dex */
public class BiddingParam {
    private static final String TAG = "BiddingParam";

    @com.huawei.openalliance.ad.annotations.a
    private Float bidFloor;
    private String bidFloorCur;
    private List<String> bpkgName;

    @AllApi
    /* loaded from: classes10.dex */
    public static final class Builder {

        @com.huawei.openalliance.ad.annotations.a
        private Float Code;
        private List<String> I;
        private String V;

        @AllApi
        public BiddingParam build() {
            return new BiddingParam(this);
        }

        @AllApi
        public Builder setBidFloor(Float f) {
            this.Code = f;
            return this;
        }

        @AllApi
        public Builder setBidFloorCur(String str) {
            this.V = str;
            return this;
        }

        @AllApi
        public Builder setBpkgName(List<String> list) {
            this.I = list;
            return this;
        }

        public String toString() {
            return "BiddingParam{bidFloorCur = " + this.V + ", bpkgName = " + this.I + '}';
        }
    }

    @AllApi
    public BiddingParam() {
    }

    public Float Code() {
        return this.bidFloor;
    }

    public List<String> I() {
        return this.bpkgName;
    }

    public String V() {
        return this.bidFloorCur;
    }

    public String toString() {
        return "BiddingParam{bidFloorCur = " + this.bidFloorCur + ", bpkgName = " + this.bpkgName + '}';
    }

    @AllApi
    public BiddingParam(Builder builder) {
        if (builder != null) {
            this.bidFloor = builder.Code;
            this.bidFloorCur = builder.V;
            this.bpkgName = builder.I;
        }
    }
}
