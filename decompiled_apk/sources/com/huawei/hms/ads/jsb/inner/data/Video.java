package com.huawei.hms.ads.jsb.inner.data;

import android.text.TextUtils;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;

@DataKeep
/* loaded from: classes10.dex */
public class Video {
    private String autoPlay;
    private Integer autoPlayAreaRatio;
    private String autoPlayWithSound;
    private Integer autoStopPlayAreaRatio;
    private int duration;
    private int fileSize;
    private float ratio;
    private String soundSwitch;
    private Integer timeBeforeAutoPlay;
    private String url;

    public Video(VideoInfo videoInfo) {
        this.autoPlay = "y";
        this.soundSwitch = "n";
        this.url = videoInfo.Code();
        this.autoStopPlayAreaRatio = videoInfo.c();
        if (TextUtils.equals(videoInfo.C(), "y") || TextUtils.equals(videoInfo.C(), "a")) {
            this.autoPlay = "y";
        } else {
            this.autoPlay = "n";
        }
        this.autoPlayAreaRatio = videoInfo.b();
        this.timeBeforeAutoPlay = Integer.valueOf(videoInfo.F());
        this.autoPlayWithSound = videoInfo.S();
        this.soundSwitch = videoInfo.S();
        this.duration = videoInfo.I();
        this.fileSize = videoInfo.B();
        this.ratio = videoInfo.e() == null ? 1.7777778f : videoInfo.e().floatValue();
    }
}
