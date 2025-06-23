package com.facebook.appevents;

import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class AppEventStore {

    @OXOo.OOXIXo
    public static final AppEventStore INSTANCE = new AppEventStore();

    @OXOo.OOXIXo
    private static final String TAG;

    static {
        String name = AppEventStore.class.getName();
        IIX0o.oO(name, "AppEventStore::class.java.name");
        TAG = name;
    }

    private AppEventStore() {
    }

    @XO0OX.x0XOIxOo
    public static final synchronized void persistEvents(@OXOo.OOXIXo AccessTokenAppIdPair accessTokenAppIdPair, @OXOo.OOXIXo SessionEventsState appEvents) {
        synchronized (AppEventStore.class) {
            if (CrashShieldHandler.isObjectCrashing(AppEventStore.class)) {
                return;
            }
            try {
                IIX0o.x0xO0oo(accessTokenAppIdPair, "accessTokenAppIdPair");
                IIX0o.x0xO0oo(appEvents, "appEvents");
                AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                AppEventUtility.assertIsNotMainThread();
                AppEventDiskStore appEventDiskStore = AppEventDiskStore.INSTANCE;
                PersistedEvents readAndClearStore = AppEventDiskStore.readAndClearStore();
                readAndClearStore.addEvents(accessTokenAppIdPair, appEvents.getEventsToPersist());
                AppEventDiskStore.saveEventsToDisk$facebook_core_release(readAndClearStore);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, AppEventStore.class);
            }
        }
    }

    @XO0OX.x0XOIxOo
    public static final synchronized void persistEvents(@OXOo.OOXIXo AppEventCollection eventsToPersist) {
        synchronized (AppEventStore.class) {
            if (CrashShieldHandler.isObjectCrashing(AppEventStore.class)) {
                return;
            }
            try {
                IIX0o.x0xO0oo(eventsToPersist, "eventsToPersist");
                AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                AppEventUtility.assertIsNotMainThread();
                AppEventDiskStore appEventDiskStore = AppEventDiskStore.INSTANCE;
                PersistedEvents readAndClearStore = AppEventDiskStore.readAndClearStore();
                for (AccessTokenAppIdPair accessTokenAppIdPair : eventsToPersist.keySet()) {
                    SessionEventsState sessionEventsState = eventsToPersist.get(accessTokenAppIdPair);
                    if (sessionEventsState != null) {
                        readAndClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
                    } else {
                        throw new IllegalStateException("Required value was null.");
                    }
                }
                AppEventDiskStore appEventDiskStore2 = AppEventDiskStore.INSTANCE;
                AppEventDiskStore.saveEventsToDisk$facebook_core_release(readAndClearStore);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, AppEventStore.class);
            }
        }
    }
}
