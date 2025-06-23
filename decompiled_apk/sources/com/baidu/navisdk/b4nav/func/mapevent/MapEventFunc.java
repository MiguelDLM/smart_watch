package com.baidu.navisdk.b4nav.func.mapevent;

import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.baidu.baidunavis.maplayer.e;
import com.baidu.navisdk.b4nav.framework.func.CoreFunc;
import com.baidu.navisdk.comapi.mapcontrol.BNDynamicOverlay;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.j;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.nplatform.comapi.MapItem;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes7.dex */
public abstract class MapEventFunc<R> extends CoreFunc<R> {
    private BNMapObserver m;
    private com.baidu.baidunavis.maplayer.b n;
    private BNDynamicOverlay.OnClickListener o;
    private final BNDynamicOverlay p;
    private final Set<com.baidu.navisdk.b4nav.func.mapevent.a> q;

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public a() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) MapEventFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BNMapObserver {
        public b() {
        }

        @Override // com.baidu.navisdk.comapi.base.b
        public void update(com.baidu.navisdk.comapi.base.c cVar, int i, int i2, Object obj) {
            g gVar = g.B4NAV;
            if (gVar.d()) {
                gVar.e(((Func) MapEventFunc.this).g, "NavMapEvent::update --> type = " + i + ", event = " + i2 + ", arg = " + obj);
            }
            if (gVar.b()) {
                ((com.baidu.navisdk.b4nav.c) ((Func) MapEventFunc.this).i).b(((Func) MapEventFunc.this).g, "NavMapEvent", "update", String.valueOf(i), String.valueOf(i2));
            }
            if (1 == i) {
                if (i2 == 265) {
                    if (gVar.d()) {
                        gVar.e(((Func) MapEventFunc.this).g, "NavMapEvent::update --> EVENT_CLICKED_POI_BKG_LAYER");
                    }
                    if (obj instanceof MapItem) {
                        MapItem mapItem = (MapItem) obj;
                        Iterator it = MapEventFunc.this.q.iterator();
                        while (it.hasNext()) {
                            ((com.baidu.navisdk.b4nav.func.mapevent.a) it.next()).a(mapItem.mUid, mapItem.mBundleParams);
                        }
                    }
                } else if (i2 == 517) {
                    if (gVar.d()) {
                        gVar.e(((Func) MapEventFunc.this).g, "NavMapEvent::update --> EVENT_CLICKED_THROUGH_NODE_LAYER");
                    }
                    if (obj instanceof Bundle) {
                        Serializable serializable = ((Bundle) obj).getSerializable("item");
                        if (serializable instanceof MapItem) {
                            MapItem mapItem2 = (MapItem) serializable;
                            int i3 = mapItem2.mItemID - 1;
                            Iterator it2 = MapEventFunc.this.q.iterator();
                            while (it2.hasNext()) {
                                ((com.baidu.navisdk.b4nav.func.mapevent.a) it2.next()).a(i3, new com.baidu.nplatform.comapi.basestruct.c(mapItem2.mLongitudeMc, mapItem2.mLatitudeMc), "", 0);
                            }
                        }
                    }
                } else if (i2 == 520) {
                    if (gVar.d()) {
                        gVar.e(((Func) MapEventFunc.this).g, "NavMapEvent::update --> EVENT_CLICKED_RC_PREDICTION_BUBBLE");
                    }
                    Iterator it3 = MapEventFunc.this.q.iterator();
                    while (it3.hasNext()) {
                        ((com.baidu.navisdk.b4nav.func.mapevent.a) it3.next()).a();
                    }
                } else if (i2 == 529) {
                    if (gVar.d()) {
                        gVar.e(((Func) MapEventFunc.this).g, "NavMapEvent::update --> EVENT_CLICKED_DEST_NODE_BUBBLE");
                    }
                    if (obj instanceof MapItem) {
                        String string = ((MapItem) obj).mBundleParams.getString("eta", "");
                        Iterator it4 = MapEventFunc.this.q.iterator();
                        while (it4.hasNext()) {
                            ((com.baidu.navisdk.b4nav.func.mapevent.a) it4.next()).a(string);
                        }
                    }
                } else if (i2 == 514) {
                    if (gVar.d()) {
                        gVar.e(((Func) MapEventFunc.this).g, "NavMapEvent::update --> EVENT_CLICKED_ROUTE");
                    }
                    if (obj instanceof MapItem) {
                        MapItem mapItem3 = (MapItem) obj;
                        com.baidu.navisdk.b4nav.b bVar = ((CoreFunc) MapEventFunc.this).k;
                        if (bVar == null) {
                            if (mapItem3.mItemID != 0) {
                                Iterator it5 = MapEventFunc.this.q.iterator();
                                while (it5.hasNext()) {
                                    ((com.baidu.navisdk.b4nav.func.mapevent.a) it5.next()).a(mapItem3.mItemID);
                                }
                            } else {
                                e.k().j();
                                return;
                            }
                        } else {
                            bVar.c();
                            throw null;
                        }
                    }
                } else if (i2 != 515) {
                    Iterator it6 = MapEventFunc.this.q.iterator();
                    while (it6.hasNext()) {
                        ((com.baidu.navisdk.b4nav.func.mapevent.a) it6.next()).a(i2, obj);
                    }
                } else {
                    if (gVar.d()) {
                        gVar.e(((Func) MapEventFunc.this).g, "NavMapEvent::update --> EVENT_CLICKED_ROUTE_UGC_ITEM");
                    }
                    if (obj instanceof MapItem) {
                        MapItem mapItem4 = (MapItem) obj;
                        int i4 = mapItem4.mBzid;
                        boolean z = i4 == 999;
                        boolean z2 = i4 == 992;
                        Iterator it7 = MapEventFunc.this.q.iterator();
                        while (it7.hasNext()) {
                            ((com.baidu.navisdk.b4nav.func.mapevent.a) it7.next()).a(mapItem4.mUid, true, mapItem4.mBundleParams, true, z2 || z, mapItem4.mBzid);
                        }
                    }
                }
            } else if (2 == i) {
                Iterator it8 = MapEventFunc.this.q.iterator();
                while (it8.hasNext()) {
                    ((com.baidu.navisdk.b4nav.func.mapevent.a) it8.next()).a(i2, obj instanceof MotionEvent ? (MotionEvent) obj : null);
                }
                if (i2 == 517) {
                    g gVar2 = g.B4NAV;
                    if (gVar2.d()) {
                        gVar2.e(((Func) MapEventFunc.this).g, "NavMapEvent::update --> EVENT_LONGPRESS");
                    }
                    if (obj == null) {
                        return;
                    }
                    MotionEvent motionEvent = (MotionEvent) obj;
                    if (motionEvent.getPointerCount() > 1 || motionEvent.getAction() != 0) {
                        return;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    LogUtil.e(((Func) MapEventFunc.this).g, "update: TYPE_GESTURE --> x = " + x + ", y = " + y);
                    com.baidu.nplatform.comapi.basestruct.c a2 = e.k().a(x, y);
                    if (a2 != null) {
                        Iterator it9 = MapEventFunc.this.q.iterator();
                        while (it9.hasNext()) {
                            ((com.baidu.navisdk.b4nav.func.mapevent.a) it9.next()).a(a2);
                        }
                    }
                }
            }
            if (g.B4NAV.b()) {
                ((com.baidu.navisdk.b4nav.c) ((Func) MapEventFunc.this).i).a(((Func) MapEventFunc.this).g, "NavMapEvent", "update", String.valueOf(i), String.valueOf(i2));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements com.baidu.baidunavis.maplayer.b {
        public c(MapEventFunc mapEventFunc) {
        }
    }

    /* loaded from: classes7.dex */
    public class d implements BNDynamicOverlay.OnClickListener {
        public d() {
        }

        @Override // com.baidu.navisdk.comapi.mapcontrol.BNDynamicOverlay.OnClickListener
        public void onClicked(int i, int i2, String str, @NonNull MapItem mapItem) {
            g gVar = g.B4NAV;
            if (gVar.d()) {
                gVar.e(((Func) MapEventFunc.this).g, "DynamicOverlay::onClicked --> key = " + i + ", id = " + i2 + ", sid = " + str);
            }
            if (gVar.b()) {
                ((com.baidu.navisdk.b4nav.c) ((Func) MapEventFunc.this).i).b(((Func) MapEventFunc.this).g, "DynamicOverlay", "onClicked");
            }
            if (i != 100) {
                Iterator it = MapEventFunc.this.q.iterator();
                while (it.hasNext()) {
                    ((com.baidu.navisdk.b4nav.func.mapevent.a) it.next()).a(i, i2, str, mapItem);
                }
            } else {
                int i3 = mapItem.mItemID - 1;
                Iterator it2 = MapEventFunc.this.q.iterator();
                while (it2.hasNext()) {
                    ((com.baidu.navisdk.b4nav.func.mapevent.a) it2.next()).a(i3, new com.baidu.nplatform.comapi.basestruct.c(mapItem.mLongitudeMc, mapItem.mLatitudeMc), mapItem.mItemSID, 1);
                }
            }
            if (g.B4NAV.b()) {
                ((com.baidu.navisdk.b4nav.c) ((Func) MapEventFunc.this).i).a(((Func) MapEventFunc.this).g, "DynamicOverlay", "onClicked");
            }
        }
    }

    private void A() {
        BNDynamicOverlay.OnClickListener onClickListener = this.o;
        if (onClickListener != null) {
            this.p.removeClickedListener(onClickListener);
        }
    }

    private void v() {
        if (this.n != null && j.d()) {
            com.baidu.baidunavis.maplayer.a.h().a(this.n);
        }
    }

    private void w() {
        BNDynamicOverlay.OnClickListener onClickListener = this.o;
        if (onClickListener != null) {
            this.p.addClickedListener(onClickListener);
        }
    }

    private void x() {
        this.m = null;
        this.n = null;
    }

    private void y() {
        com.baidu.nplatform.comapi.map.a.c().b(this.m);
    }

    private void z() {
        com.baidu.baidunavis.maplayer.a.h().g();
    }

    @Override // com.baidu.navisdk.framework.func.Func
    public String o() {
        return "MapEventFunc";
    }

    private void r() {
        u();
        t();
        s();
    }

    private void s() {
        this.o = new d();
    }

    private void t() {
        this.n = new c(this);
    }

    private void u() {
        this.m = new b();
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        r();
        a(1002, new a());
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        this.q.clear();
        x();
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void i() {
        super.i();
        z();
        y();
        A();
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void j() {
        super.j();
        v();
        w();
        this.k.k();
        throw null;
    }
}
