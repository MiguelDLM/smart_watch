package com.jd.ad.sdk.jad_kx;

/* loaded from: classes10.dex */
public class jad_er {
    public com.jd.ad.sdk.jad_kx.jad_an jad_an;
    public jad_fs jad_bo;
    public com.jd.ad.sdk.jad_na.jad_an jad_er;
    public int jad_cp = 3600;
    public int jad_dq = 2;
    public int jad_fs = 3;
    public boolean jad_jt = true;

    /* loaded from: classes10.dex */
    public static class jad_an {
        public static final jad_er jad_an = new jad_er();
    }

    public int jad_bo() {
        if (this.jad_er == null) {
            this.jad_er = com.jd.ad.sdk.jad_pc.jad_an.jad_an();
        }
        com.jd.ad.sdk.jad_na.jad_an jad_anVar = this.jad_er;
        if (jad_anVar != null) {
            this.jad_cp = jad_anVar.jad_jw;
        }
        return this.jad_cp;
    }

    public int jad_cp() {
        if (this.jad_er == null) {
            this.jad_er = com.jd.ad.sdk.jad_pc.jad_an.jad_an();
        }
        com.jd.ad.sdk.jad_na.jad_an jad_anVar = this.jad_er;
        if (jad_anVar != null) {
            this.jad_fs = jad_anVar.jad_ly;
        }
        if (this.jad_fs < 3) {
            this.jad_fs = 3;
        }
        return this.jad_fs;
    }

    public int jad_an() {
        if (this.jad_er == null) {
            this.jad_er = com.jd.ad.sdk.jad_pc.jad_an.jad_an();
        }
        com.jd.ad.sdk.jad_na.jad_an jad_anVar = this.jad_er;
        if (jad_anVar != null) {
            this.jad_dq = jad_anVar.jad_kx;
        }
        return this.jad_dq;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e A[Catch: all -> 0x0016, DONT_GENERATE, TryCatch #0 {all -> 0x0016, blocks: (B:7:0x0009, B:9:0x000d, B:11:0x0011, B:12:0x0018, B:14:0x0022, B:15:0x0028, B:17:0x0033, B:19:0x0048, B:21:0x004e, B:24:0x0052, B:27:0x005e, B:30:0x0039, B:32:0x003d, B:34:0x0043), top: B:6:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean jad_bo(java.lang.String r5) {
        /*
            r4 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            monitor-enter(r4)
            boolean r0 = r4.jad_jt     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L43
            com.jd.ad.sdk.jad_kx.jad_fs r0 = r4.jad_bo     // Catch: java.lang.Throwable -> L16
            if (r0 != 0) goto L18
            com.jd.ad.sdk.jad_kx.jad_fs r0 = com.jd.ad.sdk.jad_kx.jad_fs.jad_an.jad_an     // Catch: java.lang.Throwable -> L16
            r4.jad_bo = r0     // Catch: java.lang.Throwable -> L16
            goto L18
        L16:
            r5 = move-exception
            goto L60
        L18:
            com.jd.ad.sdk.jad_kx.jad_fs r0 = r4.jad_bo     // Catch: java.lang.Throwable -> L16
            java.util.ArrayList r0 = r0.jad_an(r5)     // Catch: java.lang.Throwable -> L16
            com.jd.ad.sdk.jad_kx.jad_an r2 = r4.jad_an     // Catch: java.lang.Throwable -> L16
            if (r2 != 0) goto L28
            com.jd.ad.sdk.jad_kx.jad_an r2 = com.jd.ad.sdk.jad_kx.jad_an.jad_dq()     // Catch: java.lang.Throwable -> L16
            r4.jad_an = r2     // Catch: java.lang.Throwable -> L16
        L28:
            com.jd.ad.sdk.jad_kx.jad_an r2 = r4.jad_an     // Catch: java.lang.Throwable -> L16
            com.jd.ad.sdk.jad_kx.jad_fs r3 = r4.jad_bo     // Catch: java.lang.Throwable -> L16
            java.util.List<java.lang.String> r3 = r3.jad_bo     // Catch: java.lang.Throwable -> L16
            r2.jad_an(r3)     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L39
            int r2 = r0.size()     // Catch: java.lang.Throwable -> L16
            if (r2 > 0) goto L48
        L39:
            com.jd.ad.sdk.jad_kx.jad_an r2 = r4.jad_an     // Catch: java.lang.Throwable -> L16
            if (r2 == 0) goto L48
            java.util.List r5 = r2.jad_an(r5)     // Catch: java.lang.Throwable -> L16
        L41:
            r0 = r5
            goto L48
        L43:
            java.util.List r5 = com.jd.ad.sdk.jad_re.jad_an.jad_an(r5)     // Catch: java.lang.Throwable -> L16
            goto L41
        L48:
            int r5 = r4.jad_an()     // Catch: java.lang.Throwable -> L16
            if (r5 > 0) goto L50
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L16
            return r1
        L50:
            if (r0 == 0) goto L5d
            int r5 = r0.size()     // Catch: java.lang.Throwable -> L16
            int r0 = r4.jad_an()     // Catch: java.lang.Throwable -> L16
            if (r5 < r0) goto L5d
            goto L5e
        L5d:
            r1 = 0
        L5e:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L16
            return r1
        L60:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L16
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_kx.jad_er.jad_bo(java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x027c, code lost:
    
        if (r3.isClosed() == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0283, code lost:
    
        r5 = com.jd.ad.sdk.jad_uh.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
        com.jd.ad.sdk.jad_vi.jad_fs.jad_an("", r5.jad_an, r5.jad_an(r0.getMessage()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02ac, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02ad, code lost:
    
        if (r3 != null) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02b5, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x02b8, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x024b, code lost:
    
        r4 = new com.jd.ad.sdk.jad_kx.jad_cp(r10, r11, r0, r13, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0252, code lost:
    
        ((java.util.ArrayList) com.jd.ad.sdk.jad_re.jad_an.jad_bo).add(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0259, code lost:
    
        r8 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x025b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x025c, code lost:
    
        r8 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0130, code lost:
    
        r12 = new com.jd.ad.sdk.jad_kx.jad_cp(r3, r19, r11, r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0139, code lost:
    
        r9.jad_bo.add(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x013e, code lost:
    
        r8 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0140, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0141, code lost:
    
        r8 = r12;
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0161, code lost:
    
        if (r0 == false) goto L75;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017f A[DONT_GENERATE] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String jad_an(java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 699
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_kx.jad_er.jad_an(java.lang.String):java.lang.String");
    }
}
