package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.j;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l0;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class RGFSMFactory {
    private final HashMap<String, RGState> mFsmTable = new HashMap<>();

    private RGState newInstance(String str) {
        if (str.equals(RGFSMTable.FsmState.SimpleGuide)) {
            return new RGStateSimpleGuide();
        }
        if (str.equals(RGFSMTable.FsmState.ArriveDest)) {
            return new RGStateArriveDest();
        }
        if (str.equals(RGFSMTable.FsmState.Voice)) {
            return new RGStateVoice();
        }
        if (str.equals(RGFSMTable.FsmState.EnlargeRoadmap)) {
            return new RGStateEnlargeRoadmap();
        }
        if (str.equals(RGFSMTable.FsmState.Fullview)) {
            return new RGStateFullview();
        }
        if (str.equals(RGFSMTable.FsmState.HUDMirror)) {
            if (!j.c()) {
                return new RGStateHUDMirror();
            }
        } else if (str.equals(RGFSMTable.FsmState.HUD)) {
            if (!j.c()) {
                return new RGStateHUD();
            }
        } else {
            if (str.equals(RGFSMTable.FsmState.BrowseMap)) {
                return new RGStateBrowseMap();
            }
            if (str.equals(RGFSMTable.FsmState.Car3D)) {
                return new RGStateCar3D();
            }
            if (str.equals(RGFSMTable.FsmState.Colladamap)) {
                return new RGStateColladamap();
            }
            if (str.equals(RGFSMTable.FsmState.Highway)) {
                return new RGStateHighway();
            }
            if (str.equals(RGFSMTable.FsmState.North2D)) {
                return new RGStateNorth2D();
            }
            if (str.equals(RGFSMTable.FsmState.NaviReady)) {
                return new RGStateNaviReady();
            }
            if (str.equals(RGFSMTable.FsmState.NearbySearch)) {
                return new RGStateNearbySearch();
            }
            if (str.equals(RGFSMTable.FsmState.IndoorPark)) {
                return new RGStateIndoorPark();
            }
            if (str.equals(RGFSMTable.FsmState.IndoorParkBrowse)) {
                return new RGStateIndoorParkBrowseMap();
            }
            if (str.equals(RGFSMTable.FsmState.IndoorParkChoose)) {
                return new RGStateIndoorParkChoose();
            }
            if (str.equals(RGFSMTable.FsmState.Pip)) {
                return new RGStatePIP();
            }
            if (str.equals(RGFSMTable.FsmState.DynamicLayer)) {
                return new RGStateDynamicLayer();
            }
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.a("can not newInstance " + str, new RuntimeException("state is null! stateName = " + str));
            }
        }
        return null;
    }

    public RGState obtainFsm(String str) {
        if (l0.c(str)) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.a("obtainFsm stateName can't empty!", new RuntimeException("stateName can't empty!"));
            }
        }
        RGState rGState = this.mFsmTable.get(str);
        if (rGState == null && (rGState = newInstance(str)) != null) {
            this.mFsmTable.put(str, rGState);
        }
        return rGState;
    }
}
