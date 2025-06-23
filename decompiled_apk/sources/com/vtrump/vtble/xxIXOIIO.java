package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class xxIXOIIO extends o00 {

    /* renamed from: I0oOoX, reason: collision with root package name */
    public String f27610I0oOoX;

    /* renamed from: IO, reason: collision with root package name */
    public byte[] f27611IO;

    /* renamed from: Io, reason: collision with root package name */
    public int f27612Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f27613IoOoX;

    /* renamed from: OI0, reason: collision with root package name */
    public byte[] f27614OI0;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public byte[] f27615X00IoxXI;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public boolean f27616XOxIOxOx;

    /* renamed from: XX, reason: collision with root package name */
    public String f27617XX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public int f27618Xx000oIo;

    /* renamed from: o0, reason: collision with root package name */
    public int f27619o0;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public byte[] f27620oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public int f27621oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public double f27622oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public ScaleUserInfo f27623ooXIXxIX;

    /* renamed from: x0o, reason: collision with root package name */
    public byte[] f27624x0o;

    /* renamed from: xI, reason: collision with root package name */
    public int f27625xI;

    /* renamed from: xII, reason: collision with root package name */
    public byte[] f27626xII;

    public xxIXOIIO(BluetoothDevice bluetoothDevice, Context context) {
        super(bluetoothDevice, context);
        this.f27613IoOoX = 2;
        this.f27615X00IoxXI = new byte[]{-32, 3, -4, 1, 0, 0, 0, 30};
        this.f27611IO = new byte[]{-32, 3, -4, 1, 0, 0, 0, 30};
        this.f27626xII = new byte[]{-18, 3, -4, 1, 0, 0, 0, 16};
        this.f27612Io = 0;
        this.f27619o0 = 0;
        this.f27617XX = "/sdcard/AAAlepu/";
        this.f27610I0oOoX = "HRData_";
    }

    private byte[] xOOOX() {
        byte II0xO02 = (byte) Oxx0xo().II0xO0();
        byte X0o0xo2 = (byte) Oxx0xo().X0o0xo();
        byte[] OOXIXo2 = xxX.OOXIXo(Oo().getAddress());
        byte b = OOXIXo2[0];
        byte b2 = OOXIXo2[1];
        byte b3 = OOXIXo2[2];
        byte b4 = OOXIXo2[3];
        byte b5 = OOXIXo2[4];
        byte b6 = OOXIXo2[5];
        byte[] bArr = this.f27620oOXoIIIo;
        return new byte[]{-1, -2, II0xO02, X0o0xo2, b, b2, b3, b4, b5, b6, TransportLayerPacket.SYNC_WORD, bArr[3], bArr[4], bArr[5], bArr[6], bArr[7], bArr[8], bArr[9]};
    }

    private void xoO0xx0(byte[] bArr) {
        double d;
        int i = bArr[2] & 255;
        this.f27625xI = i;
        int i2 = bArr[3] >> 4;
        double d2 = ((bArr[4] & 255) << 8) | (bArr[5] & 255);
        this.f27622oo0xXOI0I = d2;
        if (i2 != 0) {
            if (i2 != 1) {
                d = i2 == 2 ? 100.0d : 10.0d;
            }
            this.f27622oo0xXOI0I = d2 / d;
        }
        int i3 = ((bArr[6] & 255) << 24) | ((bArr[7] & 255) << 16) | ((bArr[8] & 255) << 8) | (bArr[9] & 255);
        this.f27621oo = i3;
        if (i == 160 || i == 176) {
            this.f27618Xx000oIo = 0;
            I0oOoX(new IIX0o(this.f27622oo0xXOI0I, i3, i2, false));
        }
        int i4 = this.f27625xI;
        if (i4 == 170 || i4 == 187) {
            ScaleUserInfo scaleUserInfo = this.f27623ooXIXxIX;
            if (scaleUserInfo == null) {
                I0oOoX(new IIX0o(this.f27622oo0xXOI0I, this.f27621oo, i2, true));
            } else if (this.f27618Xx000oIo == 0) {
                XX(Ix0x.II0XooXoX.X0IIOO(0).IIX0o(this.f27623ooXIXxIX, this.f27622oo0xXOI0I, this.f27621oo, "lepu"), scaleUserInfo, xOOOX(), this.f27620oOXoIIIo, this.f27613IoOoX, 0, oI0IIXIo(), "");
                this.f27618Xx000oIo++;
            }
        }
    }

    public void OX00O0xII() {
        X0o0xo(IXxxXO.f27244xXoOI00O, IXxxXO.f27230x0, true);
    }

    public final void XIXIX() {
        byte[] bArr = this.f27614OI0;
        int i = (((bArr[1] & 255) << 8) | (bArr[0] & 255)) * 2;
        if (i <= bArr.length - 2) {
            byte[] bArr2 = new byte[i];
            this.f27624x0o = bArr2;
            System.arraycopy(bArr, 2, bArr2, 0, i);
            Log.d("VTDeviceScaleLepu", "parseHeartData: , len: " + i + ", 当前完整数据流水号： " + this.f27612Io);
            ooOx(0, "Wave data", this.f27612Io, this.f27624x0o);
            this.f27612Io = this.f27612Io + 1;
            this.f27614OI0 = xxX.oOoXoXO(this.f27614OI0, 0, i + 1);
        }
    }

    public final void oOo() {
        xII(IXxxXO.f27244xXoOI00O, IXxxXO.f27186X0xII0I, new byte[]{-18, 3, -4, 0, 0, 0, 0, xxX.x0xO0oo(new byte[]{-18, 3, -4, 0, 0, 0, 0}, 0, 6)}, true);
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void oOoXoXO(String str, String str2, byte[] bArr) {
        int i;
        String str3;
        if (bArr != null && (bArr[0] & 255) == 26 && (bArr[1] & 255) == 65) {
            this.f27620oOXoIIIo = bArr;
            oXIO0o0XI();
            xoO0xx0(bArr);
            return;
        }
        if (Arrays.equals(this.f27615X00IoxXI, bArr)) {
            i = 10;
            str3 = "Wave data is complete";
        } else if (Arrays.equals(this.f27626xII, bArr)) {
            oXIO0o0XI();
            i = 11;
            str3 = "Connector is off";
        } else {
            if (!Arrays.equals(this.f27611IO, bArr)) {
                if (this.f27616XOxIOxOx) {
                    this.f27619o0 = 255 & bArr[0];
                    Log.d("VTDeviceScaleLepu", "第一包：" + this.f27619o0);
                    this.f27616XOxIOxOx = false;
                } else {
                    int i2 = this.f27619o0 + 1;
                    this.f27619o0 = i2;
                    if (i2 > 255) {
                        this.f27619o0 = 0;
                    }
                    int i3 = 255 & bArr[0];
                    if (this.f27619o0 != i3) {
                        Log.d("VTDeviceScaleLepu", " 跳包了 ，" + this.f27619o0 + ", " + i3);
                        oOo();
                        oXIO0o0XI();
                        ooOx(1, "Communication error", 0, null);
                    }
                }
                int length = bArr.length - 1;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 1, bArr2, 0, length);
                this.f27614OI0 = xxX.ooOOo0oXI(this.f27614OI0, bArr2);
                XIXIX();
                return;
            }
            i = 12;
            str3 = "Test error";
        }
        ooOx(i, str3, 0, null);
    }

    public final void oXIO0o0XI() {
        this.f27612Io = 0;
        this.f27616XOxIOxOx = true;
    }

    public final void ooOx(int i, String str, int i2, byte[] bArr) {
        if (this.f27483xxX == null) {
            Log.d("VTDeviceScaleLepu", "VTHRDataCallback is null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(MapBundleKey.MapObjKey.OBJ_SL_INDEX, i2);
            jSONObject2.put("waveform", bArr == null ? "" : xxX.o00(bArr));
            jSONObject.put("code", i);
            jSONObject.put("msg", str);
            jSONObject.put("HRData", jSONObject2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.f27483xxX.oIX0oI(jSONObject.toString());
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        ScaleUserInfo scaleUserInfo = new ScaleUserInfo();
        this.f27623ooXIXxIX = scaleUserInfo;
        scaleUserInfo.xoIox(jSONObject.optInt("height"));
        this.f27623ooXIXxIX.II0XooXoX(jSONObject.optDouble("age"));
        this.f27623ooXIXxIX.xxIXOIIO(jSONObject.optInt("gender"));
    }

    @Override // com.vtrump.vtble.o00
    public void oxXx0IX() {
        super.oxXx0IX();
        xII(IXxxXO.f27244xXoOI00O, IXxxXO.f27186X0xII0I, new byte[]{1, 0, (byte) 1}, true);
    }

    public void xX0IIXIx0() {
        X0o0xo(IXxxXO.f27244xXoOI00O, IXxxXO.f27232x0OxxIOxX, true);
    }

    @Override // com.vtrump.vtble.o00
    public void xXOx(int i, oXoXxOo.oIX0oI oix0oi) {
        this.f27483xxX = oix0oi;
        Oxx0xo.oIX0oI("VTDeviceScaleLepu", "enableHRData:开启心率数据 ");
        x0o(IXxxXO.f27244xXoOI00O, IXxxXO.f27186X0xII0I, new byte[]{1, 1, (byte) 0}, true);
        byte b = (byte) (i >> 8);
        byte b2 = (byte) i;
        x0o(IXxxXO.f27244xXoOI00O, IXxxXO.f27186X0xII0I, new byte[]{2, b, b2, (byte) ((b ^ 2) ^ b2)}, true);
        x0o(IXxxXO.f27244xXoOI00O, IXxxXO.f27186X0xII0I, new byte[]{4, 1, 5}, true);
    }
}
