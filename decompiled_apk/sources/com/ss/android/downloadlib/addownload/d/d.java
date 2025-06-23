package com.ss.android.downloadlib.addownload.d;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static d f26032a;
    private List<g> b;

    private d() {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(new e());
        this.b.add(new b());
        this.b.add(new c());
    }

    public static d a() {
        if (f26032a == null) {
            synchronized (k.class) {
                try {
                    if (f26032a == null) {
                        f26032a = new d();
                    }
                } finally {
                }
            }
        }
        return f26032a;
    }

    public void a(com.ss.android.downloadad.api.a.b bVar, int i, h hVar, com.ss.android.downloadlib.addownload.a.c cVar) {
        DownloadInfo b;
        List<g> list = this.b;
        if (list == null || list.size() == 0 || bVar == null) {
            hVar.a(bVar);
        }
        if (!TextUtils.isEmpty(bVar.af())) {
            b = com.ss.android.downloadlib.i.a(com.ss.android.downloadlib.addownload.k.a()).a(bVar.af(), null, true);
        } else {
            b = com.ss.android.downloadlib.i.a(com.ss.android.downloadlib.addownload.k.a()).b(bVar.a());
        }
        if (b == null) {
            b = Downloader.getInstance(com.ss.android.downloadlib.addownload.k.a()).getDownloadInfo(bVar.s());
        }
        if (b != null && "application/vnd.android.package-archive".equals(b.getMimeType())) {
            if (new j().a(bVar, i, hVar)) {
                return;
            }
            Iterator<g> it = this.b.iterator();
            while (it.hasNext()) {
                if (it.next().a(bVar, i, hVar, cVar)) {
                    return;
                }
            }
            hVar.a(bVar);
            return;
        }
        hVar.a(bVar);
    }
}
