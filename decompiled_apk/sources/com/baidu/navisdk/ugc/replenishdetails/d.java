package com.baidu.navisdk.ugc.replenishdetails;

import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.util.common.g;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private f f8237a;
    private c b;
    private volatile String c;
    private com.baidu.navisdk.ugc.replenishdetails.a d;

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final d f8238a = new d();
    }

    public static d o() {
        return b.f8238a;
    }

    public void a(com.baidu.navisdk.ugc.replenishdetails.a aVar) {
        this.d = aVar;
    }

    public void b(Message message) {
        a(message, 2);
    }

    public boolean c(String str) {
        if (this.f8237a == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(this.f8237a.c);
    }

    public int d() {
        if (l()) {
            return this.b.f8235a;
        }
        if (m()) {
            return this.f8237a.f8240a.e;
        }
        return 0;
    }

    public String e() {
        if (l()) {
            return this.b.b();
        }
        if (m()) {
            return this.f8237a.a();
        }
        return null;
    }

    public int f() {
        if (l()) {
            return this.b.b;
        }
        if (m()) {
            return this.f8237a.d;
        }
        return 0;
    }

    @Nullable
    public String g() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar.i;
        }
        return null;
    }

    public com.baidu.navisdk.ugc.report.data.datastatus.a h() {
        if (m()) {
            return this.f8237a.f8240a;
        }
        return null;
    }

    @Nullable
    public String i() {
        if (l()) {
            return this.b.e;
        }
        return null;
    }

    public int j() {
        if (l()) {
            return this.b.k;
        }
        return 0;
    }

    public void k() {
        f fVar;
        boolean z;
        c cVar;
        boolean z2;
        if (l() && (z2 = (cVar = this.b).h) && cVar.g == 2) {
            cVar.a(z2, true);
        } else if (m() && (z = (fVar = this.f8237a).h) && fVar.f == 2) {
            fVar.a(z, true);
        }
    }

    public boolean l() {
        c cVar = this.b;
        if (cVar != null && cVar.d()) {
            return true;
        }
        return false;
    }

    public boolean m() {
        f fVar = this.f8237a;
        if (fVar != null && fVar.b()) {
            return true;
        }
        return false;
    }

    public void n() {
        a();
        f fVar = this.f8237a;
        if (fVar != null) {
            fVar.c();
        }
        this.d = null;
    }

    private d() {
    }

    public void a(JSONObject jSONObject, com.baidu.navisdk.ugc.report.data.datastatus.a aVar, int i) {
        int i2;
        c cVar;
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Replenish", "addOrUpdateReportDetailsData jsonObject: " + jSONObject + ", reportFrom: " + i);
        }
        if (jSONObject == null || aVar == null || i == 6 || i == 5 || com.baidu.navisdk.module.ugc.a.b(aVar.e) || (i2 = aVar.e) <= 0 || i2 == 7) {
            return;
        }
        int i3 = aVar.d;
        if (i3 == 1 || i3 == 8 || i3 == 9 || i3 == 30 || i3 == 31 || i3 == 32 || i3 == 33 || i3 == 34 || i3 == 20 || i3 == 40) {
            long optLong = jSONObject.optLong("event_id", 0L);
            if (gVar.d()) {
                gVar.e("UgcModule_Replenish", "addOrUpdateReportDetailsData eventId: " + optLong + ", " + aVar.toString());
            }
            if (optLong <= 0) {
                return;
            }
            if (this.f8237a == null) {
                this.f8237a = new f();
            }
            this.f8237a.a(this.d);
            if (!this.f8237a.a(JNITrajectoryControl.sInstance.eventIdEncode(optLong), aVar, i) || (cVar = this.b) == null) {
                return;
            }
            cVar.a();
            this.b = null;
        }
    }

    public void b(String str) {
        f fVar = this.f8237a;
        if (fVar == null || str == null || !str.equals(fVar.c)) {
            return;
        }
        this.f8237a.a(false);
        this.f8237a = null;
    }

    public String c() {
        if (l()) {
            return this.b.c;
        }
        if (m()) {
            return this.f8237a.c;
        }
        return null;
    }

    public String b() {
        return this.c;
    }

    public void d(String str) {
        this.c = str;
    }

    public boolean b(int i) {
        if (!m()) {
            return false;
        }
        f fVar = this.f8237a;
        if (fVar.f != i) {
            return false;
        }
        boolean z = fVar.h;
        if (z) {
            fVar.a(i);
            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.2", i + "", "1", null);
        }
        return z;
    }

    public static int c(int i) {
        if (i == 10) {
            return R.drawable.nsdk_ugc_report_btn_icon_weixian;
        }
        if (i == 51) {
            return R.drawable.nsdk_ugc_report_btn_icon_jishui;
        }
        if (i == 4) {
            return R.drawable.nsdk_ugc_report_btn_icon_yongdu;
        }
        if (i == 5) {
            return R.drawable.nsdk_ugc_report_btn_icon_shigu;
        }
        if (i == 6) {
            return R.drawable.nsdk_ugc_report_btn_icon_shigong;
        }
        if (i != 7) {
            switch (i) {
                case 53:
                case 54:
                    return R.drawable.nsdk_ugc_report_btn_icon_jixue;
                case 55:
                    return R.drawable.nsdk_ugc_report_btn_icon_wu;
                default:
                    return 0;
            }
        }
        return R.drawable.nsdk_ugc_report_btn_icon_fenglu;
    }

    public void a(Message message) {
        a(message, 3);
    }

    private void a(Message message, int i) {
        if (message == null) {
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_Replenish", "handlerEventPasserMessage message is null, comeFrom:" + i);
                return;
            }
            return;
        }
        int i2 = message.arg2;
        int i3 = message.arg1;
        g gVar2 = g.UGC;
        if (gVar2.d()) {
            gVar2.e("UgcModule_Replenish", "handlerEventPasserMessage eventId: " + i2 + ", ugcDistanceStatus:" + i3 + ",message: " + message.toString() + ", comeFrom: " + i);
        }
        if (i2 <= 0 || i3 == 0 || i3 == 4) {
            return;
        }
        if (i3 != 1) {
            c cVar = this.b;
            if (cVar == null || !cVar.a(i2, i3)) {
                return;
            }
            this.b = null;
            return;
        }
        if (this.b == null) {
            this.b = new c();
        }
        this.b.a(this.d);
        if (this.b.a(i2, i, i3)) {
            f fVar = this.f8237a;
            if (fVar != null) {
                fVar.a(true);
                this.f8237a = null;
                return;
            }
            return;
        }
        this.b = null;
    }

    public void a(String str) {
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void a() {
        c cVar = this.b;
        if (cVar != null) {
            cVar.a();
            this.b = null;
        }
    }

    public boolean a(int i) {
        if (!l()) {
            return false;
        }
        c cVar = this.b;
        if (cVar.g != i) {
            return false;
        }
        boolean z = cVar.h;
        if (z) {
            cVar.c();
            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.4", i + "", "1", null);
        }
        return z;
    }
}
