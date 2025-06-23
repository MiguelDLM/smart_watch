package com.sma.smartv3.ui.main;

import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.pop.XoI0Ixx0;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class BaseMainActivity$checkDeviceSecurity$1 extends Lambda implements Oox.oOoXoXO<Boolean, oXIO0o0XI> {
    final /* synthetic */ BaseMainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMainActivity$checkDeviceSecurity$1(BaseMainActivity baseMainActivity) {
        super(1);
        this.this$0 = baseMainActivity;
    }

    @Override // Oox.oOoXoXO
    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return oXIO0o0XI.f29392oIX0oI;
    }

    public final void invoke(boolean z) {
        if (z) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this.this$0, 0, 2, null);
            xoI0Ixx0.x0xO0oo(false);
            xoI0Ixx0.Xx000oIo("安全提醒");
            xoI0Ixx0.oo("检测到您的手机存在安全风险, 请注意!");
            XoI0Ixx0.IO(xoI0Ixx0, null, null, 2, null);
            xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$checkDeviceSecurity$1$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx0.IIXOooo();
        }
    }
}
