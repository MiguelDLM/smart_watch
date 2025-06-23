package com.huawei.openalliance.ad.download;

import com.huawei.openalliance.ad.download.app.k;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes10.dex */
public class a implements AppDownloadListener {
    private static final String Code = "AppDownloadListenerRegister";
    private static final String I = "outer_listener_key";
    private static final String Z = "jsb_listener_key";
    private final CopyOnWriteArraySet<AppDownloadListener> B;
    private Map<String, AppDownloadListener> V;

    /* renamed from: com.huawei.openalliance.ad.download.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0659a {
        private static a Code = new a();

        private C0659a() {
        }
    }

    private a() {
        this.V = new ConcurrentHashMap();
        this.B = new CopyOnWriteArraySet<>();
        com.huawei.openalliance.ad.download.app.g.I().Code(this);
    }

    public static a Code() {
        return C0659a.Code;
    }

    public void I(AppDownloadListener appDownloadListener) {
        if (appDownloadListener == null) {
            return;
        }
        this.B.remove(appDownloadListener);
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
    public void V(AppInfo appInfo) {
        for (AppDownloadListener appDownloadListener : this.V.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.V(appInfo);
            }
        }
    }

    public void Z(AppDownloadListener appDownloadListener) {
        if (appDownloadListener == null) {
            this.V.remove(Z);
        } else {
            this.V.put(Z, appDownloadListener);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
    public void Code(k kVar, AppInfo appInfo) {
        for (AppDownloadListener appDownloadListener : this.V.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.Code(kVar, appInfo);
            }
        }
    }

    public void V(AppDownloadListener appDownloadListener) {
        if (appDownloadListener == null) {
            return;
        }
        this.B.add(appDownloadListener);
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
    public void Code(AppInfo appInfo) {
        for (AppDownloadListener appDownloadListener : this.V.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.Code(appInfo);
            }
        }
        Iterator<AppDownloadListener> it = this.B.iterator();
        while (it.hasNext()) {
            AppDownloadListener next = it.next();
            if (next != null) {
                next.Code(appInfo);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
    public void Code(AppInfo appInfo, int i) {
        for (AppDownloadListener appDownloadListener : this.V.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.Code(appInfo, i);
            }
        }
    }

    public void Code(AppDownloadListener appDownloadListener) {
        if (appDownloadListener == null) {
            this.V.remove(I);
        } else {
            this.V.put(I, appDownloadListener);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
    public void Code(String str) {
        for (AppDownloadListener appDownloadListener : this.V.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.Code(str);
            }
        }
        Iterator<AppDownloadListener> it = this.B.iterator();
        while (it.hasNext()) {
            AppDownloadListener next = it.next();
            if (next != null) {
                next.Code(str);
            }
        }
    }
}
