package com.sma.smartv3.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class ElectricQuantityUtils {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f24202I0Io = 10;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f24203II0xO0 = 20;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final ElectricQuantityUtils f24204oIX0oI = new ElectricQuantityUtils();

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f24205oxoX = 100;

    public final String I0Io(Context context) {
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.xIx()) {
            String string = context.getString(R.string.ring);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(string);
            return string;
        }
        if (!productManager.xxxI() && !ProductManager.xOOxIO(productManager, null, 1, null)) {
            String string2 = context.getString(R.string.watch);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(string2);
            return string2;
        }
        String string3 = context.getString(R.string.headphones);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(string3);
        return string3;
    }

    public final int II0xO0(int i) {
        if (i == 100) {
            Xo0 xo0 = Xo0.f24349oIX0oI;
            if (xo0.XO().getBoolean(XoI0Ixx0.f24391OOOI, false)) {
                return 0;
            }
            xo0.XO().put(XoI0Ixx0.f24391OOOI, true);
            return 100;
        }
        if (10 <= i && i < 20) {
            Xo0 xo02 = Xo0.f24349oIX0oI;
            if (xo02.XO().getBoolean(XoI0Ixx0.f24457oo00, false)) {
                return 0;
            }
            xo02.XO().put(XoI0Ixx0.f24457oo00, true);
            return 20;
        }
        if (1 > i || i >= 10) {
            return 0;
        }
        Xo0 xo03 = Xo0.f24349oIX0oI;
        if (xo03.XO().getBoolean(XoI0Ixx0.f24401OxXXx0X, false)) {
            return 0;
        }
        xo03.XO().put(XoI0Ixx0.f24401OxXXx0X, true);
        return 10;
    }

    public final void X0o0xo(int i) {
        if (i != 100) {
            Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24391OOOI, false);
        }
        if (20 <= i && i < 100) {
            Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24457oo00, false);
        }
        if (i > 10) {
            Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24401OxXXx0X, false);
        }
    }

    public final void XO(Activity activity, View view, String str, int i) {
        final com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(activity, R.layout.pop_power_hint);
        String string = activity.getString(R.string.battery_low, str);
        kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
        xoI0Ixx0.Xx000oIo(string);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(org.apache.log4j.helpers.x0XOIxOo.f33309xxIXOIIO);
        xoI0Ixx0.oo(activity.getString(R.string.battery_level_low, str, sb.toString(), str));
        com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, null, null, 2, null);
        xoI0Ixx0.x0o(R.string.game_detail_guidance_knew, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.util.ElectricQuantityUtils$showMeasurementCompletePopup$mMeasurementCompletePopup$1$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Boolean invoke() {
                com.sma.smartv3.pop.XoI0Ixx0.this.dismiss();
                return Boolean.TRUE;
            }
        });
        xoI0Ixx0.xoXoI(view);
    }

    public final void oIX0oI(@OXOo.OOXIXo Context context, int i, @OXOo.OOXIXo View rootView) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        kotlin.jvm.internal.IIX0o.x0xO0oo(rootView, "rootView");
        int II0xO02 = II0xO0(i);
        if (II0xO02 != 0) {
            String I0Io2 = I0Io(context);
            String oxoX2 = oxoX(context, II0xO02, I0Io2);
            I0oOIX.oIX0oI(context);
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(org.apache.log4j.helpers.x0XOIxOo.f33309xxIXOIIO);
            String string = context.getString(R.string.electric_quantity, I0Io2, sb.toString());
            kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
            I0oOIX.II0xO0(context, string, oxoX2);
            String valueOf = String.valueOf(II0xO02);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            sb2.append(org.apache.log4j.helpers.x0XOIxOo.f33309xxIXOIIO);
            LogUtils.i("battery_low1", valueOf, sb2.toString(), I0Io2);
            if (II0xO02 == 10 || II0xO02 == 20) {
                XO((Activity) context, rootView, I0Io2, i);
            }
        }
        X0o0xo(i);
    }

    public final String oxoX(Context context, int i, String str) {
        if (i != 10) {
            if (i != 20) {
                if (i != 100) {
                    String string = context.getString(R.string.too_low_hint, str);
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(string);
                    return string;
                }
                String string2 = context.getString(R.string.fully_charged, str);
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(string2);
                return string2;
            }
            String string3 = context.getString(R.string.too_low_hint, str);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(string3);
            return string3;
        }
        String string4 = context.getString(R.string.too_low_hint, str);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(string4);
        return string4;
    }
}
