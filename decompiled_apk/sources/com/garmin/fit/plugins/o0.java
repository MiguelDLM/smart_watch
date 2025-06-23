package com.garmin.fit.plugins;

import com.garmin.fit.SensorType;
import com.garmin.fit.XxI;
import com.garmin.fit.o0Xo;
import com.garmin.fit.oIXoXx0;
import com.garmin.fit.x0OI;
import com.garmin.fit.x0OxxIOxX;
import com.garmin.fit.xIoXXXIXo;
import java.lang.reflect.Array;
import java.util.List;

/* loaded from: classes9.dex */
public class o0 implements XxI {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public II0xO0 f15127II0XooXoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public II0xO0 f15134xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public II0xO0 f15135xxIXOIIO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f15132oIX0oI = 0;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f15128II0xO0 = 1;

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f15126I0Io = 2;

    /* renamed from: oxoX, reason: collision with root package name */
    public final int f15133oxoX = 3;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f15130X0o0xo = false;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f15131XO = false;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f15129Oxx0IOOO = false;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f15142oIX0oI;

        static {
            int[] iArr = new int[SensorType.values().length];
            f15142oIX0oI = iArr;
            try {
                iArr[SensorType.ACCELEROMETER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15142oIX0oI[SensorType.GYROSCOPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15142oIX0oI[SensorType.COMPASS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public o0() {
        oIX0oI oix0oi = null;
        this.f15127II0XooXoX = new II0xO0(this, oix0oi);
        this.f15135xxIXOIIO = new II0xO0(this, oix0oi);
        this.f15134xoIox = new II0xO0(this, oix0oi);
    }

    public final float[] I0Io(int[] iArr, II0xO0 iI0xO0) {
        float[] fArr = new float[iArr.length];
        float[] fArr2 = new float[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            float f = iArr[i];
            fArr[i] = f;
            float f2 = f - ((float) iI0xO0.f15141oxoX);
            fArr[i] = f2;
            float f3 = f2 - ((float) iI0xO0.f15136I0Io[i]);
            fArr[i] = f3;
            float f4 = f3 * ((float) iI0xO0.f15140oIX0oI);
            fArr[i] = f4;
            fArr[i] = f4 / ((float) iI0xO0.f15137II0xO0);
        }
        float[][] fArr3 = iI0xO0.f15138X0o0xo;
        float[] fArr4 = fArr3[0];
        float f5 = fArr4[0] * fArr[0];
        float f6 = fArr4[1];
        float f7 = fArr[1];
        float f8 = fArr4[2];
        float f9 = fArr[2];
        fArr2[0] = f5 + (f6 * f7) + (f8 * f9);
        float[] fArr5 = fArr3[1];
        float f10 = fArr5[0];
        float f11 = fArr[0];
        fArr2[1] = (f10 * f11) + (fArr5[1] * f7) + (fArr5[2] * f9);
        float[] fArr6 = fArr3[2];
        fArr2[2] = (fArr6[0] * f11) + (fArr6[1] * fArr[1]) + (fArr6[2] * f9);
        return fArr2;
    }

    @Override // com.garmin.fit.XxI
    public void II0xO0(List<oIXoXx0> list) {
        int[] iArr = new int[3];
        for (oIXoXx0 oixoxx0 : list) {
            int XXoOx02 = oixoxx0.XXoOx0();
            if (XXoOx02 != 164) {
                if (XXoOx02 != 165) {
                    if (XXoOx02 == 208 && this.f15129Oxx0IOOO) {
                        xIoXXXIXo xioxxxixo = new xIoXXXIXo(oixoxx0);
                        int XO0o2 = xioxxxixo.XO0o();
                        for (int i = 0; i < XO0o2; i++) {
                            iArr[0] = xioxxxixo.OooI(i).intValue();
                            iArr[1] = xioxxxixo.xIXX(i).intValue();
                            iArr[2] = xioxxxixo.O00(i).intValue();
                            oxoX(oixoxx0, new String[]{"calibrated_mag_x", "calibrated_mag_y", "calibrated_mag_z"}, I0Io(iArr, this.f15134xoIox), "magnetometer_data");
                        }
                    }
                } else if (this.f15131XO) {
                    com.garmin.fit.I0Io i0Io = new com.garmin.fit.I0Io(oixoxx0);
                    int xX2 = i0Io.xX();
                    for (int i2 = 0; i2 < xX2; i2++) {
                        iArr[0] = i0Io.Oxx(i2).intValue();
                        iArr[1] = i0Io.oXIoO(i2).intValue();
                        iArr[2] = i0Io.XoIxOXIXo(i2).intValue();
                        oxoX(oixoxx0, new String[]{"calibrated_accel_x", "calibrated_accel_y", "calibrated_accel_z"}, I0Io(iArr, this.f15135xxIXOIIO), "accelerometer_data");
                    }
                }
            } else if (this.f15130X0o0xo) {
                o0Xo o0xo = new o0Xo(oixoxx0);
                int XO0o3 = o0xo.XO0o();
                for (int i3 = 0; i3 < XO0o3; i3++) {
                    iArr[0] = o0xo.OooI(i3).intValue();
                    iArr[1] = o0xo.xIXX(i3).intValue();
                    iArr[2] = o0xo.O00(i3).intValue();
                    oxoX(oixoxx0, new String[]{"calibrated_gyro_x", "calibrated_gyro_y", "calibrated_gyro_z"}, I0Io(iArr, this.f15127II0XooXoX), "gyroscope_data");
                }
            }
        }
    }

    @Override // com.garmin.fit.XxI
    public void oIX0oI(oIXoXx0 oixoxx0) {
        if (oixoxx0.XXoOx0() == 167) {
            x0OI x0oi = new x0OI(oixoxx0);
            int i = oIX0oI.f15142oIX0oI[x0oi.xOOxIO().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.f15134xoIox.oIX0oI(x0oi);
                        this.f15129Oxx0IOOO = true;
                        return;
                    }
                    return;
                }
                this.f15127II0XooXoX.oIX0oI(x0oi);
                this.f15130X0o0xo = true;
                return;
            }
            this.f15135xxIXOIIO.oIX0oI(x0oi);
            this.f15131XO = true;
        }
    }

    public final void oxoX(oIXoXx0 oixoxx0, String[] strArr, float[] fArr, String str) {
        if (strArr.length == 3 && fArr.length == 3) {
            if (oixoxx0.x0xO0oo(strArr[0]) == null) {
                oixoxx0.xxIXOIIO(x0OxxIOxX.oxoX(str, strArr[0]));
            }
            if (oixoxx0.x0xO0oo(strArr[1]) == null) {
                oixoxx0.xxIXOIIO(x0OxxIOxX.oxoX(str, strArr[1]));
            }
            if (oixoxx0.x0xO0oo(strArr[2]) == null) {
                oixoxx0.xxIXOIIO(x0OxxIOxX.oxoX(str, strArr[2]));
            }
            oixoxx0.x0xO0oo(strArr[0]).Oxx0IOOO(Float.valueOf(fArr[0]));
            oixoxx0.x0xO0oo(strArr[1]).Oxx0IOOO(Float.valueOf(fArr[1]));
            oixoxx0.x0xO0oo(strArr[2]).Oxx0IOOO(Float.valueOf(fArr[2]));
        }
    }

    /* loaded from: classes9.dex */
    public class II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public long[] f15136I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public long f15137II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public float[][] f15138X0o0xo;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public long f15140oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public long f15141oxoX;

        public II0xO0() {
            this.f15136I0Io = new long[3];
            this.f15138X0o0xo = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 3, 3);
        }

        public void oIX0oI(x0OI x0oi) {
            this.f15140oIX0oI = x0oi.oXIoO().longValue();
            this.f15137II0xO0 = x0oi.OX().longValue();
            this.f15141oxoX = x0oi.XoIxOXIXo().longValue();
            this.f15136I0Io[0] = x0oi.OIx00oxx(0).intValue();
            this.f15136I0Io[1] = x0oi.OIx00oxx(1).intValue();
            this.f15136I0Io[2] = x0oi.OIx00oxx(2).intValue();
            this.f15138X0o0xo[0][0] = x0oi.xxxI(0).floatValue();
            this.f15138X0o0xo[0][1] = x0oi.xxxI(1).floatValue();
            this.f15138X0o0xo[0][2] = x0oi.xxxI(2).floatValue();
            this.f15138X0o0xo[1][0] = x0oi.xxxI(3).floatValue();
            this.f15138X0o0xo[1][1] = x0oi.xxxI(4).floatValue();
            this.f15138X0o0xo[1][2] = x0oi.xxxI(5).floatValue();
            this.f15138X0o0xo[2][0] = x0oi.xxxI(6).floatValue();
            this.f15138X0o0xo[2][1] = x0oi.xxxI(7).floatValue();
            this.f15138X0o0xo[2][2] = x0oi.xxxI(8).floatValue();
        }

        public /* synthetic */ II0xO0(o0 o0Var, oIX0oI oix0oi) {
            this();
        }
    }
}
