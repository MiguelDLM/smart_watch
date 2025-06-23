package com.jd.ad.sdk.bl.initsdk;

import androidx.annotation.Nullable;
import com.jd.ad.sdk.dl.baseinfo.JADLocation;

/* loaded from: classes10.dex */
public abstract class JADPrivateController {
    public String getIP() {
        return "0.0.0.0";
    }

    public String getImei() {
        return "";
    }

    @Nullable
    public JADLocation getLocation() {
        return new JADLocation(-1.0d, -1.0d, -1.0d);
    }

    public abstract String getOaid();

    public boolean isCanUseIP() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }

    @Deprecated
    public boolean isCanUsePhoneState() {
        return false;
    }
}
