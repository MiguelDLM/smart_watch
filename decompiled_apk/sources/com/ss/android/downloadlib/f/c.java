package com.ss.android.downloadlib.f;

import com.ss.android.socialbase.appdownloader.c.i;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public class c implements j {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f26109a;
    private List<j> b;

    private c() {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(new b());
        this.b.add(new a());
    }

    public static c a() {
        if (f26109a == null) {
            synchronized (c.class) {
                try {
                    if (f26109a == null) {
                        f26109a = new c();
                    }
                } finally {
                }
            }
        }
        return f26109a;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.j
    public void a(DownloadInfo downloadInfo, i iVar) {
        if (downloadInfo != null && this.b.size() != 0) {
            a(downloadInfo, 0, iVar);
        } else if (iVar != null) {
            iVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final DownloadInfo downloadInfo, final int i, final i iVar) {
        if (i != this.b.size() && i >= 0) {
            this.b.get(i).a(downloadInfo, new i() { // from class: com.ss.android.downloadlib.f.c.1
                @Override // com.ss.android.socialbase.appdownloader.c.i
                public void a() {
                    c.this.a(downloadInfo, i + 1, iVar);
                }
            });
        } else {
            iVar.a();
        }
    }
}
