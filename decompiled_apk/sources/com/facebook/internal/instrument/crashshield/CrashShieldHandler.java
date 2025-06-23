package com.facebook.internal.instrument.crashshield;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class CrashShieldHandler {

    @OOXIXo
    public static final CrashShieldHandler INSTANCE = new CrashShieldHandler();
    private static final Set<Object> crashingObjects = Collections.newSetFromMap(new WeakHashMap());
    private static boolean enabled;

    private CrashShieldHandler() {
    }

    @x0XOIxOo
    @VisibleForTesting
    public static final void disable() {
        enabled = false;
    }

    @x0XOIxOo
    public static final void enable() {
        enabled = true;
    }

    @x0XOIxOo
    public static final void handleThrowable(@oOoXoXO Throwable th, @OOXIXo Object o) {
        IIX0o.x0xO0oo(o, "o");
        if (!enabled) {
            return;
        }
        crashingObjects.add(o);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            ExceptionAnalyzer exceptionAnalyzer = ExceptionAnalyzer.INSTANCE;
            ExceptionAnalyzer.execute(th);
            InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
            InstrumentData.Builder.build(th, InstrumentData.Type.CrashShield).save();
        }
        scheduleCrashInDebug(th);
    }

    @x0XOIxOo
    @VisibleForTesting
    public static final boolean isDebug() {
        return false;
    }

    @x0XOIxOo
    public static final boolean isObjectCrashing(@OOXIXo Object o) {
        IIX0o.x0xO0oo(o, "o");
        return crashingObjects.contains(o);
    }

    @x0XOIxOo
    public static final void methodFinished(@oOoXoXO Object obj) {
    }

    @x0XOIxOo
    public static final void reset() {
        resetCrashingObjects();
    }

    @x0XOIxOo
    public static final void resetCrashingObjects() {
        crashingObjects.clear();
    }

    @x0XOIxOo
    @VisibleForTesting
    public static final void scheduleCrashInDebug(@oOoXoXO final Throwable th) {
        if (isDebug()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.internal.instrument.crashshield.CrashShieldHandler$scheduleCrashInDebug$1
                @Override // java.lang.Runnable
                public void run() {
                    throw new RuntimeException(th);
                }
            });
        }
    }
}
