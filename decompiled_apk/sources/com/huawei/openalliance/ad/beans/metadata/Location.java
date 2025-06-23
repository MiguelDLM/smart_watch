package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.b;
import com.huawei.openalliance.ad.annotations.c;
import com.huawei.openalliance.ad.annotations.d;
import com.huawei.openalliance.ad.utils.aj;

@DataKeep
@b
/* loaded from: classes10.dex */
public class Location {
    private int clctSource;
    private Long clctTime;
    private Integer lastfix;

    @c(Code = "lat")
    @com.huawei.openalliance.ad.annotations.a
    private Double latitude;

    @d
    private com.huawei.openalliance.ad.beans.inner.b locationSwitches;

    @c(Code = "lon")
    @com.huawei.openalliance.ad.annotations.a
    private Double longitude;

    public Location() {
    }

    public Integer B() {
        return this.lastfix;
    }

    public int C() {
        return this.clctSource;
    }

    public Location Code() {
        Location location = new Location();
        location.longitude = this.longitude;
        location.latitude = this.latitude;
        location.lastfix = this.lastfix;
        location.clctTime = this.clctTime;
        location.clctSource = this.clctSource;
        return location;
    }

    public Double I() {
        return this.latitude;
    }

    public com.huawei.openalliance.ad.beans.inner.b S() {
        return this.locationSwitches;
    }

    public Double V() {
        return this.longitude;
    }

    public Long Z() {
        return this.clctTime;
    }

    @b
    public Location(Double d, Double d2) {
        Code(d);
        V(d2);
    }

    public void Code(int i) {
        this.clctSource = i;
    }

    public void V(Double d) {
        this.latitude = aj.Code(d, 4, 4);
    }

    public void Code(com.huawei.openalliance.ad.beans.inner.b bVar) {
        this.locationSwitches = bVar;
    }

    public void Code(Double d) {
        this.longitude = aj.Code(d, 4, 4);
    }

    public void Code(Integer num) {
        this.lastfix = num;
    }

    public void Code(Long l) {
        this.clctTime = l;
    }
}
