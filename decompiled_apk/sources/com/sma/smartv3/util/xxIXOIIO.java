package com.sma.smartv3.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class xxIXOIIO implements SensorEventListener {

    /* renamed from: O0xOxO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f24735O0xOxO = new oIX0oI(null);

    /* renamed from: X0IIOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24736X0IIOO = "Compass";

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final float[] f24737IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Sensor f24738IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final SensorManager f24739Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public float f24740OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Sensor f24741Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final float[] f24742OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public II0xO0 f24743XO;

    /* renamed from: o00, reason: collision with root package name */
    public float f24744o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final float[] f24745oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final float[] f24746xoXoI;

    /* loaded from: classes12.dex */
    public interface II0xO0 {
        void oIX0oI(float f);
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public xxIXOIIO(@OXOo.OOXIXo Context context) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        Object systemService = context.getSystemService("sensor");
        kotlin.jvm.internal.IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        SensorManager sensorManager = (SensorManager) systemService;
        this.f24739Oo = sensorManager;
        this.f24745oI0IIXIo = new float[3];
        this.f24742OxxIIOOXO = new float[3];
        this.f24737IIXOooo = new float[9];
        this.f24746xoXoI = new float[9];
        this.f24738IXxxXO = sensorManager.getDefaultSensor(1);
        this.f24741Oxx0xo = sensorManager.getDefaultSensor(2);
    }

    public final void I0Io(@OXOo.oOoXoXO II0xO0 iI0xO0) {
        this.f24743XO = iI0xO0;
    }

    public final void II0xO0(float f) {
        this.f24740OxI = f;
    }

    public final void X0o0xo() {
        this.f24739Oo.unregisterListener(this);
    }

    public final void oIX0oI() {
        II0xO0(0.0f);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(@OXOo.OOXIXo Sensor sensor, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sensor, "sensor");
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(@OXOo.OOXIXo SensorEvent event) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(event, "event");
        synchronized (this) {
            try {
                if (event.sensor.getType() == 1) {
                    float[] fArr = this.f24745oI0IIXIo;
                    float f = fArr[0] * 0.97f;
                    float f2 = 1 - 0.97f;
                    float[] fArr2 = event.values;
                    fArr[0] = f + (fArr2[0] * f2);
                    fArr[1] = (fArr[1] * 0.97f) + (fArr2[1] * f2);
                    fArr[2] = (fArr[2] * 0.97f) + (f2 * fArr2[2]);
                }
                if (event.sensor.getType() == 2) {
                    float[] fArr3 = this.f24742OxxIIOOXO;
                    float f3 = fArr3[0] * 0.97f;
                    float f4 = 1 - 0.97f;
                    float[] fArr4 = event.values;
                    fArr3[0] = f3 + (fArr4[0] * f4);
                    fArr3[1] = (fArr3[1] * 0.97f) + (fArr4[1] * f4);
                    fArr3[2] = (0.97f * fArr3[2]) + (f4 * fArr4[2]);
                }
                if (SensorManager.getRotationMatrix(this.f24737IIXOooo, this.f24746xoXoI, this.f24745oI0IIXIo, this.f24742OxxIIOOXO)) {
                    SensorManager.getOrientation(this.f24737IIXOooo, new float[3]);
                    float f5 = 360;
                    this.f24744o00 = ((((float) Math.toDegrees(r10[0])) + this.f24740OxI) + f5) % f5;
                    II0xO0 iI0xO0 = this.f24743XO;
                    if (iI0xO0 != null) {
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(iI0xO0);
                        iI0xO0.oIX0oI(this.f24744o00);
                    }
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void oxoX() {
        this.f24739Oo.registerListener(this, this.f24738IXxxXO, 1);
        this.f24739Oo.registerListener(this, this.f24741Oxx0xo, 1);
    }
}
