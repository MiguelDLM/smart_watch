package com.baidu.navisdk.ugc.report.voice;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.s;
import com.baidu.navisdk.model.modelfactory.e;
import com.baidu.navisdk.ugc.https.d;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.z;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class c implements com.baidu.navisdk.ugc.report.voice.a {
    private com.baidu.navisdk.ugc.report.data.datastatus.a b;
    private com.baidu.navisdk.ugc.report.voice.b c;
    private GeoPoint d;

    /* renamed from: a, reason: collision with root package name */
    private Handler f8325a = null;
    private int e = 2;

    /* loaded from: classes8.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            s b;
            if (message.what == 1003) {
                if (message.arg1 == 0 && (b = ((e) com.baidu.navisdk.model.modelfactory.c.a().a("PoiSearchModel")).b()) != null && b.g.length() > 0) {
                    c.this.b.s = b.g;
                }
                c.this.d();
            }
        }
    }

    private c() {
    }

    private int a(int i) {
        switch (i) {
            case 0:
                return 5;
            case 1:
            case 6:
                return 4;
            case 2:
                return 9;
            case 3:
                return 10;
            case 4:
                return 6;
            case 5:
                return 7;
            case 7:
                return 2;
            case 8:
                return 47;
            case 9:
                return 15;
            case 10:
                return 45;
            default:
                return -1;
        }
    }

    private void b() {
        if (this.f8325a == null) {
            this.f8325a = new b(Looper.getMainLooper());
        }
    }

    public static com.baidu.navisdk.ugc.report.voice.a c() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.baidu.navisdk.ugc.https.e.a(this.b, (com.baidu.navisdk.ugc.https.c) new a(this.e), false, this.e);
    }

    @Override // com.baidu.navisdk.ugc.report.voice.a
    public boolean a(int i, int i2, com.baidu.navisdk.ugc.report.voice.b bVar, int i3, int i4) {
        return a(i, null, null, null, i2, bVar, i3, i4);
    }

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.ugc.report.ui.innavi.a {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.a, com.baidu.navisdk.ugc.https.c
        public void a(JSONObject jSONObject) {
            super.a(jSONObject);
            if (c.this.c != null) {
                c.this.c.a();
            }
            c.this.a();
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.a, com.baidu.navisdk.ugc.https.c
        public void a(String str) {
            super.a(str);
            if (c.this.c != null) {
                c.this.c.b();
            }
            c.this.a();
        }
    }

    public boolean a(int i, String str, String str2, String str3, int i2, com.baidu.navisdk.ugc.report.voice.b bVar, int i3, int i4) {
        if (this.b == null) {
            this.b = new com.baidu.navisdk.ugc.report.data.datastatus.a();
        }
        if (!a(this.b)) {
            if (bVar == null) {
                return false;
            }
            bVar.b();
            return false;
        }
        this.e = i3;
        this.c = bVar;
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = this.b;
        aVar.c = aVar.b;
        d.a(aVar);
        this.b.e = a(i);
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar2 = this.b;
        aVar2.d = i2;
        aVar2.h = str2;
        aVar2.T = str3;
        aVar2.G = a(str);
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar3 = this.b;
        aVar3.b0 = i4;
        if (a(this.d, aVar3)) {
            return true;
        }
        d();
        return true;
    }

    private boolean a(com.baidu.navisdk.ugc.report.data.datastatus.a aVar) {
        if (!z.a(com.baidu.navisdk.framework.a.c().a())) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_fail_badwet));
            return false;
        }
        String a2 = d.a(true);
        aVar.b = a2;
        if (!TextUtils.isEmpty(a2)) {
            return true;
        }
        TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_open_gpc));
        return false;
    }

    private boolean a(GeoPoint geoPoint, com.baidu.navisdk.ugc.report.data.datastatus.a aVar) {
        b();
        if (geoPoint != null) {
            return com.baidu.navisdk.poisearch.c.a(this.d, (com.baidu.navisdk.framework.a.c().a() == null || z.a(com.baidu.navisdk.framework.a.c().a())) ? 1 : 0, 1500, this.f8325a);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Handler handler = this.f8325a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f8325a = null;
        }
        this.c = null;
        this.d = null;
        this.b = null;
    }

    private int a(String str) {
        if (TextUtils.equals(str, "追尾")) {
            return 44;
        }
        if (TextUtils.equals(str, "剐蹭") || TextUtils.equals(str, "刮蹭")) {
            return 45;
        }
        if (TextUtils.equals(str, "故障")) {
            return 46;
        }
        if (TextUtils.equals(str, "严重事故")) {
            return 47;
        }
        if (TextUtils.equals(str, "积水")) {
            return 53;
        }
        if (TextUtils.equals(str, "路上有坑")) {
            return 54;
        }
        if (TextUtils.equals(str, "障碍物")) {
            return 55;
        }
        if (TextUtils.equals(str, "可以通行")) {
            return 48;
        }
        return TextUtils.equals(str, "不能通行") ? 49 : -1;
    }
}
