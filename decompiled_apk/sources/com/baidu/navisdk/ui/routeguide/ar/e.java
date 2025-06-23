package com.baidu.navisdk.ui.routeguide.ar;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.ui.routeguide.control.o;
import com.baidu.navisdk.ui.routeguide.control.q;
import com.baidu.navisdk.ui.routeguide.fsm.RGStateCar3D;
import com.baidu.navisdk.ui.routeguide.fsm.RGStateNorth2D;
import com.baidu.nplatform.comapi.map.j;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.MapViewSurfaceListener;
import kotlin.Pair;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes8.dex */
public final class e implements com.baidu.navisdk.framework.interfaces.pronavi.hd.a, com.baidu.navisdk.framework.interfaces.pronavi.hd.b {

    @oOoXoXO
    private static MapStatus.WinRound h;
    private static boolean i;

    @OOXIXo
    public static final a j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private int f8462a;
    private int b;
    private int c;
    private final X0IIOO d;
    private int e;
    private int f;
    private boolean g;

    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        @oOoXoXO
        public final MapStatus.WinRound a() {
            return e.h;
        }

        public final boolean b() {
            return e.i;
        }

        public final void c(boolean z) {
            e.i = z;
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }

        public final void a(@oOoXoXO MapStatus.WinRound winRound) {
            e.h = winRound;
        }

