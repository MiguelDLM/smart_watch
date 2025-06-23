package com.adp.sdk.dto;

public class ADPContentItem {
    public String id;
    public int materialType = 0;
    public int position;
    public long videoDuration;

    public String getId() {
        return this.id;
    }

    public int getMaterialType() {
        return this.materialType;
    }

    public int getPosition() {
        return this.position;
    }

    public long getVideoDuration() {
        return this.videoDuration;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMaterialType(int i) {
        this.materialType = i;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setVideoDuration(long j) {
        this.videoDuration = j;
    }
}
