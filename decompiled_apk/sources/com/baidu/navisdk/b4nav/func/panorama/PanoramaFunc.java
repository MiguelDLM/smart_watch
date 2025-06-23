package com.baidu.navisdk.b4nav.func.panorama;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.baidunavis.maplayer.i;
import com.baidu.navisdk.b4nav.framework.func.CoreFunc;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.util.common.g;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public class PanoramaFunc extends CoreFunc<com.baidu.navisdk.b4nav.func.panorama.a> {
    private final MutableLiveData<Boolean> m;
    private volatile boolean n;
    private boolean o;

    /* loaded from: classes7.dex */
    public static final class a implements i {
        final /* synthetic */ com.baidu.baidunavis.maplayer.d b;

        public a(com.baidu.baidunavis.maplayer.d dVar) {
            this.b = dVar;
        }

        @Override // com.baidu.baidunavis.maplayer.i
        public boolean a(int i, int i2, @oOoXoXO com.baidu.nplatform.comapi.basestruct.c cVar) {
            return false;
        }

        @Override // com.baidu.baidunavis.maplayer.i
        public boolean a(@oOoXoXO com.baidu.nplatform.comapi.basestruct.c cVar) {
            return false;
        }

        @Override // com.baidu.baidunavis.maplayer.i
        public boolean a(int i) {
            g gVar = g.B4NAV;
            if (gVar.d()) {
                gVar.e(((Func) PanoramaFunc.this).g, "tapDestBubble --> bubbleClickable = " + PanoramaFunc.this.n);
            }
            if (!PanoramaFunc.this.n) {
                return false;
            }
            Object a2 = this.b.a("panorama_info");
            if (gVar.d()) {
                gVar.e(((Func) PanoramaFunc.this).g, "tapDestBubble --> panoramaInfo = " + a2);
            }
            if (a2 instanceof com.baidu.navisdk.b4nav.data.panorama.a) {
                com.baidu.navisdk.b4nav.data.panorama.a aVar = (com.baidu.navisdk.b4nav.data.panorama.a) a2;
                if (!TextUtils.isEmpty(aVar.a())) {
                    com.baidu.navisdk.util.statistic.userop.b.r().a("2.16.10", "1", String.valueOf(PanoramaFunc.b(PanoramaFunc.this).o() - 1));
                    Bundle bundle = new Bundle();
                    bundle.putString("openapi", aVar.a());
                    com.baidu.navisdk.framework.b.a(32, bundle);
                }
            }
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements Observer<Boolean> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            PanoramaFunc panoramaFunc = PanoramaFunc.this;
            panoramaFunc.a(bool, PanoramaFunc.c(panoramaFunc).b().getValue());
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements Observer<com.baidu.baidunavis.maplayer.d> {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(com.baidu.baidunavis.maplayer.d dVar) {
            PanoramaFunc panoramaFunc = PanoramaFunc.this;
            panoramaFunc.a(PanoramaFunc.c(panoramaFunc).c().getValue(), dVar);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends com.baidu.navisdk.b4nav.service.rpmsg.c {
        public d() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.c
        @OOXIXo
        public String a() {
            String TAG = ((Func) PanoramaFunc.this).g;
            IIX0o.oO(TAG, "TAG");
            return TAG;
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public e() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        @OOXIXo
        public String a() {
            String TAG = ((Func) PanoramaFunc.this).g;
            IIX0o.oO(TAG, "TAG");
            return TAG;
        }
    }

    /* loaded from: classes7.dex */
    public static final class f extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public f() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        @OOXIXo
        public String a() {
            String TAG = ((Func) PanoramaFunc.this).g;
            IIX0o.oO(TAG, "TAG");
            return TAG;
        }
    }

    public static final /* synthetic */ com.baidu.navisdk.b4nav.c b(PanoramaFunc panoramaFunc) {
        return (com.baidu.navisdk.b4nav.c) panoramaFunc.i;
    }

    public static final /* synthetic */ com.baidu.navisdk.b4nav.func.panorama.a c(PanoramaFunc panoramaFunc) {
        return (com.baidu.navisdk.b4nav.func.panorama.a) panoramaFunc.j;
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        r();
        ((com.baidu.navisdk.b4nav.func.panorama.a) this.j).c().observe(this, new b());
        ((com.baidu.navisdk.b4nav.func.panorama.a) this.j).b().observe(this, new c());
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        com.baidu.baidunavis.maplayer.e.k().e();
        ((com.baidu.navisdk.b4nav.func.panorama.a) this.j).d();
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @oOoXoXO
    public String o() {
        return "PanoramaFunc";
    }

    public final void r() {
        a(1000, new d());
        a(4001, new e());
        a(4007, new f());
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc
    public void b(boolean z) {
        super.b(z);
        ((com.baidu.navisdk.b4nav.func.panorama.a) this.j).c().setValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Boolean bool, com.baidu.baidunavis.maplayer.d dVar) {
        g gVar = g.B4NAV;
        if (gVar.d()) {
            gVar.e(this.g, "judgeDestBubble --> showPanoramaBubble = " + bool + ", overlayItem = " + dVar);
        }
        if (bool != null && bool.booleanValue() && dVar != null) {
            com.baidu.baidunavis.maplayer.e.k().a(dVar, new a(dVar));
            BNMapController.getInstance().setEndNodeIconVisible(false);
            this.m.setValue(Boolean.TRUE);
            if (this.o) {
                return;
            }
            this.o = true;
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.16.10", "0", String.valueOf(((com.baidu.navisdk.b4nav.c) this.i).o() - 1));
            return;
        }
        com.baidu.baidunavis.maplayer.e.k().e();
        BNMapController.getInstance().setEndNodeIconVisible(true);
        this.m.setValue(Boolean.FALSE);
    }
}
