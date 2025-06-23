package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class II0xO0 extends o00 {

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f27128IoOoX;

    /* renamed from: oo, reason: collision with root package name */
    public int f27129oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f27130oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public float f27131ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public byte[] f27132xI;

    public II0xO0(BluetoothDevice bluetoothDevice, Context context, XIxXXX0x0 xIxXXX0x0) {
        super(bluetoothDevice, context);
        this.f27131ooXIXxIX = 0.0f;
        this.f27128IoOoX = 2;
        byte[] II0xO02 = xIxXXX0x0.II0xO0();
        this.f27132xI = II0xO02;
        this.f27129oo = II0xO02[8];
        this.f27131ooXIXxIX = (((II0xO02[10] & 255) << 8) | (II0xO02[11] & 255)) / 100.0f;
        this.f27130oo0xXOI0I = (II0xO02[13] & 255) | ((II0xO02[12] & 255) << 8);
        Oxx0xo.oIX0oI("VTDeviceScaleAdvWY", "VTDeviceScaleAdvWY: W:" + this.f27131ooXIXxIX + ",R: " + this.f27130oo0xXOI0I);
    }

    public final byte[] OX00O0xII() {
        byte oxoX2 = (byte) Oxx0xo().oxoX();
        byte I0Io2 = (byte) Oxx0xo().I0Io();
        byte II0xO02 = (byte) Oxx0xo().II0xO0();
        byte X0o0xo2 = (byte) Oxx0xo().X0o0xo();
        byte[] bArr = this.f27132xI;
        return new byte[]{-1, -1, 48, oxoX2, I0Io2, II0xO02, X0o0xo2, bArr[14], bArr[15], bArr[16], bArr[17], bArr[18], bArr[19], TransportLayerPacket.SYNC_WORD, 2, 0, 0, bArr[10], bArr[11], bArr[12], bArr[13]};
    }

    public boolean ooOx() {
        return this.f27129oo == 5 && this.f27475X0IIOO;
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("height");
        double optDouble = jSONObject.optDouble("age");
        int optInt2 = jSONObject.optInt("gender");
        if (!ooOx() || xXxxox0I.oIX0oI().I0Io(Oo().getAddress(), this.f27131ooXIXxIX)) {
            return;
        }
        XX(Ix0x.II0XooXoX.X0IIOO(1005).IIX0o(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27131ooXIXxIX, this.f27130oo0xXOI0I, "wy"), new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), OX00O0xII(), this.f27132xI, 2, 1005, "wy", "");
    }

    public void xoO0xx0() {
        if (!ooOx()) {
            xXxxox0I.oIX0oI().II0xO0(Oo().getAddress());
        }
        I0oOoX(new IIX0o(this.f27131ooXIXxIX, this.f27130oo0xXOI0I, 2, ooOx()));
    }
}
