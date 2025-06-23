package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.vtrump.vtble.Scale.ScaleInfo;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class I0oOoX extends o00 {

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public static final String f27118oOXoIIIo = "z";

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f27119IoOoX;

    /* renamed from: oo, reason: collision with root package name */
    public byte[] f27120oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f27121oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public int f27122ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public float f27123xI;

    public I0oOoX(BluetoothDevice bluetoothDevice, Context context, XIxXXX0x0 xIxXXX0x0) {
        super(bluetoothDevice, context);
        float f;
        byte[] II0xO02 = xIxXXX0x0.II0xO0();
        this.f27120oo = II0xO02;
        ooOx(II0xO02[13] & 255);
        byte[] bArr = this.f27120oo;
        int i = bArr[14] & 255;
        this.f27119IoOoX = i;
        float f2 = ((bArr[15] & 255) << 24) | ((bArr[16] & 255) << 16) | ((bArr[17] & 255) << 8) | (bArr[18] & 255);
        this.f27123xI = f2;
        if (i != 1) {
            f = i == 2 ? 100.0f : 10.0f;
            this.f27121oo0xXOI0I = (bArr[20] & 255) | ((bArr[19] & 255) << 8);
            Oxx0xo.oIX0oI(f27118oOXoIIIo, "VTDeviceSicScale, type: " + this.f27122ooXIXxIX + ", weight: " + this.f27123xI + ", mRvalue: " + this.f27121oo0xXOI0I + ",accuracy=" + this.f27119IoOoX);
        }
        this.f27123xI = f2 / f;
        this.f27121oo0xXOI0I = (bArr[20] & 255) | ((bArr[19] & 255) << 8);
        Oxx0xo.oIX0oI(f27118oOXoIIIo, "VTDeviceSicScale, type: " + this.f27122ooXIXxIX + ", weight: " + this.f27123xI + ", mRvalue: " + this.f27121oo0xXOI0I + ",accuracy=" + this.f27119IoOoX);
    }

    public boolean OX00O0xII() {
        return xoO0xx0() == 170 && this.f27475X0IIOO;
    }

    public void ooOx(int i) {
        this.f27122ooXIXxIX = i;
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("height");
        double optDouble = jSONObject.optDouble("age");
        int optInt2 = jSONObject.optInt("gender");
        if (!OX00O0xII() || xXxxox0I.oIX0oI().I0Io(Oo().getAddress(), this.f27123xI)) {
            return;
        }
        ScaleInfo IIX0o2 = Ix0x.II0XooXoX.X0IIOO(1000).IIX0o(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27123xI, this.f27121oo0xXOI0I, "advsic");
        ScaleUserInfo xoIox2 = new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt);
        byte[] bArr = this.f27120oo;
        XX(IIX0o2, xoIox2, bArr, bArr, this.f27119IoOoX, 1000, "advsic", "");
    }

    public void xX0IIXIx0() {
        if (!OX00O0xII()) {
            xXxxox0I.oIX0oI().II0xO0(Oo().getAddress());
        }
        I0oOoX(new IIX0o(this.f27123xI, this.f27121oo0xXOI0I, this.f27119IoOoX, OX00O0xII()));
    }

    public int xoO0xx0() {
        return this.f27122ooXIXxIX;
    }
}
