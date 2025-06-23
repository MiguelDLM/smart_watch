package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes10.dex */
public class PermissionEntity implements Serializable {
    private static final long serialVersionUID = -1825501272693801533L;
    private String name;
    private int type;

    public PermissionEntity() {
    }

    public String Code() {
        return this.name;
    }

    public int V() {
        return this.type;
    }

    public PermissionEntity(String str, int i) {
        this.name = str;
        this.type = i;
    }
}
