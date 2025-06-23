package com.ss.android.socialbase.appdownloader.f.a;

import java.io.PrintStream;

/* loaded from: classes13.dex */
public class h extends Exception {

    /* renamed from: a, reason: collision with root package name */
    protected Throwable f26188a;
    protected int b;
    protected int c;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h(java.lang.String r4, com.ss.android.socialbase.appdownloader.f.a.g r5, java.lang.Throwable r6) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = ""
            if (r4 != 0) goto Lb
            r4 = r1
            goto L1c
        Lb:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.lang.String r4 = " "
            r2.append(r4)
            java.lang.String r4 = r2.toString()
        L1c:
            r0.append(r4)
            if (r5 != 0) goto L23
            r4 = r1
            goto L3d
        L23:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r2 = "(position:"
            r4.append(r2)
            java.lang.String r2 = r5.d()
            r4.append(r2)
            java.lang.String r2 = ") "
            r4.append(r2)
            java.lang.String r4 = r4.toString()
        L3d:
            r0.append(r4)
            if (r6 != 0) goto L43
            goto L54
        L43:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r1 = "caused by: "
            r4.append(r1)
            r4.append(r6)
            java.lang.String r1 = r4.toString()
        L54:
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            r4 = -1
            r3.b = r4
            r3.c = r4
            if (r5 == 0) goto L71
            int r4 = r5.c()
            r3.b = r4
            int r4 = r5.f()
            r3.c = r4
        L71:
            r3.f26188a = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.f.a.h.<init>(java.lang.String, com.ss.android.socialbase.appdownloader.f.a.g, java.lang.Throwable):void");
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.f26188a == null) {
            super.printStackTrace();
            return;
        }
        PrintStream printStream = System.err;
        synchronized (printStream) {
            printStream.println(super.getMessage() + "; nested exception is:");
            this.f26188a.printStackTrace();
        }
    }
}
