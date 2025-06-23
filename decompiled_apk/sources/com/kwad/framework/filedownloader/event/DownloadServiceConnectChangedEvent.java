package com.kwad.framework.filedownloader.event;

/* loaded from: classes11.dex */
public final class DownloadServiceConnectChangedEvent extends b {
    private final ConnectStatus ahV;
    private final Class<?> ahW;

    /* loaded from: classes11.dex */
    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.ahV = connectStatus;
        this.ahW = cls;
    }

    public final ConnectStatus wx() {
        return this.ahV;
    }
}
