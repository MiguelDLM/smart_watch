package com.facebook.appevents.suggestedevents;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.app.Activity;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONArray;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class SuggestedEventsManager {

    @OOXIXo
    private static final String ELIGIBLE_EVENTS_KEY = "eligible_for_prediction_events";

    @OOXIXo
    private static final String PRODUCTION_EVENTS_KEY = "production_events";

    @OOXIXo
    public static final SuggestedEventsManager INSTANCE = new SuggestedEventsManager();

    @OOXIXo
    private static final AtomicBoolean enabled = new AtomicBoolean(false);

    @OOXIXo
    private static final Set<String> productionEvents = new LinkedHashSet();

    @OOXIXo
    private static final Set<String> eligibleEvents = new LinkedHashSet();

    private SuggestedEventsManager() {
    }

    @x0XOIxOo
    public static final synchronized void enable() {
        synchronized (SuggestedEventsManager.class) {
            if (CrashShieldHandler.isObjectCrashing(SuggestedEventsManager.class)) {
                return;
            }
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: oxXx0IX.oIX0oI
                    @Override // java.lang.Runnable
                    public final void run() {
                        SuggestedEventsManager.m174enable$lambda0();
                    }
                });
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, SuggestedEventsManager.class);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: enable$lambda-0, reason: not valid java name */
    public static final void m174enable$lambda0() {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventsManager.class)) {
            return;
        }
        try {
            AtomicBoolean atomicBoolean = enabled;
            if (atomicBoolean.get()) {
                return;
            }
            atomicBoolean.set(true);
            INSTANCE.initialize();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SuggestedEventsManager.class);
        }
    }

    private final void initialize() {
        String suggestedEventsSetting;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (queryAppSettings == null || (suggestedEventsSetting = queryAppSettings.getSuggestedEventsSetting()) == null) {
                return;
            }
            populateEventsFromRawJsonString$facebook_core_release(suggestedEventsSetting);
            if (productionEvents.isEmpty() && eligibleEvents.isEmpty()) {
                return;
            }
            ModelManager modelManager = ModelManager.INSTANCE;
            File ruleFile = ModelManager.getRuleFile(ModelManager.Task.MTML_APP_EVENT_PREDICTION);
            if (ruleFile == null) {
                return;
            }
            FeatureExtractor featureExtractor = FeatureExtractor.INSTANCE;
            FeatureExtractor.initialize(ruleFile);
            ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
            Activity currentActivity = ActivityLifecycleTracker.getCurrentActivity();
            if (currentActivity != null) {
                trackActivity(currentActivity);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @x0XOIxOo
    public static final boolean isEligibleEvents$facebook_core_release(@OOXIXo String event) {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventsManager.class)) {
            return false;
        }
        try {
            IIX0o.x0xO0oo(event, "event");
            return eligibleEvents.contains(event);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SuggestedEventsManager.class);
            return false;
        }
    }

    @x0XOIxOo
    public static final boolean isEnabled() {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventsManager.class)) {
            return false;
        }
        try {
            return enabled.get();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SuggestedEventsManager.class);
            return false;
        }
    }

    @x0XOIxOo
    public static final boolean isProductionEvents$facebook_core_release(@OOXIXo String event) {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventsManager.class)) {
            return false;
        }
        try {
            IIX0o.x0xO0oo(event, "event");
            return productionEvents.contains(event);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SuggestedEventsManager.class);
            return false;
        }
    }

    @x0XOIxOo
    public static final void trackActivity(@OOXIXo Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventsManager.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(activity, "activity");
            try {
                if (enabled.get()) {
                    FeatureExtractor featureExtractor = FeatureExtractor.INSTANCE;
                    if (FeatureExtractor.isInitialized()) {
                        if (productionEvents.isEmpty()) {
                            if (!eligibleEvents.isEmpty()) {
                            }
                        }
                        ViewObserver.Companion.startTrackingActivity(activity);
                        return;
                    }
                }
                ViewObserver.Companion.stopTrackingActivity(activity);
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SuggestedEventsManager.class);
        }
    }

    @VisibleForTesting(otherwise = 2)
    public final void populateEventsFromRawJsonString$facebook_core_release(@oOoXoXO String str) {
        JSONArray jSONArray;
        int length;
        JSONArray jSONArray2;
        int length2;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = 0;
            if (jSONObject.has(PRODUCTION_EVENTS_KEY) && (length2 = (jSONArray2 = jSONObject.getJSONArray(PRODUCTION_EVENTS_KEY)).length()) > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    Set<String> set = productionEvents;
                    String string = jSONArray2.getString(i2);
                    IIX0o.oO(string, "jsonArray.getString(i)");
                    set.add(string);
                    if (i3 >= length2) {
                        break;
                    } else {
                        i2 = i3;
                    }
                }
            }
            if (!jSONObject.has(ELIGIBLE_EVENTS_KEY) || (length = (jSONArray = jSONObject.getJSONArray(ELIGIBLE_EVENTS_KEY)).length()) <= 0) {
                return;
            }
            while (true) {
                int i4 = i + 1;
                Set<String> set2 = eligibleEvents;
                String string2 = jSONArray.getString(i);
                IIX0o.oO(string2, "jsonArray.getString(i)");
                set2.add(string2);
                if (i4 < length) {
                    i = i4;
                } else {
                    return;
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
