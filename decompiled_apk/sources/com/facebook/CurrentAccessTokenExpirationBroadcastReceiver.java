package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class CurrentAccessTokenExpirationBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Intent intent) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(intent, "intent");
        if (IIX0o.Oxx0IOOO(AccessTokenManager.ACTION_CURRENT_ACCESS_TOKEN_CHANGED, intent.getAction())) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.isInitialized()) {
                AccessTokenManager.Companion.getInstance().currentAccessTokenChanged();
            }
        }
    }
}
