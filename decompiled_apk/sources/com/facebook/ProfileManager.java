package com.facebook;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.Utility;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class ProfileManager {

    @OXOo.OOXIXo
    public static final String ACTION_CURRENT_PROFILE_CHANGED = "com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED";

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    public static final String EXTRA_NEW_PROFILE = "com.facebook.sdk.EXTRA_NEW_PROFILE";

    @OXOo.OOXIXo
    public static final String EXTRA_OLD_PROFILE = "com.facebook.sdk.EXTRA_OLD_PROFILE";
    private static volatile ProfileManager instance;

    @OXOo.oOoXoXO
    private Profile currentProfileField;

    @OXOo.OOXIXo
    private final LocalBroadcastManager localBroadcastManager;

    @OXOo.OOXIXo
    private final ProfileCache profileCache;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final synchronized ProfileManager getInstance() {
            ProfileManager profileManager;
            try {
                if (ProfileManager.instance == null) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
                    IIX0o.oO(localBroadcastManager, "getInstance(applicationContext)");
                    ProfileManager.instance = new ProfileManager(localBroadcastManager, new ProfileCache());
                }
                profileManager = ProfileManager.instance;
                if (profileManager == null) {
                    IIX0o.XOxIOxOx("instance");
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
            return profileManager;
        }

        private Companion() {
        }
    }

    public ProfileManager(@OXOo.OOXIXo LocalBroadcastManager localBroadcastManager, @OXOo.OOXIXo ProfileCache profileCache) {
        IIX0o.x0xO0oo(localBroadcastManager, "localBroadcastManager");
        IIX0o.x0xO0oo(profileCache, "profileCache");
        this.localBroadcastManager = localBroadcastManager;
        this.profileCache = profileCache;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final synchronized ProfileManager getInstance() {
        ProfileManager companion;
        synchronized (ProfileManager.class) {
            companion = Companion.getInstance();
        }
        return companion;
    }

    private final void sendCurrentProfileChangedBroadcast(Profile profile, Profile profile2) {
        Intent intent = new Intent(ACTION_CURRENT_PROFILE_CHANGED);
        intent.putExtra(EXTRA_OLD_PROFILE, profile);
        intent.putExtra(EXTRA_NEW_PROFILE, profile2);
        this.localBroadcastManager.sendBroadcast(intent);
    }

    @OXOo.oOoXoXO
    public final Profile getCurrentProfile() {
        return this.currentProfileField;
    }

    public final boolean loadCurrentProfile() {
        Profile load = this.profileCache.load();
        if (load == null) {
            return false;
        }
        setCurrentProfile(load, false);
        return true;
    }

    public final void setCurrentProfile(@OXOo.oOoXoXO Profile profile) {
        setCurrentProfile(profile, true);
    }

    private final void setCurrentProfile(Profile profile, boolean z) {
        Profile profile2 = this.currentProfileField;
        this.currentProfileField = profile;
        if (z) {
            if (profile != null) {
                this.profileCache.save(profile);
            } else {
                this.profileCache.clear();
            }
        }
        Utility utility = Utility.INSTANCE;
        if (Utility.areObjectsEqual(profile2, profile)) {
            return;
        }
        sendCurrentProfileChangedBroadcast(profile2, profile);
    }
}
