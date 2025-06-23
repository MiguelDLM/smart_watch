package com.huawei.hms.ads.jsb.inner.data;

import android.text.TextUtils;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.constant.ca;

@DataKeep
/* loaded from: classes10.dex */
public class ImageInfo {
    private int fileSize;
    private int height;
    private String imageType;
    private String url;
    private int width;

    public ImageInfo(com.huawei.openalliance.ad.beans.metadata.ImageInfo imageInfo) {
        this.width = 0;
        this.height = 0;
        if (imageInfo != null) {
            String I = imageInfo.I();
            this.url = I;
            if (!TextUtils.isEmpty(I) && !this.url.startsWith(ca.HTTP.toString()) && !this.url.startsWith(ca.HTTPS.toString())) {
                this.url = imageInfo.F();
            }
            this.width = imageInfo.Z();
            this.height = imageInfo.B();
            this.imageType = imageInfo.V();
            this.fileSize = imageInfo.C();
        }
    }
}
