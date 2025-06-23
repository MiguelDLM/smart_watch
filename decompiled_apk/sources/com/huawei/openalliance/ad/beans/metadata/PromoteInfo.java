package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.utils.ay;
import java.io.Serializable;

@DataKeep
/* loaded from: classes10.dex */
public class PromoteInfo implements Serializable {
    private static final long serialVersionUID = 5783856735147861149L;
    private String name;
    private int type;

    public void Code(int i) {
        this.type = i;
    }

    @AllApi
    public String getName() {
        return ay.V(this.name);
    }

    @AllApi
    public int getType() {
        return this.type;
    }

    public void Code(String str) {
        this.name = str;
    }
}
