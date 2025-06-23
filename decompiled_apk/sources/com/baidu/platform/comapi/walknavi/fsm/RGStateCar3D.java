package com.baidu.platform.comapi.walknavi.fsm;

import XIXIX.OOXIXo;
import android.graphics.Point;
import com.baidu.R;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.WinRound;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.walknavi.segmentbrowse.c;
import com.baidu.platform.comapi.wnplatform.f;

/* loaded from: classes8.dex */
public class RGStateCar3D extends RGState {
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
        super.exit();
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionLayers() {
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionMapStatus() {
        b.a().Y().r();
        b.a().N().b(true);
        GeoPoint e = b.a().K().e();
        MapStatus h = b.a().N().h();
        if (h != null) {
            MapStatus.Builder builder = new MapStatus.Builder(h);
            WinRound winRound = h.winRound;
            long abs = 0.0f - (Math.abs(winRound.bottom - winRound.top) * 0.2f);
            WinRound winRound2 = h.winRound;
            builder.targetScreen(new Point((winRound2.right + winRound2.left) / 2, ((winRound2.top + winRound2.bottom) / 2) - ((int) abs)));
            builder.rotate(b.a().K().d());
            if (f.a().g()) {
                if (f.a().d()) {
                    builder.overlook(0.0f);
                } else {
                    builder.overlook(-50.0f);
                }
            } else if (f.a().h()) {
                builder.overlook(-47.0f);
            }
            if (h.zoom < 19.0f) {
                builder.zoom(19.0f);
            }
            if (e.getLongitudeE6() != OOXIXo.f3760XO && e.getLatitudeE6() != OOXIXo.f3760XO) {
                builder.target(com.baidu.platform.comapi.wnplatform.p.f.a(e));
                b.a().N().a(builder.build(), FeatureCodes.VO);
            }
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionNaviEngine() {
        if (b.a().Q() != 4 && c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE && c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE) {
            b.a().K().a(false);
            if (f.a().d()) {
                b.a().K().c(1);
            } else {
                b.a().K().c(0);
            }
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionUI() {
        b.a().Y().n();
        b.a().Y().c(R.drawable.wsdk_drawable_rg_ic_walk_bike3d_new);
        if (f.a().g()) {
            if (b.a().Q() != 4) {
                b.a().Y().a(true);
            }
        } else if (f.a().h()) {
            b.a().Y().a(true);
        }
    }
}
