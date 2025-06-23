package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.gatekeeper.GateKeeper;
import com.facebook.internal.gatekeeper.GateKeeperRuntimeCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.oxxXoxO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class FetchedAppGateKeepersManager {

    @OXOo.OOXIXo
    private static final String APPLICATION_FIELDS = "fields";
    private static final long APPLICATION_GATEKEEPER_CACHE_TIMEOUT = 3600000;

    @OXOo.OOXIXo
    private static final String APPLICATION_GATEKEEPER_EDGE = "mobile_sdk_gk";

    @OXOo.OOXIXo
    private static final String APPLICATION_GATEKEEPER_FIELD = "gatekeepers";

    @OXOo.OOXIXo
    private static final String APPLICATION_GRAPH_DATA = "data";

    @OXOo.OOXIXo
    private static final String APPLICATION_PLATFORM = "platform";

    @OXOo.OOXIXo
    private static final String APPLICATION_SDK_VERSION = "sdk_version";

    @OXOo.OOXIXo
    private static final String APP_GATEKEEPERS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_GATEKEEPERS.%s";

    @OXOo.OOXIXo
    private static final String APP_GATEKEEPERS_PREFS_STORE = "com.facebook.internal.preferences.APP_GATEKEEPERS";

    @OXOo.OOXIXo
    private static final String APP_PLATFORM = "android";

    @OXOo.oOoXoXO
    private static GateKeeperRuntimeCache gateKeeperRuntimeCache;

    @OXOo.oOoXoXO
    private static Long timestamp;

    @OXOo.OOXIXo
    public static final FetchedAppGateKeepersManager INSTANCE = new FetchedAppGateKeepersManager();

    @OXOo.oOoXoXO
    private static final String TAG = IO.oxoX(FetchedAppGateKeepersManager.class).xoXoI();

    @OXOo.OOXIXo
    private static final AtomicBoolean isLoading = new AtomicBoolean(false);

    @OXOo.OOXIXo
    private static final ConcurrentLinkedQueue<Callback> callbacks = new ConcurrentLinkedQueue<>();

    @OXOo.OOXIXo
    private static final Map<String, JSONObject> fetchedAppGateKeepers = new ConcurrentHashMap();

    /* loaded from: classes8.dex */
    public interface Callback {
        void onCompleted();
    }

    private FetchedAppGateKeepersManager() {
    }

    private final JSONObject getAppGateKeepersQueryResponse(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("platform", "android");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        bundle.putString("sdk_version", FacebookSdk.getSdkVersion());
        bundle.putString("fields", APPLICATION_GATEKEEPER_FIELD);
        GraphRequest.Companion companion = GraphRequest.Companion;
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("app/%s", Arrays.copyOf(new Object[]{APPLICATION_GATEKEEPER_EDGE}, 1));
        IIX0o.oO(format, "java.lang.String.format(format, *args)");
        GraphRequest newGraphPathRequest = companion.newGraphPathRequest(null, format, null);
        newGraphPathRequest.setParameters(bundle);
        JSONObject jsonObject = newGraphPathRequest.executeAndWait().getJsonObject();
        if (jsonObject == null) {
            return new JSONObject();
        }
        return jsonObject;
    }

    @XO0OX.x0XOIxOo
    public static final boolean getGateKeeperForKey(@OXOo.OOXIXo String name, @OXOo.oOoXoXO String str, boolean z) {
        IIX0o.x0xO0oo(name, "name");
        Map<String, Boolean> gateKeepersForApplication = INSTANCE.getGateKeepersForApplication(str);
        if (gateKeepersForApplication.containsKey(name)) {
            Boolean bool = gateKeepersForApplication.get(name);
            if (bool == null) {
                return z;
            }
            return bool.booleanValue();
        }
        return z;
    }

    private final boolean isTimestampValid(Long l) {
        if (l == null || System.currentTimeMillis() - l.longValue() >= 3600000) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadAppGateKeepersAsync$lambda-0, reason: not valid java name */
    public static final void m199loadAppGateKeepersAsync$lambda0(String applicationId, Context context, String gateKeepersKey) {
        IIX0o.x0xO0oo(applicationId, "$applicationId");
        IIX0o.x0xO0oo(context, "$context");
        IIX0o.x0xO0oo(gateKeepersKey, "$gateKeepersKey");
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = INSTANCE;
        JSONObject appGateKeepersQueryResponse = fetchedAppGateKeepersManager.getAppGateKeepersQueryResponse(applicationId);
        if (appGateKeepersQueryResponse.length() != 0) {
            parseAppGateKeepersFromJSON$facebook_core_release(applicationId, appGateKeepersQueryResponse);
            context.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(gateKeepersKey, appGateKeepersQueryResponse.toString()).apply();
            timestamp = Long.valueOf(System.currentTimeMillis());
        }
        fetchedAppGateKeepersManager.pollCallbacks();
        isLoading.set(false);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    @VisibleForTesting(otherwise = 2)
    public static final synchronized JSONObject parseAppGateKeepersFromJSON$facebook_core_release(@OXOo.OOXIXo String applicationId, @OXOo.oOoXoXO JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONArray optJSONArray;
        synchronized (FetchedAppGateKeepersManager.class) {
            try {
                IIX0o.x0xO0oo(applicationId, "applicationId");
                jSONObject2 = fetchedAppGateKeepers.get(applicationId);
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                int i = 0;
                JSONObject jSONObject3 = null;
                if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
                    jSONObject3 = optJSONArray.optJSONObject(0);
                }
                if (jSONObject3 == null) {
                    jSONObject3 = new JSONObject();
                }
                JSONArray optJSONArray2 = jSONObject3.optJSONArray(APPLICATION_GATEKEEPER_FIELD);
                if (optJSONArray2 == null) {
                    optJSONArray2 = new JSONArray();
                }
                int length = optJSONArray2.length();
                if (length > 0) {
                    while (true) {
                        int i2 = i + 1;
                        try {
                            JSONObject jSONObject4 = optJSONArray2.getJSONObject(i);
                            jSONObject2.put(jSONObject4.getString("key"), jSONObject4.getBoolean("value"));
                        } catch (JSONException e) {
                            Utility utility = Utility.INSTANCE;
                            Utility.logd(Utility.LOG_TAG, e);
                        }
                        if (i2 >= length) {
                            break;
                        }
                        i = i2;
                    }
                }
                fetchedAppGateKeepers.put(applicationId, jSONObject2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return jSONObject2;
    }

    private final void pollCallbacks() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (true) {
            ConcurrentLinkedQueue<Callback> concurrentLinkedQueue = callbacks;
            if (!concurrentLinkedQueue.isEmpty()) {
                final Callback poll = concurrentLinkedQueue.poll();
                if (poll != null) {
                    handler.post(new Runnable() { // from class: com.facebook.internal.X0o0xo
                        @Override // java.lang.Runnable
                        public final void run() {
                            FetchedAppGateKeepersManager.Callback.this.onCompleted();
                        }
                    });
                }
            } else {
                return;
            }
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final JSONObject queryAppGateKeepers(@OXOo.OOXIXo String applicationId, boolean z) {
        IIX0o.x0xO0oo(applicationId, "applicationId");
        if (!z) {
            Map<String, JSONObject> map = fetchedAppGateKeepers;
            if (map.containsKey(applicationId)) {
                JSONObject jSONObject = map.get(applicationId);
                if (jSONObject == null) {
                    return new JSONObject();
                }
                return jSONObject;
            }
        }
        JSONObject appGateKeepersQueryResponse = INSTANCE.getAppGateKeepersQueryResponse(applicationId);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
        IIX0o.oO(format, "java.lang.String.format(format, *args)");
        applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(format, appGateKeepersQueryResponse.toString()).apply();
        return parseAppGateKeepersFromJSON$facebook_core_release(applicationId, appGateKeepersQueryResponse);
    }

    @XO0OX.x0XOIxOo
    public static final void resetRuntimeGateKeeperCache() {
        GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
        if (gateKeeperRuntimeCache2 != null) {
            GateKeeperRuntimeCache.resetCache$default(gateKeeperRuntimeCache2, null, 1, null);
        }
    }

    @XO0OX.x0XOIxOo
    public static final void setRuntimeGateKeeper(@OXOo.OOXIXo String applicationId, @OXOo.OOXIXo GateKeeper gateKeeper) {
        GateKeeper gateKeeper2;
        IIX0o.x0xO0oo(applicationId, "applicationId");
        IIX0o.x0xO0oo(gateKeeper, "gateKeeper");
        GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
        if (gateKeeperRuntimeCache2 == null) {
            gateKeeper2 = null;
        } else {
            gateKeeper2 = gateKeeperRuntimeCache2.getGateKeeper(applicationId, gateKeeper.getName());
        }
        if (gateKeeper2 != null) {
            GateKeeperRuntimeCache gateKeeperRuntimeCache3 = gateKeeperRuntimeCache;
            if (gateKeeperRuntimeCache3 != null) {
                gateKeeperRuntimeCache3.setGateKeeper(applicationId, gateKeeper);
                return;
            }
            return;
        }
        Log.w(TAG, "Missing gatekeeper runtime cache");
    }

    public static /* synthetic */ void setRuntimeGateKeeper$default(String str, GateKeeper gateKeeper, int i, Object obj) {
        if ((i & 1) != 0) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            str = FacebookSdk.getApplicationId();
        }
        setRuntimeGateKeeper(str, gateKeeper);
    }

    @OXOo.OOXIXo
    public final Map<String, Boolean> getGateKeepersForApplication(@OXOo.oOoXoXO String str) {
        List<GateKeeper> dumpGateKeepers;
        loadAppGateKeepersAsync();
        if (str != null) {
            Map<String, JSONObject> map = fetchedAppGateKeepers;
            if (map.containsKey(str)) {
                GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
                if (gateKeeperRuntimeCache2 == null) {
                    dumpGateKeepers = null;
                } else {
                    dumpGateKeepers = gateKeeperRuntimeCache2.dumpGateKeepers(str);
                }
                if (dumpGateKeepers != null) {
                    HashMap hashMap = new HashMap();
                    for (GateKeeper gateKeeper : dumpGateKeepers) {
                        hashMap.put(gateKeeper.getName(), Boolean.valueOf(gateKeeper.getValue()));
                    }
                    return hashMap;
                }
                HashMap hashMap2 = new HashMap();
                JSONObject jSONObject = map.get(str);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    IIX0o.oO(key, "key");
                    hashMap2.put(key, Boolean.valueOf(jSONObject.optBoolean(key)));
                }
                GateKeeperRuntimeCache gateKeeperRuntimeCache3 = gateKeeperRuntimeCache;
                if (gateKeeperRuntimeCache3 == null) {
                    gateKeeperRuntimeCache3 = new GateKeeperRuntimeCache();
                }
                ArrayList arrayList = new ArrayList(hashMap2.size());
                for (Map.Entry entry : hashMap2.entrySet()) {
                    arrayList.add(new GateKeeper((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue()));
                }
                gateKeeperRuntimeCache3.setGateKeepers(str, arrayList);
                gateKeeperRuntimeCache = gateKeeperRuntimeCache3;
                return hashMap2;
            }
        }
        return new HashMap();
    }

    public final void loadAppGateKeepersAsync() {
        loadAppGateKeepersAsync(null);
    }

    @XO0OX.x0XOIxOo
    public static final synchronized void loadAppGateKeepersAsync(@OXOo.oOoXoXO Callback callback) {
        synchronized (FetchedAppGateKeepersManager.class) {
            if (callback != null) {
                try {
                    callbacks.add(callback);
                } catch (Throwable th) {
                    throw th;
                }
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            final String applicationId = FacebookSdk.getApplicationId();
            FetchedAppGateKeepersManager fetchedAppGateKeepersManager = INSTANCE;
            if (fetchedAppGateKeepersManager.isTimestampValid(timestamp) && fetchedAppGateKeepers.containsKey(applicationId)) {
                fetchedAppGateKeepersManager.pollCallbacks();
                return;
            }
            final Context applicationContext = FacebookSdk.getApplicationContext();
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            final String format = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
            IIX0o.oO(format, "java.lang.String.format(format, *args)");
            if (applicationContext == null) {
                return;
            }
            JSONObject jSONObject = null;
            String string = applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).getString(format, null);
            Utility utility = Utility.INSTANCE;
            if (!Utility.isNullOrEmpty(string)) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e) {
                    Utility utility2 = Utility.INSTANCE;
                    Utility.logd(Utility.LOG_TAG, e);
                }
                if (jSONObject != null) {
                    parseAppGateKeepersFromJSON$facebook_core_release(applicationId, jSONObject);
                }
            }
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            Executor executor = FacebookSdk.getExecutor();
            if (executor == null) {
                return;
            }
            if (isLoading.compareAndSet(false, true)) {
                executor.execute(new Runnable() { // from class: com.facebook.internal.XO
                    @Override // java.lang.Runnable
                    public final void run() {
                        FetchedAppGateKeepersManager.m199loadAppGateKeepersAsync$lambda0(applicationId, applicationContext, format);
                    }
                });
            }
        }
    }
}
