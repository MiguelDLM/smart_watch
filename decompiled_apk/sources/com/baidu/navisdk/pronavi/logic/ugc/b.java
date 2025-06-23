package com.baidu.navisdk.pronavi.logic.ugc;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.text.TextUtils;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.ugc.replenishdetails.e;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import kotlin.LazyThreadSafetyMode;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private int f7798a;
    private String b;
    private int c;
    private final X0IIOO d = XIxXXX0x0.I0Io(LazyThreadSafetyMode.NONE, C0326b.f7799a);
    private final a.InterfaceC0201a e = new c();

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* renamed from: com.baidu.navisdk.pronavi.logic.ugc.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0326b extends Lambda implements oIX0oI<ArrayList<com.baidu.navisdk.pronavi.logic.ugc.a>> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0326b f7799a = new C0326b();

        public C0326b() {
            super(0);
        }

        @Override // Oox.oIX0oI
        @OOXIXo
        public final ArrayList<com.baidu.navisdk.pronavi.logic.ugc.a> invoke() {
            return new ArrayList<>(4);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements a.InterfaceC0201a {
        public c() {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(@OOXIXo Object event) {
            IIX0o.x0xO0oo(event, "event");
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("RGUgcReportBtnLogic", "onEvent: " + event);
            }
            if (event instanceof e) {
                e eVar = (e) event;
                if (eVar.b == 2) {
                    if (!eVar.f8239a && b.this.f7798a != eVar.e) {
                        return;
                    }
                    int i = R.drawable.nsdk_rg_ic_ugc_report_innavi;
                    String str = "上报";
                    if (!eVar.f8239a) {
                        b.this.f7798a = 0;
                    } else {
                        b.this.f7798a = eVar.e;
                        int i2 = eVar.c;
                        if (i2 > 0) {
                            i = i2;
                        }
                        if (!TextUtils.isEmpty(eVar.d)) {
                            str = eVar.d;
                            IIX0o.oO(str, "event.text");
                        }
                        if (eVar.e == 1) {
                            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.4", String.valueOf(eVar.b) + "", "6", null);
                        } else {
                            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.2", String.valueOf(eVar.b) + "", "3", null);
                        }
                    }
                    b.this.a(!eVar.f8239a, str, i);
                }
            }
        }
    }

    static {
        new a(null);
    }

    private final ArrayList<com.baidu.navisdk.pronavi.logic.ugc.a> c() {
        return (ArrayList) this.d.getValue();
    }

    private final void d() {
        for (com.baidu.navisdk.pronavi.logic.ugc.a aVar : c()) {
            int i = this.f7798a;
            String str = this.b;
            IIX0o.ooOOo0oXI(str);
            aVar.a(i, str, this.c);
        }
    }

    public final void b() {
        com.baidu.navisdk.framework.message.a.a().a(this.e, e.class, new Class[0]);
    }

    public final void a() {
        com.baidu.navisdk.framework.message.a.a().a(this.e);
        c().clear();
    }

    public final void a(@oOoXoXO com.baidu.navisdk.pronavi.logic.ugc.a aVar) {
        if (aVar == null || c().contains(aVar)) {
            return;
        }
        c().add(aVar);
        String str = this.b;
        if (str == null || str.length() == 0 || this.c == 0) {
            return;
        }
        int i = this.f7798a;
        String str2 = this.b;
        IIX0o.ooOOo0oXI(str2);
        aVar.a(i, str2, this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean z, String str, int i) {
        if (IIX0o.Oxx0IOOO(str, this.b) || i == this.c) {
            return;
        }
        this.b = str;
        this.c = i;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGUgcReportBtnLogic", "changeBtnState: " + this.f7798a + ", " + z + ", " + str + ", " + i);
        }
        d();
    }
}
