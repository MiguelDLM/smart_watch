package com.facebook.internal;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class ProfileInformationCache {

    @OXOo.OOXIXo
    public static final ProfileInformationCache INSTANCE = new ProfileInformationCache();

    @OXOo.OOXIXo
    private static final ConcurrentHashMap<String, JSONObject> infoCache = new ConcurrentHashMap<>();

    private ProfileInformationCache() {
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final JSONObject getProfileInformation(@OXOo.OOXIXo String accessToken) {
        IIX0o.x0xO0oo(accessToken, "accessToken");
        return infoCache.get(accessToken);
    }

    @XO0OX.x0XOIxOo
    public static final void putProfileInformation(@OXOo.OOXIXo String key, @OXOo.OOXIXo JSONObject value) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(value, "value");
        infoCache.put(key, value);
    }
}
