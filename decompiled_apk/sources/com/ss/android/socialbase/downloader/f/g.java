package com.ss.android.socialbase.downloader.f;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes13.dex */
public class g {
    private final DownloadInfo c;
    private final com.ss.android.socialbase.downloader.g.a e;
    private final com.ss.android.socialbase.downloader.h.f f;
    private final c g;
    private BaseException h;
    private final boolean m;
    private final long n;
    private final long o;
    private final boolean p;
    private long q;

    /* renamed from: a, reason: collision with root package name */
    private final List<l> f26289a = new LinkedList();
    private final List<l> b = new ArrayList();
    private volatile boolean i = false;
    private volatile boolean j = false;
    private volatile boolean k = false;
    private volatile long r = 0;
    private volatile long s = 0;
    private final com.ss.android.socialbase.downloader.downloader.j d = com.ss.android.socialbase.downloader.downloader.c.y();
    private final com.ss.android.socialbase.downloader.a.a l = com.ss.android.socialbase.downloader.a.a.a();

    public g(DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.h.f fVar, c cVar) {
        boolean z;
        this.c = downloadInfo;
        this.f = fVar;
        this.g = cVar;
        com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        this.e = a2;
        if (a2.a("sync_strategy", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.m = z;
        if (z) {
            long a3 = a2.a("sync_interval_ms_fg", 5000);
            long a4 = a2.a("sync_interval_ms_bg", 1000);
            this.n = Math.max(a3, 500L);
            this.o = Math.max(a4, 500L);
        } else {
            this.n = 0L;
            this.o = 0L;
        }
        this.p = a2.b("monitor_rw") == 1;
    }

    private boolean a(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    private void b(List<l> list) throws IOException {
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    private void c() throws IOException {
        boolean z;
        boolean z2 = this.p;
        long nanoTime = z2 ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.c;
        com.ss.android.socialbase.downloader.downloader.j jVar = this.d;
        List<l> list = this.f26289a;
        List<l> list2 = this.b;
        Map<Long, i> l = jVar.l(downloadInfo.getId());
        if (l == null) {
            l = new HashMap<>(4);
        }
        synchronized (this) {
            try {
                a(list);
                try {
                    b(list);
                    z = true;
                } catch (Throwable th) {
                    th.printStackTrace();
                    z = false;
                }
                a(list, l);
                if (list2.size() > 0) {
                    c(list2);
                    list.removeAll(list2);
                    list2.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z) {
            downloadInfo.updateRealDownloadTime(true);
            jVar.a(downloadInfo.getId(), l);
            jVar.a(downloadInfo);
            this.r = downloadInfo.getCurBytes();
        }
        if (z2) {
            this.q += System.nanoTime() - nanoTime;
        }
    }

    public void a(l lVar) {
        synchronized (this) {
            this.f26289a.add(lVar);
        }
    }

    public void b() {
        this.j = true;
        this.i = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x017e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x017f, code lost:
    
        r15 = r22;
        r17 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0183, code lost:
    
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0177, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0178, code lost:
    
        r15 = r22;
        r17 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x017c, code lost:
    
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x025a, code lost:
    
        r3.b(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x00bf, code lost:
    
        if (r2 <= 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x00c2, code lost:
    
        r3.b(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0157, code lost:
    
        a(r10, r3.b(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x015c, code lost:
    
        if (com.ss.android.socialbase.downloader.network.b.f26407a != false) goto L346;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0162, code lost:
    
        if (r4.isOnlyWifi() != false) goto L343;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0168, code lost:
    
        if (r4.isDownloadFromReserveWifi() == false) goto L347;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x016e, code lost:
    
        if (r4.isPauseReserveOnWifi() != false) goto L345;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0176, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0192, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0191, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0186, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0187, code lost:
    
        r10 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0189, code lost:
    
        r9 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02e2 A[Catch: all -> 0x01b9, TryCatch #18 {all -> 0x01b9, blocks: (B:171:0x01a5, B:173:0x01a9, B:176:0x01af, B:178:0x01b5, B:179:0x01bd, B:181:0x01d3, B:225:0x0254, B:226:0x0256, B:116:0x02d8, B:118:0x02e2, B:120:0x02e6, B:163:0x0365, B:165:0x036b, B:166:0x036e, B:167:0x0386), top: B:6:0x0024, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0315 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x036b A[Catch: all -> 0x01b9, TryCatch #18 {all -> 0x01b9, blocks: (B:171:0x01a5, B:173:0x01a9, B:176:0x01af, B:178:0x01b5, B:179:0x01bd, B:181:0x01d3, B:225:0x0254, B:226:0x0256, B:116:0x02d8, B:118:0x02e2, B:120:0x02e6, B:163:0x0365, B:165:0x036b, B:166:0x036e, B:167:0x0386), top: B:6:0x0024, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01a9 A[Catch: all -> 0x01b9, TryCatch #18 {all -> 0x01b9, blocks: (B:171:0x01a5, B:173:0x01a9, B:176:0x01af, B:178:0x01b5, B:179:0x01bd, B:181:0x01d3, B:225:0x0254, B:226:0x0256, B:116:0x02d8, B:118:0x02e2, B:120:0x02e6, B:163:0x0365, B:165:0x036b, B:166:0x036e, B:167:0x0386), top: B:6:0x0024, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x01b5 A[Catch: all -> 0x01b9, TryCatch #18 {all -> 0x01b9, blocks: (B:171:0x01a5, B:173:0x01a9, B:176:0x01af, B:178:0x01b5, B:179:0x01bd, B:181:0x01d3, B:225:0x0254, B:226:0x0256, B:116:0x02d8, B:118:0x02e2, B:120:0x02e6, B:163:0x0365, B:165:0x036b, B:166:0x036e, B:167:0x0386), top: B:6:0x0024, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0203 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x01e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0282 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0263 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x03c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.ss.android.socialbase.downloader.f.d r28) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 1041
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.g.a(com.ss.android.socialbase.downloader.f.d):void");
    }

    private void c(List<l> list) {
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    private void a(long j, boolean z) throws IOException {
        long j2 = j - this.s;
        if (this.m) {
            if (j2 > (this.l.b() ? this.n : this.o)) {
                c();
                this.s = j;
                return;
            }
            return;
        }
        long curBytes = this.c.getCurBytes() - this.r;
        if (z || a(curBytes, j2)) {
            c();
            this.s = j;
        }
    }

    private void a(e eVar) {
        synchronized (this) {
            this.b.add((l) eVar);
        }
    }

    private void a(List<l> list) throws IOException {
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    private void a(List<l> list, Map<Long, i> map) {
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            i e = it.next().e();
            i iVar = map.get(Long.valueOf(e.c()));
            if (iVar == null) {
                map.put(Long.valueOf(e.c()), new i(e));
            } else {
                iVar.a(e.d());
                iVar.c(e.f());
            }
        }
    }

    public void a() {
        this.k = true;
        this.i = true;
    }
}
