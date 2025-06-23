package com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.text.TextUtils;
import android.view.View;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public abstract class b extends com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a {

    @OOXIXo
    private String b = "RGMABBaseBtnLogic";
    private int c = -1;

    public abstract int a(int i);

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.a
    public boolean a(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b uiContext, @OOXIXo View view, @oOoXoXO Object obj) {
        IIX0o.x0xO0oo(uiContext, "uiContext");
        IIX0o.x0xO0oo(view, "view");
        com.baidu.navisdk.ui.routeguide.subview.a w = uiContext.w();
        IIX0o.oO(w, "uiContext.subViewListener");
        if (w == null) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(this.b, "onClicked: subViewListener == null");
            }
            return false;
        }
        if (com.baidu.navisdk.ui.util.g.a()) {
            LogUtil.e(this.b, "mRLBridgeSwitch isFastDoubleClick");
            return false;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a b = x.b();
        IIX0o.oO(b, "RGViewController.getInstance()");
        if (b.l2()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(this.b, "mRLBridgeSwitch isInterceptReCalRouteForVdrGuide");
            }
            return false;
        }
        return a(w, uiContext);
    }

    public abstract boolean a(@oOoXoXO com.baidu.navisdk.ui.routeguide.subview.a aVar, @OOXIXo com.baidu.navisdk.pronavi.ui.base.b bVar);

    public abstract boolean b(int i);

    public final void c(int i) {
        this.c = i;
    }

    public void d(int i) {
        this.c = a(i);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.b, "update: " + i + ",mCurrentType: " + this.c);
        }
        k();
        String j = j();
        if (!TextUtils.isEmpty(j)) {
            com.baidu.navisdk.util.statistic.userop.b.r().c(j);
        }
    }

    public final int h() {
        return this.c;
    }

    @OOXIXo
    public final String i() {
        return this.b;
    }

    @oOoXoXO
    public abstract String j();

    public abstract void k();

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.b
    public boolean a(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar) {
        int i;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.b, "getVisibility:  " + this.c);
        }
        if (!BNSettingManager.isMainAuxiliaryOrBridgeEnable()) {
            if (gVar.d()) {
                gVar.e(this.b, "getVisibility: isMainAuxiliaryOrBridgeEnable");
            }
            return false;
        }
        a0 I = a0.I();
        IIX0o.oO(I, "RGSimpleGuideModel.getInstance()");
        if (I.D()) {
            if (gVar.d()) {
                gVar.e(this.b, "getVisibility: isYawing");
            }
            return false;
        }
        if ((bVar != null && bVar.C()) || (i = this.c) == 0 || i == -1) {
            return false;
        }
        if (bVar != null && bVar.I()) {
            if (gVar.d()) {
                gVar.e(this.b, "isShowChargeStationList visibility gone: ");
            }
            return false;
        }
        if (bVar != null && bVar.L()) {
            if (gVar.d()) {
                gVar.e(this.b, "isShowParkRecList visibility gone: ");
            }
            return false;
        }
        return b(this.c);
    }
}
