package com.baidu.navisdk.ui.routeguide.control;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.baidumaps.aihome.common.SmartSpaceAuth;
import com.baidu.location.LocationConst;
import com.baidu.navisdk.adapter.IBNRouteResultManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.m0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.w0;
import com.baidu.navisdk.ui.routeguide.model.o;
import com.baidu.navisdk.ui.routeguide.model.v;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.util.MD5;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.o00;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @oOoXoXO
    private static String f8536a;
    private static boolean b;
    private static boolean c;

    @oOoXoXO
    private static RoutePlanNode e;
    private static RoutePlanNode f;
    private static int g;

    @oOoXoXO
    private static RoutePlanNode h;

    @oOoXoXO
    private static String i;
    private static boolean j;
    private static volatile boolean l;

    @OOXIXo
    public static final e o = new e();
    private static boolean d = true;
    private static Handler k = new a();

    @OOXIXo
    private static com.baidu.navisdk.comapi.routeplan.v2.a m = new b();
    private static final com.baidu.navisdk.comapi.base.d n = new c("mRoutePlanResultHandler");

    /* loaded from: classes8.dex */
    public static final class a extends com.baidu.navisdk.util.worker.loop.a {
        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(@OOXIXo Message msg) {
            Object obj;
            IIX0o.x0xO0oo(msg, "msg");
            if (msg.what == 1001) {
                e eVar = e.o;
                if (e.e(eVar) && (obj = msg.obj) != null && (obj instanceof RoutePlanNode)) {
                    eVar.a((RoutePlanNode) obj, false);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends com.baidu.navisdk.comapi.routeplan.v2.a {
        @Override // com.baidu.navisdk.comapi.routeplan.v2.a
        @oOoXoXO
        public String getName() {
            return null;
        }

        @Override // com.baidu.navisdk.comapi.routeplan.v2.a
        public void onRoutePlan(int i, int i2, @oOoXoXO com.baidu.navisdk.comapi.routeplan.v2.d dVar, @oOoXoXO Bundle bundle) {
            if (i == 65) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGArriveApproachParkController", "YAWING_SUCCESS----");
                }
                e.o.a(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends com.baidu.navisdk.util.worker.loop.b {
        public c(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(4099);
        }

        @Override // com.baidu.navisdk.util.worker.loop.b
        public void onMessage(@OOXIXo Message msg) {
            IIX0o.x0xO0oo(msg, "msg");
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "mRoutePlanResultHandler message's what is " + msg.what + ", arg1=" + msg.arg1 + ", arg2=" + msg.arg2 + ", showRoutePlanTip==" + e.d(e.o));
            }
            if (msg.what == 4099 && msg.arg1 == 0) {
                Bundle bundle = new Bundle();
                BNRoutePlaner.getInstance().a(new ArrayList<>(), bundle);
                if (bundle.containsKey("unRoutePlanID")) {
                    int i = bundle.getInt("unRoutePlanID");
                    e eVar = e.o;
                    if (e.b(eVar) == i) {
                        if (eVar.d() && eVar.c() == null) {
                            eVar.b(e.a(eVar));
                        }
                        eVar.b(1);
                        com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().d(!eVar.d());
                        if (e.d(eVar)) {
                            s.T().a("已为您规划到推荐车位的路线", true);
                            e.b = false;
                        }
                    }
                }
            }
            com.baidu.navisdk.vi.b.b(this);
        }
    }

    /* loaded from: classes8.dex */
    public static final class h extends com.baidu.navisdk.asr.i.a {
        final /* synthetic */ com.baidu.navisdk.ui.routeguide.model.o b;
        final /* synthetic */ RoutePlanNode c;
        final /* synthetic */ Ref.ObjectRef d;

        public h(com.baidu.navisdk.ui.routeguide.model.o oVar, RoutePlanNode routePlanNode, Ref.ObjectRef objectRef) {
            this.b = oVar;
            this.c = routePlanNode;
            this.d = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.navisdk.asr.i.a
        public void a(@OOXIXo String intention, boolean z) {
            IIX0o.x0xO0oo(intention, "intention");
            super.a(intention, z);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "BNAsrConfirmListener confirm == " + z);
            }
            if (z) {
                e.o.a(this.b, 2, this.c);
            }
            ((i0) this.d.element).c();
            com.baidu.navisdk.asr.d.B().c();
        }

        @Override // com.baidu.navisdk.asr.i.a
        public void b() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "BNAsrConfirmListener stop");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class i implements i0.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.ui.routeguide.model.o f8539a;
        final /* synthetic */ RoutePlanNode b;

        public i(com.baidu.navisdk.ui.routeguide.model.o oVar, RoutePlanNode routePlanNode) {
            this.f8539a = oVar;
            this.b = routePlanNode;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            e.o.a(this.f8539a, 2, this.b);
        }
    }

    private e() {
    }

    public static final /* synthetic */ int b(e eVar) {
        return g;
    }

    public static final /* synthetic */ boolean c(e eVar) {
        return j;
    }

    public static final /* synthetic */ boolean d(e eVar) {
        return b;
    }

    public static final /* synthetic */ boolean e(e eVar) {
        return l;
    }

    private final void f(RoutePlanNode routePlanNode) {
        HashMap<String, String> params = com.baidu.navisdk.util.http.a.a();
        IIX0o.oO(params, "params");
        IIX0o.ooOOo0oXI(routePlanNode);
        params.put("uid", routePlanNode.getUID());
        params.put(TypedValues.TransitionType.S_FROM, MapItem.KEY_IS_MAP_ITEM);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "requestServiceAreaZoneInfo->params:" + params);
        }
        String b2 = com.baidu.navisdk.util.http.b.d().b("HighwayServicePartition");
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "requestServiceAreaZoneInfo->url:" + b2);
        }
        com.baidu.navisdk.util.http.center.b.a().a(b2, params, new g(), null);
    }

    private final boolean g() {
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V, "BNavigator.getInstance()");
        int q = V.q();
        com.baidu.navisdk.framework.interfaces.t i2 = com.baidu.navisdk.module.vehiclemanager.b.i();
        IIX0o.oO(i2, "BNVehicleManager.getInstance()");
        boolean f2 = i2.f();
        com.baidu.navisdk.ui.routeguide.b V2 = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V2, "BNavigator.getInstance()");
        boolean A = V2.A();
        boolean a2 = com.baidu.navisdk.module.asr.h.a();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "sceneType -> " + q + ", isCar = " + f2 + ", isFromCarLink = " + A + ", isOffLineMode = " + a2);
        }
        if (f2 && q != 3 && !A && !a2) {
            return true;
        }
        return false;
    }

    private final void h() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "stopLoopStall");
        }
        l = false;
        k.removeMessages(1001);
    }

    public static final /* synthetic */ RoutePlanNode a(e eVar) {
        return f;
    }

    private final void e(RoutePlanNode routePlanNode) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "requestNewStall node = " + routePlanNode + TokenParser.SP + ",mCurRoutePlanNode = " + h);
        }
        Message obtainMessage = k.obtainMessage(1001);
        IIX0o.oO(obtainMessage, "mHandler.obtainMessage(LOOP_STALL_MSG_TYPE)");
        if (routePlanNode == null) {
            routePlanNode = h;
        }
        obtainMessage.obj = routePlanNode;
        if (routePlanNode != null) {
            k.sendMessageDelayed(obtainMessage, 60000L);
        }
    }

    @oOoXoXO
    public final RoutePlanNode c() {
        return e;
    }

    public final boolean d() {
        return c;
    }

    private final RoutePlanNode c(int i2, int i3) {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        BNRoutePlaner.getInstance().b(arrayList);
        if (arrayList.size() != 2 || i2 != 0) {
            return null;
        }
        Bundle bundle = arrayList.get(arrayList.size() - 1);
        IIX0o.oO(bundle, "routePlanNodeBundleList[…nNodeBundleList.size - 1]");
        Bundle bundle2 = bundle;
        double d2 = Integer.MIN_VALUE;
        double d3 = bundle2.getDouble("x", d2);
        double d4 = bundle2.getDouble("y", d2);
        String string = bundle2.getString("uid", "");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "getEndNode --> x:" + d3 + ", y:" + d4 + ", uid:" + string);
        }
        double d5 = 100000;
        RoutePlanNode routePlanNode = new RoutePlanNode(new GeoPoint((int) (d3 * d5), (int) (d4 * d5)), 0, (String) null, (String) null, string);
        routePlanNode.setPoiType(i3);
        return routePlanNode;
    }

    private final void d(RoutePlanNode routePlanNode) {
        h = routePlanNode;
        IIX0o.ooOOo0oXI(routePlanNode);
        String uid = routePlanNode.getUID();
        IIX0o.oO(uid, "node!!.uid");
        HashMap<String, String> a2 = a(uid, 2, 0);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "requestIndoorParkInfo->params:" + a2);
        }
        String str = com.baidu.navisdk.util.http.b.d().b("ApproachNodeParkService") + "/parking/api/navi/rpbyparkbid";
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "requestIndoorParkInfo->url:" + str);
        }
        com.baidu.navisdk.util.http.center.b.a().a(str, a2, new d(routePlanNode), null);
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.control.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0438e extends com.baidu.navisdk.util.http.center.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f8538a;
        final /* synthetic */ RoutePlanNode b;

        public C0438e(boolean z, RoutePlanNode routePlanNode) {
            this.f8538a = z;
            this.b = routePlanNode;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, @oOoXoXO String str, @oOoXoXO Throwable th) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestParkingRecommend->onFailure ,statusCode + ");
                sb.append(i);
                sb.append("responseString=");
                sb.append(str);
                sb.append(",");
                sb.append(th != null ? th.toString() : null);
                gVar.e("RGArriveApproachParkController", sb.toString());
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, @oOoXoXO String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "requestParkingRecommend-> onSuccess! responseString = " + str);
            }
            e eVar = e.o;
            if (e.c(eVar)) {
                e.j = false;
                boolean z = this.f8538a;
                if (z) {
                    eVar.a(str, !z, this.b, z);
                    return;
                }
                return;
            }
            boolean z2 = this.f8538a;
            eVar.a(str, !z2, this.b, z2);
        }
    }

    /* loaded from: classes8.dex */
    public static final class f extends com.baidu.navisdk.util.http.center.f {
        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, @oOoXoXO String str, @oOoXoXO Throwable th) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestRemainStall->onFailure ,statusCode + ");
                sb.append(i);
                sb.append("responseString=");
                sb.append(str);
                sb.append(",");
                sb.append(th != null ? th.toString() : null);
                gVar.e("RGArriveApproachParkController", sb.toString());
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, @oOoXoXO String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "requestRemainStall-> onSuccess! responseString = " + str);
            }
            e.o.d(str);
        }
    }

    /* loaded from: classes8.dex */
    public static final class g extends com.baidu.navisdk.util.http.center.f {
        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, @oOoXoXO String str, @oOoXoXO Throwable th) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestServiceAreaZoneInfo->onFailure ,statusCode + ");
                sb.append(i);
                sb.append("responseString=");
                sb.append(str);
                sb.append(",");
                sb.append(th != null ? th.toString() : null);
                gVar.e("RGArriveApproachParkController", sb.toString());
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, @oOoXoXO String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "requestServiceAreaZoneInfo-> onSuccess! responseString = " + str);
            }
            e.o.e(str);
        }
    }

    @oOoXoXO
    public final String b() {
        return f8536a;
    }

    public final void b(boolean z) {
        c = z;
    }

    public final void b(@oOoXoXO RoutePlanNode routePlanNode) {
        e = routePlanNode;
    }

    /* loaded from: classes8.dex */
    public static final class d extends com.baidu.navisdk.util.http.center.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RoutePlanNode f8537a;

        public d(RoutePlanNode routePlanNode) {
            this.f8537a = routePlanNode;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, @oOoXoXO String str, @oOoXoXO Throwable th) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "requestIndoorParkInfo->onFailure ,statusCode + " + i + "responseString=" + str + "," + th);
            }
            LogUtil.out("RGArriveApproachParkController", "requestIndoorParkInfo->onFailure ,statusCode + " + i + "responseString=" + str + "," + th);
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, @oOoXoXO String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "requestIndoorParkInfo-> onSuccess! responseString = " + str);
            }
            LogUtil.out("RGArriveApproachParkController", "requestIndoorParkInfo-> onSuccess! responseString = " + str);
            e.o.a(str, false, this.f8537a, false);
        }
    }

    public final void a(@oOoXoXO String str) {
        f8536a = str;
    }

    public final void b(@oOoXoXO String str) {
        i = str;
    }

    public final void a(boolean z) {
        d = z;
    }

    public final void b(int i2, int i3) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "onArriveApproachNodeNear--> index = " + i2 + ", arriveNodeType = " + i3);
        }
        f = null;
        b(0);
        Bundle bundle = new Bundle();
        if (JNIGuidanceControl.getInstance().GetViaPoint(i2, bundle)) {
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "onArriveApproachNodeNear: index --> " + i2 + ", bundle: " + bundle);
            }
            double d2 = 100000;
            GeoPoint geoPoint = new GeoPoint((int) (bundle.getDouble("x") * d2), (int) (bundle.getDouble("y") * d2));
            com.baidu.navisdk.module.nearbysearch.model.b bVar = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE;
            if (bVar.c(geoPoint)) {
                com.baidu.navisdk.module.nearbysearch.model.a b2 = bVar.b(geoPoint);
                if (b2 != null) {
                    b2.setPoiType(i3);
                    int parkType = b2.getParkType();
                    String uid = b2.getUID();
                    if (gVar.d()) {
                        gVar.e("RGArriveApproachParkController", "onArriveOutdoorDestNear-> IndoorParkType=" + parkType + ", uid=" + uid);
                    }
                    c = false;
                    d(b2);
                    return;
                }
                return;
            }
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "onArriveApproachNodeNear: isViaNode --> false");
            }
            RoutePlanNode c2 = c(i2, i3);
            if (c2 != null) {
                if (gVar.d()) {
                    gVar.e("RGArriveApproachParkController", "onArriveApproachNodeNear-> uid=" + c2.getUID());
                }
                c = true;
                d(c2);
                return;
            }
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "onArriveApproachNodeNear: isEndNode --> false");
                return;
            }
            return;
        }
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "handleArriveViaReminderMsg: Error --> GetViaPoint returns false");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.getInt("errno") != 0 || (jSONObject = jSONObject2.getJSONObject("data")) == null) {
                return;
            }
            jSONObject.getString("text");
            jSONObject.getString("tts");
            String string = jSONObject.getString("park_uid");
            List<com.baidu.navisdk.module.pronavi.model.e> a2 = com.baidu.navisdk.module.pronavi.model.e.a(jSONObject.getJSONArray("regions"));
            IIX0o.oO(a2, "BNServiceAreaZoneTypeBea…eJsonArrData(zoneJsonArr)");
            w0 w0Var = new w0();
            com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V, "BNavigator.getInstance()");
            com.baidu.navisdk.ui.routeguide.navicenter.a i2 = V.i();
            IIX0o.oO(i2, "BNavigator.getInstance().modelManager");
            com.baidu.navisdk.module.pronavi.model.d a3 = i2.c().a(string);
            if (a3 == null || a2 == null || a2.isEmpty()) {
                return;
            }
            String h2 = a3.h();
            IIX0o.oO(h2, "serviceAreaInfo.name");
            a(h2, a2);
            w0Var.a(a3, a2);
            com.baidu.navisdk.ui.routeguide.control.i.g().a(w0Var);
        } catch (Exception e2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.c()) {
                e2.printStackTrace();
                gVar.c("RGArriveApproachParkController", "handleServiceAreaZoneInfoResponse-> exception! e = " + e2);
            }
        }
    }

    public final void a(@oOoXoXO RoutePlanNode routePlanNode) {
        h = routePlanNode;
    }

    public final void a(int i2, int i3) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "onApproachServiceAreaNodeNear--> index = " + i2 + ", arriveNodeType = " + i3);
        }
        f8536a = null;
        Bundle bundle = new Bundle();
        if (JNIGuidanceControl.getInstance().GetViaPoint(i2, bundle)) {
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "onApproachServiceAreaNodeNear: index --> " + i2 + ", bundle: " + bundle);
            }
            double d2 = 100000;
            int i4 = (int) (bundle.getDouble("x") * d2);
            int i5 = (int) (bundle.getDouble("y") * d2);
            GeoPoint geoPoint = new GeoPoint(i4, i5);
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "onApproachServiceAreaNodeNear: x --> " + i4 + ", y: " + i5);
            }
            com.baidu.navisdk.module.nearbysearch.model.b bVar = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE;
            if (bVar.c(geoPoint)) {
                com.baidu.navisdk.module.nearbysearch.model.a b2 = bVar.b(geoPoint);
                if (b2 != null) {
                    b2.setPoiType(i3);
                    int parkType = b2.getParkType();
                    String uid = b2.getUID();
                    if (gVar.d()) {
                        gVar.e("RGArriveApproachParkController", "onApproachServiceAreaNodeNear 2km-> parkType=" + parkType + ", uid=" + uid);
                    }
                    f(b2);
                    return;
                }
                return;
            }
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "onApproachServiceAreaNodeNear: isViaNode --> false");
            }
            RoutePlanNode c2 = c(i2, i3);
            if (c2 != null) {
                if (gVar.d()) {
                    gVar.e("RGArriveApproachParkController", "onApproachServiceAreaNodeNear-> uid=" + c2 + ".uid");
                }
                f(c2);
                return;
            }
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "onApproachServiceAreaNodeNear: isEndNode --> false");
                return;
            }
            return;
        }
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "handleArriveVia2kmReminderMsg: Error --> GetViaPoint returns false");
        }
    }

    /* loaded from: classes8.dex */
    public static final class j extends com.baidu.navisdk.asr.i.b {
        final /* synthetic */ List b;

        public j(List list) {
            this.b = list;
        }

        @Override // com.baidu.navisdk.asr.i.b
        public void a(@OOXIXo String intention, int i) {
            IIX0o.x0xO0oo(intention, "intention");
            super.a(intention, i);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "BNAsrSelectListener select index == " + i);
            }
            if (i < 0 || i >= this.b.size()) {
                return;
            }
            e eVar = e.o;
            eVar.a(((com.baidu.navisdk.module.pronavi.model.e) this.b.get(i)).a());
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "selected indoorpark_ext == " + eVar.b());
            }
            com.baidu.navisdk.asr.d.B().a(com.baidu.navisdk.module.asr.instructions.b.b("好的，将为您导航到" + ((com.baidu.navisdk.module.pronavi.model.e) this.b.get(i)).b() + "附近的停车位置"));
            com.baidu.navisdk.ui.routeguide.control.i.g().b(1011);
        }

        @Override // com.baidu.navisdk.asr.i.b
        public void c() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "BNAsrSelectListener stop");
            }
        }

        @Override // com.baidu.navisdk.asr.i.b
        public void a() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "BNAsrSelectListener cancel");
            }
            com.baidu.navisdk.ui.routeguide.control.i.g().b(1011);
            com.baidu.navisdk.asr.d.B().c();
        }
    }

    public final void f() {
        e = null;
        BNRoutePlaner.getInstance().a(m, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.getInt("errno") != 0 || (jSONObject = jSONObject2.getJSONObject("data")) == null) {
                return;
            }
            com.baidu.navisdk.ui.routeguide.model.v vVar = new com.baidu.navisdk.ui.routeguide.model.v();
            vVar.a(jSONObject);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "handleRemainStallResponse-> RemainStall = " + vVar);
            }
            TTSPlayerControl.playTTS("已为您查询，终点空车位剩余" + vVar.c() + (char) 20010, 1);
            if (vVar.a() != null) {
                List<v.a> a2 = vVar.a();
                IIX0o.ooOOo0oXI(a2);
                if (a2.isEmpty()) {
                    return;
                }
                m0 m0Var = new m0();
                m0Var.a(vVar);
                com.baidu.navisdk.ui.routeguide.control.i.g().a(m0Var);
            }
        } catch (Exception e2) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.c()) {
                e2.printStackTrace();
                gVar2.c("RGArriveApproachParkController", "handleRemainStallResponse-> exception! e = " + e2);
            }
        }
    }

    private final void f(String str) {
        HashMap<String, String> a2 = com.baidu.navisdk.util.http.a.a();
        IIX0o.oO(a2, "HttpParamManager.getCommonParams()");
        Bundle bundle = new Bundle();
        BNRoutePlaner.getInstance().c(bundle);
        String string = bundle.getString("session");
        if (!TextUtils.isEmpty(string)) {
            IIX0o.ooOOo0oXI(string);
            a2.put("sessionid", string);
        }
        a2.put("uid", str);
        String e2 = com.baidu.navisdk.framework.b.e();
        if (!TextUtils.isEmpty(e2)) {
            IIX0o.ooOOo0oXI(e2);
            a2.put("bduss", e2);
        }
        String b2 = com.baidu.navisdk.util.http.b.d().b("NavigationEpilogueParkingInfo");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "requestRemainStall->url:" + b2);
        }
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "requestRemainStall->params:" + a2);
        }
        com.baidu.navisdk.util.http.center.b.a().a(b2, a2, new f(), null);
    }

    public final void c(@oOoXoXO RoutePlanNode routePlanNode) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "startLoopRequestNewStall isLoopStall = " + l);
        }
        h();
        l = true;
        e(routePlanNode);
    }

    private final boolean c(String str) {
        JSONArray jSONArray;
        SmartSpaceAuth smartSpaceAuth = SmartSpaceAuth.getInstance();
        IIX0o.oO(smartSpaceAuth, "SmartSpaceAuth.getInstance()");
        String smartSpaceAuth2 = smartSpaceAuth.getSmartSpaceAuth();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("containsInSmartSpaceAuth->");
            sb.append(smartSpaceAuth2 != null ? smartSpaceAuth2.toString() : null);
            gVar.e("RGArriveApproachParkController", sb.toString());
        }
        if (smartSpaceAuth2 != null && !TextUtils.isEmpty(smartSpaceAuth2)) {
            try {
                JSONObject jSONObject = new JSONObject(smartSpaceAuth2);
                if (jSONObject.has("auth_poi") && (jSONArray = jSONObject.getJSONArray("auth_poi")) != null && jSONArray.length() > 0) {
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        if (str.equals(jSONArray.getString(i2))) {
                            return true;
                        }
                    }
                }
            } catch (Exception e2) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar2.c()) {
                    e2.printStackTrace();
                    gVar2.c("RGArriveApproachParkController", "containsInSmartSpaceAuth-> exception! e = " + e2);
                }
            }
        }
        return false;
    }

    public final void e() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "onIndoorCrossFloorYaw mCurRoutePlanNode = " + h);
        }
        if (h != null) {
            j = true;
            h();
            a(h, true);
        }
    }

    public final void b(int i2) {
        JNIGuidanceControl.getInstance().setIndoorParkStatus(i2);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "setIndoorParkStatusToEngine-> stallTallType = " + i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, boolean z, RoutePlanNode routePlanNode, boolean z2) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.getInt("errno") != 0 || (jSONObject = jSONObject2.getJSONObject("data")) == null) {
                return;
            }
            a(jSONObject, z, routePlanNode, z2);
        } catch (Exception e2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.c()) {
                e2.printStackTrace();
                gVar.c("RGArriveApproachParkController", "handleParkInfoResponse-> exception! e = " + e2);
            }
        }
    }

    private final void a(String str, List<? extends com.baidu.navisdk.module.pronavi.model.e> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (com.baidu.navisdk.module.pronavi.model.e eVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", eVar.b());
                jSONArray.put(jSONObject);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.c()) {
                gVar.c("RGArriveApproachParkController", "voiceSelectPartition 分区数据转换成json list失败");
            }
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGArriveApproachParkController", "voiceSelectPartition list = " + jSONArray);
        }
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            String b2 = list.get(0).b();
            if (list.size() > 1) {
                b2 = list.get(0).b() + (char) 12289 + list.get(1).b();
            }
            String str2 = "即将到达" + str + "，可点击" + b2 + "等为您开启停车位导航";
            if (!com.baidu.navisdk.asr.f.a()) {
                if (gVar2.d()) {
                    gVar2.e("RGArriveApproachParkController", "voiceSelectPartition BNAsrUtils.isAsrWork() false");
                }
                TTSPlayerControl.playTTS(str2, 1);
                return;
            }
            com.baidu.navisdk.asr.d.B().a(str2, jSONArray, "service_partition", new j(list), false);
            return;
        }
        if (gVar2.c()) {
            gVar2.c("RGArriveApproachParkController", "service name为空");
        }
    }

    private final void a(JSONObject jSONObject, boolean z, RoutePlanNode routePlanNode, boolean z2) throws Exception {
        com.baidu.navisdk.ui.routeguide.model.o oVar = new com.baidu.navisdk.ui.routeguide.model.o();
        int i2 = jSONObject.getInt("type");
        int i3 = jSONObject.has("change") ? jSONObject.getInt("change") : 0;
        oVar.f(i2);
        oVar.b(i3);
        oVar.a(jSONObject);
        i = jSONObject.toString();
        if (i2 == 1) {
            b(1);
        } else if (i2 == 2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "parseStallData-> TYPE_STALL_RECOMMEND，oldStall=" + oVar);
            }
            if (oVar.g() == null) {
                if (gVar.d()) {
                    gVar.e("RGArriveApproachParkController", "parseStallData-> curStall == null!! return");
                    return;
                }
                return;
            }
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "parseStallData-> isLoopRequest = " + z + "，changeStall=" + oVar.e() + ", isIndoorCrossYaw=" + z2);
            }
            if ((z || z2) && oVar.e() == 1) {
                a(z2, routePlanNode, oVar);
            } else if (!z && !z2) {
                if (gVar.d()) {
                    gVar.e("RGArriveApproachParkController", "parseStallData indoorpark_ext = " + f8536a);
                }
                if (TextUtils.isEmpty(f8536a)) {
                    TTSPlayerControl.playTTS("自动为您推荐可用车位", 1);
                }
                a(oVar, 2, routePlanNode);
            }
        }
        if (oVar.e() == 1) {
            h();
            return;
        }
        if (z || z2) {
            if (z) {
                e(routePlanNode);
            } else {
                c(routePlanNode);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [com.baidu.navisdk.ui.routeguide.mapmode.subview.i0, T] */
    private final void a(boolean z, RoutePlanNode routePlanNode, com.baidu.navisdk.ui.routeguide.model.o oVar) {
        if (!s.T().b(137)) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "showNewStallConfirm allowOperableNotificationShow return false!");
                return;
            }
            return;
        }
        String str = z ? "已为您推荐当前楼层车位，确定导航到新车位吗" : "车位已被占用，是否导航至新分配车位";
        if (!TextUtils.isEmpty(oVar.q())) {
            str = oVar.q();
            IIX0o.oO(str, "model.ttsText");
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGArriveApproachParkController", "showNewStallConfirm ttsText = " + str);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? a2 = x.b().k(137).D(100).v(20000).g("确定").f("取消").a("已为您推荐最新车位，是否前往停车？").d(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_service_area)).a(new i(oVar, routePlanNode));
        objectRef.element = a2;
        a2.y();
        if (!com.baidu.navisdk.asr.f.a()) {
            if (gVar2.d()) {
                gVar2.e("RGArriveApproachParkController", "showChangeNewStallNotification BNAsrUtils.isAsrWork() false");
            }
            TTSPlayerControl.playTTS(str, 1);
            return;
        }
        com.baidu.navisdk.asr.d.B().a(str, "change_stall", (com.baidu.navisdk.asr.i.a) new h(oVar, routePlanNode, objectRef), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(com.baidu.navisdk.ui.routeguide.model.o oVar, int i2, RoutePlanNode routePlanNode) {
        o.a g2 = oVar.g();
        IIX0o.oO(g2, "model.curStall");
        if (g2 == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "changeIndoorParkStall-> stall = null!!!");
            }
            return false;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGArriveApproachParkController", "changeIndoorParkStall-> stall = " + g2.toString() + ", entry =" + i2);
        }
        GeoPoint geoPoint = new GeoPoint();
        geoPoint.setLatitudeE6(g2.d());
        geoPoint.setLongitudeE6(g2.c());
        if (!geoPoint.isValid()) {
            if (gVar2.d()) {
                gVar2.e("RGArriveApproachParkController", "changeIndoorParkStall-> !gp.isValid , carGeoPt = " + geoPoint.toString());
            }
            return false;
        }
        if (!c) {
            BNRoutePlaner.getInstance().h(1);
            com.baidu.navisdk.module.nearbysearch.model.a a2 = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.a(routePlanNode);
            com.baidu.navisdk.module.nearbysearch.model.a aVar = new com.baidu.navisdk.module.nearbysearch.model.a();
            if (a2 != null) {
                aVar.setName(g2.a());
                aVar.setGeoPoint(geoPoint);
                aVar.setUID(g2.b());
                aVar.b(IBNRouteResultManager.NearbySearchKeyword.Park);
                if (gVar2.d()) {
                    gVar2.e("RGArriveApproachParkController", "changeIndoorParkStall-> 修改途径点为推荐车位重算路");
                }
                l.l().a(a2, aVar, 0);
                BNRoutePlaner bNRoutePlaner = BNRoutePlaner.getInstance();
                IIX0o.oO(bNRoutePlaner, "BNRoutePlaner.getInstance()");
                g = bNRoutePlaner.v();
                com.baidu.navisdk.vi.b.a(n);
            }
        } else {
            if (gVar2.d()) {
                gVar2.e("RGArriveApproachParkController", "changeIndoorParkStall-> 修改终点为推荐车位重算路");
            }
            com.baidu.navisdk.model.modelfactory.a a3 = com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
            if (a3 != null) {
                com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) a3;
                RoutePlanNode mo81clone = fVar.g() != null ? fVar.g().mo81clone() : null;
                RoutePlanNode routePlanNode2 = new RoutePlanNode(geoPoint, 8, g2.a(), (String) null, g2.b());
                com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().a(oVar);
                routePlanNode2.mNodeType = 0;
                com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
                IIX0o.oO(V, "BNavigator.getInstance()");
                if (V.l().a(routePlanNode2, i2)) {
                    f = mo81clone;
                    oVar.a(mo81clone);
                    BNRoutePlaner bNRoutePlaner2 = BNRoutePlaner.getInstance();
                    IIX0o.oO(bNRoutePlaner2, "BNRoutePlaner.getInstance()");
                    g = bNRoutePlaner2.v();
                    com.baidu.navisdk.vi.b.a(n);
                } else if (gVar2.d()) {
                    gVar2.e("RGArriveApproachParkController", "changeDestByOnline-> false");
                }
                com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().A();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.navisdk.model.modelfactory.RoutePlanModel");
            }
        }
        return false;
    }

    private final HashMap<String, String> a(String str, int i2, int i3) {
        HashMap<String, String> params = com.baidu.navisdk.util.http.a.a();
        IIX0o.oO(params, "params");
        params.put("uid", str);
        params.put(TypedValues.TransitionType.S_FROM, "navi_service");
        if (!TextUtils.isEmpty(f8536a)) {
            b = true;
            params.put("indoorpark_ext", f8536a);
        } else {
            b = false;
        }
        com.baidu.navisdk.util.logic.a j2 = com.baidu.navisdk.util.logic.a.j();
        IIX0o.oO(j2, "BNExtGPSLocationManager.getInstance()");
        com.baidu.navisdk.model.datastruct.g c2 = j2.c();
        if (c2 != null) {
            Bundle b2 = com.baidu.navisdk.util.common.o.b(c2.b, c2.f6926a);
            double d2 = b2.getDouble("MCx_D", XIXIX.OOXIXo.f3760XO);
            double d3 = b2.getDouble("MCy_D", XIXIX.OOXIXo.f3760XO);
            String plainString = new BigDecimal(String.valueOf(d2)).toPlainString();
            String plainString2 = new BigDecimal(String.valueOf(d3)).toPlainString();
            params.put("start_x", plainString);
            params.put("start_y", plainString2);
            if (i3 == 1 && !TextUtils.isEmpty(c2.p)) {
                params.put("start_floor", "" + c2.p);
            }
        }
        com.baidu.navisdk.model.modelfactory.a a2 = com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (a2 != null) {
            RoutePlanNode g2 = ((com.baidu.navisdk.model.modelfactory.f) a2).g();
            if (g2 != null) {
                Bundle c3 = com.baidu.navisdk.util.common.o.c(g2.getLongitudeE6(), g2.getLatitudeE6());
                double d4 = c3.getDouble("MCx_D", XIXIX.OOXIXo.f3760XO);
                double d5 = c3.getDouble("MCy_D", XIXIX.OOXIXo.f3760XO);
                String plainString3 = new BigDecimal(String.valueOf(d4)).toPlainString();
                String plainString4 = new BigDecimal(String.valueOf(d5)).toPlainString();
                params.put("end_x", plainString3);
                params.put("end_y", plainString4);
                if (!TextUtils.isEmpty(g2.mFloorId)) {
                    params.put("end_floor", g2.mFloorId);
                }
                Bundle bundle = new Bundle();
                BNRouteGuider.getInstance().getRouteInfoInUniform(38, bundle);
                Bundle b3 = com.baidu.navisdk.util.common.o.b(bundle.getDouble("x", XIXIX.OOXIXo.f3760XO), bundle.getDouble("y", XIXIX.OOXIXo.f3760XO));
                double d6 = b3.getDouble("MCx_D", XIXIX.OOXIXo.f3760XO);
                double d7 = b3.getDouble("MCy_D", XIXIX.OOXIXo.f3760XO);
                String plainString5 = new BigDecimal(String.valueOf(d6)).toPlainString();
                String plainString6 = new BigDecimal(String.valueOf(d7)).toPlainString();
                params.put("guide_x", plainString5);
                params.put("guide_y", plainString6);
            }
            params.put("req_distanc", "200");
            params.put("req_indoor", "" + i3);
            Bundle bundle2 = new Bundle();
            boolean indoorCrossFloorYawInfo = JNIGuidanceControl.getInstance().getIndoorCrossFloorYawInfo(bundle2);
            if (!indoorCrossFloorYawInfo) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGArriveApproachParkController", "getReqParams->getIndoorCrossFloorYawInfo false");
                }
            }
            if (indoorCrossFloorYawInfo) {
                String string = bundle2.getString("sessionId");
                if (!TextUtils.isEmpty(string)) {
                    params.put("session_id", string);
                }
            }
            if (!com.baidu.navisdk.j.d()) {
                com.baidu.navisdk.framework.interfaces.k k2 = com.baidu.navisdk.framework.interfaces.c.p().k();
                if (k2 != null && !TextUtils.isEmpty(k2.R())) {
                    params.put("cloud_token", k2.R());
                }
                params.put("cloud_sdk_service", "lbs_navsdk_mini");
                params.put(TypedValues.TransitionType.S_FROM, "lbs_navsdk_mini");
            }
            return params;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.navisdk.model.modelfactory.RoutePlanModel");
    }

    private final HashMap<String, String> a(String str, boolean z) {
        HashMap<String, String> params = com.baidu.navisdk.util.http.a.a();
        IIX0o.oO(params, "params");
        params.put("uid", str);
        params.put(TypedValues.TransitionType.S_FROM, "navi_service");
        if (!TextUtils.isEmpty(f8536a)) {
            b = true;
            params.put("indoorpark_ext", f8536a);
        } else {
            b = false;
        }
        com.baidu.navisdk.util.logic.a j2 = com.baidu.navisdk.util.logic.a.j();
        IIX0o.oO(j2, "BNExtGPSLocationManager.getInstance()");
        com.baidu.navisdk.model.datastruct.g c2 = j2.c();
        if (c2 != null) {
            Bundle b2 = com.baidu.navisdk.util.common.o.b(c2.b, c2.f6926a);
            double d2 = b2.getDouble("MCx_D", XIXIX.OOXIXo.f3760XO);
            double d3 = b2.getDouble("MCy_D", XIXIX.OOXIXo.f3760XO);
            String plainString = new BigDecimal(String.valueOf(d2)).toPlainString();
            String plainString2 = new BigDecimal(String.valueOf(d3)).toPlainString();
            params.put("point_x", plainString);
            params.put("point_y", plainString2);
        }
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getRouteInfoInUniform(38, bundle);
        Bundle b3 = com.baidu.navisdk.util.common.o.b(bundle.getDouble("x", XIXIX.OOXIXo.f3760XO), bundle.getDouble("y", XIXIX.OOXIXo.f3760XO));
        double d4 = b3.getDouble("MCx_D", XIXIX.OOXIXo.f3760XO);
        double d5 = b3.getDouble("MCy_D", XIXIX.OOXIXo.f3760XO);
        String plainString3 = new BigDecimal(String.valueOf(d4)).toPlainString();
        String plainString4 = new BigDecimal(String.valueOf(d5)).toPlainString();
        params.put("guide_x", plainString3);
        params.put("guide_y", plainString4);
        Bundle bundle2 = new Bundle();
        boolean indoorCrossFloorYawInfo = JNIGuidanceControl.getInstance().getIndoorCrossFloorYawInfo(bundle2);
        if (!indoorCrossFloorYawInfo) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "getParkingRecommendReqParams->getIndoorCrossFloorYawInfo false");
            }
        }
        if (indoorCrossFloorYawInfo) {
            String string = bundle2.getString("mrsl");
            if (!TextUtils.isEmpty(string)) {
                params.put("mrsl", string);
            }
            String string2 = bundle2.getString("routeMd5");
            if (!TextUtils.isEmpty(string2)) {
                params.put("route_md5sum", string2);
            }
            String string3 = bundle2.getString("floor");
            if (!TextUtils.isEmpty(string3)) {
                params.put("floor", string3);
            }
            String string4 = bundle2.getString("sessionId");
            if (!TextUtils.isEmpty(string4)) {
                params.put("session_id", string4);
            }
            params.put(LocationConst.HDYawConst.KEY_HD_YAW_LINK_ID, String.valueOf(bundle2.getLong("ullLinkID")));
            params.put("req_indoor", String.valueOf(bundle2.getInt("reqIndoor")));
        }
        params.put("floor_yaw", z ? "1" : "0");
        if (!TextUtils.isEmpty(i)) {
            params.put("recommend_data", i);
        }
        String e2 = com.baidu.navisdk.framework.b.e();
        if (!TextUtils.isEmpty(e2)) {
            params.put("bduss", e2);
        }
        params.put(HttpConstants.SIGN, a(params));
        return params;
    }

    private final String a(HashMap<String, String> hashMap) {
        ArrayList arrayList = new ArrayList();
        for (String str : hashMap.keySet()) {
            IIX0o.ooOOo0oXI(str);
            arrayList.add(str);
        }
        o00.IoOoo(arrayList);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "getSignString->key : " + arrayList.toString());
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(hashMap.get((String) it.next()));
        }
        stringBuffer.append("aispace_carport_second_recomand");
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGArriveApproachParkController", "getSignString->sorted params string:" + stringBuffer);
        }
        return MD5.getMD5String(stringBuffer.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(RoutePlanNode routePlanNode, boolean z) {
        IIX0o.ooOOo0oXI(routePlanNode);
        String uid = routePlanNode.getUID();
        IIX0o.oO(uid, "node!!.uid");
        HashMap<String, String> a2 = a(uid, z);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "requestParkingRecommend->isIndoorCrossYaw:" + z);
        }
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "requestParkingRecommend->params:" + a2);
        }
        String str = com.baidu.navisdk.util.http.b.d().b("IndoorParkReRecommand") + "/parking/api/navi/parkingRecommend";
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "requestParkingRecommend->url:" + str);
        }
        com.baidu.navisdk.util.http.center.b.a().a(str, a2, new C0438e(z, routePlanNode), null);
    }

    public final void a() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "clear data");
        }
        BNRoutePlaner.getInstance().b(m);
        d = true;
        c = false;
        i = null;
        h = null;
        f8536a = null;
        h();
    }

    public final void a(int i2) {
        int i3 = com.baidu.navisdk.module.cloudconfig.f.c().c.p0;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveApproachParkController", "onRemainTimeUpdate->remainTime:" + i2 + ", mShowRemainStallPanel:" + d + ", remainStallCardAutoHideTime:" + i3);
        }
        if (!g()) {
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "onRemainTimeUpdate->canShowRemainStallCard() return false");
                return;
            }
            return;
        }
        if (!d || i2 > i3) {
            return;
        }
        d = false;
        com.baidu.navisdk.model.modelfactory.a a2 = com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (a2 != null) {
            RoutePlanNode g2 = ((com.baidu.navisdk.model.modelfactory.f) a2).g();
            boolean e0 = com.baidu.navisdk.framework.b.e0();
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("onRemainTimeUpdate->endNode.uid:");
                sb.append(g2 != null ? g2.getUID() : null);
                sb.append(", userIsLogin:");
                sb.append(e0);
                gVar.e("RGArriveApproachParkController", sb.toString());
            }
            if (g2 == null || TextUtils.isEmpty(g2.getUID()) || !e0) {
                return;
            }
            String uid = g2.getUID();
            IIX0o.oO(uid, "endNode.uid");
            boolean c2 = c(uid);
            if (gVar.d()) {
                gVar.e("RGArriveApproachParkController", "onRemainTimeUpdate containsInSmartSpaceAuth->" + c2);
            }
            if (c2) {
                String uid2 = g2.getUID();
                IIX0o.oO(uid2, "endNode.uid");
                f(uid2);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.navisdk.model.modelfactory.RoutePlanModel");
    }
}
