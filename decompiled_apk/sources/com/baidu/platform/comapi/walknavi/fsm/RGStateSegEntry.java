package com.baidu.platform.comapi.walknavi.fsm;

import android.graphics.Point;
import com.baidu.R;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.WinRound;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.p.f;

/* loaded from: classes8.dex */
public class RGStateSegEntry extends RGStateCar3D {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionMapStatus() {
        b.a().Y().r();
        b.a().N().b(true);
        MapStatus h = b.a().N().h();
        if (h != null) {
            MapStatus.Builder builder = new MapStatus.Builder(h);
            WinRound winRound = h.winRound;
            long abs = 0.0f - (Math.abs(winRound.bottom - winRound.top) * 0.2f);
            builder.overlook(0.0f);
            WinRound winRound2 = h.winRound;
            builder.targetScreen(new Point((winRound2.right + winRound2.left) / 2, ((winRound2.top + winRound2.bottom) / 2) - ((int) abs)));
            if (h.zoom < 19.0f) {
                builder.zoom(19.0f);
            }
            com.baidu.platform.comapi.basestruct.Point S = b.a().S();
            if (S != null) {
                builder.target(f.a(new GeoPoint(S.getDoubleY(), S.getDoubleX())));
            }
            b.a().N().a(builder.build(), 500);
        }
        b.a().K().a(true);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionNaviEngine() {
        b.a().K().a(true);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionUI() {
        b.a().Y().c(R.drawable.wsdk_drawable_rg_ic_locate_walk_bike_point);
    }
}
