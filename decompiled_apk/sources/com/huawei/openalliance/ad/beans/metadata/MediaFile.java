package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes10.dex */
public class MediaFile implements Serializable {
    private static final long serialVersionUID = 30422300;
    private long fileSize;
    private int height;
    private String sha256;

    @com.huawei.openalliance.ad.annotations.a
    private String url;
    private int width;
    private String mime = "video/mp4";
    private int checkSha256Flag = 0;
    private int downloadNetwork = 0;
    private int playMode = 1;

    public String B() {
        return this.url;
    }

    public String C() {
        return this.sha256;
    }

    public String Code() {
        return this.mime;
    }

    public int D() {
        return this.playMode;
    }

    public int F() {
        return this.downloadNetwork;
    }

    public int I() {
        return this.height;
    }

    public int S() {
        return this.checkSha256Flag;
    }

    public int V() {
        return this.width;
    }

    public long Z() {
        return this.fileSize;
    }
}