        public final void b(boolean z) {
            if (a() != null) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGArNaviBaseMapHelper", "resetWinRoundQuitNavi hdState, " + z);
                    a(a(), "resetWinRoundQuitNavi original:");
                }
                com.baidu.baidunavis.maplayer.a h = com.baidu.baidunavis.maplayer.a.h();
                IIX0o.oO(h, "BMMapGLSurfaceView.getInstance()");
                MapController a2 = h.a();
                MapStatus mapStatus = a2 != null ? a2.getMapStatus() : null;
                if (mapStatus != null) {
                    if (gVar.d()) {
                        e.j.a(mapStatus.winRound, "resetWinRoundQuitNavi current:");
                    }
                    com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
                    int a3 = aVar.a();
                    int b = aVar.b();
                    if (gVar.d()) {
                        gVar.e("RGArNaviBaseMapHelper", "screen: " + b + ':' + a3);
                    }
                    if (z) {
                        MapStatus.WinRound winRound = mapStatus.winRound;
                        if (winRound.bottom - winRound.top < a3) {
                            a aVar2 = e.j;
                            MapStatus.WinRound a4 = aVar2.a();
                            IIX0o.ooOOo0oXI(a4);
                            winRound.top = a4.top;
                            MapStatus.WinRound winRound2 = mapStatus.winRound;
                            MapStatus.WinRound a5 = aVar2.a();
                            IIX0o.ooOOo0oXI(a5);
                            winRound2.left = a5.left;
                            if (aVar2.b()) {
                                MapStatus.WinRound winRound3 = mapStatus.winRound;
                                MapStatus.WinRound a6 = aVar2.a();
                                IIX0o.ooOOo0oXI(a6);
                                winRound3.bottom = a6.bottom;
                                MapStatus.WinRound winRound4 = mapStatus.winRound;
                                MapStatus.WinRound a7 = aVar2.a();
                                IIX0o.ooOOo0oXI(a7);
                                winRound4.right = a7.right;
                            } else {
                                MapStatus.WinRound winRound5 = mapStatus.winRound;
                                MapStatus.WinRound a8 = aVar2.a();
                                IIX0o.ooOOo0oXI(a8);
                                winRound5.bottom = a8.right;
                                MapStatus.WinRound winRound6 = mapStatus.winRound;
                                MapStatus.WinRound a9 = aVar2.a();
                                IIX0o.ooOOo0oXI(a9);
                                winRound6.right = a9.bottom;
                            }
                            MapStatus.WinRound winRound7 = mapStatus.winRound;
                            winRound7.right = X0.IIXOooo.OxxIIOOXO(winRound7.right, b);
                            MapStatus.WinRound winRound8 = mapStatus.winRound;
                            winRound8.bottom = X0.IIXOooo.OxxIIOOXO(winRound8.bottom, a3);
                            if (gVar.d()) {
                                aVar2.a(mapStatus.winRound, "portrait resetWinRoundQuitNavi");
                            }
                            a2.setMapStatus(mapStatus);
                        }
                    } else {
                        MapStatus.WinRound winRound9 = mapStatus.winRound;
                        if (winRound9.right - winRound9.left < a3) {
                            a aVar3 = e.j;
                            MapStatus.WinRound a10 = aVar3.a();
                            IIX0o.ooOOo0oXI(a10);
                            winRound9.top = a10.top;
                            MapStatus.WinRound winRound10 = mapStatus.winRound;
                            MapStatus.WinRound a11 = aVar3.a();
                            IIX0o.ooOOo0oXI(a11);
                            winRound10.left = a11.left;
                            if (!aVar3.b()) {
                                MapStatus.WinRound winRound11 = mapStatus.winRound;
                                MapStatus.WinRound a12 = aVar3.a();
                                IIX0o.ooOOo0oXI(a12);
                                winRound11.right = a12.right;
                                MapStatus.WinRound winRound12 = mapStatus.winRound;
                                MapStatus.WinRound a13 = aVar3.a();
                                IIX0o.ooOOo0oXI(a13);
                                winRound12.bottom = a13.bottom;
                            } else {
                                MapStatus.WinRound winRound13 = mapStatus.winRound;
                                MapStatus.WinRound a14 = aVar3.a();
                                IIX0o.ooOOo0oXI(a14);
                                winRound13.right = a14.bottom;
                                MapStatus.WinRound winRound14 = mapStatus.winRound;
                                MapStatus.WinRound a15 = aVar3.a();
                                IIX0o.ooOOo0oXI(a15);
                                winRound14.bottom = a15.right;
                            }
                            MapStatus.WinRound winRound15 = mapStatus.winRound;
                            winRound15.right = X0.IIXOooo.OxxIIOOXO(winRound15.right, a3);
                            MapStatus.WinRound winRound16 = mapStatus.winRound;
                            winRound16.bottom = X0.IIXOooo.OxxIIOOXO(winRound16.bottom, b);
                            if (gVar.d()) {
                                aVar3.a(mapStatus.winRound, "land resetWinRoundQuitNavi");
                            }
                            a2.setMapStatus(mapStatus);
                        }
                    }
                    if (gVar.d()) {
                        e.j.a(mapStatus.winRound, "resetWinRoundQuitNavi set later:");
                    }
                }
            }
            a((MapStatus.WinRound) null);
        }

        public final void a(boolean z) {
            if (a() == null) {
                com.baidu.baidunavis.maplayer.a h = com.baidu.baidunavis.maplayer.a.h();
                IIX0o.oO(h, "BMMapGLSurfaceView.getInstance()");
                MapController a2 = h.a();
                MapStatus mapStatus = a2 != null ? a2.getMapStatus() : null;
                if (mapStatus != null) {
                    a aVar = e.j;
                    aVar.a(new MapStatus.WinRound());
                    aVar.c(z);
                    MapStatus.WinRound a3 = aVar.a();
                    IIX0o.ooOOo0oXI(a3);
                    a3.bottom = mapStatus.winRound.bottom;
                    MapStatus.WinRound a4 = aVar.a();
                    IIX0o.ooOOo0oXI(a4);
                    a4.top = mapStatus.winRound.top;
                    MapStatus.WinRound a5 = aVar.a();
                    IIX0o.ooOOo0oXI(a5);
                    a5.left = mapStatus.winRound.left;
                    MapStatus.WinRound a6 = aVar.a();
                    IIX0o.ooOOo0oXI(a6);
                    a6.right = mapStatus.winRound.right;
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar.d()) {
                        aVar.a(aVar.a(), "initOriginalWinRound");
                        gVar.e("RGArNaviBaseMapHelper", "initOriginalWinRound " + z);
                    }
                }
            }
        }

        public final void a(@oOoXoXO MapStatus.WinRound winRound, @OOXIXo String methodName) {
            IIX0o.x0xO0oo(methodName, "methodName");
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append(methodName);
                sb.append(", winRound{");
                sb.append(winRound != null ? Integer.valueOf(winRound.left) : null);
                sb.append(',');
                sb.append(winRound != null ? Integer.valueOf(winRound.top) : null);
                sb.append(',');
                sb.append(winRound != null ? Integer.valueOf(winRound.right) : null);
                sb.append(',');
                sb.append(winRound != null ? Integer.valueOf(winRound.bottom) : null);
                sb.append('}');
                gVar.e("RGArNaviBaseMapHelper", sb.toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements oIX0oI<MapViewSurfaceListener> {

        /* loaded from: classes8.dex */
        public static final class a implements MapViewSurfaceListener {
            public a(b bVar) {
            }
        }

        public b(e eVar) {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final MapViewSurfaceListener invoke() {
            return new a(this);
        }
    }

    public e(int i2, int i3, boolean z) {
        this.e = i2;
        this.f = i3;
        this.g = z;
        g();
        this.d = XIxXXX0x0.oIX0oI(new b(this));
    }

    private final MapViewSurfaceListener e() {
        return (MapViewSurfaceListener) this.d.getValue();
    }

    private final void f() {
        int i2 = this.f8462a;
        if (i2 != 0) {
            a(i2, this.g);
            if (this.f8462a == 2) {
                d(this.g);
            }
        }
    }

    private final void g() {
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        this.b = aVar.b();
        this.c = aVar.a();
    }

    private final void h() {
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
        BNMapController.getInstance().setMapStatus(mapStatus, j.b.eAnimationArc, o.A(), true);
    }

    private final void i() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArNaviBaseMapHelper", "setMapShowScreenRect");
        }
        q.c().b();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void b(int i2, int i3, boolean z, @OOXIXo com.baidu.navisdk.framework.interfaces.pronavi.hd.f params) {
        IIX0o.x0xO0oo(params, "params");
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.a
    public void onHdStateSwitch(int i2, int i3, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArNaviBaseMapHelper", "onARStateSwitch: " + i2 + org.apache.commons.text.oIX0oI.f33048oxoX + i3 + ", isPortrait: " + z + ", curState:" + this.f8462a);
        }
        if (i2 == 0 && i3 != 0) {
            j.a(z);
        }
        this.f8462a = i3;
    }

    private final void d(boolean z) {
        int i2;
        int i3;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArNaviBaseMapHelper", "onEnterMultiSetXYOffset: " + z);
        }
        BNMapController bNMapController = BNMapController.getInstance();
        IIX0o.oO(bNMapController, "BNMapController.getInstance()");
        com.baidu.nplatform.comapi.basestruct.b mapStatus = bNMapController.getMapStatus();
        if (mapStatus != null) {
            com.baidu.navisdk.pronavi.carlogooffset.i.b f = com.baidu.navisdk.ui.routeguide.utils.b.f();
            Pair<Long, Long> pair = null;
            com.baidu.navisdk.pronavi.carlogooffset.i.a a2 = f != null ? f.a(1) : null;
            if (z) {
                i2 = this.e;
                i3 = 1;
            } else {
                i2 = this.b;
                i3 = 2;
            }
            if (a2 != null) {
                BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
                IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
                pair = a2.a(i3, bNCommSettingManager.getMapMode(), Integer.valueOf(i2));
            }
            if (pair != null) {
                mapStatus.i = pair.getFirst().longValue();
                mapStatus.j = pair.getSecond().longValue();
                BNMapController.getInstance().setMapStatus(mapStatus, j.b.eAnimationArc, 1000, true);
            }
        }
    }

    public final void a(int i2) {
        this.g = i2 != 2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArNaviBaseMapHelper", "aronOrientationChange: " + i2 + ", " + this.g);
        }
        f();
    }

    public final void b() {
        g();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArNaviBaseMapHelper", "onSizeChange: " + this.b + ':' + this.c + ";curState: " + this.f8462a + ", " + this.g);
        }
        f();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void e(int i2, int i3, boolean z, @OOXIXo com.baidu.navisdk.framework.interfaces.pronavi.hd.f params) {
        IIX0o.x0xO0oo(params, "params");
        i();
        d(z);
        a(2, z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void f(int i2, int i3, boolean z, @OOXIXo com.baidu.navisdk.framework.interfaces.pronavi.hd.f params) {
        IIX0o.x0xO0oo(params, "params");
        i();
        h();
        a(0, z);
    }

    private final void a(int i2, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.c()) {
            gVar.c("RGArNaviBaseMapHelper", "setWindowRound: " + i2 + ",isPortrait: " + z);
        }
        com.baidu.baidunavis.maplayer.a h2 = com.baidu.baidunavis.maplayer.a.h();
        IIX0o.oO(h2, "BMMapGLSurfaceView.getInstance()");
        MapController a2 = h2.a();
        MapStatus mapStatus = a2 != null ? a2.getMapStatus() : null;
        if (mapStatus != null) {
            if (z) {
                MapStatus.WinRound winRound = mapStatus.winRound;
                winRound.left = 0;
                int i3 = this.c;
                winRound.bottom = i3;
                winRound.right = this.b;
                if (i2 == 2) {
                    winRound.top = i3 - this.e;
                } else if (i2 != 3) {
                    winRound.top = 0;
                } else {
                    winRound.right = 1;
                    winRound.top = i3 - 1;
                }
            } else {
                MapStatus.WinRound winRound2 = mapStatus.winRound;
                winRound2.top = 0;
                int i4 = this.c;
                winRound2.right = i4;
                winRound2.bottom = this.b;
                if (i2 == 2) {
                    winRound2.left = i4 - this.f;
                } else if (i2 != 3) {
                    winRound2.left = 0;
                } else {
                    winRound2.bottom = 1;
                    winRound2.left = i4 - 1;
                }
            }
            if (gVar.c()) {
                gVar.c("RGArNaviBaseMapHelper", "setWindowRound: " + mapStatus + ",winRound{" + mapStatus.winRound.left + ',' + mapStatus.winRound.top + ',' + mapStatus.winRound.right + ',' + mapStatus.winRound.bottom + '}');
            }
            a2.setMapStatusWithAnimation(mapStatus, 4, 0);
        }
    }

    public final void b(boolean z) {
        com.baidu.baidunavis.maplayer.a h2 = com.baidu.baidunavis.maplayer.a.h();
        IIX0o.oO(h2, "BMMapGLSurfaceView.getInstance()");
        MapController a2 = h2.a();
        if (a2 != null) {
            MapStatus mapStatus = a2.getMapStatus();
            MapStatus.WinRound winRound = mapStatus.winRound;
            winRound.left = 0;
            winRound.right = 1;
            int i2 = this.c;
            winRound.top = i2 - 1;
            winRound.bottom = i2;
            if (z) {
                winRound.right = 1;
                winRound.top = i2 - 1;
                winRound.left = 0;
                winRound.bottom = i2;
            } else {
                winRound.top = 0;
                winRound.right = i2;
                winRound.bottom = 1;
                winRound.left = i2 - 1;
            }
            j.a(winRound, "pauseBaseMapDraw");
            a2.setMapStatusWithAnimation(mapStatus, 4, 0);
        }
    }

    public final void a() {
        com.baidu.baidunavis.maplayer.a h2 = com.baidu.baidunavis.maplayer.a.h();
        IIX0o.oO(h2, "BMMapGLSurfaceView.getInstance()");
        MapController a2 = h2.a();
        if (a2 != null) {
            a2.setMapViewSurfaceListener(e());
        }
    }

    public final void a(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.c()) {
            gVar.c("RGArNaviBaseMapHelper", "onDestroy:" + z);
        }
        com.baidu.baidunavis.maplayer.a h2 = com.baidu.baidunavis.maplayer.a.h();
        IIX0o.oO(h2, "BMMapGLSurfaceView.getInstance()");
        MapController a2 = h2.a();
        if (a2 != null) {
            a2.setMapViewSurfaceListener(null);
        }
        j.b(z);
    }
}
