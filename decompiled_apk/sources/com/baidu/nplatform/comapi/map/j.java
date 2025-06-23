package com.baidu.nplatform.comapi.map;

import XIXIX.OOXIXo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.navisdk.comapi.mapcontrol.MapParams;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.b;
import com.google.android.gms.common.util.GmsVersion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class j implements View.OnKeyListener {
    private static final String p = "j";
    private static long q;
    private static float r;
    private static float s;
    private static boolean t;
    private static boolean u;

    /* renamed from: a, reason: collision with root package name */
    public c f9514a;
    private int b;
    private int c;
    private boolean d;
    private boolean e;
    private JNIBaseMap f;
    private m g;
    private int h;
    private Rect i;
    private final com.baidu.navisdk.comapi.base.d j;
    private final com.baidu.nplatform.comapi.map.gesture.b k;
    private boolean l;
    private u m;
    private final Bundle n;
    private final Object o;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.comapi.base.d {
        public a(Looper looper) {
            super(looper);
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(4197);
            observe(4198);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 4197) {
                if (i == 4198 && j.this.q() != null) {
                    j.this.q().onMapNetworkingChanged(false);
                    return;
                }
                return;
            }
            if (j.this.q() != null) {
                j.this.q().onMapNetworkingChanged(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public enum b {
        eAnimationNone(0),
        eAnimationPos(1),
        eAnimationRotate(16),
        eAnimationOverlook(256),
        eAnimationLevel(4096),
        eAnimationAll(4369),
        eAnimationInelligent(268435456),
        eAnimationFrogleap(268435457),
        eAnimationArc(268435712),
        eAnimationViewall(268439552),
        eAnimationPoi(268500992);


        /* renamed from: a, reason: collision with root package name */
        private final int f9516a;

        b(int i) {
            this.f9516a = i;
        }

        public int a() {
            return this.f9516a;
        }
    }

    /* loaded from: classes8.dex */
    public enum c {
        DEFAULT(1),
        INDOOR(2),
        STREET(3),
        STREET_WAITING(4);

        c(int i) {
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
    }

    static {
        new d();
        q = 0L;
        u = true;
    }

    public j(Context context, m mVar) {
        this.f9514a = c.DEFAULT;
        this.d = true;
        this.e = true;
        this.f = null;
        this.g = null;
        this.h = -1;
        a aVar = new a(Looper.getMainLooper());
        this.j = aVar;
        this.k = new com.baidu.nplatform.comapi.map.gesture.b(this);
        this.l = false;
        this.m = null;
        this.n = new Bundle();
        new Handler(Looper.getMainLooper());
        this.o = new Object();
        this.g = mVar;
        mVar.setOnKeyListener(this);
        com.baidu.navisdk.vi.b.a(aVar);
        VDeviceAPI.getScreenDensity();
    }

    private boolean M() {
        if (s <= ScreenUtil.getInstance().dip2px(40)) {
            return true;
        }
        return false;
    }

    public static int o(int i) {
        switch (i) {
            case 1:
                return 10000000;
            case 2:
                return GmsVersion.VERSION_LONGHORN;
            case 3:
                return 2000000;
            case 4:
                return 1000000;
            case 5:
                return 500000;
            case 6:
                return 200000;
            case 7:
                return 100000;
            case 8:
                return 50000;
            case 9:
                return 25000;
            case 10:
                return 20000;
            case 11:
                return 10000;
            case 12:
                return 5000;
            case 13:
                return 2000;
            case 14:
                return 1000;
            case 15:
                return 500;
            case 16:
                return 200;
            case 17:
                return 100;
            case 18:
                return 50;
            case 19:
                return 20;
            case 20:
                return 10;
            case 21:
                return 5;
            case 22:
                return 2;
            default:
                return 0;
        }
    }

    public void A() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap != null) {
            jNIBaseMap.ResetImageRes();
        }
    }

    public boolean B() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.SaveScreenToBuffer();
    }

    public void C() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.set2DCarLogo(1);
    }

    public void D() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.set2DCarLogo(2);
    }

    public void E(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.SetShowTrackBrake(z);
    }

    public void F(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.SetShowTrackCurve(z);
    }

    public void G(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.SetShowTrackMaxSpeed(z);
    }

    public void H() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(p, "unInit(), mBasemap=" + this.f + ", hashCode()=" + hashCode());
        }
        if (this.f != null) {
            this.f = null;
        }
    }

    public void I(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.SetShowTrackRapidAcc(z);
    }

    public boolean J() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.ZoomIn();
    }

    public boolean K() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.ZoomOut();
    }

    public boolean L() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.ZoomToTrajectory();
    }

    public boolean a(int i, boolean z) {
        return false;
    }

    public void b(Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(p, "initBaseMap(), b=" + bundle + ", hashCode()=" + hashCode());
        }
        ScreenUtil.getInstance().getDPI();
        this.b = bundle.getInt("right");
        this.c = bundle.getInt("bottom");
        if (this.f == null) {
            try {
                this.f = new JNIBaseMap();
            } catch (Throwable th) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(p, "initBaseMap,e:" + th);
                }
            }
        }
    }

    public boolean c(MotionEvent motionEvent) {
        this.k.a(motionEvent);
        if (motionEvent.getPointerCount() == 2) {
            u = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            f(motionEvent);
        } else if (action == 1) {
            u = true;
            e(motionEvent);
        } else {
            if (action != 2) {
                return false;
            }
            d(motionEvent);
        }
        return true;
    }

    public boolean d(int i) {
        return false;
    }

    public boolean e(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (u) {
            a(5, 0, (y << 16) | x);
        }
        LogUtil.e("Map", "_MAP_handleTouchUp: bFling " + this.l);
        u uVar = this.g.b;
        if (uVar == null) {
            return true;
        }
        uVar.onMapAnimationFinish();
        return true;
    }

    public void f(boolean z) {
    }

    public com.baidu.nplatform.comapi.basestruct.b g(boolean z) {
        if (this.f == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f.GetMapStatus(bundle, z) ? bundle : null;
        String str = p;
        StringBuilder sb = new StringBuilder();
        sb.append("getMapStatus() --> bundle = ");
        sb.append(bundle2 == null ? "null" : bundle2.toString());
        LogUtil.e(str, sb.toString());
        com.baidu.nplatform.comapi.basestruct.b bVar = new com.baidu.nplatform.comapi.basestruct.b();
        if (bundle2 != null) {
            bVar.f9474a = (float) bundle2.getDouble("level");
            bVar.b = (float) bundle2.getDouble("rotation");
            bVar.c = (int) bundle2.getDouble("overlooking");
            bVar.d = (int) bundle2.getDouble("centerptx");
            bVar.e = (int) bundle2.getDouble("centerpty");
            bVar.g.f9476a = bundle2.getInt("left");
            bVar.g.b = bundle2.getInt("right");
            bVar.g.c = bundle2.getInt("top");
            bVar.g.d = bundle2.getInt("bottom");
            bVar.h.f9475a = bundle2.getLong("gleft");
            bVar.h.b = bundle2.getLong("gright");
            bVar.h.c = bundle2.getLong("gtop");
            bVar.h.d = bundle2.getLong("gbottom");
            bVar.h.e.a(bundle2.getInt("lbx"));
            bVar.h.e.b(bundle2.getInt("lby"));
            bVar.h.f.a(bundle2.getInt("ltx"));
            bVar.h.f.b(bundle2.getInt("lty"));
            bVar.h.g.a(bundle2.getInt("rtx"));
            bVar.h.g.b(bundle2.getInt("rty"));
            bVar.h.h.a(bundle2.getInt("rbx"));
            bVar.h.h.b(bundle2.getInt("rby"));
            bVar.i = bundle2.getFloat("xoffset");
            bVar.j = bundle2.getFloat("yoffset");
            bVar.m = bundle2.getFloat("screen_xoffset");
            bVar.n = bundle2.getFloat("screen_yoffset");
            bVar.k = bundle2.getInt("bfpp") == 1;
        }
        b.a aVar = bVar.h;
        if (aVar.f9475a <= -20037508) {
            aVar.f9475a = -20037508L;
        }
        if (aVar.b >= 20037508) {
            aVar.b = 20037508L;
        }
        if (aVar.c >= 20037508) {
            aVar.c = 20037508L;
        }
        if (aVar.d <= -20037508) {
            aVar.d = -20037508L;
        }
        return bVar;
    }

    public void h(int i) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.SetMemoryScale(i);
    }

    public boolean i(int i) {
        if (this.f == null) {
            if (!LogUtil.LOGGABLE) {
                return false;
            }
            LogUtil.e(p, "setNaviMapMode,mBasemap is null");
            return false;
        }
        String str = p;
        LogUtil.e(str, "setNaviMapMode: mapMode --> " + i);
        boolean naviMapMode = this.f.setNaviMapMode(i);
        LogUtil.e(str, "setNaviMapMode: mapMode end--> ");
        return naviMapMode;
    }

    public boolean j() {
        return this.d;
    }

    public void k(boolean z) {
        this.d = z;
    }

    public float l() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return 18.0f;
        }
        return jNIBaseMap.GetZoomLevel();
    }

    public c m() {
        return this.f9514a;
    }

    public boolean n(int i) {
        JNIBaseMap jNIBaseMap = this.f;
        return jNIBaseMap != null && jNIBaseMap.UpdateLayer(i);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }

    public t p() {
        return this.g;
    }

    public u q() {
        return this.m;
    }

    public int r() {
        return this.c;
    }

    public int s() {
        return this.b;
    }

    public int t() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return 18;
        }
        return Math.round(jNIBaseMap.GetZoomLevel());
    }

    public double u() {
        if (this.f == null) {
            return 1.0d;
        }
        return Math.pow(2.0d, 18.0f - r0.GetZoomLevel());
    }

    public void v() {
        u uVar = this.g.b;
        if (uVar != null) {
            uVar.onDoubleFingerZoom();
        }
    }

    public void w() {
        if (q() == null) {
            return;
        }
        q().onMapAnimationFinish();
    }

    public void x() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap != null) {
            jNIBaseMap.OnPause();
        }
    }

    public boolean y(boolean z) {
        if (this.f == null) {
            return false;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(p, "setNightMode = " + z);
        }
        return this.f.setNightMode(z);
    }

    public boolean z() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.ReleaseSharedMapData(0, 0);
    }

    private void f(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        r = x;
        s = y;
        a(4, 0, (y << 16) | x);
        t = true;
    }

    public void a(MotionEvent motionEvent) {
        if (q() != null) {
            q().onClickedBackground((int) motionEvent.getX(), (int) motionEvent.getY());
        }
    }

    public void d(int i, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(p, "resizeSecreen(), width=" + i + ", height=" + i2);
        }
        this.b = i;
        this.c = i2;
    }

    public boolean j(int i) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.setRouteDetailIndex(i);
    }

    public boolean k(int i) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.setSlightScreenStatus(i);
    }

    public void m(int i) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap != null) {
            jNIBaseMap.UpdateChosenMultiRouteID(i);
        }
    }

    public boolean n(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.SetCharsetEncodeType(z);
    }

    public com.baidu.nplatform.comapi.basestruct.b o() {
        return g(true);
    }

    public void p(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap != null) {
            try {
                jNIBaseMap.SetDrawNaviLogo(z);
            } catch (Throwable unused) {
            }
        }
    }

    public void q(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            com.baidu.navisdk.util.common.g.MAP.c(p, "setEndNodeIconVisible --> mBaseMap is null");
        } else {
            jNIBaseMap.setEndNodeIconVisible(z);
        }
    }

    public void r(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            com.baidu.navisdk.util.common.g.MAP.c(p, "setEndNodeNameVisible --> mBaseMap is null");
        } else {
            jNIBaseMap.setEndNodeNameVisible(z);
        }
    }

    public void s(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.SetEnlargedStatus(z);
    }

    public boolean A(boolean z) {
        if (this.f == null) {
            return false;
        }
        LogUtil.e(p, "setPreRoutePlanStatus: bPreRoutePlanStatus --> " + z);
        return this.f.SetPreRoutePlanStatus(z);
    }

    public boolean B(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.setQuitMossPartZoom(z);
    }

    public boolean C(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.setRedLineRender(z);
    }

    public boolean D(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        boolean routeSearchStatus = jNIBaseMap.setRouteSearchStatus(z);
        LogUtil.e(p, "setRouteSearchStatus: isHasNearbySearchResult --> " + z + ",result --> " + routeSearchStatus);
        return routeSearchStatus;
    }

    public boolean E() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.setNaviCarPos();
    }

    public void F() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            com.baidu.navisdk.util.common.g.MAP.c(p, "mBaseMap is null");
        } else {
            jNIBaseMap.setSlightModeZoomToFullView();
        }
    }

    public boolean G() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.stopAllAnimation();
    }

    public boolean I() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.UpdateShareMapData(0, 0);
    }

    public boolean J(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        boolean simpleModeGuide = jNIBaseMap.setSimpleModeGuide(z);
        LogUtil.e(p, "setSimpleModeGuide: isSimpleMode --> " + z + ",result --> " + simpleModeGuide);
        return simpleModeGuide;
    }

    public void K(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap != null) {
            jNIBaseMap.SwitchITSMode(z);
        }
    }

    public void h(boolean z) {
        if (this.f == null) {
            return;
        }
        JNIBaseMap.notifyOrientation(z);
    }

    public boolean l(boolean z) {
        if (this.f == null) {
            return false;
        }
        LogUtil.e(p, "setAnimationGlobalSwitch: " + z);
        return this.f.SetAnimationGlobalSwitch(z);
    }

    public boolean o(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.setDragMapStatus(z);
    }

    public void t(boolean z) {
        if (this.f == null) {
            LogUtil.e(p, "mBasemap is null");
            return;
        }
        LogUtil.e(p, "SetMap2DLook:" + z);
        this.f.setMap2DLook(z);
    }

    public void u(boolean z) {
        if (this.f == null) {
            LogUtil.e(p, "mBasemap is null");
            return;
        }
        LogUtil.e(p, "setMapBClicked --> bClicked = " + z);
        this.f.setMapClickInfo(z);
    }

    public boolean v(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.setMapForceSwitchStrategy(z);
    }

    public void w(boolean z) {
        if (this.f == null) {
            com.baidu.navisdk.util.common.g.MAP.c(p, "mBaseMap is null");
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(p, "SetMapPoiScene(), isShow = " + z);
        }
        this.f.setMapPoiScene(z);
    }

    public void x(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.setNaviStatus(z);
    }

    public boolean z(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        boolean preFinishStatus = jNIBaseMap.setPreFinishStatus(z);
        LogUtil.e(p, "setPreFinishStatus: preFinish --> " + z + ",result --> " + preFinishStatus);
        return preFinishStatus;
    }

    private MapItem a(JSONObject jSONObject) {
        Bundle b2;
        MapItem mapItem = new MapItem();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONArray("dataset").getJSONObject(0);
            if (jSONObject2.has("ty")) {
                mapItem.mItemType = jSONObject2.getInt("ty");
            }
            if (jSONObject2.has("ud")) {
                mapItem.mUid = jSONObject2.getString("ud");
            }
            if (jSONObject2.has("tx")) {
                mapItem.mTitle = jSONObject2.getString("tx");
            }
            if (jSONObject2.has("geo") && (b2 = com.baidu.navisdk.framework.b.b(jSONObject2.getString("geo"))) != null) {
                mapItem.mLatitudeMc = b2.getDouble("y");
                mapItem.mLongitudeMc = b2.getDouble("x");
            }
            if (jSONObject2.has("indoorpoi")) {
                mapItem.mIsIndoorpoi = jSONObject2.getBoolean("indoorpoi");
            }
            if (jSONObject2.has("onlineType")) {
                mapItem.mOnlineType = jSONObject2.getInt("onlineType");
            }
            LogUtil.e(p, "convert2MapItem: mapItem --> " + mapItem);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mapItem;
    }

    public boolean j(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.resetRouteDetailIndex(z);
    }

    public float k() {
        if (this.f == null) {
            return 0.0f;
        }
        if (com.baidu.navisdk.j.d()) {
            return this.f.getDpiScale(com.baidu.baidunavis.maplayer.a.h().a().getBaseMap().GetId());
        }
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            return this.f.getDpiScale(k.N());
        }
        return 0.0f;
    }

    public void m(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.setAutoLevelEnable(z);
    }

    public Rect n() {
        return this.i;
    }

    public void H(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.SetShowTrackOverSpeed(z);
    }

    public void h() {
        if (this.f == null) {
            return;
        }
        LogUtil.e(p, "destroyMiniMapControl(BaiduGLSurfaceView): --> ");
        this.f.destroyMiniMapControl();
    }

    public void y() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap != null) {
            jNIBaseMap.OnResume();
        }
    }

    public boolean d(MotionEvent motionEvent) {
        if (M() || !u || System.currentTimeMillis() - q < 300) {
            return true;
        }
        float abs = Math.abs(motionEvent.getX() - r);
        float abs2 = Math.abs(motionEvent.getY() - s);
        double density = ScreenUtil.getInstance().getDensity();
        if (density > 1.5d) {
            density *= 1.5d;
        }
        float f = (float) density;
        if (t && abs / f <= 3.0f && abs2 / f <= 3.0f) {
            return true;
        }
        t = false;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        a(3, 0, (y << 16) | x);
        return false;
    }

    public void l(int i) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.setTranslucentHeight(i);
    }

    public boolean i(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.preNextRouteDetail(z);
    }

    public GeoPoint e(int i, int i2) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return null;
        }
        String ScrPtToGeoPoint = jNIBaseMap.ScrPtToGeoPoint(i, i2);
        GeoPoint geoPoint = new GeoPoint(0, 0);
        if (ScrPtToGeoPoint != null) {
            try {
                JSONObject jSONObject = new JSONObject(ScrPtToGeoPoint);
                geoPoint.setLongitudeE6(jSONObject.getInt("geox"));
                geoPoint.setLatitudeE6(jSONObject.getInt("geoy"));
                return geoPoint;
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public boolean f(Bundle bundle) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.ZoomToBound(bundle);
    }

    private void c(String str, MapItem mapItem) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(p, "handlerClickUgc: " + str + ", item:" + mapItem);
        }
        int i = 2;
        try {
            i = new JSONObject(str).optInt("ictype", 2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (i == 7) {
            a(str, mapItem);
        } else {
            b(str, mapItem, -1);
        }
    }

    public void i() {
        if (this.f == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(p, "exitCarPlayMode mBasemap is null");
            }
        } else {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(p, "exitCarPlayMode");
            }
            this.f.exitCarPlayMode();
        }
    }

    public void b(MotionEvent motionEvent) {
        float f;
        float f2;
        if (this.e) {
            GeoPoint e = e((int) motionEvent.getX(), (int) motionEvent.getY());
            if (e != null) {
                f = e.getLongitudeE6();
                f2 = e.getLatitudeE6();
            } else {
                f = 0.0f;
                f2 = 0.0f;
            }
            float x = motionEvent.getX() - (s() / 2);
            float y = (motionEvent.getY() - (r() / 2)) * (-1.0f);
            com.baidu.navisdk.comapi.statistics.b.f().a(Math.min(t() + 1, 20));
            a(8195, (((int) motionEvent.getY()) << 16) | ((int) motionEvent.getX()), ((this.c / 2) << 16) | (this.b / 2), 0, 0, f, f2, x, y);
            q = System.currentTimeMillis();
        }
    }

    public void f(int i, int i2) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.setHighLightRoute(i, i2);
    }

    public void f() {
        if (this.f == null) {
            return;
        }
        LogUtil.e(p, "awakeDrawWaitEvent -->");
        this.f.awakeDrawWaitEvent();
    }

    public MapItem e(int i, int i2, int i3) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return null;
        }
        return (MapItem) jNIBaseMap.SelectItem(i, i2, i3);
    }

    public void f(int i) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            com.baidu.navisdk.util.common.g.MAP.c(p, "setACEParkViewVisible --> mBaseMap is null");
        } else {
            jNIBaseMap.setACEParkViewMode(i);
        }
    }

    public boolean c(int i, boolean z) {
        LogUtil.e(p, "showLayer: layerType --> " + i + ", show: " + z);
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null || !jNIBaseMap.ShowLayer(i, z)) {
            return false;
        }
        if (i != 13 || this.h == -1 || z) {
            return true;
        }
        this.h = -1;
        return true;
    }

    public void e(int i) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.mapClickEvent(i);
    }

    private void d(String str, MapItem mapItem) {
        try {
            String optString = new JSONObject(str).optString("eta");
            Bundle bundle = new Bundle();
            mapItem.mBundleParams = bundle;
            bundle.putString("eta", optString);
            q().onClickDestNodeBubble(mapItem);
        } catch (Exception unused) {
        }
    }

    public boolean e() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.allViewSerialAnimation();
    }

    public j(Context context) {
        this.f9514a = c.DEFAULT;
        this.d = true;
        this.e = true;
        this.f = null;
        this.g = null;
        this.h = -1;
        a aVar = new a(Looper.getMainLooper());
        this.j = aVar;
        this.k = new com.baidu.nplatform.comapi.map.gesture.b(this);
        this.l = false;
        this.m = null;
        this.n = new Bundle();
        new Handler(Looper.getMainLooper());
        this.o = new Object();
        com.baidu.navisdk.vi.b.a(aVar);
        VDeviceAPI.getScreenDensity();
    }

    private MapItem b(String str) {
        JSONObject jSONObject;
        double d2;
        double d3;
        String str2 = p;
        LogUtil.e(str2, "convert2MapItem: jsonStr --> " + str);
        if (str == null) {
            return null;
        }
        MapItem mapItem = new MapItem();
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e = e;
        }
        try {
        } catch (JSONException e2) {
            e = e2;
            e.printStackTrace();
            return mapItem;
        }
        if (jSONObject.has("dataset")) {
            return a(jSONObject);
        }
        if (!(jSONObject.has(MapItem.KEY_IS_MAP_ITEM) ? jSONObject.getBoolean(MapItem.KEY_IS_MAP_ITEM) : false)) {
            return null;
        }
        if (jSONObject.has("in")) {
            mapItem.mItemID = jSONObject.getInt("in");
        }
        if (jSONObject.has(MapItem.KEY_ITEM_SID)) {
            mapItem.mItemSID = jSONObject.getString(MapItem.KEY_ITEM_SID);
        }
        if (jSONObject.has("ty")) {
            mapItem.mItemType = jSONObject.getInt("ty");
        }
        if (jSONObject.has("ud")) {
            mapItem.mUid = jSONObject.getString("ud");
        }
        if (jSONObject.has("tx")) {
            mapItem.mTitle = jSONObject.getString("tx");
        }
        if (jSONObject.has(MapItem.KEY_BZID)) {
            mapItem.mBzid = jSONObject.getInt(MapItem.KEY_BZID);
        }
        if (jSONObject.has("tag")) {
            mapItem.mClickTag = jSONObject.getInt("tag");
        }
        if (jSONObject.has(MapItem.KEY_LONGITUDE) && jSONObject.has(MapItem.KEY_LATITUDE)) {
            d3 = jSONObject.getDouble(MapItem.KEY_LONGITUDE);
            d2 = jSONObject.getDouble(MapItem.KEY_LATITUDE);
        } else {
            d2 = Double.MIN_VALUE;
            d3 = Double.MIN_VALUE;
        }
        if (d2 != Double.MIN_VALUE && d3 != Double.MIN_VALUE) {
            mapItem.mLatitudeMc = d2;
            mapItem.mLongitudeMc = d3;
            Bundle b2 = com.baidu.navisdk.util.common.o.b((int) d3, (int) d2);
            mapItem.mLatitude = b2.getInt("LLy");
            mapItem.mLongitude = b2.getInt("LLx");
        }
        if (jSONObject.has(MapItem.KEY_CUR_ROUTE_INDEX)) {
            mapItem.mCurRouteIdx = jSONObject.getInt(MapItem.KEY_CUR_ROUTE_INDEX);
        }
        if (jSONObject.has(MapItem.KEY_CLICK_TYPE)) {
            mapItem.mClickType = jSONObject.getInt(MapItem.KEY_CLICK_TYPE);
        }
        if (jSONObject.has(MapItem.KEY_IS_EXPAND)) {
            mapItem.mIsExpand = jSONObject.getBoolean(MapItem.KEY_IS_EXPAND);
        }
        if (jSONObject.has(MapItem.KEY_LABEL_CLICK_TYPE)) {
            mapItem.mLabelClickType = jSONObject.getInt(MapItem.KEY_LABEL_CLICK_TYPE);
        }
        if (jSONObject.has(MapItem.KEY_JAM_INDEX)) {
            mapItem.mJamIndex = jSONObject.getInt(MapItem.KEY_JAM_INDEX);
        }
        if (jSONObject.has(MapItem.KEY_CHAT_ID)) {
            mapItem.chatId = jSONObject.getString(MapItem.KEY_CHAT_ID);
        }
        LogUtil.e(str2, "convert2MapItem: mapItem --> " + mapItem);
        return mapItem;
    }

    public void c(int i, int i2) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.ResetScalePosition(i, i2);
    }

    public boolean e(Bundle bundle) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.setScreenShow(bundle);
    }

    public void c() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap != null) {
            jNIBaseMap.StopMapDataRequest();
        }
    }

    public boolean d() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.UpdataBaseLayers();
    }

    public void e(boolean z) {
        if (this.f == null) {
            LogUtil.e(p, "mBasemap is null");
        } else {
            LogUtil.e(p, "SetStrategyVisible");
            this.f.SetStrategyVisible(z);
        }
    }

    public void a(u uVar) {
        this.m = uVar;
    }

    public void c(int i) {
        if (this.f == null) {
            return;
        }
        LogUtil.e(p, "dynamicWindowShutDown: type --> " + i);
        this.f.dynamicWindowShutDown(i);
    }

    public void d(int i, int i2, int i3) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.ResetCompassPosition(i, i2, i3);
    }

    public boolean a(String str, int i, int i2) {
        MapItem b2 = b(str);
        if (b2 == null || q() == null) {
            return false;
        }
        int i3 = b2.mItemType;
        if (i3 == 16) {
            LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_FAVPOI");
            q().onClickedFavPoiLayer(b2);
        } else if (i3 == 17) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_AVOIDLINE");
            }
            int i4 = b2.mOnlineType;
            if (i4 < 5 || i4 > 7) {
                return false;
            }
            q().onClickIndoorParkspace(b2);
        } else if (i3 == 34) {
            LogUtil.e(p, "onMapItemClick: --> NE_Map_Layer_Type_MAP_UGC");
            q().onClickedUgcItem(b2);
        } else if (i3 == 37) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(p, "onMapItemClick: --> NE_MAP_LAYER_TYPE_TRAFFIC_LIGHT");
            }
            b(str, b2);
        } else if (i3 == 200) {
            LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_ITEM");
        } else if (i3 == 1240) {
            LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_THROUGH_NODE");
            q().onClickedThroughNodeLayer(b2, i, i2);
        } else if (i3 == 6016) {
            LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_ROUTE_UGC");
            c(str, b2);
        } else if (i3 == 6017) {
            LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_ELEMENT_AROUND_ROUTE");
            b2.mBundleParams = new Bundle();
            try {
                JSONObject jSONObject = new JSONObject(str);
                b2.mBundleParams.putInt("style_id", jSONObject.optInt("style_id", 0));
                b2.mBundleParams.putInt("dis", jSONObject.optInt("dis", 0));
                b2.mBundleParams.putString("geo", jSONObject.optString("geo", ""));
            } catch (Exception unused) {
                LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_ELEMENT_AROUND_ROUTE exception");
            }
            q().onClickedRouteAroundElement(b2);
        } else if (i3 == 0) {
            LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_BASE_MAP");
            q().onClickedBaseLayer();
        } else if (i3 == 1) {
            LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_START");
            q().onClickedStartLayer(b2, i, i2);
        } else if (i3 == 2) {
            LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_END");
            q().onClickedEndLayer(b2, i, i2);
        } else if (i3 == 3) {
            LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_POI");
            q().onClickedPOILayer(b2);
        } else if (i3 != 4) {
            switch (i3) {
                case 9:
                    LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_COMPASS");
                    q().onClickedCompassLayer();
                    break;
                case 10:
                    int a2 = a(str, b2.mClickType);
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_ROUTE jsonStr: " + str + ", clickSource: " + a2);
                    }
                    if (a2 == 3) {
                        q().onClickedRoute(b2);
                    } else if (a2 == 5) {
                        q().onClickedCarLogo(b2);
                    } else if (a2 == 6) {
                        d(str, b2);
                    } else {
                        b(str, b2, a2);
                    }
                    return true;
                case 11:
                    LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_POPUP");
                    q().onClickedPopupLayer();
                    break;
                case 12:
                    LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_BASE_POI");
                    q().onClickedBasePOILayer(b2);
                    break;
                case 13:
                    int a3 = a(str, b2.mClickType);
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_ROUTE_SPEC jsonStr: " + str + ", clickSource: " + a3);
                    }
                    if (a3 == 3) {
                        q().onClickedRouteSpecLayer(b2);
                    } else if (a3 == 5) {
                        q().onClickedCarLogo(b2);
                    } else {
                        b(str, b2, a3);
                    }
                    return true;
                default:
                    switch (i3) {
                        case MapParams.Const.LayerType.MAP_LAYER_TYPE_ELEMENT_RC_PRED /* 6020 */:
                            if (LogUtil.LOGGABLE) {
                                LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_ELEMENT_RC_PRED");
                            }
                            q().onClickedRcPredictionElement(b2);
                            break;
                        case MapParams.Const.LayerType.MAP_LAYER_TYPE_TRUCK_UGC /* 6021 */:
                            if (LogUtil.LOGGABLE) {
                                LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_TRUCK_UGC");
                            }
                            b(str, b2, 4);
                            break;
                        case MapParams.Const.LayerType.MAP_LAYER_TYPE_MG_DATA /* 6022 */:
                            if (LogUtil.LOGGABLE) {
                                LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_MG_DATA");
                            }
                            int i5 = b2.mBzid;
                            if (i5 == 999) {
                                try {
                                    if (new JSONObject(new JSONObject(str).getString(MapItem.KEY_EXT)).optInt("ictype", -1) == 8) {
                                        a(str, b2, 3);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            } else if (i5 != 992 && i5 != 978) {
                                q().onClickedMgData(b2);
                            } else {
                                a(str, b2, 2);
                            }
                            return true;
                        default:
                            return false;
                    }
            }
        } else {
            LogUtil.e(p, "onMapItemClick: --> MAP_LAYER_TYPE_POI_BKG");
            b2.mBundleParams = new Bundle();
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                if (jSONObject2.has(MapParams.PoiSearchKey.KEY_BKG_CLICK_TYPE)) {
                    b2.mBundleParams.putInt(MapParams.PoiSearchKey.KEY_BKG_CLICK_TYPE, jSONObject2.getInt(MapParams.PoiSearchKey.KEY_BKG_CLICK_TYPE));
                }
                if (jSONObject2.has(MapParams.PoiSearchKey.KEY_BKG_ROUTE_VIA_FAST_LABEL)) {
                    b2.mBundleParams.putBoolean(MapParams.PoiSearchKey.KEY_BKG_ROUTE_VIA_FAST_LABEL, jSONObject2.getBoolean(MapParams.PoiSearchKey.KEY_BKG_ROUTE_VIA_FAST_LABEL));
                }
            } catch (Exception unused2) {
            }
            q().onClickedPOIBkgLayer(b2);
        }
        return true;
    }

    public void d(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.SetIfInterruptAutoLevel(z);
    }

    public void e(int i, Bundle bundle) {
        if (this.f == null) {
            LogUtil.e(p, "setMapFuncInfoMapStrategy,mBasemap is null");
            return;
        }
        String str = p;
        LogUtil.e(str, "setMapFuncInfoMapStrategy --> mapStrategyType = " + i + ", bundle = " + bundle);
        boolean mapFuncInfoMapStrategy = this.f.setMapFuncInfoMapStrategy(i, bundle);
        StringBuilder sb = new StringBuilder();
        sb.append("setMapFuncInfoMapStrategy --> ret = ");
        sb.append(mapFuncInfoMapStrategy);
        LogUtil.e(str, sb.toString());
    }

    public void c(boolean z) {
        if (this.f == null) {
            LogUtil.e(p, "mBasemap is null");
        } else {
            LogUtil.e(p, "SetCompassVisible");
            this.f.SetCompassVisible(z);
        }
    }

    public void d(int i, Bundle bundle) {
        if (this.f == null) {
            LogUtil.e(p, "setMapFuncInfoMapClass,mBasemap is null");
            return;
        }
        String str = p;
        LogUtil.e(str, "setMapFuncInfoMapClass --> mapClassType = " + i + ", bundle = " + bundle);
        boolean mapFuncInfoMapClass = this.f.setMapFuncInfoMapClass(i, bundle);
        StringBuilder sb = new StringBuilder();
        sb.append("setMapFuncInfoMapClass --> ret = ");
        sb.append(mapFuncInfoMapClass);
        LogUtil.e(str, sb.toString());
    }

    public void c(int i, Bundle bundle) {
        if (this.f == null) {
            LogUtil.e(p, "mBasemap is null");
            return;
        }
        LogUtil.e(p, "setMapFuncInfo --> mapElementType = " + i + ", mapElementAttr = " + bundle);
        this.f.SetMapFuncInfo(i, bundle);
    }

    public boolean d(Bundle bundle) {
        if (this.f == null) {
            com.baidu.navisdk.util.common.g.MAP.c(p, "mBaseMap is null");
            return false;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(p, "setHDDataToMap(): " + bundle);
        }
        return this.f.setHdDataToMap(bundle);
    }

    public void c(int i, int i2, int i3) {
        if (this.f == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(p, "initMiniRenderEngine mBasemap is null");
                return;
            }
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(p, "initMiniRenderEngine type:" + i + "width = " + i2 + " height = " + i3);
        }
        this.f.initMiniRenderEngine(i, i2, i3);
    }

    public void g() {
        if (this.f == null) {
            return;
        }
        LogUtil.e(p, "createMiniMapControl(BaiduGLSurfaceView): --> ");
        this.f.createMiniMapControl();
    }

    public boolean c(Bundle bundle) {
        if (this.f == null) {
            com.baidu.navisdk.util.common.g.MAP.c(p, "mBaseMap is null");
            return false;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(p, "setBarrageInfo: " + bundle);
        }
        return this.f.setBarrageInfo(bundle);
    }

    public void g(int i) {
        if (this.f == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(p, "mBasemap is null");
                return;
            }
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(p, "mBasemap setLimitFrame" + i);
        }
        this.f.setLimitFrame(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x009d A[Catch: Exception -> 0x0121, TryCatch #0 {Exception -> 0x0121, blocks: (B:6:0x0045, B:8:0x0050, B:9:0x0059, B:11:0x0060, B:12:0x0066, B:15:0x0073, B:17:0x0091, B:19:0x009d, B:20:0x00a6, B:22:0x00ac, B:23:0x00b5, B:25:0x00bb, B:27:0x00c1, B:28:0x00d3, B:30:0x00d9, B:31:0x00e0, B:33:0x00e6, B:34:0x00f1, B:36:0x00f7, B:37:0x0101, B:39:0x0107, B:40:0x0110, B:42:0x0118, B:48:0x007e, B:51:0x0089), top: B:5:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ac A[Catch: Exception -> 0x0121, TryCatch #0 {Exception -> 0x0121, blocks: (B:6:0x0045, B:8:0x0050, B:9:0x0059, B:11:0x0060, B:12:0x0066, B:15:0x0073, B:17:0x0091, B:19:0x009d, B:20:0x00a6, B:22:0x00ac, B:23:0x00b5, B:25:0x00bb, B:27:0x00c1, B:28:0x00d3, B:30:0x00d9, B:31:0x00e0, B:33:0x00e6, B:34:0x00f1, B:36:0x00f7, B:37:0x0101, B:39:0x0107, B:40:0x0110, B:42:0x0118, B:48:0x007e, B:51:0x0089), top: B:5:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d9 A[Catch: Exception -> 0x0121, TryCatch #0 {Exception -> 0x0121, blocks: (B:6:0x0045, B:8:0x0050, B:9:0x0059, B:11:0x0060, B:12:0x0066, B:15:0x0073, B:17:0x0091, B:19:0x009d, B:20:0x00a6, B:22:0x00ac, B:23:0x00b5, B:25:0x00bb, B:27:0x00c1, B:28:0x00d3, B:30:0x00d9, B:31:0x00e0, B:33:0x00e6, B:34:0x00f1, B:36:0x00f7, B:37:0x0101, B:39:0x0107, B:40:0x0110, B:42:0x0118, B:48:0x007e, B:51:0x0089), top: B:5:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e6 A[Catch: Exception -> 0x0121, TryCatch #0 {Exception -> 0x0121, blocks: (B:6:0x0045, B:8:0x0050, B:9:0x0059, B:11:0x0060, B:12:0x0066, B:15:0x0073, B:17:0x0091, B:19:0x009d, B:20:0x00a6, B:22:0x00ac, B:23:0x00b5, B:25:0x00bb, B:27:0x00c1, B:28:0x00d3, B:30:0x00d9, B:31:0x00e0, B:33:0x00e6, B:34:0x00f1, B:36:0x00f7, B:37:0x0101, B:39:0x0107, B:40:0x0110, B:42:0x0118, B:48:0x007e, B:51:0x0089), top: B:5:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f7 A[Catch: Exception -> 0x0121, TryCatch #0 {Exception -> 0x0121, blocks: (B:6:0x0045, B:8:0x0050, B:9:0x0059, B:11:0x0060, B:12:0x0066, B:15:0x0073, B:17:0x0091, B:19:0x009d, B:20:0x00a6, B:22:0x00ac, B:23:0x00b5, B:25:0x00bb, B:27:0x00c1, B:28:0x00d3, B:30:0x00d9, B:31:0x00e0, B:33:0x00e6, B:34:0x00f1, B:36:0x00f7, B:37:0x0101, B:39:0x0107, B:40:0x0110, B:42:0x0118, B:48:0x007e, B:51:0x0089), top: B:5:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0107 A[Catch: Exception -> 0x0121, TryCatch #0 {Exception -> 0x0121, blocks: (B:6:0x0045, B:8:0x0050, B:9:0x0059, B:11:0x0060, B:12:0x0066, B:15:0x0073, B:17:0x0091, B:19:0x009d, B:20:0x00a6, B:22:0x00ac, B:23:0x00b5, B:25:0x00bb, B:27:0x00c1, B:28:0x00d3, B:30:0x00d9, B:31:0x00e0, B:33:0x00e6, B:34:0x00f1, B:36:0x00f7, B:37:0x0101, B:39:0x0107, B:40:0x0110, B:42:0x0118, B:48:0x007e, B:51:0x0089), top: B:5:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0118 A[Catch: Exception -> 0x0121, TRY_LEAVE, TryCatch #0 {Exception -> 0x0121, blocks: (B:6:0x0045, B:8:0x0050, B:9:0x0059, B:11:0x0060, B:12:0x0066, B:15:0x0073, B:17:0x0091, B:19:0x009d, B:20:0x00a6, B:22:0x00ac, B:23:0x00b5, B:25:0x00bb, B:27:0x00c1, B:28:0x00d3, B:30:0x00d9, B:31:0x00e0, B:33:0x00e6, B:34:0x00f1, B:36:0x00f7, B:37:0x0101, B:39:0x0107, B:40:0x0110, B:42:0x0118, B:48:0x007e, B:51:0x0089), top: B:5:0x0045 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(java.lang.String r18, com.baidu.nplatform.comapi.MapItem r19, int r20) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.nplatform.comapi.map.j.b(java.lang.String, com.baidu.nplatform.comapi.MapItem, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x004f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int a(java.lang.String r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "labelClickType"
            java.lang.String r1 = "routeClickType"
            boolean r2 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE
            if (r2 == 0) goto L26
            java.lang.String r2 = com.baidu.nplatform.comapi.map.j.p
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getRouteClickType: "
            r3.append(r4)
            r3.append(r8)
            java.lang.String r4 = ", clickType: "
            r3.append(r4)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            com.baidu.navisdk.util.common.LogUtil.e(r2, r3)
        L26:
            r2 = 3
            r3 = 5
            r4 = 2
            if (r9 != r4) goto L2d
            r5 = 5
            goto L2e
        L2d:
            r5 = 3
        L2e:
            boolean r6 = android.text.TextUtils.isEmpty(r8)
            if (r6 == 0) goto L35
            return r5
        L35:
            r6 = 1
            if (r9 != r6) goto L51
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch: java.lang.Exception -> L48
            r9.<init>(r8)     // Catch: java.lang.Exception -> L48
            boolean r8 = r9.has(r1)     // Catch: java.lang.Exception -> L48
            if (r8 == 0) goto L4c
            int r8 = r9.optInt(r1, r6)     // Catch: java.lang.Exception -> L48
            goto L4d
        L48:
            r8 = move-exception
            r8.printStackTrace()
        L4c:
            r8 = 1
        L4d:
            if (r8 != r4) goto L50
            r5 = 1
        L50:
            return r5
        L51:
            if (r9 != 0) goto L75
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch: java.lang.Exception -> L63
            r9.<init>(r8)     // Catch: java.lang.Exception -> L63
            boolean r8 = r9.has(r0)     // Catch: java.lang.Exception -> L63
            if (r8 == 0) goto L67
            int r6 = r9.optInt(r0, r6)     // Catch: java.lang.Exception -> L63
            goto L67
        L63:
            r8 = move-exception
            r8.printStackTrace()
        L67:
            if (r6 != r4) goto L6a
            goto L74
        L6a:
            if (r6 != r2) goto L6e
            r4 = 6
            goto L74
        L6e:
            r8 = 4
            if (r6 != r8) goto L73
            r4 = 7
            goto L74
        L73:
            r4 = r5
        L74:
            return r4
        L75:
            if (r9 != r4) goto L78
            return r3
        L78:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.nplatform.comapi.map.j.a(java.lang.String, int):int");
    }

    public GeoPoint b(int i, int i2) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return null;
        }
        int[] iArr = {0};
        int[] iArr2 = {0};
        if (jNIBaseMap.GetGeoPosByScreenPos(i, i2, iArr, iArr2)) {
            return new GeoPoint(iArr[0], iArr2[0]);
        }
        return null;
    }

    public void b(boolean z, boolean z2) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap != null) {
            jNIBaseMap.ShowTrafficMap(z, z2);
        }
    }

    public void b() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap != null) {
            jNIBaseMap.StartMapDataRequest();
        }
    }

    public void b(int i, Bundle bundle) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.sendCommandToMapEngine(i, bundle);
    }

    private void a(String str, MapItem mapItem, int i) {
        String str2;
        String str3;
        String str4;
        if (!LogUtil.LOGGABLE) {
            str2 = "ictype";
            str3 = "routeindex";
            str4 = "nFrom";
        } else {
            str4 = "nFrom";
            String str5 = p;
            str2 = "ictype";
            StringBuilder sb = new StringBuilder();
            str3 = "routeindex";
            sb.append("handleClickUgcFromMGData: ");
            sb.append(str);
            LogUtil.e(str5, sb.toString());
        }
        mapItem.mBundleParams = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString(MapItem.KEY_EXT));
            if (jSONObject2.has("type")) {
                mapItem.mBundleParams.putInt(MapParams.PanoramaKeys.EVENT_TYPE, jSONObject2.optInt("type"));
            }
            mapItem.mBundleParams.putInt("onroute", jSONObject2.has("onRoute") ? jSONObject2.optInt("onRoute", 0) : 0);
            mapItem.mBundleParams.putInt("click_source", i);
            if (jSONObject2.has(MapItem.KEY_JAM_INDEX)) {
                mapItem.mBundleParams.putInt(MapItem.KEY_JAM_INDEX, jSONObject2.optInt(MapItem.KEY_JAM_INDEX, -1));
            }
            if (jSONObject2.has("jamVersion")) {
                mapItem.mBundleParams.putInt("jamVersion", jSONObject2.optInt("jamVersion", -1));
            }
            if (jSONObject.has("x") && jSONObject.has("y")) {
                mapItem.mBundleParams.putDouble("x", jSONObject.optDouble("x"));
                mapItem.mBundleParams.putDouble("y", jSONObject.optDouble("y"));
            }
            if (jSONObject2.has("uid")) {
                mapItem.mUid = jSONObject2.optString("uid", null);
            }
            if (jSONObject.has("idl") && jSONObject.has("idh")) {
                long j = (jSONObject.getLong("idh") << 32) | jSONObject.getLong("idl");
                mapItem.mEventId = j;
                mapItem.mBundleParams.putLong("event_id", j);
            }
            if (jSONObject2.has("routeMD5")) {
                mapItem.mBundleParams.putString("routeMD5", jSONObject2.optString("routeMD5", ""));
            }
            if (jSONObject.has("pass")) {
                mapItem.mBundleParams.putBoolean("pass", jSONObject.optBoolean("pass", false));
            }
            String str6 = str3;
            if (jSONObject.has(str6)) {
                mapItem.mBundleParams.putInt("ridx", jSONObject.optInt(str6, -1));
            }
            mapItem.mBundleParams.putInt(MapItem.KEY_BZID, mapItem.mBzid);
            String str7 = str2;
            if (jSONObject2.has(str7)) {
                mapItem.mBundleParams.putInt("clickType", jSONObject2.optInt(str7, -1));
            }
            String str8 = str4;
            if (jSONObject2.has(str8)) {
                mapItem.mBundleParams.putInt(str8, jSONObject2.optInt(str8, 0));
            }
            if (jSONObject2.has("jumpAction")) {
                mapItem.mBundleParams.putString("jumpAction", jSONObject2.optString("jumpAction"));
            }
            if (jSONObject.has("elemType")) {
                mapItem.mBundleParams.putInt("elemType", jSONObject.optInt("elemType", 0));
            }
            if (!TextUtils.isEmpty(mapItem.chatId)) {
                mapItem.mBundleParams.putString("chatId", mapItem.chatId);
            }
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
                LogUtil.e(p, e.toString());
            }
        }
        q().onClickedRouteUgcItem(mapItem);
    }

    public void b(int i) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.dynamicWindowDraw(i);
    }

    public void b(int i, int i2, int i3) {
        if (this.f == null) {
            return;
        }
        LogUtil.e(p, "dynamicWindowChange: type --> " + i + ", width: " + i2 + ", height: " + i3);
        this.f.dynamicWindowChange(i, i2, i3);
    }

    public boolean b(boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            if (!LogUtil.LOGGABLE) {
                return false;
            }
            LogUtil.e(p, "SetCarLogoVisible,mBasemap is null");
            return false;
        }
        boolean SetCarLogoVisible = jNIBaseMap.SetCarLogoVisible(z);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(p, "SetCarLogoVisible,show:" + z + ",ret:" + SetCarLogoVisible);
        }
        return SetCarLogoVisible;
    }

    private void b(String str, MapItem mapItem) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(p, "handlerClickTrafficLight: " + str);
        }
        Bundle bundle = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bundle.putInt("c", jSONObject.optInt("c", 0));
            bundle.putInt("wc", jSONObject.optInt("wc", -1));
            bundle.putInt("wt", jSONObject.optInt("wt", -1));
            bundle.putInt("wdis", jSONObject.optInt("wdis", -1));
            bundle.putInt("pdis", jSONObject.optInt("pdis", -1));
            bundle.putString("id", jSONObject.optString("id", null));
            bundle.putInt("iid", jSONObject.optInt("iid", -1));
            bundle.putInt(MapParams.PanoramaKeys.EVENT_TYPE, 4101);
            bundle.putInt("source", 11);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mapItem.mBundleParams = bundle;
        q().onClickedTrafficLightItem(mapItem);
    }

    public void b(int[] iArr, boolean z) {
        if (this.f == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(p, "setMapFuncTruckUgcInfo mBasemap is null");
                return;
            }
            return;
        }
        if (LogUtil.LOGGABLE) {
            String str = p;
            StringBuilder sb = new StringBuilder();
            sb.append("mBasemap setMapFuncTruckUgcInfo isShow:");
            sb.append(z);
            sb.append(iArr == null ? "ugcTypeArray == null" : Arrays.toString(iArr));
            LogUtil.e(str, sb.toString());
        }
        this.f.SetMapFuncTruckUgcInfo(iArr, z);
    }

    public void b(long j) {
        if (this.f == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(p, "enterCarPlayMode mBasemap is null");
                return;
            }
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(p, "enterCarPlayMode --> baseMapAddr = " + j);
        }
        this.f.enterCarPlayMode(j);
    }

    public void b(int i, int i2, long[] jArr, int[] iArr) {
        if (this.f == null) {
            return;
        }
        synchronized (this.o) {
            this.f.showMGDataset(i, i2, jArr, iArr);
        }
    }

    public void b(int i, int i2, String[] strArr) {
        if (this.f == null) {
            return;
        }
        synchronized (this.o) {
            this.f.showMGDatasetBySid(i, i2, strArr);
        }
    }

    public boolean b(boolean z, int i, int i2, int i3) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(p, "setMapFuncInfoPartRouteZoom: " + z + ", " + i + ", " + i2 + ", " + i3);
        }
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.setMapFuncInfoPartRouteZoom(z, i, i2, i3);
    }

    public void b(int i, boolean z) {
        if (this.f == null) {
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(p, "setLabelBreathing isBreathing = " + z);
        }
        this.f.setLabelBreathing(i, z);
    }

    private void a(String str, MapItem mapItem) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(p, "handleClickRoutePanoramaIcon: " + str);
        }
        if (mapItem.mBundleParams == null) {
            mapItem.mBundleParams = new Bundle();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            mapItem.mBundleParams.putDouble("x", jSONObject.optDouble("x", Double.MIN_VALUE));
            mapItem.mBundleParams.putDouble("y", jSONObject.optDouble("y", Double.MIN_VALUE));
            mapItem.mBundleParams.putInt(MapParams.PanoramaKeys.EVENT_TYPE, jSONObject.optInt(MapParams.PanoramaKeys.EVENT_TYPE, 0));
            mapItem.mBundleParams.putString(MapParams.PanoramaKeys.PANO_URL, jSONObject.optString(MapParams.PanoramaKeys.PANO_URL, null));
            mapItem.mBundleParams.putString("desc", jSONObject.optString("desc", null));
            mapItem.mBundleParams.putString(MapParams.PanoramaKeys.ROAD_NAME, jSONObject.optString(MapParams.PanoramaKeys.ROAD_NAME, null));
        } catch (JSONException e) {
            e.printStackTrace();
            LogUtil.e(p, "");
        }
        q().onClickedRoutePanItem(mapItem);
    }

    public synchronized void a(com.baidu.nplatform.comapi.basestruct.b bVar, b bVar2) {
        a(bVar, bVar2, -1, false);
    }

    public synchronized void a(com.baidu.nplatform.comapi.basestruct.b bVar, b bVar2, int i) {
        a(bVar, bVar2, -1, false);
    }

    public synchronized void a(com.baidu.nplatform.comapi.basestruct.b bVar, b bVar2, int i, boolean z) {
        try {
            if (this.f == null) {
                return;
            }
            this.n.clear();
            this.n.putDouble("level", bVar.f9474a);
            this.n.putDouble("rotation", bVar.b);
            this.n.putDouble("overlooking", bVar.c);
            this.n.putDouble("centerptx", bVar.d);
            this.n.putDouble("centerpty", bVar.e);
            this.n.putInt("left", bVar.g.f9476a);
            this.n.putInt("right", bVar.g.b);
            this.n.putInt("top", bVar.g.c);
            this.n.putInt("bottom", bVar.g.d);
            this.n.putInt("lbx", bVar.h.e.c());
            this.n.putInt("lby", bVar.h.e.d());
            this.n.putInt("ltx", bVar.h.f.c());
            this.n.putInt("lty", bVar.h.f.d());
            this.n.putInt("rtx", bVar.h.g.c());
            this.n.putInt("rty", bVar.h.g.d());
            this.n.putInt("rbx", bVar.h.h.c());
            this.n.putInt("rby", bVar.h.h.d());
            this.n.putFloat("yoffset", (float) bVar.j);
            this.n.putFloat("xoffset", (float) bVar.i);
            this.n.putInt("animation", bVar2.a());
            if (i < 0) {
                if (bVar2.a() == b.eAnimationNone.a()) {
                    this.n.putInt("animatime", 0);
                } else {
                    this.n.putInt("animatime", 1000);
                }
            } else {
                this.n.putInt("animatime", i);
            }
            this.n.putInt("bfpp", bVar.k ? 1 : 0);
            this.n.putBoolean("useScreenOffset", z);
            boolean SetMapStatus = this.f.SetMapStatus(this.n);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
            if (gVar.d()) {
                gVar.e("SetMapStatus result:" + SetMapStatus + ",params=" + this.n);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean a(int i, int i2) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.SetMinimapWinSize(i, i2);
    }

    public void a(boolean z) {
        if (this.f != null) {
            LogUtil.e("MinimapTexture", "MapController ReleaseMinimap");
            this.f.ResetGLHandleWhenCreateOrDestroyContext(z);
        }
    }

    public void a(Rect rect, boolean z, int i, int i2, boolean z2) {
        if (rect != null && this.f != null) {
            Bundle bundle = new Bundle();
            bundle.putLong("left", rect.left);
            bundle.putLong("top", rect.top);
            bundle.putLong("right", rect.right);
            bundle.putLong("bottom", rect.bottom);
            bundle.putInt("isVertical", z ? 1 : 0);
            bundle.putInt("heightPixels", i);
            bundle.putInt("widthPixels", i2);
            bundle.putInt("needAnimForFullview", z2 ? 1 : 0);
            if (LogUtil.LOGGABLE) {
                LogUtil.e(p, "zoomToFullView->data=" + bundle);
            }
            this.f.ZoomToFullView(bundle);
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(p, "zoomToFullView->rect=" + rect + " mBasemap=" + this.f);
        }
    }

    public boolean a(int i) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null || !jNIBaseMap.ClearLayer(i)) {
            return false;
        }
        if (i != 13) {
            return true;
        }
        this.h = -1;
        return true;
    }

    public boolean a(String str) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.SaveScreen(str);
    }

    public com.baidu.nplatform.comapi.basestruct.c a(GeoPoint geoPoint) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return null;
        }
        if (jNIBaseMap.GetScreenPosByGeoPos(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6(), new int[]{0}, new int[]{0})) {
            return new com.baidu.nplatform.comapi.basestruct.c(r3[0], r4[0]);
        }
        return null;
    }

    public int a(int i, int i2, int i3) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return 0;
        }
        try {
            return jNIBaseMap.MapProc(i, i2, i3, 0, 0, OOXIXo.f3760XO, OOXIXo.f3760XO, OOXIXo.f3760XO, OOXIXo.f3760XO);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public int a(int i, int i2, int i3, int i4, int i5, double d2, double d3, double d4, double d5) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return 0;
        }
        try {
            return jNIBaseMap.MapProc(i, i2, i3, i4, i5, d2, d3, d4, d5);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public void a() {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap != null) {
            jNIBaseMap.SaveCache();
        }
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.GetScreenPosByGeoPos(i, i2, iArr, iArr2);
    }

    public boolean a(int i, int i2, int i3, Bitmap bitmap) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.GetScreenShot(i, i2, i3, bitmap);
    }

    public boolean a(int i, int i2, int i3, int i4, boolean z, Bitmap bitmap) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.GetScreenMask(i, i2, i3, i4, z, bitmap);
    }

    public boolean a(boolean z, boolean z2) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.SetDrawHouse(z, z2);
    }

    public boolean a(int i, int i2, boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.FocusItem(i, i2, z);
    }

    public float a(Bundle bundle, float f, float f2) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return -1.0f;
        }
        return jNIBaseMap.GetZoomToBound(bundle, f, f2);
    }

    public void a(Rect rect) {
        JNIBaseMap jNIBaseMap;
        int i;
        int i2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(p, "setMapShowScreenRect --> rect = " + rect);
        }
        if (rect == null || (jNIBaseMap = this.f) == null) {
            return;
        }
        int i3 = rect.right;
        int i4 = rect.left;
        if (i3 >= i4 && (i = rect.bottom) >= (i2 = rect.top)) {
            this.i = rect;
            jNIBaseMap.setMapShowScreenRect(i4, i2, i3, i);
        } else if (gVar.d()) {
            gVar.e(p, "setMapShowScreenRect --> rect error");
        }
    }

    public void a(Bundle bundle, boolean z) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.zoomToSlightNaviFullView(bundle, z);
    }

    public boolean a(int i, int i2, int i3, long j, long j2, int i4) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.setScreenShotParam(i, i2, i3, j, j2, i4);
    }

    public boolean a(Bundle bundle) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.getScreenShotImage(bundle);
    }

    public boolean a(String str, String str2) {
        if (this.f == null) {
            return false;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(p, "set3DCarLogoToMap filePath:" + str + ", configFileName:" + str2);
        }
        return this.f.set3DCarLogoToMap(str, str2);
    }

    public boolean a(int i, String str, String str2) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        try {
            return jNIBaseMap.setDIYDataToMap(i, str, str2);
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(p, "setDIYDataToMap " + e.getMessage());
            }
            return false;
        }
    }

    public void a(int i, int i2, int i3, byte[] bArr) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return;
        }
        jNIBaseMap.setCarImageToMap(i, i2, i3, bArr, bArr.length);
    }

    public boolean a(int i, Bundle bundle) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        boolean dynamicWindowInit = jNIBaseMap.dynamicWindowInit(i, bundle);
        String str = p;
        StringBuilder sb = new StringBuilder();
        sb.append("dynamicWindowInit: type --> ");
        sb.append(i);
        sb.append(", params: ");
        String str2 = bundle;
        if (bundle != null) {
            str2 = bundle.toString();
        }
        sb.append((Object) str2);
        sb.append(", ret: ");
        sb.append(dynamicWindowInit);
        LogUtil.e(str, sb.toString());
        return dynamicWindowInit;
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (this.f == null) {
            return;
        }
        if (com.baidu.navisdk.util.common.g.MAP.d()) {
            LogUtil.e(p, "setDynamicWindowShowSize: --> iVWidth: " + i + ", iVHeight: " + i2 + ", iHWidth: " + i3 + ", iHHeight: " + i4 + ", laneHeight:" + i5);
        }
        this.f.setDynamicWindowShowSize(i, i2, i3, i4, i5);
    }

    public boolean a(ArrayList<Bundle> arrayList) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        boolean uIViewBound = jNIBaseMap.setUIViewBound(arrayList, 500);
        LogUtil.e(p, "setUIViewBound: array --> " + arrayList.toString() + ",result --> " + uIViewBound);
        return uIViewBound;
    }

    public boolean a(ArrayList<Bundle> arrayList, int i) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        boolean uIViewBound = jNIBaseMap.setUIViewBound(arrayList, i);
        LogUtil.e(p, "setUIViewBound: array --> " + arrayList.toString() + ",result --> " + uIViewBound);
        return uIViewBound;
    }

    public boolean a(boolean z, int i, int i2, int i3) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            if (!LogUtil.LOGGABLE) {
                return false;
            }
            LogUtil.e(p, "setMapFuncInfoFastRoute,mBasemap is null");
            return false;
        }
        boolean mapFuncInfoFastRoute = jNIBaseMap.setMapFuncInfoFastRoute(z, i, i2, i3);
        if (LogUtil.LOGGABLE) {
            String str = p;
            LogUtil.e(str, "setMapFuncInfoFastRoute bShow = " + z + ", iIndex = " + i + ", iStartShapeIndex =" + i2 + ", iEndShapeIndex" + i3);
            StringBuilder sb = new StringBuilder();
            sb.append("setMapFuncInfoFastRoute --> ret = ");
            sb.append(mapFuncInfoFastRoute);
            LogUtil.e(str, sb.toString());
        }
        return mapFuncInfoFastRoute;
    }

    public void a(boolean z, int i, int i2, String str, String str2) {
        if (this.f == null) {
            LogUtil.e(p, "setJamMapClickInfo mBasemap is null");
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(p, "setMapBClicked --> bClicked = " + z + ", jamIndex = " + i + ", jamVer = " + i2 + ", eventId = " + str + ", routeMd5 = " + str2);
        }
        this.f.setMapJamClickInfo(z, i, i2, str, str2);
    }

    public void a(boolean z, String str, int i) {
        if (this.f == null) {
            LogUtil.e(p, "setTrafficLightMapClickInfo mBasemap is null");
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(p, "setTrafficLightMapClickInfo: " + z + ", lightId:" + str + ",iid: " + i);
        }
        this.f.setMapTrafficLightClickInfo(z, str, i);
    }

    public void a(int[] iArr, boolean z) {
        if (this.f == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(p, "setMapFuncTruckLimitInfo mBasemap is null");
                return;
            }
            return;
        }
        if (LogUtil.LOGGABLE) {
            String str = p;
            StringBuilder sb = new StringBuilder();
            sb.append("mBasemap setMapFuncTruckLimitInfo isShow:");
            sb.append(z);
            sb.append(iArr == null ? "ugcTypeArray == null" : Arrays.toString(iArr));
            LogUtil.e(str, sb.toString());
        }
        this.f.setMapFuncTruckLimitInfo(iArr, z);
    }

    public boolean a(long j) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            if (!LogUtil.LOGGABLE) {
                return false;
            }
            LogUtil.e(p, "checkMapViewCameraAvailable mBasemap is null");
            return false;
        }
        boolean checkMapViewCameraAvailable = jNIBaseMap.checkMapViewCameraAvailable(j);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(p, "checkMapViewCameraAvailable --> baseMapAddr = " + j + ", isMapViewCameraAvailable = " + checkMapViewCameraAvailable);
        }
        return checkMapViewCameraAvailable;
    }

    public void a(int i, ArrayList<Bundle> arrayList) {
        if (this.f == null) {
            return;
        }
        synchronized (this.o) {
            this.f.setMGDataset(i, arrayList);
        }
    }

    public void a(int i, int i2, long[] jArr, int[] iArr, int i3, int i4) {
        if (this.f == null) {
            return;
        }
        synchronized (this.o) {
            this.f.zoomMGDataset(i, i2, jArr, iArr, i3, i4);
        }
    }

    public void a(int i, int i2, long[] jArr, int[] iArr) {
        if (this.f == null) {
            return;
        }
        synchronized (this.o) {
            this.f.focusMGDataset(i, i2, jArr, iArr);
        }
    }

    public void a(int i, int i2, long[] jArr) {
        a(i, i2, jArr, (int[]) null);
    }

    public void a(int i, int i2, String[] strArr, int[] iArr, int i3, int i4) {
        if (this.f == null) {
            return;
        }
        synchronized (this.o) {
            this.f.zoomMGDatasetBySid(i, i2, strArr, iArr, i3, i4);
        }
    }

    public void a(int i, int i2, String[] strArr) {
        if (this.f == null) {
            return;
        }
        synchronized (this.o) {
            this.f.focusMGDatasetBySid(i, i2, strArr);
        }
    }

    public void a(float f) {
        if (this.f == null) {
            return;
        }
        if (com.baidu.navisdk.j.d()) {
            this.f.setDpiScale(com.baidu.baidunavis.maplayer.a.h().b().getController().getBaseMap().GetId(), f);
        } else {
            com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
            if (k != null) {
                this.f.setDpiScale(k.N(), f);
            }
        }
    }

    public boolean a(List<Bundle> list) {
        JNIBaseMap jNIBaseMap = this.f;
        if (jNIBaseMap == null) {
            return false;
        }
        return jNIBaseMap.set3DCarToMap(list);
    }

    public boolean a(List<Bitmap> list, int[] iArr) {
        if (list == null || this.f == null || iArr == null) {
            return false;
        }
        int size = list.size();
        int i = size / 16;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            Bitmap bitmap = list.get((i2 + i) % size);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int byteCount = (bitmap.getByteCount() * 8) / (width * height);
            byte[] a2 = com.baidu.navisdk.ui.util.d.a(bitmap);
            Bundle bundle = new Bundle();
            bundle.putInt("imageWidth", width);
            bundle.putInt("imageHeight", height);
            bundle.putInt("imageLen", bitmap.getByteCount());
            bundle.putInt("bits", byteCount);
            bundle.putByteArray("imageBytes", a2);
            arrayList.add(bundle);
        }
        return this.f.setDIYImageToMap(arrayList, iArr);
    }

    public boolean a(int[] iArr) {
        if (this.f == null) {
            com.baidu.navisdk.util.common.g.MAP.c(p, "mBaseMap is null");
            return false;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(p, "setDynamicLayerShowKeys --> keys = " + Arrays.toString(iArr));
        }
        return this.f.setDynamicLayerShowKeys(iArr);
    }

    public void a(long j, String str, String str2) {
        if (this.f == null) {
            com.baidu.navisdk.util.common.g.MAP.c(p, "setRealGraphInf --> mBaseMap is null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("imageUrl", str);
        bundle.putString("text", str2);
        bundle.putLong("eventId", j);
        this.f.setRealGraphInfo(bundle);
    }
}
