package com.baidu.navisdk.pronavi.ui.buttoncollect.naviplay;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.pronavi.data.model.i;
import com.baidu.navisdk.pronavi.style.d;
import com.baidu.navisdk.pronavi.style.f;
import com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.d;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Triple;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class a extends com.baidu.navisdk.pronavi.base.b {
    private final ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> b;
    private final X0IIOO c;
    private int d;
    private com.baidu.navisdk.pronavi.style.i.a e;

    /* renamed from: com.baidu.navisdk.pronavi.ui.buttoncollect.naviplay.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0348a {
        private C0348a() {
        }

        public /* synthetic */ C0348a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.a<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>>> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7906a = new b();

        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.a<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>> invoke() {
            return new com.baidu.navisdk.framework.lifecycle.a<>();
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends com.baidu.navisdk.pronavi.style.c {
        public c(Integer[] numArr) {
            super(numArr);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        @OOXIXo
        public String a() {
            return "FixedBtnCollectNaviPlayKey";
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void b(@oOoXoXO String str) {
            a aVar = a.this;
            aVar.b(aVar.d);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void c() {
        }

        @Override // com.baidu.navisdk.pronavi.style.c
        public boolean h(@oOoXoXO String str, @OOXIXo HashMap<String, ? super com.baidu.navisdk.pronavi.style.d> styleMap) {
            IIX0o.x0xO0oo(styleMap, "styleMap");
            a aVar = a.this;
            aVar.a(styleMap, aVar.d, this);
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T> implements Observer<Integer> {
        public d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer it) {
            a aVar = a.this;
            IIX0o.oO(it, "it");
            aVar.d = it.intValue();
            a.this.a(it.intValue());
        }
    }

    static {
        new C0348a(null);
    }

    public a() {
        ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> arrayList = new ArrayList<>(3);
        this.b = arrayList;
        this.c = XIxXXX0x0.oIX0oI(b.f7906a);
        this.d = -1;
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("");
        a(aVar, 0, this.d);
        arrayList.add(aVar);
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar2 = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("");
        a(aVar2, 3, this.d);
        arrayList.add(aVar2);
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar3 = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("");
        a(aVar3, 2, this.d);
        arrayList.add(aVar3);
        e();
    }

    private final String a(int i, int i2) {
        return i2 != 2 ? i2 != 3 ? i == i2 ? "VoiceModePanelPlayOn" : "VoiceModePanelPlayOff" : i == i2 ? "VoiceModePanelWarnOn" : "VoiceModePanelWarnOff" : i == i2 ? "VoiceModePanelQuietOn" : "VoiceModePanelQuietOff";
    }

    private final com.baidu.navisdk.framework.lifecycle.a<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>> d() {
        return (com.baidu.navisdk.framework.lifecycle.a) this.c.getValue();
    }

    private final void e() {
        if (this.e == null) {
            c cVar = new c(new Integer[0]);
            this.e = cVar;
            f.b.a("FixedBtnCollectNaviPlayKey", cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        for (com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar : this.b) {
            a(aVar, Integer.parseInt(aVar.e()), i);
        }
        d().setValue(this.b);
    }

    @oOoXoXO
    public final LiveData<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>> c() {
        return d();
    }

    @Override // com.baidu.navisdk.pageframe.store.data.c
    public void a(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar) {
        i iVar;
        super.a((a) bVar);
        if (bVar == null || (iVar = (i) bVar.b(i.class)) == null) {
            return;
        }
        d().addSource(iVar.b(), new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBtnCollectNaviPlayVM", "onChangeCurVoiceMode: " + i);
        }
        com.baidu.navisdk.pronavi.style.i.a aVar = this.e;
        if (aVar != null) {
            IIX0o.ooOOo0oXI(aVar);
            aVar.a("FixedBtnCollectNaviPlayKey");
        } else {
            b(i);
        }
    }

    private final void a(com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar, int i, int i2) {
        Triple a2 = d.a.a(com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.d.b, i, i2, false, 4, null);
        aVar.a(String.valueOf(i));
        aVar.a(((Number) a2.getFirst()).intValue());
        String string = JarUtils.getResources().getString(((Number) a2.getSecond()).intValue());
        IIX0o.oO(string, "JarUtils.getResources().getString(trip.second)");
        aVar.b(string);
        aVar.d(((Number) a2.getThird()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(HashMap<String, ? super com.baidu.navisdk.pronavi.style.d> hashMap, int i, com.baidu.navisdk.pronavi.style.c cVar) {
        for (com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar : this.b) {
            d.a f = cVar.f(a(i, Integer.parseInt(aVar.e())), hashMap);
            if (f != null) {
                aVar.a(f.c());
                aVar.d(f.d());
            }
        }
        d().setValue(this.b);
    }
}
