package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class oIX0oI extends o00 {

    /* renamed from: oo, reason: collision with root package name */
    public int f27494oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f27495oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public float f27496ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public byte[] f27497xI;

    /* renamed from: com.vtrump.vtble.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C1101oIX0oI implements OXooXo.I0Io {
        public C1101oIX0oI() {
        }

        @Override // OXooXo.I0Io
        public void a() {
            Log.d("VTDeviceScaleAdvTM", "onFailure: ");
        }

        @Override // OXooXo.I0Io
        public void a(String str) {
            Oxx0xo.oIX0oI("VTDeviceScaleAdvTM", "decode，成功: " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("is_success") && jSONObject.getBoolean("is_success") && jSONObject.has("results")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("results");
                    oIX0oI.this.f27497xI = new byte[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        oIX0oI.this.f27497xI[i] = (byte) (((Integer) jSONArray.get(i)).intValue() & 255);
                    }
                    Oxx0xo.II0xO0("VTDeviceScaleAdvTM", xxX.XO(oIX0oI.this.f27497xI));
                    oIX0oI oix0oi = oIX0oI.this;
                    oix0oi.f27495oo0xXOI0I = (oix0oi.f27497xI[3] & 255) >> 4;
                    oIX0oI.this.f27496ooXIXxIX = ((r9.f27497xI[4] & 255) << 8) | (oIX0oI.this.f27497xI[5] & 255);
                    StringBuilder sb = new StringBuilder();
                    sb.append("pot: ");
                    sb.append(oIX0oI.this.f27495oo0xXOI0I);
                    sb.append(" mWeight: ");
                    sb.append(oIX0oI.this.f27496ooXIXxIX);
                    Oxx0xo.II0xO0("VTDeviceScaleAdvTM", sb.toString());
                    oIX0oI.this.f27496ooXIXxIX = (float) (r9.f27496ooXIXxIX / Math.pow(10.0d, oIX0oI.this.f27495oo0xXOI0I));
                    oIX0oI oix0oi2 = oIX0oI.this;
                    oix0oi2.f27494oo = ((oix0oi2.f27497xI[6] & 255) << 24) | ((oIX0oI.this.f27497xI[7] & 255) << 16) | ((oIX0oI.this.f27497xI[8] & 255) << 8) | (oIX0oI.this.f27497xI[9] & 255);
                    oIX0oI.this.I0oOoX(new IIX0o(r9.f27496ooXIXxIX, oIX0oI.this.f27494oo, oIX0oI.this.f27495oo0xXOI0I, oIX0oI.this.xOoOIoI()));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public oIX0oI(BluetoothDevice bluetoothDevice, Context context, XIxXXX0x0 xIxXXX0x0) {
        super(bluetoothDevice, context);
        OX00O0xII(xIxXXX0x0);
    }

    public final void OX00O0xII(XIxXXX0x0 xIxXXX0x0) {
        String Oxx0xo2 = xxX.Oxx0xo(xIxXXX0x0.II0xO0());
        Oxx0xo.II0xO0("VTDeviceScaleAdvTM", Oxx0xo2);
        xX0IIXIx0(Oxx0xo2.substring(6));
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        super.ox(jSONObject);
        byte[] bArr = this.f27497xI;
        if (bArr == null) {
            Log.e("VTDeviceScaleAdvTM", "setmUserInfo:mData == null ");
            return;
        }
        byte[] bArr2 = new byte[18];
        bArr2[0] = -1;
        bArr2[1] = -2;
        System.arraycopy(bArr, 0, bArr2, 2, 2);
        byte[] OOXIXo2 = xxX.OOXIXo(Oo().getAddress());
        System.arraycopy(OOXIXo2, 0, bArr2, 4, OOXIXo2.length);
        byte[] bArr3 = this.f27497xI;
        System.arraycopy(bArr3, 2, bArr2, 10, bArr3.length - 2);
        ScaleUserInfo scaleUserInfo = new ScaleUserInfo();
        scaleUserInfo.xoIox(jSONObject.optInt("height"));
        scaleUserInfo.II0XooXoX(jSONObject.optDouble("age"));
        scaleUserInfo.xxIXOIIO(jSONObject.optInt("gender"));
        XX(Ix0x.II0XooXoX.X0IIOO(1002).IIX0o(scaleUserInfo, this.f27496ooXIXxIX, this.f27494oo, "tmadv"), scaleUserInfo, bArr2, this.f27497xI, this.f27495oo0xXOI0I, 1002, "tmadv", "");
    }

    public boolean xOoOIoI() {
        return true;
    }

    public final void xX0IIXIx0(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("payload");
        stringBuffer.append("=");
        stringBuffer.append(str);
        Oxx0xo.oIX0oI("VTDeviceScaleAdvTM", "decode: payload: " + stringBuffer.toString());
        new OXooXo.oIX0oI("device_data_decrypt", stringBuffer.toString(), new C1101oIX0oI()).execute(new Void[0]);
    }
}
