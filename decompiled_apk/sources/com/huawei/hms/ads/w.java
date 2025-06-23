package com.huawei.hms.ads;

import android.net.Uri;
import com.huawei.openalliance.ad.inter.data.VideoInfo;

/* loaded from: classes10.dex */
public class w extends Video {
    private Uri Code;
    private int I;
    private Float V;

    public w(VideoInfo videoInfo) {
        if (videoInfo != null) {
            this.Code = Uri.parse(videoInfo.V());
            this.V = videoInfo.g();
            this.I = videoInfo.I();
        }
    }

    @Override // com.huawei.hms.ads.Video
    public float getAspectRatio() {
        Float f = this.V;
        if (f == null) {
            return 1.7777778f;
        }
        return f.floatValue();
    }

    @Override // com.huawei.hms.ads.Video
    public int getDuration() {
        return this.I;
    }

    @Override // com.huawei.hms.ads.Video
    public Uri getUri() {
        return this.Code;
    }
}
