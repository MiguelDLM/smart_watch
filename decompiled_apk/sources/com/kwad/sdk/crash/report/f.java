package com.kwad.sdk.crash.report;

/* loaded from: classes11.dex */
public final class f extends d {
    /* JADX WARN: Removed duplicated region for block: B:13:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0050  */
    @Override // com.kwad.sdk.crash.report.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.kwad.sdk.crash.model.message.ExceptionMessage a(@androidx.annotation.NonNull java.io.File r7, java.io.File r8, java.io.File r9, java.lang.String r10) {
        /*
            r6 = this;
            java.lang.String r8 = "\n"
            r0 = 0
            java.lang.String r1 = com.kwad.sdk.utils.q.V(r7)     // Catch: java.lang.Exception -> L8
            goto L20
        L8:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r6.mErrorMessage
            r2.append(r3)
            r2.append(r1)
            r2.append(r8)
            java.lang.String r1 = r2.toString()
            r6.mErrorMessage = r1
            r1 = r0
        L20:
            if (r1 == 0) goto L4e
            com.kwad.sdk.crash.model.message.JavaExceptionMessage r2 = new com.kwad.sdk.crash.model.message.JavaExceptionMessage     // Catch: java.lang.Exception -> L33
            r2.<init>()     // Catch: java.lang.Exception -> L33
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L31
            r0.<init>(r1)     // Catch: java.lang.Exception -> L31
            r2.parseJson(r0)     // Catch: java.lang.Exception -> L31
        L2f:
            r0 = r2
            goto L4e
        L31:
            r0 = move-exception
            goto L37
        L33:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
        L37:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r6.mErrorMessage
            r3.append(r4)
            r3.append(r0)
            r3.append(r8)
            java.lang.String r0 = r3.toString()
            r6.mErrorMessage = r0
            goto L2f
        L4e:
            if (r0 != 0) goto L5d
            com.kwad.sdk.crash.model.message.JavaExceptionMessage r0 = new com.kwad.sdk.crash.model.message.JavaExceptionMessage
            r0.<init>()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L5d
            r0.mCrashDetail = r1
        L5d:
            java.lang.String r1 = r7.getName()     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r1 = com.kwad.sdk.crash.utils.g.fT(r1)     // Catch: java.lang.Throwable -> Lb0
            r0.mLogUUID = r1     // Catch: java.lang.Throwable -> Lb0
            r0.toString()     // Catch: java.lang.Throwable -> Lb0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> Lb0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb0
            r2.<init>()     // Catch: java.lang.Throwable -> Lb0
            r2.append(r10)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r3 = ".jtrace"
            r2.append(r3)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lb0
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lb0
            com.kwad.sdk.crash.report.d.a(r1, r0)     // Catch: java.lang.Throwable -> Lb0
            r6.b(r9, r0)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r1 = r0.toString()     // Catch: java.lang.Throwable -> Lb0
            com.kwad.sdk.crash.utils.g.a(r7, r1)     // Catch: java.lang.Throwable -> Lb0
            com.kwad.sdk.crash.utils.g.d(r9, r7)     // Catch: java.lang.Throwable -> Lb0
            r7.renameTo(r9)     // Catch: java.lang.Throwable -> Lb0
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> Lb0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb0
            r9.<init>()     // Catch: java.lang.Throwable -> Lb0
            r9.append(r10)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r10 = ".minfo"
            r9.append(r10)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lb0
            r7.<init>(r9)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r7 = com.kwad.sdk.utils.q.V(r7)     // Catch: java.lang.Throwable -> Lb0
            r0.mDumpsys = r7     // Catch: java.lang.Throwable -> Lb0
            goto Lca
        Lb0:
            r7 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r6.mErrorMessage
            r9.append(r10)
            r9.append(r7)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r6.mErrorMessage = r8
            com.kwad.sdk.core.e.c.printStackTraceOnly(r7)
        Lca:
            java.lang.String r7 = r6.mErrorMessage
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto Le7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r0.mErrorMessage
            r7.append(r8)
            java.lang.String r8 = r6.mErrorMessage
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r0.mErrorMessage = r7
        Le7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.report.f.a(java.io.File, java.io.File, java.io.File, java.lang.String):com.kwad.sdk.crash.model.message.ExceptionMessage");
    }
}
