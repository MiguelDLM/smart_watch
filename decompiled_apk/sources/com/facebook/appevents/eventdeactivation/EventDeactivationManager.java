package com.facebook.appevents.eventdeactivation;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONArray;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class EventDeactivationManager {
    private static boolean enabled;

    @OOXIXo
    public static final EventDeactivationManager INSTANCE = new EventDeactivationManager();

    @OOXIXo
    private static final List<DeprecatedParamFilter> deprecatedParamFilters = new ArrayList();

    @OOXIXo
    private static final Set<String> deprecatedEvents = new HashSet();

    /* loaded from: classes8.dex */
    public static final class DeprecatedParamFilter {

        @OOXIXo
        private List<String> deprecateParams;

        @OOXIXo
        private String eventName;

        public DeprecatedParamFilter(@OOXIXo String eventName, @OOXIXo List<String> deprecateParams) {
            IIX0o.x0xO0oo(eventName, "eventName");
            IIX0o.x0xO0oo(deprecateParams, "deprecateParams");
            this.eventName = eventName;
            this.deprecateParams = deprecateParams;
        }

        @OOXIXo
        public final List<String> getDeprecateParams() {
            return this.deprecateParams;
        }

        @OOXIXo
        public final String getEventName() {
            return this.eventName;
        }

        public final void setDeprecateParams(@OOXIXo List<String> list) {
            IIX0o.x0xO0oo(list, "<set-?>");
            this.deprecateParams = list;
        }

        public final void setEventName(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.eventName = str;
        }
    }

    private EventDeactivationManager() {
    }

    @x0XOIxOo
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(EventDeactivationManager.class)) {
            return;
        }
        try {
            enabled = true;
            INSTANCE.initialize();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, EventDeactivationManager.class);
        }
    }

    private final synchronized void initialize() {
        FetchedAppSettings queryAppSettings;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
        } catch (Exception unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return;
        }
        if (queryAppSettings == null) {
            return;
        }
        String restrictiveDataSetting = queryAppSettings.getRestrictiveDataSetting();
        if (restrictiveDataSetting != null && restrictiveDataSetting.length() > 0) {
            JSONObject jSONObject = new JSONObject(restrictiveDataSetting);
            deprecatedParamFilters.clear();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(key);
                if (jSONObject2 != null) {
                    if (jSONObject2.optBoolean("is_deprecated_event")) {
                        Set<String> set = deprecatedEvents;
                        IIX0o.oO(key, "key");
                        set.add(key);
                    } else {
                        JSONArray optJSONArray = jSONObject2.optJSONArray("deprecated_param");
                        IIX0o.oO(key, "key");
                        DeprecatedParamFilter deprecatedParamFilter = new DeprecatedParamFilter(key, new ArrayList());
                        if (optJSONArray != null) {
                            Utility utility = Utility.INSTANCE;
                            deprecatedParamFilter.setDeprecateParams(Utility.convertJSONArrayToList(optJSONArray));
                        }
                        deprecatedParamFilters.add(deprecatedParamFilter);
                    }
                }
            }
        }
    }

    @x0XOIxOo
    public static final void processDeprecatedParameters(@OOXIXo Map<String, String> parameters, @OOXIXo String eventName) {
        if (CrashShieldHandler.isObjectCrashing(EventDeactivationManager.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(parameters, "parameters");
            IIX0o.x0xO0oo(eventName, "eventName");
            if (!enabled) {
                return;
            }
            ArrayList<String> arrayList = new ArrayList(parameters.keySet());
            for (DeprecatedParamFilter deprecatedParamFilter : new ArrayList(deprecatedParamFilters)) {
                if (IIX0o.Oxx0IOOO(deprecatedParamFilter.getEventName(), eventName)) {
                    for (String str : arrayList) {
                        if (deprecatedParamFilter.getDeprecateParams().contains(str)) {
                            parameters.remove(str);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, EventDeactivationManager.class);
        }
    }

    @x0XOIxOo
    public static final void processEvents(@OOXIXo List<AppEvent> events) {
        if (CrashShieldHandler.isObjectCrashing(EventDeactivationManager.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(events, "events");
            if (!enabled) {
                return;
            }
            Iterator<AppEvent> it = events.iterator();
            while (it.hasNext()) {
                if (deprecatedEvents.contains(it.next().getName())) {
                    it.remove();
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, EventDeactivationManager.class);
        }
    }
}
