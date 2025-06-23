package com.sma.smartv3.ui.device.item;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes12.dex */
public final class EarphoneItem$switchStatusRunnable$2 extends Lambda implements Oox.oIX0oI<Runnable> {
    final /* synthetic */ EarphoneItem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarphoneItem$switchStatusRunnable$2(EarphoneItem earphoneItem) {
        super(0);
        this.this$0 = earphoneItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(EarphoneItem this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getIvConnection().setEnabled(false);
    }

    @Override // Oox.oIX0oI
    @OOXIXo
    public final Runnable invoke() {
        final EarphoneItem earphoneItem = this.this$0;
        return new Runnable() { // from class: com.sma.smartv3.ui.device.item.oIX0oI
            @Override // java.lang.Runnable
            public final void run() {
                EarphoneItem$switchStatusRunnable$2.invoke$lambda$0(EarphoneItem.this);
            }
        };
    }
}
