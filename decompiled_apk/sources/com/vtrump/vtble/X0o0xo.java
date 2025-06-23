package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class X0o0xo extends o00 {

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f27423oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public ScaleUserInfo f27424ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public int f27425xI;

    public X0o0xo(BluetoothDevice bluetoothDevice, Context context) {
        super(bluetoothDevice, context);
        this.f27425xI = 2;
        this.f27423oo0xXOI0I = 0;
    }

    public void OX00O0xII() {
        X0IIOO(IXxxXO.f27141I0Io, IXxxXO.f27228oxoX);
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void oOoXoXO(String str, String str2, byte[] bArr) {
        if (IXxxXO.f27141I0Io.equalsIgnoreCase(str) && IXxxXO.f27228oxoX.equalsIgnoreCase(str2)) {
            xoO0xx0(bArr);
            Oxx0xo.oIX0oI("VTDeviceScaleCompConn", "dataChangedNotify: " + xxX.IIXOooo(bArr));
        }
        super.oOoXoXO(str, str2, bArr);
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void ooOOo0oXI(String str, String str2, byte[] bArr) {
        if (IXxxXO.f27141I0Io.equalsIgnoreCase(str) && IXxxXO.f27228oxoX.equalsIgnoreCase(str2)) {
            xoO0xx0(bArr);
        }
        super.ooOOo0oXI(str, str2, bArr);
    }

    public void ooOx(boolean z) {
        X0o0xo(IXxxXO.f27141I0Io, IXxxXO.f27228oxoX, z);
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        if (this.f27424ooXIXxIX == null) {
            this.f27424ooXIXxIX = new ScaleUserInfo();
        }
        this.f27424ooXIXxIX.xoIox(jSONObject.optInt("height"));
        this.f27424ooXIXxIX.II0XooXoX(jSONObject.optDouble("age"));
        this.f27424ooXIXxIX.xxIXOIIO(jSONObject.optInt("gender"));
    }

    public final void xoO0xx0(byte[] bArr) {
        IIX0o iIX0o;
        if (bArr == null) {
            Log.i("VTDeviceScaleCompConn", " data is null");
            return;
        }
        OIoxIx.X0o0xo II0xO02 = ooXIXxIX.II0xO0(bArr, 2001, null, null);
        double Oxx0xo2 = II0xO02.Oxx0xo();
        double IXxxXO2 = II0xO02.IXxxXO();
        if (IXxxXO2 == -1.0d) {
            IXxxXO2 = XIXIX.OOXIXo.f3760XO;
        }
        if (II0xO02.xoIox() == 170) {
            if (this.f27423oo0xXOI0I != 0) {
                return;
            }
            ScaleUserInfo scaleUserInfo = this.f27424ooXIXxIX;
            if (scaleUserInfo == null) {
                iIX0o = new IIX0o(Oxx0xo2, IXxxXO2, this.f27425xI, false);
            } else {
                XX(Ix0x.II0XooXoX.X0IIOO(0).IIX0o(this.f27424ooXIXxIX, II0xO02.Oxx0xo(), II0xO02.IXxxXO(), "comp-conn"), scaleUserInfo, II0xO02.xxIXOIIO(), bArr, this.f27425xI, 0, "comp-conn", "");
                this.f27423oo0xXOI0I++;
                return;
            }
        } else {
            this.f27423oo0xXOI0I = 0;
            iIX0o = new IIX0o(Oxx0xo2, IXxxXO2, this.f27425xI, false);
        }
        I0oOoX(iIX0o);
    }
}
