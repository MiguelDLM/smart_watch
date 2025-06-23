package com.baidu.navisdk.ugc.report.data.datarepository;

import com.garmin.fit.OxXXx0X;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private h f8253a;
    private HashMap<Integer, String> b;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> c;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> d;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> e;

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final f f8254a = new f();
    }

    public static f e() {
        return b.f8254a;
    }

    private void f() {
        if (this.b == null) {
            HashMap<Integer, String> hashMap = new HashMap<>(32, 1.0f);
            this.b = hashMap;
            hashMap.put(13, "道路不通");
            this.b.put(40, "道路不存在");
            this.b.put(2, "禁止转向");
            this.b.put(3, "电子眼");
            this.b.put(4, "拥堵");
            this.b.put(5, "事故");
            this.b.put(6, "施工");
            this.b.put(7, "封路");
            this.b.put(8, "管制");
            this.b.put(9, "警察");
            this.b.put(10, "危险");
            this.b.put(15, "限速");
            this.b.put(47, "导向箭头");
            this.b.put(12, "播报错误");
            this.b.put(48, "路口放大图");
            this.b.put(45, "其他");
            this.b.put(51, "积水");
            this.b.put(53, "积雪");
            this.b.put(54, "结冰");
            this.b.put(55, "团雾");
            this.b.put(3104, "偷油高发");
            this.b.put(3105, "违章高发");
            this.b.put(3106, "打折加油");
            this.b.put(3108, "补胎维修");
            this.b.put(Integer.valueOf(OxXXx0X.f13062Oox), "加水加气");
            this.b.put(Integer.valueOf(OxXXx0X.f13184oXIoIo), "办通行证");
            this.b.put(3114, "餐饮美食");
            this.b.put(3115, "休闲娱乐");
        }
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> a() {
        if (this.c == null) {
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>(6);
            this.c = arrayList;
            arrayList.add(b(5, 1));
            this.c.add(b(4, 1));
            this.c.add(b(10, 1));
            this.c.add(b(6, 1));
            this.c.add(b(7, 1));
            this.c.add(b(51, 1));
        }
        return this.c;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> b() {
        if (this.e == null) {
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>(8);
            this.e = arrayList;
            arrayList.add(b(13, 6));
            this.e.add(b(2, 6));
            this.e.add(b(15, 6));
            this.e.add(b(47, 6));
            this.e.add(b(12, 6));
            this.e.add(b(48, 6));
            this.e.add(b(45, 6));
        }
        return this.e;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> c() {
        if (this.d == null) {
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>(6);
            this.d = arrayList;
            arrayList.add(b(5, 2));
            this.d.add(b(4, 2));
            this.d.add(b(10, 2));
            this.d.add(b(6, 2));
            this.d.add(b(7, 2));
            this.d.add(b(51, 2));
        }
        return this.d;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> d() {
        ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>(8);
        arrayList.add(b(3104, 2));
        arrayList.add(b(3105, 2));
        arrayList.add(b(3108, 2));
        arrayList.add(b(OxXXx0X.f13184oXIoIo, 2));
        arrayList.add(b(OxXXx0X.f13062Oox, 2));
        arrayList.add(b(3106, 2));
        arrayList.add(b(3114, 2));
        arrayList.add(b(3115, 2));
        return arrayList;
    }

    private f() {
        this.f8253a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f8253a = h.o();
        f();
    }

    public void a(com.baidu.navisdk.ugc.report.data.datarepository.b bVar, int i) {
        if (bVar == null) {
            return;
        }
        bVar.i = a(bVar.b, i);
        bVar.j = b(bVar.b);
        bVar.h = c(bVar.b);
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> c(int i) {
        if (i == 2) {
            return this.f8253a.m();
        }
        if (i == 3) {
            return this.f8253a.h();
        }
        if (i == 12) {
            return this.f8253a.n();
        }
        if (i == 13) {
            return this.f8253a.j();
        }
        if (i == 15) {
            return this.f8253a.l();
        }
        if (i != 46) {
            return null;
        }
        return this.f8253a.k();
    }

    public boolean d(int i) {
        HashMap<Integer, String> hashMap = this.b;
        return hashMap != null && hashMap.containsKey(Integer.valueOf(i));
    }

    private com.baidu.navisdk.ugc.report.data.datarepository.b b(int i, int i2) {
        f();
        if (!this.b.containsKey(Integer.valueOf(i))) {
            return null;
        }
        com.baidu.navisdk.ugc.report.data.datarepository.b bVar = new com.baidu.navisdk.ugc.report.data.datarepository.b(this.b.get(Integer.valueOf(i)), i, null);
        a(bVar, i2);
        return bVar;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> a(int i, int i2) {
        if (i == 9) {
            return this.f8253a.a(i2);
        }
        if (i == 10) {
            return this.f8253a.a(i, i2);
        }
        if (i != 51) {
            if (i == 4) {
                return this.f8253a.a(i2);
            }
            if (i == 5) {
                return this.f8253a.a(i, i2);
            }
            if (i == 6) {
                return this.f8253a.a(i, i2);
            }
            if (i == 7) {
                return this.f8253a.a(i2);
            }
            switch (i) {
                case 53:
                case 54:
                case 55:
                    break;
                default:
                    return null;
            }
        }
        if (i2 == 2) {
            return this.f8253a.a(i, i2);
        }
        return null;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> b(int i) {
        if (i == 4) {
            return this.f8253a.b();
        }
        if (i == 5) {
            return this.f8253a.c();
        }
        if (i == 6) {
            return this.f8253a.d();
        }
        if (i == 7) {
            return this.f8253a.e();
        }
        if (i == 9) {
            return this.f8253a.g();
        }
        if (i != 10) {
            if (i != 51) {
                if (i == 3108) {
                    return this.f8253a.i();
                }
                if (i == 3110) {
                    return this.f8253a.a();
                }
                switch (i) {
                    case 53:
                    case 54:
                    case 55:
                        break;
                    default:
                        return null;
                }
            }
            return this.f8253a.d();
        }
        return this.f8253a.f();
    }

    public String a(int i) {
        f();
        return this.b.get(Integer.valueOf(i));
    }
}
