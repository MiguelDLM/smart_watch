package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.b;
import java.io.Serializable;

@DataKeep
/* loaded from: classes10.dex */
public class VideoInfo implements Serializable {
    private static final long serialVersionUID = 5224357961234973073L;
    private Integer autoPlayAreaRatio;
    private Integer autoStopPlayAreaRatio;
    private int checkSha256Flag;

    @com.huawei.openalliance.ad.annotations.a
    private String originalDownloadUrl;
    private String sha256;
    private float splashSwitchTime;

    @com.huawei.openalliance.ad.annotations.a
    private String videoDownloadUrl;
    private int videoDuration;
    private int videoFileSize;
    private Float videoRatio;
    private String videoAutoPlayOnWifi = "y";
    private String videoAutoPlayWithSound = "n";
    private int timeBeforeVideoAutoPlay = 200;
    private int videoPlayMode = 1;
    private int downloadNetwork = 0;
    private String showSoundIcon = "y";

    @b
    public int B() {
        return this.videoFileSize;
    }

    public String C() {
        return this.videoAutoPlayOnWifi;
    }

    public String Code() {
        return this.videoDownloadUrl;
    }

    public String D() {
        return this.sha256;
    }

    public int F() {
        return this.timeBeforeVideoAutoPlay;
    }

    @b
    public int I() {
        return this.videoDuration;
    }

    public int L() {
        return this.videoPlayMode;
    }

    public String S() {
        return this.videoAutoPlayWithSound;
    }

    public String V() {
        return this.originalDownloadUrl;
    }

    public int Z() {
        return this.videoDuration;
    }

    public int a() {
        return this.checkSha256Flag;
    }

    public Integer b() {
        return this.autoPlayAreaRatio;
    }

    public Integer c() {
        return this.autoStopPlayAreaRatio;
    }

    public int d() {
        return this.downloadNetwork;
    }

    public Float e() {
        return this.videoRatio;
    }

    @b
    public String f() {
        return this.showSoundIcon;
    }

    public float g() {
        return this.splashSwitchTime;
    }

    public void B(int i) {
        this.downloadNetwork = i;
    }

    public void Code(float f) {
        this.splashSwitchTime = f;
    }

    public void I(int i) {
        this.timeBeforeVideoAutoPlay = i;
    }

    public void V(int i) {
        this.videoFileSize = i;
    }

    public void Z(int i) {
        this.checkSha256Flag = i;
    }

    public void Code(int i) {
        this.videoDuration = i;
    }

    public void I(String str) {
        this.videoAutoPlayWithSound = str;
    }

    public void V(Integer num) {
        this.autoStopPlayAreaRatio = num;
    }

    public void Z(String str) {
        this.sha256 = str;
    }

    public void Code(Float f) {
        this.videoRatio = f;
    }

    public void V(String str) {
        this.videoAutoPlayOnWifi = str;
    }

    public void Code(Integer num) {
        this.autoPlayAreaRatio = num;
    }

    public void Code(String str) {
        this.videoDownloadUrl = str;
    }
}
