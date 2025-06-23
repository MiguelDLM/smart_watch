package com.baidu.navisdk.pronavi.logic.service.parkrec;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import com.baidu.entity.pb.DestDrivingRecInfo;
import com.baidu.entity.pb.InetlligentDestDrivingResponse;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.framework.interfaces.t;
import com.baidu.navisdk.jni.nativeif.JNIIdssControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.destrec.c;
import com.baidu.navisdk.pronavi.data.model.f;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.util.common.g;
import com.baidu.platform.comjni.tools.ProtobufUtils;
import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.MessageMicro;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.pronavi.logic.base.a f7790a;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new a(null);
    }

    public b(@OOXIXo com.baidu.navisdk.pronavi.logic.base.a context, @OOXIXo f model) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(model, "model");
        this.f7790a = context;
    }

    @oOoXoXO
    public final c a(@oOoXoXO byte[] bArr) {
        ByteStringMicro destRecInfo;
        byte[] byteArray;
        DestDrivingRecInfo destDrivingRecInfo = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        MessageMicro messageLite = ProtobufUtils.getMessageLite(InetlligentDestDrivingResponse.class.getSimpleName(), bArr);
        InetlligentDestDrivingResponse inetlligentDestDrivingResponse = messageLite instanceof InetlligentDestDrivingResponse ? (InetlligentDestDrivingResponse) messageLite : null;
        if (inetlligentDestDrivingResponse != null && (destRecInfo = inetlligentDestDrivingResponse.getDestRecInfo()) != null && (byteArray = destRecInfo.toByteArray()) != null) {
            MessageMicro messageLite2 = ProtobufUtils.getMessageLite(DestDrivingRecInfo.class.getSimpleName(), byteArray);
            if (messageLite2 instanceof DestDrivingRecInfo) {
                destDrivingRecInfo = (DestDrivingRecInfo) messageLite2;
            }
        }
        return c.f.a(destDrivingRecInfo);
    }

    public final void a() {
        Bundle bundle = new Bundle();
        RoutePlanNode k = this.f7790a.k();
        if (k != null) {
            double d = 100000;
            bundle.putDouble("end_ptx", k.getLongitudeE6() / d);
            bundle.putDouble("end_pty", k.getLatitudeE6() / d);
            String uid = k.getUID();
            if (uid != null && uid.length() != 0) {
                bundle.putString("end_uid", k.getUID());
            }
        }
        com.baidu.navisdk.util.logic.a j = com.baidu.navisdk.util.logic.a.j();
        IIX0o.oO(j, "BNExtGPSLocationManager.getInstance()");
        if (j.b() != null) {
            double d2 = 100000;
            bundle.putDouble("cur_ptx", r1.getLongitudeE6() / d2);
            bundle.putDouble("cur_pty", r1.getLatitudeE6() / d2);
        }
        l l = l.l();
        IIX0o.oO(l, "RGEngineControl.getInstance()");
        RoutePlanNode f = l.f();
        String uid2 = f != null ? f.getUID() : null;
        if (uid2 != null && uid2.length() != 0) {
            bundle.putString("first_uid", uid2);
        }
        com.baidu.navisdk.model.modelfactory.a a2 = com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (a2 != null) {
            RoutePlanNode g = ((com.baidu.navisdk.model.modelfactory.f) a2).g();
            String uid3 = g != null ? g.getUID() : null;
            l l2 = l.l();
            IIX0o.oO(l2, "RGEngineControl.getInstance()");
            if (l2.h() == 2) {
                l l3 = l.l();
                IIX0o.oO(l3, "RGEngineControl.getInstance()");
                String e = l3.e();
                if (e != null && e.length() != 0) {
                    l l4 = l.l();
                    IIX0o.oO(l4, "RGEngineControl.getInstance()");
                    uid3 = l4.e();
                }
            }
            if (uid3 != null && uid3.length() != 0) {
                bundle.putString("route_uid", uid3);
            }
            BNRoutePlaner bNRoutePlaner = BNRoutePlaner.getInstance();
            IIX0o.oO(bNRoutePlaner, "BNRoutePlaner.getInstance()");
            String x = bNRoutePlaner.x();
            l l5 = l.l();
            IIX0o.oO(l5, "RGEngineControl.getInstance()");
            if (l5.h() == 2) {
                l l6 = l.l();
                IIX0o.oO(l6, "RGEngineControl.getInstance()");
                String g2 = l6.g();
                if (g2 != null && g2.length() != 0) {
                    l l7 = l.l();
                    IIX0o.oO(l7, "RGEngineControl.getInstance()");
                    x = l7.g();
                }
            }
            if (x != null && x.length() != 0) {
                bundle.putString("session_id", x);
            }
            bundle.putBoolean("parking_guide", RouteGuideFSM.getInstance().isTopState(RGFSMTable.FsmState.IndoorPark));
            l l8 = l.l();
            IIX0o.oO(l8, "RGEngineControl.getInstance()");
            bundle.putBoolean("second_rec", l8.h() == 2);
            String e2 = com.baidu.navisdk.framework.b.e();
            if (e2 != null) {
                bundle.putString("bduss", e2);
            }
            t i = com.baidu.navisdk.module.vehiclemanager.b.i();
            IIX0o.oO(i, "BNVehicleManager.getInstance()");
            bundle.putInt("trip_mode", i.b());
            BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
            IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
            bundle.putBoolean("novice_mode", bNCommSettingManager.isNoviceMode());
            g gVar = g.B4NAV;
            if (gVar.d()) {
                gVar.e("RGParkRecRepository", "requestIdss --> extraParams = " + bundle);
            }
            JNIIdssControl.getInstance().request(3, bundle);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.navisdk.model.modelfactory.RoutePlanModel");
    }
}
