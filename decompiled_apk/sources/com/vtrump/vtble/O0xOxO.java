package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.vtrump.vtble.VTDevice;
import com.vtrump.vtble.VTDeviceToy;
import java.util.Calendar;

/* loaded from: classes13.dex */
public class O0xOxO extends VTDeviceToy {

    /* renamed from: xI, reason: collision with root package name */
    public static final String f27258xI = "VTDeviceSmv";

    /* renamed from: IIX0o, reason: collision with root package name */
    public II0xO0 f27259IIX0o;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public VTDevice.II0xO0 f27260ooXIXxIX;

    /* loaded from: classes13.dex */
    public static abstract class II0xO0 {
        public void oIX0oI(int i) {
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI extends VTDevice.II0xO0 {
        public oIX0oI() {
        }

        @Override // com.vtrump.vtble.VTDevice.II0xO0
        public void oIX0oI(int i) {
            super.oIX0oI(i);
            Oxx0xo.oIX0oI(O0xOxO.f27258xI, "onRssiReceived: rssi" + i);
            if (O0xOxO.this.f27259IIX0o != null) {
                O0xOxO.this.f27259IIX0o.oIX0oI(i);
            }
        }
    }

    public O0xOxO(BluetoothDevice bluetoothDevice, Context context) {
        super(bluetoothDevice, context);
        oIX0oI oix0oi = new oIX0oI();
        this.f27260ooXIXxIX = oix0oi;
        ooXIXxIX(oix0oi);
    }

    @Override // com.vtrump.vtble.VTDeviceToy
    public void I0oOoX() {
        super.I0oOoX();
        OoO(new byte[]{3, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    }

    @Override // com.vtrump.vtble.VTDeviceToy
    public void IIX0(int i) {
        OoO(new byte[]{6, 1, (byte) i});
    }

    @Override // com.vtrump.vtble.VTDeviceToy
    public void OO0x0xX() {
        super.OO0x0xX();
        OoO(new byte[]{4, 0});
    }

    @Override // com.vtrump.vtble.VTDeviceToy
    public void OOXIxO0(VTAlarm vTAlarm) {
        Calendar c = vTAlarm.getC();
        String str = f27258xI;
        Oxx0xo.II0xO0(str, "setAlarm: " + c.getTimeInMillis() + " , " + Calendar.getInstance().getTimeInMillis());
        if (c.getTimeInMillis() < Calendar.getInstance().getTimeInMillis()) {
            String format = String.format("{\"setAlarm\":%1$b}", Boolean.FALSE);
            Log.e(str, "setAlarm: The time is earlier than current");
            VTDeviceToy.oIX0oI oix0oi = this.f27404XxX0x0xxx;
            if (oix0oi != null) {
                oix0oi.oIX0oI(format);
                return;
            }
            return;
        }
        OoO(new byte[]{3, 10, (byte) (c.get(1) - 2000), (byte) (c.get(2) + 1), (byte) c.get(5), (byte) c.get(11), (byte) c.get(12), (byte) c.get(13), (byte) vTAlarm.getRing(), (byte) vTAlarm.getWk_time(), vTAlarm.isOpen() ? (byte) 1 : (byte) 0, (byte) vTAlarm.getRepeat_time()});
    }

    public final void OoO(byte[] bArr) {
        Oxx0xo.II0xO0(f27258xI, "writeData: " + xxX.IIXOooo(bArr));
        boolean z = true;
        if (!this.f27408xxX.equals(VTDeviceToy.VTChipSchemeType.VTSchemeTypeTI) && this.f27408xxX.equals(VTDeviceToy.VTChipSchemeType.VTSchemeTypeTL)) {
            z = false;
        }
        x0o(IXxxXO.f27248xoIxX, IXxxXO.f27235x0xO, bArr, z);
    }

    @Override // com.vtrump.vtble.VTDeviceToy
    public boolean Ox0O(byte b, byte b2, byte b3) {
        return super.Ox0O(b, b2, b3);
    }

    @Override // com.vtrump.vtble.VTDeviceToy
    public void XIXIX() {
        Calendar calendar = Calendar.getInstance();
        OoO(new byte[]{1, 6, (byte) (calendar.get(1) - 2000), (byte) (calendar.get(2) + 1), (byte) calendar.get(5), (byte) calendar.get(11), (byte) calendar.get(12), (byte) calendar.get(13)});
    }

    @Override // com.vtrump.vtble.VTDeviceToy
    public void XIo0oOXIx() {
        OoO(new byte[]{5, 0});
    }

    public boolean XXoOx0(boolean z, byte b, boolean z2, byte b2) {
        if (b > 100) {
            b = 100;
        }
        if (b2 > 100) {
            b2 = 100;
        }
        Oxx0xo.oIX0oI(f27258xI, "topcosales writeGroup, level0: " + ((int) b) + ", level1: " + ((int) b2));
        int i = z ? 0 : 128;
        byte b3 = IXxxXO.f27140I0;
        return xII(IXxxXO.f27172OO0x0xX, IXxxXO.f27192XIo0oOXIx, new byte[]{16, IXxxXO.f27147IIX0, 4, b3, b, 100, (byte) i, 4, b3, b2, 100, 1, 4, IXxxXO.f27249xoO0xx0, b2, 0, 0}, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x0176, code lost:
    
        if (r19[2] == 1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
    
        if (r19[2] == 1) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0193 A[Catch: JSONException -> 0x019b, TRY_LEAVE, TryCatch #1 {JSONException -> 0x019b, blocks: (B:22:0x018f, B:24:0x0193), top: B:21:0x018f }] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e2  */
    @Override // com.vtrump.vtble.VTDeviceToy, com.vtrump.vtble.VTDevice
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void oOoXoXO(java.lang.String r17, java.lang.String r18, byte[] r19) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vtrump.vtble.O0xOxO.oOoXoXO(java.lang.String, java.lang.String, byte[]):void");
    }

    @Override // com.vtrump.vtble.VTDeviceToy
    public void ox() {
        OoO(new byte[]{2, 0});
    }

    public void x0OIX00oO(II0xO0 iI0xO0) {
        this.f27259IIX0o = iI0xO0;
    }

    @Override // com.vtrump.vtble.VTDeviceToy
    public boolean xI0oxI00(byte b) {
        String IXxxXO2 = IXxxXO();
        if (IXxxXO2 != null && (((IXxxXO2.startsWith("R200") && Integer.parseInt(IXxxXO2.substring(10, 14)) < 8) || IXxxXO2.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) && b == 1)) {
            b = 0;
        }
        return super.xI0oxI00(b);
    }

    @Override // com.vtrump.vtble.VTDeviceToy
    public boolean xOoOIoI(byte b, byte b2) {
        String IXxxXO2 = IXxxXO();
        if (IXxxXO2 != null && (((IXxxXO2.startsWith("R200") && Integer.parseInt(IXxxXO2.substring(10, 14)) < 8) || IXxxXO2.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) && b == 1)) {
            b = 0;
        }
        return super.xOoOIoI(b, b2);
    }

    public O0xOxO(Context context) {
        super(context);
        oIX0oI oix0oi = new oIX0oI();
        this.f27260ooXIXxIX = oix0oi;
        ooXIXxIX(oix0oi);
    }
}
