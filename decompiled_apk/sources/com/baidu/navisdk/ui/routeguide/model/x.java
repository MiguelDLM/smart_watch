package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.g0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.util.navimageloader.b;

/* loaded from: classes8.dex */
public class x {
    private static x y;

    /* renamed from: a, reason: collision with root package name */
    public boolean f8982a = false;
    public boolean b = false;
    private int c = -1;
    private int d = 0;
    private int e = -1;
    public int f = -1;
    public int g = -1;
    private String h = null;
    private String i = null;
    private String j = null;
    private int k = 0;
    private String l = null;
    private String m = null;
    private int n = 0;
    private int o = 0;
    private int p = -1;
    private int q = -1;
    public int r = 0;
    private boolean s = false;
    public String t = null;
    public String u = null;
    public int v = -1;
    private boolean w = false;
    private g0.e x = new d(this);

    /* loaded from: classes8.dex */
    public class a implements i0.f {
        public a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
            if (x.A().f8982a) {
                com.baidu.navisdk.ui.routeguide.b.V().a(2, false);
            }
            com.baidu.navisdk.ui.routeguide.asr.c.n().c(true);
            String h = com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_switch_route_cancel);
            if (x.this.x()) {
                TTSPlayerControl.playXDTTSText(h, 1);
            } else {
                TTSPlayerControl.playTTS(h, 1);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.d", null, "1", null);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            x.A().f8982a = false;
            com.baidu.navisdk.ui.routeguide.b.V().a(4, false);
            String h = com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_switch_route_cancel);
            if (x.this.x()) {
                TTSPlayerControl.playXDTTSText(h, 1);
            } else {
                TTSPlayerControl.playTTS(h, 1);
            }
            if (x.this.E()) {
                com.baidu.navisdk.module.asr.e.INSTANCE.a(false);
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            if (x.this.r == 6) {
                com.baidu.navisdk.ui.routeguide.asr.instruction.d.INSTANCE.a(true);
            }
            x.A().f8982a = false;
            com.baidu.navisdk.ui.routeguide.b.V().a(3, false);
            if (x.this.E()) {
                com.baidu.navisdk.module.asr.e.INSTANCE.a(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements i0.f {
        public b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
            x.this.f8982a = false;
            com.baidu.navisdk.ui.routeguide.control.s.T().e(103);
            com.baidu.navisdk.ui.routeguide.b.V().r().n();
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            x.this.f8982a = false;
            com.baidu.navisdk.ui.routeguide.control.s.T().e(103);
            com.baidu.navisdk.ui.routeguide.b.V().r().n();
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.7", "" + x.this.q, "1", "" + x.this.r);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            x.this.f8982a = false;
            Bundle bundle = new Bundle();
            bundle.putInt("source", 4);
            bundle.putInt("page", 1);
            bundle.putInt("onroute", 1);
            com.baidu.navisdk.ui.routeguide.b.V().b(x.this.h, true, bundle);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.7", "" + x.this.q, "5", "" + x.this.r);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements i0.f {
        public c(x xVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.3.1", "4", null, null);
            x.A().f8982a = false;
            com.baidu.navisdk.ui.routeguide.b.V().r().n();
            BNRouteGuider.getInstance().refreshRoute(1);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.3.1", "2", null, null);
            x.A().f8982a = false;
            com.baidu.navisdk.ui.routeguide.b.V().r().n();
            BNRouteGuider.getInstance().refreshRoute(1);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.3.1", "3", null, null);
            x.A().f8982a = false;
            com.baidu.navisdk.ui.routeguide.b.V().r().n();
        }
    }

    /* loaded from: classes8.dex */
    public class d extends g0.f {
        public d(x xVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGRouteRecommendModel", "RGMMNotificationBaseView.NotificationDisplayListener - onShowWithAnim");
            }
            com.baidu.navisdk.ui.routeguide.control.x.b().I().b(false);
            com.baidu.navisdk.ui.routeguide.control.x.b().c();
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b() {
            com.baidu.navisdk.ui.routeguide.control.x.b().I().b(true);
            com.baidu.navisdk.ui.routeguide.control.x.b().Y2();
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void c() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void d() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGRouteRecommendModel", "RGMMNotificationBaseView.NotificationDisplayListener - onShowWithOutAnim");
            }
            com.baidu.navisdk.ui.routeguide.control.x.b().I().b(false);
            com.baidu.navisdk.ui.routeguide.control.x.b().c();
        }
    }

    private x() {
    }

    public static x A() {
        if (y == null) {
            y = new x();
        }
        return y;
    }

    private i0 B() {
        if (!com.baidu.navisdk.ui.routeguide.control.s.T().b(103)) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGRouteRecommendModel", "getRouteInfoNotificationView allowOperableNotificationShow return false!");
            }
            return null;
        }
        String str = this.u;
        if (str == null) {
            str = "您已切换到参考路线";
        }
        i0 a2 = com.baidu.navisdk.ui.routeguide.control.x.b().k(103).D(100).v(A().a()).a(str).g(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_confirm)).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_negative)).d(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_route_recommend)).A(true).a(new c(this)).a(this.x);
        a2.z(2);
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.3.1", "1", null, null);
        return a2;
    }

    private i0 C() {
        int i;
        if (!com.baidu.navisdk.ui.routeguide.control.s.T().b(103)) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGRouteRecommendModel", "getRouteSwitchNotificationView allowOperableNotificationShow return false!");
            }
            return null;
        }
        String str = this.l;
        if (str == null) {
            str = "";
        }
        Spanned fromHtml = Html.fromHtml(str);
        String str2 = this.m;
        if (str2 == null) {
            str2 = "";
        }
        if (this.o == 2) {
            i = 300;
        } else {
            i = 100;
        }
        i0 z = com.baidu.navisdk.ui.routeguide.control.x.b().k(103).D(i).v(30000).b(str2).g(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_faster_route_btn_ok)).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_faster_route_btn_cancle)).A(true).a(new a()).a(this.x).z(2);
        int i2 = this.n;
        if (i2 == 1001) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.6", "" + this.q, "0", this.r + "");
            int i3 = R.drawable.nsdk_notification_route_recommend_1001;
            z.d(com.baidu.navisdk.ui.util.b.f(i3)).a(fromHtml);
            ImageView s0 = z.s0();
            if (s0 != null) {
                s0.setTag(Integer.valueOf(i3));
            }
        } else if (i2 == 1002) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.6", "" + this.q, "0", this.r + "");
            int i4 = R.drawable.nsdk_notification_route_recommend_1002;
            z.d(com.baidu.navisdk.ui.util.b.f(i4)).a(fromHtml);
            ImageView s02 = z.s0();
            if (s02 != null) {
                s02.setTag(Integer.valueOf(i4));
            }
        } else {
            String str3 = com.baidu.navisdk.module.a.h().a().v0;
            String str4 = com.baidu.navisdk.module.a.h().a().w0;
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.6", "" + this.q, "1", this.r + "");
                z.a(str3, new b.C0502b().b(R.drawable.nsdk_notification_route_recommend).a(), (com.baidu.navisdk.util.navimageloader.e) null).a(Html.fromHtml(str4 + str));
            } else {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.6", "" + this.q, "0", this.r + "");
                int i5 = R.drawable.nsdk_notification_route_recommend;
                z.d(com.baidu.navisdk.ui.util.b.f(i5)).a(fromHtml);
                ImageView s03 = z.s0();
                if (s03 != null) {
                    s03.setTag(Integer.valueOf(i5));
                }
            }
        }
        return z;
    }

    private com.baidu.navisdk.ui.routeguide.mapmode.subview.m D() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.m mVar;
        String h = A().h();
        if (!TextUtils.isEmpty(h)) {
            mVar = com.baidu.navisdk.ui.routeguide.control.x.b().j(123).z(100).b(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_route_recommend)).f(h);
        } else {
            mVar = null;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRouteRecommendModel", "getSupplyDataNoRouteNotificationView(), view = " + mVar + " content = " + h);
        }
        return mVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E() {
        int i = this.c;
        if (i != 7 && i != 13) {
            return false;
        }
        return true;
    }

    public void a(int i) {
    }

    public void d(int i) {
        this.q = i;
    }

    public void e(int i) {
        this.e = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.baidu.navisdk.ui.routeguide.mapmode.subview.i0 f() {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.model.x.f():com.baidu.navisdk.ui.routeguide.mapmode.subview.i0");
    }

    public int g() {
        return this.k;
    }

    public String h() {
        return this.l;
    }

    public String i() {
        return this.h;
    }

    public int j() {
        return this.q;
    }

    public int k() {
        return this.e;
    }

    public String l() {
        return this.m;
    }

    public int m() {
        return this.c;
    }

    public int n() {
        return this.p;
    }

    public String o() {
        return this.i;
    }

    public void p() {
        this.l = "世界杯来了,韩乔生请求为您导航!";
        this.m = "sub测试";
        this.r = 5;
        this.p = 0;
        this.i = "为您找到一条通往人生巅峰的道路";
        this.o = 0;
        this.n = 0;
    }

    public boolean q() {
        int i = this.r;
        if (i == 6 || i == 1 || i == 2 || i == 12) {
            return true;
        }
        return false;
    }

    public boolean r() {
        if (this.r == 7) {
            return true;
        }
        return false;
    }

    public boolean s() {
        if (this.f8982a && E()) {
            return true;
        }
        return false;
    }

    public boolean t() {
        return this.s;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean u() {
        /*
            r4 = this;
            int r0 = r4.d
            r1 = 3
            r2 = 1
            if (r0 == r1) goto L2b
            int r0 = r4.c
            r1 = 19
            if (r0 != r1) goto Ld
            goto L32
        Ld:
            r1 = 20
            if (r0 != r1) goto L18
            java.lang.String r0 = r4.i
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            goto L31
        L18:
            java.lang.String r0 = r4.l
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L32
            java.lang.String r0 = r4.m
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L29
            goto L32
        L29:
            r2 = 0
            goto L32
        L2b:
            java.lang.String r0 = r4.u
            boolean r0 = android.text.TextUtils.isEmpty(r0)
        L31:
            r2 = r2 ^ r0
        L32:
            if (r2 != 0) goto L72
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.PRO_NAV
            boolean r1 = r0.d()
            if (r1 == 0) goto L72
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "isParamsCorrect: fail mRouteInfoType:-->"
            r1.append(r3)
            int r3 = r4.d
            r1.append(r3)
            java.lang.String r3 = "mContent: "
            r1.append(r3)
            java.lang.String r3 = r4.l
            r1.append(r3)
            java.lang.String r3 = ", mSubContent: "
            r1.append(r3)
            java.lang.String r3 = r4.m
            r1.append(r3)
            java.lang.String r3 = " mChangeRouteUITxt:"
            r1.append(r3)
            java.lang.String r3 = r4.u
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "RGRouteRecommendModel"
            r0.e(r3, r1)
        L72:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.model.x.u():boolean");
    }

    public boolean v() {
        if (this.r == 4 && !w()) {
            return true;
        }
        return false;
    }

    public boolean w() {
        return this.w;
    }

    public boolean x() {
        if (!w() && !q()) {
            return false;
        }
        return true;
    }

    public void y() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRouteRecommendModel", "reset:  --> ");
        }
        this.h = null;
        this.n = 0;
        this.l = null;
        this.m = null;
        this.j = null;
        this.i = null;
        this.o = 0;
        this.p = -1;
        this.q = -1;
        this.e = -1;
        this.t = null;
        this.u = null;
        this.v = -1;
        this.s = false;
    }

    public void z() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRouteRecommendModel", "updateEngineNotificationData: mSubType --> " + this.c + ",mRouteInfoType = " + this.d);
        }
        if (this.d == 0) {
            int i = this.c;
            switch (i) {
                case 0:
                case 1:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 13:
                case 14:
                case 15:
                case 16:
                case 19:
                case 20:
                case 21:
                    this.d = 1;
                    break;
                case 2:
                case 10:
                case 11:
                case 12:
                case 17:
                case 18:
                default:
                    this.d = i;
                    break;
            }
        }
        Bundle bundle = new Bundle();
        if (BNRouteGuider.getInstance().getRouteInfoInUniform(this.d, bundle)) {
            a(bundle);
        } else {
            y();
        }
    }

    public void b(String str) {
        this.h = str;
    }

    public g0 c() {
        int i = this.c;
        if (i != 3) {
            if (i != 7) {
                if (i != 20) {
                    if (i != 29) {
                        if (i != 13) {
                            if (i != 14) {
                                return null;
                            }
                        }
                    }
                    return f();
                }
                return D();
            }
            return C();
        }
        return B();
    }

    public String d() {
        return this.j;
    }

    public int e() {
        return this.d;
    }

    private void a(Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("parseRouteInfo: bundle --> ");
            sb.append(bundle == null ? "null" : bundle.toString());
            gVar.e("RGRouteRecommendModel", sb.toString());
        }
        if (bundle == null) {
            y();
            return;
        }
        this.n = bundle.getInt("nIconID");
        this.o = bundle.getInt("nPattern");
        bundle.getInt("nDisplayDuation");
        this.l = bundle.getString("usContent");
        this.m = bundle.getString("usSubContent");
        this.j = bundle.getString("usReasonDesc");
        this.i = bundle.getString("usVoiceContent");
        this.k = bundle.getInt("usVoiceContentType");
        this.h = bundle.getString("usInfoID");
        this.p = bundle.getInt("enVoiceBroadType");
        this.q = bundle.getInt("enPushType");
        this.r = bundle.getInt("enUpdateRouteSource");
        this.i = bundle.getString("usVoiceContent");
        this.t = bundle.getString("usVoiceTxt");
        this.u = bundle.getString("usUITxt");
        this.v = bundle.getInt("enType");
        this.s = bundle.getBoolean("ETAQueryNeedVia");
        bundle.getInt("unTime");
        this.f = bundle.getInt("nBeginIndex", -1);
        this.g = bundle.getInt("nEndIndex", -1);
    }

    public void b(int i) {
        this.n = i;
    }

    public void d(String str) {
        this.i = str;
    }

    public String b() {
        return com.baidu.navisdk.module.asr.instructions.b.a(this.w, this.r);
    }

    public void c(String str) {
        this.m = str;
    }

    public void c(int i) {
        this.o = i;
    }

    public int a() {
        int a2;
        f.a0 a0Var = com.baidu.navisdk.module.cloudconfig.f.c().f7101a;
        if (a0Var == null || (a2 = a0Var.a()) <= 0) {
            return 30000;
        }
        return a2 * 1000;
    }

    public void a(String str) {
        this.l = str;
    }

    public void a(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    public void a(boolean z) {
        this.w = z;
    }

    public void f(int i) {
        this.p = i;
    }
}
