package com.bytedance.pangle.receiver;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes8.dex */
public abstract class PluginBroadcastReceiver {
    public abstract void onReceive(Context context, Intent intent);
}
