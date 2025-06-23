package com.baidu.navisdk.ugc.replenishdetails;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.g;
import java.util.Locale;

/* loaded from: classes8.dex */
public class f {
    private long b;
    public String c;
    int d;
    String e;
    int f;
    private Handler i;
    private int j;
    private com.baidu.navisdk.ugc.replenishdetails.a k;
    public int g = 0;
    boolean h = false;

    /* renamed from: a, reason: collision with root package name */
    com.baidu.navisdk.ugc.report.data.datastatus.a f8240a = new com.baidu.navisdk.ugc.report.data.datastatus.a();

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                f.this.a(false, false);
            }
        }
    }

    private boolean b(int i) {
        return i == 31 || i == 32 || i == 33 || i == 34;
    }

    private String d() {
        int currentTimeMillis = (int) ((System.currentTimeMillis() - this.b) / 60000);
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Replenish", "getTime time: " + currentTimeMillis + "分钟");
        }
        if (currentTimeMillis <= 0) {
            return "1分钟";
        }
        if (currentTimeMillis < 60) {
            return currentTimeMillis + "分钟";
        }
        int i = currentTimeMillis / 60;
        int i2 = currentTimeMillis - (i * 60);
        String str = i + "小时";
        if (i2 > 0) {
            return str + i2 + "分钟";
        }
        return str;
    }

    private void e() {
        if (this.i == null) {
            this.i = new a();
        }
    }

    public void a(com.baidu.navisdk.ugc.replenishdetails.a aVar) {
        this.k = aVar;
    }

    public void c() {
        if (this.f == 2) {
            Handler handler = this.i;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.i = null;
            }
            a(false, false);
            this.h = false;
            this.k = null;
        }
    }

    public String toString() {
        return "UgcReportDetailsData{ugcReportInfo=" + this.f8240a + ", reportTime=" + this.b + ", eventId='" + this.c + "', eventIconId=" + this.d + ", eventName='" + this.e + "', reportFrom=" + this.f + ", businessTrigger=" + this.g + ", isShowReplenishDetailsButton=" + this.h + ", reportBtnIconId=" + this.j + '}';
    }

    public boolean a(String str, com.baidu.navisdk.ugc.report.data.datastatus.a aVar, int i) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            return false;
        }
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Replenish", "addOrUpdateData eventId:" + str + ", current eventId: " + this.c + aVar.toString());
        }
        if (str.equals(this.c)) {
            this.f8240a.b(aVar);
            this.f = i;
        } else {
            if (b(aVar.d)) {
                a(false);
                return false;
            }
            this.f8240a.a();
            this.f8240a.b(aVar);
            String a2 = com.baidu.navisdk.ugc.report.data.datarepository.f.e().a(this.f8240a.e);
            this.e = a2;
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            this.b = System.currentTimeMillis();
            this.c = str;
            this.d = com.baidu.navisdk.ugc.report.data.datarepository.c.a(this.f8240a.e, false);
            this.j = d.c(this.f8240a.e);
            this.f = i;
            this.g = this.f8240a.d;
            if (gVar.d()) {
                gVar.e("UgcModule_Replenish", "addOrUpdateData: " + toString());
            }
            if (a(i, aVar)) {
                e();
                this.h = true;
                this.i.removeMessages(1);
                this.i.sendEmptyMessageDelayed(1, 600000L);
                a(true, false);
            }
        }
        return true;
    }

    public boolean b() {
        return (TextUtils.isEmpty(this.c) || this.f8240a == null) ? false : true;
    }

    private void b(boolean z) {
        if (this.f != 2) {
            return;
        }
        boolean c = com.baidu.navisdk.ugc.report.c.a().c(z);
        com.baidu.navisdk.ugc.replenishdetails.a aVar = this.k;
        if (aVar != null) {
            aVar.a(c);
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.e)) {
            return null;
        }
        return String.format(Locale.getDefault(), "最近上报%s事件，%s前", this.e, d());
    }

    public void a(boolean z) {
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = this.f8240a;
        if (aVar != null) {
            aVar.b();
            this.f8240a.a();
        }
        a(false, false, z);
        Handler handler = this.i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.i = null;
        }
        this.h = false;
        this.b = 0L;
        this.c = null;
        this.d = 0;
        this.e = null;
        this.f = 0;
        this.g = 0;
    }

    public void a(boolean z, boolean z2) {
        a(z, z2, false);
    }

    public void a(boolean z, boolean z2, boolean z3) {
        int i = this.f;
        if (i == 2 || i == 3 || i == 8) {
            if (!z) {
                if (this.h) {
                    g gVar = g.UGC;
                    if (gVar.d()) {
                        gVar.e("UgcModule_Replenish", "sendChangeUploadButtonStatus: ");
                    }
                    if (!z3) {
                        com.baidu.navisdk.framework.message.a.a().a(new e(z, this.f, 0, null, 2));
                    }
                    if (!z2) {
                        b(false);
                    }
                }
            } else {
                com.baidu.navisdk.framework.message.a.a().a(new e(z, this.f, this.j, "补充详情", 2));
                if (!z2) {
                    b(true);
                }
            }
            this.h = z;
        }
    }

    private boolean a(int i, com.baidu.navisdk.ugc.report.data.datastatus.a aVar) {
        if ((i != 2 && i != 8 && i != 3) || aVar == null) {
            return false;
        }
        int i2 = aVar.d;
        if ((i2 == 1 || i2 == 30) && aVar.G <= 0 && aVar.E <= 0 && TextUtils.isEmpty(aVar.i) && TextUtils.isEmpty(aVar.n) && TextUtils.isEmpty(aVar.d()) && !aVar.e()) {
            return aVar.d != 1 || TextUtils.isEmpty(aVar.h);
        }
        return false;
    }

    public void a(int i) {
        if (this.h) {
            Handler handler = this.i;
            if (handler != null) {
                handler.removeMessages(1);
            }
            a(false, false);
            this.h = false;
        }
    }
}
