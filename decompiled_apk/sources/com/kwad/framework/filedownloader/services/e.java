package com.kwad.framework.filedownloader.services;

import android.app.Notification;
import android.os.IBinder;
import com.kwad.framework.filedownloader.c.b;
import com.kwad.framework.filedownloader.n;
import java.lang.ref.WeakReference;

/* loaded from: classes11.dex */
public final class e extends b.a implements i {
    private final g aiO;
    private final WeakReference<FileDownloadServiceProxy> aiP;

    /* loaded from: classes11.dex */
    public interface a {
        void a(e eVar);

        void onDisconnected();
    }

    public e(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        this.aiP = weakReference;
        this.aiO = gVar;
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void a(com.kwad.framework.filedownloader.c.a aVar) {
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void b(com.kwad.framework.filedownloader.c.a aVar) {
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean bd(int i) {
        return this.aiO.bd(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final byte be(int i) {
        return this.aiO.be(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean bf(int i) {
        return this.aiO.bf(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean bx(int i) {
        return this.aiO.bx(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final long by(int i) {
        return this.aiO.bJ(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final long bz(int i) {
        return this.aiO.bz(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean isIdle() {
        return this.aiO.isIdle();
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final void onDestroy() {
        n.vr().onDisconnected();
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void pauseAllTasks() {
        this.aiO.xi();
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void startForeground(int i, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.aiP;
        if (weakReference != null && weakReference.get() != null) {
            this.aiP.get().context.startForeground(i, notification);
        }
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void stopForeground(boolean z) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.aiP;
        if (weakReference != null && weakReference.get() != null) {
            this.aiP.get().context.stopForeground(z);
        }
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean u(String str, String str2) {
        return this.aiO.y(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void wz() {
        this.aiO.wz();
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final void xf() {
        n.vr().a(this);
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final IBinder xg() {
        return null;
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void b(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        this.aiO.b(str, str2, z, i, i2, i3, z2, bVar, z3);
    }
}
