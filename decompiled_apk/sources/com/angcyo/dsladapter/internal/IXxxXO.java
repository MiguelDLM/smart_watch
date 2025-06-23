package com.angcyo.dsladapter.internal;

import android.view.View;
import com.angcyo.dsladapter.internal.ThrottleClickListener;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public final class IXxxXO {
    public static /* synthetic */ void I0Io(long j, Oox.oIX0oI oix0oi, int i, Object obj) {
        if ((i & 1) != 0) {
            j = ThrottleClickListener.f5397oI0IIXIo.oIX0oI();
        }
        oIX0oI(j, oix0oi);
    }

    public static final void II0xO0(@OXOo.OOXIXo View view, long j, @OXOo.OOXIXo Oox.oOoXoXO<? super View, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(view, "<this>");
        IIX0o.x0xO0oo(action, "action");
        view.setOnClickListener(new ThrottleClickListener(j, null, action, 2, null));
    }

    public static final void oIX0oI(long j, @OXOo.OOXIXo Oox.oIX0oI<oXIO0o0XI> action) {
        IIX0o.x0xO0oo(action, "action");
        long currentTimeMillis = System.currentTimeMillis();
        ThrottleClickListener.oIX0oI oix0oi = ThrottleClickListener.f5397oI0IIXIo;
        if (currentTimeMillis - oix0oi.II0xO0() > j) {
            oix0oi.oxoX(currentTimeMillis);
            action.invoke();
        }
    }

    public static /* synthetic */ void oxoX(View view, long j, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            j = ThrottleClickListener.f5397oI0IIXIo.oIX0oI();
        }
        II0xO0(view, j, oooxoxo);
    }
}
