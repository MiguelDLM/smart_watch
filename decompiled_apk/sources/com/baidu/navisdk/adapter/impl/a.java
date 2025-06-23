package com.baidu.navisdk.adapter.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.navisdk.adapter.IBNCruiserManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.logic.j;
import com.baidu.nplatform.comjni.map.basemap.LocationCallback;

/* loaded from: classes7.dex */
public class a implements IBNCruiserManager {
    private static volatile a j;

    /* renamed from: a, reason: collision with root package name */
    private Context f6485a;
    private IBNCruiserManager.ICruiserListener b;
    com.baidu.navisdk.cruise.control.a g;
    private com.baidu.navisdk.util.statistic.d h;
    private boolean c = false;
    private boolean d = false;
    private boolean e = true;
    private boolean f = true;
    private final com.baidu.navisdk.comapi.geolocate.b i = new C0156a();

    /* renamed from: com.baidu.navisdk.adapter.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0156a implements com.baidu.navisdk.comapi.geolocate.b {

        /* renamed from: com.baidu.navisdk.adapter.impl.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0157a extends com.baidu.navisdk.util.worker.f<String, String> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f6487a;
            final /* synthetic */ boolean b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0157a(String str, String str2, boolean z, boolean z2) {
                super(str, str2);
                this.f6487a = z;
                this.b = z2;
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                if (!this.f6487a) {
                    if (a.this.e && a.this.f && a.this.h != null) {
                        a.this.h.n++;
                    }
                    a.this.e = false;
                    a.this.f = false;
                    return null;
                }
                a.this.e = true;
                a.this.f = this.b;
                if (a.this.f || a.this.h == null) {
                    return null;
                }
                a.this.h.n++;
                return null;
            }
        }

        public C0156a() {
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onGpsStatusChange(boolean z, boolean z2) {
            LogUtil.out("BNCruiserManager", "onGpsStatusChange: enabled " + z + ", available " + z2);
            com.baidu.navisdk.util.worker.h a2 = com.baidu.navisdk.util.worker.c.a();
            StringBuilder sb = new StringBuilder();
            sb.append("startRouteCruise-");
            sb.append(C0156a.class.getSimpleName());
            a2.a((com.baidu.navisdk.util.worker.f) new C0157a(sb.toString(), null, z, z2), new com.baidu.navisdk.util.worker.e(8, 0));
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onLocationChange(com.baidu.navisdk.model.datastruct.g gVar) {
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onWGS84LocationChange(com.baidu.navisdk.model.datastruct.g gVar, com.baidu.navisdk.model.datastruct.g gVar2) {
            a.this.e();
            a.this.a(gVar, gVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.d) {
            return;
        }
        LogUtil.out("BNCruiserManager", "startRouteCruise");
        this.d = true;
        BNRouteGuider.getInstance().startRouteCruise();
        com.baidu.navisdk.cruise.control.a aVar = this.g;
        if (aVar != null) {
            aVar.a(true);
            this.g.b();
        }
        com.baidu.navisdk.util.statistic.d dVar = this.h;
        if (dVar != null) {
            dVar.l = SystemClock.elapsedRealtime();
        }
        IBNCruiserManager.ICruiserListener iCruiserListener = this.b;
        if (iCruiserListener != null) {
            iCruiserListener.onCruiserStart();
            this.b = null;
        }
    }

    private void f() {
        com.baidu.navisdk.util.statistic.d dVar = this.h;
        if (dVar != null) {
            dVar.m = BNRouteGuider.getInstance().getCurrentRouteDrvieDistance();
            this.h.b(0);
        }
        if (this.c) {
            BNRouteGuider.getInstance().stopRouteCruise();
            d.b().a(false);
            this.c = false;
            this.d = false;
            com.baidu.navisdk.cruise.control.a aVar = this.g;
            if (aVar != null) {
                aVar.a(false);
            }
        }
        com.baidu.navisdk.cruise.control.a aVar2 = this.g;
        if (aVar2 != null) {
            aVar2.d();
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNCruiserManager
    public boolean isCruiserStarted() {
        return this.c;
    }

    @Override // com.baidu.navisdk.adapter.IBNCruiserManager
    public void startCruiser(Context context, IBNCruiserManager.ICruiserListener iCruiserListener) {
        LogUtil.out("BNCruiserManager", "startCruiser");
        if (this.c) {
            return;
        }
        this.f6485a = context;
        this.c = true;
        d.b().a(true);
        this.b = iCruiserListener;
        com.baidu.navisdk.cruise.control.a aVar = new com.baidu.navisdk.cruise.control.a(this.f6485a);
        this.g = aVar;
        aVar.c();
        com.baidu.navisdk.util.statistic.d n = com.baidu.navisdk.util.statistic.d.n();
        this.h = n;
        n.k = SystemClock.elapsedRealtime();
        b();
        c();
    }

    @Override // com.baidu.navisdk.adapter.IBNCruiserManager
    public void stopCruise() {
        LogUtil.out("ImportantCruiseBug", "quitCruise map onResume");
        this.b = null;
        f();
        j.r().b(this.i);
        j.r().i();
        d();
    }

    private void c() {
        j.r().a(this.f6485a);
        j.r().a(this.i);
    }

    private void d() {
        BNRouteGuider.getInstance().setVoiceMode(BNSettingManager.getVoiceMode());
        BNRouteGuider.getInstance().SetOtherCameraSpeak(BNSettingManager.isElecCameraSpeakEnable());
        BNRouteGuider.getInstance().SetOverspeedSpeak(BNSettingManager.isSpeedCameraSpeakEnable());
        BNRouteGuider.getInstance().SetStraightSpeak(BNSettingManager.isStraightDirectSpeakEnable());
    }

    public static a a() {
        if (j == null) {
            synchronized (a.class) {
                try {
                    if (j == null) {
                        j = new a();
                    }
                } finally {
                }
            }
        }
        return j;
    }

    private void b() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("closeElectronEye", !com.baidu.navisdk.cruise.prefer.a.g().c());
        bundle.putBoolean("closeSafetyNote", !com.baidu.navisdk.cruise.prefer.a.g().e());
        bundle.putBoolean("closePlayRouteTraffic", !com.baidu.navisdk.cruise.prefer.a.g().d());
        BNRouteGuider.getInstance().SetCruiseSetting(bundle);
        com.baidu.navisdk.module.pronavi.a.j = 1;
        BNRouteGuider.getInstance().setLocateMode(1);
        com.baidu.navisdk.model.datastruct.g f = com.baidu.navisdk.model.a.g().f();
        if (f != null) {
            com.baidu.navisdk.model.datastruct.g m84clone = f.m84clone();
            m84clone.c = 0.0f;
            m84clone.g = 0;
            a((com.baidu.navisdk.model.datastruct.g) null, m84clone);
        }
    }

    public void a(com.baidu.navisdk.model.datastruct.g gVar, com.baidu.navisdk.model.datastruct.g gVar2) {
        if (gVar2 == null || !gVar2.b() || gVar == null || !gVar.b()) {
            return;
        }
        LogUtil.out("BNCruiserManager", "updateLocation");
        LocationCallback.setData(gVar2.a(com.baidu.navisdk.model.b.b().a() == 2));
        BNRouteGuider.getInstance().triggerGPSDataChange((int) (gVar.b * 100000.0d), (int) (gVar.f6926a * 100000.0d), gVar.c, gVar.e, gVar.f, (float) gVar.h, gVar.g, gVar.k, gVar.j, 1, gVar.o, gVar.a());
        BNRouteGuider.getInstance().triggerStartLocationData((int) (gVar.b * 100000.0d), (int) (gVar.f6926a * 100000.0d), (float) gVar.h, gVar.c, gVar.e, gVar.f, gVar.d, gVar.k, 0, gVar.j);
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getVehicleInfo(bundle);
        float f = (float) bundle.getDouble("vehicle_angle");
        int i = (int) (gVar2.c * 3.6f);
        if (LogUtil.LOGGABLE) {
            LogUtil.out("BNCruiserManager", "updateLocation: speed " + i + ", angle " + f + ", " + gVar2);
        }
    }
}
