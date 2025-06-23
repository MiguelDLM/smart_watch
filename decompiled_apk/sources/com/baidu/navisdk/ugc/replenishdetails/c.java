package com.baidu.navisdk.ugc.replenishdetails;

import XIXIX.OOXIXo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.model.datastruct.s;
import com.baidu.navisdk.ugc.report.data.datarepository.h;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.y;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.Locale;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    int f8235a;
    int b;
    String c;
    String e;
    private int f;
    public int g;
    String i;
    private int j;
    int k;
    private com.baidu.navisdk.ugc.replenishdetails.a o;
    private int d = 0;
    boolean h = false;
    private Handler l = null;
    public double m = -1.0d;
    public double n = -1.0d;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            s b;
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_Replenish", "handleMessage: " + message.toString());
            }
            if (c.this.f > 0 && message.what == 1003 && message.arg1 == 0 && (b = ((com.baidu.navisdk.model.modelfactory.e) com.baidu.navisdk.model.modelfactory.c.a().a("PoiSearchModel")).b()) != null && !TextUtils.isEmpty(b.g)) {
                c.this.i = b.g;
            }
        }
    }

    private void b(int i) {
        if (g.UGC.b() && i == 7) {
            this.c = "853f2deee30ad8582ab97c18";
            this.f8235a = 4;
        }
    }

    private void e() {
        int i;
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (this.m > OOXIXo.f3760XO && this.n > OOXIXo.f3760XO) {
            f();
            GeoPoint geoPoint = new GeoPoint((int) (this.n * 100000.0d), (int) (this.m * 100000.0d));
            if (com.baidu.navisdk.framework.a.c().a() != null && !y.d(com.baidu.navisdk.framework.a.c().a())) {
                i = 0;
            } else {
                i = 1;
            }
            com.baidu.navisdk.poisearch.c.a(geoPoint, i, 2000, this.l);
            return;
        }
        this.i = null;
    }

    private void f() {
        if (this.l == null) {
            this.l = new a();
        }
    }

    public void c() {
        if (this.h) {
            a(false, false);
        }
        this.h = false;
    }

    public boolean d() {
        if (!TextUtils.isEmpty(this.c) && this.f > 0 && this.d != 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "PasserEventDetailsData{eventType=" + this.f8235a + ", eventIconId=" + this.b + ", encryptedEventId='" + this.c + "', distanceStatus=" + this.d + ", eventName='" + this.e + "', eventId=" + this.f + ", comeFrom=" + this.g + ", isShowVerifyBtn=" + this.h + ", address='" + this.i + "', reportBtnIconId=" + this.j + ", verifyPanelIconId=" + this.k + ", positionHandler=" + this.l + ", latitude=" + this.m + ", longitude=" + this.n + '}';
    }

    public void a(com.baidu.navisdk.ugc.replenishdetails.a aVar) {
        this.o = aVar;
    }

    public boolean a(int i, int i2, int i3) {
        if (!a(i)) {
            a();
            return false;
        }
        this.f = i;
        this.g = i2;
        this.d = i3;
        this.b = com.baidu.navisdk.ugc.report.data.datarepository.c.a(this.f8235a, false);
        this.k = com.baidu.navisdk.ugc.report.data.datarepository.c.a(this.f8235a, true);
        this.j = d.c(this.f8235a);
        this.e = com.baidu.navisdk.ugc.report.data.datarepository.f.e().a(this.f8235a);
        this.i = null;
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Replenish", "addEventDetails: " + this);
        }
        if (TextUtils.isEmpty(this.e)) {
            a();
            return false;
        }
        e();
        a(true, false);
        return true;
    }

    public String b() {
        return String.format(Locale.getDefault(), "当前路段%s", this.e);
    }

    public boolean a(int i, int i2) {
        if (this.f != i || i <= 0 || i2 < this.d) {
            return false;
        }
        if (i2 != 2 && i2 != 3) {
            this.d = i2;
            return true;
        }
        a();
        return true;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str) || !str.equals(this.c)) {
            return false;
        }
        a(false, false);
        return true;
    }

    private boolean a(int i) {
        g gVar = g.UGC;
        if (gVar.b() && i == 7) {
            b(i);
            this.n = 113.85923d;
            this.m = 22.61073d;
        } else {
            Bundle bundle = new Bundle();
            BNRouteGuider.getInstance().getRouteInfoInUniform(12, i, bundle);
            this.c = bundle.getString("usEncodeUgcID");
            int i2 = bundle.getInt("enUgcType");
            this.f8235a = h.b(i2);
            this.n = bundle.getDouble("gcjLongitude", -1.0d);
            this.m = bundle.getDouble("gcjLatitude", -1.0d);
            if (gVar.d()) {
                gVar.e("UgcModule_Replenish", "getUgcDetailsDataFromEngine: eventType " + this.f8235a + " ,encryptedEventId:" + this.c + " ,longitude: " + this.n + " ,latitude:" + this.m + ",busEventType: " + i2);
            }
        }
        return !TextUtils.isEmpty(this.c) && this.f8235a > 0;
    }

    public void a() {
        if (this.h) {
            a(false, false);
        }
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.l = null;
        }
        this.b = 0;
        this.f = 0;
        this.c = null;
        this.e = null;
        this.d = 0;
        this.f8235a = 0;
        this.g = 0;
        this.i = null;
        this.j = 0;
        this.k = 0;
        this.m = -1.0d;
        this.n = -1.0d;
    }

    public void a(boolean z, boolean z2) {
        int i = this.g;
        if (i == 3 || i == 2) {
            if (!z) {
                if (this.h) {
                    com.baidu.navisdk.framework.message.a.a().a(new e(z, this.g, 0, null, 1));
                    if (!z2) {
                        a(false);
                    }
                }
            } else {
                com.baidu.navisdk.framework.message.a.a().a(new e(z, this.g, this.j, "事件验证", 1));
                if (!z2) {
                    a(true);
                }
            }
            this.h = z;
        }
    }

    private void a(boolean z) {
        if (this.g != 2) {
            return;
        }
        boolean b = com.baidu.navisdk.ugc.report.c.a().b(z);
        com.baidu.navisdk.ugc.replenishdetails.a aVar = this.o;
        if (aVar != null) {
            aVar.a(b);
        }
    }
}
