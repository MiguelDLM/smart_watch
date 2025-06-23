package com.facebook.appevents.restrictivedatafilter;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.util.Log;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class RestrictiveDataManager {

    @OOXIXo
    private static final String PROCESS_EVENT_NAME = "process_event_name";

    @OOXIXo
    private static final String REPLACEMENT_STRING = "_removed_";

    @OOXIXo
    private static final String RESTRICTIVE_PARAM = "restrictive_param";

    @OOXIXo
    private static final String RESTRICTIVE_PARAM_KEY = "_restrictedParams";
    private static boolean enabled;

    @OOXIXo
    public static final RestrictiveDataManager INSTANCE = new RestrictiveDataManager();

    @oOoXoXO
    private static final String TAG = RestrictiveDataManager.class.getCanonicalName();

    @OOXIXo
    private static final List<RestrictiveParamFilter> restrictiveParamFilters = new ArrayList();

    @OOXIXo
    private static final Set<String> restrictedEvents = new CopyOnWriteArraySet();

    /* loaded from: classes8.dex */
    public static final class RestrictiveParamFilter {

        @OOXIXo
        private String eventName;

        @OOXIXo
        private Map<String, String> restrictiveParams;

        public RestrictiveParamFilter(@OOXIXo String eventName, @OOXIXo Map<String, String> restrictiveParams) {
            IIX0o.x0xO0oo(eventName, "eventName");
            IIX0o.x0xO0oo(restrictiveParams, "restrictiveParams");
            this.eventName = eventName;
            this.restrictiveParams = restrictiveParams;
        }

        @OOXIXo
        public final String getEventName() {
            return this.eventName;
        }

        @OOXIXo
        public final Map<String, String> getRestrictiveParams() {
            return this.restrictiveParams;
        }

        public final void setEventName(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.eventName = str;
        }

        public final void setRestrictiveParams(@OOXIXo Map<String, String> map) {
            IIX0o.x0xO0oo(map, "<set-?>");
            this.restrictiveParams = map;
        }
    }

    private RestrictiveDataManager() {
    }

    @x0XOIxOo
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(RestrictiveDataManager.class)) {
            return;
        }
        try {
            enabled = true;
            INSTANCE.initialize();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, RestrictiveDataManager.class);
        }
    }

    private final String getMatchedRuleType(String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            try {
                for (RestrictiveParamFilter restrictiveParamFilter : new ArrayList(restrictiveParamFilters)) {
                    if (restrictiveParamFilter != null && IIX0o.Oxx0IOOO(str, restrictiveParamFilter.getEventName())) {
                        for (String str3 : restrictiveParamFilter.getRestrictiveParams().keySet()) {
                            if (IIX0o.Oxx0IOOO(str2, str3)) {
                                return restrictiveParamFilter.getRestrictiveParams().get(str3);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                Log.w(TAG, "getMatchedRuleType failed", e);
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final void initialize() {
        String restrictiveDataSetting;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (queryAppSettings != null && (restrictiveDataSetting = queryAppSettings.getRestrictiveDataSetting()) != null && restrictiveDataSetting.length() != 0) {
                JSONObject jSONObject = new JSONObject(restrictiveDataSetting);
                restrictiveParamFilters.clear();
                restrictedEvents.clear();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(key);
                    if (jSONObject2 != null) {
                        JSONObject optJSONObject = jSONObject2.optJSONObject(RESTRICTIVE_PARAM);
                        IIX0o.oO(key, "key");
                        RestrictiveParamFilter restrictiveParamFilter = new RestrictiveParamFilter(key, new HashMap());
                        if (optJSONObject != null) {
                            Utility utility = Utility.INSTANCE;
                            restrictiveParamFilter.setRestrictiveParams(Utility.convertJSONObjectToStringMap(optJSONObject));
                            restrictiveParamFilters.add(restrictiveParamFilter);
                        }
                        if (jSONObject2.has(PROCESS_EVENT_NAME)) {
                            restrictedEvents.add(restrictiveParamFilter.getEventName());
                        }
                    }
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final boolean isRestrictedEvent(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return restrictedEvents.contains(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final String processEvent(@OOXIXo String eventName) {
        if (CrashShieldHandler.isObjectCrashing(RestrictiveDataManager.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(eventName, "eventName");
            if (enabled) {
                if (INSTANCE.isRestrictedEvent(eventName)) {
                    return REPLACEMENT_STRING;
                }
                return eventName;
            }
            return eventName;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, RestrictiveDataManager.class);
            return null;
        }
    }

    @x0XOIxOo
    public static final void processParameters(@OOXIXo Map<String, String> parameters, @OOXIXo String eventName) {
        if (CrashShieldHandler.isObjectCrashing(RestrictiveDataManager.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(parameters, "parameters");
            IIX0o.x0xO0oo(eventName, "eventName");
            if (!enabled) {
                return;
            }
            HashMap hashMap = new HashMap();
            for (String str : new ArrayList(parameters.keySet())) {
                String matchedRuleType = INSTANCE.getMatchedRuleType(eventName, str);
                if (matchedRuleType != null) {
                    hashMap.put(str, matchedRuleType);
                    parameters.remove(str);
                }
            }
            if (!hashMap.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        jSONObject.put((String) entry.getKey(), (String) entry.getValue());
                    }
                    parameters.put(RESTRICTIVE_PARAM_KEY, jSONObject.toString());
                } catch (JSONException unused) {
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, RestrictiveDataManager.class);
        }
    }
}
