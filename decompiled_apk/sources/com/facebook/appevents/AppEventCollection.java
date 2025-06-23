package com.facebook.appevents;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class AppEventCollection {

    @OXOo.OOXIXo
    private final HashMap<AccessTokenAppIdPair, SessionEventsState> stateMap = new HashMap<>();

    private final synchronized SessionEventsState getSessionEventsState(AccessTokenAppIdPair accessTokenAppIdPair) {
        SessionEventsState sessionEventsState = this.stateMap.get(accessTokenAppIdPair);
        if (sessionEventsState == null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(applicationContext);
            if (attributionIdentifiers != null) {
                sessionEventsState = new SessionEventsState(attributionIdentifiers, AppEventsLogger.Companion.getAnonymousAppDeviceGUID(applicationContext));
            }
        }
        if (sessionEventsState == null) {
            return null;
        }
        this.stateMap.put(accessTokenAppIdPair, sessionEventsState);
        return sessionEventsState;
    }

    public final synchronized void addEvent(@OXOo.OOXIXo AccessTokenAppIdPair accessTokenAppIdPair, @OXOo.OOXIXo AppEvent appEvent) {
        IIX0o.x0xO0oo(accessTokenAppIdPair, "accessTokenAppIdPair");
        IIX0o.x0xO0oo(appEvent, "appEvent");
        SessionEventsState sessionEventsState = getSessionEventsState(accessTokenAppIdPair);
        if (sessionEventsState != null) {
            sessionEventsState.addEvent(appEvent);
        }
    }

    public final synchronized void addPersistedEvents(@OXOo.oOoXoXO PersistedEvents persistedEvents) {
        if (persistedEvents == null) {
            return;
        }
        for (Map.Entry<AccessTokenAppIdPair, List<AppEvent>> entry : persistedEvents.entrySet()) {
            SessionEventsState sessionEventsState = getSessionEventsState(entry.getKey());
            if (sessionEventsState != null) {
                Iterator<AppEvent> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    sessionEventsState.addEvent(it.next());
                }
            }
        }
    }

    @OXOo.oOoXoXO
    public final synchronized SessionEventsState get(@OXOo.OOXIXo AccessTokenAppIdPair accessTokenAppIdPair) {
        IIX0o.x0xO0oo(accessTokenAppIdPair, "accessTokenAppIdPair");
        return this.stateMap.get(accessTokenAppIdPair);
    }

    public final synchronized int getEventCount() {
        int i;
        Iterator<SessionEventsState> it = this.stateMap.values().iterator();
        i = 0;
        while (it.hasNext()) {
            i += it.next().getAccumulatedEventCount();
        }
        return i;
    }

    @OXOo.OOXIXo
    public final synchronized Set<AccessTokenAppIdPair> keySet() {
        Set<AccessTokenAppIdPair> keySet;
        keySet = this.stateMap.keySet();
        IIX0o.oO(keySet, "stateMap.keys");
        return keySet;
    }
}
