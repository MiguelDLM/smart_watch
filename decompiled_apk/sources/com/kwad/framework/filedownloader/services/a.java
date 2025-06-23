package com.kwad.framework.filedownloader.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwad.framework.filedownloader.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, u {
    private final Class<?> ahW;
    private volatile INTERFACE aiC;
    private final HashMap<String, Object> aiD = new HashMap<>();
    private final List<Context> aiE = new ArrayList();
    private final ArrayList<Runnable> afJ = new ArrayList<>();
    private final CALLBACK aiB = vv();

    public a(Class<?> cls) {
        this.ahW = cls;
    }

    private void a(Context context, Runnable runnable) {
        if (!com.kwad.framework.filedownloader.f.f.ay(context)) {
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.c(this, "bindStartByContext %s", context.getClass().getSimpleName());
            }
            Intent intent = new Intent(context, this.ahW);
            if (!this.aiE.contains(context)) {
                this.aiE.add(context);
            }
            context.bindService(intent, this, 1);
            context.startService(intent);
            return;
        }
        throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
    }

    private void bg(boolean z) {
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "release connect resources %s", this.aiC);
        }
        this.aiC = null;
        com.kwad.framework.filedownloader.f.vd().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.lost, this.ahW));
    }

    public abstract void a(INTERFACE r1, CALLBACK callback);

    @Override // com.kwad.framework.filedownloader.u
    public final void av(Context context) {
        a(context, (Runnable) null);
    }

    public abstract INTERFACE b(IBinder iBinder);

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        if (wU() != null) {
            return true;
        }
        return false;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.aiC = b(iBinder);
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "onServiceConnected %s %s", componentName, this.aiC);
        }
        try {
            a((a<CALLBACK, INTERFACE>) this.aiC, (INTERFACE) this.aiB);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        List list = (List) this.afJ.clone();
        this.afJ.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        com.kwad.framework.filedownloader.f.vd().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.ahW));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "onServiceDisconnected %s %s", componentName, this.aiC);
        }
        bg(true);
    }

    public abstract CALLBACK vv();

    public final INTERFACE wU() {
        return this.aiC;
    }
}
