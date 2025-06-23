package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import com.vtrump.vtble.b.b;
import java.util.Calendar;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class x0XOIxOo extends o00 {

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public boolean f27541oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public ScaleUserInfo f27542ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public boolean f27543xI;

    public x0XOIxOo(BluetoothDevice bluetoothDevice, Context context) {
        super(bluetoothDevice, context);
        this.f27541oo0xXOI0I = false;
    }

    private byte[] OX00O0xII(ScaleUserInfo scaleUserInfo) {
        Oxx0xo.oIX0oI("VTDeviceScaleXHF", "packageDownData: ");
        Calendar calendar = Calendar.getInstance();
        byte[] bArr = {-54, 16, 14, 1, (byte) (calendar.get(1) - 2000), (byte) (calendar.get(2) + 1), (byte) calendar.get(5), (byte) calendar.get(10), (byte) calendar.get(12), (byte) calendar.get(13), 0, 0, 0, 1, (byte) ((scaleUserInfo.I0Io() + 1) % 2), (byte) scaleUserInfo.II0xO0(), Integer.valueOf(scaleUserInfo.oxoX()).byteValue(), xxX.x0xO0oo(bArr, 1, 16), 0, 0};
        return bArr;
    }

    private void xoO0xx0(byte[] bArr) {
        if (this.f27543xI) {
            return;
        }
        if (bArr == null) {
            Log.i("VTDeviceScaleXHF", " data is null");
            return;
        }
        Oxx0xo.oIX0oI("VTDeviceScaleXHF", "onScaleDataReceived: " + xxX.Oxx0xo(bArr));
        int i = bArr[3] & 255;
        byte b = bArr[4];
        boolean z = (b & 1) == 1;
        int i2 = b & 6;
        int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 : 2 : 0 : 1;
        double pow = (((bArr[5] & 255) << 8) | (bArr[6] & 255)) / Math.pow(10.0d, i3);
        if (!z) {
            I0oOoX(new IIX0o(pow, XIXIX.OOXIXo.f3760XO, i3, false));
        }
        if (i == 1) {
            ScaleUserInfo scaleUserInfo = this.f27542ooXIXxIX;
            if (scaleUserInfo == null) {
                I0oOoX(new IIX0o(pow, XIXIX.OOXIXo.f3760XO, i3, false));
                return;
            } else {
                if (!z || this.f27543xI) {
                    return;
                }
                XX(Ix0x.II0XooXoX.X0IIOO(1009).xxX(this.f27542ooXIXxIX, bArr).IIX0o(this.f27542ooXIXxIX, pow, 100.0d, "xhf"), new ScaleUserInfo().II0XooXoX(this.f27542ooXIXxIX.II0xO0()).xoIox(this.f27542ooXIXxIX.oxoX()).xxIXOIIO(scaleUserInfo.I0Io()), bArr, bArr, i3, 1009, "xhf", "");
                this.f27543xI = true;
                return;
            }
        }
        I0oOoX(new IIX0o(pow, XIXIX.OOXIXo.f3760XO, i3, false));
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void oOoXoXO(String str, String str2, byte[] bArr) {
        super.oOoXoXO(str, str2, bArr);
        xoO0xx0(bArr);
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void ooOOo0oXI(String str, String str2, byte[] bArr) {
        super.ooOOo0oXI(str, str2, bArr);
    }

    public void ooOx(boolean z) {
        X0o0xo(IXxxXO.f27165O0IxXx, IXxxXO.f27159IoXIXo, z);
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        Oxx0xo.oIX0oI("VTDeviceScaleXHF", "setmUserInfo: ");
        ScaleUserInfo scaleUserInfo = new ScaleUserInfo();
        this.f27542ooXIXxIX = scaleUserInfo;
        scaleUserInfo.xoIox(jSONObject.optInt("height"));
        this.f27542ooXIXxIX.II0XooXoX(jSONObject.optDouble("age"));
        this.f27542ooXIXxIX.xxIXOIIO(jSONObject.optInt("gender"));
        ScaleUserInfo scaleUserInfo2 = this.f27542ooXIXxIX;
        if (scaleUserInfo2 == null) {
            new b("your userinfo is null");
            return;
        }
        if (!this.f27541oo0xXOI0I) {
            xII(IXxxXO.f27165O0IxXx, IXxxXO.f27255xxOXOOoIX, OX00O0xII(scaleUserInfo2), true);
            this.f27541oo0xXOI0I = true;
        } else {
            Oxx0xo.oIX0oI("VTDeviceScaleXHF", "isWrite: " + this.f27541oo0xXOI0I);
        }
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void x0XOIxOo(String str, String str2) {
        super.x0XOIxOo(str, str2);
    }
}
