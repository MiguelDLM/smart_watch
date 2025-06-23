package com.baidu.navisdk.ui.routeguide.map;

import android.os.Bundle;
import com.baidu.navisdk.comapi.base.c;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.j;
import com.baidu.navisdk.model.datastruct.n;
import com.baidu.navisdk.model.datastruct.s;
import com.baidu.navisdk.module.pronavi.model.i;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.d;
import com.baidu.navisdk.ui.routeguide.control.f;
import com.baidu.navisdk.ui.routeguide.control.k;
import com.baidu.navisdk.ui.routeguide.control.r;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.t;
import com.baidu.navisdk.ui.routeguide.navicenter.BNavigatorLogic;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.e0;
import com.baidu.navisdk.util.common.o;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

/* loaded from: classes8.dex */
public class a implements BNMapObserver {

    /* renamed from: a, reason: collision with root package name */
    private final BNavigatorLogic f8643a;
    private BNMapObserver b;
    private int c = -1;
    private int d = 0;

    public a(BNavigatorLogic bNavigatorLogic, BNMapObserver bNMapObserver) {
        this.f8643a = bNavigatorLogic;
        this.b = bNMapObserver;
    }

    private boolean a(int i, int i2) {
        if (i != 2) {
            return false;
        }
        switch (i2) {
            case 513:
            case 514:
            case 515:
            case 516:
            case 517:
            case 518:
            case 520:
            case 521:
                return true;
            case 519:
            default:
                return false;
        }
    }

    private void b(int i, int i2) {
        if (!a(i, i2)) {
            return;
        }
        int i3 = this.c;
        if (520 == i3 && 513 == i2) {
            return;
        }
        if (519 == i2) {
            i2 = 518;
        }
        if (520 == i3 && 518 == i2) {
            return;
        }
        if ((521 != i3 || 518 != i2) && 2 == i) {
            if (i2 == i3) {
                this.d++;
            } else {
                this.c = i2;
                this.d = 1;
            }
            if (this.c == 518 && this.d == 2) {
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_map_scroll"));
            }
        }
    }

