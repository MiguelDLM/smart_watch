package com.vtrump.vtble;

import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class oxoX extends o00 {

    /* renamed from: IoOoX, reason: collision with root package name */
    public double f27533IoOoX;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public byte[] f27534X00IoxXI;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public int f27535Xx000oIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public double f27536oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public int f27537oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f27538oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public byte[] f27539ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public int f27540xI;

    /* JADX WARN: Removed duplicated region for block: B:14:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public oxoX(android.bluetooth.BluetoothDevice r18, android.content.Context r19, com.vtrump.vtble.XIxXXX0x0 r20) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vtrump.vtble.oxoX.<init>(android.bluetooth.BluetoothDevice, android.content.Context, com.vtrump.vtble.XIxXXX0x0):void");
    }

    private byte[] OX00O0xII() {
        byte oxoX2 = (byte) Oxx0xo().oxoX();
        byte I0Io2 = (byte) Oxx0xo().I0Io();
        byte II0xO02 = (byte) Oxx0xo().II0xO0();
        byte X0o0xo2 = (byte) Oxx0xo().X0o0xo();
        byte[] bArr = this.f27534X00IoxXI;
        byte b = bArr[9];
        byte b2 = bArr[10];
        byte b3 = bArr[11];
        byte b4 = bArr[12];
        byte b5 = bArr[13];
        byte b6 = bArr[14];
        int i = this.f27538oo0xXOI0I;
        byte b7 = (byte) i;
        byte[] OxxIIOOXO2 = xxX.OxxIIOOXO(xxX.I0Io(this.f27533IoOoX, (int) Math.pow(10.0d, i)));
        byte b8 = OxxIIOOXO2[0];
        byte b9 = OxxIIOOXO2[1];
        byte b10 = OxxIIOOXO2[2];
        byte b11 = OxxIIOOXO2[3];
        byte[] bArr2 = this.f27539ooXIXxIX;
        return new byte[]{-1, -1, 48, oxoX2, I0Io2, II0xO02, X0o0xo2, b, b2, b3, b4, b5, b6, TransportLayerPacket.SYNC_WORD, b7, b8, b9, b10, b11, bArr2[4], bArr2[5]};
    }

    public boolean ooOx() {
        return this.f27540xI == 1 && this.f27475X0IIOO;
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("height");
        double optDouble = jSONObject.optDouble("age");
        int optInt2 = jSONObject.optInt("gender");
        if (!ooOx() || xXxxox0I.oIX0oI().I0Io(Oo().getAddress(), this.f27533IoOoX)) {
            return;
        }
        int II0xO02 = Oxx0xo().II0xO0();
        int i = 22 == II0xO02 ? 1000 : 32 == II0xO02 ? 1002 : 0;
        Oxx0xo.oIX0oI("VTDeviceScaleAdvXHSic", "setmUserInfo:cal " + i);
        XX(Ix0x.II0XooXoX.X0IIOO(i).IIX0o(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27533IoOoX, this.f27536oOXoIIIo, "advxhsic"), new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), OX00O0xII(), this.f27539ooXIXxIX, this.f27538oo0xXOI0I, i, "advxhsic", "");
    }

    public void xoO0xx0() {
        if (!ooOx()) {
            xXxxox0I.oIX0oI().II0xO0(Oo().getAddress());
        }
        I0oOoX(new IIX0o(this.f27533IoOoX, this.f27536oOXoIIIo, this.f27538oo0xXOI0I, ooOx()));
    }
}
