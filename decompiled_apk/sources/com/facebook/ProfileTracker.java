package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.Validate;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public abstract class ProfileTracker {

    @OXOo.OOXIXo
    private final LocalBroadcastManager broadcastManager;
    private boolean isTracking;

    @OXOo.OOXIXo
    private final BroadcastReceiver receiver;

    /* loaded from: classes8.dex */
    public final class ProfileBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ ProfileTracker this$0;

        public ProfileBroadcastReceiver(ProfileTracker this$0) {
            IIX0o.x0xO0oo(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Intent intent) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(intent, "intent");
            if (IIX0o.Oxx0IOOO(ProfileManager.ACTION_CURRENT_PROFILE_CHANGED, intent.getAction())) {
                this.this$0.onCurrentProfileChanged((Profile) intent.getParcelableExtra(ProfileManager.EXTRA_OLD_PROFILE), (Profile) intent.getParcelableExtra(ProfileManager.EXTRA_NEW_PROFILE));
            }
        }
    }

    public ProfileTracker() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        this.receiver = new ProfileBroadcastReceiver(this);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
        IIX0o.oO(localBroadcastManager, "getInstance(FacebookSdk.getApplicationContext())");
        this.broadcastManager = localBroadcastManager;
        startTracking();
    }

    private final void addBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ProfileManager.ACTION_CURRENT_PROFILE_CHANGED);
        this.broadcastManager.registerReceiver(this.receiver, intentFilter);
    }

    public final boolean isTracking() {
        return this.isTracking;
    }

    public abstract void onCurrentProfileChanged(@OXOo.oOoXoXO Profile profile, @OXOo.oOoXoXO Profile profile2);

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
