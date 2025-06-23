package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class SDCardListener extends BroadcastReceiver {
    static {
        new ArrayList();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!"android.intent.action.MEDIA_MOUNTED".equals(action) && !"android.intent.action.MEDIA_UNMOUNTED".equals(action) && !"android.intent.action.MEDIA_BAD_REMOVAL".equals(action) && !"android.intent.action.MEDIA_EJECT".equals(action)) {
                "android.intent.action.MEDIA_REMOVED".equals(action);
            }
        }
    }
}
