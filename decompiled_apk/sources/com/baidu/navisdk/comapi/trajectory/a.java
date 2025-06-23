package com.baidu.navisdk.comapi.trajectory;

import com.baidu.mapframework.location.LocationChangeListener;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected int f6741a;
    protected com.baidu.navisdk.comapi.geolocate.a b = null;
    protected LocationChangeListener c = null;
    protected boolean d = true;
    protected boolean e = false;
    protected boolean f = false;
    protected boolean g = false;

    public String a() {
        if (this.d) {
            return JNITrajectoryControl.sInstance.getCurrentUUID();
        }
        return null;
    }

    public abstract String b();

    public ArrayList<NaviTrajectoryGPSData> b(String str) {
        if (!this.d) {
            return null;
        }
        ArrayList<NaviTrajectoryGPSData> arrayList = new ArrayList<>();
        JNITrajectoryControl.sInstance.GetTrajectoryGPSListDirect(str, arrayList);
        return arrayList;
    }

    public boolean c() {
        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
            return true;
        }
        return false;
    }

    public boolean d() {
        return BNSettingManager.isMonkey();
    }

    /* renamed from: com.baidu.navisdk.comapi.trajectory.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0185a extends com.baidu.navisdk.util.http.center.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6742a;
        final /* synthetic */ HashMap b;

        public C0185a(String str, HashMap hashMap) {
            this.f6742a = str;
            this.b = hashMap;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.TRAJECTORY;
            if (gVar.d()) {
                String th2 = th != null ? th.toString() : "";
                gVar.c(a.this.b(), "requestUgcFee failed!" + th2);
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            com.baidu.navisdk.util.common.g.TRAJECTORY.e(a.this.b(), "requestUgcFee success! url=" + this.f6742a + ", resp=" + str + ", params=" + this.b);
        }
    }

    public NaviTrajectory a(String str) {
        if (!com.baidu.navisdk.module.init.a.a() || !this.d) {
            return null;
        }
        NaviTrajectory naviTrajectory = new NaviTrajectory();
        JNITrajectoryControl.sInstance.getTrajectoryById(str, naviTrajectory);
        return naviTrajectory;
    }

    public void a(HashMap<String, String> hashMap) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.navisdk.util.http.center.i("qt", "routefee"));
        String a2 = com.baidu.navisdk.util.http.center.c.a(com.baidu.navisdk.util.http.b.d().b("BNTrackChargeKey"), arrayList);
        com.baidu.navisdk.util.http.center.b.a().b(a2, hashMap, new C0185a(a2, hashMap), null);
    }
}
