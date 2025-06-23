package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import com.vtrump.vtble.Scale.ScaleInfo;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class xII extends o00 {

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public OIoxIx.X0o0xo f27549ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public int f27550xI;

    public xII(BluetoothDevice bluetoothDevice, Context context, XIxXXX0x0 xIxXXX0x0) {
        super(bluetoothDevice, context);
        this.f27550xI = 2;
        this.f27549ooXIXxIX = ooXIXxIX.II0xO0(xIxXXX0x0.II0xO0(), 2005, null, null);
    }

    @Override // com.vtrump.vtble.o00
    public void Xo0(String str, JSONObject jSONObject) {
        Oxx0xo.I0Io("", "cash data request");
        if (jSONObject == null) {
            return;
        }
        OIoxIx.oIX0oI oIX0oI2 = OIoxIx.II0xO0.oxoX().oIX0oI(str);
        if (oIX0oI2 == null) {
            Log.e("getReportByDataId", "dataId is cleared or not support");
            return;
        }
        int optInt = jSONObject.optInt("height");
        double optDouble = jSONObject.optDouble("age");
        int optInt2 = jSONObject.optInt("gender");
        OIoxIx.X0o0xo II0xO02 = ooXIXxIX.II0xO0(oIX0oI2.oxoX(), 2005, null, null);
        ScaleInfo IIX0o2 = Ix0x.II0XooXoX.X0IIOO(1004).XIxXXX0x0(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), II0xO02.Oxx0xo(), 0, (int) II0xO02.IXxxXO(), 0, 0, 0, 0, false).IIX0o(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), II0xO02.Oxx0xo(), II0xO02.IXxxXO(), "comp-hr.27");
        IIX0o2.XIo0oOXIx(II0xO02.ooOOo0oXI());
        XX(IIX0o2, new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), II0xO02.xxIXOIIO(), II0xO02.Oo(), this.f27550xI, 1004, "comp-hr.27", "");
        OIoxIx.II0xO0.oxoX().II0xO0();
        Log.i("getReportByDataId", "dataId is cleared");
    }

    public boolean ooOx() {
        return this.f27549ooXIXxIX.xoIox() == 170 && this.f27475X0IIOO;
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("height");
        double optDouble = jSONObject.optDouble("age");
        int optInt2 = jSONObject.optInt("gender");
        if (!ooOx() || xXxxox0I.oIX0oI().I0Io(Oo().getAddress(), this.f27549ooXIXxIX.Oxx0xo())) {
            return;
        }
        Oxx0xo.I0Io("twoleg:", "=" + this.f27549ooXIXxIX.IXxxXO());
        String uuid = UUID.randomUUID().toString();
        OIoxIx.II0xO0.oxoX().I0Io(new OIoxIx.oIX0oI().II0xO0(uuid).I0Io(this.f27549ooXIXxIX.Oo()).oIX0oI(Oxx0xo().II0xO0()).X0o0xo(Oxx0xo().X0o0xo()));
        ScaleInfo IIX0o2 = Ix0x.II0XooXoX.X0IIOO(1004).XIxXXX0x0(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27549ooXIXxIX.Oxx0xo(), 0, (int) this.f27549ooXIXxIX.IXxxXO(), 0, 0, 0, 0, false).IIX0o(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27549ooXIXxIX.Oxx0xo(), this.f27549ooXIXxIX.IXxxXO(), "comp-hr.27");
        IIX0o2.XIo0oOXIx(this.f27549ooXIXxIX.ooOOo0oXI());
        XX(IIX0o2, new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27549ooXIXxIX.xxIXOIIO(), this.f27549ooXIXxIX.Oo(), this.f27550xI, 1004, "comp-hr.27", uuid);
    }

    public void xoO0xx0() {
        double IXxxXO2 = this.f27549ooXIXxIX.IXxxXO();
        if (IXxxXO2 == 65535.0d) {
            IXxxXO2 = XIXIX.OOXIXo.f3760XO;
        }
        double d = IXxxXO2;
        if (!ooOx()) {
            xXxxox0I.oIX0oI().II0xO0(Oo().getAddress());
        }
        I0oOoX(new IIX0o(this.f27549ooXIXxIX.Oxx0xo(), d, this.f27550xI, ooOx()));
    }
}
