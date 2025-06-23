package IO0XoXxO;

import XIXIX.OOXIXo;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ExoPlayer;
import com.octopus.ad.widget.ShakeView;
import x0.I0oOoX;

/* loaded from: classes11.dex */
public class xoIox {

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static volatile long f420XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static SensorManager f421XIxXXX0x0;

    /* renamed from: I0Io, reason: collision with root package name */
    public double f422I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f423II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public double f424II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f431Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f435X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f436XO;

    /* renamed from: o00, reason: collision with root package name */
    public float f437o00;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Context f439oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public ShakeView f440oO;

    /* renamed from: oxoX, reason: collision with root package name */
    public double f443oxoX;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public oxoX f445x0xO0oo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public View f447xoXoI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f448xxIXOIIO = 0;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f446xoIox = 0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public float f428OOXIXo = -100.0f;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public float f441oOoXoXO = -100.0f;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public float f442ooOOo0oXI = -100.0f;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public int f444x0XOIxOo = 0;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f429Oo = false;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f426IXxxXO = 200;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public String f432Oxx0xo = "50%";

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public String f438oI0IIXIo = "70%";

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public String f433OxxIIOOXO = "140";

    /* renamed from: IIXOooo, reason: collision with root package name */
    public String f425IIXOooo = "140";

    /* renamed from: OxI, reason: collision with root package name */
    public final float[] f430OxI = new float[3];

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f427O0xOxO = 2;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public final SensorEventListener f434X0IIOO = new oIX0oI();

    /* loaded from: classes11.dex */
    public class I0Io implements Runnable {
        public I0Io() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                xoIox.this.o00();
                xoIox.this.IIX0o();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class II0xO0 implements Runnable {
        public II0xO0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            xoIox.this.X0o0xo();
        }
    }

    /* loaded from: classes11.dex */
    public interface oxoX {
        void a();
    }

    public xoIox(Context context) {
        this.f439oIX0oI = context;
        f421XIxXXX0x0 = (SensorManager) context.getApplicationContext().getSystemService("sensor");
        IIX0o();
    }

    public static /* synthetic */ int oo(xoIox xoiox) {
        int i = xoiox.f448xxIXOIIO;
        xoiox.f448xxIXOIIO = i + 1;
        return i;
    }

    public static /* synthetic */ int x0o(xoIox xoiox) {
        int i = xoiox.f446xoIox;
        xoiox.f446xoIox = i + 1;
        return i;
    }

    public static Pair<Integer, Boolean> xXxxox0I(int i) {
        int random = (int) ((Math.random() * 100.0d) + 1.0d);
        if (random <= i) {
            return new Pair<>(Integer.valueOf(random), Boolean.TRUE);
        }
        return new Pair<>(Integer.valueOf(random), Boolean.FALSE);
    }

    public void II0XooXoX(int i) {
        this.f435X0o0xo = i;
    }

    public final void IIX0o() {
        Oxx0IOOO(1.5d, OOXIXo.f3760XO);
        Oxx0xo(1000);
        O0xOxO(0);
        oo0xXOI0I(0);
    }

    public void IXxxXO(double d) {
        this.f422I0Io = d;
    }

