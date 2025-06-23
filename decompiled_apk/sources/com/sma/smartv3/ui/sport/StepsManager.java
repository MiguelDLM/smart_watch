package com.sma.smartv3.ui.sport;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.blankj.utilcode.util.LogUtils;
import java.util.Arrays;

/* loaded from: classes12.dex */
public final class StepsManager {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Sensor f23858I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f23859II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public SensorManager f23860II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public oIX0oI f23861OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f23862Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f23863X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public DetectStatus f23864XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final String f23865oIX0oI;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public II0xO0 f23866oOoXoXO;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Sensor f23867oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f23868xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f23869xxIXOIIO;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes12.dex */
    public static final class DetectStatus {
        private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
        private static final /* synthetic */ DetectStatus[] $VALUES;
        public static final DetectStatus START = new DetectStatus("START", 0);
        public static final DetectStatus RESUME = new DetectStatus("RESUME", 1);
        public static final DetectStatus PAUSE = new DetectStatus("PAUSE", 2);
        public static final DetectStatus END = new DetectStatus("END", 3);

        private static final /* synthetic */ DetectStatus[] $values() {
            return new DetectStatus[]{START, RESUME, PAUSE, END};
        }

        static {
            DetectStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.I0Io.I0Io($values);
        }

        private DetectStatus(String str, int i) {
        }

        @OXOo.OOXIXo
        public static kotlin.enums.oIX0oI<DetectStatus> getEntries() {
            return $ENTRIES;
        }

        public static DetectStatus valueOf(String str) {
            return (DetectStatus) Enum.valueOf(DetectStatus.class, str);
        }

