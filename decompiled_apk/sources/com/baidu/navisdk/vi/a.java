package com.baidu.navisdk.vi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9406a = "a";

    @SuppressLint({"UseSparseArrays"})
    private static final Map<Integer, Bundle> b = new HashMap();

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x001c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.os.Bundle a(int r7) {
        /*
            com.baidu.navisdk.jni.nativeif.JNIGuidanceControl r0 = com.baidu.navisdk.jni.nativeif.JNIGuidanceControl.getInstance()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            switch(r7) {
                case 4100: goto Ldc;
                case 4101: goto Ld3;
                case 4102: goto Ld3;
                case 4103: goto Ld3;
                case 4104: goto L8d;
                case 4105: goto L8d;
                case 4106: goto L8d;
                default: goto Lb;
            }
        Lb:
            switch(r7) {
                case 4108: goto L84;
                case 4109: goto L7b;
                case 4110: goto L7b;
                case 4111: goto L7b;
                default: goto Le;
            }
        Le:
            switch(r7) {
                case 4146: goto L72;
                case 4147: goto L72;
                case 4148: goto L72;
                default: goto L11;
            }
        L11:
            switch(r7) {
                case 4179: goto L68;
                case 4180: goto L68;
                case 4181: goto L68;
                default: goto L14;
            }
        L14:
            switch(r7) {
                case 4406: goto L5e;
                case 4407: goto L5e;
                case 4408: goto L5e;
                case 4409: goto L54;
                case 4410: goto L54;
                case 4411: goto L54;
                default: goto L17;
            }
        L17:
            switch(r7) {
                case 4441: goto L4a;
                case 4442: goto L4a;
                case 4443: goto L4a;
                default: goto L1a;
            }
        L1a:
            java.lang.String r2 = "get_image"
            switch(r7) {
                case 4608: goto L3c;
                case 4609: goto L2e;
                case 4610: goto L24;
                default: goto L1f;
            }
        L1f:
            switch(r7) {
                case 4617: goto L2e;
                case 4618: goto L2e;
                case 4619: goto L24;
                default: goto L22;
            }
        L22:
            goto Le4
        L24:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r0.GetVectorExpandMapInfo(r1)
            goto Le4
        L2e:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r7 = 0
            r1.putInt(r2, r7)
            r0.GetVectorExpandMapInfo(r1)
            goto Le4
        L3c:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r7 = 1
            r1.putInt(r2, r7)
            r0.GetVectorExpandMapInfo(r1)
            goto Le4
        L4a:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r0.GetExitDirectionBoardInfo(r1)
            goto Le4
        L54:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r0.GetExitFastway(r1)
            goto Le4
        L5e:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r0.GetInHighWay(r1)
            goto Le4
        L68:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r0.GetDestStreetViewInfo(r1)
            goto Le4
        L72:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r0.GetHighWayInfo(r1)
            goto Le4
        L7b:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r0.GetDirectBoardInfo(r1)
            goto Le4
        L84:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r0.GetCurRoadName(r1)
            goto Le4
        L8d:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r0.GetAssistRemainDist(r1)
            java.lang.String r0 = "remainDist"
            int r0 = r1.getInt(r0)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            java.lang.String r4 = com.baidu.navisdk.vi.a.f9406a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "~~~ msgId="
            r5.append(r6)
            r5.append(r7)
            java.lang.String r7 = ", remain dist="
            r5.append(r7)
            r5.append(r2)
            java.lang.String r7 = r5.toString()
            com.baidu.navisdk.util.common.LogUtil.e(r4, r7)
            java.lang.String r7 = "remain_dist"
            r3.putInt(r7, r0)
            java.lang.String r7 = "description"
            java.lang.String r0 = r1.getString(r7)
            r3.putString(r7, r0)
            r1 = r3
            goto Le4
        Ld3:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r0.GetRasterExpandMapInfo(r1)
            goto Le4
        Ldc:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r0.GetSimpleMapInfo(r1)
        Le4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.vi.a.a(int):android.os.Bundle");
    }

    public static Bundle b(int i) {
        Bundle a2 = a(i);
        if (a2 != null) {
            a(i, a2);
        }
        return a2;
    }

    private static synchronized void a(int i, Bundle bundle) {
        synchronized (a.class) {
            b.put(Integer.valueOf(i), bundle);
        }
    }
}
