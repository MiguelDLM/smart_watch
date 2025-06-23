package com.sma.smartv3.model;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class UploadAlipayBindInfoData {
    private int result;
    private long time;

    @OOXIXo
    private String bleName = "";

    @OOXIXo
    private String firmwareFlag = "";

    @OOXIXo
    private String macAddress = "";

    @OOXIXo
    private String firmwareVersion = "";

    @OOXIXo
    private String appVersion = "";

    @OOXIXo
    public final String getAppVersion() {
        return this.appVersion;
    }

    @OOXIXo
    public final String getBleName() {
        return this.bleName;
    }

    @OOXIXo
    public final String getFirmwareFlag() {
        return this.firmwareFlag;
    }

    @OOXIXo
    public final String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    @OOXIXo
    public final String getMacAddress() {
        return this.macAddress;
    }

    public final int getResult() {
        return this.result;
    }

    public final long getTime() {
        return this.time;
    }

    public final void setAppVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.appVersion = str;
    }

    public final void setBleName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.bleName = str;
    }

    public final void setFirmwareFlag(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.firmwareFlag = str;
    }

    public final void setFirmwareVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.firmwareVersion = str;
    }

    public final void setMacAddress(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.macAddress = str;
    }

    public final void setResult(int i) {
        this.result = i;
    }

    public final void setTime(long j) {
        this.time = j;
    }
}
