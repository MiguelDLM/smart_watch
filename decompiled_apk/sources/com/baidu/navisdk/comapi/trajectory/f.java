package com.baidu.navisdk.comapi.trajectory;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.framework.message.bean.v;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import java.util.ArrayList;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes7.dex */
public class f extends com.baidu.navisdk.comapi.trajectory.a {
    private e h;

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6745a;
        final /* synthetic */ String b;
        final /* synthetic */ j c;
        final /* synthetic */ boolean d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, String str3, String str4, j jVar, boolean z, String str5) {
            super(str, str2);
            this.f6745a = str3;
            this.b = str4;
            this.c = jVar;
            this.d = z;
            this.e = str5;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            try {
                f fVar = f.this;
                String str = this.f6745a;
                if (str == null) {
                    str = "";
                }
                String str2 = this.b;
                if (str2 == null) {
                    str2 = "";
                }
                int a2 = fVar.a(str, str2, this.c, this.d, this.e);
                com.baidu.navisdk.util.statistic.userop.b r = com.baidu.navisdk.util.statistic.userop.b.r();
                r.a("8.2.3", "" + this.c.a(), "" + a2);
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.TRAJECTORY;
                if (gVar.d()) {
                    gVar.e(f.this.b(), "startRecordInner,ret:" + a2);
                }
                com.baidu.navisdk.framework.message.a.a().d(new v(1));
                return null;
            } catch (Throwable th) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.TRAJECTORY;
                if (!gVar2.c()) {
                    return null;
                }
                gVar2.c(f.this.b(), "startRecordInner,e:" + th);
                return null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.comapi.geolocate.a {
        public b() {
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onLocationChange(com.baidu.navisdk.model.datastruct.g gVar) {
            boolean z;
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.TRAJECTORY;
            if (gVar2.b()) {
                gVar2.b(f.this.b(), "navi-onLocationChange: " + gVar);
            }
            if (gVar != null) {
                long j = gVar.j;
                if (f.this.h != null) {
                    z = f.this.h.a(gVar);
                } else {
                    z = true;
                }
                if (!z) {
                    j = System.currentTimeMillis();
                }
                f.this.a(gVar.b, gVar.f6926a, gVar.c, gVar.e, gVar.f, j, gVar.k, gVar.o, gVar.a());
            }
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onWGS84LocationChange(com.baidu.navisdk.model.datastruct.g gVar, com.baidu.navisdk.model.datastruct.g gVar2) {
        }
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "{" + str + ooOOo0oXI.f33074oOoXoXO;
    }

    private void f() {
        ArrayList<NaviTrajectoryGPSData> b2 = b(a());
        int b3 = com.baidu.navisdk.module.vehiclemanager.b.i().b();
        if (b2 != null && com.baidu.navisdk.naviresult.c.a(b3, b2.size())) {
            a(com.baidu.navisdk.naviresult.c.a(a(), b3, 3));
        }
    }

    @Override // com.baidu.navisdk.comapi.trajectory.a
    public String b() {
        return "BNTrajectoryRecordInNaviLogicController";
    }

    public int e() {
        return this.f6741a;
    }

    private int b(String str, j jVar) {
        String str2;
        String str3;
        int i;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.TRAJECTORY;
        if (gVar.d()) {
            gVar.e(b(), "endRecord: --> endPointName: " + str + "\n, endType: " + jVar + "\nmIsStartRecord = " + this.g + "\n,mIsMonkey:" + this.e + "\n,mIsNeedRecordTrack:" + this.d);
        }
        if (this.f) {
            return -10;
        }
        if (!this.d) {
            return -11;
        }
        if (this.e) {
            return -12;
        }
        if (!this.g) {
            return -13;
        }
        this.g = false;
        if (this.b != null) {
            com.baidu.navisdk.util.logic.c.k().b(this.b);
            this.b = null;
        }
        com.baidu.navisdk.model.modelfactory.f h = BNRoutePlaner.getInstance().h();
        RoutePlanNode g = h != null ? h.g() : null;
        if (BNRoutePlaner.getInstance().d() == 20) {
            str2 = "1";
        } else if (BNRoutePlaner.getInstance().d() == 21) {
            str2 = "2";
        } else {
            str2 = (g == null || (str3 = g.mUID) == null || str3.length() <= 0) ? "" : g.mUID;
        }
        Bundle bundle = new Bundle();
        try {
            i = JNITrajectoryControl.sInstance.endRecord(str, str2, com.baidu.navisdk.module.pronavi.model.h.c, bundle);
        } catch (Throwable th) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.TRAJECTORY;
            if (gVar2.d()) {
                gVar2.e(b(), "endRecord,e:" + th);
            }
            i = -100;
        }
        com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.TRAJECTORY;
        if (gVar3.d()) {
            gVar3.e(b(), "endRecord,engine-ret:" + i);
        }
        if (bundle.containsKey("trajectory_requestid")) {
            bundle.getInt("trajectory_requestid");
        }
        try {
            JNITrajectoryControl.sInstance.updateEndName(a(), str);
        } catch (Throwable unused) {
        }
        if (!c() && i == 0) {
            com.baidu.navisdk.framework.b.c0();
            f();
        }
        com.baidu.navisdk.framework.message.a.a().d(new v(2));
        return i;
    }

    public int a(String str, String str2, j jVar, boolean z) {
        return a(str, str2, jVar, z, true, (String) null);
    }

    public int a(String str, String str2, j jVar, boolean z, boolean z2, String str3) {
        String c = c(str3);
        this.d = z2;
        this.e = d();
        this.f = c();
        this.f6741a = -1;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.TRAJECTORY;
        if (gVar.d()) {
            gVar.e(b(), "startRecord-->userId:" + str + "\n,startPointName:" + str2 + "\n,trajectoryType:" + jVar + "\n,selfRegisterLocation:" + z + "\n,mIsNeedRecordTrack:" + this.d + "\n,mIsAnalogNavi:" + this.f + "\n,mIsMonkey):" + this.e);
        }
        com.baidu.navisdk.util.worker.c.a().c(new a("startRecord-in-navi", null, str, str2, jVar, z, c), new com.baidu.navisdk.util.worker.e(200, 0));
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, String str2, j jVar, boolean z, String str3) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.TRAJECTORY;
        if (gVar.d()) {
            gVar.e(b(), "startRecordInner-->userId:" + str + "\n,startPointName:" + str2 + "\n,fromType:" + jVar + "\n,extraJson:" + str3 + "\n,selfRegisterLocation:" + z + "\n,mIsMonkey:" + this.e + "\n,mIsStartRecord:" + this.g + "\n,mIsNeedRecordTrack:" + this.d);
        }
        if (this.f) {
            return -10;
        }
        if (!this.d) {
            return -11;
        }
        if (this.e) {
            return -12;
        }
        if (this.g) {
            return -13;
        }
        this.g = true;
        int startRecord = JNITrajectoryControl.sInstance.startRecord(str, str2, jVar.a(), com.baidu.navisdk.framework.b.Q(), str3);
        this.h = new e(jVar.a());
        if (z) {
            if (this.b == null) {
                this.b = new b();
            }
            com.baidu.navisdk.util.logic.c.k().a(this.b);
        }
        if (gVar.d()) {
            gVar.e(b(), "startRecordInner,engine-ret:" + startRecord);
        }
        return startRecord;
    }

    public int a(String str, j jVar) {
        int b2 = b(str, jVar);
        com.baidu.navisdk.util.statistic.userop.b.r().a("8.2.4", "" + jVar.a(), "" + b2);
        this.f6741a = b2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.TRAJECTORY;
        if (gVar.d()) {
            gVar.e(b(), "endRecord,ret:" + b2 + ",trajectoryType:" + jVar);
        }
        e eVar = this.h;
        if (eVar != null) {
            eVar.a();
        }
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(double d, double d2, float f, float f2, float f3, long j, int i, int i2, String str) {
        if (!this.d || this.e || this.f) {
            return 0;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.TRAJECTORY;
        if (gVar.b()) {
            gVar.b(b(), "recording,longitude:" + d + "\n,latitude:" + d2 + "\n,speed:" + f + "\n,bearing:" + f2 + "\n,accuracy:" + f3 + "\n,time:" + j + "\n,locType:" + i + "\n,gpsType:" + i2 + ",jsonData:" + str);
        }
        return JNITrajectoryControl.sInstance.recording(d, d2, f, f2, f3, j, i, i2, str);
    }
}
