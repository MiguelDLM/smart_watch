package com.baidu.mapsdkplatform.comapi.map;

import android.os.Bundle;
import com.baidu.mapapi.map.WinRound;
import com.baidu.platform.comapi.basestruct.Point;

/* loaded from: classes7.dex */
public class w {
    private static final String t = "w";
    public double m;
    public double n;
    public int o;
    public String p;
    public float q;
    public boolean r;
    public int s;

    /* renamed from: a, reason: collision with root package name */
    public float f6196a = 12.0f;
    public int b = 0;
    public int c = 0;
    public double d = 1.2958162E7d;
    public double e = 4825907.0d;
    public float h = 0.0f;
    public float i = 0.0f;
    public int f = -1;
    public int g = -1;
    public WinRound j = new WinRound();
    public a k = new a();
    public boolean l = false;

    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public long f6197a = 0;
        public long b = 0;
        public long c = 0;
        public long d = 0;
        public Point e = new Point(0, 0);
        public Point f = new Point(0, 0);
        public Point g = new Point(0, 0);
        public Point h = new Point(0, 0);

        public a() {
        }
    }

    public void a(Bundle bundle) {
        int i;
        if (bundle == null) {
            return;
        }
        this.f6196a = (float) bundle.getDouble("level");
        this.b = (int) bundle.getDouble("rotation");
        this.c = (int) bundle.getDouble("overlooking");
        this.d = bundle.getDouble("centerptx");
        this.e = bundle.getDouble("centerpty");
        this.j.left = bundle.getInt("left");
        this.j.right = bundle.getInt("right");
        this.j.top = bundle.getInt("top");
        this.j.bottom = bundle.getInt("bottom");
        this.h = bundle.getFloat("xoffset");
        float f = bundle.getFloat("yoffset");
        this.i = f;
        WinRound winRound = this.j;
        int i2 = winRound.right;
        if (i2 != 0 && (i = winRound.bottom) != 0) {
            int i3 = (i2 - winRound.left) / 2;
            int i4 = (i - winRound.top) / 2;
            this.f = ((int) this.h) + i3;
            this.g = ((int) (-f)) + i4;
        }
        this.k.f6197a = bundle.getLong("gleft");
        this.k.b = bundle.getLong("gright");
        this.k.c = bundle.getLong("gtop");
        this.k.d = bundle.getLong("gbottom");
        a aVar = this.k;
        if (aVar.f6197a <= -20037508) {
            aVar.f6197a = -20037508L;
        }
        if (aVar.b >= 20037508) {
            aVar.b = 20037508L;
        }
        if (aVar.c >= 20037508) {
            aVar.c = 20037508L;
        }
        if (aVar.d <= -20037508) {
            aVar.d = -20037508L;
        }
        Point point = aVar.e;
        long j = aVar.f6197a;
        point.doubleX = j;
        long j2 = aVar.d;
        point.doubleY = j2;
        Point point2 = aVar.f;
        point2.doubleX = j;
        long j3 = aVar.c;
        point2.doubleY = j3;
        Point point3 = aVar.g;
        long j4 = aVar.b;
        point3.doubleX = j4;
        point3.doubleY = j3;
        Point point4 = aVar.h;
        point4.doubleX = j4;
        point4.doubleY = j2;
        this.l = bundle.getInt("bfpp") == 1;
        this.m = bundle.getFloat("adapterZoomUnits");
        this.n = bundle.getDouble("zoomunit");
        this.p = bundle.getString("panoid");
        this.q = bundle.getFloat("siangle");
        this.r = bundle.getInt("isbirdeye") != 0;
        this.s = bundle.getInt("ssext");
    }

    public Bundle a(c cVar) {
        int i;
        int i2;
        WinRound winRound;
        int i3;
        int i4;
        float f = this.f6196a;
        float f2 = cVar.b;
        if (f < f2) {
            this.f6196a = f2;
        }
        float f3 = this.f6196a;
        float f4 = cVar.f6178a;
        if (f3 > f4) {
            if (f3 != 1096.0f && c.d != 26.0f) {
                this.f6196a = f4;
            } else {
                this.f6196a = 26.0f;
                c.d = 26.0f;
            }
        }
        while (true) {
            i = this.b;
            if (i >= 0) {
                break;
            }
            this.b = i + 360;
        }
        this.b = i % 360;
        if (this.c > 0) {
            this.c = 0;
        }
        if (this.c < -45) {
            this.c = -45;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", this.f6196a);
        bundle.putDouble("rotation", this.b);
        bundle.putDouble("overlooking", this.c);
        bundle.putDouble("centerptx", this.d);
        bundle.putDouble("centerpty", this.e);
        bundle.putInt("left", this.j.left);
        bundle.putInt("right", this.j.right);
        bundle.putInt("top", this.j.top);
        bundle.putInt("bottom", this.j.bottom);
        int i5 = this.f;
        if (i5 >= 0 && (i2 = this.g) >= 0 && i5 <= (i3 = (winRound = this.j).right) && i2 <= (i4 = winRound.bottom) && i3 > 0 && i4 > 0) {
            int i6 = (i3 - winRound.left) / 2;
            int i7 = i2 - ((i4 - winRound.top) / 2);
            float f5 = i5 - i6;
            this.h = f5;
            this.i = -i7;
            bundle.putFloat("xoffset", f5);
            bundle.putFloat("yoffset", this.i);
        }
        bundle.putInt("lbx", this.k.e.getIntX());
        bundle.putInt("lby", this.k.e.getIntY());
        bundle.putInt("ltx", this.k.f.getIntX());
        bundle.putInt("lty", this.k.f.getIntY());
        bundle.putInt("rtx", this.k.g.getIntX());
        bundle.putInt("rty", this.k.g.getIntY());
        bundle.putInt("rbx", this.k.h.getIntX());
        bundle.putInt("rby", this.k.h.getIntY());
        bundle.putLong("gleft", this.k.f6197a);
        bundle.putLong("gbottom", this.k.d);
        bundle.putLong("gtop", this.k.c);
        bundle.putLong("gright", this.k.b);
        bundle.putInt("bfpp", this.l ? 1 : 0);
        bundle.putInt("animation", 1);
        bundle.putInt("animatime", this.o);
        bundle.putString("panoid", this.p);
        bundle.putInt("autolink", 0);
        bundle.putFloat("siangle", this.q);
        bundle.putInt("isbirdeye", this.r ? 1 : 0);
        bundle.putInt("ssext", this.s);
        return bundle;
    }
}
