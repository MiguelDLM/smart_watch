package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;

/* loaded from: classes7.dex */
public class dj {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6310a = "error_message";
    public static final String b = "error_code";
    private static volatile dj d;
    protected final bv c = bv.a();

    private dj() {
    }

    public static dj a() {
        if (d == null) {
            synchronized (dj.class) {
                try {
                    if (d == null) {
                        d = new dj();
                    }
                } finally {
                }
            }
        }
        return d;
    }

    public String a(br brVar, String str) {
        if (brVar == null) {
            return "";
        }
        return a(brVar.b() + "", brVar.c(), str);
    }

    public String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append("ErrorCode: [");
            sb.append(str);
            sb.append("];");
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append("ErrorDesc: [");
            sb.append(str2);
            sb.append("];");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(" Extra: [");
            sb.append(str3);
            sb.append("];");
        }
        return sb.toString();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:9:0x0019
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "error_message"
            java.lang.String r1 = "msg"
            java.lang.String r2 = ""
            if (r5 == 0) goto L28
            boolean r3 = r5.containsKey(r1)     // Catch: java.lang.Exception -> L19
            if (r3 == 0) goto L1b
            java.lang.Object r5 = r5.get(r1)     // Catch: java.lang.Exception -> L19
            com.baidu.mobads.sdk.internal.br r5 = (com.baidu.mobads.sdk.internal.br) r5     // Catch: java.lang.Exception -> L19
            java.lang.String r5 = r4.a(r5, r2)     // Catch: java.lang.Exception -> L19
            goto L29
        L19:
            goto L28
        L1b:
            boolean r1 = r5.containsKey(r0)     // Catch: java.lang.Exception -> L19
            if (r1 == 0) goto L28
            java.lang.Object r5 = r5.get(r0)     // Catch: java.lang.Exception -> L19
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L19
            goto L29
        L28:
            r5 = r2
        L29:
            if (r5 != 0) goto L2c
            goto L2d
        L2c:
            r2 = r5
        L2d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.dj.a(java.util.Map):java.lang.String");
    }
}
