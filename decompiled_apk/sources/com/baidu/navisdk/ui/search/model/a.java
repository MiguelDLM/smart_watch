package com.baidu.navisdk.ui.search.model;

import android.text.TextUtils;
import com.baidu.navisdk.model.datastruct.s;
import com.baidu.navisdk.util.common.l0;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f9185a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public int k;
    public GeoPoint l;
    public int m;
    public String n;
    public double o;

    public static List<s> a(List<a> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            s a2 = a(it.next());
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    public String toString() {
        return "NavPoiResult{\n\t name='" + this.b + "'\n\t addr='" + this.c + "'\n\t stdTag='" + this.d + "'\n\t distance='" + this.e + "'\n\t line1Column1='" + this.f + "'\n\t line1Column2='" + this.g + "'\n\t line2Column1='" + this.h + "'\n\t line2Column2='" + this.i + "'\n\t subTitle='" + this.j + "'\n\t accFlag=" + this.k + "\n\t cityId=" + this.m + "\n\t cityName='" + this.n + "'\n\t distanceValue=" + this.o + "\n\t geoPoint=" + this.l + '}';
    }

    public static s a(a aVar) {
        if (aVar == null) {
            return null;
        }
        s sVar = new s();
        sVar.k = aVar.l;
        sVar.e = aVar.b;
        sVar.g = aVar.c;
        StringBuilder sb = new StringBuilder();
        l0.a((int) aVar.o, l0.a.ZH, sb);
        sVar.u = "距离" + a(sb.toString());
        sVar.p = aVar.f9185a;
        return sVar;
    }

    private static String a(String str) {
        return (!TextUtils.isEmpty(str) && str.contains(".0")) ? str.replace(".0", "") : str;
    }
}
