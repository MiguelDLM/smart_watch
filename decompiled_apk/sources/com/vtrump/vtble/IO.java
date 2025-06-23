package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class IO extends o00 {

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public OIoxIx.X0o0xo f27138ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public int f27139xI;

    public IO(BluetoothDevice bluetoothDevice, Context context, XIxXXX0x0 xIxXXX0x0) {
        super(bluetoothDevice, context);
        this.f27139xI = 2;
        this.f27138ooXIXxIX = ooXIXxIX.II0xO0(xIxXXX0x0.II0xO0(), 2002, null, null);
    }

    public void OX00O0xII() {
        double IXxxXO2 = this.f27138ooXIXxIX.IXxxXO();
        if (IXxxXO2 == 65535.0d) {
            IXxxXO2 = XIXIX.OOXIXo.f3760XO;
        }
        double d = IXxxXO2;
        if (!ooOx() && !xoO0xx0()) {
            xXxxox0I.oIX0oI().II0xO0(Oo().getAddress());
        }
        I0oOoX(new IIX0o(this.f27138ooXIXxIX.Oxx0xo(), d, this.f27139xI, ooOx()));
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
        byte[] oxoX2 = oIX0oI2.oxoX();
        if (Oxx0xo().II0xO0() == 16) {
            OIoxIx.X0o0xo II0xO02 = ooXIXxIX.II0xO0(oxoX2, 2002, null, null);
            XX(Ix0x.II0XooXoX.X0IIOO(1002).IIX0o(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), II0xO02.Oxx0xo(), II0xO02.IXxxXO(), "comp-acc 10"), new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), II0xO02.xxIXOIIO(), II0xO02.Oo(), this.f27139xI, 1002, "comp-acc 10", "");
            OIoxIx.II0xO0.oxoX().II0xO0();
            Log.i("getReportByDataId", "dataId is cleared");
        }
    }

    public boolean ooOx() {
        return this.f27138ooXIXxIX.xoIox() == 170 && this.f27475X0IIOO;
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("height");
        double optDouble = jSONObject.optDouble("age");
        int optInt2 = jSONObject.optInt("gender");
        if (ooOx()) {
            if (xXxxox0I.oIX0oI().I0Io(Oo().getAddress(), this.f27138ooXIXxIX.Oxx0xo())) {
                return;
            }
            if (Oxx0xo().II0xO0() == 16) {
                String uuid = UUID.randomUUID().toString();
                OIoxIx.II0xO0.oxoX().I0Io(new OIoxIx.oIX0oI().II0xO0(uuid).I0Io(this.f27138ooXIXxIX.Oo()).oIX0oI(Oxx0xo().II0xO0()).X0o0xo(Oxx0xo().X0o0xo()));
                XX(Ix0x.II0XooXoX.X0IIOO(1002).IIX0o(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27138ooXIXxIX.Oxx0xo(), this.f27138ooXIXxIX.IXxxXO(), "comp-acc 10"), new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27138ooXIXxIX.xxIXOIIO(), this.f27138ooXIXxIX.Oo(), this.f27139xI, 1002, "comp-acc 10", uuid);
                return;
            } else {
                xoXoI.OOXIxO0().x0o(true);
                Oxx0xo.I0Io("twoleg:", "=" + this.f27138ooXIXxIX.IXxxXO());
                XX(Ix0x.II0XooXoX.X0IIOO(1004).XIxXXX0x0(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27138ooXIXxIX.Oxx0xo(), 0, (int) this.f27138ooXIXxIX.IXxxXO(), 0, 0, 0, 0, false).IIX0o(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27138ooXIXxIX.Oxx0xo(), this.f27138ooXIXxIX.IXxxXO(), "comp-acc 0e"), new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27138ooXIXxIX.xxIXOIIO(), this.f27138ooXIXxIX.Oo(), this.f27139xI, 1004, "comp-acc 0e", "");
                return;
            }
        }
        if (xoO0xx0() && !xXxxox0I.oIX0oI().I0Io(Oo().getAddress(), this.f27138ooXIXxIX.Oxx0xo()) && Oxx0xo().II0xO0() == 16) {
            XX(Ix0x.II0XooXoX.X0IIOO(100).XxX0x0xxx(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27138ooXIXxIX.Oxx0xo()), new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27138ooXIXxIX.xxIXOIIO(), this.f27138ooXIXxIX.Oo(), this.f27139xI, 1002, "comp-acc 10", "");
        }
    }

    public boolean xoO0xx0() {
        return this.f27138ooXIXxIX.xoIox() == 187 && this.f27475X0IIOO;
    }
}
