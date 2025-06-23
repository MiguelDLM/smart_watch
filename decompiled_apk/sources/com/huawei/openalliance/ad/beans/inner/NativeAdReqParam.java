package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.util.List;

@DataKeep
/* loaded from: classes10.dex */
public class NativeAdReqParam extends BaseAdReqParam {
    private List<String> cacheContentIds;
    private boolean enableDirectCacheVideo;
    private boolean enableDirectReturnVideoAd;
    private boolean enableVideoDownloadInMobileNetwork;
    private String extraInfo;
    private int linkedVideoMode = 0;

    public void Code(String str) {
        this.extraInfo = str;
    }

    public void I(boolean z) {
        this.enableDirectCacheVideo = z;
    }

    public void V(boolean z) {
        this.enableDirectReturnVideoAd = z;
    }

    public void Code(List<String> list) {
        this.cacheContentIds = list;
    }

    public void Code(boolean z) {
        this.enableVideoDownloadInMobileNetwork = z;
    }
}
