package com.facebook.appevents;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class PersistedEvents implements Serializable {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 20160629001L;

    @OXOo.OOXIXo
    private final HashMap<AccessTokenAppIdPair, List<AppEvent>> events;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class SerializationProxyV1 implements Serializable {

        @OXOo.OOXIXo
        public static final Companion Companion = new Companion(null);
        private static final long serialVersionUID = 20160629001L;

        @OXOo.OOXIXo
        private final HashMap<AccessTokenAppIdPair, List<AppEvent>> proxyEvents;

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            private Companion() {
            }
        }

        public SerializationProxyV1(@OXOo.OOXIXo HashMap<AccessTokenAppIdPair, List<AppEvent>> proxyEvents) {
            IIX0o.x0xO0oo(proxyEvents, "proxyEvents");
            this.proxyEvents = proxyEvents;
        }

        private final Object readResolve() throws ObjectStreamException {
            return new PersistedEvents(this.proxyEvents);
        }
    }

    public PersistedEvents() {
        this.events = new HashMap<>();
    }

    private final Object writeReplace() throws ObjectStreamException {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return new SerializationProxyV1(this.events);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final void addEvents(@OXOo.OOXIXo AccessTokenAppIdPair accessTokenAppIdPair, @OXOo.OOXIXo List<AppEvent> appEvents) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(accessTokenAppIdPair, "accessTokenAppIdPair");
            IIX0o.x0xO0oo(appEvents, "appEvents");
            if (!this.events.containsKey(accessTokenAppIdPair)) {
                this.events.put(accessTokenAppIdPair, CollectionsKt___CollectionsKt.o0Xo0XII(appEvents));
                return;
            }
            List<AppEvent> list = this.events.get(accessTokenAppIdPair);
            if (list != null) {
                list.addAll(appEvents);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final boolean containsKey(@OXOo.OOXIXo AccessTokenAppIdPair accessTokenAppIdPair) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            IIX0o.x0xO0oo(accessTokenAppIdPair, "accessTokenAppIdPair");
            return this.events.containsKey(accessTokenAppIdPair);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    @OXOo.OOXIXo
    public final Set<Map.Entry<AccessTokenAppIdPair, List<AppEvent>>> entrySet() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Set<Map.Entry<AccessTokenAppIdPair, List<AppEvent>>> entrySet = this.events.entrySet();
            IIX0o.oO(entrySet, "events.entries");
            return entrySet;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @OXOo.oOoXoXO
    public final List<AppEvent> get(@OXOo.OOXIXo AccessTokenAppIdPair accessTokenAppIdPair) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(accessTokenAppIdPair, "accessTokenAppIdPair");
            return this.events.get(accessTokenAppIdPair);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @OXOo.OOXIXo
    public final Set<AccessTokenAppIdPair> keySet() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Set<AccessTokenAppIdPair> keySet = this.events.keySet();
            IIX0o.oO(keySet, "events.keys");
            return keySet;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public PersistedEvents(@OXOo.OOXIXo HashMap<AccessTokenAppIdPair, List<AppEvent>> appEventMap) {
        IIX0o.x0xO0oo(appEventMap, "appEventMap");
        HashMap<AccessTokenAppIdPair, List<AppEvent>> hashMap = new HashMap<>();
        this.events = hashMap;
        hashMap.putAll(appEventMap);
    }
}
