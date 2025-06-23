package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import java.util.ArrayList;
import java.util.List;
import okio.Utf8;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class II0XooXoX extends o00 {

    /* renamed from: oo, reason: collision with root package name */
    public int f27124oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public List<byte[]> f27125oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public ScaleUserInfo f27126ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public double f27127xI;

    public II0XooXoX(BluetoothDevice bluetoothDevice, Context context) {
        super(bluetoothDevice, context);
        this.f27125oo0xXOI0I = new ArrayList();
        this.f27124oo = 2;
    }

    private void OX00O0xII(byte[] bArr) {
        if (bArr == null) {
            Oxx0xo.I0Io("VTDeviceScaleFat12", " data is null");
            return;
        }
        int i = bArr[3] & 255;
        if (i == 209) {
            double ooOx2 = ooOx(bArr[4], bArr[5]);
            Oxx0xo.oIX0oI("VTDeviceScaleFat12", "just weight = " + ooOx2);
            I0oOoX(new IIX0o(ooOx2, XIXIX.OOXIXo.f3760XO, this.f27124oo, false));
            return;
        }
        if (i == 210) {
            List<byte[]> list = this.f27125oo0xXOI0I;
            if (list != null && list.size() == 0) {
                this.f27125oo0xXOI0I.add(bArr);
            }
            this.f27127xI = ooOx(bArr[4], bArr[5]);
            byte[] bArr2 = this.f27125oo0xXOI0I.get(0);
            I0oOoX(new IIX0o(this.f27127xI, (bArr2[6] == -1 && bArr2[7] == -1 && bArr2[8] == -1) ? 0 : ((r1 & 255) << 16) | ((r3 & 255) << 8) | (r10 & 255), this.f27124oo, true));
        }
    }

    private void xOOOX() {
        Oxx0xo.oIX0oI("VTDeviceScaleFat12", "setScaleFinalWeightAck: ");
        try {
            Thread.sleep(50L);
            xII(IXxxXO.f27156IoIOOxIIo, IXxxXO.f27207o0oIxOo, xX0IIXIx0(), false);
            Thread.sleep(50L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void oOoXoXO(String str, String str2, byte[] bArr) {
        super.oOoXoXO(str, str2, bArr);
        if (IXxxXO.f27156IoIOOxIIo.equalsIgnoreCase(str) && IXxxXO.f27226oxIIX0o.equalsIgnoreCase(str2)) {
            OX00O0xII(bArr);
        }
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void ooOOo0oXI(String str, String str2, byte[] bArr) {
        super.ooOOo0oXI(str, str2, bArr);
        if (IXxxXO.f27156IoIOOxIIo.equalsIgnoreCase(str) && IXxxXO.f27226oxIIX0o.equalsIgnoreCase(str2)) {
            OX00O0xII(bArr);
        }
    }

    public final double ooOx(byte b, byte b2) {
        int i = (b >> 6) & 3;
        double d = (((b & Utf8.REPLACEMENT_BYTE) << 8) | (b2 & 255)) / 10.0d;
        return i == 1 ? d / 2.0d : i == 2 ? OxxIIOOXO.ooOOo0oXI(d) : d;
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        ScaleUserInfo scaleUserInfo = new ScaleUserInfo();
        this.f27126ooXIXxIX = scaleUserInfo;
        scaleUserInfo.xoIox(jSONObject.optInt("height"));
        this.f27126ooXIXxIX.II0XooXoX(jSONObject.optDouble("age"));
        this.f27126ooXIXxIX.xxIXOIIO(jSONObject.optInt("gender"));
        Log.d("VTDeviceScaleFat12", "setmUserInfo: ");
        List<byte[]> list = this.f27125oo0xXOI0I;
        if (list == null || list.size() != 1) {
            return;
        }
        byte[] bArr = this.f27125oo0xXOI0I.get(0);
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
        byte[] OxxIIOOXO2 = xxX.OxxIIOOXO(xxX.I0Io(this.f27127xI, 10));
        byte b7 = OxxIIOOXO2[0];
        byte b8 = OxxIIOOXO2[1];
        byte b9 = OxxIIOOXO2[2];
        byte b10 = OxxIIOOXO2[3];
        byte b11 = bArr[6];
        byte b12 = bArr[7];
        byte b13 = bArr[8];
        xOOOX();
        XX(Ix0x.II0XooXoX.X0IIOO(1002).IIX0o(this.f27126ooXIXxIX, this.f27127xI, ((b11 & 255) << 16) | ((b12 & 255) << 8) | (b13 & 255), "fat12"), new ScaleUserInfo().II0XooXoX(this.f27126ooXIXxIX.II0xO0()).xoIox(this.f27126ooXIXxIX.oxoX()).xxIXOIIO(this.f27126ooXIXxIX.I0Io()), new byte[]{-1, -1, -2, oxoX2, I0Io2, II0xO02, X0o0xo2, b, b2, b3, b4, b5, b6, TransportLayerPacket.SYNC_WORD, 1, b7, b8, b9, b10, b11, b12, b13}, bArr, this.f27124oo, 1002, "fat12", "");
        this.f27125oo0xXOI0I.clear();
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void x0XOIxOo(String str, String str2) {
        super.x0XOIxOo(str, str2);
    }

    public final byte[] xX0IIXIx0() {
        return new byte[]{90, 4, 38, -46, -16, TransportLayerPacket.SYNC_WORD};
    }

    public void xoO0xx0(boolean z) {
        X0o0xo(IXxxXO.f27156IoIOOxIIo, IXxxXO.f27226oxIIX0o, z);
    }
}
