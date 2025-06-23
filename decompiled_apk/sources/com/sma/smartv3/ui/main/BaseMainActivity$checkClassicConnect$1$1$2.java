package com.sma.smartv3.ui.main;

import android.os.Handler;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class BaseMainActivity$checkClassicConnect$1$1$2 extends Lambda implements Oox.oIX0oI<oXIO0o0XI> {
    final /* synthetic */ BaseMainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMainActivity$checkClassicConnect$1$1$2(BaseMainActivity baseMainActivity) {
        super(0);
        this.this$0 = baseMainActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(BaseMainActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.permissionCheckPopup();
    }

    @Override // Oox.oIX0oI
    public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
        invoke2();
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Handler handler;
        handler = this.this$0.mHandler;
        final BaseMainActivity baseMainActivity = this.this$0;
        handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.main.oOoXoXO
            @Override // java.lang.Runnable
            public final void run() {
                BaseMainActivity$checkClassicConnect$1$1$2.invoke$lambda$0(BaseMainActivity.this);
            }
        }, 3000L);
    }
}
