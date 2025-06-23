package com.baidu.nplatform.comapi.basestruct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f9473a;
    private c b;
    private c c;
    private ArrayList<ArrayList<c>> d;
    private ArrayList<c> e;

    public static a a(List<? extends Number> list) {
        if (list == null || list.size() < 2) {
            return null;
        }
        a aVar = new a();
        int size = list.size();
        if (size >= 5) {
            aVar.b = new c(list.get(0).doubleValue(), list.get(1).doubleValue());
            aVar.c = new c(list.get(2).doubleValue(), list.get(3).doubleValue());
            aVar.f9473a = (int) list.get(4).doubleValue();
            aVar.d = new ArrayList<>();
            int i = 7;
            if (size >= 7) {
                ArrayList<c> arrayList = new ArrayList<>();
                c cVar = new c(list.get(5).doubleValue(), list.get(6).doubleValue());
                arrayList.add(cVar);
                while (true) {
                    int i2 = i + 1;
                    if (i2 >= size) {
                        break;
                    }
                    c cVar2 = new c(cVar.a() + list.get(i).doubleValue(), cVar.b() + list.get(i2).doubleValue());
                    arrayList.add(cVar2);
                    i += 2;
                    cVar = cVar2;
                }
                aVar.d.add(arrayList);
            }
        } else if (size >= 2) {
            c cVar3 = new c(list.get(0).doubleValue(), list.get(1).doubleValue());
            ArrayList<c> arrayList2 = new ArrayList<>();
            arrayList2.add(cVar3);
            aVar.b = new c(cVar3);
            aVar.c = new c(cVar3);
            aVar.f9473a = 1;
            ArrayList<ArrayList<c>> arrayList3 = new ArrayList<>();
            aVar.d = arrayList3;
            arrayList3.add(arrayList2);
        }
        return aVar;
    }

    public String toString() {
        return "ComplexPt [eType=" + this.f9473a + ", mLL=" + this.b + ", mRu=" + this.c + ", mGeoPt=" + this.d + "]";
    }

    public ArrayList<c> a() {
        if (this.e == null) {
            this.e = new ArrayList<>();
            ArrayList<ArrayList<c>> arrayList = this.d;
            if (arrayList != null && arrayList.size() > 0 && this.d.get(0).size() > 0) {
                Iterator<ArrayList<c>> it = this.d.iterator();
                while (it.hasNext()) {
                    this.e.addAll(it.next());
                }
            }
        }
        return this.e;
    }
}
