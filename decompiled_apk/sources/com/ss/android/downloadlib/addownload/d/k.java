package com.ss.android.downloadlib.addownload.d;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static k f26035a;
    private List<i> b;

    private k() {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(new j());
        this.b.add(new l());
        this.b.add(new f());
        this.b.add(new a());
    }

    public static k a() {
        if (f26035a == null) {
            synchronized (k.class) {
                try {
                    if (f26035a == null) {
                        f26035a = new k();
                    }
                } finally {
                }
            }
        }
        return f26035a;
    }

    public void a(com.ss.android.downloadad.api.a.b bVar, int i, h hVar) {
        DownloadInfo b;
        List<i> list = this.b;
        if (list != null && list.size() != 0 && bVar != null) {
            if (!TextUtils.isEmpty(bVar.af())) {
                b = com.ss.android.downloadlib.i.a((Context) null).a(bVar.af(), null, true);
            } else {
                b = com.ss.android.downloadlib.i.a((Context) null).b(bVar.a());
            }
            if (b != null && "application/vnd.android.package-archive".equals(b.getMimeType())) {
                boolean z = com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("pause_optimise_switch", 0) == 1;
                for (i iVar : this.b) {
                    if (z || (iVar instanceof l)) {
                        if (iVar.a(bVar, i, hVar)) {
                            return;
                        }
                    }
                }
                hVar.a(bVar);
                return;
            }
            hVar.a(bVar);
            return;
        }
        hVar.a(bVar);
    }
}
