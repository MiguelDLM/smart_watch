package com.huawei.hms.ads;

import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: classes10.dex */
public class gq {
    public static gr Code(AdContentData adContentData) {
        if (adContentData == null) {
            return new gp();
        }
        if (adContentData.t() != null || (adContentData.u() != null && "video/mp4".equals(adContentData.u().Code()))) {
            if (gu.C()) {
                return new gu();
            }
        } else if (gm.Code()) {
            return new gm();
        }
        return new gp();
    }
}
