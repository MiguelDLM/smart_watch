package com.sma.smartv3.util;

import com.blankj.utilcode.util.ViewUtils;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class EnvDetector$checkDeviceSecurity$1 extends Lambda implements Oox.oIX0oI<oXIO0o0XI> {
    final /* synthetic */ Oox.oOoXoXO<Boolean, oXIO0o0XI> $action;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EnvDetector$checkDeviceSecurity$1(Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        super(0);
        this.$action = oooxoxo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(Oox.oOoXoXO action, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "$action");
        action.invoke(Boolean.valueOf(z));
    }

    @Override // Oox.oIX0oI
    public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
        invoke2();
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        EnvDetector envDetector = EnvDetector.f24206oIX0oI;
        final boolean z = envDetector.II0xO0() || envDetector.I0Io();
        final Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo = this.$action;
        ViewUtils.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.util.x0XOIxOo
            @Override // java.lang.Runnable
            public final void run() {
                EnvDetector$checkDeviceSecurity$1.invoke$lambda$0(Oox.oOoXoXO.this, z);
            }
        });
    }
}
