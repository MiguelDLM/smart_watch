package com.baidu.xclient.gdid.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.xclient.gdid.e.d;

/* loaded from: classes8.dex */
public class b extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static String f10227a = "action_tir_mshield";
    public boolean b = true;

    public final void a(Context context, Intent intent) {
        com.baidu.xclient.gdid.e.b.b().a(new c(this, intent, context));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
