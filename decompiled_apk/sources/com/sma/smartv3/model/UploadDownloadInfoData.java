package com.sma.smartv3.model;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class UploadDownloadInfoData {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int TYPE_BUSINESS = 3;
    public static final int TYPE_DYNAMIC = 1;
    public static final int TYPE_EXERCISE = 2;
    public static final int TYPE_ILLUSTRATION = 6;
    public static final int TYPE_MACHINERY = 4;
    public static final int TYPE_OTHER = 0;
    public static final int TYPE_SIMPLE = 5;

    @OOXIXo
    private String bleName = "";

    @OOXIXo
    private String projectId = "";

    @OOXIXo
    private String firmwareFlag = "";

    @OOXIXo
    private String filePath = "";

    @OOXIXo
    private String fileSize = "";

    @OOXIXo
    private String fileCategory = "";

    @OOXIXo
    private String eleId = "";

    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    @OOXIXo
    public final String getBleName() {
        return this.bleName;
    }

    @OOXIXo
    public final String getEleId() {
        return this.eleId;
    }

    @OOXIXo
    public final String getFileCategory() {
        return this.fileCategory;
    }

    @OOXIXo
    public final String getFilePath() {
        return this.filePath;
    }

    @OOXIXo
    public final String getFileSize() {
        return this.fileSize;
    }

    @OOXIXo
    public final String getFirmwareFlag() {
        return this.firmwareFlag;
    }

    @OOXIXo
    public final String getProjectId() {
        return this.projectId;
    }

    public final void setBleName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.bleName = str;
    }

    public final void setEleId(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.eleId = str;
    }

    public final void setFileCategory(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.fileCategory = str;
    }

    public final void setFilePath(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.filePath = str;
    }

    public final void setFileSize(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.fileSize = str;
    }

    public final void setFirmwareFlag(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.firmwareFlag = str;
    }

    public final void setProjectId(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.projectId = str;
    }
}
