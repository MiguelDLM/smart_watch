package com.baidu.platform.comapi.walknavi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.R;
import com.baidu.entity.pb.WalkPlan;
import com.baidu.mapapi.bikenavi.adapter.IBNaviStatusListener;
import com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener;
import com.baidu.mapapi.bikenavi.model.BikeNaviDisplayOption;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.MapBound;
import com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener;
import com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.walknavi.fsm.WGuideFSM;
import com.baidu.platform.comapi.walknavi.h.b;
import com.baidu.platform.comapi.walknavi.widget.a.z;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import com.baidu.platform.comapi.wnplatform.p.r;
import com.baidu.platform.comapi.wnplatform.p.s;
import com.baidu.platform.comjni.jninative.tts.WNaviTTSPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class b implements com.baidu.platform.comapi.walknavi.h.c.a {

    /* renamed from: a, reason: collision with root package name */
    public static int f9700a = 0;
    public static int b = 1;
    public static int c = 2;
    private Bundle A;
    private Context B;
    private Context C;
    private Handler D;
    private int E;
    private int F;
    private LatLng G;
    private LatLng H;
    private com.baidu.platform.comapi.wnplatform.model.c I;
    private int J;
    private int K;
    private boolean L;
    private WalkNaviDisplayOption M;
    private BikeNaviDisplayOption N;
    private ArrayList<com.baidu.platform.comapi.walknavi.e.a> O;
    private ArrayList<BaseNpcModel> P;
    private Bitmap Q;
    private Bitmap R;
    private boolean S;
    private int T;
    private float U;
    private com.baidu.platform.comapi.walknavi.widget.b V;
    private int W;
    private FrameLayout X;
    private final BroadcastReceiver Y;
    private boolean Z;
    private com.baidu.platform.comapi.walknavi.c.b d;
    private com.baidu.platform.comapi.wnplatform.j.l e;
    private com.baidu.platform.comapi.wnplatform.b.a f;
    private com.baidu.platform.comapi.wnplatform.i.f g;
    private WGuideFSM h;
    private com.baidu.platform.comapi.wnplatform.walkmap.d i;
    private com.baidu.platform.comapi.walknavi.a.a j;
    private r k;
    private com.baidu.platform.comapi.wnplatform.tts.a l;
    private com.baidu.platform.comapi.wnplatform.k.c m;
    private com.baidu.platform.comapi.wnplatform.c.d n;
    private com.baidu.platform.comapi.wnplatform.model.b o;
    private com.baidu.platform.comapi.wnplatform.o.a p;
    private com.baidu.platform.comapi.wnplatform.o.a q;
    private boolean r;
    private com.baidu.platform.comapi.wnplatform.n.a s;
    private com.baidu.platform.comapi.wnplatform.a.a t;
    private WalkPlan u;
    private com.baidu.platform.comapi.wnplatform.g.b v;
    private IWNaviStatusListener w;
    private IBNaviStatusListener x;
    private int y;
    private int z;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static final b f9702a = new b(null);
    }

    /* renamed from: com.baidu.platform.comapi.walknavi.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public enum EnumC0532b {
        NORMAL(0),
        AR(1),
        LIGHT(3);

        private final int d;

        EnumC0532b(int i) {
            this.d = i;
        }

        public int a() {
            return this.d;
        }
    }

    public /* synthetic */ b(c cVar) {
        this();
    }

    private void af() {
        if (com.baidu.platform.comapi.wnplatform.f.a().g()) {
            if (a().O().a("WALKNAVI_THREED_MAP_ON_OFF", true)) {
                a().d(-50);
            } else {
                a().d(0);
            }
        }
    }

    private int ag() {
        int i;
        if (Y() != null) {
            i = Y().l();
        } else {
            i = 0;
        }
        if (i <= 0) {
            return 12;
        }
        return i;
    }

    private void ah() {
        if (com.baidu.platform.comapi.wnplatform.f.a().g()) {
            this.l = new com.baidu.platform.comapi.walknavi.g.a();
        } else if (com.baidu.platform.comapi.wnplatform.f.a().h()) {
            this.l = new com.baidu.platform.comapi.bikenavi.b.a();
        }
    }

    private void ai() {
        com.baidu.platform.comapi.walknavi.b.a.c = 19;
    }

    private void aj() {
        BroadcastReceiver broadcastReceiver;
        try {
            Context context = this.B;
            if (context != null && (broadcastReceiver = this.Y) != null) {
                context.unregisterReceiver(broadcastReceiver);
            }
        } catch (IllegalArgumentException e) {
            com.baidu.platform.comapi.wnplatform.d.a.b(e.getMessage());
        }
    }

    public void A() {
        if (D()) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_token", true);
            bundle.putBoolean("is_phoneinfo", true);
            Set<String> keySet = bundle.keySet();
            if (keySet == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                for (String str : keySet) {
                    if (!TextUtils.equals(str, "glr") && !TextUtils.equals(str, "glv")) {
                        jSONObject.put(str, String.valueOf(bundle.get(str)));
                    }
                }
                a().K().b(jSONObject.toString());
            } catch (Exception e) {
                com.baidu.platform.comapi.wnplatform.d.a.b(e.getMessage());
            }
        }
    }

    public boolean B() {
        return O().a("WALKNAVI_FIRST_CLICK_NORMAL_AR_ENTRANCE", true);
    }

    public void C() {
        com.baidu.platform.comapi.walknavi.e.e.c().i();
        com.baidu.platform.comapi.wnplatform.b.a aVar = this.f;
        if (aVar != null && aVar.g()) {
            this.f.i();
        }
        if (this.i != null) {
            a().N().a(0);
        }
        a().a(false);
        aj();
        ae();
        this.L = false;
    }

    public boolean D() {
        if (this.z != 0) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.walknavi.h.c.a
    public void E() {
        IWNaviStatusListener iWNaviStatusListener = this.w;
        if (iWNaviStatusListener != null) {
            iWNaviStatusListener.onNaviExit();
        }
        IBNaviStatusListener iBNaviStatusListener = this.x;
        if (iBNaviStatusListener != null) {
            iBNaviStatusListener.onNaviExit();
        }
        C();
    }

    @Override // com.baidu.platform.comapi.walknavi.h.c.a
    public void F() {
        IWNaviStatusListener iWNaviStatusListener = this.w;
        if (iWNaviStatusListener != null) {
            iWNaviStatusListener.onNaviExit();
        }
        IBNaviStatusListener iBNaviStatusListener = this.x;
        if (iBNaviStatusListener != null) {
            iBNaviStatusListener.onNaviExit();
        }
    }

    public void G() {
        int i;
        int i2;
        if (Y() != null) {
            i = Y().i();
            i2 = Y().h();
        } else {
            i = 0;
            i2 = 0;
        }
        N().a(i, i2);
    }

    public void H() {
        N().k();
    }

    public com.baidu.platform.comapi.walknavi.c.b I() {
        if (this.d == null) {
            this.d = new com.baidu.platform.comapi.walknavi.c.b();
        }
        return this.d;
    }

    public com.baidu.platform.comapi.wnplatform.j.l J() {
        if (this.e == null) {
            this.e = new com.baidu.platform.comapi.wnplatform.j.l();
        }
        return this.e;
    }

    public com.baidu.platform.comapi.wnplatform.b.a K() {
        if (this.f == null) {
            this.f = new com.baidu.platform.comapi.wnplatform.b.a();
        }
        return this.f;
    }

    public com.baidu.platform.comapi.wnplatform.i.f L() {
        if (this.g == null) {
            this.g = new com.baidu.platform.comapi.wnplatform.i.f();
        }
        return this.g;
    }

    public WGuideFSM M() {
        if (this.h == null) {
            this.h = new WGuideFSM();
        }
        return this.h;
    }

    public com.baidu.platform.comapi.wnplatform.walkmap.d N() {
        if (this.i == null) {
            this.i = new com.baidu.platform.comapi.wnplatform.walkmap.d();
        }
        return this.i;
    }

    public r O() {
        if (this.k == null) {
            this.k = new r();
        }
        return this.k;
    }

    public com.baidu.platform.comapi.wnplatform.tts.a P() {
        return this.l;
    }

    public int Q() {
        return this.E;
    }

    public int R() {
        return this.F;
    }

    public Point S() {
        return CoordUtil.ll2point(this.G);
    }

    public LatLng T() {
        return this.G;
    }

    public LatLng U() {
        return this.H;
    }

    public WalkPlan V() {
        return this.u;
    }

    public com.baidu.platform.comapi.wnplatform.k.c W() {
        if (this.m == null) {
            this.m = new com.baidu.platform.comapi.wnplatform.k.c();
        }
        return this.m;
    }

    public com.baidu.platform.comapi.wnplatform.c.d X() {
        if (this.n == null) {
            this.n = new com.baidu.platform.comapi.wnplatform.c.d();
        }
        return this.n;
    }

    public com.baidu.platform.comapi.wnplatform.o.a Y() {
        if (a().R() == EnumC0532b.LIGHT.a()) {
            return this.q;
        }
        return this.p;
    }

    public com.baidu.platform.comapi.wnplatform.model.b Z() {
        if (this.o == null) {
            this.o = new com.baidu.platform.comapi.wnplatform.model.b();
        }
        return this.o;
    }

    public com.baidu.platform.comapi.wnplatform.n.a aa() {
        if (this.s == null) {
            this.s = new com.baidu.platform.comapi.wnplatform.n.a();
        }
        return this.s;
    }

    public MapBound ab() {
        new Bundle();
        Bundle o = a().K().o();
        if (o == null) {
            return null;
        }
        int i = o.getInt("left");
        int i2 = o.getInt("bottom");
        int i3 = o.getInt("right");
        int i4 = o.getInt("top");
        MapBound mapBound = new MapBound();
        mapBound.setPtLB(new Point(i, i2));
        mapBound.setPtRT(new Point(i3, i4));
        return mapBound;
    }

    public Bundle ac() {
        return this.A;
    }

    public boolean ad() {
        return this.Z;
    }

    public void ae() {
        com.baidu.platform.comapi.wnplatform.p.d.a(this.B);
        this.z = 0;
        this.w = null;
        this.x = null;
        com.baidu.platform.comapi.wnplatform.o.a aVar = this.p;
        if (aVar != null) {
            aVar.a((com.baidu.platform.comapi.walknavi.h.c.a) null);
            this.p.release();
            this.p = null;
        }
        com.baidu.platform.comapi.wnplatform.o.a aVar2 = this.q;
        if (aVar2 != null) {
            aVar2.a((com.baidu.platform.comapi.walknavi.h.c.a) null);
            this.q.release();
            this.q = null;
        }
        com.baidu.platform.comapi.wnplatform.j.l lVar = this.e;
        if (lVar != null) {
            lVar.release();
            this.e = null;
        }
        com.baidu.platform.comapi.wnplatform.b.a aVar3 = this.f;
        if (aVar3 != null) {
            aVar3.release();
            this.f = null;
        }
        com.baidu.platform.comapi.wnplatform.i.f fVar = this.g;
        if (fVar != null) {
            fVar.release();
            this.g = null;
        }
        WGuideFSM wGuideFSM = this.h;
        if (wGuideFSM != null) {
            wGuideFSM.release();
            this.h = null;
        }
        com.baidu.platform.comapi.wnplatform.walkmap.d dVar = this.i;
        if (dVar != null) {
            dVar.release();
            this.i = null;
        }
        com.baidu.platform.comapi.walknavi.a.a aVar4 = this.j;
        if (aVar4 != null) {
            aVar4.release();
            this.j = null;
        }
        r rVar = this.k;
        if (rVar != null) {
            rVar.release();
            this.k = null;
        }
        com.baidu.platform.comapi.wnplatform.k.c cVar = this.m;
        if (cVar != null) {
            cVar.release();
            this.m = null;
        }
        com.baidu.platform.comapi.wnplatform.c.d dVar2 = this.n;
        if (dVar2 != null) {
            dVar2.release();
            this.n = null;
        }
        com.baidu.platform.comapi.wnplatform.model.b bVar = this.o;
        if (bVar != null) {
            bVar.release();
            this.o = null;
        }
        com.baidu.platform.comapi.wnplatform.n.a aVar5 = this.s;
        if (aVar5 != null) {
            aVar5.release();
            this.s = null;
        }
        com.baidu.platform.comapi.wnplatform.g.b bVar2 = this.v;
        if (bVar2 != null) {
            bVar2.release();
            this.v = null;
        }
        com.baidu.platform.comapi.wnplatform.a.a aVar6 = this.t;
        if (aVar6 != null) {
            aVar6.release();
            this.t = null;
        }
        ArrayList<com.baidu.platform.comapi.walknavi.e.a> arrayList = this.O;
        if (arrayList != null) {
            arrayList.clear();
            this.O = null;
        }
        ArrayList<BaseNpcModel> arrayList2 = this.P;
        if (arrayList2 != null) {
            arrayList2.clear();
            this.P = null;
        }
        Bitmap bitmap = this.Q;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.Q.recycle();
            this.Q = null;
        }
        Bitmap bitmap2 = this.R;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.R.recycle();
            this.R = null;
        }
        com.baidu.platform.comapi.wnplatform.tts.a aVar7 = this.l;
        if (aVar7 != null) {
            aVar7.release();
            this.l = null;
        }
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.j = null;
        this.k = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.s = null;
        this.t = null;
        this.A = null;
        this.y = 0;
        this.B = null;
        this.u = null;
        com.baidu.platform.comapi.walknavi.h.b.b.a();
        s.a().d();
        com.baidu.platform.comapi.wnplatform.p.a.a.a();
    }

    public void b(String str) {
    }

    public void e() {
        if (com.baidu.platform.comapi.walknavi.e.e.c().d()) {
            com.baidu.platform.comapi.walknavi.e.e.c().f();
        }
    }

    public boolean f() {
        SensorManager sensorManager;
        List<Sensor> sensorList;
        Context a2 = com.baidu.platform.comapi.wnplatform.p.b.a.a();
        if (a2 == null || (sensorManager = (SensorManager) a2.getSystemService("sensor")) == null || (sensorList = sensorManager.getSensorList(-1)) == null) {
            return false;
        }
        Iterator<Sensor> it = sensorList.iterator();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (it.hasNext()) {
            int type = it.next().getType();
            if (type == 11) {
                z = true;
            } else if (type == 1) {
                z2 = true;
            } else if (type == 2) {
                z3 = true;
            }
        }
        return z || (z2 && z3);
    }

    public Context g() {
        return this.B;
    }

    public boolean h() {
        return this.L;
    }

    public void i() {
        e();
        if (com.baidu.platform.comapi.wnplatform.f.a().h()) {
            N().a(1);
        } else if (com.baidu.platform.comapi.wnplatform.f.a().g()) {
            if (y() == 1) {
                N().a(1);
            } else if (y() == 2) {
                N().a(0);
            }
        }
        if (this.p != null) {
            W().a(this.B, this.p.z());
            this.p.a(this);
            this.p.f();
        }
        if (this.q != null) {
            W().a(this.B, this.q.z());
            this.q.a(this);
            this.q.f();
        }
        if (a().N().f9974a) {
            a().N().f();
        } else {
            M().runCurrentState();
        }
    }

    public void j() {
        d();
        com.baidu.platform.comapi.wnplatform.k.c cVar = this.m;
        if (cVar != null) {
            cVar.a();
        }
        com.baidu.platform.comapi.wnplatform.o.a aVar = this.p;
        if (aVar != null) {
            aVar.a((com.baidu.platform.comapi.walknavi.h.c.a) null);
            this.p.g();
        }
        com.baidu.platform.comapi.wnplatform.o.a aVar2 = this.q;
        if (aVar2 != null) {
            aVar2.a((com.baidu.platform.comapi.walknavi.h.c.a) null);
            this.q.g();
        }
    }

    public void k() {
        com.baidu.platform.comapi.walknavi.c.b bVar = this.d;
        if (bVar != null) {
            bVar.release();
        }
    }

    public boolean l() {
        com.baidu.platform.comapi.walknavi.c.b bVar = this.d;
        if (bVar == null || bVar.a() <= 0) {
            return false;
        }
        return true;
    }

    public void m() {
        this.d.b();
    }

    public void n() {
        N().b();
    }

    public WalkNaviDisplayOption o() {
        return this.M;
    }

    public void p() {
        if (this.M != null) {
            this.M = null;
        }
    }

    public BikeNaviDisplayOption q() {
        return this.N;
    }

    public void r() {
        if (this.N != null) {
            this.N = null;
        }
    }

    public ArrayList<com.baidu.platform.comapi.walknavi.e.a> s() {
        ArrayList<com.baidu.platform.comapi.walknavi.e.a> arrayList = this.O;
        if (arrayList == null || arrayList.size() == 0) {
            c((ArrayList<BaseNpcModel>) null);
        }
        return this.O;
    }

    public ArrayList<BaseNpcModel> t() {
        ArrayList<BaseNpcModel> arrayList = this.P;
        if (arrayList == null || arrayList.size() == 0) {
            b((ArrayList<BaseNpcModel>) null);
        }
        return this.P;
    }

    public boolean u() {
        if (this.z < 2) {
            return false;
        }
        this.L = true;
        MapStatus h = N().h();
        this.z = 3;
        com.baidu.platform.comapi.wnplatform.o.a aVar = this.p;
        if (aVar != null && (aVar instanceof com.baidu.platform.comapi.walknavi.h.b)) {
            aVar.k();
        }
        N().a(1);
        K().e(ag());
        if (com.baidu.platform.comapi.walknavi.h.b.b.f9767a != 4) {
            if (com.baidu.platform.comapi.wnplatform.f.a().c()) {
                g(EnumC0532b.AR.a());
            } else if (com.baidu.platform.comapi.wnplatform.f.a().f()) {
                g(EnumC0532b.LIGHT.a());
            } else {
                g(EnumC0532b.NORMAL.a());
            }
            if (S() != null) {
                K().a(S().x, S().y, 0, (String) null, (String) null);
            }
            K().h();
        }
        a().K().a(true);
        N().a(h);
        if (com.baidu.platform.comapi.walknavi.h.b.b.f9767a == 4) {
            K().k();
            return true;
        }
        this.D.postDelayed(new d(this), 500L);
        return true;
    }

    public void v() {
        K().r();
    }

    public int w() {
        return this.J;
    }

    public void x() {
        a().a(true);
        if (com.baidu.platform.comapi.wnplatform.f.a().b()) {
            N().a().getMap().setMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder(N().a().getMap().getMapStatus()).zoom(22.0f).build()));
            a().M().run(RGFSMTable.FsmEvent.BTN_CLICK_NORTH_2D);
        }
    }

    public int y() {
        return this.W;
    }

    public void z() {
        if (a().N().f9974a) {
            a().N().f();
        } else {
            M().run("[查看全览]按钮点击");
        }
    }

    private b() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = true;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = 0;
        this.z = 0;
        this.A = new Bundle();
        this.D = new Handler();
        this.J = -1;
        this.K = -1;
        this.L = false;
        this.O = new ArrayList<>();
        this.P = new ArrayList<>();
        this.Q = null;
        this.R = null;
        this.S = false;
        this.T = 0;
        this.U = 0.0f;
        this.Y = new l(this);
        this.Z = false;
    }

    public boolean c() {
        SensorManager sensorManager;
        List<Sensor> sensorList;
        Iterator<Sensor> it;
        Context a2 = com.baidu.platform.comapi.wnplatform.p.b.a.a();
        if (a2 == null || (sensorManager = (SensorManager) a2.getSystemService("sensor")) == null || (sensorList = sensorManager.getSensorList(-1)) == null || (it = sensorList.iterator()) == null) {
            return true;
        }
        while (it.hasNext()) {
            if (it.next().getType() == 11) {
                return true;
            }
        }
        return false;
    }

    public void d() {
        com.baidu.platform.comapi.wnplatform.o.a aVar;
        com.baidu.platform.comapi.walknavi.h.c.c o;
        if (!com.baidu.platform.comapi.walknavi.e.e.c().d() || (aVar = this.p) == null || !(aVar instanceof com.baidu.platform.comapi.walknavi.h.b) || (o = ((com.baidu.platform.comapi.walknavi.h.b) aVar).o()) == null) {
            return;
        }
        o.c(false);
    }

    public void g(int i) {
        com.baidu.platform.comapi.wnplatform.b.a aVar = this.f;
        if (aVar != null) {
            aVar.i(i);
        }
    }

    public MapBound h(int i) {
        new Bundle();
        Bundle g = a().K().g(i);
        int i2 = g.getInt("left");
        int i3 = g.getInt("bottom");
        int i4 = g.getInt("right");
        int i5 = g.getInt("top");
        MapBound mapBound = new MapBound();
        mapBound.setPtLB(new Point(i2, i3));
        mapBound.setPtRT(new Point(i4, i5));
        return mapBound;
    }

    public int b() {
        return this.T;
    }

    public void e(int i) {
        this.E = i;
    }

    public static b a() {
        return a.f9702a;
    }

    public View b(Activity activity) {
        if (com.baidu.platform.comapi.wnplatform.f.a().g()) {
            com.baidu.platform.comapi.wnplatform.o.a aVar = this.q;
            if (aVar != null && (aVar instanceof com.baidu.platform.comapi.bikenavi.c.l)) {
                aVar.a((com.baidu.platform.comapi.walknavi.h.c.a) null);
                this.q.release();
                this.q = null;
            }
            if (this.q == null) {
                this.q = new com.baidu.platform.comapi.walknavi.h.a(activity);
            }
        } else if (com.baidu.platform.comapi.wnplatform.f.a().h()) {
            com.baidu.platform.comapi.wnplatform.o.a aVar2 = this.q;
            if (aVar2 != null && (aVar2 instanceof com.baidu.platform.comapi.walknavi.h.a)) {
                aVar2.a((com.baidu.platform.comapi.walknavi.h.c.a) null);
                this.q.release();
                this.q = null;
            }
            if (this.q == null) {
                this.q = new com.baidu.platform.comapi.bikenavi.c.l(activity);
            }
        }
        return this.q.j();
    }

    public void a(int i) {
        this.T = i;
    }

    public void a(int i, int i2) {
        com.baidu.platform.comapi.wnplatform.f.a().b(i);
        com.baidu.platform.comapi.wnplatform.f.a().c(i2);
        b(i);
        ah();
    }

    public boolean d(int i) {
        if (K() != null) {
            return this.f.j(i);
        }
        return false;
    }

    public void f(int i) {
        this.F = i;
    }

    public View c(Activity activity) {
        if (com.baidu.platform.comapi.wnplatform.f.a().g()) {
            com.baidu.platform.comapi.wnplatform.o.a aVar = this.p;
            if (aVar != null && (aVar instanceof com.baidu.platform.comapi.bikenavi.c.b)) {
                aVar.a((com.baidu.platform.comapi.walknavi.h.c.a) null);
                this.p.release();
                this.p = null;
            }
            if (this.p == null) {
                this.p = new com.baidu.platform.comapi.walknavi.h.b(activity);
            }
        } else if (com.baidu.platform.comapi.wnplatform.f.a().h()) {
            com.baidu.platform.comapi.wnplatform.o.a aVar2 = this.p;
            if (aVar2 != null && (aVar2 instanceof com.baidu.platform.comapi.walknavi.h.b)) {
                aVar2.a((com.baidu.platform.comapi.walknavi.h.c.a) null);
                this.p.release();
                this.p = null;
            }
            if (this.p == null) {
                this.p = new com.baidu.platform.comapi.bikenavi.c.b(activity);
            }
        }
        return this.p.j();
    }

    public void a(Activity activity, IWRouteGuidanceListener iWRouteGuidanceListener) {
        a(activity).a(iWRouteGuidanceListener);
    }

    public void a(Activity activity, IBRouteGuidanceListener iBRouteGuidanceListener) {
        a(activity).a(iBRouteGuidanceListener);
    }

    public com.baidu.platform.comapi.wnplatform.g.b a(Activity activity) {
        if (this.v == null) {
            this.v = new com.baidu.platform.comapi.wnplatform.g.b(activity);
        }
        return this.v;
    }

    public void a(Context context, long j, com.baidu.platform.comapi.walknavi.c.a aVar) {
        if (this.d == null) {
            this.d = new com.baidu.platform.comapi.walknavi.c.b();
        }
        this.z = 1;
        this.d.a(context, j, aVar);
        X().a(context);
        X().b(context);
    }

    public void b(com.baidu.platform.comapi.wnplatform.j.f fVar) {
        J().b(fVar);
    }

    private void b(ArrayList<BaseNpcModel> arrayList) {
        ArrayList<BaseNpcModel> arrayList2 = this.P;
        if (arrayList2 != null) {
            arrayList2.clear();
        } else {
            this.P = new ArrayList<>();
        }
        if (this.Q == null) {
            this.Q = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.p.a.a.b(), R.drawable.wsdk_icon_classic);
        }
        BaseNpcModel baseNpcModel = new BaseNpcModel();
        baseNpcModel.setDownLoadKey("");
        baseNpcModel.setIcon(this.Q);
        baseNpcModel.setOriginTitle("经典");
        baseNpcModel.setLoadFromLocal(true);
        this.P.add(baseNpcModel);
        if (this.R == null) {
            this.R = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.p.a.a.b(), R.drawable.wsdk_icon_tutu);
        }
        BaseNpcModel baseNpcModel2 = new BaseNpcModel();
        baseNpcModel2.setDownLoadKey("10279765");
        baseNpcModel2.setIcon(this.R);
        baseNpcModel2.setOriginTitle("图图");
        baseNpcModel2.setLoadFromLocal(false);
        this.P.add(baseNpcModel2);
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.P.addAll(arrayList);
    }

    private int i(int i) {
        return (com.baidu.platform.comapi.wnplatform.p.g.b() == 1 && com.baidu.platform.comapi.wnplatform.p.g.a()) ? i | 4 : i;
    }

    public boolean a(long j) {
        com.baidu.platform.comapi.walknavi.c.b bVar = this.d;
        if (bVar == null) {
            return false;
        }
        return bVar.a(j);
    }

    public void a(Context context, MapView mapView) {
        N().a(context, mapView);
    }

    private void c(ArrayList<BaseNpcModel> arrayList) {
        ArrayList<com.baidu.platform.comapi.walknavi.e.a> arrayList2 = this.O;
        if (arrayList2 != null) {
            arrayList2.clear();
        } else {
            this.O = new ArrayList<>();
        }
        com.baidu.platform.comapi.walknavi.e.a aVar = new com.baidu.platform.comapi.walknavi.e.a();
        aVar.a("");
        aVar.b("经典");
        aVar.a(true);
        aVar.a(this.Q);
        this.O.add(aVar);
        com.baidu.platform.comapi.walknavi.e.a aVar2 = new com.baidu.platform.comapi.walknavi.e.a();
        aVar2.a("10279765");
        aVar2.b("图图");
        aVar2.a(false);
        aVar2.a(this.R);
        this.O.add(aVar2);
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<BaseNpcModel> it = arrayList.iterator();
        while (it.hasNext()) {
            BaseNpcModel next = it.next();
            com.baidu.platform.comapi.walknavi.e.a aVar3 = new com.baidu.platform.comapi.walknavi.e.a();
            aVar3.a(next.getDownLoadKey());
            aVar3.b(next.getOriginTitle());
            aVar3.c(next.getModelSize());
            aVar3.d(next.getLocalPath());
            aVar3.a(next.getIcon());
            aVar3.a(next.isLoadFromLocal());
            this.O.add(aVar3);
        }
    }

    public void a(com.baidu.platform.comapi.wnplatform.j.f fVar) {
        J().a(fVar);
    }

    public void a(WLocData wLocData) {
        com.baidu.platform.comapi.wnplatform.c.d dVar = this.n;
        if (dVar == null || wLocData == null) {
            return;
        }
        dVar.b(wLocData);
    }

    public void a(WalkNaviDisplayOption walkNaviDisplayOption) {
        this.M = walkNaviDisplayOption;
    }

    public void a(BikeNaviDisplayOption bikeNaviDisplayOption) {
        this.N = bikeNaviDisplayOption;
    }

    public void a(com.baidu.platform.comapi.wnplatform.tts.c cVar) {
        P().a(cVar);
    }

    public void a(ArrayList<BaseNpcModel> arrayList) {
        b(arrayList);
        c(arrayList);
    }

    public com.baidu.platform.comapi.walknavi.e.a a(String str) {
        ArrayList<com.baidu.platform.comapi.walknavi.e.a> s = s();
        if (s != null && s.size() != 0) {
            Iterator<com.baidu.platform.comapi.walknavi.e.a> it = s.iterator();
            while (it.hasNext()) {
                com.baidu.platform.comapi.walknavi.e.a next = it.next();
                if (TextUtils.equals(next.c(), str)) {
                    return next;
                }
            }
        }
        return null;
    }

    public void a(BaseNpcModel baseNpcModel) {
        com.baidu.platform.comapi.walknavi.h.c.c o;
        com.baidu.platform.comapi.wnplatform.o.a aVar = this.p;
        if (aVar == null || !(aVar instanceof com.baidu.platform.comapi.walknavi.h.b) || (o = ((com.baidu.platform.comapi.walknavi.h.b) aVar).o()) == null) {
            return;
        }
        o.a(baseNpcModel);
    }

    public RelativeLayout a(z.a aVar) {
        com.baidu.platform.comapi.wnplatform.o.a aVar2 = this.p;
        if (aVar2 instanceof com.baidu.platform.comapi.walknavi.h.b) {
            return ((com.baidu.platform.comapi.walknavi.h.b) aVar2).a(aVar);
        }
        return null;
    }

    public void a(IWNPCEngineInitListener iWNPCEngineInitListener) {
        com.baidu.platform.comapi.walknavi.e.e.c().a("10279765", new c(this, iWNPCEngineInitListener));
    }

    public void b(int i) {
        K().h(i);
    }

    public void a(IWMoreNPCModelOnClickListener iWMoreNPCModelOnClickListener) {
        com.baidu.platform.comapi.walknavi.h.c.c o;
        com.baidu.platform.comapi.wnplatform.o.a aVar = this.p;
        if (aVar == null || !(aVar instanceof com.baidu.platform.comapi.walknavi.h.b) || (o = ((com.baidu.platform.comapi.walknavi.h.b) aVar).o()) == null) {
            return;
        }
        o.a(iWMoreNPCModelOnClickListener);
    }

    public boolean b(boolean z) {
        return O().b("WALKNAVI_FIRST_CLICK_NORMAL_AR_ENTRANCE", z);
    }

    public void b(LatLng latLng) {
        this.H = latLng;
    }

    public void a(IWNPCLoadAndInitListener iWNPCLoadAndInitListener) {
        com.baidu.platform.comapi.walknavi.h.c.c o;
        com.baidu.platform.comapi.wnplatform.o.a aVar = this.p;
        if (aVar == null || !(aVar instanceof com.baidu.platform.comapi.walknavi.h.b) || (o = ((com.baidu.platform.comapi.walknavi.h.b) aVar).o()) == null) {
            return;
        }
        o.a(iWNPCLoadAndInitListener);
    }

    public boolean a(Activity activity, Bundle bundle) {
        boolean a2;
        K().s();
        this.B = activity;
        this.C = activity;
        try {
            if (bundle != null) {
                com.baidu.platform.comapi.walknavi.h.b.b.f9767a = bundle.getInt("wnavi_mode", 1);
            } else {
                com.baidu.platform.comapi.walknavi.h.b.b.f9767a = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (a().Q() != 4) {
            if (P() != null) {
                P().ready();
            }
            if (com.baidu.platform.comapi.wnplatform.f.a().g()) {
                a2 = a().O().a("WALKNAVI_VOICE_ON_OFF", true);
            } else {
                a2 = com.baidu.platform.comapi.wnplatform.f.a().h() ? a().O().a("BIKENAVI_VOICE_ON_OFF", true) : true;
            }
            if (a2) {
                WNaviTTSPlayer.resumeVoiceTTSOutput();
            } else {
                WNaviTTSPlayer.pauseVoiceTTSOutput();
            }
        } else {
            WNaviTTSPlayer.pauseVoiceTTSOutput();
        }
        int R = R();
        EnumC0532b enumC0532b = EnumC0532b.LIGHT;
        if (R == enumC0532b.a()) {
            WNaviTTSPlayer.pauseVoiceTTSOutput();
        }
        N().ready();
        if (R() == enumC0532b.a()) {
            if (this.q == null) {
                if (com.baidu.platform.comapi.wnplatform.f.a().g()) {
                    this.q = new com.baidu.platform.comapi.walknavi.h.a(activity);
                } else if (com.baidu.platform.comapi.wnplatform.f.a().h()) {
                    this.q = new com.baidu.platform.comapi.bikenavi.c.l(activity);
                }
            }
            com.baidu.platform.comapi.wnplatform.o.a aVar = this.q;
            if (aVar == null || aVar.e()) {
                return false;
            }
            this.q.ready();
        } else {
            if (this.p == null) {
                if (com.baidu.platform.comapi.wnplatform.f.a().g()) {
                    this.p = new com.baidu.platform.comapi.walknavi.h.b(activity);
                } else if (com.baidu.platform.comapi.wnplatform.f.a().h()) {
                    this.p = new com.baidu.platform.comapi.bikenavi.c.b(activity);
                }
            }
            com.baidu.platform.comapi.wnplatform.o.a aVar2 = this.p;
            if (aVar2 == null || aVar2.e()) {
                return false;
            }
            this.p.ready();
        }
        G();
        if (a().Q() != 4 && !X().e()) {
            X().a(this.B);
        }
        L().ready();
        J().ready();
        v();
        int i = com.baidu.platform.comapi.walknavi.h.b.b.f9767a;
        if (i == 1) {
            X().b(activity);
        } else if (i == 3) {
            aa().ready();
        }
        ai();
        N().c();
        this.z = 2;
        af();
        int i2 = 16;
        if (com.baidu.platform.comapi.wnplatform.f.a().g()) {
            if (this.F == EnumC0532b.AR.a()) {
                i2 = 2;
            } else if (this.F != enumC0532b.a()) {
                i2 = 1;
            }
            a().a(i(i2), true);
            int a3 = com.baidu.platform.comapi.wnplatform.p.g.a(V(), b());
            if (a3 == 2 || a3 == 3) {
                a().a(this.B, (b.InterfaceC0537b) null, a3);
            }
        } else if (com.baidu.platform.comapi.wnplatform.f.a().h()) {
            if (R() == enumC0532b.a()) {
                a().g(enumC0532b.a());
                com.baidu.platform.comapi.wnplatform.f.a().a(16);
            } else {
                a().g(0);
                com.baidu.platform.comapi.wnplatform.f.a().a(1);
            }
        }
        N().a().getMap().setBaiduHeatMapEnabled(false);
        N().a().getMap().setTrafficEnabled(false);
        N().a().getMap().setMyLocationEnabled(false);
        return true;
    }

    public void c(int i) {
        K().k(i);
    }

    public void c(boolean z) {
        this.Z = z;
        com.baidu.platform.comapi.wnplatform.i.f fVar = this.g;
        if (fVar != null) {
            fVar.release();
            this.g = null;
        }
    }

    public void a(com.baidu.platform.comapi.wnplatform.model.c cVar) {
        this.I = cVar;
    }

    public void a(Bundle bundle) {
        K().e(bundle);
    }

    public void a(int i, String str) {
        this.D.postDelayed(new e(this, str), i);
    }

    public void a(IWNaviStatusListener iWNaviStatusListener) {
        this.w = iWNaviStatusListener;
        com.baidu.platform.comapi.wnplatform.o.a aVar = this.p;
        if (aVar == null || !(aVar instanceof com.baidu.platform.comapi.walknavi.h.b)) {
            return;
        }
        ((com.baidu.platform.comapi.walknavi.h.b) aVar).a(iWNaviStatusListener);
    }

    public void a(IBNaviStatusListener iBNaviStatusListener) {
        this.x = iBNaviStatusListener;
        com.baidu.platform.comapi.wnplatform.o.a aVar = this.p;
        if (aVar == null || !(aVar instanceof com.baidu.platform.comapi.bikenavi.c.b)) {
            return;
        }
        ((com.baidu.platform.comapi.bikenavi.c.b) aVar).a(iBNaviStatusListener);
    }

    public void a(boolean z) {
        if (z) {
            com.baidu.platform.comapi.wnplatform.p.e.a(true);
            com.baidu.platform.comapi.wnplatform.f.a().a(com.baidu.platform.comapi.wnplatform.f.a().e() | 4);
        } else {
            com.baidu.platform.comapi.wnplatform.p.e.a(false);
            com.baidu.platform.comapi.wnplatform.f.a().a(com.baidu.platform.comapi.wnplatform.f.a().e() & (-5));
        }
    }

    public void a(Context context, b.InterfaceC0537b interfaceC0537b, int i) {
        String str;
        if (context == null) {
            return;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager.isWifiEnabled()) {
                if (interfaceC0537b != null) {
                    interfaceC0537b.a(i);
                    return;
                }
                return;
            }
            if (i == 1 || i == 3) {
                str = "不导航了";
            } else if (i == 2) {
                str = "不需要";
            } else {
                str = "取消";
            }
            Activity activity = (Activity) context;
            com.baidu.platform.comapi.walknavi.widget.b b2 = new com.baidu.platform.comapi.walknavi.widget.b(activity).a(true).b("温馨提示").a("您所在的商户支持室内导航,开启WIFI即可使用室内导航").c(str).a(new g(this, interfaceC0537b, i)).d("去开启").b(new f(this, wifiManager, interfaceC0537b, i));
            this.V = b2;
            if (b2.isShowing() || activity.isFinishing()) {
                return;
            }
            this.V.show();
        } catch (Exception unused) {
        }
    }

    public void a(boolean z, boolean z2) {
        if (z) {
            a(this.B, new h(this), com.baidu.platform.comapi.wnplatform.p.g.a(z2));
        } else {
            a().a(false);
        }
    }

    public void a(int i, boolean z) {
        com.baidu.platform.comapi.wnplatform.f.a().a(i);
        IWNaviStatusListener iWNaviStatusListener = this.w;
        if (iWNaviStatusListener != null) {
            iWNaviStatusListener.onWalkNaviModeChange(i, new j(this, i, z));
        }
        if (z) {
            if (com.baidu.platform.comapi.wnplatform.f.a().d()) {
                x();
            } else {
                a().a(false);
            }
        }
    }

    public void a(FrameLayout frameLayout) {
        this.X = frameLayout;
    }

    public void a(LatLng latLng) {
        this.G = latLng;
    }

    public void a(WalkPlan walkPlan) {
        this.u = walkPlan;
    }
}
