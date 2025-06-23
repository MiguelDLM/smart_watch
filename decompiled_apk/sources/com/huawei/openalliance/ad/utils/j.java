package com.huawei.openalliance.ad.utils;

import android.content.Context;
import com.huawei.hms.ads.base.R;
import java.util.Locale;

/* loaded from: classes10.dex */
public class j {
    private static final String Code = "CNStrUtil";

    private static String Code(long j) {
        float f = (((float) j) * 1.0f) / 1048576.0f;
        if (f < 0.1f) {
            f = 0.1f;
        }
        return String.format(Locale.getDefault(), "%.1f", Float.valueOf(f));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String Code(android.content.Context r5, int r6, java.lang.String r7, java.lang.Object... r8) {
        /*
            java.lang.String r0 = "getChinaString "
            java.lang.String r1 = "CNStrUtil"
            android.content.res.Resources r2 = r5.getResources()
            r3 = 0
            com.huawei.hms.ads.cv r4 = com.huawei.hms.ads.ck.Code(r5)     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            boolean r4 = r4.Code()     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            if (r4 == 0) goto L5f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            r4.<init>()     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            r4.append(r7)     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            java.lang.String r7 = "_zh"
            r4.append(r7)     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            java.lang.String r4 = "string"
            java.lang.String r5 = r5.getPackageName()     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            int r5 = r2.getIdentifier(r7, r4, r5)     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            if (r8 == 0) goto L39
            java.lang.String r3 = r2.getString(r5, r8)     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            goto L5f
        L35:
            r5 = move-exception
            goto L3e
        L37:
            r5 = move-exception
            goto L59
        L39:
            java.lang.String r3 = r2.getString(r5)     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            goto L5f
        L3e:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
        L43:
            r7.append(r0)
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            com.huawei.hms.ads.fb.Z(r1, r5)
            goto L5f
        L59:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            goto L43
        L5f:
            if (r3 != 0) goto L6f
            if (r8 == 0) goto L6b
            int r5 = r8.length
            if (r5 <= 0) goto L6b
            java.lang.String r3 = r2.getString(r6, r8)
            goto L6f
        L6b:
            java.lang.String r3 = r2.getString(r6)
        L6f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.j.Code(android.content.Context, int, java.lang.String, java.lang.Object[]):java.lang.String");
    }

    public static String Code(Context context, long j) {
        if (context == null) {
            return "";
        }
        return context.getString(R.string.hiad_data_size_prompt, Code(j));
    }
}
