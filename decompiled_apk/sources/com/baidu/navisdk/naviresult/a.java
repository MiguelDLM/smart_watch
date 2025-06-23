package com.baidu.navisdk.naviresult;

import XIXIX.OOXIXo;
import android.os.Message;
import com.baidu.navisdk.comapi.trajectory.i;
import com.baidu.navisdk.comapi.trajectory.j;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.f;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l0;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.naviresult.b f7622a;
    private boolean b;
    private boolean c;
    private boolean d;

    /* renamed from: com.baidu.navisdk.naviresult.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class HandlerC0303a extends com.baidu.navisdk.util.worker.loop.b {
        public HandlerC0303a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(4107);
            observe(4116);
            observe(4153);
        }

        @Override // com.baidu.navisdk.util.worker.loop.b
        public void onMessage(Message message) {
            g gVar = g.TRAJECTORY;
            if (gVar.d()) {
                gVar.e("BNNaviResultController", "handleMessage,msg.what:" + message.what + ",msg.arg1:" + message.arg1 + ",msg.arg2:" + message.arg2 + ",msg.obj:" + message.obj);
            }
            int i = message.what;
            if (i != 4107) {
                if (i != 4116) {
                    if (i == 4153) {
                        a.this.b = true;
                        return;
                    }
                    return;
                } else {
                    if (message.arg1 == 1) {
                        a.this.b = true;
                        return;
                    }
                    return;
                }
            }
            if (a.this.b && !a.this.c) {
                a.this.c = true;
                a.this.f7622a.a(message.arg1);
                a.this.f7622a.a(message.arg2 * 1000);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7624a;

        static {
            int[] iArr = new int[j.values().length];
            f7624a = iArr;
            try {
                iArr[j.TRAJECTORY_FROM_COMMUTE_GUIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7624a[j.TRAJECTORY_FROM_EDOG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7624a[j.TRAJECTORY_FROM_EDOG_TRUCK_CHALLENGE_MODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final a f7625a = new a(null);
    }

    public /* synthetic */ a(HandlerC0303a handlerC0303a) {
        this();
    }

    private static boolean a(int i) {
        return i >= 50 && i <= 1000;
    }

    public static a d() {
        return c.f7625a;
    }

    public static int e() {
        com.baidu.navisdk.model.datastruct.g a2 = com.baidu.navisdk.util.logic.g.j().a();
        RoutePlanNode g = ((f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).g();
        RoutePlanNode e = d().f7622a.e();
        g gVar = g.TRAJECTORY;
        if (gVar.d()) {
            gVar.e("BNNaviResultController", "getWalkNaviRemainDist,originalEndNode: " + e);
        }
        if (e != null) {
            g = e;
        }
        if (g == null || g.getLatitudeE6() == Integer.MIN_VALUE || g.getLongitudeE6() == Integer.MIN_VALUE || a2 == null || a2.b == -1.0d || a2.f6926a == -1.0d) {
            return -1;
        }
        int a3 = a(a2, g);
        if (gVar.d()) {
            gVar.e("BNNaviResultController", "getWalkNaviRemainDist,sphereDist: " + a3);
        }
        return a3;
    }

    private a() {
        this.b = false;
        this.c = false;
        this.d = false;
        new HandlerC0303a("NRC");
        this.f7622a = new com.baidu.navisdk.naviresult.b();
    }

    private boolean c() {
        long trajectoryLength = JNITrajectoryControl.sInstance.getTrajectoryLength(JNITrajectoryControl.sInstance.getCurrentUUID());
        int a2 = d().a().a();
        double d = a2 == 0 ? OOXIXo.f3760XO : trajectoryLength / a2;
        g gVar = g.TRAJECTORY;
        if (gVar.d()) {
            gVar.e("BNNaviResultController", "checkPastDistance,curMilea: " + trajectoryLength + ", planedDist: " + a2 + ", percentage: " + d);
        }
        if (trajectoryLength > 10000) {
            if (gVar.d()) {
                gVar.e("BNNaviResultController", "checkPastDistance,true(距离大于10KM)");
            }
            return true;
        }
        if (trajectoryLength <= 200 || d <= 0.1d) {
            return false;
        }
        if (gVar.d()) {
            gVar.e("BNNaviResultController", "checkPastDistance,true(距离大于200m 且超过全程的10%)");
        }
        return true;
    }

    public static boolean b(int i) {
        return a(i) && (com.baidu.navisdk.module.pronavi.a.j != 2);
    }

    public com.baidu.navisdk.naviresult.b a() {
        return this.f7622a;
    }

    private static int a(com.baidu.navisdk.model.datastruct.g gVar, RoutePlanNode routePlanNode) {
        if (gVar == null || routePlanNode == null) {
            return -1;
        }
        return (int) l0.a(gVar.b * 100000.0d, gVar.f6926a * 100000.0d, routePlanNode.getLongitudeE6(), routePlanNode.getLatitudeE6());
    }

    public a b() {
        this.d = false;
        return this;
    }

    private boolean b(j jVar, i iVar) {
        if (com.baidu.navisdk.comapi.trajectory.c.c().a().c()) {
            this.d = false;
        } else {
            int i = b.f7624a[jVar.ordinal()];
            if (i == 1) {
                this.d = a(iVar);
            } else if (i != 2 && i != 3) {
                this.d = b(iVar);
            } else {
                this.d = false;
            }
        }
        return this.d;
    }

    public boolean a(j jVar, i iVar) {
        return b(jVar, iVar);
    }

    private boolean a(i iVar) {
        if (i.END_RECORD_REASON_ARRIVE_DEST == iVar) {
            return true;
        }
        return c();
    }

    private boolean b(i iVar) {
        if (!com.baidu.navisdk.function.b.FUNC_ENTER_NAVI_RESULT_PAGE.a()) {
            g gVar = g.TRAJECTORY;
            if (!gVar.d()) {
                return false;
            }
            gVar.e("BNNaviResultController", "checkShouldEnterNaviResultPage FUNC_ENTER_NAVI_RESULT_PAGE");
            return false;
        }
        if (d().a().j()) {
            g gVar2 = g.TRAJECTORY;
            if (!gVar2.d()) {
                return true;
            }
            gVar2.e("BNNaviResultController", "checkShouldEnterNaviResultPage ret = 1");
            return true;
        }
        return c();
    }
}
