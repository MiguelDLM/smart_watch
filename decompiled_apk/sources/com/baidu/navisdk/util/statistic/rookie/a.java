package com.baidu.navisdk.util.statistic.rookie;

import android.os.Message;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.navisdk.comapi.base.d;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.v;
import com.baidu.navisdk.util.http.center.c;
import com.baidu.navisdk.util.http.center.f;
import com.baidu.navisdk.util.http.center.i;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class a {
    private static a b;

    /* renamed from: a, reason: collision with root package name */
    private d f9382a = new HandlerC0508a("RookieEventOpStat");

    /* renamed from: com.baidu.navisdk.util.statistic.rookie.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC0508a extends com.baidu.navisdk.util.worker.loop.b {
        public HandlerC0508a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(4099);
        }

        @Override // com.baidu.navisdk.util.worker.loop.b
        public void onMessage(Message message) {
            if (message.what == 4099 && message.arg1 == 0 && com.baidu.navisdk.module.vehiclemanager.b.i().f() && BNSettingManager.isNoviceMode()) {
                a.this.e();
            }
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        BNSettingManager.putRookieEventOpStartTime(0L);
    }

    public static a d() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        String b2 = com.baidu.navisdk.util.http.b.d().b("RookieEventOp");
        ArrayList arrayList = new ArrayList();
        String E = com.baidu.navisdk.framework.b.E();
        try {
            if (E == null) {
                E = "";
            }
            arrayList.add(new i("bduid", URLEncoder.encode(E, "utf-8")));
            arrayList.add(new i("cuid", URLEncoder.encode(a0.e(), "utf-8")));
            arrayList.add(new i("type", URLEncoder.encode("new_driver", "utf-8")));
            arrayList.add(new i("finishtime", URLEncoder.encode(String.valueOf((int) (System.currentTimeMillis() / 1000)), "utf-8")));
            arrayList.add(new i(HttpConstants.SIGN, v.b(com.baidu.navisdk.module.cloudconfig.d.a(arrayList) + "MI49ZDyZ6EqHmwvSpjRzXFMJpDhKz4Ge").toLowerCase()));
            com.baidu.navisdk.util.http.center.b.a().b(b2, c.a(arrayList), new b(), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* loaded from: classes8.dex */
    public class b extends f {
        public b() {
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.e("RookieEventOpStat", "onFailure(), statusCode = " + i + " responseString = " + str + " throwable = " + th);
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.e("RookieEventOpStat", "onSuccess(), statusCode = " + i + " responseString = " + str);
            }
            try {
                if (new JSONObject(str).getInt("errno") == 0) {
                    a.this.c();
                    a.this.b();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a() {
        if (System.currentTimeMillis() / 86400000 == BNSettingManager.getRookieEventOpStartTime() / 86400000) {
            com.baidu.navisdk.vi.b.a(this.f9382a);
        }
    }

    public void b() {
        com.baidu.navisdk.vi.b.b(this.f9382a);
    }
}
