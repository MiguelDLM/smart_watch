package com.baidu.platform.comapi.walknavi.fsm;

import android.graphics.Point;
import com.baidu.R;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.MapBound;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;

/* loaded from: classes8.dex */
public class RGStateOverview extends RGState {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void enter() {
        super.enter();
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void excute() {
        super.excute();
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void exit() {
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionLayers() {
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionMapStatus() {
        b.a().Y().r();
        b.a().N().b(true);
        MapBound ab = b.a().ab();
        MapStatus h = b.a().N().h();
        if (h != null) {
            MapStatus.Builder builder = new MapStatus.Builder(h);
            builder.overlook(0.0f);
            WinRound winRound = h.winRound;
            builder.targetScreen(new Point((winRound.right + winRound.left) / 2, ((winRound.top + winRound.bottom) / 2) - ((int) 0)));
            if (ab != null) {
                float a2 = b.a().N().a(ab, com.baidu.platform.comapi.wnplatform.p.b.b.a().b(), (com.baidu.platform.comapi.wnplatform.p.b.b.a().c() - b.a().Y().q()) - b.a().Y().p());
                builder.target(CoordUtil.mc2ll(new GeoPoint((ab.getPtLB().getIntY() + ab.getPtRT().getIntY()) / 2, (ab.getPtLB().getIntX() + ab.getPtRT().getIntX()) / 2)));
                if (a2 > 3.0f) {
                    a2 = (float) (a2 - 0.8d);
                }
                builder.zoom(a2);
            }
            b.a().N().a(builder.build(), 500);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionNaviEngine() {
        b.a().K().a(true);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionUI() {
        b.a().Y().c(R.drawable.wsdk_drawable_rg_ic_locate_walk_bike_point);
    }
}
