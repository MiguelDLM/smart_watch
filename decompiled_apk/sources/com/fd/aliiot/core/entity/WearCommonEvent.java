package com.fd.aliiot.core.entity;

/* loaded from: classes8.dex */
public class WearCommonEvent {
    private String eventContent;
    private String eventIdentifier;
    private String trackId;

    public String getEventContent() {
        return this.eventContent;
    }

    public String getEventIdentifier() {
        return this.eventIdentifier;
    }

    public String getTrackId() {
        String str = this.trackId;
        return str == null ? "" : str;
    }

    public void setEventContent(String str) {
        this.eventContent = str;
    }

    public void setEventIdentifier(String str) {
        this.eventIdentifier = str;
    }

    public void setTrackId(String str) {
        this.trackId = str;
    }
}
