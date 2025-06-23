package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.vtrump.vtble.Scale.ScaleInfo;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class XX extends o00 {

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public static final String f27453Xx000oIo = "y";

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f27454IoOoX;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public byte[] f27455oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public float f27456oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public float f27457oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public int f27458ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public float f27459xI;

    public XX(BluetoothDevice bluetoothDevice, Context context, XIxXXX0x0 xIxXXX0x0) {
        super(bluetoothDevice, context);
        float f;
        this.f27454IoOoX = 0;
        byte[] II0xO02 = xIxXXX0x0.II0xO0();
        this.f27455oOXoIIIo = II0xO02;
        ooOx(II0xO02[13] & 255);
        this.f27454IoOoX = this.f27455oOXoIIIo[14] & 255;
        String str = f27453Xx000oIo;
        Oxx0xo.oIX0oI(str, "accuracy: " + this.f27454IoOoX);
        byte[] bArr = this.f27455oOXoIIIo;
        float f2 = (float) (((bArr[15] & 255) << 24) | ((bArr[16] & 255) << 16) | ((bArr[17] & 255) << 8) | (bArr[18] & 255));
        this.f27459xI = f2;
        int i = this.f27454IoOoX;
        if (i != 1) {
            f = i == 2 ? 100.0f : 10.0f;
            this.f27457oo0xXOI0I = ((bArr[19] & 255) << 8) | (bArr[20] & 255);
            this.f27456oo = (bArr[22] & 255) | ((bArr[21] & 255) << 8);
            Oxx0xo.oIX0oI(str, "VTDeviceSicScale, type: " + this.f27458ooXIXxIX + ", weight: " + this.f27459xI + ", mRvalue: " + this.f27457oo0xXOI0I);
        }
        this.f27459xI = f2 / f;
        this.f27457oo0xXOI0I = ((bArr[19] & 255) << 8) | (bArr[20] & 255);
        this.f27456oo = (bArr[22] & 255) | ((bArr[21] & 255) << 8);
        Oxx0xo.oIX0oI(str, "VTDeviceSicScale, type: " + this.f27458ooXIXxIX + ", weight: " + this.f27459xI + ", mRvalue: " + this.f27457oo0xXOI0I);
    }

    public boolean OX00O0xII() {
        return xoO0xx0() == 170 && this.f27475X0IIOO;
    }

    public void ooOx(int i) {
        this.f27458ooXIXxIX = i;
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("height");
        double optDouble = jSONObject.optDouble("age");
        int optInt2 = jSONObject.optInt("gender");
        if (!OX00O0xII() || xXxxox0I.oIX0oI().I0Io(Oo().getAddress(), this.f27459xI)) {
            return;
        }
        ScaleInfo xXxxox0I2 = Ix0x.II0XooXoX.X0IIOO(1003).xXxxox0I(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27459xI, this.f27457oo0xXOI0I, this.f27456oo, "knm");
        ScaleUserInfo xoIox2 = new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt);
        byte[] bArr = this.f27455oOXoIIIo;
        XX(xXxxox0I2, xoIox2, bArr, bArr, this.f27454IoOoX, 1003, "knm", "");
    }

    public void xX0IIXIx0() {
        if (!OX00O0xII()) {
            xXxxox0I.oIX0oI().II0xO0(Oo().getAddress());
        }
        I0oOoX(new IIX0o(this.f27459xI, this.f27457oo0xXOI0I, this.f27454IoOoX, OX00O0xII()));
    }

    public int xoO0xx0() {
        return this.f27458ooXIXxIX;
    }
}
