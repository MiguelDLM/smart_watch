package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.AdSessionConfiguration;

/* loaded from: classes10.dex */
public class ha implements hh {
    private static boolean Code = gw.Code(gw.g);
    private static final String V = "AdSessionConfiguration";
    private AdSessionConfiguration I;

    private ha(hd hdVar, hi hiVar, hj hjVar, hj hjVar2, boolean z) {
        this.I = null;
        if (hd.Code() && hi.Code() && hj.Code()) {
            this.I = AdSessionConfiguration.createAdSessionConfiguration(hd.Code(hdVar), hi.Code(hiVar), hj.Code(hjVar), hj.Code(hjVar2), z);
        }
    }

    public static ha Code(hd hdVar, hi hiVar, hj hjVar, hj hjVar2, boolean z) {
        if (Code) {
            return new ha(hdVar, hiVar, hjVar, hjVar2, z);
        }
        return null;
    }

    public AdSessionConfiguration V() {
        return this.I;
    }

    public static boolean Code() {
        return Code;
    }
}
