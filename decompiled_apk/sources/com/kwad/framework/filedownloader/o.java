package com.kwad.framework.filedownloader;

import android.content.Context;
import android.content.Intent;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwad.framework.filedownloader.services.e;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class o implements e.a, u {
    private static Class<?> afI;
    private final ArrayList<Runnable> afJ = new ArrayList<>();
    private com.kwad.framework.filedownloader.services.e afK;

    private static Class<?> vt() {
        if (afI == null) {
            afI = FileDownloadService.SharedMainProcessService.class;
        }
        return afI;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.h(str, str2, z);
        }
        this.afK.b(str, str2, z, i, i2, i3, z2, bVar, z3);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final void av(Context context) {
        a(context, null);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bd(int i) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.bd(i);
        }
        return this.afK.bd(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte be(int i) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.be(i);
        }
        return this.afK.be(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bf(int i) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.bf(i);
        }
        return this.afK.bf(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        if (this.afK != null) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.services.e.a
    public final void onDisconnected() {
        this.afK = null;
        f.vd().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, vt()));
    }

    private void a(Context context, Runnable runnable) {
        context.startService(new Intent(context, vt()));
    }

    @Override // com.kwad.framework.filedownloader.services.e.a
    public final void a(com.kwad.framework.filedownloader.services.e eVar) {
        this.afK = eVar;
        List list = (List) this.afJ.clone();
        this.afJ.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        f.vd().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, vt()));
    }
}
