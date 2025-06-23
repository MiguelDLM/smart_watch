package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class x0o extends o00 {

    /* renamed from: IoOoX, reason: collision with root package name */
    public boolean f27544IoOoX;

    /* renamed from: oo, reason: collision with root package name */
    public int f27545oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public byte[] f27546oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public double f27547ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public double f27548xI;

    public x0o(BluetoothDevice bluetoothDevice, Context context, XIxXXX0x0 xIxXXX0x0) {
        super(bluetoothDevice, context);
        double d;
        double d2;
        this.f27545oo = 2;
        this.f27546oo0xXOI0I = xIxXXX0x0.II0xO0();
        Oxx0xo.oIX0oI("VTDeviceScaleAdvAccDR", "VTDeviceScaleAdvAccDR: " + xxX.IIXOooo(this.f27546oo0xXOI0I));
        int i = (this.f27546oo0xXOI0I[0] & 255) >> 4;
        if (i == 13) {
            this.f27544IoOoX = false;
        }
        if (i == 14) {
            this.f27544IoOoX = true;
        }
        this.f27547ooXIXxIX = (r6[2] & 255) | ((r6[1] & 255) << 8);
        if (OX00O0xII()) {
            d = this.f27547ooXIXxIX;
            d2 = 100.0d;
        } else {
            d = this.f27547ooXIXxIX;
            d2 = 10.0d;
        }
        this.f27547ooXIXxIX = d / d2;
        byte[] bArr = this.f27546oo0xXOI0I;
        this.f27548xI = (bArr[4] & 255) | ((bArr[3] & 255) << 8);
        Oxx0xo.oIX0oI("VTDeviceScaleAdvAccDR", " dr, isFinal: " + this.f27544IoOoX + ", mRvalue: " + this.f27548xI + ", weight: " + this.f27547ooXIXxIX);
    }

    private byte[] xX0IIXIx0() {
        int I0Io2;
        byte[] bArr = new byte[21];
        bArr[0] = -1;
        bArr[1] = -1;
        bArr[2] = 48;
        bArr[3] = (byte) Oxx0xo().oxoX();
        bArr[4] = (byte) Oxx0xo().I0Io();
        bArr[5] = (byte) Oxx0xo().II0xO0();
        bArr[6] = (byte) Oxx0xo().X0o0xo();
        byte[] OOXIXo2 = xxX.OOXIXo(Oo().getAddress());
        bArr[7] = OOXIXo2[0];
        bArr[8] = OOXIXo2[1];
        bArr[9] = OOXIXo2[2];
        bArr[10] = OOXIXo2[3];
        bArr[11] = OOXIXo2[4];
        bArr[12] = OOXIXo2[5];
        bArr[13] = TransportLayerPacket.SYNC_WORD;
        if (OX00O0xII()) {
            bArr[14] = 2;
            I0Io2 = xxX.I0Io(this.f27547ooXIXxIX, 100);
        } else {
            bArr[14] = 1;
            I0Io2 = xxX.I0Io(this.f27547ooXIXxIX, 10);
        }
        byte[] OxxIIOOXO2 = xxX.OxxIIOOXO(I0Io2);
        bArr[15] = OxxIIOOXO2[0];
        bArr[16] = OxxIIOOXO2[1];
        bArr[17] = OxxIIOOXO2[2];
        bArr[18] = OxxIIOOXO2[3];
        byte[] bArr2 = this.f27546oo0xXOI0I;
        bArr[19] = bArr2[5];
        bArr[20] = bArr2[6];
        return bArr;
    }

    public final boolean OX00O0xII() {
        return "da".equals(Oo().getName());
    }

    public boolean ooOx() {
        return this.f27544IoOoX && this.f27475X0IIOO;
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("height");
        double optDouble = jSONObject.optDouble("age");
        int optInt2 = jSONObject.optInt("gender");
        if (!this.f27544IoOoX || xXxxox0I.oIX0oI().I0Io(Oo().getAddress(), this.f27547ooXIXxIX)) {
            return;
        }
        XX(Ix0x.II0XooXoX.X0IIOO(1002).IIX0o(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27547ooXIXxIX, this.f27548xI, "acc"), new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), xX0IIXIx0(), this.f27546oo0xXOI0I, this.f27545oo, 1002, "acc", "");
    }

    public void xoO0xx0() {
        if (!ooOx()) {
            xXxxox0I.oIX0oI().II0xO0(Oo().getAddress());
        }
        I0oOoX(new IIX0o(this.f27547ooXIXxIX, this.f27548xI, this.f27545oo, this.f27544IoOoX));
    }
}
