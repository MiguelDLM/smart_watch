package com.baidu.navisdk.navimap;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.jni.nativeif.JNINaviMap;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.s;
import com.baidu.nplatform.comapi.basestruct.b;
import java.io.File;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final JNINaviMap f7621a = new JNINaviMap();

    private a() {
    }

    public static a a(String str, long j) {
        if (j == 0) {
            com.baidu.navisdk.skyeye.a.n().a(g.MAP, "createDefaultMap baseMapAddr == 0, tag:" + str);
        }
        a aVar = new a();
        aVar.b(str, j);
        return aVar;
    }

    private void b(String str, long j) {
        this.f7621a.create(str, j);
    }

    public boolean c(boolean z) {
        return this.f7621a.setNightMode(z);
    }

    public void b(int i) {
        this.f7621a.setNaviMode(i);
    }

    public b b() {
        return a(true);
    }

    public void a() {
        this.f7621a.destroy();
    }

    public boolean b(boolean z) {
        return this.f7621a.setBrowse(z);
    }

    public void a(Rect rect) {
        if (rect == null) {
            return;
        }
        this.f7621a.setShowRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    public boolean b(Bundle bundle) {
        return this.f7621a.setNormalHdDataToMap(bundle);
    }

    public b a(boolean z) {
        Bundle mapStatus = this.f7621a.getMapStatus(z);
        g gVar = g.MAP;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("getMapStatus() --> bundle = ");
            sb.append(mapStatus == null ? "null" : mapStatus.toString());
            gVar.e(sb.toString());
        }
        if (mapStatus == null) {
            return null;
        }
        b bVar = new b();
        bVar.f9474a = (float) mapStatus.getDouble("level");
        bVar.b = (float) mapStatus.getDouble("rotation");
        bVar.c = (int) mapStatus.getDouble("overlooking");
        bVar.d = (int) mapStatus.getDouble("centerptx");
        bVar.e = (int) mapStatus.getDouble("centerpty");
        bVar.g.f9476a = mapStatus.getInt("left");
        bVar.g.b = mapStatus.getInt("right");
        bVar.g.c = mapStatus.getInt("top");
        bVar.g.d = mapStatus.getInt("bottom");
        bVar.h.f9475a = mapStatus.getLong("gleft");
        bVar.h.b = mapStatus.getLong("gright");
        bVar.h.c = mapStatus.getLong("gtop");
        bVar.h.d = mapStatus.getLong("gbottom");
        bVar.h.e.a(mapStatus.getInt("lbx"));
        bVar.h.e.b(mapStatus.getInt("lby"));
        bVar.h.f.a(mapStatus.getInt("ltx"));
        bVar.h.f.b(mapStatus.getInt("lty"));
        bVar.h.g.a(mapStatus.getInt("rtx"));
        bVar.h.g.b(mapStatus.getInt("rty"));
        bVar.h.h.a(mapStatus.getInt("rbx"));
        bVar.h.h.b(mapStatus.getInt("rby"));
        bVar.i = mapStatus.getFloat("xoffset");
        bVar.j = mapStatus.getFloat("yoffset");
        bVar.k = mapStatus.getInt("bfpp") == 1;
        b.a aVar = bVar.h;
        if (aVar.f9475a <= -20037508) {
            aVar.f9475a = -20037508L;
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
        return bVar;
    }

    public void a(b bVar, int i, int i2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putDouble("level", bVar.f9474a);
        bundle.putDouble("rotation", bVar.b);
        bundle.putDouble("overlooking", bVar.c);
        bundle.putDouble("centerptx", bVar.d);
        bundle.putDouble("centerpty", bVar.e);
        bundle.putInt("left", bVar.g.f9476a);
        bundle.putInt("right", bVar.g.b);
        bundle.putInt("top", bVar.g.c);
        bundle.putInt("bottom", bVar.g.d);
        bundle.putInt("lbx", bVar.h.e.c());
        bundle.putInt("lby", bVar.h.e.d());
        bundle.putInt("ltx", bVar.h.f.c());
        bundle.putInt("lty", bVar.h.f.d());
        bundle.putInt("rtx", bVar.h.g.c());
        bundle.putInt("rty", bVar.h.g.d());
        bundle.putInt("rbx", bVar.h.h.c());
        bundle.putInt("rby", bVar.h.h.d());
        bundle.putFloat("yoffset", (float) bVar.j);
        bundle.putFloat("xoffset", (float) bVar.i);
        if (i <= 0) {
            bundle.putInt("animation", 0);
            bundle.putInt("animatime", 0);
        } else {
            bundle.putInt("animation", i2);
            bundle.putInt("animatime", i);
        }
        bundle.putInt("bfpp", bVar.k ? 1 : 0);
        bundle.putBoolean("useScreenOffset", z);
        g gVar = g.MAP;
        if (gVar.d()) {
            gVar.e("setMapStatus = " + bundle);
        }
        this.f7621a.setMapStatus(bundle);
    }

    public boolean a(Bundle bundle) {
        return this.f7621a.setHdDataToMap(bundle);
    }

    public void a(int i) {
        this.f7621a.setLimitFrame(i);
    }

    public boolean a(int i, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str3 = File.separator;
        if (!str.endsWith(str3)) {
            str = str + str3;
        }
        if (str2 != null) {
            if (!s.d(str + str2)) {
                g gVar = g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("setDIYDataToMap: " + str2 + "," + str);
                }
                return false;
            }
        }
        return this.f7621a.setDIYDataToMap(i, str, str2);
    }
}
