package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import OXOo.OOXIXo;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.pronavi.data.model.d;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.BNLottieSpeedView;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class o extends com.baidu.navisdk.pronavi.ui.bucket.item.a {
    public ViewGroup f;
    public BNLottieSpeedView g;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b uiContext, @OOXIXo com.baidu.navisdk.pronavi.ui.bucket.config.d itemData) {
        super(uiContext, itemData);
        IIX0o.x0xO0oo(uiContext, "uiContext");
        IIX0o.x0xO0oo(itemData, "itemData");
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    @OOXIXo
    public View a(@OOXIXo ViewGroup parentView, int i, @OOXIXo Context context) {
        IIX0o.x0xO0oo(parentView, "parentView");
        IIX0o.x0xO0oo(context, "context");
        this.f = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        ViewGroup viewGroup = this.f;
        if (viewGroup == null) {
            IIX0o.XOxIOxOx("mContainerView");
        }
        viewGroup.setLayoutParams(layoutParams);
        this.g = new BNLottieSpeedView(context, null, 0, 6, null);
        ViewGroup viewGroup2 = this.f;
        if (viewGroup2 == null) {
            IIX0o.XOxIOxOx("mContainerView");
        }
        BNLottieSpeedView bNLottieSpeedView = this.g;
        if (bNLottieSpeedView == null) {
            IIX0o.XOxIOxOx("mSpeedView");
        }
        viewGroup2.addView(bNLottieSpeedView);
        ViewGroup viewGroup3 = this.f;
        if (viewGroup3 == null) {
            IIX0o.XOxIOxOx("mContainerView");
        }
        return viewGroup3;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        d.a aVar;
        com.baidu.navisdk.framework.lifecycle.b<d.a> a2;
        BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
        IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
        if (!bNCommSettingManager.isShowSpeedClock()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGLottieSpeedView", "show user setting not show");
            }
            return 8;
        }
        if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGLottieSpeedView", "visibility: not hasCalcRouteOk");
            }
            return 8;
        }
        com.baidu.navisdk.ui.routeguide.model.a0 I = com.baidu.navisdk.ui.routeguide.model.a0.I();
        IIX0o.oO(I, "RGSimpleGuideModel.getInstance()");
        if (I.D()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGLottieSpeedView", "visibility: isYawing");
            }
            return 8;
        }
        com.baidu.navisdk.module.pronavi.model.g o = com.baidu.navisdk.module.pronavi.model.g.o();
        IIX0o.oO(o, "RGAssistGuideModel.getInstance()");
        if (!o.i()) {
            com.baidu.navisdk.pronavi.ui.base.b uiContext = this.f7853a;
            IIX0o.oO(uiContext, "uiContext");
            if (!uiContext.z()) {
                com.baidu.navisdk.pronavi.ui.base.b uiContext2 = this.f7853a;
                IIX0o.oO(uiContext2, "uiContext");
                if (!uiContext2.B()) {
                    com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar4.d()) {
                        gVar4.e("RGLottieSpeedView", "visibility: not isCurCarSpeedVisiable");
                    }
                    return 8;
                }
            }
        }
        if (com.baidu.navisdk.module.pronavi.model.g.o().g()) {
            com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar5.d()) {
                gVar5.e("RGLottieSpeedView", "visibility: hasIntervalCamera");
            }
            return 8;
        }
        if (m.o.a() != 0) {
            com.baidu.navisdk.util.common.g gVar6 = com.baidu.navisdk.util.common.g.ACE;
            if (gVar6.d()) {
                gVar6.e("RGLottieSpeedView", "visibility: has greenLightSpeedView");
            }
            return 8;
        }
        com.baidu.navisdk.pronavi.data.model.d dVar = (com.baidu.navisdk.pronavi.data.model.d) this.f7853a.b(com.baidu.navisdk.pronavi.data.model.d.class);
        if (dVar != null && (a2 = dVar.a()) != null) {
            aVar = a2.getValue();
        } else {
            aVar = null;
        }
        if (aVar == d.a.ENTER) {
            com.baidu.navisdk.util.common.g gVar7 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar7.d()) {
                gVar7.e("RGLottieSpeedView", "visibility: is in highSpped");
            }
            return 8;
        }
        if (!this.f7853a.c(RGFSMTable.FsmState.SimpleGuide, RGFSMTable.FsmState.EnlargeRoadmap)) {
            return 8;
        }
        return 0;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean n() {
        return true;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        super.onVisibleChange(i);
        if (i == 0) {
            com.baidu.navisdk.module.pronavi.model.g o = com.baidu.navisdk.module.pronavi.model.g.o();
            IIX0o.oO(o, "RGAssistGuideModel.getInstance()");
            String speed = o.b();
            com.baidu.navisdk.module.pronavi.model.g o2 = com.baidu.navisdk.module.pronavi.model.g.o();
            IIX0o.oO(o2, "RGAssistGuideModel.getInstance()");
            boolean j = o2.j();
            BNLottieSpeedView bNLottieSpeedView = this.g;
            if (bNLottieSpeedView == null) {
                IIX0o.XOxIOxOx("mSpeedView");
            }
            IIX0o.oO(speed, "speed");
            bNLottieSpeedView.a(speed, j, null);
        }
    }

    public final void v() {
        boolean isVisible = isVisible();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGLottieSpeedView", "updateCurCarSpeed: " + isVisible);
        }
        com.baidu.navisdk.module.pronavi.model.g o = com.baidu.navisdk.module.pronavi.model.g.o();
        IIX0o.oO(o, "RGAssistGuideModel.getInstance()");
        String speed = o.b();
        com.baidu.navisdk.module.pronavi.model.g o2 = com.baidu.navisdk.module.pronavi.model.g.o();
        IIX0o.oO(o2, "RGAssistGuideModel.getInstance()");
        boolean j = o2.j();
        if (isVisible) {
            BNLottieSpeedView bNLottieSpeedView = this.g;
            if (bNLottieSpeedView == null) {
                IIX0o.XOxIOxOx("mSpeedView");
            }
            IIX0o.oO(speed, "speed");
            bNLottieSpeedView.a(speed, j, null);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public void a(boolean z) {
        if (isVisible()) {
            BNLottieSpeedView bNLottieSpeedView = this.g;
            if (bNLottieSpeedView == null) {
                IIX0o.XOxIOxOx("mSpeedView");
            }
            if (bNLottieSpeedView.a()) {
                BNLottieSpeedView bNLottieSpeedView2 = this.g;
                if (bNLottieSpeedView2 == null) {
                    IIX0o.XOxIOxOx("mSpeedView");
                }
                bNLottieSpeedView2.setLottieRes(z);
            }
        }
    }
}
