package com.ss.android.socialbase.downloader.h;

import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.i;

/* loaded from: classes13.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static final String f26302a = "b";
    private com.ss.android.socialbase.downloader.model.b b;
    private com.ss.android.socialbase.downloader.model.b c;
    private com.ss.android.socialbase.downloader.downloader.e d;
    private final DownloadTask e;
    private DownloadInfo f;
    private final f g;
    private i h;
    private j i;
    private volatile boolean j;
    private volatile boolean k;
    private boolean l;

    public b(com.ss.android.socialbase.downloader.model.b bVar, DownloadTask downloadTask, f fVar) {
        this.l = false;
        this.c = bVar;
        this.e = downloadTask;
        if (downloadTask != null) {
            this.f = downloadTask.getDownloadInfo();
        }
        this.g = fVar;
        this.i = com.ss.android.socialbase.downloader.downloader.c.y();
        this.c.a(this);
    }

    private String c() {
        return this.f.getConnectionUrl();
    }

    private void d() {
        i iVar = this.h;
        if (iVar != null) {
            iVar.d();
            this.h = null;
        }
    }

    private boolean e() {
        if (!this.j && !this.k) {
            return false;
        }
        return true;
    }

    public void a(long j, long j2) {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.d;
        if (eVar == null) {
            return;
        }
        eVar.a(j, j2);
    }

    public void b() {
        this.k = true;
        com.ss.android.socialbase.downloader.downloader.e eVar = this.d;
        if (eVar != null) {
            eVar.c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0017, code lost:
    
        r3.b.a(false);
     */
    @Override // java.lang.Runnable
    @android.annotation.SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r3 = this;
            r0 = 10
            android.os.Process.setThreadPriority(r0)
            com.ss.android.socialbase.downloader.model.b r0 = r3.c
            r3.b = r0
        L9:
            r0 = 0
            com.ss.android.socialbase.downloader.model.b r1 = r3.b     // Catch: java.lang.Throwable -> L1d
            r1.a(r3)     // Catch: java.lang.Throwable -> L1d
            com.ss.android.socialbase.downloader.model.b r1 = r3.b     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r3.a(r1)     // Catch: java.lang.Throwable -> L1d
            if (r1 != 0) goto L1f
            com.ss.android.socialbase.downloader.model.b r1 = r3.b     // Catch: java.lang.Throwable -> L1d
            r1.a(r0)     // Catch: java.lang.Throwable -> L1d
            goto L4f
        L1d:
            r1 = move-exception
            goto L5f
        L1f:
            com.ss.android.socialbase.downloader.model.b r1 = r3.b     // Catch: java.lang.Throwable -> L1d
            r1.a(r0)     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r3.e()     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L2b
            goto L4f
        L2b:
            com.ss.android.socialbase.downloader.h.f r1 = r3.g     // Catch: java.lang.Throwable -> L1d
            com.ss.android.socialbase.downloader.model.b r2 = r3.b     // Catch: java.lang.Throwable -> L1d
            int r2 = r2.s()     // Catch: java.lang.Throwable -> L1d
            com.ss.android.socialbase.downloader.model.b r1 = r1.a(r2)     // Catch: java.lang.Throwable -> L1d
            r3.b = r1     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r3.e()     // Catch: java.lang.Throwable -> L1d
            if (r1 != 0) goto L4f
            com.ss.android.socialbase.downloader.model.b r1 = r3.b     // Catch: java.lang.Throwable -> L1d
            if (r1 != 0) goto L44
            goto L4f
        L44:
            r1 = 50
            java.lang.Thread.sleep(r1)     // Catch: java.lang.Throwable -> L4a
            goto L9
        L4a:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L1d
            goto L9
        L4f:
            com.ss.android.socialbase.downloader.model.b r1 = r3.b
            if (r1 == 0) goto L56
            r1.a(r0)
        L56:
            r3.d()
            com.ss.android.socialbase.downloader.h.f r0 = r3.g
            r0.a(r3)
            return
        L5f:
            com.ss.android.socialbase.downloader.model.b r2 = r3.b
            if (r2 == 0) goto L66
            r2.a(r0)
        L66:
            r3.d()
            com.ss.android.socialbase.downloader.h.f r0 = r3.g
            r0.a(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.b.run():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x022b, code lost:
    
        if (r2 < 0) goto L163;
     */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x019c A[Catch: all -> 0x00d7, BaseException -> 0x0172, TRY_LEAVE, TryCatch #0 {BaseException -> 0x0172, blocks: (B:53:0x0149, B:55:0x0150, B:59:0x015c, B:60:0x0162, B:147:0x0182, B:148:0x0190, B:162:0x0198, B:164:0x019c, B:175:0x01b1, B:176:0x01b4), top: B:29:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:178:? A[Catch: all -> 0x00d7, BaseException -> 0x0172, SYNTHETIC, TRY_LEAVE, TryCatch #0 {BaseException -> 0x0172, blocks: (B:53:0x0149, B:55:0x0150, B:59:0x015c, B:60:0x0162, B:147:0x0182, B:148:0x0190, B:162:0x0198, B:164:0x019c, B:175:0x01b1, B:176:0x01b4), top: B:29:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0108 A[Catch: all -> 0x00d7, BaseException -> 0x00da, TRY_ENTER, TryCatch #11 {all -> 0x00d7, blocks: (B:22:0x004f, B:24:0x0059, B:27:0x0064, B:33:0x00ba, B:35:0x00be, B:44:0x00d3, B:45:0x00fe, B:47:0x0108, B:49:0x010c, B:51:0x013c, B:53:0x0149, B:55:0x0150, B:59:0x015c, B:60:0x0162, B:62:0x0175, B:144:0x0135, B:140:0x013b, B:147:0x0182, B:148:0x0190, B:182:0x00e4, B:184:0x00e8, B:162:0x0198, B:164:0x019c, B:175:0x01b1, B:176:0x01b4), top: B:21:0x004f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01dc A[Catch: all -> 0x01c5, TRY_ENTER, TryCatch #2 {all -> 0x01c5, blocks: (B:70:0x01d2, B:72:0x01dc, B:125:0x01e2, B:74:0x01eb, B:76:0x01f3, B:106:0x01f9, B:79:0x0204, B:81:0x0208, B:83:0x0210, B:85:0x0221, B:87:0x0247, B:89:0x024d, B:90:0x025a, B:92:0x0262, B:97:0x0254, B:99:0x0230, B:101:0x023c, B:110:0x026d, B:112:0x0275, B:114:0x027d, B:116:0x0285, B:118:0x028d, B:121:0x0296, B:201:0x01b5, B:206:0x01bf, B:211:0x01c9, B:22:0x004f, B:24:0x0059, B:27:0x0064, B:33:0x00ba, B:35:0x00be, B:44:0x00d3, B:45:0x00fe, B:47:0x0108, B:49:0x010c, B:51:0x013c, B:53:0x0149, B:55:0x0150, B:59:0x015c, B:60:0x0162, B:62:0x0175, B:144:0x0135, B:140:0x013b, B:147:0x0182, B:148:0x0190, B:182:0x00e4, B:184:0x00e8, B:162:0x0198, B:164:0x019c, B:175:0x01b1, B:176:0x01b4), top: B:69:0x01d2, inners: #3, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x024d A[Catch: all -> 0x01c5, TryCatch #2 {all -> 0x01c5, blocks: (B:70:0x01d2, B:72:0x01dc, B:125:0x01e2, B:74:0x01eb, B:76:0x01f3, B:106:0x01f9, B:79:0x0204, B:81:0x0208, B:83:0x0210, B:85:0x0221, B:87:0x0247, B:89:0x024d, B:90:0x025a, B:92:0x0262, B:97:0x0254, B:99:0x0230, B:101:0x023c, B:110:0x026d, B:112:0x0275, B:114:0x027d, B:116:0x0285, B:118:0x028d, B:121:0x0296, B:201:0x01b5, B:206:0x01bf, B:211:0x01c9, B:22:0x004f, B:24:0x0059, B:27:0x0064, B:33:0x00ba, B:35:0x00be, B:44:0x00d3, B:45:0x00fe, B:47:0x0108, B:49:0x010c, B:51:0x013c, B:53:0x0149, B:55:0x0150, B:59:0x015c, B:60:0x0162, B:62:0x0175, B:144:0x0135, B:140:0x013b, B:147:0x0182, B:148:0x0190, B:182:0x00e4, B:184:0x00e8, B:162:0x0198, B:164:0x019c, B:175:0x01b1, B:176:0x01b4), top: B:69:0x01d2, inners: #3, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0262 A[Catch: all -> 0x01c5, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x01c5, blocks: (B:70:0x01d2, B:72:0x01dc, B:125:0x01e2, B:74:0x01eb, B:76:0x01f3, B:106:0x01f9, B:79:0x0204, B:81:0x0208, B:83:0x0210, B:85:0x0221, B:87:0x0247, B:89:0x024d, B:90:0x025a, B:92:0x0262, B:97:0x0254, B:99:0x0230, B:101:0x023c, B:110:0x026d, B:112:0x0275, B:114:0x027d, B:116:0x0285, B:118:0x028d, B:121:0x0296, B:201:0x01b5, B:206:0x01bf, B:211:0x01c9, B:22:0x004f, B:24:0x0059, B:27:0x0064, B:33:0x00ba, B:35:0x00be, B:44:0x00d3, B:45:0x00fe, B:47:0x0108, B:49:0x010c, B:51:0x013c, B:53:0x0149, B:55:0x0150, B:59:0x015c, B:60:0x0162, B:62:0x0175, B:144:0x0135, B:140:0x013b, B:147:0x0182, B:148:0x0190, B:182:0x00e4, B:184:0x00e8, B:162:0x0198, B:164:0x019c, B:175:0x01b1, B:176:0x01b4), top: B:69:0x01d2, inners: #3, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x025e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0254 A[Catch: all -> 0x01c5, TryCatch #2 {all -> 0x01c5, blocks: (B:70:0x01d2, B:72:0x01dc, B:125:0x01e2, B:74:0x01eb, B:76:0x01f3, B:106:0x01f9, B:79:0x0204, B:81:0x0208, B:83:0x0210, B:85:0x0221, B:87:0x0247, B:89:0x024d, B:90:0x025a, B:92:0x0262, B:97:0x0254, B:99:0x0230, B:101:0x023c, B:110:0x026d, B:112:0x0275, B:114:0x027d, B:116:0x0285, B:118:0x028d, B:121:0x0296, B:201:0x01b5, B:206:0x01bf, B:211:0x01c9, B:22:0x004f, B:24:0x0059, B:27:0x0064, B:33:0x00ba, B:35:0x00be, B:44:0x00d3, B:45:0x00fe, B:47:0x0108, B:49:0x010c, B:51:0x013c, B:53:0x0149, B:55:0x0150, B:59:0x015c, B:60:0x0162, B:62:0x0175, B:144:0x0135, B:140:0x013b, B:147:0x0182, B:148:0x0190, B:182:0x00e4, B:184:0x00e8, B:162:0x0198, B:164:0x019c, B:175:0x01b1, B:176:0x01b4), top: B:69:0x01d2, inners: #3, #11 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(com.ss.android.socialbase.downloader.model.b r25) {
        /*
            Method dump skipped, instructions count: 675
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.b.a(com.ss.android.socialbase.downloader.model.b):boolean");
    }

    public b(com.ss.android.socialbase.downloader.model.b bVar, DownloadTask downloadTask, i iVar, f fVar) {
        this(bVar, downloadTask, fVar);
        this.h = iVar;
    }

    private void a(com.ss.android.socialbase.downloader.model.b bVar, long j) {
        com.ss.android.socialbase.downloader.model.b e = bVar.d() ? bVar.e() : bVar;
        if (e != null) {
            if (e.h()) {
                this.i.a(e.k(), e.b(), j);
            }
            e.b(j);
            this.i.a(e.k(), e.s(), e.b(), j);
            return;
        }
        if (bVar.d()) {
            this.i.a(bVar.k(), bVar.s(), j);
        }
    }

    public void a() {
        this.j = true;
        com.ss.android.socialbase.downloader.downloader.e eVar = this.d;
        if (eVar != null) {
            eVar.b();
        }
    }
}
