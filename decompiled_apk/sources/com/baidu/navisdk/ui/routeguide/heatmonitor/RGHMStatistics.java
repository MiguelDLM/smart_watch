package com.baidu.navisdk.ui.routeguide.heatmonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.navisdk.apm.cpu.b;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class RGHMStatistics {

    /* renamed from: a, reason: collision with root package name */
    private final Context f8611a;
    private final f b;
    private float e;
    private float f;
    private long k;
    private List<com.baidu.navisdk.module.cpu.a> o;
    private List<com.baidu.navisdk.module.cpu.a> p;
    private boolean d = false;
    private final SparseArray<Long> g = new SparseArray<>();
    private final SparseArray<Long> h = new SparseArray<>();
    private int i = -1;
    private int j = -1;
    private final JSONObject l = new JSONObject();
    private final com.baidu.navisdk.apm.cpu.b m = new com.baidu.navisdk.apm.cpu.b();
    private final BroadcastReceiver n = new BroadcastReceiver() { // from class: com.baidu.navisdk.ui.routeguide.heatmonitor.RGHMStatistics.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getIntExtra("status", 1) == 2) {
                RGHMStatistics.this.d = true;
            }
            RGHMStatistics rGHMStatistics = RGHMStatistics.this;
            rGHMStatistics.f = rGHMStatistics.a(intent);
        }
    };
    private long q = -1;
    private long r = -1;
    private final com.baidu.navisdk.module.abtest.model.g c = com.baidu.navisdk.module.abtest.model.g.s();

    /* loaded from: classes8.dex */
    public class a implements b.e {
        public a() {
        }

        @Override // com.baidu.navisdk.apm.cpu.b.e
        public void a(List<com.baidu.navisdk.module.cpu.b> list) {
            RGHMStatistics rGHMStatistics = RGHMStatistics.this;
            rGHMStatistics.o = rGHMStatistics.m.c();
            RGHMStatistics rGHMStatistics2 = RGHMStatistics.this;
            rGHMStatistics2.q = rGHMStatistics2.m.a();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements b.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8614a;
        final /* synthetic */ com.baidu.navisdk.apm.cpu.b b;

        public b(int i, com.baidu.navisdk.apm.cpu.b bVar) {
            this.f8614a = i;
            this.b = bVar;
        }

        @Override // com.baidu.navisdk.apm.cpu.b.e
        public void a(List<com.baidu.navisdk.module.cpu.b> list) {
            try {
                String format = String.format("l%dcpu", Integer.valueOf(this.f8614a));
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < 5; i++) {
                    jSONObject.put(list.get(i).a(), r4.b());
                }
                RGHMStatistics.this.l.put(format, jSONObject);
                RGHMStatistics.this.p = this.b.d();
                RGHMStatistics.this.r = this.b.b();
            } catch (JSONException e) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.HEAT_MONITOR;
                if (gVar.c()) {
                    gVar.c("RGHMStatistics", "onData(), e = " + e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends com.baidu.navisdk.util.worker.f<Long, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8615a;
        final /* synthetic */ long b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, Long l, int i, long j) {
            super(str, l);
            this.f8615a = i;
            this.b = j;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            RGHMStatistics.this.c.b(this.f8615a, com.baidu.navisdk.apm.cpu.a.c() - this.b);
            return null;
        }
    }

    public RGHMStatistics(Context context, f fVar) {
        this.f8611a = context;
        this.b = fVar;
    }

    private void d() {
        List<com.baidu.navisdk.module.cpu.b> a2;
        if (this.b.a().e() && (a2 = com.baidu.navisdk.apm.cpu.b.a(this.q, this.r, this.o, this.p)) != null && a2.size() > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < 5; i++) {
                    jSONObject.put(a2.get(i).a(), r3.b());
                }
                this.l.put(IAdInterListener.AdProdType.PRODUCT_CPU, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void e() {
        long elapsedRealtime = (SystemClock.elapsedRealtime() - com.baidu.navisdk.util.statistic.i.f9373a) / 1000;
        float f = this.e - this.f;
        if (!this.d && elapsedRealtime >= 0 && f >= 0.0f) {
            this.c.a((f / ((float) elapsedRealtime)) * 3600.0f);
        }
    }

    private void f() {
        String currentUUID = JNITrajectoryControl.sInstance.getCurrentUUID();
        if (TextUtils.isEmpty(currentUUID)) {
            this.c.a(0L);
        } else {
            this.c.a(JNITrajectoryControl.sInstance.getTrajectoryLength(currentUUID));
        }
    }

    private void g() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.k;
        SparseArray<Long> sparseArray = this.h;
        int i = this.i;
        sparseArray.put(i, Long.valueOf(sparseArray.get(i, 0L).longValue() + elapsedRealtime));
        long longValue = this.h.get(0, 0L).longValue() + this.h.get(1, 0L).longValue() + this.h.get(2, 0L).longValue() + this.h.get(3, 0L).longValue();
        if (longValue != 0) {
            this.c.a(0, (float) ((this.h.get(0, 0L).longValue() * 100) / longValue));
            this.c.a(1, (float) ((this.h.get(1, 0L).longValue() * 100) / longValue));
            this.c.a(2, (float) ((this.h.get(2, 0L).longValue() * 100) / longValue));
            this.c.a(3, (float) ((this.h.get(3, 0L).longValue() * 100) / longValue));
        }
    }

    private void h() {
        this.c.b((SystemClock.elapsedRealtime() - com.baidu.navisdk.util.statistic.i.f9373a) / 1000);
    }

    private void c(int i) {
        com.baidu.navisdk.apm.cpu.b bVar = new com.baidu.navisdk.apm.cpu.b();
        bVar.a(this.b.a().d(), new b(i, bVar));
    }

    private boolean c() {
        f fVar = this.b;
        return (fVar == null || fVar.b() == com.baidu.navisdk.ui.routeguide.heatmonitor.a.CLOUND) ? false : true;
    }

    public void b() {
        if (c()) {
            this.f8611a.unregisterReceiver(this.n);
            f();
            h();
            e();
            this.c.b(this.d);
            g();
            d();
            this.c.b(this.l.toString());
            this.c.d(this.j);
            this.c.b(1);
        }
    }

    public void a() {
        if (c()) {
            Intent registerReceiver = this.f8611a.registerReceiver(this.n, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.e = a(registerReceiver);
            this.f = a(registerReceiver);
            if (this.b.a().e()) {
                this.m.a(10, new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float a(Intent intent) {
        if (intent == null) {
            return 0.0f;
        }
        int intExtra = intent.getIntExtra("level", 0);
        if (intent.getIntExtra("scale", 100) != 0) {
            return (intExtra * 100) / r4;
        }
        return 100.0f;
    }

    private void b(int i) {
        com.baidu.navisdk.util.worker.c.a().a(new c("RGHMStatistics", null, i, com.baidu.navisdk.apm.cpu.a.c()), new com.baidu.navisdk.util.worker.e(99, 0), this.b.a().d() * 1000);
    }

    public void a(int i) {
        if (c()) {
            if (this.g.get(i) == null) {
                this.g.put(i, Long.valueOf(SystemClock.elapsedRealtime()));
                this.c.a(i, (SystemClock.elapsedRealtime() - com.baidu.navisdk.util.statistic.i.f9373a) / 1000);
                if (i >= 1) {
                    b(i);
                    c(i);
                }
                if (this.j < i) {
                    this.j = i;
                }
            }
            int i2 = this.i;
            if (i2 == -1) {
                this.i = i;
                this.k = SystemClock.elapsedRealtime();
            } else if (i2 != i) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.k;
                SparseArray<Long> sparseArray = this.h;
                int i3 = this.i;
                sparseArray.put(i3, Long.valueOf(sparseArray.get(i3, 0L).longValue() + elapsedRealtime));
                this.i = i;
                this.k = SystemClock.elapsedRealtime();
            }
        }
    }
}
