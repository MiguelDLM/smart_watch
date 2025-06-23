package com.sma.smartv3.ui.me.item;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.util.x0xO0oo;
import com.szabh.smable3.component.BleConnector;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

/* loaded from: classes11.dex */
public final class MainUserOrderItem$toWatchFaceActivity$1 extends Lambda implements oOoXoXO<BleConnector, oXIO0o0XI> {
    final /* synthetic */ Context $context;
    final /* synthetic */ int $index;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainUserOrderItem$toWatchFaceActivity$1(Context context, int i) {
        super(1);
        this.$context = context;
        this.$index = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(int i) {
        x0xO0oo.oIX0oI(x0xO0oo.f24643oxIIX0o, Integer.valueOf(i));
    }

    @Override // Oox.oOoXoXO
    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BleConnector bleConnector) {
        invoke2(bleConnector);
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@OOXIXo BleConnector it) {
        IIX0o.x0xO0oo(it, "it");
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        Context context = this.$context;
        IIX0o.x0XOIxOo(context, "null cannot be cast to non-null type android.app.Activity");
        projectManager.OIxOX((Activity) context);
        Handler handler = new Handler(Looper.getMainLooper());
        final int i = this.$index;
        handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.item.XO
            @Override // java.lang.Runnable
            public final void run() {
                MainUserOrderItem$toWatchFaceActivity$1.invoke$lambda$0(i);
            }
        }, 500L);
    }
}
