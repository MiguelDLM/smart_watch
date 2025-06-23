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
public abstract class AccessTokenTracker {

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
    public final class CurrentAccessTokenBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ AccessTokenTracker this$0;

        public CurrentAccessTokenBroadcastReceiver(AccessTokenTracker this$0) {
            IIX0o.x0xO0oo(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Intent intent) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(intent, "intent");
            if (IIX0o.Oxx0IOOO(AccessTokenManager.ACTION_CURRENT_ACCESS_TOKEN_CHANGED, intent.getAction())) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(AccessTokenTracker.TAG, "AccessTokenChanged");
                this.this$0.onCurrentAccessTokenChanged((AccessToken) intent.getParcelableExtra(AccessTokenManager.EXTRA_OLD_ACCESS_TOKEN), (AccessToken) intent.getParcelableExtra(AccessTokenManager.EXTRA_NEW_ACCESS_TOKEN));
            }
        }
    }

    static {
        String simpleName = AccessTokenTracker.class.getSimpleName();
        IIX0o.oO(simpleName, "AccessTokenTracker::class.java.simpleName");
        TAG = simpleName;
    }

    public AccessTokenTracker() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        this.receiver = new CurrentAccessTokenBroadcastReceiver(this);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
        IIX0o.oO(localBroadcastManager, "getInstance(FacebookSdk.getApplicationContext())");
        this.broadcastManager = localBroadcastManager;
        startTracking();
    }

    private final void addBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(AccessTokenManager.ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        this.broadcastManager.registerReceiver(this.receiver, intentFilter);
    }

    public final boolean isTracking() {
        return this.isTracking;
    }

    public abstract void onCurrentAccessTokenChanged(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO AccessToken accessToken2);

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
