package com.baidu.mshield.x0.i;

import android.content.Context;
import android.content.Intent;
import com.baidu.mshield.x0.b.d;
import com.baidu.mshield.x0.h.a;

/* loaded from: classes7.dex */
public class a {
    public static void a(Context context, Intent intent) {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004a A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:5:0x0003, B:15:0x0043, B:17:0x004a, B:19:0x0027, B:22:0x0033), top: B:4:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r3, java.lang.String r4) {
        /*
            if (r4 != 0) goto L3
            return
        L3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L31
            r0.<init>()     // Catch: java.lang.Throwable -> L31
            java.lang.String r1 = "secac="
            r0.append(r1)     // Catch: java.lang.Throwable -> L31
            r0.append(r4)     // Catch: java.lang.Throwable -> L31
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L31
            com.baidu.mshield.b.c.a.b(r0)     // Catch: java.lang.Throwable -> L31
            int r0 = r4.hashCode()     // Catch: java.lang.Throwable -> L31
            r1 = 1083937949(0x409b949d, float:4.8618913)
            r2 = 1
            if (r0 == r1) goto L33
            r1 = 1278732294(0x4c37e806, float:4.8209944E7)
            if (r0 == r1) goto L27
            goto L3d
        L27:
            java.lang.String r0 = "com.baidu.mshield.x0.detect.app.fr"
            boolean r4 = r4.equals(r0)     // Catch: java.lang.Throwable -> L31
            if (r4 == 0) goto L3d
            r4 = 1
            goto L3e
        L31:
            r3 = move-exception
            goto L4e
        L33:
            java.lang.String r0 = "com.baidu.mshield.x0.timer.pp.action"
            boolean r4 = r4.equals(r0)     // Catch: java.lang.Throwable -> L31
            if (r4 == 0) goto L3d
            r4 = 0
            goto L3e
        L3d:
            r4 = -1
        L3e:
            if (r4 == 0) goto L4a
            if (r4 == r2) goto L43
            goto L51
        L43:
            com.baidu.mshield.x0.a.d.a(r3)     // Catch: java.lang.Throwable -> L31
            com.baidu.mshield.x0.b.b.c(r3)     // Catch: java.lang.Throwable -> L31
            goto L51
        L4a:
            a(r3)     // Catch: java.lang.Throwable -> L31
            goto L51
        L4e:
            com.baidu.mshield.x0.b.d.a(r3)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x0.i.a.a(android.content.Context, java.lang.String):void");
    }

    public static void a(Context context) {
        try {
            com.baidu.mshield.x0.h.a.a(context).a((a.InterfaceC0148a) new b(context), true);
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
