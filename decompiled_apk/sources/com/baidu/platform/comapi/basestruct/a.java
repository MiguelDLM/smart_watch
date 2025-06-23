package com.baidu.platform.comapi.basestruct;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f9538a;
    public Point b;
    public Point c;
    public ArrayList<ArrayList<Point>> d;

    public static a a(List<? extends Number> list) {
        if (list != null && list.size() >= 2) {
            a aVar = new a();
            int size = list.size();
            if (size >= 5) {
                aVar.b = new Point(list.get(0).doubleValue(), list.get(1).doubleValue());
                aVar.c = new Point(list.get(2).doubleValue(), list.get(3).doubleValue());
                aVar.f9538a = (int) list.get(4).doubleValue();
                aVar.d = new ArrayList<>();
                int i = 7;
                if (size >= 7) {
                    ArrayList<Point> arrayList = new ArrayList<>();
                    Point point = new Point(list.get(5).doubleValue(), list.get(6).doubleValue());
                    arrayList.add(point);
                    while (true) {
                        int i2 = i + 1;
                        if (i2 >= size) {
                            break;
                        }
                        Point point2 = new Point(point.getDoubleX() + list.get(i).doubleValue(), point.getDoubleY() + list.get(i2).doubleValue());
                        arrayList.add(point2);
                        i += 2;
                        point = point2;
                    }
                    aVar.d.add(arrayList);
                }
            } else if (size >= 2) {
                Point point3 = new Point(list.get(0).doubleValue(), list.get(1).doubleValue());
                ArrayList<Point> arrayList2 = new ArrayList<>();
                arrayList2.add(point3);
                aVar.b = new Point(point3);
                aVar.c = new Point(point3);
                aVar.f9538a = 1;
                ArrayList<ArrayList<Point>> arrayList3 = new ArrayList<>();
                aVar.d = arrayList3;
                arrayList3.add(arrayList2);
            }
            return aVar;
        }
        return null;
    }

    public String toString() {
        return "ComplexPt [eType=" + this.f9538a + ", mLL=" + this.b + ", mRu=" + this.c + ", mGeoPt=" + this.d + "]";
    }
}
