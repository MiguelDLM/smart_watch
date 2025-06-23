package com.sma.smartv3.model;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class UploadBaiduServiceCallLogData {
    public static final int CALL_TYPE_AIGC = 1;
    public static final int CALL_TYPE_NAV = 2;
    public static final int CALL_TYPE_OTHER = 0;
    public static final int CALL_TYPE_SCORE_GOOD = 4;
    public static final int CALL_TYPE_SCORE_HIDE = 6;
    public static final int CALL_TYPE_SCORE_POOR = 5;
    public static final int CALL_TYPE_SCORE_SHOW = 7;
    public static final int CALL_TYPE_VOICE = 3;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int MICROSOFT_IDENTIFY = 8;
    public static final int MICROSOFT_PLAY_AUDIO = 10;
    public static final int MICROSOFT_TRANSLATE = 9;
    public static final int PLATFORM_ANDROID = 2;
    public static final int PLATFORM_IOS = 1;
    private long callTime;
    private int callType;
    private int platform;
    private int projectId;

    @OOXIXo
    private String bleName = "";

    @OOXIXo
    private String firmwareFlag = "";

    @OOXIXo
    private String appVersion = "";

    @OOXIXo
    private String macAddress = "";

    @OOXIXo
    private String remark = "";

    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    @OOXIXo
    public final String getAppVersion() {
        return this.appVersion;
    }

    @OOXIXo
    public final String getBleName() {
        return this.bleName;
    }

    public final long getCallTime() {
        return this.callTime;
    }

    public final int getCallType() {
        return this.callType;
    }

    @OOXIXo
    public final String getFirmwareFlag() {
        return this.firmwareFlag;
    }

    @OOXIXo
    public final String getMacAddress() {
        return this.macAddress;
    }

    public final int getPlatform() {
        return this.platform;
    }

    public final int getProjectId() {
        return this.projectId;
    }

    @OOXIXo
    public final String getRemark() {
        return this.remark;
    }

    public final void setAppVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.appVersion = str;
    }

    public final void setBleName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.bleName = str;
    }

    public final void setCallTime(long j) {
        this.callTime = j;
    }

    public final void setCallType(int i) {
        this.callType = i;
    }

    public final void setFirmwareFlag(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.firmwareFlag = str;
    }

    public final void setMacAddress(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.macAddress = str;
    }

    public final void setPlatform(int i) {
        this.platform = i;
    }

    public final void setProjectId(int i) {
        this.projectId = i;
    }

    public final void setRemark(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.remark = str;
    }
}
