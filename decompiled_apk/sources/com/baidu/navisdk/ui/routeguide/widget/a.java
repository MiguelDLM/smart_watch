package com.baidu.navisdk.ui.routeguide.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.i;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public abstract class a extends d {
    public a(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
    }

    public abstract void f(String str);

    public boolean n0() {
        if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k()) {
            y(false);
            return false;
        }
        if (a0.I().D()) {
            LogUtil.e("guide_info", "随后-disposeNextTurnVisible, isYawing return!");
            return false;
        }
        if (x.b().f2()) {
            return false;
        }
        if (x.b().N2()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("VdrModeGuide", "isVdrFuzzyMode");
            }
            return false;
        }
        if (i.s().l()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("guide_info", "随后-disposeNextTurnVisible, 辅助直行 return!");
            }
            y(false);
            return false;
        }
        if (r0() && !a0.I().v()) {
            Drawable d = a0.I().e().d();
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("guide_info", "随后-disposeNextTurnVisible - iconId : ");
            }
            if (d != null) {
                x.b().a(d);
                y(true);
            }
            return true;
        }
        y(false);
        return false;
    }

    public abstract void o0();

    public abstract View p0();

    public abstract int q0();

    public boolean r0() {
        if (!x.b().Q2() && !x.b().P2()) {
            return a0.I().B();
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("isShowFollowInfo: is vdr");
            return false;
        }
        return false;
    }

    public abstract void s0();

    public abstract void t0();

    public abstract void u0();

    public abstract int w0();

    public void y(boolean z) {
        int i;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("guide_info", "setNextTurnVisibility: " + z);
        }
        a0.I().i(z);
        com.baidu.navisdk.ui.routeguide.mapmode.a b = x.b();
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        b.r(i);
    }
}
