package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.SDKInitializer;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class XO extends o00 {

    /* renamed from: IoOoX, reason: collision with root package name */
    public String f27435IoOoX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public String f27436Xx000oIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public String f27437oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public String f27438oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f27439oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public ScaleUserInfo f27440ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public int f27441xI;

    /* loaded from: classes13.dex */
    public class oIX0oI implements OXooXo.I0Io {
        public oIX0oI() {
        }

        @Override // OXooXo.I0Io
        public void a() {
            Log.d("VTDeviceScaleCompConnTM", "onFailure: ");
            XO.this.xoO0xx0(31, "verify failed");
        }

        @Override // OXooXo.I0Io
        public void a(String str) {
            XO xo2;
            int i;
            String str2;
            Log.d("VTDeviceScaleCompConnTM", "getCipherFromServer，成功: " + str);
            try {
                if (TextUtils.isEmpty(str)) {
                    XO.this.xoO0xx0(32, SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
                    return;
                }
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("is_success")) {
                    if (jSONObject.getBoolean("is_success")) {
                        if (jSONObject.getString("results").equalsIgnoreCase(XO.this.f27436Xx000oIo)) {
                            XO.this.xoO0xx0(30, "verify success");
                            XO.this.IIxOXoOo0();
                            return;
                        }
                        return;
                    }
                    int i2 = jSONObject.getInt("err_code");
                    StringBuilder sb = new StringBuilder();
                    sb.append("verify ,,err_code ");
                    sb.append(i2);
                    Log.d("VTDeviceScaleCompConnTM", sb.toString());
                    if (i2 == 10009) {
                        xo2 = XO.this;
                        i = 33;
                        str2 = "invilde device";
                    } else {
                        xo2 = XO.this;
                        i = 31;
                        str2 = "verify failed";
                    }
                    xo2.xoO0xx0(i, str2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public XO(BluetoothDevice bluetoothDevice, Context context) {
        super(bluetoothDevice, context);
        this.f27441xI = 2;
        this.f27439oo0xXOI0I = 0;
        this.f27438oo = "";
        this.f27435IoOoX = "";
        this.f27437oOXoIIIo = "";
        this.f27438oo = bluetoothDevice.getAddress();
    }

    private void xOOOX(byte[] bArr) {
        IIX0o iIX0o;
        if (bArr == null) {
            Log.i("VTDeviceScaleCompConnTM", " data is null");
            return;
        }
        OIoxIx.X0o0xo II0xO02 = ooXIXxIX.II0xO0(bArr, 2001, null, null);
        double Oxx0xo2 = II0xO02.Oxx0xo();
        double IXxxXO2 = II0xO02.IXxxXO();
        if (II0xO02.xoIox() == 170) {
            if (this.f27439oo0xXOI0I != 0) {
                return;
            }
            ScaleUserInfo scaleUserInfo = this.f27440ooXIXxIX;
            if (scaleUserInfo == null) {
                iIX0o = new IIX0o(Oxx0xo2, IXxxXO2, this.f27441xI, false);
            } else {
                XX(Ix0x.II0XooXoX.X0IIOO(1002).IIX0o(this.f27440ooXIXxIX, II0xO02.Oxx0xo(), II0xO02.IXxxXO(), "comp-conn"), scaleUserInfo, II0xO02.xxIXOIIO(), bArr, this.f27441xI, 1002, "comp-conn", "");
                this.f27439oo0xXOI0I++;
                return;
            }
        } else {
            this.f27439oo0xXOI0I = 0;
            iIX0o = new IIX0o(Oxx0xo2, IXxxXO2, this.f27441xI, false);
        }
        I0oOoX(iIX0o);
    }

    @Override // com.vtrump.vtble.o00
    public void IIxOXoOo0() {
        super.IIxOXoOo0();
        byte[] bArr = {-32, 31, 0};
        Log.d("VTDeviceScaleCompConnTM", "writeImApp: " + xxX.IIXOooo(bArr));
        xII(IXxxXO.f27250xoXoI, IXxxXO.f27206o00, bArr, true);
    }

    public void XIXIX() {
        if (TextUtils.isEmpty(this.f27438oo) || TextUtils.isEmpty(this.f27435IoOoX) || TextUtils.isEmpty(this.f27437oOXoIIIo)) {
            return;
        }
        String lowerCase = this.f27438oo.replace(":", "").toLowerCase();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("mac");
        stringBuffer.append("=");
        stringBuffer.append(lowerCase);
        stringBuffer.append("&");
        stringBuffer.append("chip_id");
        stringBuffer.append("=");
        stringBuffer.append(this.f27435IoOoX);
        stringBuffer.append("&");
        stringBuffer.append("random_str");
        stringBuffer.append("=");
        stringBuffer.append(this.f27437oOXoIIIo);
        Oxx0xo.oIX0oI("VTDeviceScaleCompConnTM", "getCipherFromServer: " + stringBuffer.toString());
        new OXooXo.oIX0oI("device_check", stringBuffer.toString(), new oIX0oI()).execute(new Void[0]);
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void oOoXoXO(String str, String str2, byte[] bArr) {
        if (IXxxXO.f27168O0xOxO.equalsIgnoreCase(str2)) {
            xOOOX(bArr);
        }
        if (IXxxXO.f27179OxI.equalsIgnoreCase(str2)) {
            if (bArr.length == 15) {
                byte[] bArr2 = new byte[12];
                System.arraycopy(bArr, 3, bArr2, 0, 12);
                this.f27435IoOoX = xxX.o00(bArr2);
                Oxx0xo.oIX0oI("VTDeviceScaleCompConnTM", "getMCU:成功 uniqueId " + this.f27435IoOoX);
                XIXIX();
                return;
            }
            if (bArr.length == 20) {
                byte[] bArr3 = new byte[16];
                System.arraycopy(bArr, 4, bArr3, 0, 16);
                this.f27436Xx000oIo = xxX.o00(bArr3);
                Oxx0xo.oIX0oI("VTDeviceScaleCompConnTM", "getCipherFromDevice:成功 " + this.f27436Xx000oIo);
                oXIO0o0XI();
            }
        }
    }

    public void oXIO0o0XI() {
        byte[] bArr = {-28, 27, 0};
        Oxx0xo.oIX0oI("VTDeviceScaleCompConnTM", "getMCU: " + xxX.IIXOooo(bArr));
        if (xII(IXxxXO.f27250xoXoI, IXxxXO.f27206o00, bArr, true)) {
            return;
        }
        xoO0xx0(31, "verify failed");
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        if (this.f27440ooXIXxIX == null) {
            this.f27440ooXIXxIX = new ScaleUserInfo();
        }
        this.f27440ooXIXxIX.xoIox(jSONObject.optInt("height"));
        this.f27440ooXIXxIX.II0XooXoX(jSONObject.optDouble("age"));
        this.f27440ooXIXxIX.xxIXOIIO(jSONObject.optInt("gender"));
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void x0XOIxOo(String str, String str2) {
        super.x0XOIxOo(str, str2);
    }

    public void xX0IIXIx0(boolean z) {
        X0o0xo(IXxxXO.f27250xoXoI, IXxxXO.f27168O0xOxO, z);
        X0o0xo(IXxxXO.f27250xoXoI, IXxxXO.f27179OxI, z);
    }

    public final void xoO0xx0(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            jSONObject.put("data", "");
            jSONObject.put("msg", str);
            oXoXxOo.II0xO0 iI0xO0 = this.f27478XxX0x0xxx;
            if (iI0xO0 != null) {
                iI0xO0.a(jSONObject.toString());
            } else {
                Log.d("VTDeviceScaleCompConnTM", "makeCallback: callback is null ");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