        public static DetectStatus[] values() {
            return (DetectStatus[]) $VALUES.clone();
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements SensorEventListener {
        public II0xO0() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(@OXOo.oOoXoXO Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(@OXOo.oOoXoXO SensorEvent sensorEvent) {
            int i;
            int i2;
            float[] fArr;
            float[] fArr2;
            float[] fArr3 = null;
            if (StepsManager.this.f23864XO != DetectStatus.END) {
                if (StepsManager.this.f23863X0o0xo == 19) {
                    if (sensorEvent != null && (fArr2 = sensorEvent.values) != null) {
                        i = (int) fArr2[0];
                    } else {
                        i = 0;
                    }
                    if (StepsManager.this.f23869xxIXOIIO == 0) {
                        StepsManager.this.f23869xxIXOIIO = i;
                    }
                    if ((i - StepsManager.this.f23869xxIXOIIO) - StepsManager.this.f23868xoIox < 0) {
                        StepsManager.this.f23868xoIox = 0;
                        StepsManager stepsManager = StepsManager.this;
                        if (i > 0) {
                            i2 = i - stepsManager.f23862Oxx0IOOO;
                        } else {
                            i2 = stepsManager.f23862Oxx0IOOO + i;
                        }
                        stepsManager.f23869xxIXOIIO = i2;
                        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                        StringBuilder sb = new StringBuilder();
                        sb.append(StepsManager.this.f23865oIX0oI);
                        sb.append(" error onSensorChanged -> cst:");
                        sb.append(StepsManager.this.f23863X0o0xo);
                        sb.append(" ev:");
                        if (sensorEvent != null) {
                            fArr = sensorEvent.values;
                        } else {
                            fArr = null;
                        }
                        sb.append(Arrays.toString(fArr));
                        sb.append(" s=");
                        sb.append(StepsManager.this.f23864XO);
                        sb.append(" l=");
                        sb.append(StepsManager.this.f23859II0XooXoX);
                        sb.append(" f=");
                        sb.append(StepsManager.this.f23869xxIXOIIO);
                        sb.append(" p=");
                        sb.append(StepsManager.this.f23868xoIox);
                        sb.append(" c=");
                        sb.append(StepsManager.this.f23862Oxx0IOOO);
                        oix0oi.oIX0oI(sb.toString());
                    }
                    if (StepsManager.this.x0XOIxOo()) {
                        StepsManager stepsManager2 = StepsManager.this;
                        stepsManager2.f23862Oxx0IOOO = (i - stepsManager2.f23869xxIXOIIO) - StepsManager.this.f23868xoIox;
                        oIX0oI oix0oi2 = StepsManager.this.f23861OOXIXo;
                        if (oix0oi2 != null) {
                            oix0oi2.oIX0oI(StepsManager.this.f23862Oxx0IOOO);
                        }
                    } else {
                        StepsManager.this.f23868xoIox += i - StepsManager.this.f23859II0XooXoX;
                    }
                    StepsManager.this.f23859II0XooXoX = i;
                } else if (StepsManager.this.f23863X0o0xo != 18) {
                    oIX0oI oix0oi3 = StepsManager.this.f23861OOXIXo;
                    if (oix0oi3 != null) {
                        oix0oi3.oIX0oI(0);
                    }
                } else if (StepsManager.this.x0XOIxOo()) {
                    oIX0oI oix0oi4 = StepsManager.this.f23861OOXIXo;
                    if (oix0oi4 != null) {
                        StepsManager stepsManager3 = StepsManager.this;
                        int i3 = stepsManager3.f23862Oxx0IOOO;
                        stepsManager3.f23862Oxx0IOOO = i3 + 1;
                        oix0oi4.oIX0oI(i3);
                    }
                } else {
                    StepsManager.this.f23868xoIox++;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(StepsManager.this.f23865oIX0oI);
            sb2.append(" onSensorChanged -> cst:");
            sb2.append(StepsManager.this.f23863X0o0xo);
            sb2.append(" ev:");
            if (sensorEvent != null) {
                fArr3 = sensorEvent.values;
            }
            sb2.append(Arrays.toString(fArr3));
            sb2.append(" s=");
            sb2.append(StepsManager.this.f23864XO);
            sb2.append(" l=");
            sb2.append(StepsManager.this.f23859II0XooXoX);
            sb2.append(" f=");
            sb2.append(StepsManager.this.f23869xxIXOIIO);
            sb2.append(" p=");
            sb2.append(StepsManager.this.f23868xoIox);
            sb2.append(" c=");
            sb2.append(StepsManager.this.f23862Oxx0IOOO);
            LogUtils.d(sb2.toString());
        }
    }

    /* loaded from: classes12.dex */
    public interface oIX0oI {
        void oIX0oI(int i);
    }

    public StepsManager(@OXOo.OOXIXo Context context, @OXOo.OOXIXo oIX0oI onStepListener) {
        Sensor sensor;
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        kotlin.jvm.internal.IIX0o.x0xO0oo(onStepListener, "onStepListener");
        this.f23865oIX0oI = "StepsManager";
        this.f23864XO = DetectStatus.END;
        this.f23866oOoXoXO = new II0xO0();
        Object systemService = context.getSystemService("sensor");
        kotlin.jvm.internal.IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        SensorManager sensorManager = (SensorManager) systemService;
        this.f23860II0xO0 = sensorManager;
        if (sensorManager != null) {
            sensor = sensorManager.getDefaultSensor(18);
        } else {
            sensor = null;
        }
        this.f23858I0Io = sensor;
        SensorManager sensorManager2 = this.f23860II0xO0;
        Sensor defaultSensor = sensorManager2 != null ? sensorManager2.getDefaultSensor(19) : null;
        this.f23867oxoX = defaultSensor;
        this.f23861OOXIXo = onStepListener;
        if (defaultSensor != null) {
            LogUtils.d("StepsManager Current sensor StepCountSensor " + this.f23867oxoX);
            this.f23863X0o0xo = 19;
            SensorManager sensorManager3 = this.f23860II0xO0;
            if (sensorManager3 != null) {
                sensorManager3.registerListener(this.f23866oOoXoXO, this.f23867oxoX, 0);
                return;
            }
            return;
        }
        if (this.f23858I0Io != null) {
            LogUtils.d("StepsManager Current sensor StepDetectorSensor " + this.f23858I0Io);
            this.f23863X0o0xo = 18;
            SensorManager sensorManager4 = this.f23860II0xO0;
            if (sensorManager4 != null) {
                sensorManager4.registerListener(this.f23866oOoXoXO, this.f23858I0Io, 0);
                return;
            }
            return;
        }
        LogUtils.d("StepsManager Count sensor not available!");
        this.f23863X0o0xo = 0;
    }

    public final void IXxxXO() {
        LogUtils.d(this.f23865oIX0oI + " onResume");
        this.f23864XO = DetectStatus.RESUME;
    }

    public final void Oo() {
        LogUtils.d(this.f23865oIX0oI + " onPause");
        this.f23864XO = DetectStatus.PAUSE;
    }

    public final void Oxx0xo() {
        LogUtils.d(this.f23865oIX0oI + " onStart");
        this.f23864XO = DetectStatus.START;
        this.f23862Oxx0IOOO = 0;
        this.f23869xxIXOIIO = 0;
        this.f23859II0XooXoX = 0;
        this.f23868xoIox = 0;
    }

    public final void oO() {
        SensorManager sensorManager;
        LogUtils.d(this.f23865oIX0oI + " onDestroy");
        int i = this.f23863X0o0xo;
        if (i == 19) {
            SensorManager sensorManager2 = this.f23860II0xO0;
            if (sensorManager2 != null) {
                sensorManager2.unregisterListener(this.f23866oOoXoXO, this.f23867oxoX);
                return;
            }
            return;
        }
        if (i == 18 && (sensorManager = this.f23860II0xO0) != null) {
            sensorManager.unregisterListener(this.f23866oOoXoXO, this.f23858I0Io);
        }
    }

    public final int ooOOo0oXI() {
        return this.f23863X0o0xo;
    }

    public final boolean x0XOIxOo() {
        DetectStatus detectStatus = this.f23864XO;
        if (detectStatus != DetectStatus.START && detectStatus != DetectStatus.RESUME) {
            return false;
        }
        return true;
    }

    public final void x0xO0oo() {
        LogUtils.d(this.f23865oIX0oI + " onEnd");
        this.f23864XO = DetectStatus.END;
    }
}
