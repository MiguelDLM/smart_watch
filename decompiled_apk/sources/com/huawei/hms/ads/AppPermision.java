package com.huawei.hms.ads;

import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.inter.data.PermissionEntity;

@GlobalApi
@DataKeep
/* loaded from: classes10.dex */
public class AppPermision {
    private String name;
    private int type;

    public AppPermision(PermissionEntity permissionEntity) {
        if (permissionEntity != null) {
            this.name = permissionEntity.Code();
            this.type = permissionEntity.V();
        }
    }

    @GlobalApi
    public String getName() {
        return this.name;
    }

    @GlobalApi
    public int getType() {
        return this.type;
    }
}
