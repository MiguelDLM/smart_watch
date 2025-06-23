package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.vtrump.vtble.Scale.ScaleInfo;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class oOoXoXO extends o00 {

    /* renamed from: IO, reason: collision with root package name */
    public boolean f27513IO;

    /* renamed from: Io, reason: collision with root package name */
    public Handler f27514Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public final JSONArray f27515IoOoX;

    /* renamed from: OI0, reason: collision with root package name */
    public int f27516OI0;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public Runnable f27517X00IoxXI;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public boolean f27518XOxIOxOx;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public int f27519Xx000oIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public boolean f27520oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public final JSONObject f27521oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f27522oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public ScaleUserInfo f27523ooXIXxIX;

    /* renamed from: x0o, reason: collision with root package name */
    public Runnable f27524x0o;

    /* renamed from: xI, reason: collision with root package name */
    public int f27525xI;

    /* renamed from: xII, reason: collision with root package name */
    public int f27526xII;

    /* loaded from: classes13.dex */
    public class I0Io implements Runnable {
        public I0Io() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (oOoXoXO.this.f27513IO || oOoXoXO.this.f27526xII > 5) {
                return;
            }
            oOoXoXO.this.oOo();
        }
    }

    /* loaded from: classes13.dex */
    public class II0xO0 implements Runnable {
        public II0xO0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (oOoXoXO.this.f27518XOxIOxOx || oOoXoXO.this.f27516OI0 > 5) {
                return;
            }
            oOoXoXO.this.IoOoo();
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI extends Handler {
        public oIX0oI() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    public oOoXoXO(BluetoothDevice bluetoothDevice, Context context) {
        super(bluetoothDevice, context);
        this.f27522oo0xXOI0I = 2;
        this.f27519Xx000oIo = 500;
        this.f27513IO = false;
        this.f27518XOxIOxOx = false;
        this.f27514Io = new oIX0oI();
        this.f27521oo = new JSONObject();
        this.f27515IoOoX = new JSONArray();
        this.f27520oOXoIIIo = false;
        this.f27524x0o = new II0xO0();
        this.f27517X00IoxXI = new I0Io();
    }

    @Override // com.vtrump.vtble.o00
    public void I0(ScaleInfo.VTUnit vTUnit) {
        ooOx(100L);
        Oxx0xo.oIX0oI("VTDeviceScaleXHBonso", "writeUnit,unit:" + vTUnit.nativeInt);
        xII(IXxxXO.f27153IXO, IXxxXO.f27161Ix00oIoI, new byte[]{1, (byte) vTUnit.nativeInt}, false);
    }

    @Override // com.vtrump.vtble.o00
    public void IoOoo() {
        ooOx(100L);
        this.f27520oOXoIIIo = true;
        this.f27516OI0++;
        this.f27514Io.postDelayed(this.f27524x0o, this.f27519Xx000oIo);
        Oxx0xo.oIX0oI("VTDeviceScaleXHBonso", "readHistoryRecord:" + this.f27516OI0);
        xII(IXxxXO.f27153IXO, IXxxXO.f27161Ix00oIoI, new byte[]{2, -73}, false);
    }

    @Override // com.vtrump.vtble.o00
    public void OOXIxO0() {
        super.OOXIxO0();
        ooOx(100L);
        Oxx0xo.oIX0oI("VTDeviceScaleXHBonso", "writeA5");
        xII(IXxxXO.f27153IXO, IXxxXO.f27161Ix00oIoI, new byte[]{5, -91}, false);
    }

    public void oOo() {
        ooOx(100L);
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        byte[] bArr = {-74, 7, (byte) i, (byte) (i >> 8), (byte) (calendar.get(2) + 1), (byte) calendar.get(5), (byte) calendar.get(11), (byte) calendar.get(12), (byte) calendar.get(13), xxX.x0xO0oo(bArr, 2, 8)};
        String str = calendar.get(1) + HelpFormatter.DEFAULT_OPT_PREFIX + (calendar.get(2) + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + calendar.get(5) + " " + calendar.get(11) + ":" + calendar.get(12) + ":" + calendar.get(13);
        Oxx0xo.oIX0oI("VTDeviceScaleXHBonso", "writeTime: " + xxX.Oxx0xo(bArr));
        Oxx0xo.oIX0oI("VTDeviceScaleXHBonso", "writeTime: " + str);
        this.f27526xII = this.f27526xII + 1;
        this.f27514Io.postDelayed(this.f27517X00IoxXI, (long) this.f27519Xx000oIo);
        xII(IXxxXO.f27153IXO, IXxxXO.f27161Ix00oIoI, bArr, false);
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void oOoXoXO(String str, String str2, byte[] bArr) {
        double ooOOo0oXI2;
        int i;
        Oxx0xo.oIX0oI("VTDeviceScaleXHBonso", "dataChangedNotify::" + xxX.IIXOooo(bArr));
        if (bArr.length == 2 || bArr.length == 3) {
            byte b = bArr[0];
            if (b == 1) {
                OO(1, (bArr[1] & 1) + "");
            } else if (b == 5) {
                OO(5, "");
            } else {
                if (b == 2 && bArr[1] == -74) {
                    this.f27513IO = true;
                    this.f27526xII = 0;
                    this.f27514Io.removeCallbacks(this.f27517X00IoxXI);
                    Oxx0xo.oIX0oI("VTDeviceScaleXHBonso", "write time end");
                } else if (b == 3) {
                    byte b2 = bArr[1];
                    if (b2 != -73 || bArr[2] != 1) {
                        if (b2 == -73 && bArr[2] == 0) {
                            this.f27518XOxIOxOx = true;
                            this.f27520oOXoIIIo = false;
                            this.f27516OI0 = 0;
                            this.f27514Io.removeCallbacks(this.f27524x0o);
                            try {
                                this.f27521oo.put("result", this.f27515IoOoX);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            OO(3, this.f27521oo.toString());
                            Oxx0xo.oIX0oI("VTDeviceScaleXHBonso", "history end: " + this.f27521oo.toString());
                        }
                    }
                }
                IoOoo();
            }
        } else {
            byte b3 = bArr[0];
            int i2 = (b3 & 32) >> 5;
            int i3 = b3 & 1;
            int i4 = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            int i5 = bArr[3] & 255;
            int i6 = bArr[4] & 255;
            int i7 = bArr[5] & 255;
            int i8 = bArr[6] & 255;
            int i9 = bArr[7] & 255;
            String str3 = i4 + HelpFormatter.DEFAULT_OPT_PREFIX + i5 + HelpFormatter.DEFAULT_OPT_PREFIX + i6 + " " + i7 + ":" + i8 + ":" + i9;
            double d = ((bArr[9] & 255) << 8) | (bArr[8] & 255);
            double d2 = ((bArr[11] & 255) << 8) | (bArr[10] & 255);
            if (i3 == 0) {
                this.f27522oo0xXOI0I = 2;
                ooOOo0oXI2 = d2 / 100.0d;
            } else {
                this.f27522oo0xXOI0I = 1;
                ooOOo0oXI2 = OxxIIOOXO.ooOOo0oXI(d2 / 10.0d);
            }
            Oxx0xo.oIX0oI("VTDeviceScaleXHBonso", "dataChangedNotify: weight:" + ooOOo0oXI2 + ",rValue:" + d + ",unit: " + i3);
            double d3 = ooOOo0oXI2 >= 183.0d ? 183.0d : ooOOo0oXI2;
            Calendar calendar = Calendar.getInstance();
            double d4 = d3;
            calendar.set(i4, i5, i6, i5, i8, i9);
            long timeInMillis = calendar.getTimeInMillis();
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis > timeInMillis ? (currentTimeMillis - timeInMillis) / 86400000 : 0L;
            if (!this.f27520oOXoIIIo || bArr.length != 16 || d <= XIXIX.OOXIXo.f3760XO || j > 90) {
                if (this.f27523ooXIXxIX == null) {
                    I0oOoX(new IIX0o(d4, d, this.f27522oo0xXOI0I, false));
                    return;
                }
                if (i2 == 0) {
                    this.f27525xI = 0;
                    I0oOoX(new IIX0o(d4, d, this.f27522oo0xXOI0I, false));
                }
                if (i2 == 1 && (i = this.f27525xI) == 0) {
                    this.f27525xI = i + 1;
                    ScaleUserInfo scaleUserInfo = this.f27523ooXIXxIX;
                    XX(Ix0x.II0XooXoX.X0IIOO(1016).XI0IXoo(this.f27523ooXIXxIX, d4, d).IIX0o(scaleUserInfo, d4, d, "bonso"), scaleUserInfo, bArr, bArr, this.f27522oo0xXOI0I, 1016, "bonso", "");
                }
            } else {
                Oxx0xo.oIX0oI("VTDeviceScaleXHBonso", "dataChangedNotify history！！::" + xxX.IIXOooo(bArr));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", str3);
                    jSONObject.put("rValue", d);
                    jSONObject.put("weight", d4);
                    StringBuilder sb = new StringBuilder();
                    sb.append("history：");
                    sb.append(jSONObject.toString());
                    Oxx0xo.oIX0oI("VTDeviceScaleXHBonso", sb.toString());
                    this.f27515IoOoX.put(jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        super.oOoXoXO(str, str2, bArr);
    }

    public void oXIO0o0XI() {
        X0IIOO(IXxxXO.f27153IXO, IXxxXO.f27209oI);
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void ooOOo0oXI(String str, String str2, byte[] bArr) {
        super.ooOOo0oXI(str, str2, bArr);
    }

    public final void ooOx(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        ScaleUserInfo scaleUserInfo = new ScaleUserInfo();
        this.f27523ooXIXxIX = scaleUserInfo;
        scaleUserInfo.xoIox(jSONObject.optInt("height"));
        this.f27523ooXIXxIX.II0XooXoX(jSONObject.optDouble("age"));
        this.f27523ooXIXxIX.xxIXOIIO(jSONObject.optInt("gender"));
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void x0XOIxOo(String str, String str2) {
        super.x0XOIxOo(str, str2);
    }

    public void xoO0xx0(boolean z) {
        X0o0xo(IXxxXO.f27153IXO, IXxxXO.f27209oI, z);
    }
}
