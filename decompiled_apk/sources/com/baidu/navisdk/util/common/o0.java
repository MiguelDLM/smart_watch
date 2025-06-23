package com.baidu.navisdk.util.common;

import java.util.ArrayList;

/* loaded from: classes8.dex */
public class o0 {

    /* renamed from: a, reason: collision with root package name */
    private d f9245a;
    private b b;

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i, boolean z, ArrayList<String> arrayList);
    }

    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final o0 f9246a = new o0();
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a(int i);

        void a(int i, String[] strArr);
    }

    public static o0 b() {
        return c.f9246a;
    }

    public void a(int i, b bVar) {
        this.b = bVar;
        d dVar = this.f9245a;
        if (dVar != null) {
            dVar.a(i);
        }
    }

    private o0() {
    }

    public void a(int i, String[] strArr, b bVar) {
        this.b = bVar;
        d dVar = this.f9245a;
        if (dVar != null) {
            dVar.a(i, strArr);
        }
    }

    public void a(int i, String[] strArr, int[] iArr) {
        if (iArr.length > 0) {
            ArrayList<String> arrayList = new ArrayList<>(iArr.length);
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (iArr[i2] != 0) {
                    arrayList.add(strArr[i2]);
                }
            }
            if (arrayList.isEmpty()) {
                b bVar = this.b;
                if (bVar != null) {
                    bVar.a(i, true, null);
                    this.b = null;
                    return;
                }
                return;
            }
            b bVar2 = this.b;
            if (bVar2 != null) {
                bVar2.a(i, false, arrayList);
                this.b = null;
            }
        }
    }

    public d a() {
        return this.f9245a;
    }

    public void a(d dVar) {
        this.f9245a = dVar;
    }
}
