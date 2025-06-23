package com.baidu.navisdk.module.newguide.subviews.guides;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public abstract class a extends com.baidu.navisdk.ui.routeguide.widget.a {
    public a(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public boolean n0() {
        if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k()) {
            y(false);
            return false;
        }
        if (a0.I().D()) {
            LogUtil.e("BNDefaultGuideBaseView", "随后-disposeNextTurnVisible, isYawing return!");
            return false;
        }
        if (x.b().f2()) {
            return false;
        }
        if (x.b().N2()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNDefaultGuideBaseView", "isVdrFuzzyMode");
            }
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.model.i.s().l()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNDefaultGuideBaseView", "随后-disposeNextTurnVisible, 辅助直行 return!");
            }
            y(false);
            return false;
        }
        if (r0() && !a0.I().v()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("BNDefaultGuideBaseView", "随后-disposeNextTurnVisible - iconId : ");
            }
            Drawable d = a0.I().e().d();
            if (d != null) {
                x.b().a(d);
                y(true);
            }
            return true;
        }
        y(false);
        return false;
    }
}
