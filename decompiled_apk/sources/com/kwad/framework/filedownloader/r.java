package com.kwad.framework.filedownloader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.services.c;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public class r {
    private static final Object afR = new Object();
    private static final Object afT = new Object();
    private w afS;
    private volatile v afU;

    /* loaded from: classes11.dex */
    public static final class a {
        private static final r afV = new r();
    }

    public static void a(Context context, c.b bVar) {
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(r.class, "init Downloader with params: %s %s", context, bVar);
        }
        if (context != null) {
            com.kwad.framework.filedownloader.f.c.ax(context.getApplicationContext());
            com.kwad.framework.filedownloader.download.b.vS().a(bVar);
            return;
        }
        throw new IllegalArgumentException("the provided context must not be null!");
    }

    public static void aw(Context context) {
        com.kwad.framework.filedownloader.f.c.ax(context.getApplicationContext());
    }

    public static com.kwad.framework.filedownloader.a bf(String str) {
        return new c(str);
    }

    private int bg(int i) {
        List<a.InterfaceC0823a> bb = h.vf().bb(i);
        if (bb.isEmpty()) {
            com.kwad.framework.filedownloader.f.d.d(this, "request pause but not exist %d", Integer.valueOf(i));
            return 0;
        }
        Iterator<a.InterfaceC0823a> it = bb.iterator();
        while (it.hasNext()) {
            it.next().uH().pause();
        }
        return bb.size();
    }

    public static boolean vA() {
        return n.vq().isConnected();
    }

    public static r vy() {
        return a.afV;
    }

    public final boolean p(int i, String str) {
        bg(i);
        if (n.vq().bf(i)) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            File file = new File(com.kwad.framework.filedownloader.f.f.bw(str));
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(str);
            if (file2.exists()) {
                file2.delete();
            }
            return true;
        }
        return false;
    }

    public final w vB() {
        if (this.afS == null) {
            synchronized (afR) {
                try {
                    if (this.afS == null) {
                        this.afS = new ab();
                    }
                } finally {
                }
            }
        }
        return this.afS;
    }

    public final v vC() {
        if (this.afU == null) {
            synchronized (afT) {
                try {
                    if (this.afU == null) {
                        this.afU = new z();
                        a((e) this.afU);
                    }
                } finally {
                }
            }
        }
        return this.afU;
    }

    public final void vz() {
        if (!vA()) {
            n.vq().av(com.kwad.framework.filedownloader.f.c.xp());
        }
    }

    private static void a(e eVar) {
        f.vd().a("event.service.connect.changed", eVar);
    }
}
