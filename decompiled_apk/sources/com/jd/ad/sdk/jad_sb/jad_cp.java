package com.jd.ad.sdk.jad_sb;

import com.jieli.watchtesttool.tool.upgrade.OTAManager;

/* loaded from: classes10.dex */
public enum jad_cp {
    JSON(".json"),
    ZIP(OTAManager.OTA_ZIP_SUFFIX);

    public final String jad_an;

    jad_cp(String str) {
        this.jad_an = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.jad_an;
    }
}
