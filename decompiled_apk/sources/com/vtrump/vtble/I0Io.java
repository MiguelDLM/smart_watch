package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class I0Io extends o00 {

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public OIoxIx.X0o0xo f27117ooXIXxIX;

    public I0Io(BluetoothDevice bluetoothDevice, Context context, XIxXXX0x0 xIxXXX0x0) {
        super(bluetoothDevice, context);
        this.f27117ooXIXxIX = ooXIXxIX.II0xO0(xIxXXX0x0.II0xO0(), 2002, null, null);
    }

    public void OX00O0xII() {
        double IXxxXO2 = this.f27117ooXIXxIX.IXxxXO();
        if (IXxxXO2 == 65535.0d) {
            IXxxXO2 = XIXIX.OOXIXo.f3760XO;
        }
        double d = IXxxXO2;
        if (!ooOx() && !xoO0xx0()) {
            xXxxox0I.oIX0oI().II0xO0(Oo().getAddress());
        }
        I0oOoX(new IIX0o(this.f27117ooXIXxIX.Oxx0xo(), d, 1, ooOx()));
    }

    public boolean ooOx() {
        return this.f27117ooXIXxIX.xoIox() == 170 && this.f27475X0IIOO;
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
            if (xXxxox0I.oIX0oI().I0Io(Oo().getAddress(), this.f27117ooXIXxIX.Oxx0xo())) {
                return;
            }
            xoXoI.OOXIxO0().oXX0IoI();
            XX(Ix0x.II0XooXoX.X0IIOO(1020).OI0(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27117ooXIXxIX.Oxx0xo(), this.f27117ooXIXxIX.IXxxXO()).IIX0o(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27117ooXIXxIX.Oxx0xo(), this.f27117ooXIXxIX.IXxxXO(), "wiseda"), new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27117ooXIXxIX.Oo(), this.f27117ooXIXxIX.Oo(), this.f27117ooXIXxIX.oIX0oI(), 1020, "wiseda", "");
            return;
        }
        if (!xoO0xx0() || xXxxox0I.oIX0oI().I0Io(Oo().getAddress(), this.f27117ooXIXxIX.Oxx0xo())) {
            return;
        }
        xoXoI.OOXIxO0().oXX0IoI();
        XX(Ix0x.II0XooXoX.X0IIOO(100).XxX0x0xxx(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27117ooXIXxIX.Oxx0xo()), new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), this.f27117ooXIXxIX.Oo(), this.f27117ooXIXxIX.Oo(), this.f27117ooXIXxIX.oIX0oI(), 1020, "wiseda", "");
    }

    public boolean xoO0xx0() {
        return this.f27117ooXIXxIX.xoIox() == 187 && this.f27475X0IIOO;
    }
}
