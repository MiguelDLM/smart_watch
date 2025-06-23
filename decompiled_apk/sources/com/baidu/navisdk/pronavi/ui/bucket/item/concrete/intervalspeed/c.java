package com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.pronavi.model.g;
import com.baidu.navisdk.pronavi.data.model.d;
import com.baidu.navisdk.ui.routeguide.ace.a;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.z;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.p;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class c extends com.baidu.navisdk.pronavi.ui.bucket.item.a {
    private d f;
    private boolean g;

    @OOXIXo
    private final LifecycleOwner h;

    /* loaded from: classes7.dex */
    public static final class a implements Observer<d.a> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@oOoXoXO d.a aVar) {
            c.this.v();
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

    /* renamed from: com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0341c implements z.i {
        public C0341c() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.z.i
        public final void a(int i, z.h hVar) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGHighSpeedIntervalView", "setIntervalCameraVisibility->animationEnd callback,animType=" + hVar);
            }
            if (hVar == z.h.EXIT) {
                c.this.w();
            }
        }
    }

    static {
        new b(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b uiContext, @oOoXoXO com.baidu.navisdk.pronavi.ui.bucket.config.d dVar, @OOXIXo LifecycleOwner owner) {
        super(uiContext, dVar);
        com.baidu.navisdk.framework.lifecycle.b<d.a> a2;
        IIX0o.x0xO0oo(uiContext, "uiContext");
        IIX0o.x0xO0oo(owner, "owner");
        this.h = owner;
        com.baidu.navisdk.pronavi.data.model.d dVar2 = (com.baidu.navisdk.pronavi.data.model.d) uiContext.b(com.baidu.navisdk.pronavi.data.model.d.class);
        if (dVar2 != null && (a2 = dVar2.a()) != null) {
            a2.observe(owner, new a());
        }
    }

    private final void b(Bundle bundle) {
        d dVar = this.f;
        if (dVar != null) {
            IIX0o.ooOOo0oXI(dVar);
            dVar.a(bundle);
            return;
        }
        if (bundle != null && bundle.getInt("KEY_TYPE", 0) == 4383) {
            int i = bundle.getInt("KEY_INTERVAL_CAMERA_SPEED_LIMIT", 0);
            g o = g.o();
            IIX0o.oO(o, "RGAssistGuideModel.getInstance()");
            p f = o.f();
            IIX0o.oO(f, "RGAssistGuideModel.getIn…lastestIntervalCameraData");
            f.c(i);
            int i2 = bundle.getInt("KEY_INTERVAL_CAMERA_LENGTH", -1);
            g o2 = g.o();
            IIX0o.oO(o2, "RGAssistGuideModel.getInstance()");
            p f2 = o2.f();
            IIX0o.oO(f2, "RGAssistGuideModel.getIn…lastestIntervalCameraData");
            f2.a(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        d dVar = this.f;
        if (dVar != null) {
            IIX0o.ooOOo0oXI(dVar);
            dVar.a();
        }
        a.C0409a c0409a = com.baidu.navisdk.ui.routeguide.ace.a.g;
        com.baidu.navisdk.ui.routeguide.ace.a a2 = c0409a.a();
        IIX0o.ooOOo0oXI(a2);
        if (a2.g() != null) {
            com.baidu.navisdk.ui.routeguide.ace.a a3 = c0409a.a();
            IIX0o.ooOOo0oXI(a3);
            if (a3.g().getValue() != null) {
                com.baidu.navisdk.ui.routeguide.ace.a a4 = c0409a.a();
                IIX0o.ooOOo0oXI(a4);
                com.baidu.navisdk.ui.routeguide.ace.g value = a4.g().getValue();
                IIX0o.ooOOo0oXI(value);
                if (value.c()) {
                    this.f7853a.j().e("RGBucketGroupComponent").a(2017).a(Boolean.TRUE).b((Object) 2).a();
                    return;
                } else if (value.b()) {
                    this.f7853a.j().e("RGBucketGroupComponent").a(2017).a(Boolean.TRUE).b((Object) 1).a();
                    return;
                } else {
                    this.f7853a.j().e("RGBucketGroupComponent").a(1017).a((Object) 2).a();
                    return;
                }
            }
        }
        this.f7853a.j().e("RGBucketGroupComponent").a(1017).a((Object) 2).a();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        d.a aVar;
        com.baidu.navisdk.framework.lifecycle.b<d.a> a2;
        if (j() || !BNSettingManager.isMeasurementEnable() || !com.baidu.navisdk.ui.routeguide.b.V().x()) {
            return 8;
        }
        if (!g.o().g()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighSpeedIntervalView", "visibility: not hasIntervalCamera");
            }
            return 8;
        }
        a0 I = a0.I();
        IIX0o.oO(I, "RGSimpleGuideModel.getInstance()");
        if (I.D()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGHighSpeedIntervalView", "visibility: isYawing");
            }
            return 8;
        }
        com.baidu.navisdk.pronavi.data.model.d dVar = (com.baidu.navisdk.pronavi.data.model.d) this.f7853a.b(com.baidu.navisdk.pronavi.data.model.d.class);
        if (dVar != null && (a2 = dVar.a()) != null) {
            aVar = a2.getValue();
        } else {
            aVar = null;
        }
        if (aVar != d.a.ENTER) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGHighSpeedIntervalView", "visibility: is not in highSpped");
            }
            return 8;
        }
        if (!b(RGFSMTable.FsmState.SimpleGuide, RGFSMTable.FsmState.EnlargeRoadmap)) {
            return 8;
        }
        return 0;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public boolean isInterceptSetVisible(int i) {
        return i == 8;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean m() {
        return false;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean n() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onDestroy() {
        super.onDestroy();
        d dVar = this.f;
        if (dVar != null) {
            IIX0o.ooOOo0oXI(dVar);
            dVar.b();
            this.f = null;
        }
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onInterceptSetVisible(@oOoXoXO View view, int i) {
        super.onInterceptSetVisible(view, i);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighSpeedIntervalView", "onInterceptSetVisible: " + i);
        }
        if (this.g) {
            d dVar = this.f;
            if (dVar != null) {
                dVar.a(new C0341c());
            }
        } else {
            w();
        }
        this.g = false;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        super.onVisibleChange(i);
        if (i == 0) {
            d dVar = this.f;
            if (dVar != null) {
                IIX0o.ooOOo0oXI(dVar);
                dVar.c();
                d dVar2 = this.f;
                IIX0o.ooOOo0oXI(dVar2);
                dVar2.d();
            }
            this.f7853a.j().e("RGBucketGroupComponent").a(1017).a((Object) 2).a();
            this.f7853a.j().e("RGBucketGroupComponent").a(2017).a(Boolean.FALSE).a();
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.19.1", "0");
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.19.1", "1");
        }
        this.g = false;
    }

    public final void v() {
        this.f7853a.j().e("RGBucketGroupComponent").a(1017).a((Object) 3).a();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    @OOXIXo
    public View a(@OOXIXo ViewGroup parentView, int i, @OOXIXo Context context) {
        IIX0o.x0xO0oo(parentView, "parentView");
        IIX0o.x0xO0oo(context, "context");
        View viewGroup = JarUtils.inflate(context, R.layout.bnav_high_speed_interval_camera_layout, parentView, false);
        this.f = new d(context, viewGroup, 1);
        IIX0o.oO(viewGroup, "viewGroup");
        return viewGroup;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int a(int i, boolean z) {
        if (i != 2) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_4dp);
        }
        return 0;
    }

    public final void a(@OOXIXo Bundle bundle) {
        IIX0o.x0xO0oo(bundle, "bundle");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighSpeedIntervalView", "updatePanel: " + bundle + "mIntervalSpeedHolder = " + this.f);
        }
        int i = bundle.getInt("KEY_TYPE");
        if (i == 4383) {
            refreshVisible();
        } else if (i == 4385) {
            this.g = true;
            refreshVisible();
        }
        b(bundle);
    }
}
