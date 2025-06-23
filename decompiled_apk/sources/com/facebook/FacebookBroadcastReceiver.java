package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public class FacebookBroadcastReceiver extends BroadcastReceiver {
    public void onFailedAppCall(@OXOo.OOXIXo String appCallId, @OXOo.OOXIXo String action, @OXOo.OOXIXo Bundle extras) {
        IIX0o.x0xO0oo(appCallId, "appCallId");
        IIX0o.x0xO0oo(action, "action");
        IIX0o.x0xO0oo(extras, "extras");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Intent intent) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(intent, "intent");
        String stringExtra = intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_CALL_ID);
        String stringExtra2 = intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_ACTION);
        Bundle extras = intent.getExtras();
        if (stringExtra != null && stringExtra2 != null && extras != null) {
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            if (NativeProtocol.isErrorResult(intent)) {
                onFailedAppCall(stringExtra, stringExtra2, extras);
            } else {
                onSuccessfulAppCall(stringExtra, stringExtra2, extras);
            }
        }
    }

    public void onSuccessfulAppCall(@OXOo.OOXIXo String appCallId, @OXOo.OOXIXo String action, @OXOo.OOXIXo Bundle extras) {
        IIX0o.x0xO0oo(appCallId, "appCallId");
        IIX0o.x0xO0oo(action, "action");
        IIX0o.x0xO0oo(extras, "extras");
    }
}
