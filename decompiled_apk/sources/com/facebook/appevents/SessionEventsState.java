package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class SessionEventsState {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final int MAX_ACCUMULATED_LOG_EVENTS;

    @OXOo.OOXIXo
    private static final String TAG;

    @OXOo.OOXIXo
    private List<AppEvent> accumulatedEvents;

    @OXOo.OOXIXo
    private final String anonymousAppDeviceGUID;

    @OXOo.OOXIXo
    private final AttributionIdentifiers attributionIdentifiers;

    @OXOo.OOXIXo
    private final List<AppEvent> inFlightEvents;
    private int numSkippedEventsDueToFullBuffer;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String simpleName = SessionEventsState.class.getSimpleName();
        IIX0o.oO(simpleName, "SessionEventsState::class.java.simpleName");
        TAG = simpleName;
        MAX_ACCUMULATED_LOG_EVENTS = 1000;
    }

    public SessionEventsState(@OXOo.OOXIXo AttributionIdentifiers attributionIdentifiers, @OXOo.OOXIXo String anonymousAppDeviceGUID) {
        IIX0o.x0xO0oo(attributionIdentifiers, "attributionIdentifiers");
        IIX0o.x0xO0oo(anonymousAppDeviceGUID, "anonymousAppDeviceGUID");
        this.attributionIdentifiers = attributionIdentifiers;
        this.anonymousAppDeviceGUID = anonymousAppDeviceGUID;
        this.accumulatedEvents = new ArrayList();
        this.inFlightEvents = new ArrayList();
    }

    public final synchronized void accumulatePersistedEvents(@OXOo.OOXIXo List<AppEvent> events) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(events, "events");
            this.accumulatedEvents.addAll(events);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final synchronized void addEvent(@OXOo.OOXIXo AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(event, "event");
            if (this.accumulatedEvents.size() + this.inFlightEvents.size() >= MAX_ACCUMULATED_LOG_EVENTS) {
                this.numSkippedEventsDueToFullBuffer++;
            } else {
                this.accumulatedEvents.add(event);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final synchronized void clearInFlightAndStats(boolean z) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        if (z) {
            try {
                this.accumulatedEvents.addAll(this.inFlightEvents);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return;
            }
        }
        this.inFlightEvents.clear();
        this.numSkippedEventsDueToFullBuffer = 0;
    }

    public final synchronized int getAccumulatedEventCount() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return this.accumulatedEvents.size();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    @OXOo.OOXIXo
    public final synchronized List<AppEvent> getEventsToPersist() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            List<AppEvent> list = this.accumulatedEvents;
            this.accumulatedEvents = new ArrayList();
            return list;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final int populateRequest(@OXOo.OOXIXo GraphRequest request, @OXOo.OOXIXo Context applicationContext, boolean z, boolean z2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            IIX0o.x0xO0oo(request, "request");
            IIX0o.x0xO0oo(applicationContext, "applicationContext");
            synchronized (this) {
                try {
                    int i = this.numSkippedEventsDueToFullBuffer;
                    EventDeactivationManager eventDeactivationManager = EventDeactivationManager.INSTANCE;
                    EventDeactivationManager.processEvents(this.accumulatedEvents);
                    this.inFlightEvents.addAll(this.accumulatedEvents);
                    this.accumulatedEvents.clear();
                    JSONArray jSONArray = new JSONArray();
                    for (AppEvent appEvent : this.inFlightEvents) {
                        if (appEvent.isChecksumValid()) {
                            if (!z && appEvent.isImplicit()) {
                            }
                            jSONArray.put(appEvent.getJsonObject());
                        } else {
                            Utility utility = Utility.INSTANCE;
                            Utility.logd(TAG, IIX0o.XIxXXX0x0("Event with invalid checksum: ", appEvent));
                        }
                    }
                    if (jSONArray.length() == 0) {
                        return 0;
                    }
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    populateRequest(request, applicationContext, i, jSONArray, z2);
                    return jSONArray.length();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return 0;
        }
    }

    private final void populateRequest(GraphRequest graphRequest, Context context, int i, JSONArray jSONArray, boolean z) {
        JSONObject jSONObject;
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                AppEventsLoggerUtility appEventsLoggerUtility = AppEventsLoggerUtility.INSTANCE;
                jSONObject = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS, this.attributionIdentifiers, this.anonymousAppDeviceGUID, z, context);
                if (this.numSkippedEventsDueToFullBuffer > 0) {
                    jSONObject.put("num_skipped_events", i);
                }
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            }
            graphRequest.setGraphObject(jSONObject);
            Bundle parameters = graphRequest.getParameters();
            String jSONArray2 = jSONArray.toString();
            IIX0o.oO(jSONArray2, "events.toString()");
            parameters.putString("custom_events", jSONArray2);
            graphRequest.setTag(jSONArray2);
            graphRequest.setParameters(parameters);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
