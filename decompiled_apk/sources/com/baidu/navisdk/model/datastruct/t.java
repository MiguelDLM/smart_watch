package com.baidu.navisdk.model.datastruct;

import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class t {
    public static int s = 1;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<s> f6942a;
    private int b;
    private int c;
    private q d;
    private String e;
    private String f;
    private boolean g;
    private int h;
    private int i;
    private f j;
    private int k;
    private t l;
    private ArrayList<s> m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;

    private t() {
        this.b = 1;
        this.p = 0;
        this.q = 0;
        this.r = -1;
    }

    public void a(boolean z) {
    }

    public int b() {
        return this.c;
    }

    public f c() {
        return this.j;
    }

    public int d() {
        return this.r;
    }

    public int e() {
        return this.i;
    }

    public int f() {
        return this.b;
    }

    public ArrayList<s> g() {
        if (s == 2 && this.k != 6) {
            if (this.m == null && this.f6942a != null) {
                this.m = new ArrayList<>(b());
                for (int i = 0; i < b() && i < this.f6942a.size(); i++) {
                    this.m.add(this.f6942a.get(i));
                }
                GeoPoint c = ((com.baidu.navisdk.model.modelfactory.e) com.baidu.navisdk.model.modelfactory.c.a().a("PoiSearchModel")).c();
                if (c != null && c.isValid()) {
                    a(c, this.m);
                }
                if (this.f6942a.size() > b()) {
                    for (int i2 = 0; i2 < this.f6942a.size() - b(); i2++) {
                        this.m.add(this.f6942a.get(b() + i2));
                    }
                }
            }
            return this.m;
        }
        return this.f6942a;
    }

    public t h() {
        return this.l;
    }

    public q i() {
        return this.d;
    }

    public String j() {
        return this.e;
    }

    public int k() {
        return this.n;
    }

    public int l() {
        return this.o;
    }

    public int m() {
        return this.p;
    }

    public int n() {
        return this.q;
    }

    public int o() {
        return this.k;
    }

    public int p() {
        return s;
    }

    public String q() {
        return this.f;
    }

    public boolean r() {
        return this.g;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x004d A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean s() {
        /*
            r1 = this;
            int r0 = r1.k
            switch(r0) {
                case 1: goto L43;
                case 2: goto L32;
                case 3: goto L21;
                case 4: goto L18;
                case 5: goto Lf;
                case 6: goto L6;
                default: goto L5;
            }
        L5:
            goto L4b
        L6:
            java.lang.String r0 = r1.e
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L4d
            goto L4b
        Lf:
            com.baidu.navisdk.model.datastruct.q r0 = r1.d
            if (r0 == 0) goto L4b
            com.baidu.nplatform.comapi.basestruct.GeoPoint r0 = r0.f6939a
            if (r0 != 0) goto L4d
            goto L4b
        L18:
            com.baidu.navisdk.model.datastruct.q r0 = r1.d
            if (r0 == 0) goto L4b
            com.baidu.nplatform.comapi.basestruct.GeoPoint r0 = r0.f6939a
            if (r0 != 0) goto L4d
            goto L4b
        L21:
            java.lang.String r0 = r1.e
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L4b
            com.baidu.navisdk.model.datastruct.q r0 = r1.d
            if (r0 == 0) goto L4b
            com.baidu.nplatform.comapi.basestruct.GeoPoint r0 = r0.f6939a
            if (r0 != 0) goto L4d
            goto L4b
        L32:
            java.lang.String r0 = r1.e
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L4b
            com.baidu.navisdk.model.datastruct.q r0 = r1.d
            if (r0 == 0) goto L4b
            com.baidu.nplatform.comapi.basestruct.GeoPoint r0 = r0.f6939a
            if (r0 != 0) goto L4d
            goto L4b
        L43:
            java.lang.String r0 = r1.e
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L4d
        L4b:
            r0 = 0
            goto L4e
        L4d:
            r0 = 1
        L4e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.model.datastruct.t.s():boolean");
    }

    public int a() {
        return this.h;
    }

    public void b(int i) {
        this.p = i;
    }

    public void c(int i) {
        this.q = i;
    }

    public void a(Object obj) {
        if (obj == null || !(obj instanceof s)) {
            return;
        }
        if (this.f6942a == null) {
            this.f6942a = new ArrayList<>();
        }
        this.f6942a.add((s) obj);
    }

    public t(String str, String str2, int i, int i2, int i3, int i4) {
        this.b = 1;
        this.p = 0;
        this.q = 0;
        this.r = -1;
        this.k = 6;
        this.e = str;
        this.f = str2;
        this.n = i;
        this.o = i2;
        this.c = i3;
        this.i = i4;
        s = 1;
    }

    public void a(int i) {
        this.r = i;
    }

    private static void a(GeoPoint geoPoint, ArrayList<s> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            int longitudeE6 = arrayList.get(i).k.getLongitudeE6();
            int latitudeE6 = arrayList.get(i).k.getLatitudeE6();
            arrayList2.add(Double.valueOf(Math.sqrt(((longitudeE6 - geoPoint.getLongitudeE6()) * (longitudeE6 - geoPoint.getLongitudeE6())) + ((latitudeE6 - geoPoint.getLatitudeE6()) * (latitudeE6 - geoPoint.getLatitudeE6())))));
        }
        a(arrayList2, 0, size - 1, arrayList);
    }

    private static void a(ArrayList<Double> arrayList, int i, int i2, ArrayList<s> arrayList2) {
        if (i >= i2 || i < 0 || arrayList == null || arrayList2 == null || i2 >= arrayList.size() || i2 >= arrayList2.size()) {
            return;
        }
        Double d = arrayList.get(i);
        double doubleValue = d.doubleValue();
        s sVar = arrayList2.get(i);
        int i3 = i;
        int i4 = i2;
        while (i3 < i4) {
            while (i3 < i4 && arrayList.get(i4).doubleValue() >= doubleValue) {
                i4--;
            }
            arrayList.set(i3, arrayList.get(i4));
            arrayList2.set(i3, arrayList2.get(i4));
            while (i3 < i4 && arrayList.get(i3).doubleValue() < doubleValue) {
                i3++;
            }
            arrayList.set(i4, arrayList.get(i3));
            arrayList2.set(i4, arrayList2.get(i3));
        }
        arrayList.set(i3, d);
        arrayList2.set(i3, sVar);
        a(arrayList, i, i3 - 1, arrayList2);
        a(arrayList, i3 + 1, i2, arrayList2);
    }
}
