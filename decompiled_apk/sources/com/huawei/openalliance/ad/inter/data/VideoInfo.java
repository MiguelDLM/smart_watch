package com.huawei.openalliance.ad.inter.data;

import android.text.TextUtils;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.constant.ca;
import java.io.Serializable;

@DataKeep
@com.huawei.openalliance.ad.annotations.b
/* loaded from: classes10.dex */
public class VideoInfo implements Serializable {
    private static final long serialVersionUID = 30414300;
    private int autoPlayAreaRatio;
    private int autoPlayNetwork;
    private int autoStopPlayAreaRatio;
    private boolean checkSha256;
    private boolean directReturnVideoAd;
    private int downloadNetwork;
    private int playProgress;
    private String sha256;
    private boolean showSoundIcon;
    private String soundSwitch;
    private float splashSwitchTime;
    private int timeBeforeVideoAutoPlay;
    private String useTemplate;
    private String videoAutoPlay;
    private String videoAutoPlayWithSound;
    private String videoDownloadUrl;
    private int videoDuration;
    private int videoFileSize;
    private int videoPlayMode;
    private Float videoRatio;

    @com.huawei.openalliance.ad.annotations.b
    public VideoInfo() {
        this.videoAutoPlay = "y";
        this.videoAutoPlayWithSound = "n";
        this.timeBeforeVideoAutoPlay = 200;
        this.playProgress = 0;
        this.soundSwitch = "n";
        this.videoPlayMode = 1;
        this.autoPlayAreaRatio = 100;
        this.autoStopPlayAreaRatio = 90;
        this.downloadNetwork = 0;
        this.showSoundIcon = true;
        this.directReturnVideoAd = false;
        this.useTemplate = Boolean.FALSE.toString();
    }

    @com.huawei.openalliance.ad.annotations.b
    public String B() {
        return this.videoAutoPlay;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String C() {
        return this.videoAutoPlayWithSound;
    }

    public void Code(float f) {
        if (f <= 0.0f) {
            f = 3.5f;
        }
        this.splashSwitchTime = f;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int D() {
        return this.videoPlayMode;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String F() {
        return this.sha256;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int I() {
        return this.videoDuration;
    }

    public int L() {
        return this.playProgress;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int S() {
        return this.timeBeforeVideoAutoPlay;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String V() {
        return this.videoDownloadUrl;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int Z() {
        return this.videoFileSize;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String a() {
        return this.soundSwitch;
    }

    @com.huawei.openalliance.ad.annotations.b
    public boolean b() {
        return this.checkSha256;
    }

    public int c() {
        return this.autoPlayAreaRatio;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int d() {
        return this.autoStopPlayAreaRatio;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int e() {
        return this.downloadNetwork;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int f() {
        return this.autoPlayNetwork;
    }

    @com.huawei.openalliance.ad.annotations.b
    public Float g() {
        return this.videoRatio;
    }

    public boolean h() {
        return this.directReturnVideoAd;
    }

    public boolean i() {
        return this.showSoundIcon;
    }

    public float j() {
        return this.splashSwitchTime;
    }

    public String k() {
        return this.useTemplate;
    }

    public VideoInfo(com.huawei.openalliance.ad.beans.metadata.VideoInfo videoInfo) {
        this.videoAutoPlay = "y";
        this.videoAutoPlayWithSound = "n";
        this.timeBeforeVideoAutoPlay = 200;
        this.playProgress = 0;
        this.soundSwitch = "n";
        this.videoPlayMode = 1;
        this.autoPlayAreaRatio = 100;
        this.autoStopPlayAreaRatio = 90;
        this.downloadNetwork = 0;
        this.showSoundIcon = true;
        this.directReturnVideoAd = false;
        this.useTemplate = Boolean.FALSE.toString();
        if (videoInfo != null) {
            this.videoDownloadUrl = videoInfo.Code();
            this.videoDuration = videoInfo.I();
            this.videoFileSize = videoInfo.B();
            if (TextUtils.equals(videoInfo.C(), "y") || TextUtils.equals(videoInfo.C(), "a")) {
                this.videoAutoPlay = "y";
            } else {
                this.videoAutoPlay = "n";
            }
            this.videoAutoPlayWithSound = videoInfo.S();
            this.timeBeforeVideoAutoPlay = videoInfo.F();
            this.sha256 = videoInfo.D();
            this.videoPlayMode = videoInfo.L();
            this.soundSwitch = this.videoAutoPlayWithSound;
            this.checkSha256 = videoInfo.a() == 0;
            if (videoInfo.b() != null) {
                this.autoPlayAreaRatio = videoInfo.b().intValue();
            }
            if (videoInfo.c() != null) {
                this.autoStopPlayAreaRatio = videoInfo.c().intValue();
            }
            I(videoInfo.d());
            if (TextUtils.equals(videoInfo.C(), "a")) {
                this.autoPlayNetwork = 1;
            } else {
                this.autoPlayNetwork = 0;
            }
            this.showSoundIcon = "y".equalsIgnoreCase(videoInfo.f());
            Code(videoInfo.e());
            Code(videoInfo.g());
        }
    }

    private void I(int i) {
        if (i == 1) {
            this.downloadNetwork = 1;
        } else {
            this.downloadNetwork = 0;
        }
    }

    public void Code(int i) {
        this.playProgress = i;
    }

    public void V(int i) {
        this.videoDuration = i;
    }

    private void Code(Float f) {
        if (f == null) {
            f = null;
        } else if (f.floatValue() <= 0.0f) {
            f = Float.valueOf(1.7777778f);
        }
        this.videoRatio = f;
    }

    public void I(String str) {
        this.useTemplate = str;
    }

    public void V(String str) {
        this.videoDownloadUrl = str;
    }

    public void Code(String str) {
        this.soundSwitch = str;
    }

    public void Code(boolean z) {
        this.directReturnVideoAd = z;
    }

    public boolean Code() {
        if (2 == this.videoPlayMode || this.directReturnVideoAd) {
            return true;
        }
        String str = this.videoDownloadUrl;
        return str != null && str.startsWith(ca.CONTENT.toString());
    }
}
