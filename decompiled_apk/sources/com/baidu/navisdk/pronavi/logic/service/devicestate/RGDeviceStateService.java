package com.baidu.navisdk.pronavi.logic.service.devicestate;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.pronavi.data.model.d;
import com.baidu.navisdk.pronavi.logic.base.RGBaseLogicService;
import com.baidu.navisdk.pronavi.logic.base.a;
import com.baidu.navisdk.ui.routeguide.ace.g;
import com.baidu.navisdk.util.logic.j;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class RGDeviceStateService<C extends com.baidu.navisdk.pronavi.logic.base.a> extends RGBaseLogicService<C> {
    private final com.baidu.navisdk.pronavi.data.model.b m;

    /* loaded from: classes7.dex */
    public static final class a<T> implements Observer<d.a> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(d.a aVar) {
            RGDeviceStateService.this.a(aVar);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements Observer<g> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(g gVar) {
            RGDeviceStateService.this.a(gVar);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements Observer<Boolean> {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean it) {
            RGDeviceStateService.this.m.d().setValue(it);
            IIX0o.oO(it, "it");
            if (it.booleanValue()) {
                JNIGuidanceControl.getInstance().setBeiDouStatus(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGDeviceStateService(@OOXIXo C context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
        this.m = (com.baidu.navisdk.pronavi.data.model.b) ((com.baidu.navisdk.pronavi.logic.base.a) this.i).b(com.baidu.navisdk.pronavi.data.model.b.class);
    }

    @Override // com.baidu.navisdk.pronavi.logic.base.RGBaseLogicService, com.baidu.navisdk.pageframe.logic.BNLogicService, com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        MutableLiveData<g> g;
        super.g();
        ((d) ((com.baidu.navisdk.pronavi.logic.base.a) this.i).b(d.class)).a().observe(this, new a());
        com.baidu.navisdk.ui.routeguide.ace.a a2 = com.baidu.navisdk.ui.routeguide.ace.a.g.a();
        if (a2 != null && (g = a2.g()) != null) {
            g.observe(this, new b());
        }
        if (com.baidu.navisdk.module.cloudconfig.a.b().a("open_bei_dou_tag", true)) {
            j r = j.r();
            IIX0o.oO(r, "BNSysLocationManager.getInstance()");
            r.k().observe(this, new c());
        }
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "RGDeviceStateService";
    }

    @Override // com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    @oOoXoXO
    public h a(@OOXIXo com.baidu.navisdk.apicenter.a api) {
        IIX0o.x0xO0oo(api, "api");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "execute: " + api);
        }
        int d = api.d();
        if (d == 40001) {
            a(api.c("paramA"), api.c("paramB"));
            return null;
        }
        if (d != 40002) {
            return null;
        }
        a(api.b("paramA"));
        return null;
    }

    private final void a(int i, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "updateSatellite:" + i + ", " + i2 + TokenParser.SP);
        }
        Integer value = this.m.c().getValue();
        if (value == null || value.intValue() != i) {
            this.m.c().setValue(Integer.valueOf(i));
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > 15) {
            i2 = 15;
        }
        Integer value2 = this.m.b().getValue();
        if (value2 != null && value2.intValue() == i2) {
            return;
        }
        this.m.b().setValue(Integer.valueOf(i2));
    }

    private final void a(boolean z) {
        if (IIX0o.Oxx0IOOO(this.m.e().getValue(), Boolean.valueOf(z))) {
            return;
        }
        this.m.e().setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(d.a aVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "onUpdateIHighSpeedState:" + aVar + ", " + this.m.a().getValue() + TokenParser.SP);
        }
        if (aVar == d.a.ENTER) {
            Integer value = this.m.a().getValue();
            if (value != null && value.intValue() == 2) {
                return;
            }
            this.m.a().setValue(2);
            return;
        }
        Integer value2 = this.m.a().getValue();
        if (value2 != null && value2.intValue() == 2) {
            this.m.a().setValue(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(g gVar) {
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e(this.g, "onUpdateACEState:" + gVar + ", " + this.m.a().getValue() + TokenParser.SP);
        }
        if (gVar != null && !gVar.a()) {
            if (!gVar.c() && !gVar.b()) {
                Integer value = this.m.a().getValue();
                if (value != null && value.intValue() == 1) {
                    this.m.a().setValue(0);
                    return;
                }
                return;
            }
            Integer value2 = this.m.a().getValue();
            if (value2 != null && value2.intValue() == 1) {
                return;
            }
            this.m.a().setValue(1);
            return;
        }
        Integer value3 = this.m.a().getValue();
        if (value3 != null && value3.intValue() == 1) {
            this.m.a().setValue(0);
        }
    }
}