    @Override // com.baidu.navisdk.comapi.base.b
    public void update(c cVar, int i, int i2, Object obj) {
        k g;
        com.baidu.navisdk.ui.routeguide.navicenter.c j;
        k g2;
        k g3;
        k g4;
        k g5;
        k g6;
        k g7;
        k g8;
        k g9;
        k g10;
        k g11;
        if ((this.f8643a.L() && !a0.I().D()) || 1 == i || i2 == 274) {
            b(i, i2);
            if (1 == i) {
                if (i2 != 257) {
                    if (i2 == 262) {
                        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MAP_COMPASS_CLICK);
                    } else if (i2 != 265) {
                        if (i2 != 272) {
                            if (i2 != 274) {
                                if (i2 != 277) {
                                    if (i2 == 521) {
                                        if (LogUtil.LOGGABLE) {
                                            LogUtil.e("RouteGuide", "update EVENT_CLICKED_CAR_LOGO:  " + com.baidu.navisdk.module.pronavi.a.j);
                                        }
                                        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
                                            LogUtil.e("RouteGuide", "EVENT_CLICKED_CAR_LOGO return NE_Locate_Mode_RouteDemoGPS");
                                            return;
                                        }
                                        if (a0.I().v()) {
                                            LogUtil.e("RouteGuide", "EVENT_CLICKED_CAR_LOGO return isNaviReady");
                                            return;
                                        }
                                        if (a0.I().D()) {
                                            LogUtil.e("RouteGuide", "EVENT_CLICKED_CAR_LOGO return isyawing");
                                            return;
                                        }
                                        if (!this.f8643a.L()) {
                                            LogUtil.e("RouteGuide", "EVENT_CLICKED_CAR_LOGO return hasCalcRouteOk false");
                                            return;
                                        }
                                        if (RouteGuideFSM.getInstance().getTopState() != null && RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.DynamicLayer)) {
                                            com.baidu.navisdk.ui.routeguide.navicenter.c j2 = com.baidu.navisdk.ui.routeguide.b.V().j();
                                            if (j2 == null || (g5 = j2.g()) == null) {
                                                return;
                                            }
                                            g5.a(i, i2);
                                            return;
                                        }
                                        if (j.d()) {
                                            this.f8643a.j0();
                                        }
                                    } else if (i2 == 530) {
                                        if (LogUtil.LOGGABLE) {
                                            LogUtil.e("RouteGuide", "update EVENT_CLICKED_INDOOR_PARK_SPACE:  " + com.baidu.navisdk.module.pronavi.a.j);
                                        }
                                        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
                                            LogUtil.e("RouteGuide", "EVENT_CLICKED_INDOOR_PARK_SPACE return NE_Locate_Mode_RouteDemoGPS");
                                            return;
                                        }
                                        if (RouteGuideFSM.getInstance().getTopState() != null && RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.DynamicLayer)) {
                                            com.baidu.navisdk.ui.routeguide.navicenter.c j3 = com.baidu.navisdk.ui.routeguide.b.V().j();
                                            if (j3 == null || (g6 = j3.g()) == null) {
                                                return;
                                            }
                                            g6.a(i, i2);
                                            return;
                                        }
                                        if (obj instanceof MapItem) {
                                            MapItem mapItem = (MapItem) obj;
                                            LogUtil.e("RouteGuide", "EVENT_CLICKED_INDOOR_PARK_SPACE indoorPark, mapItem=" + mapItem);
                                            this.f8643a.a(mapItem.mTitle, mapItem.mUid, mapItem.mLatitudeMc, mapItem.mLongitudeMc, mapItem.mOnlineType);
                                            return;
                                        }
                                    } else if (i2 != 514) {
                                        if (i2 != 515) {
                                            switch (i2) {
                                                case 517:
                                                    com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
                                                    if ((k != null && !k.isNodeClick()) || obj == null || com.baidu.navisdk.module.pronavi.a.j == 2) {
                                                        return;
                                                    }
                                                    if (RouteGuideFSM.getInstance().getTopState() != null && RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.DynamicLayer)) {
                                                        com.baidu.navisdk.ui.routeguide.navicenter.c j4 = com.baidu.navisdk.ui.routeguide.b.V().j();
                                                        if (j4 == null || (g9 = j4.g()) == null) {
                                                            return;
                                                        }
                                                        g9.a(i, i2);
                                                        return;
                                                    }
                                                    Bundle bundle = (Bundle) obj;
                                                    if (bundle.getSerializable("item") != null) {
                                                        MapItem mapItem2 = (MapItem) bundle.getSerializable("item");
                                                        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MAP_MOVE);
                                                        com.baidu.navisdk.poisearch.model.b.m().a(new GeoPoint(mapItem2.mLongitude, mapItem2.mLatitude));
                                                        x.b().s4();
                                                        break;
                                                    }
                                                    break;
                                                case 518:
                                                    if (a0.I().D()) {
                                                        LogUtil.e("RouteGuide", "EVENT_CLICKED_ROUTE_AROUND_ELEMENT return isyawing");
                                                        return;
                                                    }
                                                    if (com.baidu.navisdk.module.pronavi.a.j == 2) {
                                                        return;
                                                    }
                                                    if (!this.f8643a.L()) {
                                                        LogUtil.e("RouteGuide", "EVENT_CLICKED_ROUTE_AROUND_ELEMENT return hasCalcRouteOk false");
                                                        return;
                                                    }
                                                    if (RouteGuideFSM.getInstance().getTopState() != null && RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.DynamicLayer)) {
                                                        com.baidu.navisdk.ui.routeguide.navicenter.c j5 = com.baidu.navisdk.ui.routeguide.b.V().j();
                                                        if (j5 == null || (g10 = j5.g()) == null) {
                                                            return;
                                                        }
                                                        g10.a(i, i2);
                                                        return;
                                                    }
                                                    if (obj != null) {
                                                        MapItem mapItem3 = (MapItem) obj;
                                                        n nVar = new n();
                                                        nVar.b = mapItem3.mUid;
                                                        nVar.f6936a = mapItem3.mTitle.replace("\\", "");
                                                        nVar.c = mapItem3.mBundleParams.getInt("style_id", 0);
                                                        mapItem3.mBundleParams.getInt("dis", 0);
                                                        GeoPoint a2 = o.a(mapItem3.mBundleParams.getString("geo", ""));
                                                        nVar.d = a2;
                                                        if (a2 != null && a2.isValid()) {
                                                            this.f8643a.a(nVar);
                                                            break;
                                                        } else {
                                                            LogUtil.e("RouteGuide", "EVENT_CLICKED_ROUTE_AROUND_ELEMENT --> poi.mGeoPoint = " + nVar.d);
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case 519:
                                                    if (com.baidu.navisdk.module.pronavi.a.j == 2) {
                                                        return;
                                                    }
                                                    if (RouteGuideFSM.getInstance().getTopState() != null && RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.DynamicLayer)) {
                                                        com.baidu.navisdk.ui.routeguide.navicenter.c j6 = com.baidu.navisdk.ui.routeguide.b.V().j();
                                                        if (j6 == null || (g11 = j6.g()) == null) {
                                                            return;
                                                        }
                                                        g11.a(i, i2);
                                                        return;
                                                    }
                                                    if (obj instanceof MapItem) {
                                                        this.f8643a.a((String) null, true, ((MapItem) obj).mBundleParams);
                                                    }
                                                    com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.5", "2", "1", null);
                                                    break;
                                            }
                                        } else {
                                            if (obj == null) {
                                                return;
                                            }
                                            if (LogUtil.LOGGABLE) {
                                                LogUtil.e("RouteGuide", "EVENT_CLICKED_ROUTE_UGC_ITEM pRGLocateMode: " + com.baidu.navisdk.module.pronavi.a.j);
                                            }
                                            if (com.baidu.navisdk.module.pronavi.a.j == 2) {
                                                return;
                                            }
                                            if (!com.baidu.navisdk.function.b.FUNC_UGC_DETAILS.a()) {
                                                if (LogUtil.LOGGABLE) {
                                                    LogUtil.d("RouteGuide", "EVENT_CLICKED_ROUTE_UGC_ITEM: FUNC_UGC_DETAILS not enable");
                                                    return;
                                                }
                                                return;
                                            }
                                            if (RouteGuideFSM.getInstance().getTopState() != null && RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.DynamicLayer)) {
                                                com.baidu.navisdk.ui.routeguide.navicenter.c j7 = com.baidu.navisdk.ui.routeguide.b.V().j();
                                                if (j7 == null || (g8 = j7.g()) == null) {
                                                    return;
                                                }
                                                g8.a(i, i2);
                                                return;
                                            }
                                            MapItem mapItem4 = (MapItem) obj;
                                            Bundle bundle2 = mapItem4.mBundleParams;
                                            if (bundle2 == null) {
                                                bundle2 = new Bundle();
                                            }
                                            if (!bundle2.containsKey("source")) {
                                                bundle2.putInt("source", 3);
                                            }
                                            if (!bundle2.containsKey(MapItem.KEY_CHAT_ID)) {
                                                bundle2.putString(MapItem.KEY_CHAT_ID, mapItem4.chatId);
                                            }
                                            bundle2.putInt("page", 1);
                                            this.f8643a.a(mapItem4.mUid, true, bundle2);
                                        }
                                    } else {
                                        if (com.baidu.navisdk.poisearch.model.a.k().h()) {
                                            LogUtil.e("RouteGuide", "EVENT_CLICKED_ROUTE return by isRouteSearchMode");
                                            return;
                                        }
                                        if (a0.I().v()) {
                                            LogUtil.e("RouteGuide", "EVENT_CLICKED_ROUTE return isNaviReady");
                                            return;
                                        }
                                        if (a0.I().D()) {
                                            LogUtil.e("RouteGuide", "EVENT_CLICKED_ROUTE return isyawing");
                                            return;
                                        }
                                        if (!this.f8643a.L()) {
                                            LogUtil.e("RouteGuide", "EVENT_CLICKED_ROUTE return hasCalcRouteOk false");
                                            return;
                                        }
                                        if (RouteGuideFSM.getInstance().getTopState() != null && RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.DynamicLayer)) {
                                            com.baidu.navisdk.ui.routeguide.navicenter.c j8 = com.baidu.navisdk.ui.routeguide.b.V().j();
                                            if (j8 == null || (g7 = j8.g()) == null) {
                                                return;
                                            }
                                            g7.a(i, i2);
                                            return;
                                        }
                                        MapItem mapItem5 = (MapItem) obj;
                                        LogUtil.e("RouteGuide", "EVENT_CLICKED_ROUTE item= " + mapItem5.mItemID);
                                        i.f().e = mapItem5.mItemID;
                                        i.f().f = mapItem5.mCurRouteIdx;
                                        if (i.f().d) {
                                            BNMapController.getInstance().setHighLightAvoidTrafficRoute(mapItem5.mItemID);
                                        } else {
                                            BNMapController.getInstance().setHighLightRoute(mapItem5.mItemID);
                                        }
                                        if (com.baidu.navisdk.module.abtest.model.i.w().o() == 3) {
                                            BNRoutePlaner.getInstance().n(i.f().e);
                                            BNMapController.getInstance().updateLayer(10);
                                            BNMapController.getInstance().clearLayer(23);
                                            if (mapItem5.mClickType == 1) {
                                                com.baidu.navisdk.module.abtest.model.i.w().u();
                                            } else {
                                                com.baidu.navisdk.module.abtest.model.i.w().t();
                                            }
                                        } else {
                                            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.TOUCH_MAP);
                                            if (i.f().e == i.f().f) {
                                                if (mapItem5.mClickType == 1) {
                                                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.1", null, "", "" + mapItem5.mItemID);
                                                } else {
                                                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.2", null, "", "" + mapItem5.mItemID);
                                                }
                                                i.f().b = false;
                                                x.b().k(true);
                                            } else {
                                                if (mapItem5.mClickType == 1) {
                                                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.1", "", null, "" + mapItem5.mItemID);
                                                    if (com.baidu.navisdk.module.abtest.model.i.w().o() == 1 || com.baidu.navisdk.module.abtest.model.i.w().o() == 2) {
                                                        com.baidu.navisdk.module.abtest.model.i.w().u();
                                                    }
                                                } else {
                                                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.2", "", null, "" + mapItem5.mItemID);
                                                    if (com.baidu.navisdk.module.abtest.model.i.w().o() == 1 || com.baidu.navisdk.module.abtest.model.i.w().o() == 2) {
                                                        com.baidu.navisdk.module.abtest.model.i.w().t();
                                                    }
                                                }
                                                x.b().Z3();
                                                if (e0.a(com.baidu.navisdk.ui.routeguide.b.V().c()).a("sp_rg_instant_first_start_guide", true)) {
                                                    e0.a(com.baidu.navisdk.ui.routeguide.b.V().c()).b("sp_rg_instant_first_start_guide", false);
                                                    TTSPlayerControl.playTTS(JarUtils.getResources().getString(R.string.nsdk_string_rg_switch_guide_tts_text), 0);
                                                }
                                            }
                                        }
                                        LogUtil.e("RouteGuide", "CLICKED_ROUTE item=" + mapItem5.mItemID + "curIdx=" + mapItem5.mCurRouteIdx);
                                        if (t.s().j()) {
                                            t.s().a(this.f8643a.r(), mapItem5.mItemID, null);
                                        }
                                    }
                                } else {
                                    if (a0.I().D()) {
                                        LogUtil.e("RouteGuide", "EVENT_CLICKED_POI_LAYER return isyawing");
                                        return;
                                    }
                                    if (!this.f8643a.L()) {
                                        LogUtil.e("RouteGuide", "EVENT_CLICKED_POI_LAYER return hasCalcRouteOk false");
                                        return;
                                    }
                                    if (RouteGuideFSM.getInstance().getTopState() != null && RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.DynamicLayer)) {
                                        com.baidu.navisdk.ui.routeguide.navicenter.c j9 = com.baidu.navisdk.ui.routeguide.b.V().j();
                                        if (j9 == null || (g4 = j9.g()) == null) {
                                            return;
                                        }
                                        g4.a(i, i2);
                                        return;
                                    }
                                    if (com.baidu.navisdk.poisearch.model.b.m().j() || com.baidu.navisdk.poisearch.model.b.m().h() || com.baidu.navisdk.poisearch.model.b.m().i() || com.baidu.navisdk.poisearch.model.b.m().g()) {
                                        x.b().g1();
                                        x.b().q1();
                                        x.b().B0();
                                        com.baidu.navisdk.poisearch.model.b.m().d(false);
                                        com.baidu.navisdk.poisearch.model.b.m().b(false);
                                        com.baidu.navisdk.poisearch.model.b.m().a(false);
                                        com.baidu.navisdk.poisearch.model.b.m().a((s) null);
                                        com.baidu.navisdk.poisearch.model.b.m().b((GeoPoint) null);
                                        com.baidu.navisdk.poisearch.model.b.m().a((com.baidu.navisdk.model.datastruct.chargestation.b) null);
                                        BNMapController.getInstance().updateLayer(3);
                                    }
                                    if (com.baidu.navisdk.poisearch.model.b.m().k()) {
                                        x.b().o1();
                                        com.baidu.navisdk.poisearch.model.b.m().e(false);
                                        com.baidu.navisdk.poisearch.model.b.m().a((GeoPoint) null);
                                        BNMapController.getInstance().updateLayer(3);
                                    }
                                }
                            }
                        } else if (com.baidu.navisdk.poisearch.model.a.k().h()) {
                            x.b().g1();
                            x.b().q1();
                            x.b().B0();
                            com.baidu.navisdk.poisearch.model.b.m().d(false);
                            com.baidu.navisdk.poisearch.model.b.m().b(false);
                            com.baidu.navisdk.poisearch.model.b.m().a(false);
                            if (com.baidu.navisdk.poisearch.model.a.k().e() > -1) {
                                BNMapController.getInstance().focusItem(4, com.baidu.navisdk.poisearch.model.a.k().e(), false);
                                BNMapController.getInstance().updateLayer(4);
                                com.baidu.navisdk.poisearch.model.a.k().j();
                            }
                        } else if (!com.baidu.navisdk.poisearch.model.b.m().j() && !com.baidu.navisdk.poisearch.model.b.m().h() && !com.baidu.navisdk.poisearch.model.b.m().i() && !com.baidu.navisdk.poisearch.model.b.m().g()) {
                            if (com.baidu.navisdk.poisearch.model.b.m().k()) {
                                x.b().o1();
                                com.baidu.navisdk.poisearch.model.b.m().e(false);
                                com.baidu.navisdk.poisearch.model.b.m().a((GeoPoint) null);
                                com.baidu.navisdk.poisearch.c.b();
                                BNMapController.getInstance().showLayer(4, false);
                                BNMapController.getInstance().updateLayer(4);
                            }
                        } else {
                            x.b().g1();
                            x.b().q1();
                            x.b().B0();
                            com.baidu.navisdk.poisearch.model.b.m().d(false);
                            com.baidu.navisdk.poisearch.model.b.m().b(false);
                            com.baidu.navisdk.poisearch.model.b.m().a(false);
                            com.baidu.navisdk.poisearch.model.b.m().a((s) null);
                            com.baidu.navisdk.poisearch.model.b.m().b((GeoPoint) null);
                            com.baidu.navisdk.poisearch.model.b.m().a((com.baidu.navisdk.model.datastruct.chargestation.b) null);
                            com.baidu.navisdk.poisearch.c.b();
                            BNMapController.getInstance().showLayer(4, false);
                            BNMapController.getInstance().updateLayer(4);
                        }
                    } else {
                        if (a0.I().D()) {
                            LogUtil.e("RouteGuide", "EVENT_CLICKED_POI_BKG_LAYER return isyawing");
                            return;
                        }
                        if (!this.f8643a.L()) {
                            LogUtil.e("RouteGuide", "EVENT_CLICKED_POI_BKG_LAYER return hasCalcRouteOk false");
                            return;
                        }
                        if (d.l().e() || com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.b.b().a().d()) {
                            return;
                        }
                        if (RouteGuideFSM.getInstance().getTopState() != null && RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.DynamicLayer)) {
                            com.baidu.navisdk.ui.routeguide.navicenter.c j10 = com.baidu.navisdk.ui.routeguide.b.V().j();
                            if (j10 == null || (g3 = j10.g()) == null) {
                                return;
                            }
                            g3.a(i, i2);
                            return;
                        }
                        MapItem mapItem6 = (MapItem) obj;
                        String str = mapItem6.mUid;
                        LogUtil.e("RouteGuide", "layerID = " + str);
                        int a3 = com.baidu.navisdk.poisearch.c.a(str);
                        if (a3 >= 0) {
                            this.f8643a.a(a3, mapItem6.mBundleParams);
                        }
                    }
                }
                if (257 == i2) {
                    com.baidu.navisdk.ui.routeguide.mapmode.a.o5().i(1);
                }
                x.b().O4();
                com.baidu.navisdk.ui.routeguide.control.b.k().a(10);
                com.baidu.navisdk.ui.routeguide.control.b.k().a();
                int zoomLevel = BNMapController.getInstance().getZoomLevel();
                com.baidu.navisdk.framework.interfaces.k k2 = com.baidu.navisdk.framework.interfaces.c.p().k();
                if (k2 != null) {
                    k2.k(zoomLevel);
                }
            }
            if (2 == i) {
                this.f8643a.p0();
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().i(2);
                switch (i2) {
                    case 513:
                        LogUtil.e("RouteGuide", "TYPE_GESTURE: EVENT_DOUBLE_TAP");
                        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MAP_MOVE);
                        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_map_double_tap"));
                        break;
                    case 514:
                        LogUtil.e("RouteGuide", "TYPE_GESTURE: EVENT_SINGLE_TAP");
                        if (RouteGuideFSM.getInstance().getTopState() != null && RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.DynamicLayer)) {
                            com.baidu.navisdk.ui.routeguide.navicenter.c j11 = com.baidu.navisdk.ui.routeguide.b.V().j();
                            if (j11 != null && (g = j11.g()) != null) {
                                g.a(i, i2);
                                break;
                            }
                        } else {
                            if (com.baidu.navisdk.ui.routeguide.control.s.T().k(112) || com.baidu.navisdk.ui.routeguide.control.s.T().j(108)) {
                                com.baidu.navisdk.ui.routeguide.asr.c.n().l();
                            }
                            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.TOUCH_MAP);
                            break;
                        }
                        break;
                    case 515:
                        LogUtil.e("RouteGuide", "EVENT_DOWN");
                        r.i().g();
                        if (com.baidu.navisdk.poisearch.model.a.k().h()) {
                            x.b().g1();
                            x.b().q1();
                            x.b().o1();
                            x.b().B0();
                            BNMapController.getInstance().focusItem(4, com.baidu.navisdk.poisearch.model.a.k().e(), false);
                            com.baidu.navisdk.poisearch.model.a.k().j();
                        }
                        if (RouteGuideFSM.getInstance().getTopState() != null && RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.DynamicLayer) && (j = com.baidu.navisdk.ui.routeguide.b.V().j()) != null && (g2 = j.g()) != null) {
                            g2.a();
                        }
                        f.k().j();
                        com.baidu.navisdk.module.powersavemode.f.o().f();
                        break;
                    case 517:
                        LogUtil.e("RouteGuide", "TYPE_GESTURE: EVENT_LONGPRESS");
                        if (com.baidu.navisdk.ui.routeguide.control.s.T().k(112) || com.baidu.navisdk.ui.routeguide.control.s.T().j(108)) {
                            com.baidu.navisdk.ui.routeguide.asr.c.n().l();
                        }
                        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MAP_MOVE);
                        break;
                    case 518:
                        if (!this.f8643a.f0()) {
                            if (LogUtil.LOGGABLE) {
                                LogUtil.e("RouteGuide", "EVENT_SCROLL->导航进入onPause状态，不允许拖动地图！");
                                return;
                            }
                            return;
                        }
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("RouteGuide", "EVENT_SCROLL");
                        }
                        if (com.baidu.navisdk.ui.routeguide.control.s.T().k(112) || com.baidu.navisdk.ui.routeguide.control.s.T().j(108)) {
                            com.baidu.navisdk.ui.routeguide.asr.c.n().l();
                        }
                        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().J().p();
                        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MAP_MOVE);
                        com.baidu.navisdk.framework.interfaces.k k3 = com.baidu.navisdk.framework.interfaces.c.p().k();
                        if (k3 != null) {
                            k3.W();
                            break;
                        }
                        break;
                    case 519:
                        LogUtil.e("RouteGuide", "EVENT_OBVIOUS_MOVE");
                        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MAP_MOVE);
                        break;
                    case 520:
                        LogUtil.e("RouteGuide", "TYPE_GESTURE: EVENT_DOUBLE_FINGER_ZOOM");
                        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MAP_MOVE);
                        BNMapController.getInstance().getMapController().d(true);
                        break;
                }
            }
            BNMapObserver bNMapObserver = this.b;
            if (bNMapObserver != null) {
                bNMapObserver.update(cVar, i, i2, obj);
            }
        }
    }
}
