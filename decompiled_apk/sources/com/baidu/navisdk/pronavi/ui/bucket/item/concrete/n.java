package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.pronavi.data.model.d;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMACESpeedView;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class n extends com.baidu.navisdk.pronavi.ui.bucket.item.a {
    public ViewGroup f;
    public RGMMACESpeedView g;

    @OOXIXo
    private final LifecycleOwner h;

    /* loaded from: classes7.dex */
    public static final class a implements Observer<d.a> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@oOoXoXO d.a aVar) {
            n.this.v();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new b(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b uiContext, @OOXIXo com.baidu.navisdk.pronavi.ui.bucket.config.d itemData, @OOXIXo LifecycleOwner owner) {
        super(uiContext, itemData);
        com.baidu.navisdk.framework.lifecycle.b<d.a> a2;
        IIX0o.x0xO0oo(uiContext, "uiContext");
        IIX0o.x0xO0oo(itemData, "itemData");
        IIX0o.x0xO0oo(owner, "owner");
        this.h = owner;
        com.baidu.navisdk.pronavi.data.model.d dVar = (com.baidu.navisdk.pronavi.data.model.d) uiContext.b(com.baidu.navisdk.pronavi.data.model.d.class);
        if (dVar != null && (a2 = dVar.a()) != null) {
            a2.observe(owner, new a());
        }
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
        this.g = new RGMMACESpeedView(context, null, 0, 6, null);
        ViewGroup viewGroup2 = this.f;
        if (viewGroup2 == null) {
            IIX0o.XOxIOxOx("mContainerView");
        }
        RGMMACESpeedView rGMMACESpeedView = this.g;
        if (rGMMACESpeedView == null) {
            IIX0o.XOxIOxOx("mSpeedView");
        }
        viewGroup2.addView(rGMMACESpeedView);
        ViewGroup viewGroup3 = this.f;
        if (viewGroup3 == null) {
            IIX0o.XOxIOxOx("mContainerView");
        }
        return viewGroup3;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        d.a aVar;
        com.baidu.navisdk.framework.interfaces.pronavi.h hVar;
        com.baidu.navisdk.framework.lifecycle.b<d.a> a2;
        BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
        IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
        if (!bNCommSettingManager.isShowSpeedClock()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighSpeedView", "show user setting not show");
            }
            return 8;
        }
        if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGHighSpeedView", "visibility: not hasCalcRouteOk");
            }
            return 8;
        }
        com.baidu.navisdk.ui.routeguide.model.a0 I = com.baidu.navisdk.ui.routeguide.model.a0.I();
        IIX0o.oO(I, "RGSimpleGuideModel.getInstance()");
        if (I.D()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGHighSpeedView", "visibility: isYawing");
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
                        gVar4.e("RGHighSpeedView", "visibility: not isCurCarSpeedVisiable");
                    }
                    return 8;
                }
            }
        }
        if (com.baidu.navisdk.module.pronavi.model.g.o().g()) {
            com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar5.d()) {
                gVar5.e("RGHighSpeedView", "visibility: hasIntervalCamera");
            }
            return 8;
        }
        if (m.o.a() != 0) {
            com.baidu.navisdk.util.common.g gVar6 = com.baidu.navisdk.util.common.g.ACE;
            if (gVar6.d()) {
                gVar6.e("RGHighSpeedView", "visibility: has greenLightSpeedView");
            }
            return 8;
        }
        com.baidu.navisdk.pronavi.data.model.d dVar = (com.baidu.navisdk.pronavi.data.model.d) this.f7853a.b(com.baidu.navisdk.pronavi.data.model.d.class);
        com.baidu.navisdk.framework.interfaces.pronavi.h hVar2 = null;
        if (dVar != null && (a2 = dVar.a()) != null) {
            aVar = a2.getValue();
        } else {
            aVar = null;
        }
        if (aVar != d.a.ENTER) {
            com.baidu.navisdk.util.common.g gVar7 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar7.d()) {
                gVar7.e("RGHighSpeedView", "visibility: is not in highSpped");
            }
            return 8;
        }
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V, "BNavigator.getInstance()");
        com.baidu.navisdk.ui.routeguide.navicenter.c j = V.j();
        if (j != null) {
            hVar = j.e();
        } else {
            hVar = null;
        }
        if (hVar != null) {
            com.baidu.navisdk.ui.routeguide.b V2 = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V2, "BNavigator.getInstance()");
            com.baidu.navisdk.ui.routeguide.navicenter.c j2 = V2.j();
            if (j2 != null) {
                hVar2 = j2.e();
            }
            if (hVar2 != null) {
                if (((com.baidu.navisdk.ui.routeguide.control.j) hVar2).c() == 227) {
                    com.baidu.navisdk.util.common.g gVar8 = com.baidu.navisdk.util.common.g.ACE;
                    if (gVar8.d()) {
                        gVar8.e("RGHighSpeedView", "visibility: has speedlogo");
                    }
                    return 8;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.navisdk.ui.routeguide.control.RGCurrentCarLogoController");
            }
        }
        if (!this.f7853a.c(RGFSMTable.FsmState.SimpleGuide, RGFSMTable.FsmState.EnlargeRoadmap)) {
            return 8;
        }
        return 0;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        super.onVisibleChange(i);
        if (i == 0) {
            com.baidu.navisdk.module.pronavi.model.g o = com.baidu.navisdk.module.pronavi.model.g.o();
            IIX0o.oO(o, "RGAssistGuideModel.getInstance()");
            String speed = o.b();
            int i2 = com.baidu.navisdk.module.pronavi.model.g.o().k;
            RGMMACESpeedView rGMMACESpeedView = this.g;
            if (rGMMACESpeedView == null) {
                IIX0o.XOxIOxOx("mSpeedView");
            }
            IIX0o.oO(speed, "speed");
            rGMMACESpeedView.a(speed, i2);
        }
    }

    public final void v() {
        this.f7853a.j().e("RGBucketGroupComponent").a(1017).a((Object) 2).a();
    }

    public final void w() {
        boolean isVisible = isVisible();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighSpeedView", "updateCurCarSpeed: " + isVisible);
        }
        com.baidu.navisdk.module.pronavi.model.g o = com.baidu.navisdk.module.pronavi.model.g.o();
        IIX0o.oO(o, "RGAssistGuideModel.getInstance()");
        String speed = o.b();
        int i = com.baidu.navisdk.module.pronavi.model.g.o().k;
        if (isVisible) {
            RGMMACESpeedView rGMMACESpeedView = this.g;
            if (rGMMACESpeedView == null) {
                IIX0o.XOxIOxOx("mSpeedView");
            }
            IIX0o.oO(speed, "speed");
            rGMMACESpeedView.a(speed, i);
        }
    }
}
