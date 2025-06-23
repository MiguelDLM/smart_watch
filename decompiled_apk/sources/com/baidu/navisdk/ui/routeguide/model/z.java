package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Arrays;

/* loaded from: classes8.dex */
public class z {
    private static z b;

    /* renamed from: a, reason: collision with root package name */
    private a[] f8986a = new a[3];

    /* loaded from: classes8.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public String f8987a;
        public String b;
        public String c;
        public int d;
        public int e;
        public int f;

        public a(z zVar) {
        }

        public boolean a() {
            return !TextUtils.isEmpty(this.f8987a);
        }

        public String toString() {
            return "RGSelectRouteItem{mrsl='" + this.f8987a + "', labelStr='" + this.b + "', labelInfo='" + this.c + "', remainDist=" + this.d + ", remainTime=" + this.e + ", trafficLight=" + this.f + '}';
        }
    }

    private z() {
        for (int i = 0; i < 3; i++) {
            this.f8986a[i] = new a(this);
        }
    }

    public static z c() {
        if (b == null) {
            b = new z();
        }
        return b;
    }

    public a[] a() {
        return (a[]) Arrays.copyOfRange(this.f8986a, 0, b());
    }

    public int b() {
        a[] aVarArr = this.f8986a;
        int length = aVarArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length && aVarArr[i2].a(); i2++) {
            i++;
        }
        return i;
    }

    public String toString() {
        return "RGSelectRouteModel{mETAItems=" + Arrays.toString(this.f8986a) + '}';
    }

    public void a(Bundle bundle) {
        String[] stringArray = bundle.getStringArray("mrslArray");
        if (stringArray != null) {
            for (int i = 0; i < stringArray.length; i++) {
                this.f8986a[i].f8987a = stringArray[i];
            }
        }
        String[] stringArray2 = bundle.getStringArray("labelStrArray");
        if (stringArray2 != null) {
            for (int i2 = 0; i2 < stringArray2.length; i2++) {
                this.f8986a[i2].b = stringArray2[i2];
            }
        }
        String[] stringArray3 = bundle.getStringArray("labelInfoArray");
        if (stringArray3 != null) {
            for (int i3 = 0; i3 < stringArray3.length; i3++) {
                this.f8986a[i3].c = stringArray3[i3];
            }
        }
        int[] intArray = bundle.getIntArray("remainDistArray");
        if (intArray != null) {
            for (int i4 = 0; i4 < intArray.length; i4++) {
                this.f8986a[i4].d = intArray[i4];
            }
        }
        int[] intArray2 = bundle.getIntArray("remainTimeArray");
        if (intArray2 != null) {
            for (int i5 = 0; i5 < intArray2.length; i5++) {
                this.f8986a[i5].e = intArray2[i5];
            }
        }
        int[] intArray3 = bundle.getIntArray("trafficLightArray");
        if (intArray3 != null) {
            for (int i6 = 0; i6 < intArray3.length; i6++) {
                this.f8986a[i6].f = intArray3[i6];
            }
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSelectRouteModel", toString());
        }
    }
}
