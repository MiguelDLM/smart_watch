package com.huawei.hms.ads.jsb.inner.data;

import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes10.dex */
class MediaFile {
    private long duration;
    private long fileSize;
    private int height;
    private String mime;
    private Float ratio;
    private String soundSwitch = "y";
    private String url;
    private int width;

    public MediaFile(com.huawei.openalliance.ad.beans.metadata.MediaFile mediaFile, long j) {
        int i;
        this.width = 0;
        this.height = 0;
        if (mediaFile != null) {
            this.mime = mediaFile.Code();
            this.url = mediaFile.B();
            this.fileSize = mediaFile.Z();
            this.width = mediaFile.V();
            this.height = mediaFile.I();
        }
        int i2 = this.width;
        if (i2 > 0 && (i = this.height) > 0) {
            this.ratio = Float.valueOf(i2 / i);
        }
        this.duration = j;
    }

    public int B() {
        return this.height;
    }

    public String C() {
        return this.mime;
    }

    public String Code() {
        return this.url;
    }

    public String I() {
        return this.soundSwitch;
    }

    public long S() {
        return this.duration;
    }

    public long V() {
        return this.fileSize;
    }

    public int Z() {
        return this.width;
    }

    public void Code(String str) {
        this.soundSwitch = str;
    }
}
