package com.baidu.navisdk.module.newguide.settings;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.j;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class e extends com.baidu.navisdk.ui.routeguide.widget.d {
    private TextView i;
    private boolean j;
    private Runnable k;
    private RelativeLayout l;
    private com.baidu.navisdk.util.worker.loop.a m;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.q0();
            e.this.k = null;
        }
    }

    public e(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.j = false;
        this.m = new com.baidu.navisdk.util.worker.loop.a("RGSettingGuideManager");
    }

    private boolean n0() {
        if (!j.d() || this.b == null) {
            return false;
        }
        if (this.j) {
            return a();
        }
        int rGSettingBubbleShowTimes = BNCommSettingManager.getInstance().getRGSettingBubbleShowTimes();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingGuideManager", "show showTimes: " + rGSettingBubbleShowTimes);
        }
        if (rGSettingBubbleShowTimes >= 3 || 2 == this.f) {
            return false;
        }
        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
            if (gVar.d()) {
                gVar.e("RGSettingGuideManager", "show: return NE_Locate_Mode_RouteDemoGPS");
            }
            return false;
        }
        int c = com.baidu.navisdk.module.pronavi.model.g.o().c();
        if (gVar.d()) {
            gVar.e("show carSpeed: " + c);
        }
        if (c > 10) {
            return false;
        }
        return true;
    }

    private boolean o0() {
        Runnable runnable = this.k;
        if (runnable != null) {
            this.m.removeCallbacks(runnable);
            this.k = null;
        }
        if (this.l == null) {
            return false;
        }
        a aVar = new a();
        this.k = aVar;
        this.m.post(aVar);
        return true;
    }

    private void p0() {
        TextView textView = this.i;
        if (textView != null) {
            ViewParent parent = textView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingGuideManager", "showBubbleView: ");
        }
        if (this.f9165a == null) {
            if (gVar.c()) {
                gVar.c("RGSettingGuideManager", "showBubbleView: mContext == null");
                return;
            }
            return;
        }
        String string = JarUtils.getResources().getString(R.string.nsdk_rg_setting_bubble_tips);
        if (this.i == null) {
            TextView textView = new TextView(this.f9165a);
            this.i = textView;
            textView.setText(string);
            this.i.setTextColor(-1);
            this.i.setTextSize(13.0f);
            this.i.setBackgroundResource(R.drawable.nsdk_rr_bottom_bubble_bg);
            this.i.setGravity(16);
        } else {
            p0();
        }
        int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_45dp);
        int dimensionPixelSize2 = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_new_control_panel_bottom_margin);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, dimensionPixelSize);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = dimensionPixelSize2;
        if (gVar.d()) {
            gVar.e("RGSettingGuideManager", "showBubbleView bottomMargin: " + layoutParams.bottomMargin);
        }
        this.l.addView(this.i, layoutParams);
        this.l.setVisibility(0);
        BNCommSettingManager.getInstance().putRGSettingBubbleShowTimes(BNCommSettingManager.getInstance().getRGSettingBubbleShowTimes() + 1);
        u(5000);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        Runnable runnable = this.k;
        if (runnable != null) {
            this.m.removeCallbacks(runnable);
            this.k = null;
        }
        RelativeLayout relativeLayout = this.l;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        e0();
        p0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i0() {
        super.i0();
        c();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingGuideManager", "show:" + this.j);
        }
        if (!n0()) {
            return false;
        }
        boolean o02 = o0();
        this.j = o02;
        if (!o02 || !super.y()) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        if (a()) {
            c();
        }
        Runnable runnable = this.k;
        if (runnable != null) {
            this.m.removeCallbacks(runnable);
            this.k = null;
        }
        if (n0()) {
            o0();
        }
    }
}
