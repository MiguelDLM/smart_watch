package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import com.vtrump.vtble.b.b;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class Oxx0IOOO extends o00 {

    /* renamed from: xI, reason: collision with root package name */
    public static final String f27277xI = "I";

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public ScaleUserInfo f27278ooXIXxIX;

    public Oxx0IOOO(BluetoothDevice bluetoothDevice, Context context) {
        super(bluetoothDevice, context);
    }

    public final int[] OX00O0xII(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int[] iArr = new int[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            iArr[i] = bArr[i] & 255;
        }
        return iArr;
    }

    public final float XIXIX(byte[] bArr) {
        if (bArr == null || bArr.length < 5) {
            return 0.0f;
        }
        int[] OX00O0xII2 = OX00O0xII(bArr);
        return (float) (((((OX00O0xII2[1] * 16777216) + (OX00O0xII2[2] * 65536)) + (OX00O0xII2[3] * 256)) + OX00O0xII2[4]) / Math.pow(10.0d, OX00O0xII2[0] & 15));
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void oOoXoXO(String str, String str2, byte[] bArr) {
        if (IXxxXO.f27141I0Io.equalsIgnoreCase(str) && IXxxXO.f27228oxoX.equalsIgnoreCase(str2)) {
            Oxx0xo.II0xO0(f27277xI, "dataChangedNotify: " + xxX.XO(bArr));
            xOOOX(bArr);
        }
        super.oOoXoXO(str, str2, bArr);
    }

    public void oXIO0o0XI() {
        X0IIOO(IXxxXO.f27141I0Io, IXxxXO.f27228oxoX);
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void ooOOo0oXI(String str, String str2, byte[] bArr) {
        if (IXxxXO.f27141I0Io.equalsIgnoreCase(str) && IXxxXO.f27228oxoX.equalsIgnoreCase(str2)) {
            Oxx0xo.II0xO0(f27277xI, "dataReadNotify:" + xxX.XO(bArr));
            xOOOX(bArr);
        }
        super.ooOOo0oXI(str, str2, bArr);
    }

    public void ooOx(boolean z) {
        X0o0xo(IXxxXO.f27141I0Io, IXxxXO.f27228oxoX, z);
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        Oxx0xo.oIX0oI(f27277xI, "setmUserInfo:AAAA ");
        ScaleUserInfo scaleUserInfo = new ScaleUserInfo();
        this.f27278ooXIXxIX = scaleUserInfo;
        scaleUserInfo.xoIox(jSONObject.optInt("height"));
        this.f27278ooXIXxIX.II0XooXoX(jSONObject.optDouble("age"));
        this.f27278ooXIXxIX.xxIXOIIO(jSONObject.optInt("gender"));
        ScaleUserInfo scaleUserInfo2 = this.f27278ooXIXxIX;
        if (scaleUserInfo2 != null) {
            xII(IXxxXO.f27141I0Io, IXxxXO.f27185X0o0xo, xoO0xx0(scaleUserInfo2), true);
        } else {
            new b("your userinfo is null");
        }
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void x0XOIxOo(String str, String str2) {
        super.x0XOIxOo(str, str2);
    }

    public final void xOOOX(byte[] bArr) {
        if (bArr == null) {
            Log.i(f27277xI, " data is null");
            return;
        }
        if ((bArr[0] & 240) == 16) {
            I0oOoX(new IIX0o(XIXIX(bArr), XIXIX.OOXIXo.f3760XO, 1, false));
            return;
        }
        if (bArr.length > 4 && bArr[2] == 0 && bArr[3] == 0) {
            if (bArr.length > 5) {
                I0oOoX(new IIX0o((((bArr[4] & 255) << 8) | (bArr[5] & 255)) / 10.0d, XIXIX.OOXIXo.f3760XO, 1, false));
                return;
            }
            return;
        }
        int I0Io2 = this.f27278ooXIXxIX.I0Io();
        double II0xO02 = this.f27278ooXIXxIX.II0xO0();
        XX(Ix0x.II0XooXoX.X0IIOO(1007).xxX(this.f27278ooXIXxIX, bArr).IIX0o(this.f27278ooXIXxIX, (((bArr[4] & 255) << 8) | (bArr[5] & 255)) / 10.0d, 100.0d, "fc"), new ScaleUserInfo().II0XooXoX(II0xO02).xxIXOIIO(I0Io2).xoIox(this.f27278ooXIXxIX.oxoX()), xX0IIXIx0(bArr), bArr, 1, 1007, "fc", "");
    }

    public final byte[] xX0IIXIx0(byte[] bArr) {
        X0IIOO Oxx0xo2 = Oxx0xo();
        byte[] OOXIXo2 = xxX.OOXIXo(Oo().getAddress());
        byte[] bArr2 = {-1, -3, -2, (byte) Oxx0xo2.oxoX(), (byte) Oxx0xo2.I0Io(), (byte) Oxx0xo2.II0xO0(), (byte) Oxx0xo2.X0o0xo(), OOXIXo2[0], OOXIXo2[1], OOXIXo2[2], OOXIXo2[3], OOXIXo2[4], OOXIXo2[5], TransportLayerPacket.SYNC_WORD, 1};
        System.arraycopy(bArr, 4, bArr2, 15, 13);
        return bArr2;
    }

    public final byte[] xoO0xx0(ScaleUserInfo scaleUserInfo) {
        byte[] bArr = new byte[5];
        bArr[0] = 16;
        bArr[1] = 0;
        if (xxX.xxIXOIIO(scaleUserInfo)) {
            bArr[2] = 0;
            bArr[3] = 20;
            bArr[4] = TransportLayerPacket.SYNC_WORD;
        } else {
            bArr[2] = (byte) scaleUserInfo.I0Io();
            bArr[3] = (byte) scaleUserInfo.II0xO0();
            bArr[4] = Integer.valueOf(scaleUserInfo.oxoX()).byteValue();
        }
        return bArr;
    }
}
