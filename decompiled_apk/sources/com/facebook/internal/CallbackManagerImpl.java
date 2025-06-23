package com.facebook.internal;

import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class CallbackManagerImpl implements CallbackManager {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final Map<Integer, Callback> staticCallbacks = new HashMap();

    @OXOo.OOXIXo
    private final Map<Integer, Callback> callbacks = new HashMap();

    /* loaded from: classes8.dex */
    public interface Callback {
        boolean onActivityResult(int i, @OXOo.oOoXoXO Intent intent);
    }

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @XO0OX.x0XOIxOo
        private final synchronized Callback getStaticCallback(int i) {
            return (Callback) CallbackManagerImpl.staticCallbacks.get(Integer.valueOf(i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        @XO0OX.x0XOIxOo
        public final boolean runStaticCallback(int i, int i2, Intent intent) {
            Callback staticCallback = getStaticCallback(i);
            if (staticCallback == null) {
                return false;
            }
            return staticCallback.onActivityResult(i2, intent);
        }

        @XO0OX.x0XOIxOo
        public final synchronized void registerStaticCallback(int i, @OXOo.OOXIXo Callback callback) {
            IIX0o.x0xO0oo(callback, "callback");
            if (CallbackManagerImpl.staticCallbacks.containsKey(Integer.valueOf(i))) {
                return;
            }
            CallbackManagerImpl.staticCallbacks.put(Integer.valueOf(i), callback);
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public enum RequestCodeOffset {
        Login(0),
        Share(1),
        Message(2),
        Like(3),
        GameRequest(4),
        AppGroupCreate(5),
        AppGroupJoin(6),
        AppInvite(7),
        DeviceShare(8),
        GamingFriendFinder(9),
        GamingGroupIntegration(10),
        Referral(11),
        GamingContextCreate(12),
        GamingContextSwitch(13),
        GamingContextChoose(14),
        TournamentShareDialog(15);

        private final int offset;

        RequestCodeOffset(int i) {
            this.offset = i;
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static RequestCodeOffset[] valuesCustom() {
            RequestCodeOffset[] valuesCustom = values();
            return (RequestCodeOffset[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }

        public final int toRequestCode() {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            return FacebookSdk.getCallbackRequestCodeOffset() + this.offset;
        }
    }

    @XO0OX.x0XOIxOo
    public static final synchronized void registerStaticCallback(int i, @OXOo.OOXIXo Callback callback) {
        synchronized (CallbackManagerImpl.class) {
            Companion.registerStaticCallback(i, callback);
        }
    }

    @Override // com.facebook.CallbackManager
    public boolean onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        Callback callback = this.callbacks.get(Integer.valueOf(i));
        if (callback == null) {
            return Companion.runStaticCallback(i, i2, intent);
        }
        return callback.onActivityResult(i2, intent);
    }

    public final void registerCallback(int i, @OXOo.OOXIXo Callback callback) {
        IIX0o.x0xO0oo(callback, "callback");
        this.callbacks.put(Integer.valueOf(i), callback);
    }

    public final void unregisterCallback(int i) {
        this.callbacks.remove(Integer.valueOf(i));
    }
}
