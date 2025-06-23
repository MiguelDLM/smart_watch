package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.utils.ay;
import java.io.Serializable;

@DataKeep
@com.huawei.openalliance.ad.annotations.b
/* loaded from: classes10.dex */
public class RewardItem implements Serializable {
    private static final long serialVersionUID = 30424300;
    int amount;
    String type;

    public RewardItem(String str, int i) {
        this.type = ay.V(str);
        this.amount = i;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String Code() {
        return this.type;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int V() {
        return this.amount;
    }

    public void Code(int i) {
        this.amount = i;
    }

    public void Code(String str) {
        this.type = str;
    }
}
