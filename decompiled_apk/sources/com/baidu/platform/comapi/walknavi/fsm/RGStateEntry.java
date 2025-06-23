package com.baidu.platform.comapi.walknavi.fsm;

import XIXIX.OOXIXo;
import com.baidu.R;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.walkmap.f;

/* loaded from: classes8.dex */
public class RGStateEntry extends RGStateCar3D {
    private int b = 0;

    /* renamed from: a, reason: collision with root package name */
    private f f9757a = new a(this);

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    public void exit() {
        this.b = 0;
        b.a().N().a((f) null);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionMapStatus() {
        b.a().Y().r();
        b.a().N().b(true);
        b.a().N().a(this.f9757a);
        GeoPoint e = b.a().K().e();
        MapStatus h = b.a().N().h();
        if (h != null) {
            MapStatus.Builder builder = new MapStatus.Builder(h);
            if (h.zoom < 19.0f) {
                builder.zoom(19.0f);
            }
            if (e.getLongitudeE6() != OOXIXo.f3760XO && e.getLatitudeE6() != OOXIXo.f3760XO) {
                builder.target(com.baidu.platform.comapi.wnplatform.p.f.a(e));
                b.a().N().a(builder.build(), 500);
            }
            this.b = 1;
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionNaviEngine() {
        b.a().K().a(true);
        if (com.baidu.platform.comapi.wnplatform.f.a().d()) {
            b.a().K().c(1);
        } else {
            b.a().K().c(0);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionUI() {
        b.a().Y().n();
        b.a().Y().c(R.drawable.wsdk_drawable_rg_ic_walk_bike3d_new);
    }
}
