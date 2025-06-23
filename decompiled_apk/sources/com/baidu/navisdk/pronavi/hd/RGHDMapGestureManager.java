package com.baidu.navisdk.pronavi.hd;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.pronavi.hd.RGHDMapGestureManager;
import com.baidu.navisdk.pronavi.hd.RGHDMapGestureManager$naviMapViewListener$2;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.util.common.g;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.NaviMapGestureAdapter;
import com.baidu.platform.comapi.map.NaviMapViewListener;
import com.baidu.platform.comapi.map.SimpleGestureAdapter;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class RGHDMapGestureManager {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7719a;

    @oOoXoXO
    private OnMapActionCallback b;
    private final X0IIOO c;
    private final X0IIOO d;
    private final X0IIOO e;
    private NaviMapGestureAdapter f;
    private final MapTextureView g;
    private final MapController h;
    private final Context i;

    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class HDSimpleGestureAdapter extends SimpleGestureAdapter {
        @Override // com.baidu.platform.comapi.map.SimpleGestureAdapter, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(@OOXIXo MotionEvent e) {
            IIX0o.x0xO0oo(e, "e");
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public interface OnMapActionCallback {
        void onAction(int i);
    }

    static {
        new Companion(null);
    }

    public RGHDMapGestureManager(@OOXIXo MapTextureView surfaceView, @OOXIXo MapController mapController, @OOXIXo Context context) {
        IIX0o.x0xO0oo(surfaceView, "surfaceView");
        IIX0o.x0xO0oo(mapController, "mapController");
        IIX0o.x0xO0oo(context, "context");
        this.g = surfaceView;
        this.h = mapController;
        this.i = context;
        this.f7719a = true;
        this.c = XIxXXX0x0.oIX0oI(new oIX0oI<HDSimpleGestureAdapter>() { // from class: com.baidu.navisdk.pronavi.hd.RGHDMapGestureManager$simpleGestureAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OOXIXo
            public final RGHDMapGestureManager.HDSimpleGestureAdapter invoke() {
                return new RGHDMapGestureManager.HDSimpleGestureAdapter();
            }
        });
        this.d = XIxXXX0x0.oIX0oI(new oIX0oI<GestureDetector>() { // from class: com.baidu.navisdk.pronavi.hd.RGHDMapGestureManager$gestureDetector$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OOXIXo
            public final GestureDetector invoke() {
                Context context2;
                SimpleGestureAdapter e;
                context2 = RGHDMapGestureManager.this.i;
                e = RGHDMapGestureManager.this.e();
                return new GestureDetector(context2, e);
            }
        });
        this.e = XIxXXX0x0.oIX0oI(new oIX0oI<RGHDMapGestureManager$naviMapViewListener$2.AnonymousClass1>() { // from class: com.baidu.navisdk.pronavi.hd.RGHDMapGestureManager$naviMapViewListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.navisdk.pronavi.hd.RGHDMapGestureManager$naviMapViewListener$2$1] */
            @Override // Oox.oIX0oI
            @OOXIXo
            public final AnonymousClass1 invoke() {
                return new NaviMapViewListener() { // from class: com.baidu.navisdk.pronavi.hd.RGHDMapGestureManager$naviMapViewListener$2.1
                    @Override // com.baidu.platform.comapi.map.NaviMapViewListener
                    public void onAction(int i, @oOoXoXO Object obj) {
                        g gVar = g.PRO_NAV;
                        if (gVar.d()) {
                            gVar.e("RGHDMapGesture", "onAction " + i + " and " + obj);
                        }
                        RGHDMapGestureManager.this.a(i, obj);
                    }

                    @Override // com.baidu.platform.comapi.map.NaviMapViewListener
                    public boolean onItemClick(@oOoXoXO String str, int i, int i2) {
                        g gVar = g.PRO_NAV;
                        if (gVar.d()) {
                            gVar.e("RGHDMapGesture", "onItemClick " + str + ',' + i + ',' + i2);
                            return false;
                        }
                        return false;
                    }

                    @Override // com.baidu.platform.comapi.map.NaviMapViewListener
                    public void onMapAnimationFinish() {
                        g gVar = g.PRO_NAV;
                        if (gVar.d()) {
                            gVar.e("RGHDMapGesture", "onMapAnimationFinish");
                        }
                    }

                    @Override // com.baidu.platform.comapi.map.NaviMapViewListener
                    public void onMapRenderModeChange(int i) {
                    }

                    @Override // com.baidu.platform.comapi.map.NaviMapViewListener
                    @oOoXoXO
                    public Point onTapInterception(@oOoXoXO Point point) {
                        g gVar = g.PRO_NAV;
                        if (gVar.d()) {
                            gVar.e("RGHDMapGesture", "onTapInterception " + point);
                        }
                        return point;
                    }

                    @Override // com.baidu.platform.comapi.map.NaviMapViewListener
                    public void resizeScreen(int i, int i2) {
                        g gVar = g.PRO_NAV;
                        if (gVar.d()) {
                            gVar.e("RGHDMapGesture", "resizeScreen " + i + ',' + i2);
                        }
                    }
                };
            }
        });
    }

    private final GestureDetector c() {
        return (GestureDetector) this.d.getValue();
    }

    private final NaviMapViewListener d() {
        return (NaviMapViewListener) this.e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SimpleGestureAdapter e() {
        return (SimpleGestureAdapter) this.c.getValue();
    }

    public final void b() {
        MapController mapController = this.h;
        if (mapController != null) {
            mapController.setNaviMapViewListener(null);
        }
        e().removeSimpleOnGestureListener(this.f);
    }

    public final void a(boolean z) {
        this.f7719a = z;
    }

    public final void a(@oOoXoXO OnMapActionCallback onMapActionCallback) {
        this.b = onMapActionCallback;
    }

    public final void a() {
        e().setMapController(this.h);
        this.h.setNaviMapViewListener(d());
        if (this.f != null) {
            e().removeSimpleOnGestureListener(this.f);
        } else {
            NaviMapGestureAdapter naviMapGestureAdapter = new NaviMapGestureAdapter();
            this.f = naviMapGestureAdapter;
            IIX0o.ooOOo0oXI(naviMapGestureAdapter);
            naviMapGestureAdapter.setMapController(this.h);
        }
        e().addSimpleOnGestureListener(this.f);
        MapTextureView mapTextureView = this.g;
        if (mapTextureView != null) {
            mapTextureView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.navisdk.pronavi.hd.RGHDMapGestureManager$initListener$1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View v, MotionEvent event) {
                    boolean a2;
                    RGHDMapGestureManager rGHDMapGestureManager = RGHDMapGestureManager.this;
                    IIX0o.oO(v, "v");
                    IIX0o.oO(event, "event");
                    a2 = rGHDMapGestureManager.a(v, event);
                    return a2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(View view, MotionEvent motionEvent) {
        MapStatus mapStatus = this.h.getMapStatus();
        IIX0o.oO(mapStatus, "mapController.mapStatus");
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int x = (int) motionEvent.getX(i);
            int y = (int) motionEvent.getY(i);
            MapStatus.WinRound winRound = mapStatus.winRound;
            if (x < winRound.left || x > winRound.right || y < winRound.top || y > winRound.bottom) {
                return false;
            }
        }
        if (c().onTouchEvent(motionEvent)) {
            return true;
        }
        this.h.handleTouchEvent(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, Object obj) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDMapGesture", "onAction: actionType --> " + i + ',' + this.f7719a);
        }
        OnMapActionCallback onMapActionCallback = this.b;
        if (onMapActionCallback != null) {
            onMapActionCallback.onAction(i);
        }
        if (this.f7719a) {
            return;
        }
        switch (i) {
            case 513:
                BNMapController.getInstance().handleDoubleTouch(null);
                return;
            case 514:
                BNMapController.getInstance().handleSingleTouch(null);
                return;
            case 515:
                BNMapController.getInstance().notifyMapObservers(2, 515, null);
                return;
            case 516:
                com.baidu.navisdk.comapi.statistics.b.f().d("td");
                BNMapController.getInstance().notifyMapObservers(2, 516, null);
                return;
            case 517:
                com.baidu.navisdk.comapi.statistics.b.f().d("dc");
                BNMapController.getInstance().notifyMapObservers(2, 517, obj);
                return;
            case 518:
                BNMapController.getInstance().notifyMapObservers(2, 518, null);
                return;
            case 519:
            default:
                return;
            case 520:
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MAP_MOVE);
                return;
            case 521:
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MAP_MOVE);
                return;
        }
    }
}
