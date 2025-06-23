package com.huawei.hms.ads.unity;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

@AllApi
/* loaded from: classes10.dex */
public class UnityNativeAdDelegate {
    private NativeAd Code;
    private UnityImageDelegate Z;
    private List<UnityImageDelegate> V = new ArrayList();
    private List<UnityImageDelegate> I = new ArrayList();

    @AllApi
    public UnityNativeAdDelegate(NativeAd nativeAd) {
        this.Code = nativeAd;
    }

    @AllApi
    public UnityImageDelegate getIcon() {
        return this.Z;
    }

    @AllApi
    public List<UnityImageDelegate> getIcons() {
        return this.Code == null ? new ArrayList() : this.I;
    }

    @AllApi
    public List<UnityImageDelegate> getImages() {
        return this.Code == null ? new ArrayList() : this.V;
    }

    @AllApi
    public NativeAd getNativeAd() {
        return this.Code;
    }

    @AllApi
    public void setIcon(UnityImageDelegate unityImageDelegate) {
        this.Z = unityImageDelegate;
    }

    @AllApi
    public void setIconList(List<UnityImageDelegate> list) {
        this.I.addAll(list);
    }

    @AllApi
    public void setImageList(List<UnityImageDelegate> list) {
        this.V.addAll(list);
    }
}
