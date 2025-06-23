package com.kwad.sdk.crash.report.upload;

/* loaded from: classes11.dex */
public final class e {
    public static e aII = new e(-11, "Please init.");
    public static e aIJ = new e(-12, "error when zip_file");
    public static e aIK = new e(-13, "There is no valid network.");
    public static e aIL = new e(-14, "Token is invalid.");
    public static e aIM = new e(-15, "upload task execute frequence exceed.");
    public static e aIN = new e(-16, "process request fail.");
    public static e aIO = new e(-17, "sever response error http code");
    public static e aIP = new e(-18, "sever response error result code");
    public static e aIQ = new e(-19, "server bad response.");
    private final int aIR;
    private final String aIS;

    private e(int i, String str) {
        this.aIR = i;
        this.aIS = str;
    }

    public final String wR() {
        return this.aIS;
    }
}
