package com.baidu.location.b;

import android.location.Location;
import android.os.Bundle;
import com.baidu.location.e.a.b;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class m {
    private static String b = "NULL";

    /* renamed from: a, reason: collision with root package name */
    private boolean f5649a = false;
    private long c = -1;
    private int d = -1;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final m f5650a = new m();
    }

    private String b(Location location) {
        StringBuilder sb = new StringBuilder();
        sb.append(location.getAccuracy());
        sb.append("|");
        sb.append(com.baidu.location.c.e.f5696a);
        sb.append("|");
        Bundle extras = location.getExtras();
        if (extras == null || !extras.containsKey("meanCn0")) {
            sb.append(-1);
        } else {
            sb.append(extras.get("meanCn0"));
        }
        sb.append("|");
        if (extras == null || !extras.containsKey("SourceType")) {
            sb.append(-1);
        } else {
            sb.append(extras.get("SourceType"));
        }
        sb.append("|");
        sb.append(b);
        return sb.toString();
    }

    private void d() {
        String a2 = com.baidu.location.e.a.b.a().a(b.EnumC0131b.GPS_CHECKER_STATUS);
        if (a2 != null && g.a(a2, e.b().bV) == 0) {
            this.f5649a = true;
        }
    }

    public int a(Location location) {
        if (location == null) {
            return -1;
        }
        this.c = System.currentTimeMillis() / 1000;
        if (!b()) {
            d();
        }
        int a2 = b() ? a(b(location)) : -1;
        this.d = a2;
        return a2;
    }

    public void c() {
        g.b();
        this.f5649a = false;
        b = "";
        this.c = -1L;
        this.d = -1;
    }

    private int a(String str) {
        return g.a(str);
    }

    public boolean b() {
        return this.f5649a;
    }

    public static m a() {
        return a.f5650a;
    }

    public void a(ArrayList<ArrayList<Float>> arrayList) {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        if (arrayList.size() == 0) {
            sb = org.apache.log4j.helpers.X0o0xo.f33252II0XooXoX;
        } else {
            Iterator<ArrayList<Float>> it = arrayList.iterator();
            boolean z = true;
            while (it.hasNext()) {
                ArrayList<Float> next = it.next();
                if (next.size() == 6) {
                    if (z) {
                        z = false;
                    } else {
                        sb2.append(com.huawei.openalliance.ad.constant.x.aL);
                    }
                    sb2.append(String.format("%.1f,", next.get(2)));
                    sb2.append(String.format("%.0f", next.get(3)));
                }
            }
            sb = sb2.toString();
        }
        b = sb;
    }
}
