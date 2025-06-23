package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.Arrays;

/* loaded from: classes8.dex */
public final class c extends com.baidu.navisdk.ui.routeguide.widget.d {
    private TextView i;
    private boolean j;
    private Runnable k;

    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8724a;
        final /* synthetic */ boolean b;
        final /* synthetic */ String c;

        public a(int i, boolean z, String str) {
            this.f8724a = i;
            this.b = z;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.b(this.f8724a, this.b, this.c);
            c.this.k = null;
        }
    }

    public c(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.j = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMM3DCarLogoBubbleView", "showBubbleView orien:" + i + ", isOrienChanged:" + z + ", bubbleText:" + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z && !a()) {
            if (gVar.d()) {
                gVar.e("RGMM3DCarLogoBubbleView", "showBubbleView isOrienChanged && !isVisibility()");
                return;
            }
            return;
        }
        if (this.i == null) {
            TextView textView = new TextView(this.f9165a);
            this.i = textView;
            textView.setText(str);
            this.i.setTextColor(-1);
            this.i.setTextSize(13.0f);
            this.i.setBackgroundResource(R.drawable.nsdk_rr_bottom_bubble_bg);
            this.i.setGravity(16);
        } else {
            q0();
        }
        int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_45dp);
        boolean z2 = BNCommSettingManager.getInstance().getMapMode() == 1 || BNCommSettingManager.getInstance().getMapMode() == 3;
        int[] iArr = new int[2];
        a(iArr, i);
        if (gVar.d()) {
            gVar.e("RGMM3DCarLogoBubbleView", "showBubbleView outLocation: " + Arrays.toString(iArr));
        }
        if (this.b instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, dimensionPixelSize);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            marginLayoutParams = layoutParams;
        } else {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, dimensionPixelSize);
        }
        marginLayoutParams.leftMargin = (b(i, z2) - (com.baidu.navisdk.ui.util.j.a(this.i, str) / 2)) - iArr[0];
        marginLayoutParams.topMargin = ((c(i, z2) - iArr[1]) - dimensionPixelSize) - o0();
        if (gVar.d()) {
            gVar.e("RGMM3DCarLogoBubbleView", "showBubbleView left: " + marginLayoutParams.leftMargin + ", lp.topMargin:" + marginLayoutParams.topMargin + ",height:" + dimensionPixelSize);
        }
        if (marginLayoutParams.leftMargin < 100 && marginLayoutParams.topMargin < 100) {
            if (gVar.d()) {
                gVar.e("RGMM3DCarLogoBubbleView", "showBubbleView lp.leftMargin < 100 && lp.topMargin < 100");
            }
        } else {
            this.b.addView(this.i, marginLayoutParams);
            if (!z) {
                BNSettingManager.add3DCarLogoBubbleTimes();
                BNSettingManager.setLast3DCarLogoBubbleTime(System.currentTimeMillis());
                BNSettingManager.setLast3DCarLogoBubbleText(str);
            }
            u(10000);
        }
    }

    private int c(int i, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMM3DCarLogoBubbleView", "getTopMargin(), orien = " + i + " isCar3D = " + z);
        }
        if (z) {
            return w(i);
        }
        return y(i);
    }

    private void n0() {
        BNSettingManager.set3DCarLogoBubbleTimes(0);
        BNSettingManager.setLast3DCarLogoBubbleTime(0L);
    }

    private int o0() {
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_44dp);
    }

    private boolean p0() {
        String str = com.baidu.navisdk.module.cloudconfig.f.c().s.f7132a;
        String last3DCarLogoBubbleText = BNSettingManager.getLast3DCarLogoBubbleText();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMM3DCarLogoBubbleView", "handlerBubblePreferData cloud: " + str + ", pre:" + last3DCarLogoBubbleText + ", defa:点击车标即可切换3D车标");
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty("点击车标即可切换3D车标")) {
            return false;
        }
        if ("点击车标即可切换3D车标".equals(str)) {
            if (!TextUtils.isEmpty(last3DCarLogoBubbleText) && !"点击车标即可切换3D车标".equals(last3DCarLogoBubbleText)) {
                return false;
            }
            return true;
        }
        if (!TextUtils.isEmpty(last3DCarLogoBubbleText) && !"点击车标即可切换3D车标".equals(last3DCarLogoBubbleText)) {
            if (!str.equals(last3DCarLogoBubbleText)) {
                n0();
            }
        } else {
            n0();
        }
        return true;
    }

    private void q0() {
        TextView textView = this.i;
        if (textView != null) {
            ViewParent parent = textView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.i);
            }
        }
    }

    private int v(int i) {
        if (2 == i) {
            return (com.baidu.navisdk.pronavi.util.a.h.d() + com.baidu.navisdk.ui.routeguide.control.x.b().V()) / 2;
        }
        if (!com.baidu.navisdk.j.d() && (com.baidu.navisdk.ui.routeguide.c.g().b() != 0 || com.baidu.navisdk.ui.routeguide.c.g().d() != 0)) {
            return (com.baidu.navisdk.pronavi.util.a.h.e() / 2) + com.baidu.navisdk.ui.routeguide.c.g().b();
        }
        return com.baidu.navisdk.pronavi.util.a.h.e() / 2;
    }

    private int w(int i) {
        int d;
        int dimensionPixelOffset;
        if (2 == i) {
            d = com.baidu.navisdk.ui.routeguide.utils.a.f9151a.a();
            dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_map_status_y_offset);
        } else {
            d = com.baidu.navisdk.pronavi.util.a.h.d();
            if (!com.baidu.navisdk.j.d() && com.baidu.navisdk.ui.routeguide.c.g().d() != 0) {
                d /= 2;
                dimensionPixelOffset = com.baidu.navisdk.ui.routeguide.c.g().d();
            } else {
                dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_172dp);
            }
        }
        return d - dimensionPixelOffset;
    }

    private int x(int i) {
        if (2 == i) {
            return (com.baidu.navisdk.pronavi.util.a.h.d() + com.baidu.navisdk.ui.routeguide.control.x.b().V()) / 2;
        }
        return com.baidu.navisdk.pronavi.util.a.h.e() / 2;
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
            gVar.e("RGMM3DCarLogoBubbleView", "show:" + this.j);
        }
        if (!com.baidu.navisdk.j.d() || this.b == null) {
            return false;
        }
        if (this.j) {
            return a();
        }
        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
            if (gVar.d()) {
                gVar.e("RGMM3DCarLogoBubbleView", "show: return NE_Locate_Mode_RouteDemoGPS");
            }
            return false;
        }
        if (com.baidu.navisdk.module.cloudconfig.f.c().s.d && com.baidu.navisdk.function.b.FUNC_CAR_LOGO_3D_SELECT.a()) {
            if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
                if (gVar.d()) {
                    gVar.e("RGMM3DCarLogoBubbleView", "show !BNavigator.getInstance().hasCalcRouteOk() return false!");
                }
                return false;
            }
            if (com.baidu.navisdk.ui.routeguide.model.g.h().a()) {
                if (gVar.d()) {
                    gVar.e("RGMM3DCarLogoBubbleView", "show is full view state");
                }
                return false;
            }
            int c = com.baidu.navisdk.module.pronavi.model.g.o().c();
            if (gVar.d()) {
                gVar.e("show carSpeed: " + c);
            }
            if (c > 5) {
                return false;
            }
            String currentUUID = JNITrajectoryControl.sInstance.getCurrentUUID();
            long trajectoryLength = !com.baidu.navisdk.util.common.l0.c(currentUUID) ? JNITrajectoryControl.sInstance.getTrajectoryLength(currentUUID) : 0L;
            if (gVar.d()) {
                gVar.e("RGMM3DCarLogoBubbleView", "show totalDistanceDriving: " + trajectoryLength);
            }
            if (trajectoryLength > 1000) {
                return false;
            }
            if (!p0()) {
                if (gVar.d()) {
                    gVar.e("RGMM3DCarLogoBubbleView", "show !handlerBubblePreferData()");
                }
                return false;
            }
            int i = BNSettingManager.get3DCarLogoBubbleTimes();
            if (gVar.d()) {
                gVar.e("RGMM3DCarLogoBubbleView", "show showTimes: " + i);
            }
            if (i >= com.baidu.navisdk.module.cloudconfig.f.c().s.b) {
                if (gVar.d()) {
                    gVar.e("RGMM3DCarLogoBubbleView", "show showTimes >= " + com.baidu.navisdk.module.cloudconfig.f.c().s.b);
                }
                return false;
            }
            long last3DCarLogoBubbleTime = BNSettingManager.getLast3DCarLogoBubbleTime();
            if (gVar.d()) {
                gVar.e("RGMM3DCarLogoBubbleView", "show lastTime:" + last3DCarLogoBubbleTime);
            }
            if (System.currentTimeMillis() - last3DCarLogoBubbleTime < com.baidu.navisdk.module.cloudconfig.f.c().s.c * 3600000) {
                if (gVar.d()) {
                    gVar.e("RGMM3DCarLogoBubbleView", "show lastTime < " + com.baidu.navisdk.module.cloudconfig.f.c().s.c);
                }
                return false;
            }
            boolean a2 = a(com.baidu.navisdk.ui.routeguide.control.x.b().d0(), false, com.baidu.navisdk.module.cloudconfig.f.c().s.f7132a);
            this.j = a2;
            return a2 && super.y();
        }
        if (gVar.d()) {
            gVar.e("RGMM3DCarLogoBubbleView", "show mCommonConfig.is3DCarLogoOpen is false");
        }
        return false;
    }

    private void a(int[] iArr, int i) {
        this.b.getLocationInWindow(iArr);
        if (2 == i) {
            iArr[0] = com.baidu.navisdk.ui.routeguide.control.x.b().V();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        if (a()) {
            q0();
            a(i, true, com.baidu.navisdk.module.cloudconfig.f.c().s.f7132a);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        ViewGroup viewGroup;
        super.c();
        Runnable runnable = this.k;
        if (runnable != null && (viewGroup = this.b) != null) {
            viewGroup.removeCallbacks(runnable);
            this.k = null;
        }
        e0();
        q0();
    }

    private boolean a(int i, boolean z, String str) {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return false;
        }
        Runnable runnable = this.k;
        if (runnable != null) {
            viewGroup.removeCallbacks(runnable);
            this.k = null;
        }
        a aVar = new a(i, z, str);
        this.k = aVar;
        this.b.post(aVar);
        return true;
    }

    private int b(int i, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMM3DCarLogoBubbleView", "getLeftMargin(), orien = " + i + " isCar3D = " + z);
        }
        if (z) {
            return v(i);
        }
        return x(i);
    }

    private int y(int i) {
        if (2 == i) {
            return com.baidu.navisdk.ui.routeguide.utils.a.f9151a.a() / 2;
        }
        return (com.baidu.navisdk.pronavi.util.a.h.d() / 2) + ScreenUtil.getInstance().dip2px(20);
    }
}
