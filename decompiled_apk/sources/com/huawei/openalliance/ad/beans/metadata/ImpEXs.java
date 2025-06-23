package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.util.List;

@DataKeep
/* loaded from: classes10.dex */
public class ImpEXs {
    private List<ImpEX> impEXs;

    public ImpEXs() {
    }

    public List<ImpEX> Code() {
        return this.impEXs;
    }

    public ImpEXs(List<ImpEX> list) {
        this.impEXs = list;
    }

    public void Code(List<ImpEX> list) {
        this.impEXs = list;
    }
}
