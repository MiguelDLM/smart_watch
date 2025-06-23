package com.baidu.platform.comapi.walknavi.fsm;

import com.baidu.R;
import com.baidu.platform.comapi.walknavi.b;

/* loaded from: classes8.dex */
public class RGStateSeg extends RGState {
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
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionNaviEngine() {
        b.a().K().a(true);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionUI() {
        b.a().Y().c(R.drawable.wsdk_drawable_rg_ic_locate_walk_bike_point);
        if (b.a().Q() != 4) {
            b.a().Y().a(false);
        }
    }
}
