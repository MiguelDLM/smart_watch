package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import com.vtrump.vtble.Scale.ScaleInfo;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class o0 extends o00 {

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f27465IoOoX;

    /* renamed from: oo, reason: collision with root package name */
    public int f27466oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public double f27467oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public byte[] f27468ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public byte f27469xI;

    public o0(BluetoothDevice bluetoothDevice, Context context, XIxXXX0x0 xIxXXX0x0) {
        super(bluetoothDevice, context);
        if (xIxXXX0x0.I0Io() == 14) {
            this.f27468ooXIXxIX = xIxXXX0x0.II0xO0();
            Log.e("VTDeviceScaleAdvHS", "VTDeviceScaleAdvHS: " + xxX.IIXOooo(this.f27468ooXIXxIX));
            byte[] bArr = this.f27468ooXIXxIX;
            this.f27469xI = bArr[7];
            this.f27467oo0xXOI0I = ((double) (((bArr[8] & 255) << 8) | (bArr[9] & 255))) / 10.0d;
            this.f27466oo = ((bArr[10] & 255) << 8) | (bArr[11] & 255);
            this.f27465IoOoX = bArr[12] & 255;
        }
    }

    public boolean ooOx() {
        return (this.f27469xI & 255) == 170 && this.f27475X0IIOO;
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("height");
        double optDouble = jSONObject.optDouble("age");
        int optInt2 = jSONObject.optInt("gender");
        if (!ooOx() || xXxxox0I.oIX0oI().I0Io(Oo().getAddress(), this.f27467oo0xXOI0I)) {
            return;
        }
        xoXoI.OOXIxO0().oXX0IoI();
        Log.e("VTDeviceScaleAdvHS", "setmUserInfo:mRvalue " + this.f27466oo);
        ScaleInfo IIX0o2 = Ix0x.II0XooXoX.X0IIOO(1002).IIX0o(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27467oo0xXOI0I, (double) this.f27466oo, "hs");
        ScaleUserInfo xoIox2 = new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt);
        byte[] bArr = this.f27468ooXIXxIX;
        XX(IIX0o2, xoIox2, bArr, bArr, 1, 1002, "hs", "");
    }

    public void xoO0xx0() {
        if (this.f27466oo == 65535) {
            this.f27466oo = 0;
        }
        if (!ooOx()) {
            xXxxox0I.oIX0oI().II0xO0(Oo().getAddress());
        }
        I0oOoX(new IIX0o(this.f27467oo0xXOI0I, this.f27466oo, 1, ooOx()));
    }
}
