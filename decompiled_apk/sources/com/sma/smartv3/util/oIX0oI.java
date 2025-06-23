package com.sma.smartv3.util;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.content.ContextCompat;

/* loaded from: classes12.dex */
public final class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f24510oIX0oI = new oIX0oI();

    public static /* synthetic */ void II0xO0(oIX0oI oix0oi, Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 4;
        }
        oix0oi.oIX0oI(context, broadcastReceiver, intentFilter, i);
    }

    @SuppressLint({"WrongConstant", "UnspecifiedRegisterReceiverFlag"})
    public final void oIX0oI(@OXOo.OOXIXo Context context, @OXOo.OOXIXo BroadcastReceiver mReceiver, @OXOo.OOXIXo IntentFilter filter, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mReceiver, "mReceiver");
        kotlin.jvm.internal.IIX0o.x0xO0oo(filter, "filter");
        if (Build.VERSION.SDK_INT >= 34) {
            ContextCompat.registerReceiver(context, mReceiver, filter, i);
        } else {
            context.registerReceiver(mReceiver, filter);
        }
    }
}
