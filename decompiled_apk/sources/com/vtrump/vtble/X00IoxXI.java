package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import okio.Utf8;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class X00IoxXI extends o00 {

    /* renamed from: IO, reason: collision with root package name */
    public static final String f27410IO = "r";

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f27411IoOoX;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public String f27412X00IoxXI;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public String f27413Xx000oIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public int f27414oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public byte[] f27415oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public double f27416oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public int f27417ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public double f27418xI;

    public X00IoxXI(BluetoothDevice bluetoothDevice, Context context, XIxXXX0x0 xIxXXX0x0) {
        super(bluetoothDevice, context);
        double oO2;
        this.f27414oOXoIIIo = 2;
        this.f27413Xx000oIo = "T277MJC7NJ0J76C2";
        this.f27412X00IoxXI = "OLOV2XDTGBQIUC8H";
        byte[] II0xO02 = xIxXXX0x0.II0xO0();
        this.f27415oo = II0xO02;
        ooOx(II0xO02[0] & 255);
        byte[] bArr = this.f27415oo;
        byte b = bArr[1];
        int i = (b >> 6) & 3;
        this.f27411IoOoX = i;
        double d = (bArr[2] & 255) | ((b & Utf8.REPLACEMENT_BYTE) << 8);
        this.f27418xI = d;
        if (i == 0) {
            this.f27418xI = d / 10.0d;
        } else {
            if (i == 2) {
                oO2 = OxxIIOOXO.ooOOo0oXI(d);
            } else {
                oO2 = i == 3 ? OxxIIOOXO.oO(d) : oO2;
            }
            this.f27418xI = oO2;
        }
        byte[] bArr2 = this.f27415oo;
        this.f27416oo0xXOI0I = (bArr2[6] & 255) | ((bArr2[5] & 255) << 8);
        Oxx0xo.oIX0oI(f27410IO, "VTDeviceScaleAdvAcc, type: " + this.f27417ooXIXxIX + ", mRvalue: " + this.f27416oo0xXOI0I + ", unit: " + this.f27411IoOoX + ", weight: " + this.f27418xI);
    }

    public boolean OX00O0xII() {
        return xoO0xx0() == 221 && this.f27475X0IIOO;
    }

    public void ooOx(int i) {
        this.f27417ooXIXxIX = i;
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("height");
        double optDouble = jSONObject.optDouble("age");
        int optInt2 = jSONObject.optInt("gender");
        if (!OX00O0xII() || xXxxox0I.oIX0oI().I0Io(Oo().getAddress(), this.f27418xI)) {
            return;
        }
        if (this.f27413Xx000oIo.equals(xoXoI.OOXIxO0().IIxOXoOo0())) {
            XX(Ix0x.II0XooXoX.X0IIOO(1013).IIX0o(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27418xI, this.f27416oo0xXOI0I, "acc"), new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), xOOOX(), this.f27415oo, this.f27414oOXoIIIo, 1013, "acc", "");
        } else if (this.f27412X00IoxXI.equals(xoXoI.OOXIxO0().IIxOXoOo0())) {
            XX(Ix0x.II0XooXoX.X0IIOO(1014).IIX0o(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27418xI, this.f27416oo0xXOI0I, "acc"), new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), xOOOX(), this.f27415oo, this.f27414oOXoIIIo, 1014, "acc", "");
        } else {
            XX(Ix0x.II0XooXoX.X0IIOO(1002).IIX0o(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27418xI, this.f27416oo0xXOI0I, "acc"), new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), xOOOX(), this.f27415oo, this.f27414oOXoIIIo, 1002, "acc", "");
        }
    }

    public final byte[] xOOOX() {
        byte oxoX2 = (byte) Oxx0xo().oxoX();
        byte I0Io2 = (byte) Oxx0xo().I0Io();
        byte II0xO02 = (byte) Oxx0xo().II0xO0();
        byte X0o0xo2 = (byte) Oxx0xo().X0o0xo();
        byte[] OOXIXo2 = xxX.OOXIXo(Oo().getAddress());
        byte b = OOXIXo2[0];
        byte b2 = OOXIXo2[1];
        byte b3 = OOXIXo2[2];
        byte b4 = OOXIXo2[3];
        byte b5 = OOXIXo2[4];
        byte b6 = OOXIXo2[5];
        byte[] OxxIIOOXO2 = xxX.OxxIIOOXO(xxX.I0Io(this.f27418xI, 10));
        byte b7 = OxxIIOOXO2[0];
        byte b8 = OxxIIOOXO2[1];
        byte b9 = OxxIIOOXO2[2];
        byte b10 = OxxIIOOXO2[3];
        byte[] bArr = this.f27415oo;
        return new byte[]{-1, -1, 48, oxoX2, I0Io2, II0xO02, X0o0xo2, b, b2, b3, b4, b5, b6, TransportLayerPacket.SYNC_WORD, 1, b7, b8, b9, b10, bArr[5], bArr[6]};
    }

    public void xX0IIXIx0() {
        if (this.f27416oo0xXOI0I == 65535.0d) {
            this.f27416oo0xXOI0I = XIXIX.OOXIXo.f3760XO;
        }
        if (!OX00O0xII()) {
            xXxxox0I.oIX0oI().II0xO0(Oo().getAddress());
        }
        I0oOoX(new IIX0o(this.f27418xI, (int) this.f27416oo0xXOI0I, this.f27414oOXoIIIo, OX00O0xII()));
    }

    public int xoO0xx0() {
        return this.f27417ooXIXxIX;
    }
}
