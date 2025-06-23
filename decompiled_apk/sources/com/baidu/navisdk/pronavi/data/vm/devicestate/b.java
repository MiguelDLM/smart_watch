package com.baidu.navisdk.pronavi.data.vm.devicestate;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.graphics.Color;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class b extends com.baidu.navisdk.pronavi.base.b {

    @OOXIXo
    private final X0IIOO b = XIxXXX0x0.oIX0oI(c.f7690a);

    @OOXIXo
    private final X0IIOO c = XIxXXX0x0.oIX0oI(k.f7698a);

    @OOXIXo
    private final X0IIOO d = XIxXXX0x0.oIX0oI(C0314b.f7689a);

    @OOXIXo
    private final X0IIOO e = XIxXXX0x0.oIX0oI(l.f7699a);

    @OOXIXo
    private final X0IIOO f = XIxXXX0x0.oIX0oI(d.f7691a);

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* renamed from: com.baidu.navisdk.pronavi.data.vm.devicestate.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0314b extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.a<com.baidu.navisdk.pronavi.data.vm.devicestate.a>> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0314b f7689a = new C0314b();

        public C0314b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.a<com.baidu.navisdk.pronavi.data.vm.devicestate.a> invoke() {
            return new com.baidu.navisdk.framework.lifecycle.a<>();
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.a<com.baidu.navisdk.pronavi.data.vm.devicestate.c>> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f7690a = new c();

        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.a<com.baidu.navisdk.pronavi.data.vm.devicestate.c> invoke() {
            return new com.baidu.navisdk.framework.lifecycle.a<>();
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.b<com.baidu.navisdk.pronavi.data.vm.devicestate.d>> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f7691a = new d();

        public d() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<com.baidu.navisdk.pronavi.data.vm.devicestate.d> invoke() {
            return new com.baidu.navisdk.framework.lifecycle.b<>();
        }
    }

    /* loaded from: classes7.dex */
    public static final class e<T> implements Observer<Integer> {
        public e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer vdrState) {
            b bVar = b.this;
            IIX0o.oO(vdrState, "vdrState");
            bVar.d(vdrState.intValue());
        }
    }

    /* loaded from: classes7.dex */
    public static final class f<T> implements Observer<Integer> {
        public f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer areaState) {
            b bVar = b.this;
            IIX0o.oO(areaState, "areaState");
            bVar.b(areaState.intValue());
        }
    }

    /* loaded from: classes7.dex */
    public static final class g<T> implements Observer<Boolean> {
        public g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean support) {
            com.baidu.navisdk.pronavi.data.vm.devicestate.c value = b.this.d().getValue();
            if (value != null) {
                IIX0o.oO(support, "support");
                value.b(support.booleanValue());
            }
            com.baidu.navisdk.pronavi.data.vm.devicestate.c value2 = b.this.d().getValue();
            if (value2 != null) {
                b.this.c(value2.b());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class h<T> implements Observer<Integer> {
        public h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer gpsSignal) {
            b bVar = b.this;
            IIX0o.oO(gpsSignal, "gpsSignal");
            bVar.c(gpsSignal.intValue());
        }
    }

    /* loaded from: classes7.dex */
    public static final class i<T> implements Observer<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.pronavi.data.model.i f7696a;
        final /* synthetic */ b b;

        public i(com.baidu.navisdk.pronavi.data.model.i iVar, b bVar) {
            this.f7696a = iVar;
            this.b = bVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer voiceMode) {
            b bVar = this.b;
            IIX0o.oO(voiceMode, "voiceMode");
            bVar.a(voiceMode.intValue(), this.f7696a.a().getValue());
        }
    }

    /* loaded from: classes7.dex */
    public static final class j<T> implements Observer<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.pronavi.data.model.i f7697a;
        final /* synthetic */ b b;

        public j(com.baidu.navisdk.pronavi.data.model.i iVar, b bVar) {
            this.f7697a = iVar;
            this.b = bVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            b bVar = this.b;
            Integer value = this.f7697a.b().getValue();
            IIX0o.ooOOo0oXI(value);
            IIX0o.oO(value, "voiceM.voiceMode.value!!");
            bVar.a(value.intValue(), num);
        }
    }

    /* loaded from: classes7.dex */
    public static final class k extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.a<com.baidu.navisdk.pronavi.data.vm.devicestate.e>> {

        /* renamed from: a, reason: collision with root package name */
        public static final k f7698a = new k();

        public k() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.a<com.baidu.navisdk.pronavi.data.vm.devicestate.e> invoke() {
            return new com.baidu.navisdk.framework.lifecycle.a<>();
        }
    }

    /* loaded from: classes7.dex */
    public static final class l extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.a<com.baidu.navisdk.pronavi.data.vm.devicestate.f>> {

        /* renamed from: a, reason: collision with root package name */
        public static final l f7699a = new l();

        public l() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.a<com.baidu.navisdk.pronavi.data.vm.devicestate.f> invoke() {
            return new com.baidu.navisdk.framework.lifecycle.a<>();
        }
    }

    static {
        new a(null);
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.a<com.baidu.navisdk.pronavi.data.vm.devicestate.a> c() {
        return (com.baidu.navisdk.framework.lifecycle.a) this.d.getValue();
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.a<com.baidu.navisdk.pronavi.data.vm.devicestate.c> d() {
        return (com.baidu.navisdk.framework.lifecycle.a) this.b.getValue();
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<com.baidu.navisdk.pronavi.data.vm.devicestate.d> e() {
        return (com.baidu.navisdk.framework.lifecycle.b) this.f.getValue();
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.a<com.baidu.navisdk.pronavi.data.vm.devicestate.e> f() {
        return (com.baidu.navisdk.framework.lifecycle.a) this.c.getValue();
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.a<com.baidu.navisdk.pronavi.data.vm.devicestate.f> g() {
        return (com.baidu.navisdk.framework.lifecycle.a) this.e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDeviceStateViewVM", "onChangeCurAreaState: " + i2 + ", " + c().getValue());
        }
        com.baidu.navisdk.pronavi.data.vm.devicestate.a value = c().getValue();
        if (value == null) {
            value = new com.baidu.navisdk.pronavi.data.vm.devicestate.a(false, 0, 0, true);
        }
        IIX0o.oO(value, "this.curAreaStateData.va…EA_STATE_NORMAL, 0, true)");
        if (value.b() == i2) {
            return;
        }
        value.b(i2);
        value.a(true);
        if (i2 == 1) {
            value.a(R.drawable.bnav_rg_ic_apollo);
            value.b(false);
        } else if (i2 != 2) {
            value.a(0);
            value.a(false);
            value.b(true);
        } else {
            value.a(R.drawable.bnav_rg_ic_apollo);
            value.b(true);
        }
        c().setValue(value);
        com.baidu.navisdk.pronavi.data.vm.devicestate.c value2 = d().getValue();
        c(value2 != null ? value2.b() : 0);
        com.baidu.navisdk.pronavi.data.vm.devicestate.e value3 = f().getValue();
        if (value3 == null || !value3.c()) {
            return;
        }
        com.baidu.navisdk.pronavi.data.vm.devicestate.e value4 = f().getValue();
        IIX0o.ooOOo0oXI(value4);
        d(value4.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDeviceStateViewVM", "onChangeVdrState: " + i2 + ", " + f().getValue());
        }
        com.baidu.navisdk.pronavi.data.vm.devicestate.e value = f().getValue();
        String str = "";
        boolean z = false;
        if (value == null) {
            value = new com.baidu.navisdk.pronavi.data.vm.devicestate.e(false, "", i2);
        }
        IIX0o.oO(value, "this.vdrData.value ?: RG…Data(false, \"\", vdrState)");
        value.a(i2);
        if (i2 != 0 && i2 != -1) {
            value.a(true);
            com.baidu.navisdk.pronavi.data.vm.devicestate.a value2 = c().getValue();
            if (value2 == null || !value2.c()) {
                str = JarUtils.getResources().getString(R.string.nsdk_vdr_location_tips);
                IIX0o.oO(str, "JarUtils.getResources().…g.nsdk_vdr_location_tips)");
            }
            value.a(str);
        } else {
            value.a(false);
        }
        f().setValue(value);
        com.baidu.navisdk.pronavi.data.vm.devicestate.c value3 = d().getValue();
        if (value3 != null) {
            value3.a(!value.c());
            d().setValue(value3);
        }
        com.baidu.navisdk.pronavi.data.vm.devicestate.f value4 = g().getValue();
        if (value4 != null) {
            boolean z2 = (value.c() || value4.a() == 0) ? false : true;
            if (value4.b() != z2) {
                value4.a(z2);
                g().setValue(value4);
            }
        }
        com.baidu.navisdk.pronavi.data.vm.devicestate.d value5 = e().getValue();
        if (value5 != null) {
            if (!value.c() && value5.b()) {
                z = true;
            }
            if (value5.b() != z) {
                value5.a(z);
                e().setValue(value5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(int i2) {
        String str;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDeviceStateViewVM", "onChangeSatelliteSignal: " + i2 + ", " + d().getValue());
        }
        com.baidu.navisdk.pronavi.data.vm.devicestate.c value = d().getValue();
        IIX0o.ooOOo0oXI(value);
        IIX0o.oO(value, "satelliteSignalData.value!!");
        com.baidu.navisdk.pronavi.data.vm.devicestate.c cVar = value;
        cVar.b(i2);
        com.baidu.navisdk.pronavi.data.vm.devicestate.e value2 = f().getValue();
        cVar.a(value2 == null || !value2.c());
        com.baidu.navisdk.pronavi.data.vm.devicestate.a value3 = c().getValue();
        boolean z = value3 == null || value3.b() == 0;
        str = "";
        if (i2 == 0) {
            cVar.a(R.drawable.nsdk_drawable_rg_ic_satellite_red);
            com.baidu.navisdk.module.newguide.a e2 = com.baidu.navisdk.module.newguide.a.e();
            IIX0o.oO(e2, "RGNewOldFuncController.getInstance()");
            if (!e2.d()) {
                str = "弱";
            } else if (z) {
                str = "定位信号弱";
            }
            cVar.a(str);
            cVar.c(Color.parseColor("#f44335"));
        } else if (i2 != 1) {
            if (cVar.e() && com.baidu.navisdk.j.d()) {
                cVar.a(R.drawable.nsdk_drawable_rg_ic_satellite_beidou);
                cVar.a("北斗定位");
                cVar.c(Color.parseColor("#ffffff"));
            } else {
                cVar.a(R.drawable.nsdk_drawable_rg_ic_satellite_green);
                cVar.a("强");
                cVar.c(Color.parseColor("#62d336"));
            }
            if (!z) {
                cVar.a("");
            }
        } else {
            cVar.a(R.drawable.nsdk_drawable_rg_ic_satellite_yellow);
            cVar.a(z ? "中" : "");
            cVar.c(Color.parseColor("#fbe000"));
        }
        d().setValue(cVar);
    }

    @Override // com.baidu.navisdk.pageframe.store.data.c
    public void a(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar) {
        super.a((b) bVar);
        com.baidu.navisdk.pronavi.ui.base.b a2 = a();
        if (a2 != null) {
            com.baidu.navisdk.framework.lifecycle.a<com.baidu.navisdk.pronavi.data.vm.devicestate.c> d2 = d();
            com.baidu.navisdk.pronavi.data.vm.devicestate.c value = d().getValue();
            if (value == null) {
                value = new com.baidu.navisdk.pronavi.data.vm.devicestate.c(false, 0, "", 0, 0, false);
            }
            d2.setValue(value);
            com.baidu.navisdk.pronavi.data.model.h hVar = (com.baidu.navisdk.pronavi.data.model.h) a2.b(com.baidu.navisdk.pronavi.data.model.h.class);
            if (hVar != null) {
                f().addSource(hVar.a(), new e());
            }
            com.baidu.navisdk.pronavi.data.model.b bVar2 = (com.baidu.navisdk.pronavi.data.model.b) a2.b(com.baidu.navisdk.pronavi.data.model.b.class);
            if (bVar2 != null) {
                c().addSource(bVar2.a(), new f());
                d().addSource(bVar2.d(), new g());
                d().addSource(bVar2.c(), new h());
            }
            com.baidu.navisdk.pronavi.data.model.i iVar = (com.baidu.navisdk.pronavi.data.model.i) a2.b(com.baidu.navisdk.pronavi.data.model.i.class);
            if (iVar != null) {
                g().addSource(iVar.b(), new i(iVar, this));
                g().addSource(iVar.a(), new j(iVar, this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i2, Integer num) {
        com.baidu.navisdk.pronavi.data.vm.devicestate.e value;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDeviceStateViewVM", "onChangeVoice: " + i2 + ", " + num + "， " + g().getValue());
        }
        com.baidu.navisdk.pronavi.data.vm.devicestate.f value2 = g().getValue();
        boolean z = false;
        if (value2 == null) {
            value2 = new com.baidu.navisdk.pronavi.data.vm.devicestate.f(false, 0);
        }
        IIX0o.oO(value2, "volumeIconData.value ?: RGVolumeIconData(false, 0)");
        value2.a(0);
        if ((num != null ? num.intValue() : 1) <= 0) {
            value2.a(R.drawable.nsdk_rg_ic_zero_volume);
        } else if (i2 == 2) {
            value2.a(R.drawable.nsdk_rg_ic_no_volume);
        } else if (i2 == 3) {
            value2.a(R.drawable.nsdk_rg_ic_play_warning_volume);
        }
        if (value2.a() != 0 && ((value = f().getValue()) == null || !value.c())) {
            z = true;
        }
        value2.a(z);
        g().setValue(value2);
    }

    public final void a(int i2) {
        com.baidu.navisdk.pronavi.data.vm.devicestate.e value;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDeviceStateViewVM", "updateServiceSubscribeNum: " + i2);
        }
        com.baidu.navisdk.module.newguide.a e2 = com.baidu.navisdk.module.newguide.a.e();
        IIX0o.oO(e2, "RGNewOldFuncController.getInstance()");
        if (e2.d()) {
            return;
        }
        com.baidu.navisdk.pronavi.data.vm.devicestate.d value2 = e().getValue();
        boolean z = false;
        if (value2 == null) {
            value2 = new com.baidu.navisdk.pronavi.data.vm.devicestate.d(false, i2);
        }
        IIX0o.oO(value2, "serviceSubscribeData.val…Data(false, subscribeNum)");
        value2.a(i2);
        if (i2 > 0 && ((value = f().getValue()) == null || !value.c())) {
            z = true;
        }
        value2.a(z);
        e().setValue(value2);
    }
}
