package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.widget.BNScaleLevelViewPlugin;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class t0 extends com.baidu.navisdk.ui.routeguide.widget.d {
    private View i;
    private RelativeLayout j;
    private TextView k;
    private TextView l;
    private View m;
    private BNScaleLevelViewPlugin n;
    private boolean o;

    /* loaded from: classes8.dex */
    public class a implements BNScaleLevelViewPlugin.SwitchModeCallback {
        public a() {
        }

        @Override // com.baidu.navisdk.ui.widget.BNScaleLevelViewPlugin.SwitchModeCallback
        public void switchMode(int i) {
            t0.this.y(i);
        }
    }

    public t0(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.o = false;
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            this.o = k.X();
        }
        q0();
        p0();
    }

    private void p0() {
        this.n = new BNScaleLevelViewPlugin(new a());
    }

    private void q0() {
        View view;
        RelativeLayout relativeLayout;
        ViewGroup viewGroup = this.b;
        if (viewGroup == null || this.i != null) {
            return;
        }
        View findViewById = viewGroup.findViewById(R.id.bnav_scale_and_logo_layout);
        this.i = findViewById;
        if (findViewById == null) {
            return;
        }
        this.j = (RelativeLayout) this.b.findViewById(R.id.bnav_rg_map_scale_layout);
        this.k = (TextView) this.b.findViewById(R.id.bnav_rg_scale_title);
        this.l = (TextView) this.b.findViewById(R.id.bnav_rg_scale_indicator);
        ImageView imageView = (ImageView) this.b.findViewById(R.id.app_name);
        this.m = this.b.findViewById(R.id.bnav_rg_baidu_map_logo);
        if (imageView != null && com.baidu.navisdk.j.d()) {
            imageView.setVisibility(8);
        }
        if (com.baidu.navisdk.util.common.x.s() && (relativeLayout = this.j) != null) {
            relativeLayout.setVisibility(8);
        }
        if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().l() && (view = this.i) != null) {
            view.setVisibility(8);
        }
        a(com.baidu.navisdk.ui.util.b.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i) {
        q0();
        View view = this.i;
        if (view != null) {
            view.setVisibility(0);
        }
        if (i != 1 && com.baidu.navisdk.ui.routeguide.utils.b.s()) {
            i = 1;
        }
        if (i == 1) {
            RelativeLayout relativeLayout = this.j;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            View view2 = this.m;
            if (view2 != null) {
                view2.setVisibility(0);
                return;
            }
            return;
        }
        View view3 = this.m;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        if (this.j != null && !com.baidu.navisdk.util.common.x.s() && !this.o) {
            this.j.setVisibility(0);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        BNScaleLevelViewPlugin bNScaleLevelViewPlugin = this.n;
        if (bNScaleLevelViewPlugin != null) {
            bNScaleLevelViewPlugin.release();
            this.n = null;
        }
    }

    public void n0() {
        q0();
        View view = this.i;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void o0() {
        int i;
        String str;
        q0();
        int screenWidth = BNMapController.getInstance().getScreenWidth();
        int zoomLevel = BNMapController.getInstance().getZoomLevel();
        double zoomUnitsInMeter = BNMapController.getInstance().getZoomUnitsInMeter();
        int o = com.baidu.nplatform.comapi.map.j.o(zoomLevel);
        LogUtil.e("Map", "room updateScale dis=" + o + " level=" + zoomLevel + " u=" + zoomUnitsInMeter);
        double ceil = Math.ceil(((double) o) / zoomUnitsInMeter);
        while (true) {
            i = (int) ceil;
            if (i <= screenWidth / 2 || zoomLevel < 4 || zoomLevel > 21) {
                break;
            }
            zoomLevel++;
            o = com.baidu.nplatform.comapi.map.j.o(zoomLevel);
            ceil = Math.ceil(o / zoomUnitsInMeter);
        }
        if (o >= 1000) {
            str = (o / 1000) + JarUtils.getResources().getString(R.string.nsdk_string_rg_kilometer);
        } else {
            str = o + JarUtils.getResources().getString(R.string.nsdk_string_rg_meter);
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            textView2.setWidth(i + 4);
        }
    }

    public void v(int i) {
        y(i);
    }

    public void w(int i) {
        BNScaleLevelViewPlugin bNScaleLevelViewPlugin;
        if (RGFSMTable.FsmState.NearbySearch.equalsIgnoreCase(RouteGuideFSM.getInstance().getCurrentState()) && (bNScaleLevelViewPlugin = this.n) != null) {
            bNScaleLevelViewPlugin.switchScaleViewMode(i);
        }
    }

    public void x(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        View view = this.i;
        if (view != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) != null && marginLayoutParams.leftMargin != i) {
            marginLayoutParams.leftMargin = i;
            this.i.requestLayout();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        this.i = null;
        q0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        TextView textView = this.k;
        if (textView != null) {
            textView.setTextColor(z ? -13223362 : -1052432);
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            textView2.setBackground(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_rg_ic_scale_indicator));
        }
    }
}
