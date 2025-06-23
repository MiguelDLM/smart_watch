package IOOXOOOOo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

/* loaded from: classes6.dex */
public class I0Io implements SensorEventListener {

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final String f524X0IIOO = "SensorController";

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int f525XI0IXoo = 0;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final int f526XIxXXX0x0 = 1;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final long f527XxX0x0xxx = 300;

    /* renamed from: xxX, reason: collision with root package name */
    public static final int f528xxX = 2;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f530IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public oIX0oI f531O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public final Sensor f532Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f534Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final SensorManager f536XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f538oI0IIXIo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public long f535OxxIIOOXO = 0;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f529IIXOooo = false;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f539xoXoI = false;

    /* renamed from: o00, reason: collision with root package name */
    public int f537o00 = 0;

    /* renamed from: OxI, reason: collision with root package name */
    public int f533OxI = 1;

    /* loaded from: classes6.dex */
    public interface oIX0oI {
        void I0Io();
    }

    public I0Io(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f536XO = sensorManager;
        this.f532Oo = sensorManager.getDefaultSensor(1);
    }

    public void I0Io() {
        XO();
        this.f539xoXoI = true;
        this.f536XO.registerListener(this, this.f532Oo, 3);
    }

    public void II0XooXoX() {
        this.f529IIXOooo = false;
        this.f533OxI++;
        Log.i(f524X0IIOO, "unlockFocus");
    }

    public void II0xO0() {
        this.f529IIXOooo = true;
        this.f533OxI--;
        Log.i(f524X0IIOO, "lockFocus");
    }

    public void Oxx0IOOO(oIX0oI oix0oi) {
        this.f531O0xOxO = oix0oi;
    }

    public void X0o0xo() {
        this.f533OxI = 1;
    }

    public final void XO() {
        this.f537o00 = 0;
        this.f530IXxxXO = 0;
        this.f534Oxx0xo = 0;
        this.f538oI0IIXIo = 0;
    }

    public boolean oIX0oI() {
        if (!this.f539xoXoI || this.f533OxI > 0) {
            return false;
        }
        return true;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        oIX0oI oix0oi;
        if (sensorEvent.sensor == null) {
            return;
        }
        if (this.f529IIXOooo) {
            XO();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f535OxxIIOOXO < 300) {
            return;
        }
        this.f535OxxIIOOXO = currentTimeMillis;
        if (sensorEvent.sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            int i = (int) fArr[0];
            int i2 = (int) fArr[1];
            int i3 = (int) fArr[2];
            int abs = Math.abs(this.f530IXxxXO - i);
            int abs2 = Math.abs(this.f534Oxx0xo - i2);
            int abs3 = Math.abs(this.f538oI0IIXIo - i3);
            if (Math.sqrt((abs * abs) + (abs2 * abs2) + (abs3 * abs3)) > 1.4d) {
                this.f537o00 = 2;
            } else {
                if (this.f537o00 == 2 && (oix0oi = this.f531O0xOxO) != null) {
                    oix0oi.I0Io();
                }
                this.f537o00 = 1;
            }
            this.f530IXxxXO = i;
            this.f534Oxx0xo = i2;
            this.f538oI0IIXIo = i3;
        }
    }

    public void oxoX() {
        this.f536XO.unregisterListener(this, this.f532Oo);
        this.f539xoXoI = false;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
