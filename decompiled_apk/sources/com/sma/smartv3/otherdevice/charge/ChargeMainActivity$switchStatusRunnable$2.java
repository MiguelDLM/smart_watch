package com.sma.smartv3.otherdevice.charge;

import kotlin.jvm.internal.Lambda;

/* loaded from: classes12.dex */
public final class ChargeMainActivity$switchStatusRunnable$2 extends Lambda implements Oox.oIX0oI<Runnable> {
    final /* synthetic */ ChargeMainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChargeMainActivity$switchStatusRunnable$2(ChargeMainActivity chargeMainActivity) {
        super(0);
        this.this$0 = chargeMainActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(ChargeMainActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.showCurDeviceState();
    }

    @Override // Oox.oIX0oI
    @OXOo.OOXIXo
    public final Runnable invoke() {
        final ChargeMainActivity chargeMainActivity = this.this$0;
        return new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.oOXoIIIo
            @Override // java.lang.Runnable
            public final void run() {
                ChargeMainActivity$switchStatusRunnable$2.invoke$lambda$0(ChargeMainActivity.this);
            }
        };
    }
}