    public final void IoOoX() {
        SensorManager sensorManager = f421XIxXXX0x0;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f434X0IIOO);
        }
    }

    public void O0xOxO(int i) {
        this.f423II0XooXoX = i;
        xI();
    }

    public void OOXIXo(View view) {
        this.f447xoXoI = view;
        SensorManager sensorManager = f421XIxXXX0x0;
        if (sensorManager != null) {
            sensorManager.registerListener(this.f434X0IIOO, sensorManager.getDefaultSensor(1), 2);
            SensorManager sensorManager2 = f421XIxXXX0x0;
            sensorManager2.registerListener(this.f434X0IIOO, sensorManager2.getDefaultSensor(4), 2);
        }
    }

    public void Oo() {
        o0IXXIx.II0XooXoX.oIX0oI("OctopusAd", "enter unRegisterShakeListenerAndSetDefault");
        Xx000oIo();
        IoOoX();
        XIxXXX0x0();
    }

    public void OxI(double d) {
        this.f443oxoX = d;
    }

    public void Oxx0IOOO(double d, double d2) {
        XO(d);
        IXxxXO(d);
        int i = 1;
        II0XooXoX(1);
        OxI(d2);
        if (d2 <= OOXIXo.f3760XO) {
            i = 0;
        }
        xxX(i);
    }

    public void Oxx0xo(int i) {
        this.f431Oxx0IOOO = i;
    }

    public void X0o0xo() {
        boolean z;
        View view = this.f447xoXoI;
        if (view != null && view.isShown()) {
            if (System.currentTimeMillis() - f420XI0IXoo > 1000) {
                StringBuilder sb = new StringBuilder();
                sb.append("enter callBackShakeHappened and mShakeStateListener != null ? ");
                if (this.f445x0xO0oo != null) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                sb.append(",!isCallBack = ");
                sb.append(!this.f429Oo);
                o0IXXIx.II0XooXoX.oIX0oI("OctopusAd", sb.toString());
                if (this.f445x0xO0oo != null && !this.f429Oo) {
                    o0IXXIx.II0XooXoX.oIX0oI("OctopusAd", "callback onShakeHappened()");
                    this.f445x0xO0oo.a();
                    this.f429Oo = true;
                    int i = this.f427O0xOxO;
                    if (i == 1) {
                        IoOoX();
                        XIxXXX0x0();
                    } else if (i == 2) {
                        Oo();
                    } else if (i == 3) {
                        xxIXOIIO(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    }
                    f420XI0IXoo = System.currentTimeMillis();
                    return;
                }
                return;
            }
            o00();
        }
    }

    public void XIxXXX0x0() {
        this.f429Oo = false;
        this.f448xxIXOIIO = 0;
        this.f446xoIox = 0;
        this.f428OOXIXo = -100.0f;
        this.f441oOoXoXO = -100.0f;
        this.f442ooOOo0oXI = -100.0f;
        this.f444x0XOIxOo = 0;
        this.f445x0xO0oo = null;
        this.f439oIX0oI = null;
        this.f440oO = null;
        this.f447xoXoI = null;
        this.f426IXxxXO = 200;
    }

    public void XO(double d) {
        this.f424II0xO0 = d;
    }

    public final void Xx000oIo() {
        ShakeView shakeView = this.f440oO;
        if (shakeView != null) {
            shakeView.I0Io();
            I0oOoX.O0xOxO(this.f440oO);
            this.f440oO = null;
        }
    }

    public void o00() {
        this.f429Oo = false;
        this.f448xxIXOIIO = 0;
        this.f446xoIox = 0;
        this.f428OOXIXo = -100.0f;
        this.f441oOoXoXO = -100.0f;
        this.f442ooOOo0oXI = -100.0f;
        this.f444x0XOIxOo = 0;
        this.f426IXxxXO = 200;
    }

    public final boolean oI0IIXIo(float f, float f2, float f3, double d) {
        if (Math.sqrt(Math.pow(f / 9.8d, 2.0d) + Math.pow(f2 / 9.8d, 2.0d) + Math.pow(f3 / 9.8d, 2.0d)) > d) {
            return true;
        }
        return false;
    }

    public void oOoXoXO(String str, String str2, String str3, String str4) {
        this.f432Oxx0xo = str;
        this.f438oI0IIXIo = str2;
        this.f433OxxIIOOXO = str3;
        this.f425IIXOooo = str4;
    }

    public void oo0xXOI0I(int i) {
        this.f426IXxxXO = i;
    }

    public final boolean ooOOo0oXI(float f, float f2, float f3, double d) {
        if (Math.sqrt(Math.pow(f / 9.8d, 2.0d) + Math.pow(f2 / 9.8d, 2.0d) + Math.pow(f3 / 9.8d, 2.0d)) > d) {
            return true;
        }
        return false;
    }

    public View oxoX(int i, int i2, float f, String str, boolean z, boolean z2) {
        int parseInt;
        int parseInt2;
        int parseInt3;
        int parseInt4;
        o0IXXIx.II0XooXoX.oIX0oI("OctopusAd", "enter getShakeView");
        if (this.f439oIX0oI != null) {
            if (this.f436XO != 0 || this.f435X0o0xo != 0 || this.f423II0XooXoX != 0) {
                if (TextUtils.isEmpty(str)) {
                    str = "摇一摇跳转至\n第三方应用或详情页";
                }
                if (TextUtils.isEmpty(this.f432Oxx0xo) || "0".equals(this.f432Oxx0xo)) {
                    this.f432Oxx0xo = "50%";
                }
                if (TextUtils.isEmpty(this.f438oI0IIXIo) || "0".equals(this.f438oI0IIXIo)) {
                    this.f438oI0IIXIo = "50%";
                }
                if (TextUtils.isEmpty(this.f433OxxIIOOXO) || "0".equals(this.f433OxxIIOOXO)) {
                    this.f433OxxIIOOXO = "180";
                }
                if (TextUtils.isEmpty(this.f425IIXOooo) || "0".equals(this.f425IIXOooo)) {
                    this.f425IIXOooo = "180";
                }
                if (this.f432Oxx0xo.endsWith("%")) {
                    String str2 = this.f432Oxx0xo;
                    parseInt = (Integer.parseInt(str2.substring(0, str2.indexOf("%"))) * i) / 100;
                } else {
                    parseInt = Integer.parseInt(this.f432Oxx0xo);
                }
                if (this.f438oI0IIXIo.endsWith("%")) {
                    String str3 = this.f438oI0IIXIo;
                    parseInt2 = (Integer.parseInt(str3.substring(0, str3.indexOf("%"))) * i2) / 100;
                } else {
                    parseInt2 = Integer.parseInt(this.f438oI0IIXIo);
                }
                if (this.f433OxxIIOOXO.endsWith("%")) {
                    String str4 = this.f433OxxIIOOXO;
                    parseInt3 = (Integer.parseInt(str4.substring(0, str4.indexOf("%"))) * i) / 100;
                } else {
                    parseInt3 = Integer.parseInt(this.f433OxxIIOOXO);
                }
                if (parseInt3 > i) {
                    parseInt3 = i;
                }
                if (this.f425IIXOooo.endsWith("%")) {
                    String str5 = this.f425IIXOooo;
                    parseInt4 = (Integer.parseInt(str5.substring(0, str5.indexOf("%"))) * i2) / 100;
                } else {
                    parseInt4 = Integer.parseInt(this.f425IIXOooo);
                }
                if (parseInt4 > i2) {
                    parseInt4 = i2;
                }
                int x0XOIxOo2 = I0oOoX.x0XOIxOo(this.f439oIX0oI, parseInt3);
                int x0XOIxOo3 = I0oOoX.x0XOIxOo(this.f439oIX0oI, parseInt4);
                int x0XOIxOo4 = I0oOoX.x0XOIxOo(this.f439oIX0oI, parseInt);
                int x0XOIxOo5 = I0oOoX.x0XOIxOo(this.f439oIX0oI, parseInt2);
                o0IXXIx.II0XooXoX.oIX0oI("OctopusAd", "widthInt = " + x0XOIxOo2 + ",heightInt = " + x0XOIxOo3);
                o0IXXIx.II0XooXoX.oIX0oI("OctopusAd", "centerYInt = " + x0XOIxOo5 + ",centerXInt = " + x0XOIxOo4 + ",adWidthDp = " + i + ",adHeightDp = " + i2);
                if (x0XOIxOo5 == 0) {
                    x0XOIxOo5 = I0oOoX.x0XOIxOo(this.f439oIX0oI, i2) / 2;
                }
                if (z2) {
                    float f2 = i / 360.0f;
                    x0XOIxOo2 = (int) (x0XOIxOo2 * f2);
                    x0XOIxOo3 = (int) (x0XOIxOo3 * f2);
                    f *= f2;
                }
                ShakeView shakeView = new ShakeView(this.f439oIX0oI, x0XOIxOo2, f);
                this.f440oO = shakeView;
                shakeView.setTitleText(str);
                if (z) {
                    this.f440oO.setLayoutParams(new FrameLayout.LayoutParams(x0XOIxOo2, -2, 17));
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(x0XOIxOo2, -2);
                    marginLayoutParams.topMargin = x0XOIxOo5 - (x0XOIxOo3 / 2);
                    marginLayoutParams.leftMargin = x0XOIxOo4 - (x0XOIxOo2 / 2);
                    this.f440oO.setLayoutParams(marginLayoutParams);
                    o0IXXIx.II0XooXoX.oIX0oI("OctopusAd", "topMargin = " + marginLayoutParams.topMargin + ",leftMargin = " + marginLayoutParams.leftMargin + ",widthInt = " + x0XOIxOo2 + ",heightInt = " + x0XOIxOo3);
                }
                this.f440oO.II0xO0();
                return this.f440oO;
            }
            return null;
        }
        return null;
    }

    public final void xI() {
        if (((Boolean) xXxxox0I(this.f423II0XooXoX).second).booleanValue()) {
            IO0XoXxO.oxoX.oIX0oI(new II0xO0(), this.f431Oxx0IOOO + (((Integer) r0.first).intValue() * 10));
        }
    }

    public void xoIox(oxoX oxox) {
        this.f445x0xO0oo = oxox;
    }

    public final void xxIXOIIO(long j) {
        new Handler().postDelayed(new I0Io(), j);
    }

    public void xxX(int i) {
        this.f436XO = i;
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements SensorEventListener {
        public oIX0oI() {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            double d;
            double d2;
            double d3;
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            if (sensorEvent.sensor.getType() == 1) {
                if (xoIox.this.f428OOXIXo == -100.0f) {
                    xoIox.this.f428OOXIXo = f;
                }
                if (xoIox.this.f441oOoXoXO == -100.0f) {
                    xoIox.this.f441oOoXoXO = f2;
                }
                if (xoIox.this.f442ooOOo0oXI == -100.0f) {
                    xoIox.this.f442ooOOo0oXI = f3;
                }
                o0IXXIx.II0XooXoX.II0xO0("ShakeUtil", "x = " + f + ",initialX = " + xoIox.this.f428OOXIXo + ",y = " + f2 + ",initialY = " + xoIox.this.f441oOoXoXO + ",z = " + f3 + ",initialZ = " + xoIox.this.f442ooOOo0oXI);
                xoIox xoiox = xoIox.this;
                if (xoiox.ooOOo0oXI(f, f2, f3, xoiox.f424II0xO0)) {
                    xoIox.this.f444x0XOIxOo = 1;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("mShakeState = ");
                sb.append(xoIox.this.f444x0XOIxOo);
                sb.append(",isShakeStart = ");
                xoIox xoiox2 = xoIox.this;
                sb.append(xoiox2.ooOOo0oXI(f, f2, f3, xoiox2.f424II0xO0));
                sb.append(",isShakeEnd = ");
                xoIox xoiox3 = xoIox.this;
                sb.append(xoiox3.oI0IIXIo(f, f2, f3, xoiox3.f422I0Io));
                o0IXXIx.II0XooXoX.II0xO0("ShakeUtil", sb.toString());
                if (xoIox.this.f444x0XOIxOo == 1) {
                    xoIox xoiox4 = xoIox.this;
                    if (xoiox4.oI0IIXIo(f, f2, f3, xoiox4.f422I0Io)) {
                        xoIox.this.f444x0XOIxOo = 2;
                        xoIox.oo(xoIox.this);
                    }
                }
            } else if (sensorEvent.sensor.getType() == 4) {
                if (xoIox.this.f436XO == 0) {
                    return;
                }
                if (xoIox.this.f437o00 != 0.0f) {
                    float f4 = (((float) sensorEvent.timestamp) - xoIox.this.f437o00) * 1.0E-9f;
                    float[] fArr2 = xoIox.this.f430OxI;
                    fArr2[0] = fArr2[0] + (sensorEvent.values[0] * f4);
                    float[] fArr3 = xoIox.this.f430OxI;
                    fArr3[1] = fArr3[1] + (sensorEvent.values[1] * f4);
                    float[] fArr4 = xoIox.this.f430OxI;
                    fArr4[2] = fArr4[2] + (sensorEvent.values[2] * f4);
                    d = Math.abs(Math.toDegrees(xoIox.this.f430OxI[0]));
                    d2 = Math.abs(Math.toDegrees(xoIox.this.f430OxI[1]));
                    d3 = Math.abs(Math.toDegrees(xoIox.this.f430OxI[2]));
                } else {
                    d = OOXIXo.f3760XO;
                    d2 = 0.0d;
                    d3 = 0.0d;
                }
                xoIox.this.f437o00 = (float) sensorEvent.timestamp;
                o0IXXIx.II0XooXoX.II0xO0("ShakeUtil", "rotateX = " + d + ",rotateY = " + d2 + ",rotateZ = " + d3 + ",rotateAmplitude = " + xoIox.this.f443oxoX);
                if (d > xoIox.this.f443oxoX) {
                    xoIox.x0o(xoIox.this);
                }
                if (d2 > xoIox.this.f443oxoX) {
                    xoIox.x0o(xoIox.this);
                }
                if (d3 > xoIox.this.f443oxoX) {
                    xoIox.x0o(xoIox.this);
                }
            }
            o0IXXIx.II0XooXoX.II0xO0("ShakeUtil", "mShakeCount = " + xoIox.this.f448xxIXOIIO + ",dstShakeCount = " + xoIox.this.f435X0o0xo + ",mRotateCount = " + xoIox.this.f446xoIox + ",dstRotateCount = " + xoIox.this.f436XO);
            if (xoIox.this.f448xxIXOIIO >= xoIox.this.f435X0o0xo && xoIox.this.f446xoIox >= xoIox.this.f436XO) {
                xoIox.this.X0o0xo();
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }
}
