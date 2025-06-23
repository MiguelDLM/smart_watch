package com.facebook.internal;

import android.content.Intent;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.UUID;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class AppCall {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.oOoXoXO
    private static AppCall currentPendingCall;

    @OXOo.OOXIXo
    private final UUID callId;
    private int requestCode;

    @OXOo.oOoXoXO
    private Intent requestIntent;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized boolean setCurrentPendingCall(AppCall appCall) {
            boolean z;
            AppCall currentPendingCall = getCurrentPendingCall();
            AppCall.access$setCurrentPendingCall$cp(appCall);
            if (currentPendingCall != null) {
                z = true;
            } else {
                z = false;
            }
            return z;
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final synchronized AppCall finishPendingCall(@OXOo.OOXIXo UUID callId, int i) {
            IIX0o.x0xO0oo(callId, "callId");
            AppCall currentPendingCall = getCurrentPendingCall();
            if (currentPendingCall != null && IIX0o.Oxx0IOOO(currentPendingCall.getCallId(), callId) && currentPendingCall.getRequestCode() == i) {
                setCurrentPendingCall(null);
                return currentPendingCall;
            }
            return null;
        }

        @OXOo.oOoXoXO
        public final AppCall getCurrentPendingCall() {
            return AppCall.access$getCurrentPendingCall$cp();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @XO0OX.xoIox
    public AppCall(int i) {
        this(i, null, 2, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ AppCall access$getCurrentPendingCall$cp() {
        if (CrashShieldHandler.isObjectCrashing(AppCall.class)) {
            return null;
        }
        try {
            return currentPendingCall;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppCall.class);
            return null;
        }
    }

    public static final /* synthetic */ void access$setCurrentPendingCall$cp(AppCall appCall) {
        if (CrashShieldHandler.isObjectCrashing(AppCall.class)) {
            return;
        }
        try {
            currentPendingCall = appCall;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppCall.class);
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final synchronized AppCall finishPendingCall(@OXOo.OOXIXo UUID uuid, int i) {
        synchronized (AppCall.class) {
            if (CrashShieldHandler.isObjectCrashing(AppCall.class)) {
                return null;
            }
            try {
                return Companion.finishPendingCall(uuid, i);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, AppCall.class);
                return null;
            }
        }
    }

    @OXOo.OOXIXo
    public final UUID getCallId() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.callId;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final int getRequestCode() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return this.requestCode;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    @OXOo.oOoXoXO
    public final Intent getRequestIntent() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.requestIntent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final boolean setPending() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                return Companion.setCurrentPendingCall(this);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return false;
            }
        }
        return false;
    }

    public final void setRequestCode(int i) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.requestCode = i;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void setRequestIntent(@OXOo.oOoXoXO Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.requestIntent = intent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @XO0OX.xoIox
    public AppCall(int i, @OXOo.OOXIXo UUID callId) {
        IIX0o.x0xO0oo(callId, "callId");
        this.requestCode = i;
        this.callId = callId;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ AppCall(int r1, java.util.UUID r2, int r3, kotlin.jvm.internal.IIXOooo r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto Ld
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r3 = "randomUUID()"
            kotlin.jvm.internal.IIX0o.oO(r2, r3)
        Ld:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AppCall.<init>(int, java.util.UUID, int, kotlin.jvm.internal.IIXOooo):void");
    }
}
