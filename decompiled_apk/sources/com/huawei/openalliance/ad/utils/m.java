package com.huawei.openalliance.ad.utils;

import android.content.Context;

/* loaded from: classes10.dex */
public class m {
    private static final String B = "com.huawei.software.features.mobiletv";
    private static final String C = "com.huawei.software.features.watch";
    private static final String Code = "DeviceTypeUtil";
    private static final String D = "com.hihonor.software.features.pad";
    private static final String F = "com.hihonor.software.features.handset";
    private static final String I = "com.huawei.software.features.pad";
    private static final String L = "com.hihonor.software.features.tv";
    private static final String S = "com.huawei.software.features.kidwatch";
    private static final String V = "com.huawei.software.features.handset";
    private static final String Z = "com.huawei.software.features.tv";

    /* renamed from: a, reason: collision with root package name */
    private static final String f17412a = "com.hihonor.software.features.mobiletv";
    private static final String b = "com.hihonor.software.features.watch";
    private static final String c = "com.hihonor.software.features.kidwatch";
    private static final String d = "default";
    private static final String e = "tablet";
    private static final String f = "tv";
    private static m g;
    private static final byte[] h = new byte[0];
    private Context i;
    private String j = "0";

    private m(Context context) {
        this.i = context.getApplicationContext();
        Z();
    }

    public static m Code(Context context) {
        return V(context);
    }

    private static m V(Context context) {
        m mVar;
        synchronized (h) {
            try {
                if (g == null) {
                    g = new m(context);
                }
                mVar = g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ee, code lost:
    
        if (r0.equals(com.huawei.openalliance.ad.utils.m.f) != false) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Z() {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.m.Z():void");
    }

    public int I() {
        if ("4".equalsIgnoreCase(this.j)) {
            return 8;
        }
        return "1".equalsIgnoreCase(this.j) ? 5 : 4;
    }

    public String Code() {
        return this.j;
    }

    public boolean V() {
        return "4".equalsIgnoreCase(Code(this.i).Code());
    }
}
