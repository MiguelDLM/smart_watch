package com.baidu.navisdk.ugc.eventdetails.model;

import android.text.TextUtils;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.ugc.eventdetails.model.c;
import java.util.Locale;

/* loaded from: classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public String f8077a = null;
    private int b = -1;
    private int c = -1;
    private int d = -1;
    private int e = 0;
    private int f = 0;
    public int g = 0;

    public boolean a(int i) {
        return i > 0 && this.g == i;
    }

    public void b(int i) {
        this.e = i;
    }

    public void c(int i) {
        this.d = i;
    }

    public void d(int i) {
        this.f = i;
    }

    public void e(int i) {
        this.b = i;
    }

    public void f(int i) {
        this.g = i;
    }

    public void g(int i) {
        this.c = i;
    }

    public String toString() {
        return "TrafficLightData{lightId='" + this.f8077a + "', roadType=" + this.b + ", waitCount=" + this.c + ", passTime=" + this.d + ", lineDistance=" + this.e + ", prePassDistance=" + this.f + ", trafficLightId=" + this.g + '}';
    }

    private String c() {
        int i = this.b;
        if (i == 1) {
            return "路口畅通";
        }
        if (i == 2) {
            return "路况缓行";
        }
        if (i == 3) {
            return "路口拥堵";
        }
        if (i != 4) {
            return null;
        }
        return "路口极度拥堵";
    }

    public b a() {
        int i;
        int i2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_TrafficLight", "convertToFixedPanelDataModel trafficLightdata: " + toString());
        }
        b bVar = new b();
        bVar.c = 4101;
        bVar.f8067a = R.drawable.ndk_ic_honglvdeng;
        bVar.d = c();
        bVar.e = null;
        bVar.g = false;
        int i3 = this.c;
        if (i3 >= 0 || this.d >= 0 || this.e >= 0 || this.f <= 0) {
            if (i3 != 0 && (((i = this.d) >= 60 || i < 0) && ((i2 = this.e) > f.r0.f7134a || i2 < 0))) {
                if (i3 > 0) {
                    if (i > 0) {
                        bVar.h = String.format(Locale.getDefault(), "前方路口预计还需等待%d次", Integer.valueOf(this.c));
                    } else {
                        bVar.h = String.format(Locale.getDefault(), "前方路口预计还需停车等待%d次通过", Integer.valueOf(this.c));
                    }
                }
                if (this.d > 0) {
                    if (TextUtils.isEmpty(bVar.h)) {
                        bVar.h = String.format(Locale.getDefault(), "前方路口预计还需等待%d分钟通过", Integer.valueOf(Math.round(this.d / 60.0f)));
                    } else {
                        bVar.i = String.format(Locale.getDefault(), "%d分钟通过", Integer.valueOf(Math.round(this.d / 60.0f)));
                    }
                }
            } else {
                bVar.h = "即将通过当前路口，请注意安全驾驶";
                bVar.i = null;
            }
            String format = this.e > 0 ? String.format(Locale.getDefault(), "前方队伍长度约%d米", Integer.valueOf(this.e)) : null;
            String format2 = this.f > 0 ? String.format(Locale.getDefault(), "红绿灯一次放行约%d米", Integer.valueOf(this.f)) : null;
            if (!TextUtils.isEmpty(format) && !TextUtils.isEmpty(format2)) {
                bVar.j = String.format(Locale.getDefault(), "%s，%s", format, format2);
            } else if (!TextUtils.isEmpty(format)) {
                bVar.j = format;
            } else {
                bVar.j = format2;
            }
        } else {
            bVar.h = String.format(Locale.getDefault(), "前方红绿灯一次放行约%d米", Integer.valueOf(this.f));
        }
        c.d dVar = new c.d();
        bVar.l = dVar;
        dVar.b = 0;
        if (TextUtils.isEmpty(f.r0.b)) {
            bVar.l.f8071a = "上述信息仅供参考，请以实际道路情况为准，安全驾驶。";
        } else {
            bVar.l.f8071a = f.r0.b;
        }
        if (gVar.d()) {
            gVar.e("UgcModule_TrafficLight", "convertToFixedPanelDataModel BNFixedPanelDataModel: " + bVar.toString());
        }
        return bVar;
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.f8077a) && (this.c > -1 || this.d >= 0 || this.f > 0);
    }
}
