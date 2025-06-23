package com.baidu.location.c;

import android.net.wifi.ScanResult;
import android.text.TextUtils;
import java.util.List;

/* loaded from: classes7.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public List<ScanResult> f5714a;
    public long b;
    public long c;
    public boolean e;
    public boolean d = false;
    public String f = null;
    public String g = null;

    public p(List<ScanResult> list, long j) {
        this.c = 0L;
        this.b = j;
        this.f5714a = list;
        this.c = System.currentTimeMillis();
        try {
            d();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private void d() {
        /*
            r7 = this;
            int r0 = r7.a()
            r1 = 1
            if (r0 >= r1) goto L8
            return
        L8:
            java.util.List<android.net.wifi.ScanResult> r0 = r7.f5714a
            int r0 = r0.size()
            int r0 = r0 - r1
            r2 = 1
        L10:
            if (r0 < r1) goto L5e
            if (r2 == 0) goto L5e
            r2 = 0
            r3 = 0
        L16:
            if (r2 >= r0) goto L5a
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f5714a
            java.lang.Object r4 = r4.get(r2)
            if (r4 == 0) goto L57
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f5714a
            int r5 = r2 + 1
            java.lang.Object r4 = r4.get(r5)
            if (r4 == 0) goto L57
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f5714a
            java.lang.Object r4 = r4.get(r2)
            android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
            int r4 = r4.level
            java.util.List<android.net.wifi.ScanResult> r6 = r7.f5714a
            java.lang.Object r6 = r6.get(r5)
            android.net.wifi.ScanResult r6 = (android.net.wifi.ScanResult) r6
            int r6 = r6.level
            if (r4 >= r6) goto L57
            java.util.List<android.net.wifi.ScanResult> r3 = r7.f5714a
            java.lang.Object r3 = r3.get(r5)
            android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f5714a
            java.lang.Object r6 = r4.get(r2)
            r4.set(r5, r6)
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f5714a
            r4.set(r2, r3)
            r3 = 1
        L57:
            int r2 = r2 + 1
            goto L16
        L5a:
            int r0 = r0 + (-1)
            r2 = r3
            goto L10
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.p.d():void");
    }

    public int a() {
        List<ScanResult> list = this.f5714a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public boolean b() {
        if (System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.c < 5000) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (System.currentTimeMillis() - this.b > 0 && System.currentTimeMillis() - this.b < 5000) {
            return true;
        }
        return false;
    }

    public boolean a(p pVar, float f) {
        return com.baidu.location.c.a.d.a(pVar, this, f);
    }

    public boolean a(p pVar) {
        List<ScanResult> list = this.f5714a;
        if (list == null || pVar == null || pVar.f5714a == null) {
            return false;
        }
        int min = Math.min(list.size(), pVar.f5714a.size());
        for (int i = 0; i < min; i++) {
            if (this.f5714a.get(i) != null) {
                String str = this.f5714a.get(i).BSSID;
                int i2 = this.f5714a.get(i).level;
                String str2 = pVar.f5714a.get(i).BSSID;
                int i3 = pVar.f5714a.get(i).level;
                if ((!TextUtils.isEmpty(str) && !str.equals(str2)) || i2 != i3) {
                    return false;
                }
            }
        }
        return true;
    }
}
