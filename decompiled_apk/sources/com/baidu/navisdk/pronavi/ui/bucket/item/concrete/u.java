package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.pronavi.widget.RGImageTextBtn;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class u extends com.baidu.navisdk.pronavi.ui.bucket.item.c {
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private boolean o;
    private RGImageTextBtn p;
    private boolean q;
    private final a.InterfaceC0201a r;

    /* loaded from: classes7.dex */
    public class a implements a.InterfaceC0201a {
        public a() {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d() && obj != null) {
                gVar.e("UgcModule_UgcReport", "onEvent: " + obj.toString());
            }
            if (obj instanceof com.baidu.navisdk.ugc.replenishdetails.e) {
                com.baidu.navisdk.ugc.replenishdetails.e eVar = (com.baidu.navisdk.ugc.replenishdetails.e) obj;
                if (eVar.b == 2) {
                    if (!eVar.f8239a && u.this.n != eVar.e) {
                        return;
                    }
                    int i = R.drawable.nsdk_rg_ic_ugc_report_innavi;
                    String str = "上报";
                    if (!eVar.f8239a) {
                        u.this.n = 0;
                    } else {
                        u.this.n = eVar.e;
                        int i2 = eVar.c;
                        if (i2 > 0) {
                            i = i2;
                        }
                        if (!TextUtils.isEmpty(eVar.d)) {
                            str = eVar.d;
                        }
                        if (eVar.e == 1) {
                            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.4", eVar.b + "", "6", null);
                        } else {
                            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.2", eVar.b + "", "3", null);
                        }
                    }
                    u.this.a(!eVar.f8239a, str, i);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements com.baidu.navisdk.widget.naviimageloader.e {
        public b() {
        }

        @Override // com.baidu.navisdk.widget.naviimageloader.e
        public void a(String str, View view) {
            u.this.l = true;
        }

        @Override // com.baidu.navisdk.widget.naviimageloader.e
        public void a(String str, View view, Bitmap bitmap, int i) {
            com.baidu.navisdk.ui.util.b.a(view);
            u.this.k = true;
            u.this.l = false;
        }
    }

    public u(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar, R.drawable.nsdk_rg_ic_ugc_report_innavi, "上报");
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = 0;
        this.o = false;
        this.p = null;
        this.q = false;
        a aVar = new a();
        this.r = aVar;
        com.baidu.navisdk.framework.message.a.a().a(aVar, com.baidu.navisdk.ugc.replenishdetails.e.class, new Class[0]);
    }

    private void A() {
        com.baidu.navisdk.ugc.utils.d.a(4102, this.p.icon, new b());
    }

    private int d(boolean z) {
        if (com.baidu.navisdk.module.newguide.a.e().d() && com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_img_width);
        }
        if (z) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_26dp);
        }
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_24dp);
    }

    private int e(boolean z) {
        if (com.baidu.navisdk.module.newguide.a.e().d() && com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_text_size_new);
        }
        if (z) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_text_size);
        }
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_10dp);
    }

    private void y() {
        if (this.p != null && !this.k && this.m) {
            if (TextUtils.isEmpty(com.baidu.navisdk.ugc.report.data.datarepository.c.e(4102))) {
                this.k = true;
            } else {
                if (this.l) {
                    return;
                }
                A();
            }
        }
    }

    private void z() {
        com.baidu.navisdk.pronavi.style.i.b g;
        if (this.e != null && (g = com.baidu.navisdk.ui.routeguide.utils.b.g()) != null) {
            g.b("UgcReport", this.e);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (!BNSettingManager.isUgcButtonEnable()) {
            return 8;
        }
        if (!com.baidu.navisdk.function.b.FUNC_UGC_REPORT_BTN.a()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("UgcModule_UgcReport", "showUgcBtnLayout force hide , return!");
            }
            return 8;
        }
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().D() || com.baidu.navisdk.ui.routeguide.model.a0.I().r() || this.f7853a.N()) {
            return 8;
        }
        return (b(RGFSMTable.FsmState.BrowseMap) || this.o) ? 0 : 8;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void loadBucketItem(ViewGroup viewGroup, int i, Context context) {
        super.loadBucketItem(viewGroup, i, context);
        this.p = v();
        if (this.q) {
            a(this.m, this.g, this.f);
        }
        t();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c, com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onDestroy() {
        super.onDestroy();
        com.baidu.navisdk.framework.message.a.a().a(this.r);
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        super.onVisibleChange(i);
        if (i == 0) {
            y();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer, RGFSMTable.FsmState.ArriveDest};
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public String[] w() {
        return new String[]{"UgcReport", "RGCommonWidget"};
    }

    public void b(boolean z) {
        this.o = z;
        refreshVisible();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void a(View view) {
        if (com.baidu.navisdk.ui.util.g.a()) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.subview.a w = this.f7853a.w();
        if (w != null) {
            w.c(2);
        }
        if (RGFSMTable.FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getTopState())) {
            com.baidu.navisdk.ui.routeguide.control.x.b().a(0L);
        }
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_reprot_ugc"));
    }

    private int c(boolean z) {
        if (com.baidu.navisdk.module.newguide.a.e().d() && com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
            return 0;
        }
        if (z) {
            return ScreenUtil.getInstance().dip2px(-4);
        }
        return ScreenUtil.getInstance().dip2px(-2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CharSequence charSequence, int i) {
        this.m = z;
        d(i);
        a(charSequence);
        RGImageTextBtn rGImageTextBtn = this.p;
        if (rGImageTextBtn == null) {
            this.q = true;
            return;
        }
        this.q = false;
        rGImageTextBtn.setTextSize(e(z));
        int d = d(z);
        this.p.b(d, d, c(z));
        if (z) {
            this.p.setTextContent(charSequence);
            if (TextUtils.isEmpty(com.baidu.navisdk.ugc.report.data.datarepository.c.e(4102))) {
                this.p.setIcon(i);
            } else {
                A();
            }
        } else {
            this.p.setTextContent(charSequence);
            this.p.setIcon(i);
        }
        if (this.f != R.drawable.nsdk_rg_ic_ugc_report_innavi) {
            z();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public void a(boolean z) {
        super.a(z);
        z();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public String a(String str) {
        if (this.f == R.drawable.nsdk_rg_ic_ugc_report_innavi && "RGImgTintColor".equals(str)) {
            return null;
        }
        return str;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void a(com.baidu.navisdk.pronavi.style.i.a aVar) {
        RGImageTextBtn v = v();
        if (v == null || aVar == null) {
            return;
        }
        aVar.a(v.text);
        aVar.a(v);
        aVar.a(v.icon);
    }
}
