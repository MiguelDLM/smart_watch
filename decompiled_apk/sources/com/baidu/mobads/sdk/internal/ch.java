package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.an;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ch implements an.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ double f6272a;
    final /* synthetic */ cb b;

    public ch(cb cbVar, double d) {
        this.b = cbVar;
        this.f6272a = d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0055, code lost:
    
        if (r9 == java.lang.Math.floor(r5.b())) goto L12;
     */
    @Override // com.baidu.mobads.sdk.internal.an.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            com.baidu.mobads.sdk.internal.cb r10 = r8.b
            com.baidu.mobads.sdk.internal.bz r0 = new com.baidu.mobads.sdk.internal.bz
            r0.<init>(r9)
            com.baidu.mobads.sdk.internal.cb.a(r10, r0)
            double r9 = com.baidu.mobads.sdk.internal.co.b()
            com.baidu.mobads.sdk.internal.cb r0 = r8.b
            android.content.SharedPreferences r0 = com.baidu.mobads.sdk.internal.cb.f(r0)
            java.lang.String r1 = "__badApkVersion__9.35"
            r2 = 0
            float r0 = r0.getFloat(r1, r2)
            com.baidu.mobads.sdk.internal.cb r1 = r8.b
            com.baidu.mobads.sdk.internal.bz r1 = com.baidu.mobads.sdk.internal.cb.g(r1)
            double r1 = r1.b()
            float r1 = (float) r1
            r2 = 1
            r3 = 0
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 != 0) goto L2e
            r1 = 1
            goto L2f
        L2e:
            r1 = 0
        L2f:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
            com.baidu.mobads.sdk.internal.cb r5 = r8.b
            com.baidu.mobads.sdk.internal.bz r5 = com.baidu.mobads.sdk.internal.cb.g(r5)
            double r5 = r5.b()
            int r7 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r7 > 0) goto L58
            double r9 = java.lang.Math.floor(r9)
            com.baidu.mobads.sdk.internal.cb r5 = r8.b
            com.baidu.mobads.sdk.internal.bz r5 = com.baidu.mobads.sdk.internal.cb.g(r5)
            double r5 = r5.b()
            double r5 = java.lang.Math.floor(r5)
            int r7 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r7 != 0) goto L58
            goto L59
        L58:
            r2 = 0
        L59:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r2)
            com.baidu.mobads.sdk.internal.cb r10 = r8.b
            com.baidu.mobads.sdk.internal.bv r10 = com.baidu.mobads.sdk.internal.cb.e(r10)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "try to download apk badVer="
            r5.append(r6)
            r5.append(r0)
            java.lang.String r0 = ", isBad="
            r5.append(r0)
            r5.append(r4)
            java.lang.String r0 = ", compatible="
            r5.append(r0)
            r5.append(r9)
            java.lang.String r9 = r5.toString()
            java.lang.String r0 = "ApkLoader"
            r10.a(r0, r9)
            double r9 = r8.f6272a
            com.baidu.mobads.sdk.internal.cb r0 = r8.b
            com.baidu.mobads.sdk.internal.bz r0 = com.baidu.mobads.sdk.internal.cb.g(r0)
            double r4 = r0.b()
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 >= 0) goto Lc0
            com.baidu.mobads.sdk.internal.cb r9 = r8.b
            com.baidu.mobads.sdk.internal.bz r9 = com.baidu.mobads.sdk.internal.cb.g(r9)
            if (r9 == 0) goto Lc0
            com.baidu.mobads.sdk.internal.cb r9 = r8.b
            com.baidu.mobads.sdk.internal.bz r9 = com.baidu.mobads.sdk.internal.cb.g(r9)
            java.lang.Boolean r9 = r9.a()
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto Lc0
            if (r2 == 0) goto Lc0
            if (r1 != 0) goto Lc0
            com.baidu.mobads.sdk.internal.cb r9 = r8.b
            com.baidu.mobads.sdk.internal.bz r10 = com.baidu.mobads.sdk.internal.cb.g(r9)
            com.baidu.mobads.sdk.internal.cb.b(r9, r10)
            goto Ld4
        Lc0:
            com.baidu.mobads.sdk.internal.cb r9 = r8.b
            boolean r9 = com.baidu.mobads.sdk.internal.cb.c(r9)
            if (r9 == 0) goto Ld4
            com.baidu.mobads.sdk.internal.cb r9 = r8.b
            com.baidu.mobads.sdk.internal.cb.a(r9, r3)
            com.baidu.mobads.sdk.internal.cb r9 = r8.b
            java.lang.String r10 = "Refused to download remote for version..."
            com.baidu.mobads.sdk.internal.cb.a(r9, r3, r10)
        Ld4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.ch.a(java.lang.String, java.lang.String):void");
    }

    @Override // com.baidu.mobads.sdk.internal.an.b
    public void a(String str, int i) {
        boolean z;
        z = this.b.A;
        if (z) {
            this.b.A = false;
            this.b.a(false, "remote update Network access failed");
        }
    }
}
