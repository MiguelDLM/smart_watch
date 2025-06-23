package com.baidu.ar.recognition;

/* loaded from: classes7.dex */
public class RequestRecognitionMode {
    private String aipAppId;
    private String appId;
    private float[] cameraDistort;
    private float[] cameraIntrinsics;
    private String cuid;
    private int frameChannels;
    private float[] gps;
    private int height;
    public byte[] image;
    private String isAip;
    private int policy;
    private String sign;
    private long timestamp;
    private int width;

    public String getAipAppId() {
        return this.aipAppId;
    }

    public String getAppId() {
        return this.appId;
    }

    public float[] getCameraDistort() {
        return this.cameraDistort;
    }

    public float[] getCameraIntrinsics() {
        return this.cameraIntrinsics;
    }

    public String getCuid() {
        return this.cuid;
    }

    public int getFrameChannels() {
        return this.frameChannels;
    }

    public float[] getGps() {
        return this.gps;
    }

    public int getHeight() {
        return this.height;
    }

    public byte[] getImage() {
        return this.image;
    }

    public String getIsAip() {
        return this.isAip;
    }

    public int getPolicy() {
        return this.policy;
    }

    public String getSign() {
        return this.sign;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getWidth() {
        return this.width;
    }

    public void setAipAppId(String str) {
        this.aipAppId = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setCameraDistort(float[] fArr) {
        this.cameraDistort = fArr;
    }

    public void setCameraIntrinsics(float[] fArr) {
        this.cameraIntrinsics = fArr;
    }

    public void setCuid(String str) {
        this.cuid = str;
    }

    public void setFrameChannels(int i) {
        this.frameChannels = i;
    }

    public void setGps(float[] fArr) {
        this.gps = fArr;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setImage(byte[] bArr) {
        this.image = bArr;
    }

    public void setIsAip(String str) {
        this.isAip = str;
    }

    public void setPolicy(int i) {
        this.policy = i;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
