package com.baidu.navisdk.util.drivertool;

import android.graphics.Bitmap;

/* loaded from: classes8.dex */
public class f {
    private static f c;

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f9284a = null;
    private Object b = null;

    private f() {
    }

    public static f c() {
        if (c == null) {
            c = new f();
        }
        return c;
    }

    public String a() {
        return d.b(2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
    
        if (com.baidu.navisdk.k.f6861a != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0082, code lost:
    
        r6.f9284a.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0080, code lost:
    
        if (com.baidu.navisdk.k.f6861a != false) goto L39;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b() {
        /*
            r6 = this;
            android.graphics.Bitmap r0 = r6.f9284a
            if (r0 != 0) goto L5
            return
        L5:
            boolean r0 = r0.isMutable()
            java.lang.String r1 = "drivingTool"
            if (r0 != 0) goto L1d
            java.lang.String r0 = "photoFinishAction bitmap is not mutable"
            com.baidu.navisdk.util.common.LogUtil.e(r1, r0)
            android.graphics.Bitmap r0 = r6.f9284a
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.RGB_565
            r3 = 1
            android.graphics.Bitmap r0 = r0.copy(r2, r3)
            r6.f9284a = r0
        L1d:
            android.graphics.Bitmap r0 = r6.f9284a
            java.lang.String r2 = com.baidu.navisdk.util.drivertool.d.e()
            java.lang.String r3 = com.baidu.navisdk.util.drivertool.d.c()
            java.lang.Object r4 = r6.b
            com.baidu.navisdk.util.drivertool.d.a(r0, r2, r3, r4)
            java.io.File r0 = new java.io.File
            java.lang.String r2 = r6.a()
            r0.<init>(r2)
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            android.graphics.Bitmap r0 = r6.f9284a     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L61
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L61
            r5 = 90
            r0.compress(r4, r5, r3)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L61
            r3.flush()     // Catch: java.lang.Exception -> L4b
            r3.close()     // Catch: java.lang.Exception -> L4b
            goto L4c
        L4b:
        L4c:
            android.graphics.Bitmap r0 = r6.f9284a
            if (r0 == 0) goto L87
            boolean r0 = r0.isRecycled()
            if (r0 != 0) goto L87
            boolean r0 = com.baidu.navisdk.k.f6861a
            if (r0 == 0) goto L87
            goto L82
        L5b:
            r0 = move-exception
            goto L9e
        L5d:
            r0 = move-exception
            r3 = r2
            goto L9e
        L60:
            r3 = r2
        L61:
            boolean r0 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE     // Catch: java.lang.Throwable -> L5b
            if (r0 == 0) goto L6a
            java.lang.String r0 = "photoFinishAction Exception"
            com.baidu.navisdk.util.common.LogUtil.e(r1, r0)     // Catch: java.lang.Throwable -> L5b
        L6a:
            if (r3 == 0) goto L74
            r3.flush()     // Catch: java.lang.Exception -> L73
            r3.close()     // Catch: java.lang.Exception -> L73
            goto L74
        L73:
        L74:
            android.graphics.Bitmap r0 = r6.f9284a
            if (r0 == 0) goto L87
            boolean r0 = r0.isRecycled()
            if (r0 != 0) goto L87
            boolean r0 = com.baidu.navisdk.k.f6861a
            if (r0 == 0) goto L87
        L82:
            android.graphics.Bitmap r0 = r6.f9284a
            r0.recycle()
        L87:
            r6.f9284a = r2
            com.baidu.navisdk.util.drivertool.b r0 = com.baidu.navisdk.util.drivertool.b.n()
            r1 = 0
            r0.a(r1)
            com.baidu.navisdk.util.drivertool.b r0 = com.baidu.navisdk.util.drivertool.b.n()
            r1 = 2
            com.baidu.navisdk.util.drivertool.view.b r0 = r0.a(r1)
            r0.show()
            return
        L9e:
            if (r3 == 0) goto La8
            r3.flush()     // Catch: java.lang.Exception -> La7
            r3.close()     // Catch: java.lang.Exception -> La7
            goto La8
        La7:
        La8:
            android.graphics.Bitmap r1 = r6.f9284a
            if (r1 == 0) goto Lbb
            boolean r1 = r1.isRecycled()
            if (r1 != 0) goto Lbb
            boolean r1 = com.baidu.navisdk.k.f6861a
            if (r1 == 0) goto Lbb
            android.graphics.Bitmap r1 = r6.f9284a
            r1.recycle()
        Lbb:
            r6.f9284a = r2
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.drivertool.f.b():void");
    }
}
