package com.huawei.hms.ads;

import com.huawei.hms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class a extends NativeAd.ChoicesInfo {
    private final String Code = "";
    private final List<Image> V = new ArrayList();

    @Override // com.huawei.hms.ads.nativead.NativeAd.ChoicesInfo
    public String getContent() {
        return "";
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd.ChoicesInfo
    public List<Image> getIcons() {
        return this.V;
    }
}
