package com.baidu.navisdk.ugc.report.data.datarepository;

import com.garmin.fit.OxXXx0X;
import com.huawei.hms.ads.gb;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> f8257a;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> b;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> c;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> d;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> e;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> f;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> g;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> h;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> i;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> j;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> k;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> l;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> m;

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final h f8258a = new h();
    }

    public static int b(int i) {
        if (i == 106) {
            return 9;
        }
        if (i == 107) {
            return 10;
        }
        if (i == 110) {
            return 6;
        }
        if (i == 401) {
            return 55;
        }
        switch (i) {
            case 101:
                return 4;
            case 102:
                return 5;
            case 103:
                return 8;
            case 104:
                return 7;
            default:
                switch (i) {
                    case 403:
                        return 54;
                    case 404:
                        return 53;
                    case 405:
                        return 51;
                    default:
                        return 0;
                }
        }
    }

    public static h o() {
        return b.f8258a;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> a(int i, int i2) {
        if (i == 6) {
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>(3);
            arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("左侧车道", 32, null));
            arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("中间车道", 31, null));
            arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("右侧车道", 30, null));
            if (i2 != 2) {
                return arrayList;
            }
            arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("应急车道", 72, null));
            return arrayList;
        }
        if (i != 51 && i != 54 && i != 53 && i != 401) {
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList2 = new ArrayList<>(4);
            arrayList2.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("左侧车道", 32, null));
            arrayList2.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("中间车道", 31, null));
            arrayList2.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("右侧车道", 30, null));
            arrayList2.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("应急车道", 72, null));
            return arrayList2;
        }
        ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList3 = new ArrayList<>(4);
        arrayList3.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("左侧车道", 32, null));
        arrayList3.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("中间车道", 31, null));
        arrayList3.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("右侧车道", 30, null));
        arrayList3.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("对向车道", 27, null));
        return arrayList3;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> c() {
        if (this.i == null) {
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>(4);
            this.i = arrayList;
            arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("追尾", 44, null));
            this.i.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("剐蹭", 45, null));
            this.i.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("故障", 46, null));
            this.i.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("严重事故", 47, null));
        }
        return this.i;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> d() {
        if (this.j == null) {
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>(2);
            this.j = arrayList;
            arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("可以通行", 48, null));
            this.j.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("不能通行", 49, null));
        }
        return this.j;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> e() {
        if (this.k == null) {
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>(3);
            this.k = arrayList;
            arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("临时封路", 56, null));
            this.k.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("长期封路", 57, null));
            this.k.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("分时段封路", 58, null));
        }
        return this.k;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> f() {
        if (this.l == null) {
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>(3);
            this.l = arrayList;
            arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("积水", 53, null));
            this.l.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("路上有坑", 54, null));
            this.l.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("障碍物", 55, null));
        }
        return this.l;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> g() {
        if (this.m == null) {
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>(3);
            this.m = arrayList;
            arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("临时管制", 59, null));
            this.m.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("处理事故", 60, null));
            this.m.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("指挥交通", 61, null));
        }
        return this.m;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> h() {
        if (this.d == null) {
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>();
            this.d = arrayList;
            arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("缺失", 37, null));
            this.d.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("多报", 38, null));
            this.d.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("错误", 39, null));
        }
        return this.d;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> i() {
        ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>(3);
        arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("补胎维修", 3109, null));
        arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("补胎", 3107, null));
        arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("维修", 3108, null));
        return arrayList;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> j() {
        if (this.b == null) {
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>();
            this.b = arrayList;
            arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("封路", 131, null));
            this.b.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("单向通行", 132, null));
            this.b.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("路不存在", 134, null));
            this.b.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("路障", 135, null));
        }
        return this.b;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> k() {
        if (this.c == null) {
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>();
            this.c = arrayList;
            arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("坡度反了", 461, null));
            this.c.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("无坡度", 462, null));
        }
        return this.c;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> l() {
        if (this.e == null) {
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>();
            this.e = arrayList;
            arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("60", 60, null));
            this.e.add(new com.baidu.navisdk.ugc.report.data.datarepository.b(gb.Code, 70, null));
            this.e.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("80", 80, null));
            this.e.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("100", 100, null));
        }
        return this.e;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> m() {
        if (this.f8257a == null) {
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>();
            this.f8257a = arrayList;
            arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("有禁左", 21, null));
            this.f8257a.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("有禁右", 23, null));
            this.f8257a.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("有禁掉", 22, null));
        }
        return this.f8257a;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> n() {
        if (this.g == null) {
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>();
            this.g = arrayList;
            arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("播报延迟错过路口", 121, null));
            this.g.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("播报内容错误", 122, null));
        }
        return this.g;
    }

    private h() {
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> b() {
        if (this.h == null) {
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>(3);
            this.h = arrayList;
            arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("缓慢行驶", 42, null));
            this.h.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("轻微拥堵", 41, null));
            this.h.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("堵住不动", 43, null));
        }
        return this.h;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> a(int i) {
        if (i == 1) {
            return null;
        }
        if (this.f == null) {
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>(2);
            this.f = arrayList;
            arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("同向车道", 28, null));
            this.f.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("对向车道", 27, null));
        }
        return this.f;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> a() {
        ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>(3);
        arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("加水加气", OxXXx0X.f13081X00IxOx, null));
        arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("加水", OxXXx0X.f13062Oox, null));
        arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b("加气", OxXXx0X.f13023OI0IXox, null));
        return arrayList;
    }
}
