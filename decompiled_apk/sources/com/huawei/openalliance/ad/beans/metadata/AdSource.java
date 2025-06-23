package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.utils.ad;
import java.io.Serializable;
import java.util.List;

@DataKeep
/* loaded from: classes10.dex */
public class AdSource implements Serializable {
    private static final long serialVersionUID = 6502296986334140841L;
    private int displayPosition;
    private String dspLogo;
    private String dspName;

    public static AdSource Code(List<AdSource> list) {
        if (ad.Code(list)) {
            return null;
        }
        for (AdSource adSource : list) {
            if (Code(adSource)) {
                return adSource;
            }
        }
        return null;
    }

    public static AdSource V(List<AdSource> list) {
        if (ad.Code(list)) {
            return null;
        }
        for (AdSource adSource : list) {
            if (V(adSource)) {
                return adSource;
            }
        }
        return null;
    }

    public int I() {
        return this.displayPosition;
    }

    public String Code() {
        return this.dspName;
    }

    public String V() {
        return this.dspLogo;
    }

    public void Code(int i) {
        this.displayPosition = i;
    }

    public void V(String str) {
        this.dspLogo = str;
    }

    private static boolean V(AdSource adSource) {
        return adSource != null && adSource.I() == 2;
    }

    public void Code(String str) {
        this.dspName = str;
    }

    private static boolean Code(AdSource adSource) {
        return adSource != null && adSource.I() == 1;
    }
}
