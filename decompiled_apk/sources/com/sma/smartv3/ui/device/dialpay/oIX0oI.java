package com.sma.smartv3.ui.device.dialpay;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.ProgressButtonV2;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class oIX0oI {
    public static /* synthetic */ String I0Io(float f, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return II0xO0(f, str);
    }

    @OOXIXo
    public static final String II0xO0(float f, @OOXIXo String priceUnit) {
        IIX0o.x0xO0oo(priceUnit, "priceUnit");
        if (priceUnit.length() == 0) {
            priceUnit = oIX0oI();
        }
        return priceUnit + f;
    }

    public static /* synthetic */ void Oxx0IOOO(ProgressButtonV2 progressButtonV2, float f, float f2, float f3, float f4, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        if ((i & 8) != 0) {
            f3 = 0.0f;
        }
        if ((i & 16) != 0) {
            f4 = 0.0f;
        }
        if ((i & 32) != 0) {
            z = false;
        }
        if ((i & 64) != 0) {
            str = "";
        }
        if ((i & 128) != 0) {
            str2 = "";
        }
        XO(progressButtonV2, f, f2, f3, f4, z, str, str2);
    }

    public static /* synthetic */ boolean X0o0xo(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return oxoX(str);
    }

    public static final void XO(@OOXIXo ProgressButtonV2 progressButton, float f, float f2, float f3, float f4, boolean z, @OOXIXo String memberAttr, @oOoXoXO String str) {
        float f5;
        float f6;
        float f7;
        String valueOf;
        float f8;
        String valueOf2;
        float f9;
        IIX0o.x0xO0oo(progressButton, "progressButton");
        IIX0o.x0xO0oo(memberAttr, "memberAttr");
        progressButton.setDrawablesLift(0);
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.Oxx0xo()) {
            f5 = f;
        } else {
            f5 = f2;
        }
        if (f5 == 0.0f) {
            ProgressButtonV2.XO(progressButton, R.string.free_order_amount, false, 1, false, R.color.order_text_orange, null, 42, null);
            return;
        }
        if (z) {
            progressButton.setDrawablesLift(R.drawable.limited_time_icon);
            ProgressButtonV2.XO(progressButton, R.string.free_order_amount, false, 1, false, R.color.order_text_orange, null, 34, null);
            return;
        }
        if (IIX0o.Oxx0IOOO(memberAttr, "2")) {
            progressButton.setDrawablesLift(R.drawable.memberattr_vip_icon);
            if (projectManager.IxIo()) {
                valueOf2 = "";
            } else {
                if (projectManager.Oxx0xo()) {
                    f8 = f;
                } else {
                    f8 = f2;
                }
                valueOf2 = String.valueOf(I0Io(f8, null, 2, null));
            }
            if (projectManager.Oxx0xo()) {
                f9 = f3;
            } else {
                f9 = f4;
            }
            ProgressButtonV2.Oxx0IOOO(progressButton, String.valueOf(I0Io(f9, null, 2, null)), false, 1, false, R.color.member_exclusive_tv_color, valueOf2, 2, null);
            return;
        }
        if (IIX0o.Oxx0IOOO(memberAttr, "1")) {
            progressButton.setDrawablesLift(R.drawable.memberattr_vip_icon);
            if (projectManager.IxIo()) {
                valueOf = "";
            } else {
                if (projectManager.Oxx0xo()) {
                    f7 = f;
                } else {
                    f7 = f2;
                }
                valueOf = String.valueOf(I0Io(f7, null, 2, null));
            }
            ProgressButtonV2.XO(progressButton, R.string.free_order_amount, false, 1, false, R.color.member_exclusive_tv_color, valueOf, 2, null);
            return;
        }
        if (oxoX(str)) {
            ProgressButtonV2.XO(progressButton, R.string.sync, false, 1, false, R.color.order_text_orange, null, 42, null);
            return;
        }
        if (projectManager.Oxx0xo()) {
            f6 = f;
        } else {
            f6 = f2;
        }
        ProgressButtonV2.Oxx0IOOO(progressButton, String.valueOf(I0Io(f6, null, 2, null)), false, 0, false, R.color.order_text_orange, null, 44, null);
    }

    @OOXIXo
    public static final String oIX0oI() {
        if (ProjectManager.f19822oIX0oI.Oxx0xo()) {
            return "$";
        }
        return "¥";
    }

    public static final boolean oxoX(@oOoXoXO String str) {
        return IIX0o.Oxx0IOOO(str, "Payed");
    }
}
