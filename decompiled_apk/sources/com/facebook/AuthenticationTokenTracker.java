package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public abstract class AuthenticationTokenTracker {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final String TAG;

    @OXOo.OOXIXo
    private final LocalBroadcastManager broadcastManager;
    private boolean isTracking;

    @OXOo.OOXIXo
    private final BroadcastReceiver receiver;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public final class CurrentAuthenticationTokenBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ AuthenticationTokenTracker this$0;

        public CurrentAuthenticationTokenBroadcastReceiver(AuthenticationTokenTracker this$0) {
            IIX0o.x0xO0oo(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Intent intent) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(intent, "intent");
            if (IIX0o.Oxx0IOOO(AuthenticationTokenManager.ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED, intent.getAction())) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(AuthenticationTokenTracker.TAG, "AuthenticationTokenChanged");
                this.this$0.onCurrentAuthenticationTokenChanged((AuthenticationToken) intent.getParcelableExtra(AuthenticationTokenManager.EXTRA_OLD_AUTHENTICATION_TOKEN), (AuthenticationToken) intent.getParcelableExtra(AuthenticationTokenManager.EXTRA_NEW_AUTHENTICATION_TOKEN));
            }
        }
    }

    static {
        String simpleName = AuthenticationTokenTracker.class.getSimpleName();
        IIX0o.oO(simpleName, "AuthenticationTokenTracker::class.java.simpleName");
        TAG = simpleName;
    }

    public AuthenticationTokenTracker() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        this.receiver = new CurrentAuthenticationTokenBroadcastReceiver(this);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
        IIX0o.oO(localBroadcastManager, "getInstance(FacebookSdk.getApplicationContext())");
        this.broadcastManager = localBroadcastManager;
        startTracking();
    }

    private final void addBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(AuthenticationTokenManager.ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED);
        this.broadcastManager.registerReceiver(this.receiver, intentFilter);
    }

    public final boolean isTracking() {
        return this.isTracking;
    }

    public abstract void onCurrentAuthenticationTokenChanged(@OXOo.oOoXoXO AuthenticationToken authenticationToken, @OXOo.oOoXoXO AuthenticationToken authenticationToken2);

    public final void startTracking() {
        if (this.isTracking) {
            return;
        }
        addBroadcastReceiver();
        this.isTracking = true;
    }

    public final void stopTracking() {
        if (!this.isTracking) {
            return;
        }
        this.broadcastManager.unregisterReceiver(this.receiver);
        this.isTracking = false;
    }
}
