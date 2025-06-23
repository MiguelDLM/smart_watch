package com.baidu.mshield.rp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* loaded from: classes7.dex */
public class Receiver extends BroadcastReceiver {
    public void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            new Thread(new a(this, context)).start();
            com.baidu.mshield.utility.b.a(context).b();
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && action.equals("com.b.r.p")) {
                a(context, intent);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }
}
