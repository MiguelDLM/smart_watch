package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;

/* loaded from: classes11.dex */
public abstract class e extends com.kwad.framework.filedownloader.event.c {
    private DownloadServiceConnectChangedEvent.ConnectStatus afo;

    @Override // com.kwad.framework.filedownloader.event.c
    public final boolean a(com.kwad.framework.filedownloader.event.b bVar) {
        if (bVar instanceof DownloadServiceConnectChangedEvent) {
            DownloadServiceConnectChangedEvent.ConnectStatus wx = ((DownloadServiceConnectChangedEvent) bVar).wx();
            this.afo = wx;
            if (wx == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
                va();
                return false;
            }
            vb();
            return false;
        }
        return false;
    }

    public abstract void va();

    public abstract void vb();

    public final DownloadServiceConnectChangedEvent.ConnectStatus vc() {
        return this.afo;
    }
}
