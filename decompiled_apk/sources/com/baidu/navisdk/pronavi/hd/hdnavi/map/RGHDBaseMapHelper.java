package com.baidu.navisdk.pronavi.hd.hdnavi.map;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import X0.IIXOooo;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.framework.interfaces.pronavi.hd.a;
import com.baidu.navisdk.ui.routeguide.control.q;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGStateCar3D;
import com.baidu.navisdk.ui.routeguide.fsm.RGStateNorth2D;
import com.baidu.navisdk.ui.routeguide.utils.b;
import com.baidu.navisdk.util.common.g;
import com.baidu.nplatform.comapi.map.j;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.MapViewSurfaceListener;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class RGHDBaseMapHelper implements a {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "RGHDBaseMapHelper";
    private static boolean isPortraitOriginal;

    @oOoXoXO
    private static MapStatus.WinRound originalWinRound;
    private final com.baidu.navisdk.pronavi.hd.hdnavi.model.a hdSize;
    private final MapStatus.WinRound lastWinRound;
    private int mCurHDState;
    private int mScreenHeight;
    private int mScreenWidth;
    private final X0IIOO mSurfaceListener$delegate;

    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        @oOoXoXO
        public final MapStatus.WinRound getOriginalWinRound() {
            return RGHDBaseMapHelper.originalWinRound;
        }

        public final void initOriginalWinRound(boolean z, @OOXIXo MapStatus mapStatus) {
            IIX0o.x0xO0oo(mapStatus, "mapStatus");
            if (getOriginalWinRound() == null) {
                setOriginalWinRound(new MapStatus.WinRound());
                setPortraitOriginal(z);
                MapStatus.WinRound originalWinRound = getOriginalWinRound();
                IIX0o.ooOOo0oXI(originalWinRound);
                originalWinRound.bottom = mapStatus.winRound.bottom;
                MapStatus.WinRound originalWinRound2 = getOriginalWinRound();
                IIX0o.ooOOo0oXI(originalWinRound2);
                originalWinRound2.top = mapStatus.winRound.top;
                MapStatus.WinRound originalWinRound3 = getOriginalWinRound();
                IIX0o.ooOOo0oXI(originalWinRound3);
                originalWinRound3.left = mapStatus.winRound.left;
                MapStatus.WinRound originalWinRound4 = getOriginalWinRound();
                IIX0o.ooOOo0oXI(originalWinRound4);
                originalWinRound4.right = mapStatus.winRound.right;
                g gVar = g.PRO_NAV;
                if (gVar.d()) {
                    printWinRound(getOriginalWinRound(), "initOriginalWinRound");
                    gVar.e(RGHDBaseMapHelper.TAG, "initOriginalWinRound " + z);
                }
            }
        }

        public final boolean isPortraitOriginal() {
            return RGHDBaseMapHelper.isPortraitOriginal;
        }

        public final void printWinRound(@oOoXoXO MapStatus.WinRound winRound, @OOXIXo String methodName) {
            Integer num;
            Integer num2;
            Integer num3;
            IIX0o.x0xO0oo(methodName, "methodName");
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append(methodName);
                sb.append(", winRound{");
                Integer num4 = null;
                if (winRound != null) {
                    num = Integer.valueOf(winRound.left);
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(',');
                if (winRound != null) {
                    num2 = Integer.valueOf(winRound.top);
                } else {
                    num2 = null;
                }
                sb.append(num2);
                sb.append(',');
                if (winRound != null) {
                    num3 = Integer.valueOf(winRound.right);
                } else {
                    num3 = null;
                }
                sb.append(num3);
                sb.append(',');
                if (winRound != null) {
                    num4 = Integer.valueOf(winRound.bottom);
                }
                sb.append(num4);
                sb.append('}');
                gVar.e(RGHDBaseMapHelper.TAG, sb.toString());
            }
        }

        public final void resetWinRoundQuitNavi(boolean z) {
            MapStatus mapStatus;
            if (getOriginalWinRound() != null) {
                g gVar = g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e(RGHDBaseMapHelper.TAG, "resetWinRoundQuitNavi hdState: " + b.i() + ", " + z);
                    printWinRound(getOriginalWinRound(), "resetWinRoundQuitNavi original:");
                }
                com.baidu.baidunavis.maplayer.a h = com.baidu.baidunavis.maplayer.a.h();
                IIX0o.oO(h, "BMMapGLSurfaceView.getInstance()");
                MapController a2 = h.a();
                if (a2 != null) {
                    mapStatus = a2.getMapStatus();
                } else {
                    mapStatus = null;
                }
                if (mapStatus != null) {
                    if (gVar.d()) {
                        RGHDBaseMapHelper.Companion.printWinRound(mapStatus.winRound, "resetWinRoundQuitNavi current:");
                    }
                    com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
                    int a3 = aVar.a();
                    int b = aVar.b();
                    if (gVar.d()) {
                        gVar.e(RGHDBaseMapHelper.TAG, "screen: " + b + ':' + a3);
                    }
                    if (z) {
                        if (mapStatus.winRound.bottom < a3) {
                            Companion companion = RGHDBaseMapHelper.Companion;
                            if (companion.isPortraitOriginal()) {
                                MapStatus.WinRound winRound = mapStatus.winRound;
                                MapStatus.WinRound originalWinRound = companion.getOriginalWinRound();
                                IIX0o.ooOOo0oXI(originalWinRound);
                                winRound.bottom = originalWinRound.bottom;
                                MapStatus.WinRound winRound2 = mapStatus.winRound;
                                MapStatus.WinRound originalWinRound2 = companion.getOriginalWinRound();
                                IIX0o.ooOOo0oXI(originalWinRound2);
                                winRound2.right = originalWinRound2.right;
                            } else {
                                MapStatus.WinRound winRound3 = mapStatus.winRound;
                                MapStatus.WinRound originalWinRound3 = companion.getOriginalWinRound();
                                IIX0o.ooOOo0oXI(originalWinRound3);
                                winRound3.bottom = originalWinRound3.right;
                                MapStatus.WinRound winRound4 = mapStatus.winRound;
                                MapStatus.WinRound originalWinRound4 = companion.getOriginalWinRound();
                                IIX0o.ooOOo0oXI(originalWinRound4);
                                winRound4.right = originalWinRound4.bottom;
                            }
                            MapStatus.WinRound winRound5 = mapStatus.winRound;
                            winRound5.right = IIXOooo.OxxIIOOXO(winRound5.right, b);
                            MapStatus.WinRound winRound6 = mapStatus.winRound;
                            winRound6.bottom = IIXOooo.OxxIIOOXO(winRound6.bottom, a3);
                            if (gVar.d()) {
                                companion.printWinRound(mapStatus.winRound, "portrait resetWinRoundQuitNavi");
                            }
                        }
                    } else if (mapStatus.winRound.right < a3) {
                        Companion companion2 = RGHDBaseMapHelper.Companion;
                        if (!companion2.isPortraitOriginal()) {
                            MapStatus.WinRound winRound7 = mapStatus.winRound;
                            MapStatus.WinRound originalWinRound5 = companion2.getOriginalWinRound();
                            IIX0o.ooOOo0oXI(originalWinRound5);
                            winRound7.right = originalWinRound5.right;
                            MapStatus.WinRound winRound8 = mapStatus.winRound;
                            MapStatus.WinRound originalWinRound6 = companion2.getOriginalWinRound();
                            IIX0o.ooOOo0oXI(originalWinRound6);
                            winRound8.bottom = originalWinRound6.bottom;
                        } else {
                            MapStatus.WinRound winRound9 = mapStatus.winRound;
                            MapStatus.WinRound originalWinRound7 = companion2.getOriginalWinRound();
                            IIX0o.ooOOo0oXI(originalWinRound7);
                            winRound9.right = originalWinRound7.bottom;
                            MapStatus.WinRound winRound10 = mapStatus.winRound;
                            MapStatus.WinRound originalWinRound8 = companion2.getOriginalWinRound();
                            IIX0o.ooOOo0oXI(originalWinRound8);
                            winRound10.bottom = originalWinRound8.right;
                        }
                        MapStatus.WinRound winRound11 = mapStatus.winRound;
                        winRound11.right = IIXOooo.OxxIIOOXO(winRound11.right, a3);
                        MapStatus.WinRound winRound12 = mapStatus.winRound;
                        winRound12.bottom = IIXOooo.OxxIIOOXO(winRound12.bottom, b);
                        if (gVar.d()) {
                            companion2.printWinRound(mapStatus.winRound, "land resetWinRoundQuitNavi");
                        }
                    }
                    a2.setMapStatus(mapStatus);
                    if (gVar.d()) {
                        RGHDBaseMapHelper.Companion.printWinRound(mapStatus.winRound, "resetWinRoundQuitNavi set later:");
                    }
                }
            }
            setOriginalWinRound(null);
        }

        public final void setOriginalWinRound(@oOoXoXO MapStatus.WinRound winRound) {
            RGHDBaseMapHelper.originalWinRound = winRound;
        }

        public final void setPortraitOriginal(boolean z) {
            RGHDBaseMapHelper.isPortraitOriginal = z;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public final void initOriginalWinRound(boolean z) {
            if (getOriginalWinRound() == null) {
                com.baidu.baidunavis.maplayer.a h = com.baidu.baidunavis.maplayer.a.h();
                IIX0o.oO(h, "BMMapGLSurfaceView.getInstance()");
                MapController a2 = h.a();
                MapStatus mapStatus = a2 != null ? a2.getMapStatus() : null;
                if (mapStatus != null) {
                    Companion companion = RGHDBaseMapHelper.Companion;
                    companion.setOriginalWinRound(new MapStatus.WinRound());
                    companion.setPortraitOriginal(z);
                    MapStatus.WinRound originalWinRound = companion.getOriginalWinRound();
                    IIX0o.ooOOo0oXI(originalWinRound);
                    originalWinRound.bottom = mapStatus.winRound.bottom;
                    MapStatus.WinRound originalWinRound2 = companion.getOriginalWinRound();
                    IIX0o.ooOOo0oXI(originalWinRound2);
                    originalWinRound2.top = mapStatus.winRound.top;
                    MapStatus.WinRound originalWinRound3 = companion.getOriginalWinRound();
                    IIX0o.ooOOo0oXI(originalWinRound3);
                    originalWinRound3.left = mapStatus.winRound.left;
                    MapStatus.WinRound originalWinRound4 = companion.getOriginalWinRound();
                    IIX0o.ooOOo0oXI(originalWinRound4);
                    originalWinRound4.right = mapStatus.winRound.right;
                    g gVar = g.PRO_NAV;
                    if (gVar.d()) {
                        companion.printWinRound(companion.getOriginalWinRound(), "initOriginalWinRound");
                        gVar.e(RGHDBaseMapHelper.TAG, "initOriginalWinRound " + z);
                    }
                }
            }
        }
    }

    public RGHDBaseMapHelper(@OOXIXo com.baidu.navisdk.pronavi.hd.hdnavi.model.a hdSize) {
        IIX0o.x0xO0oo(hdSize, "hdSize");
        this.hdSize = hdSize;
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        this.mScreenWidth = aVar.b();
        this.mScreenHeight = aVar.a();
        this.lastWinRound = new MapStatus.WinRound();
        initScreenSize();
        this.mSurfaceListener$delegate = XIxXXX0x0.oIX0oI(new oIX0oI<MapViewSurfaceListener>() { // from class: com.baidu.navisdk.pronavi.hd.hdnavi.map.RGHDBaseMapHelper$mSurfaceListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OOXIXo
            public final MapViewSurfaceListener invoke() {
                return new MapViewSurfaceListener() { // from class: com.baidu.navisdk.pronavi.hd.hdnavi.map.RGHDBaseMapHelper$mSurfaceListener$2.1
                    @Override // com.baidu.platform.comapi.map.MapViewSurfaceListener
                    public final void onSurfaceChanged(int i, int i2) {
                        g gVar = g.PRO_NAV;
                        if (gVar.d()) {
                            gVar.e("RGHDBaseMapHelper", "onSurfaceChanged: " + i + ':' + i2);
                        }
                        RGHDBaseMapHelper.this.onSizeChange();
                    }
                };
            }
        });
    }

    private final MapViewSurfaceListener getMSurfaceListener() {
        return (MapViewSurfaceListener) this.mSurfaceListener$delegate.getValue();
    }

    private final void initScreenSize() {
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        this.mScreenWidth = aVar.b();
        this.mScreenHeight = aVar.a();
    }

    private final void setWindowRound(int i, boolean z) {
        MapStatus mapStatus;
        g gVar = g.PRO_NAV;
        if (gVar.c()) {
            gVar.c(TAG, "setWindowRound: " + i + ",isPortrait: " + z);
        }
        com.baidu.baidunavis.maplayer.a h = com.baidu.baidunavis.maplayer.a.h();
        IIX0o.oO(h, "BMMapGLSurfaceView.getInstance()");
        MapController a2 = h.a();
        if (a2 != null) {
            mapStatus = a2.getMapStatus();
        } else {
            mapStatus = null;
        }
        if (mapStatus != null) {
            if (z) {
                MapStatus.WinRound winRound = mapStatus.winRound;
                winRound.left = 0;
                winRound.top = 0;
                if (i != 2) {
                    if (i != 3) {
                        winRound.right = this.mScreenWidth;
                        winRound.bottom = this.mScreenHeight;
                    } else {
                        winRound.right = 1;
                        winRound.bottom = 1;
                    }
                } else {
                    winRound.right = this.mScreenWidth;
                    winRound.bottom = (this.mScreenHeight - this.hdSize.f()) + com.baidu.navisdk.pronavi.hd.hdnavi.model.a.h.b();
                }
            } else {
                MapStatus.WinRound winRound2 = mapStatus.winRound;
                winRound2.left = 0;
                winRound2.top = 0;
                if (i != 2) {
                    if (i != 3) {
                        winRound2.bottom = this.mScreenWidth;
                        winRound2.right = this.mScreenHeight;
                    } else {
                        winRound2.right = 1;
                        winRound2.bottom = 1;
                    }
                } else {
                    winRound2.bottom = this.mScreenWidth;
                    winRound2.right = (this.mScreenHeight - this.hdSize.c()) + com.baidu.navisdk.pronavi.hd.hdnavi.model.a.h.b();
                }
            }
            if (gVar.c()) {
                gVar.c(TAG, "setWindowRound: " + mapStatus + ",winRound{" + mapStatus.winRound.left + ',' + mapStatus.winRound.top + ',' + mapStatus.winRound.right + ',' + mapStatus.winRound.bottom + '}');
            }
            a2.setMapStatusWithAnimation(mapStatus, 4, 0);
        }
    }

    public final void addSurfaceListener() {
        com.baidu.baidunavis.maplayer.a h = com.baidu.baidunavis.maplayer.a.h();
        IIX0o.oO(h, "BMMapGLSurfaceView.getInstance()");
        MapController a2 = h.a();
        if (a2 != null) {
            a2.setMapViewSurfaceListener(getMSurfaceListener());
        }
    }

    public final void changeBaseMapWinRound(int i, boolean z) {
        MapStatus mapStatus;
        MapStatus.WinRound winRound;
        com.baidu.baidunavis.maplayer.a h = com.baidu.baidunavis.maplayer.a.h();
        IIX0o.oO(h, "BMMapGLSurfaceView.getInstance()");
        MapController a2 = h.a();
        if (a2 != null && (winRound = (mapStatus = a2.getMapStatus()).winRound) != null) {
            MapStatus.WinRound winRound2 = this.lastWinRound;
            winRound2.bottom = winRound.bottom;
            winRound2.top = winRound.top;
            winRound2.left = winRound.left;
            winRound2.right = winRound.right;
            winRound.left = 0;
            winRound.top = 0;
            if (z) {
                winRound.right = this.mScreenWidth;
                winRound.bottom = this.mScreenHeight - i;
            } else {
                winRound.bottom = this.mScreenWidth;
                winRound.right = this.mScreenHeight - i;
            }
            if (!IIX0o.Oxx0IOOO(winRound2, winRound)) {
                Companion.printWinRound(mapStatus.winRound, "changeBaseMapWinRound");
                a2.setMapStatusWithAnimation(mapStatus, 4, 0);
            }
        }
    }

    public final void onAnimatorStartBaseMapOffsetXY(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "onAnimatorStartBaseMapOffsetXY: " + i);
        }
        BNMapController bNMapController = BNMapController.getInstance();
        IIX0o.oO(bNMapController, "BNMapController.getInstance()");
        com.baidu.nplatform.comapi.basestruct.b mapStatus = bNMapController.getMapStatus();
        BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
        IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
        if (bNCommSettingManager.getMapMode() == 1) {
            RGStateCar3D.setXYOffset(mapStatus);
        } else {
            RGStateNorth2D.setXYOffset(mapStatus, false);
        }
        BNMapController.getInstance().setMapStatus(mapStatus, j.b.eAnimationArc, i, true);
    }

    public final void onDestroy(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.c()) {
            gVar.c(TAG, "onDestroy:" + z);
        }
        com.baidu.baidunavis.maplayer.a h = com.baidu.baidunavis.maplayer.a.h();
        IIX0o.oO(h, "BMMapGLSurfaceView.getInstance()");
        MapController a2 = h.a();
        if (a2 != null) {
            a2.setMapViewSurfaceListener(null);
        }
        Companion.resetWinRoundQuitNavi(z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.a
    public void onHdStateSwitch(int i, int i2, boolean z) {
        this.mCurHDState = i2;
    }

    public final void onSizeChange() {
        initScreenSize();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "onSizeChange: " + this.mScreenWidth + ':' + this.mScreenHeight + ";curState: " + this.mCurHDState + ", " + b.i());
        }
        int i = this.mCurHDState;
        if (i != 0) {
            com.baidu.navisdk.ui.routeguide.mapmode.a b = x.b();
            IIX0o.oO(b, "RGViewController.getInstance()");
            setWindowRound(i, b.s2());
        }
    }

    public final void pauseBaseMapDraw() {
        com.baidu.baidunavis.maplayer.a h = com.baidu.baidunavis.maplayer.a.h();
        IIX0o.oO(h, "BMMapGLSurfaceView.getInstance()");
        MapController a2 = h.a();
        if (a2 != null) {
            MapStatus mapStatus = a2.getMapStatus();
            MapStatus.WinRound winRound = mapStatus.winRound;
            winRound.left = 0;
            winRound.top = 0;
            winRound.right = 1;
            winRound.bottom = 1;
            Companion.printWinRound(winRound, "pauseBaseMapDraw");
            a2.setMapStatusWithAnimation(mapStatus, 4, 0);
        }
    }

    public final void setMapShowScreenRect() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "setMapShowScreenRect");
        }
        q.c().b();
    }
}
