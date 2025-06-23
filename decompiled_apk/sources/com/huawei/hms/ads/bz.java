package com.huawei.hms.ads;

import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.openalliance.ad.inter.data.VideoInfo;

/* loaded from: classes10.dex */
public class bz {
    private NativeAd Code;
    private VideoInfo I;
    private VideoConfiguration V;

    public bz(NativeAd nativeAd) {
        NativeAdConfiguration aq;
        this.Code = nativeAd;
        if (nativeAd instanceof by) {
            by byVar = (by) nativeAd;
            this.I = byVar.Code().C();
            com.huawei.openalliance.ad.inter.data.l Code = byVar.Code();
            if (!(Code instanceof com.huawei.openalliance.ad.inter.data.l) || (aq = Code.aq()) == null) {
                return;
            }
            this.V = aq.getVideoConfiguration();
        }
    }

    public boolean Code() {
        return this.I != null;
    }

    public float I() {
        Float g;
        VideoInfo videoInfo = this.I;
        if (videoInfo == null || (g = videoInfo.g()) == null) {
            return 0.0f;
        }
        return g.floatValue();
    }

    public boolean V() {
        VideoInfo videoInfo = this.I;
        return videoInfo != null && "n".equals(videoInfo.a());
    }

    public boolean Z() {
        VideoConfiguration videoConfiguration = this.V;
        return videoConfiguration != null && videoConfiguration.isCustomizeOperateRequested();
    }
}
