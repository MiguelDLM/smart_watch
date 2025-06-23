package com.huawei.openalliance.ad.inter.data;

import android.text.TextUtils;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.constant.ca;
import java.io.Serializable;

@DataKeep
@com.huawei.openalliance.ad.annotations.b
/* loaded from: classes10.dex */
public class ImageInfo implements Serializable {
    private static final long serialVersionUID = 30414300;
    private boolean checkSha256;
    private int fileSize;
    private int height;
    private String imageType;
    private String originalUrl;
    private String sha256;
    private String url;
    private int width;

    @com.huawei.openalliance.ad.annotations.b
    public ImageInfo() {
        this.width = 0;
        this.height = 0;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int B() {
        return this.height;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int C() {
        return this.width;
    }

    public void Code(String str) {
        this.originalUrl = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String D() {
        return this.originalUrl;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int F() {
        return this.fileSize;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String I() {
        return this.sha256;
    }

    @com.huawei.openalliance.ad.annotations.b
    public boolean S() {
        return this.checkSha256;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String V() {
        return this.imageType;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String Z() {
        return this.url;
    }

    public ImageInfo(com.huawei.openalliance.ad.beans.metadata.ImageInfo imageInfo) {
        this.width = 0;
        this.height = 0;
        if (imageInfo != null) {
            this.url = imageInfo.I();
            String I = imageInfo.I();
            this.originalUrl = I;
            if (!TextUtils.isEmpty(I) && !this.originalUrl.startsWith(ca.HTTP.toString()) && !this.originalUrl.startsWith(ca.HTTPS.toString())) {
                this.originalUrl = imageInfo.F();
            }
            this.width = imageInfo.Z();
            this.height = imageInfo.B();
            this.sha256 = imageInfo.Code();
            this.imageType = imageInfo.V();
            this.fileSize = imageInfo.C();
            this.checkSha256 = imageInfo.S() == 0;
        }
    }

    public boolean Code() {
        String str = this.url;
        return str != null && str.startsWith(ca.CONTENT.toString());
    }
}
