package com.baidu.platform.comapi.bmsdk;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class BmLayer extends BmObject {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<BmDrawItem> f9576a;
    private d b;
    private long c;

    public BmLayer() {
        super(1, nativeCreate());
        this.f9576a = new ArrayList<>();
        this.b = null;
        this.c = 0L;
    }

    private static native boolean nativeAddDrawItem(long j, long j2);

    private static native boolean nativeAddDrawItemAbove(long j, long j2, long j3);

    private static native boolean nativeAddDrawItemBelow(long j, long j2, long j3);

    private static native boolean nativeAddDrawItemByZIndex(long j, long j2, int i);

    private static native boolean nativeClearDrawItems(long j);

    private static native boolean nativeCommitUpdate(long j);

    private static native long nativeCreate();

    private static native Bundle nativeGetDrawItemRect(long j, int i, int i2, int i3, int i4);

    private static native long nativeGetLayerId(long j);

    private static native boolean nativeHandleClick(long j, int i, int i2, int i3, long[] jArr);

    private static native boolean nativeRemoveDrawItem(long j, long j2);

    private static native boolean nativeSetClickable(long j, boolean z);

    private static native boolean nativeSetCollisionBaseMap(long j, boolean z);

    private static native boolean nativeSetShowLevel(long j, int i, int i2);

    private static native boolean nativeSetVisibility(long j, int i);

    public long a() {
        if (this.c == 0) {
            this.c = nativeGetLayerId(this.g);
        }
        return this.c;
    }

    public boolean b() {
        this.f9576a.clear();
        return nativeClearDrawItems(this.g);
    }

    public boolean c() {
        return nativeCommitUpdate(this.g);
    }

    public boolean a(BmDrawItem bmDrawItem, short s) {
        this.f9576a.add(bmDrawItem);
        return nativeAddDrawItemByZIndex(this.g, bmDrawItem.e(), s);
    }

    public boolean a(BmDrawItem bmDrawItem) {
        this.f9576a.remove(bmDrawItem);
        return nativeRemoveDrawItem(this.g, bmDrawItem.e());
    }

    public BmDrawItem a(String str) {
        Iterator<BmDrawItem> it = this.f9576a.iterator();
        while (it.hasNext()) {
            BmDrawItem next = it.next();
            if (!str.isEmpty() && next.d().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public boolean a(int i, int i2, int i3) {
        long[] jArr = {0, 0, -1};
        if (nativeHandleClick(this.g, i, i2, i3, jArr) && this.b != null) {
            long j = jArr[0];
            if (j != 0) {
                for (int i4 = 0; i4 < this.f9576a.size(); i4++) {
                    if (this.f9576a.get(i4).g == j) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(int r11, int r12, int r13, boolean r14, boolean r15) {
        /*
            r10 = this;
            r0 = 1
            r1 = 0
            r3 = 3
            long[] r3 = new long[r3]
            r3 = {x0092: FILL_ARRAY_DATA , data: [0, 0, -1} // fill-array
            long r4 = r10.g
            r6 = r11
            r7 = r12
            r8 = r13
            r9 = r3
            boolean r11 = nativeHandleClick(r4, r6, r7, r8, r9)
            if (r11 == 0) goto L91
            com.baidu.platform.comapi.bmsdk.d r12 = r10.b
            if (r12 == 0) goto L91
            r12 = 0
            r4 = r3[r12]
            int r13 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r13 == 0) goto L91
        L20:
            java.util.ArrayList<com.baidu.platform.comapi.bmsdk.BmDrawItem> r13 = r10.f9576a
            int r13 = r13.size()
            if (r12 >= r13) goto L91
            java.util.ArrayList<com.baidu.platform.comapi.bmsdk.BmDrawItem> r13 = r10.f9576a
            java.lang.Object r13 = r13.get(r12)
            com.baidu.platform.comapi.bmsdk.BmDrawItem r13 = (com.baidu.platform.comapi.bmsdk.BmDrawItem) r13
            long r6 = r13.g
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 != 0) goto L8f
            r4 = r3[r0]
            int r12 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r12 == 0) goto L54
            boolean r12 = r13 instanceof com.baidu.platform.comapi.bmsdk.BmBaseMarker
            if (r12 == 0) goto L48
            r12 = r13
            com.baidu.platform.comapi.bmsdk.BmBaseMarker r12 = (com.baidu.platform.comapi.bmsdk.BmBaseMarker) r12
            com.baidu.platform.comapi.bmsdk.ui.BmBaseUI r12 = r12.a(r4)
            goto L55
        L48:
            boolean r12 = r13 instanceof com.baidu.platform.comapi.bmsdk.Bm3DModel
            if (r12 == 0) goto L54
            r12 = r13
            com.baidu.platform.comapi.bmsdk.Bm3DModel r12 = (com.baidu.platform.comapi.bmsdk.Bm3DModel) r12
            com.baidu.platform.comapi.bmsdk.ui.BmBaseUI r12 = r12.a(r4)
            goto L55
        L54:
            r12 = 0
        L55:
            boolean r0 = r13 instanceof com.baidu.platform.comapi.bmsdk.BmCircle
            r1 = 2
            if (r0 == 0) goto L63
            r0 = r13
            com.baidu.platform.comapi.bmsdk.BmCircle r0 = (com.baidu.platform.comapi.bmsdk.BmCircle) r0
            r1 = r3[r1]
            r0.a(r1)
            goto L6f
        L63:
            boolean r0 = r13 instanceof com.baidu.platform.comapi.bmsdk.BmPolygon
            if (r0 == 0) goto L6f
            r0 = r13
            com.baidu.platform.comapi.bmsdk.BmPolygon r0 = (com.baidu.platform.comapi.bmsdk.BmPolygon) r0
            r1 = r3[r1]
            r0.a(r1)
        L6f:
            if (r14 == 0) goto L81
            if (r15 == 0) goto L91
            if (r12 == 0) goto L7b
            com.baidu.platform.comapi.bmsdk.d r14 = r10.b
            r14.a(r13, r12)
            goto L91
        L7b:
            com.baidu.platform.comapi.bmsdk.d r12 = r10.b
            r12.a(r13)
            goto L91
        L81:
            if (r12 == 0) goto L89
            com.baidu.platform.comapi.bmsdk.d r14 = r10.b
            r14.a(r13, r12)
            goto L91
        L89:
            com.baidu.platform.comapi.bmsdk.d r12 = r10.b
            r12.a(r13)
            goto L91
        L8f:
            int r12 = r12 + r0
            goto L20
        L91:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.bmsdk.BmLayer.a(int, int, int, boolean, boolean):boolean");
    }

    public void a(d dVar) {
        this.b = dVar;
    }
}
