package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes10.dex */
public class Permission implements Serializable {
    private static final long serialVersionUID = 5884421861234976573L;
    private String groupDesc;
    private String permissionLabel;

    public String Code() {
        return this.permissionLabel;
    }

    public String V() {
        return this.groupDesc;
    }
}
