package com.huawei.hms.ads;

import android.graphics.drawable.Drawable;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;

/* loaded from: classes10.dex */
public interface kd extends fw {
    void Code(long j);

    void Code(ImageInfo imageInfo, Drawable drawable);

    void Code(VideoInfo videoInfo, boolean z);

    void Code(String str);

    void S();

    void setNativeAd(com.huawei.openalliance.ad.inter.data.g gVar);

    void setPpsNativeView(ki kiVar);
}
