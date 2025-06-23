package com.baidu.navisdk.ui.routeguide.ace;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import android.os.Message;
import androidx.lifecycle.MutableLiveData;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes8.dex */
public final class a {
    private static volatile a f;

    @OOXIXo
    public static final C0409a g = new C0409a(null);

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private final MutableLiveData<g> f8420a;

    @OOXIXo
    private final MutableLiveData<i> b;

    @OOXIXo
    private final MutableLiveData<f> c;

    @OOXIXo
    private final MutableLiveData<d> d;
    private final c e;

    /* renamed from: com.baidu.navisdk.ui.routeguide.ace.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0409a {
        private C0409a() {
        }

        @oOoXoXO
        public final a a() {
            if (a.f == null) {
                synchronized (a.class) {
                    try {
                        if (a.f == null) {
                            a.f = new a(null);
                        }
                        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return a.f;
        }

        public /* synthetic */ C0409a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements com.baidu.navisdk.module.pronavi.msg.c {
        public b() {
        }

        private final void b(Message message) {
            if (message.what == 4500 && message.arg2 == 2251 && com.baidu.navisdk.module.ace.d.values()[message.arg1] == com.baidu.navisdk.module.ace.d.Area_Enter) {
                com.baidu.navisdk.util.statistic.userop.b r = com.baidu.navisdk.util.statistic.userop.b.r();
                String a2 = a.this.d().a();
                StringBuilder sb = new StringBuilder();
                sb.append("");
                BNRouteGuider bNRouteGuider = BNRouteGuider.getInstance();
                IIX0o.oO(bNRouteGuider, "BNRouteGuider.getInstance()");
                sb.append(bNRouteGuider.getACEABTag());
                r.a("36.0.2.1432", a2, sb.toString());
            }
        }

        @Override // com.baidu.navisdk.module.pronavi.msg.c
        @OOXIXo
        public int[] a() {
            return new int[]{4500, 4501, 4502};
        }

        @Override // com.baidu.navisdk.module.pronavi.msg.c
        public void a(@OOXIXo Message message) {
            IIX0o.x0xO0oo(message, "message");
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ACE;
            if (gVar.d()) {
                gVar.e("RGACE", "receiveMsg(), message = " + message.what + " arg1 = " + message.arg1 + " arg2 = " + message.arg2);
            }
            b(message);
            if (a.this.i()) {
                return;
            }
            switch (message.what) {
                case 4500:
                    int i = message.arg2;
                    if (i == 2251 || i == 0) {
                        a.this.b(message.arg1);
                        return;
                    }
                    return;
                case 4501:
                    a.this.a(message.arg1, message.arg2);
                    return;
                case 4502:
                    a.this.b(message.arg1, message.arg2);
                    return;
                default:
                    return;
            }
        }
    }

    private a() {
        this.f8420a = new MutableLiveData<>();
        this.b = new MutableLiveData<>();
        this.c = new MutableLiveData<>();
        this.d = new MutableLiveData<>();
        this.e = new c(this);
    }

    @oOoXoXO
    public static final a m() {
        return g.a();
    }

    @OOXIXo
    public final MutableLiveData<d> c() {
        return this.d;
    }

    @OOXIXo
    public final e d() {
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getRouteInfoInUniform(47, bundle);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ACE;
        if (gVar.d()) {
            gVar.e("RGACE", "getPanelModel(), bundle = " + bundle);
        }
        return new e(bundle.getString(MapBundleKey.MapObjKey.OBJ_BID), bundle.getString("content"), bundle.getString("url"), bundle.getString("voice"));
    }

    @OOXIXo
    public final MutableLiveData<i> e() {
        return this.b;
    }

    @OOXIXo
    public final MutableLiveData<f> f() {
        return this.c;
    }

    @OOXIXo
    public final MutableLiveData<g> g() {
        return this.f8420a;
    }

    public final void h() {
        this.e.d();
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V, "BNavigator.getInstance()");
        com.baidu.navisdk.pronavi.ui.base.b s = V.s();
        if (s != null) {
            s.a(new b());
        }
        if (i()) {
            return;
        }
        this.f8420a.setValue(new g(false, false, false, 4, null));
    }

    public final boolean i() {
        int b2 = com.baidu.navisdk.module.vehiclemanager.b.i().b();
        if (b2 == 3 || b2 == 2) {
            return true;
        }
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V, "BNavigator.getInstance()");
        if (V.E()) {
            return true;
        }
        BNRouteGuider bNRouteGuider = BNRouteGuider.getInstance();
        IIX0o.oO(bNRouteGuider, "BNRouteGuider.getInstance()");
        if (bNRouteGuider.getACEABTag() == 1) {
            return true;
        }
        return false;
    }

    public final void j() {
        if (i()) {
            return;
        }
        this.e.g();
    }

    public final void k() {
        this.f8420a.setValue(new g(false, false, false, 7, null));
        this.b.setValue(null);
        this.c.setValue(null);
        this.d.setValue(null);
        this.e.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ACE;
        if (gVar.d()) {
            gVar.e("RGACE", "onSpeedChange(), minSpeed = " + i + " maxSpeed = " + i2);
        }
        this.c.setValue(new f(i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, int i2) {
        com.baidu.navisdk.module.ace.c cVar;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ACE;
        if (gVar.d()) {
            gVar.e("RGACE", "onLightStatusChange(), lightStatus = " + i + " lightNum =" + i2);
        }
        if (i2 <= 0) {
            cVar = com.baidu.navisdk.module.ace.c.INVALID;
        } else {
            cVar = com.baidu.navisdk.module.ace.c.values()[i];
        }
        this.d.setValue(new d(cVar, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ACE;
        if (gVar.d()) {
            gVar.e("RGACE", "onStatusChange(), status = " + i);
        }
        com.baidu.navisdk.module.ace.d dVar = com.baidu.navisdk.module.ace.d.values()[i];
        g value = this.f8420a.getValue();
        if (value == null) {
            value = new g(false, false, false, 4, null);
        }
        int i2 = com.baidu.navisdk.ui.routeguide.ace.b.f8422a[dVar.ordinal()];
        if (i2 == 1) {
            value.c(false);
            value.b(false);
        } else if (i2 == 2) {
            value.b(true);
        } else if (i2 == 3) {
            value.b(false);
        } else if (i2 == 4) {
            value.c(true);
        } else if (i2 == 5) {
            value.c(false);
        }
        value.a(com.baidu.navisdk.ui.routeguide.utils.b.s());
        this.f8420a.setValue(value);
        this.b.setValue(new i(value.b(), d()));
    }

    public /* synthetic */ a(IIXOooo iIXOooo) {
        this();
    }

    public final void a() {
        if (i()) {
            return;
        }
        g value = this.f8420a.getValue();
        if (value != null) {
            value.a(true);
        }
        this.f8420a.setValue(value);
    }

    public final void a(int i) {
        if (i()) {
            return;
        }
        this.e.a(i);
    }

    public final void b() {
        if (i()) {
            return;
        }
        g value = this.f8420a.getValue();
        if (value != null) {
            value.a(false);
        }
        this.f8420a.setValue(value);
    }
}
