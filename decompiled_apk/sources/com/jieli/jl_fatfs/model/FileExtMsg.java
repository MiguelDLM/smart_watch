package com.jieli.jl_fatfs.model;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes10.dex */
public class FileExtMsg {

    @SerializedName("prj_uuid")
    private String uuid;

    @SerializedName("version_id")
    private String versionID;

    public String getUuid() {
        return this.uuid;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setVersionID(String str) {
        this.versionID = str;
    }

    public String toString() {
        return new GsonBuilder().create().toJson(this);
    }
}
