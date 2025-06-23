package com.baidu.navisdk.pronavi.hd.normal.map;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class a extends com.baidu.navisdk.pronavi.hd.b {

    /* renamed from: a, reason: collision with root package name */
    private int f7762a;
    private int b;
    private final float c = JarUtils.getResources().getDimension(R.dimen.navi_dimens_9dp);

    /* renamed from: com.baidu.navisdk.pronavi.hd.normal.map.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0323a {
        private C0323a() {
        }

        public /* synthetic */ C0323a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7763a = new b();

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends ViewOutlineProvider {
        public c() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@oOoXoXO View view, @oOoXoXO Outline outline) {
            if (outline != null) {
                outline.setRoundRect(0, 0, a.this.f7762a, a.this.b, a.this.c);
            }
        }
    }

    static {
        new C0323a(null);
    }

    @Override // com.baidu.navisdk.pronavi.hd.b
    @OOXIXo
    public com.baidu.navisdk.pronavi.hd.c obtainMapConfig() {
        com.baidu.navisdk.pronavi.hd.c cVar = new com.baidu.navisdk.pronavi.hd.c(false);
        cVar.k(false);
        cVar.i(false);
        cVar.j(false);
        cVar.f(false);
        cVar.g(false);
        cVar.h(false);
        cVar.a(false);
        cVar.e(false);
        cVar.d(false);
        cVar.l(false);
        cVar.c(false);
        cVar.b(false);
        return cVar;
    }

    @Override // com.baidu.navisdk.pronavi.hd.b
    public boolean setHdDataToMap(@OOXIXo Bundle bundle) {
        IIX0o.x0xO0oo(bundle, "bundle");
        com.baidu.navisdk.navimap.a mNaviMapController = getMNaviMapController();
        if (mNaviMapController != null && mNaviMapController.b(bundle)) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.e
    public void setShowRect(int i, boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGLineMapView", "setShowRect: " + i + ",:" + z);
        }
        Rect rect = new Rect();
        rect.left = 0;
        rect.top = 0;
        rect.right = this.f7762a;
        rect.bottom = this.b;
        if (gVar.d()) {
            gVar.e("RGLineMapView", "setShowRect: " + rect);
        }
        com.baidu.navisdk.navimap.a mNaviMapController = getMNaviMapController();
        if (mNaviMapController != null) {
            mNaviMapController.a(rect);
        }
    }

    @Override // com.baidu.navisdk.pronavi.hd.b
    public void setXYOffset(@oOoXoXO com.baidu.nplatform.comapi.basestruct.b bVar, int i, boolean z) {
        if (bVar == null) {
            return;
        }
        bVar.i = 0L;
        if (z) {
            bVar.j = -((this.b / 2) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_28dp));
            return;
        }
        int e = com.baidu.navisdk.pronavi.util.a.h.e();
        int i2 = this.b;
        bVar.j = -(((i2 / 2) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_88dp)) + ((e - i2) / 2));
    }

    @OOXIXo
    public final View a(@OOXIXo Context context, int i, int i2, int i3) {
        IIX0o.x0xO0oo(context, "context");
        this.f7762a = i;
        this.b = i2;
        View onCreate = onCreate(context, i3, "__normalhdmap__");
        a();
        Bundle bundle = new Bundle();
        bundle.putInt(bn.f.V, !isPortrait() ? 1 : 0);
        setHdDataToMap(bundle);
        onCreate.setOnTouchListener(b.f7763a);
        return onCreate;
    }

    public final void a(int i, int i2, int i3) {
        this.f7762a = i2;
        this.b = i3;
        super.onOrientationChange(i);
        a();
        Bundle bundle = new Bundle();
        bundle.putInt(bn.f.V, !isPortrait() ? 1 : 0);
        setHdDataToMap(bundle);
    }

    private final void a() {
        showMapViewRoundCorner(new c());
    }

    public final boolean a(int i, @oOoXoXO String str, @oOoXoXO String str2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGLineMapView", "setDIYDataToMap: " + i + ", " + str + ", " + str2 + TokenParser.SP);
        }
        com.baidu.navisdk.navimap.a mNaviMapController = getMNaviMapController();
        return mNaviMapController != null && mNaviMapController.a(i, str, str2);
    }

    public final void a(boolean z, int i, boolean z2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGLineMapView", "setMapAerialAnimation: " + z + ", " + i);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("anime", z ? 1 : 0);
        bundle.putInt("aerial", i);
        bundle.putInt(bn.f.V, !z2 ? 1 : 0);
        setHdDataToMap(bundle);
    }
}
