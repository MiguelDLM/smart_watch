package com.baidu.navisdk.util.common;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.ArrayList;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes8.dex */
public final class i implements SensorEventListener {

    @OOXIXo
    public static final a f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private SensorManager f9229a;
    private Sensor b;
    private float[] c;
    private final X0IIOO d;
    private volatile boolean e;

    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        @OOXIXo
        public final i a() {
            return c.b.a();
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(float f, float f2, float f3);
    }

    /* loaded from: classes8.dex */
    public static final class c {

        @OOXIXo
        public static final c b = new c();

        /* renamed from: a, reason: collision with root package name */
        @OOXIXo
        private static final i f9230a = new i(null);

        private c() {
        }

        @OOXIXo
        public final i a() {
            return f9230a;
        }
    }

    /* loaded from: classes8.dex */
    public static final class d extends Lambda implements Oox.oIX0oI<ArrayList<b>> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f9231a = new d();

        public d() {
            super(0);
        }

        @Override // Oox.oIX0oI
        @OOXIXo
        public final ArrayList<b> invoke() {
            return new ArrayList<>(4);
        }
    }

    private i() {
        this.c = new float[3];
        this.d = XIxXXX0x0.oIX0oI(d.f9231a);
    }

    private final ArrayList<b> a() {
        return (ArrayList) this.d.getValue();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(@oOoXoXO Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(@oOoXoXO SensorEvent sensorEvent) {
        Integer num;
        Sensor sensor;
        if (sensorEvent != null && (sensor = sensorEvent.sensor) != null) {
            num = Integer.valueOf(sensor.getType());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 9) {
            float[] fArr = sensorEvent.values;
            float[] fArr2 = this.c;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            for (b bVar : a()) {
                float[] fArr3 = sensorEvent.values;
                bVar.a(fArr3[0], fArr3[1], fArr3[2]);
            }
        }
    }

    public final void a(@OOXIXo Context context, @oOoXoXO b bVar) {
        IIX0o.x0xO0oo(context, "context");
        if (bVar == null) {
            return;
        }
        if (!a().contains(bVar)) {
            a().add(bVar);
        }
        if (this.f9229a == null) {
            this.e = false;
            this.f9229a = (SensorManager) context.getApplicationContext().getSystemService("sensor");
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNSysSensorHelper", "startAngleChangeListener：" + this.e + TokenParser.SP);
        }
        if (this.e || a().isEmpty()) {
            return;
        }
        this.e = true;
        SensorManager sensorManager = this.f9229a;
        if (sensorManager != null) {
            Sensor defaultSensor = sensorManager.getDefaultSensor(9);
            this.b = defaultSensor;
            sensorManager.registerListener(this, defaultSensor, 200000);
            if (gVar.d()) {
                gVar.e("BNSysSensorHelper", "startAngleChangeListener：registerListener ");
            }
        }
    }

    public /* synthetic */ i(IIXOooo iIXOooo) {
        this();
    }

    public final void a(@oOoXoXO b bVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNSysSensorHelper", "cancelAngleChangeListener");
        }
        if (bVar == null) {
            a().clear();
        } else {
            a().remove(bVar);
        }
        if (a().isEmpty()) {
            SensorManager sensorManager = this.f9229a;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this, this.b);
            }
            this.f9229a = null;
            this.e = false;
            if (gVar.d()) {
                gVar.e("BNSysSensorHelper", "cancelAngleChangeListener: end");
            }
        }
    }
}
