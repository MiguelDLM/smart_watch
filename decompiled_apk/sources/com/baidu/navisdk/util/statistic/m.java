package com.baidu.navisdk.util.statistic;

import android.content.Context;
import android.os.Bundle;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.jni.nativeif.JNIStatisticsControl;
import com.baidu.navisdk.ui.widget.BNWebViewClient;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.e0;
import com.baidu.navisdk.util.common.x;
import java.text.DecimalFormat;

/* loaded from: classes8.dex */
public class m implements a.InterfaceC0201a {
    private static final String c = "com.baidu.navisdk.util.statistic.m";
    private static m d;

    /* renamed from: a, reason: collision with root package name */
    private StringBuffer f9378a;
    private String b;

    private m() {
        this.f9378a = null;
        this.f9378a = new StringBuffer();
        com.baidu.navisdk.framework.message.a.a().a(this, com.baidu.navisdk.framework.message.bean.n.class, new Class[0]);
    }

    public static m d() {
        if (d == null) {
            d = new m();
        }
        return d;
    }

    public String a() {
        Bundle bundle = new Bundle();
        JNIStatisticsControl.sInstance.getAllNetWorkDataSize(bundle);
        return a(bundle);
    }

    public void c() {
        d = null;
        this.f9378a = null;
    }

    @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
    public void onEvent(Object obj) {
        if (obj instanceof com.baidu.navisdk.framework.message.bean.n) {
            com.baidu.navisdk.framework.message.bean.n nVar = (com.baidu.navisdk.framework.message.bean.n) obj;
            a aVar = new a();
            aVar.a(nVar.b, nVar.c, nVar.e);
            aVar.a(nVar.d);
            aVar.a();
        }
    }

    public void b(Context context) {
        if (context == null && (context = com.baidu.navisdk.framework.a.c().a()) == null) {
            return;
        }
        boolean a2 = e0.a(context).a("navi.end.flag.key", false);
        if (x.t()) {
            ProNaviStatItem.O().d(a2 ? 1 : 0);
        }
        e0.a(context).b("navi.end.flag.key", true);
    }

    /* loaded from: classes8.dex */
    public static class a {
        private static DecimalFormat e;

        /* renamed from: a, reason: collision with root package name */
        private long f9379a = 0;
        private float b = 0.0f;
        private float c = 0.0f;
        private String d = null;

        public a() {
            if (e == null) {
                e = new DecimalFormat(".0");
            }
        }

        public void a(long j, long j2, String str) {
            this.d = m.c(str);
            this.f9379a = j;
            this.b = ((float) (j2 >> 9)) / 2.0f;
        }

        public String toString() {
            if (e == null) {
                e = new DecimalFormat(".0");
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("c;");
            stringBuffer.append(this.f9379a + com.huawei.openalliance.ad.constant.x.aL);
            stringBuffer.append(e.format((double) (this.b + this.c)) + com.huawei.openalliance.ad.constant.x.aL);
            if (this.d == null) {
                this.d = "";
            }
            stringBuffer.append(this.d);
            return stringBuffer.toString();
        }

        public void a(long j) {
            this.c = ((float) (j >> 9)) / 2.0f;
        }

        public void a() {
            m.d().a(toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str) {
        if (str == null) {
            return null;
        }
        if (!str.startsWith(BNWebViewClient.URL_HTTP_PREFIX) || str.length() <= 7) {
            return (!str.startsWith(BNWebViewClient.URL_HTTPS_PREFIX) || str.length() <= 8) ? str : str.substring(8);
        }
        return str.substring(7);
    }

    private String a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = bundle.getInt("count.sum");
        for (int i2 = 0; i2 < i; i2++) {
            Bundle bundle2 = bundle.getBundle(i2 + "");
            if (bundle2 != null) {
                stringBuffer.append("e;");
                stringBuffer.append(bundle2.getLong("tick.count"));
                stringBuffer.append(com.huawei.openalliance.ad.constant.x.aL);
                stringBuffer.append(bundle2.getDouble("data.size"));
                stringBuffer.append(com.huawei.openalliance.ad.constant.x.aL);
                stringBuffer.append(c(bundle2.getString("pstdomain.name")));
                if (i2 + 1 < i) {
                    stringBuffer.append("||");
                }
            }
        }
        return stringBuffer.toString();
    }

    public void b() {
        JNIStatisticsControl.sInstance.clearOldNetWorkDataRecord();
    }

    public void a(Context context) {
        String str;
        if (context == null) {
            return;
        }
        e0.a(context).b("navi.end.flag.key", false);
        String a2 = a();
        StringBuffer stringBuffer = this.f9378a;
        if (stringBuffer != null) {
            str = stringBuffer.toString();
        } else {
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        String str2 = c;
        sb.append(str2);
        sb.append("_endStat engine:");
        LogUtil.e(sb.toString(), a2);
        LogUtil.e(str2 + "_endStat http:", str);
        this.b = a2 + "||" + str;
        ProNaviStatItem.O().c(this.b);
        b();
        c();
    }

    public void a(String str) {
        if (str == null) {
            return;
        }
        if (this.f9378a == null) {
            this.f9378a = new StringBuffer();
        }
        if (!this.f9378a.toString().equals("")) {
            this.f9378a.append("||");
        }
        this.f9378a.append(str);
    }
}
