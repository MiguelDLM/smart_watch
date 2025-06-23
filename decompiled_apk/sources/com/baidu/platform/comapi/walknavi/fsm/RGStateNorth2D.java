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
import com.baidu.platform.comapi.wnplatform.p.f;
import com.facebook.appevents.UserDataStore;

/* loaded from: classes8.dex */
public class RGStateNorth2D extends RGState {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void enter() {
        super.enter();
        WGuideFSM.restoreZoomLevel();
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void excute() {
        super.excute();
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void exit() {
        WGuideFSM.saveZoomLevel();
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
        com.baidu.platform.comapi.wnplatform.d.a.b(UserDataStore.STATE, h.toString());
        MapStatus.Builder builder = new MapStatus.Builder(h);
        builder.rotate(0.0f);
        builder.overlook(0.0f);
        WinRound winRound = h.winRound;
        builder.targetScreen(new Point((winRound.right + winRound.left) / 2, ((winRound.top + winRound.bottom) / 2) - ((int) 0)));
        if (h.zoom < 19.0f) {
            builder.zoom(19.0f);
        }
        if (e.getLongitudeE6() != OOXIXo.f3760XO && e.getLatitudeE6() != OOXIXo.f3760XO) {
            builder.target(f.a(e));
            b.a().N().a(builder.build(), FeatureCodes.VO);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionNaviEngine() {
        if (b.a().Q() != 4 && c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE && c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE) {
            b.a().K().a(false);
            b.a().K().c(1);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionUI() {
        b.a().Y().n();
        b.a().Y().c(R.drawable.wsdk_drawable_rg_ic_north_walk_bike2d);
        b.a().Q();
    }
}
