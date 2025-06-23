package com.huawei.hms.ads.consent.bean.network;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;
import java.util.ArrayList;
import java.util.List;

@DataKeep
/* loaded from: classes10.dex */
public class ConfirmResultReq {
    private List<ApiStatisticsReq> caches = new ArrayList();

    @AllApi
    public List<ApiStatisticsReq> getCaches() {
        return this.caches;
    }

    @AllApi
    public void setCaches(List<ApiStatisticsReq> list) {
        this.caches = list;
    }
}
